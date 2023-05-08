package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j // 로그를 찍을 수 있다.
@RestController // 응답 값을 view를 찾는 게 아니라 바로 문자 그대로 반환한다.
public class RequestHeaderController {

    /**
     * 애너테이션 기반의 Controller는 정말 다양한 파라미터를 받을 수 있다.
     * 인터페이스로 정형화돼있는 것이 아니므로.
     * 스프링이 지원하는 것은 다 된다.
     *
     * @param request
     * @param response
     * @param httpMethod 스프링에서 정해놓은 것이다.
     * @param locale     언어 정보
     * @param headerMap  header를 받으므로 key와 value 모두 String
     * @param host       host라는 필수 헤더 하나만 받을 때
     * @param cookie     쿠키를 편하게 받을 수 있는데, required를 false로 함으로써 없어도 되게 설정하였다.
     * @return
     */
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}
