백기선님 스프링 부트 강의 후 코드 작성

> https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-developing-auto-configuration
 - Xxx-Spring-Boot-Autoconfigure 모듈: 자동 설정
 - Xxx-Spring-Boot-Starter 모듈: 필요한 의존성 정의
 - 그냥 하나로 만들고 싶을 때는?
    - Xxx-Spring-Boot-Starter

## 구현 방법
### 1. 의존성 추가

```xml
<dependencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure-processor</artifactId>
      <optional>true</optional>
  </dependency>
</dependencies>

<dependencyManagement>
  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-dependencies</artifactId>
          <version>2.0.3.RELEASE</version>
          <type>pom</type>
          <scope>import</scope>
      </dependency>
  </dependencies>
</dependencyManagement>
```

### 2. @Configuration 파일 작성 3. src/main/resource/META-INF에 spring.factories 파일 만들기 4. spring.factories 안에 자동 설정 파일 추가

```properties
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
FQCN,\
FQCN
```

### 5. mvn install