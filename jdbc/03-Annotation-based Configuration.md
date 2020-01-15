# 4.3 Annotation-based Configuration

`@EnableJdbcRepositories`를 이용하여 활성화 시킬수 있습니다.

Example 54. Spring Data JDBC repositories using Java configuration
```java
@Configuration
@EnableJdbcRepositories
class ApplicationConfig {

  @Bean
  public DataSource dataSource() {

    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
    return builder.setType(EmbeddedDatabaseType.HSQL).build();
  }

}
```