# 4.1. Why Spring Data JDBC?

Java Persistence API인 spring JPA가 있는데 Spring Data JDBC는 왜 필요한 걸까?

spring JPA는 엔티티의 변경 사항을 추적하며, 레이지로딩을 수행합니다.
이를 통하여 객체 구성을 동일하게 데이터베이스에 설계하여 매핑 할 수 있습니다.
하지만 JPA는 간단한 개념의 작업을 어렵게 만드는게 있습니다. (many to many)

spring JPA는 
1. JPAs complexity
2. Lazy Loading(Exception)
3. Map almost anything to anything

Spring Data JDBC에서는 아래와 같은 설계 결정을 수용함으로써 개념적으로 단순합니다.
1. 엔티티를 로드할시에 SQL 문이 실행됩니다. 이 작업은 한번에 완전히 로드가 끝나며 지연로드 또는 캐싱이 수행되지 않습니다.
2. 엔터티 저장하면 저장됩니다. 그렇지 않으면 그렇지 않습니다. 더티 트래킹 및 세션이 없습니다.
3. 엔터티를 테이블에 매핑하는 간단한 모델만 사용하며 복잡한 경우에는 로직으로 해결합니다.

DAO(Data Access Object)
DTO(Data Transfer Object)