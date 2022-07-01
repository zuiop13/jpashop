package jpashop.zuiop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@Slf4j
@RequestMapping("/zuiop")
public class HomeController {
    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "zuiop/home";
    }
}