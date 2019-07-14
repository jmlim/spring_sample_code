### 백기선님 인프런 강의중...

## 스프링 부트 운영
스프링 부트는 애플리케이션 운영 환경에서 유용한 기능을 제공한다.<br/>
스프링부트가 제공하는 엔드포인트와 매트릭스 그리고 그 데이터를 활용하는 모니터링 기능에 대해 학습한다.

## 의존성 추가.
- spring-boot-starter-actuator

## 애플리케이션의 각종 정보를 확인할 수 있는 Endpoints
 - 다양한 Endpoints제공
    - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints
 - JMX 또는 HTTP를 통해 접근 가능 함.
 - shutdown을 제외한 모든 Endpoint는 기본적으로 활성화 상태
 - 활성화 옵션 조정
   - management.endpoints.enabled-by-default=false
   - management.endpoint.info.enabled=true

## JConsole 사용하기.
 - https://docs.oracle.com/javase/tutorial/jmx/mbeans/
 - https://docs.oracle.com/javase/7/docs/technotes/guides/management/jconsole.html

## VisualVM 사용하기.
 - https://visualvm.github.io/download.html
## HTTP 사용하기
 - /actuator
 - health와 info를 제외한 대부분의 Endpoint가 기본적으로 비공개 상태
 - 공개 옵션 조정
    - management.endpoints.web.exposure.include=*
    - management.endpoints.web.exposure.exclude=env.beans
    
  
## 스프링 진영 x, 제 3자가 제공하는 오픈소스 프로젝트
> 스프링부트 엑츄에이터 정보를 UI 에서 확인할 수 있다.

프로젝트를 한개 더 만듬. (springbootactuatormonitor 라고 만들었음)

 https://github.com/codecentric/spring-boot-admin 
### 스프링 부트 Actuator UI 제공 어드민 서버 설정

```groovy
 implementation 'de.codecentric:spring-boot-admin-starter-server:2.0.1'
```
> 강의에서는 스프링부트 2.0 버전을 사용하였고 만약 스프링부트 2.1로 프로젝트 셋팅후에 위와 같이 spring boot admin 2.0 을 사용하면 에러가 발생한다.
  
> 관련 이슈:   https://github.com/codecentric/spring-boot-admin/issues/768

### 스프링부트 2.1 이상을 사용하였을 경우 아래와 같이 2.1.0 버전을 지정하여 받는다.
```groovy
 implementation 'de.codecentric:spring-boot-admin-starter-server:2.1.0'
``` 
### @EnableAdminServer 설정
 - 모니터할 서버 프로젝트의 Application 에 @EnableAdminServer 어노테이션을 걸어준다.
```java
package io.jmlim.example.sprinbootactuatormonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

```
### 클라이언트 설정 (위에서 springbootactuator 설정을 한 프로젝트)
```groovy
 implementation 'de.codecentric:spring-boot-admin-starter-client:2.0.1'
``` 
#### 스프링부트 2.1 이상을 사용하였을 경우 아래와 같이 2.1.0 버전을 지정하여 받는다.
```groovy
  implementation 'de.codecentric:spring-boot-admin-starter-client:2.1.0'
```

```properties
 spring.boot.admin.client.url=http://localhost:8080
 management.endpoints.web.exposure.include=*
```
 
### 양쪽 서버 전부 실행 후 acturator를 설정한 서버의 정보가 admin 서버에서 UI로 잘 나오는지 확인한다.
<img src="/spring-boot-acturator-admin.png" />

#### 디테일한 정보 확인
<img src="/spring-boot-acturator-admin-detail.png" />
 
 
 > 당연한 얘기지만 보안적으로 민감한 정보들이 모니터링 되므로 어드민 서버, 
 클라이언트(약간 agent같은 느낌이다..) 에도 스프링 시큐리티나 기타 다른것으로 보안처리를 해야한다는 것 잊으면 안된다.
 