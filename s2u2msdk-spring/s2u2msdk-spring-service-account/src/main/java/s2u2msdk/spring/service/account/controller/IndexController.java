package s2u2msdk.spring.service.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class IndexController
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "hello world";
    }
}
