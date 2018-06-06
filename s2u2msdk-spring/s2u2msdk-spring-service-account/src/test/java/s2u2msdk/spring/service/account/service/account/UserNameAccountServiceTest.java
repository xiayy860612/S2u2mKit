package s2u2msdk.spring.service.account.service.account;

import s2u2msdk.spring.service.account.service.UserService;
import s2u2msdk.spring.test.AbS2u2mSpringTest;
import s2u2msdk.spring.service.account.controller.account.dto.UserNameAccountRegDTO;
import s2u2msdk.spring.service.account.dao.UserNameAccountDAO;
import s2u2msdk.spring.service.account.entity.UserEntity;
import s2u2msdk.spring.service.account.entity.account.UserNameAccountEntity;
import s2u2msdk.spring.service.account.enums.GenderEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

public class UserNameAccountServiceTest extends AbS2u2mSpringTest {

    @Autowired
    private UserNameAccountService accountService;

    @MockBean
    private UserService userService;

    @MockBean
    private UserNameAccountDAO accountDAO;

    @Test
    public void reg__success() {
        String nickName = "test123456";
        String password = "test@123456";
        String id = "123456";
        GenderEnum gender = GenderEnum.Female;

        // mock
        doReturn(null).when(accountDAO).getByUserName(anyString());
        doReturn(1).when(accountDAO).insert(any(UserNameAccountEntity.class));

        doReturn(new UserEntity().setId(id).setNickName(nickName))
                .when(userService).create(any(UserEntity.class));

        UserNameAccountRegDTO regDTO = new UserNameAccountRegDTO()
                .setUserName(nickName)
                .setPassword(password)
                .setGender(gender);

        UserEntity entity = accountService.reg(regDTO);

        assertTrue(entity.getId().equals(id));
        assertNotNull(entity.getCreateTime());
        assertFalse(entity.getDeleteFlag());

        assertTrue(entity.getNickName().equals(nickName));
    }
}