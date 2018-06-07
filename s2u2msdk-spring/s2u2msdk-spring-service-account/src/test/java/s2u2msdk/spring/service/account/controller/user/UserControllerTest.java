package s2u2msdk.spring.service.account.controller.user;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import s2u2msdk.spring.test.AbS2u2mControllerTest;
import s2u2msdk.spring.service.account.entity.UserEntity;
import s2u2msdk.spring.service.account.enums.GenderEnum;
import s2u2msdk.spring.service.account.service.UserService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.Instant;
import java.util.Date;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class UserControllerTest
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public class UserControllerTest extends AbS2u2mControllerTest {

    @MockBean
    private UserService userService;

    @Test
    public void getUserInfo() throws Exception {
        String id = "123456";
        String nickName = "test";
        GenderEnum gender = GenderEnum.Unknown;
        Date birthday = Date.from(Instant.now());

        UserEntity entity = new UserEntity()
                .setId(id)
                .setNickName(nickName)
                .setGender(gender)
                .setBirthday(birthday);
        doReturn(entity).when(userService).get(anyString());

        mockMvc.perform(get("/user/")
                .header("token", "asdfsafd")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(documentAPI("getUserInfo"));
    }
}
