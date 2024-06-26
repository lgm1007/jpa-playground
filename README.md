# JPA Playground 🎈
* JPA 로직 동작할 때 실제 Query가 어떻게 진행되는지 확인한다.
* [Service.java](./src/main/java/com/example/jpaplayground/experiment/service/ExperimentService.java)

### 확인하는 Case
1. 같은 클래스 상에서 상위 메서드, 하위 메서드 둘 다 `@Transactional`이 선언되어 있을 때, 하위 메서드에서 더티 체킹 업데이트 확인
2. 같은 클래스 상에서 상위 메서드에만 `@Transactional`이 선언되어 있을 때, 하위 메서드에서 더티 체킹 업데이트 확인
3. 같은 클래스 상에서 하위 메서드에만 `@Transactional`이 선언되어 있을 때, 하위 메서드에서 더티 체킹 업데이트 확인
4. DB 상 같은 행 데이터를 `findById()`, `findBy필드명()`, `JPQL로 선언한 findBy필드명()` 함수 순으로 조회하고, `findBy필드명()`, `findById()` 순으로 조회할 때 select 캐싱 확인
5. 4번과 동일하게 조회하되, 각 조회한 엔티티마다 `set필드명(필드값)`하여 업데이트 동작 확인
