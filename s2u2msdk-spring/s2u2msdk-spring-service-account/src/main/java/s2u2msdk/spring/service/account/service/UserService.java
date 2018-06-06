package s2u2msdk.spring.service.account.service;

import s2u2msdk.spring.service.account.dao.UserDAO;
import s2u2msdk.spring.service.account.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s2u2msdk.spring.core.uid.SnowFlakeUidGenerator;

/**
 * class UserService
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    SnowFlakeUidGenerator uidGenerator;

    @Transactional
    public UserEntity create(UserEntity entity) {
        String id = uidGenerator.nextIdByString();
        entity.setId(id);

        userDAO.insert(entity);
        return entity;
    }

    @Transactional(readOnly = true)
    public UserEntity get(String id) {
        return userDAO.getById(id);
    }
}
