package s2u2msdk.spring.service.account.controller.account.dto;

import s2u2msdk.spring.service.account.enums.GenderEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * class UserNameAccountRegDTO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserNameAccountRegDTO {
    private String userName;
    private String password;

    private GenderEnum gender;
    private Date birthday;
}
