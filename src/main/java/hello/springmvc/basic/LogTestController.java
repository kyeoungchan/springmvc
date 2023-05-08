package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // 현재 위치의 클래스를 파라미터로 설정. @Slf4j 애너테이션이 있으면 생략 가능
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class); // 이렇게 지정해도 같다.

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 로그를 찍을 때 레벨을 찍어준다.
        log.trace("trace log={}", name);
        log.debug("debug log={}", name); // 현재 로그는 디버그할 때 보는 거다. 개발 서버 같은 데에서 보는 정보다.
        log.info("  info log ={}", name); // 현재 로그는 중요한 비즈니스 정보거나 운영 시스템에서 봐야할 정보다.
        log.warn("  warn log={}", name); // 이거는 위험한 거다.
        log.error("error log={}", name); // 에러다. 빨리 확인해야한다.

//        로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 안 된다. 혼난다.
//        log.debug("String concat log=" + name);

        return "ok";
    }
}
