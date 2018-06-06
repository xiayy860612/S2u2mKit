package s2u2msdk.spring.service.account.controller.account.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * class UserNameAccountRegDTO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserNameAccountLoginDTO {
    private String userName;
    private String password;
}
