# 5.1. Introduction

Spring Data JPA를 ~~namespace(xml)방식~~과 annotation-based(java) 방식으로 설정하는 방법을 알아봅니다.

## Annotation-based Configuration
```java
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class ApplicationConfig {

  @Bean
  public DataSource dataSource() {

    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.HSQL).build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com.acme.domain");
    factory.setDataSource(dataSource());
    return factory;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

    JpaTransactionManager txManager = new JpaTransactionManager();
    txManager.setEntityManagerFactory(entityManagerFactory);
    return txManager;
  }
}
```
- `@EnableJpaRepositories`를 사용해서 JPA를 사용할 수 있습니다.
    - basepackage를 지정해주지 않으면 Configuration 클래스가 있는 위치를 base로 잡습니다.
- `entityManagerFactory`를 등록할때 `EntityManagerFactory`를 직접 생성하면 예외 번역(exception translation)과정에서 제외됨으로 `LocalContainerEntityManagerFactoryBean`로 생성해야 합니다.

## Bootstrap Mode
`EntityManagerFactory`의 생성에는 시간이 오래걸리기 때문에 Spring은 별도의 background thread를 통해서 생성 과정을 지원합니다. 
이 과정을 보다 효율적으로 하기 위해서는 JPA repository를 최대한 늦게 초기화 시키는것이 좋습니다.
> JPA repository를 늦게 초기화 하는거와 `EntityManagerFactory` 생성이 오래걸리는게 무슨 관계인지는 잘 모르겠네요

JPA의 repository들은 기본적으로 ***default spring bean(singleton && eager-init)*** 이지만 JPA2.1에 추가된 `BootstrapMode`를 사용하여 bean 설정을 변경할 수 있습니다.
- Default (default)
    - `@Lazy` 어노테이션이 붙지 않은 repository들을 default 설정으로 생성합니다.
    - Lazification은 다른 bean의 초기화 과정에서 명시한 bean이 필요하지 않은 경우에만 효과가 있습니다.
        > @Lazy를 붙인 경우라도 다른 bean 생성시에 필요하다면 application context 생성 시점에 함께 생긴다는 의미인 것 같습니다.
- LAZY
    - 모든 repository를 lazy로 설정하고 다른 bean의 초기화 과정에 proxy를 주입해서 application context 생성에 따른 eager loading을 막습니다.
    - Repository가 최초로 호출될때 인스턴스가 생성됩니다.
    - 모든 repository 인스턴스가 필요하지 않을 수 도 있는 로컬 환경또는 테스팅에 추천됩니다.
 - DEFERRED
    - Lazy와 기본적으로 동일하지만 `ContextRefreshedEvent`가 수행될 때 인스턴스가 생성됨으로 어플리케이션이 시작되기 전에 repository의 검증이 가능합니다.
    - `EntityManagerFactory`의 초기화가 다른 모든 컴포넌트의 초기화보다 오래걸리는 경우에만 대기하며, 어플리케이션이 실행되기 전에 초기화가 완료되기 때문에 일반적인 경우 권장 됩니다.


