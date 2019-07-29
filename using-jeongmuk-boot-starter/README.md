
백기선님 스프링 부트 강의 후 코드 작성

 - 빈 덮어쓰기 방지하기
    - @ConditionalOnMissingBean
 - 빈 재정의 수고 덜기
    - @ConfigurationProperties("holoman")
    - @EnableConfigurationProperties(HolomanProperties)
    - 프로퍼티 키값 자동 완성

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-configuration-processor</artifactId>
   <optional>true</optional>
</dependency>
```