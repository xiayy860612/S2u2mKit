package s2u2msdk.spring.service.account.controller.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s2u2msdk.spring.core.dto.S2u2mResponseBody;
import s2u2msdk.spring.service.account.controller.account.dto.LoginInfoDTO;
import s2u2msdk.spring.service.account.controller.account.dto.UserNameAccountLoginDTO;
import s2u2msdk.spring.service.account.controller.account.dto.UserNameAccountRegDTO;
import s2u2msdk.spring.service.account.entity.UserEntity;
import s2u2msdk.spring.service.account.service.account.UserNameAccountService;

/**
 * class UserNameAccountController
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Profile(value = {"dev", "local", "test"})
@RestController
@RequestMapping(value = "/account/username")
public class UserNameAccountController {

    @Autowired
    private UserNameAccountService accountService;

    @S2u2mResponseBody
    @PostMapping(value = "/reg")
    public LoginInfoDTO reg(@RequestBody UserNameAccountRegDTO regDTO) {
        UserEntity entity = accountService.reg(regDTO);
        // get token
        String token = entity.getId();
        return new LoginInfoDTO().setToken(token);
    }

    @S2u2mResponseBody
    @PostMapping(value = "/login")
    public LoginInfoDTO login(@RequestBody UserNameAccountLoginDTO loginDTO) {
        UserEntity entity = accountService.login(loginDTO);
        return new LoginInfoDTO().setToken(entity.getId());
    }
}
