package s2u2msdk.spring.service.account.dao;

import s2u2msdk.spring.service.account.entity.account.UserNameAccountEntity;

/**
 * interface UserNameAccountDAO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public interface UserNameAccountDAO {
    UserNameAccountEntity getByUserName(String userName);

    UserNameAccountEntity getByUserId(String userId);

    int insert(UserNameAccountEntity entity);
}
