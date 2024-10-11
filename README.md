# SPRING PLUS
- 프로젝트에서 배운 점
    - 

- JPQL 날씨와 수정일 기준으로 검색하는 기능
  -
  - 수정일 기준으로 검색할 때 @Requestparam 으로 전달받는 데이터는 LocalDate 이지만
  timestamp 를 상속받는 todo 엔티티의 modifiedAt 은 LocalDateTime 이므로 LocalDateTime으로 
  형 변환하여 Repository에 전달해 주어야 한다. 
  -      LocalDateTime startDate = dates.get(0).atStartOfDay();


- QueryDSL 적용하기
  - 
  - build.gradle에 추가
    - 
    - //querydsl
      implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
      annotationProcessor "com.querydsl:querydsl-apt:5.0.0:jakarta"
      annotationProcessor "jakarta.annotation:jakarta.annotation-api"
      annotationProcessor "jakarta.persistence:jakarta.persistence-api"
    - geadle -> build -> Q클래스 만들어 졌는지 확인
  - 쿼리 dsl Repository(인터페이스) 구현체(RepositoryImpl) 만들기
    - 
  - 원래 Repository가 dsl Repository 를 상속 받도록 해줌
    - 

- Spring  Security 적용하기
  - 
  - build.gradle에 추가
    - 
    - // Spring Security
      implementation 'org.springframework.boot:spring-boot-starter-security'
      implementation 'org.springframework.security:spring-security-test'
  - JwtSecurityFilter 만들기
    - 
  - 등록하기(SecurityConfig)
    - 
  - JwtAuthenticationToken 만들기
    - 
  - UserRole 형식 바꾸기
    - 
  - @Auth 대신 @AuthenticationPrincipal 으로 바꾸기
    - 