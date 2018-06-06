package s2u2msdk.spring.service.account.dao;

import s2u2msdk.spring.service.account.entity.UserEntity;

/**
 * interface UserDAO
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public interface UserDAO {
    int insert(UserEntity entity);

    UserEntity getById(String id);
}
