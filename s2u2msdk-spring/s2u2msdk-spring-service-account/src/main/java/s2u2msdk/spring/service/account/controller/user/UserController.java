package s2u2msdk.spring.service.account.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import s2u2msdk.spring.service.account.controller.user.dto.UserInfoDTO;
import s2u2msdk.spring.service.account.entity.UserEntity;
import s2u2msdk.spring.service.account.service.UserService;

/**
 * class UserController
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public UserInfoDTO getUserInfo(@RequestHeader("token") String token) {
        String id = token;
        UserEntity userEntity = userService.get(id);
        return new UserInfoDTO()
                .setNickName(userEntity.getNickName())
                .setGender(userEntity.getGender())
                .setBirthday(userEntity.getBirthday());
    }
}
