package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        /* @Controller 애너테이션 아래에 String 타입으로 반환하면 그 반환값은 view의 이름으로 렌더링된다.
         * 만약 이 메서드 위에 @ResponseBody 애너테이션이 있다면 뷰로 렌더링이 되지 않는다.*/
        model.addAttribute("data", "hello!");
        return "response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        /* 경로의 이름(Controller의 경로 이름)이랑 뷰의 논리 이름이 같다면
        *  반환형을 void로 하고 model만 세팅하면 된다.
        * 그러면 Controller의 경로 이름을 논리적 뷰 이름으로 지정해서 진행한다.
        * 앞에 '/'는 자동으로 떼어준다.*/
        model.addAttribute("data", "hello!");
    }
}
