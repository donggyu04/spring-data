# 5.2. Persisting Entities

Spring Date JPA로 엔티티를 persist(save) 하는 방법을 알아봅시다.

## Saving Entities
`CrudRepository.save(…)`을 통해서 데이터 저장을 수행할 수 있습니다.
`EntityManager`를 통해서 실제 동작이 수행되며 save의 대상이 존재하지 않는다면 
`entityManager.persist(…)`가 호출되고, 그렇지 않다면 `entityManager.merge(…)`가 호출됩니다.

### Entity State-detection Strategies
JPA에서 엔티티가 새로운것인지 아닌지를 확인하는 방법을 알아봅시다. 
1. Version & id property (default)
    - Non-primitive 타입의 `Version` property가 있다면 가장 먼저 확인하며, 값이 `null`인 경우 새로운 엔티티로 파악합니다.
    - `Version` property가 없다면 identifier property를 확인하며, 값이 `null`인 경우 새로운 엔티티로 파악합니다. 
2. `Persistable` 구현
    - 엔티티가 `Persistable` 인터페이스의 구현체라면 `isNew(...)` 메서드에 상태 감지를 위임합니다.
3. `EntityInformation` 구현
    - `JpaRepositoryFactory`를 상속받고 `getEntityInformation(...)` 메서드를 override 해서 `EntityInformation`의 추상화를 커스터마이즈 할 수 있습니다.
    - 일반적인 방법은 아닙니다.

일반적으로 new instance를 나타내는 flag를 가지는 base class를 하나 두고, JPA lifecycle 콜백을 사용해서 값을 토글해주는 방식을 사용합니다.
```java
@MappedSuperclass
public abstract class AbstractEntity<ID> implements Persistable<ID> {

  @Transient
  private boolean isNew = true;     // new instance를 나타낼 flag

  @Override
  public boolean isNew() {          // Persistable를 구현한 방식
    return isNew; 
  }

  @PrePersist                       // lifecycle callback을 이용해서 flag를 토글
  @PostLoad
  void markNotNew() {
    this.isNew = false;
  }
  // More code…
}
```
