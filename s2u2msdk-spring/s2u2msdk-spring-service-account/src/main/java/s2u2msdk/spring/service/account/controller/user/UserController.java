package s2u2msdk.spring.service.account.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public UserInfoDTO getUserInfo(UserEntity userEntity) {
        return new UserInfoDTO()
                .setNickName(userEntity.getNickName())
                .setGender(userEntity.getGender())
                .setBirthday(userEntity.getBirthday());
    }
}
