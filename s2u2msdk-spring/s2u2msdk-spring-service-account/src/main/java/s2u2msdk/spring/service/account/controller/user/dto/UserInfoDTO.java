package s2u2msdk.spring.service.account.controller.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import s2u2msdk.spring.service.account.enums.GenderEnum;

import java.util.Date;

/**
 * class UserInfoDTO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserInfoDTO {
    private String nickName;
    private GenderEnum gender;
    private Date birthday;
}
