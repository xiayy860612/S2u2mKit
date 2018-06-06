package s2u2msdk.spring.service.account.entity.account;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Date;

/**
 * class UserNameAccountEntity
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserNameAccountEntity {
    private String userName;
    private String password;
    private String userId;
    private Date createTime = Date.from(Instant.now());
}
