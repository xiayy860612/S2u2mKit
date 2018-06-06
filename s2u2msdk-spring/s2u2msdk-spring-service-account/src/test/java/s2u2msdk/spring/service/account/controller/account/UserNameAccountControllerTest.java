package s2u2msdk.spring.service.account.controller.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import s2u2msdk.spring.test.AbS2u2mControllerTest;
import s2u2msdk.spring.service.account.controller.account.dto.LoginInfoDTO;
import s2u2msdk.spring.service.account.controller.account.dto.UserNameAccountLoginDTO;
import s2u2msdk.spring.service.account.controller.account.dto.UserNameAccountRegDTO;
import s2u2msdk.spring.service.account.entity.UserEntity;
import s2u2msdk.spring.service.account.entity.account.UserNameAccountEntity;
import s2u2msdk.spring.service.account.enums.GenderEnum;
import s2u2msdk.spring.service.account.service.account.UserNameAccountService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class UserNameAccountControllerTest
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public class UserNameAccountControllerTest extends AbS2u2mControllerTest {

    @MockBean
    private UserNameAccountService accountService;

    @Test
    public void reg() throws Exception {
        String nickName = "test12345";
        String password = "test@123456";
        String id = "123456";
        GenderEnum gender = GenderEnum.Female;

        UserEntity exp = new UserEntity()
                .setId(id).setNickName(nickName)
                .setGender(gender);
        doReturn(exp).when(accountService).reg(any(UserNameAccountRegDTO.class));

        UserNameAccountRegDTO regDTO = new UserNameAccountRegDTO()
                .setUserName(nickName).setPassword(password)
                .setGender(gender);

        ObjectMapper mapper = new ObjectMapper();
        MvcResult rst = mockMvc.perform(post("/account/username/reg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(regDTO)))
                .andExpect(status().isOk())
                .andDo(documentAPI("UserNameAccountReg"))
                .andReturn();

        LoginInfoDTO infoDTO = this.convertResponseToObject(rst, LoginInfoDTO.class);
        String expToken = exp.getId();
        assertEquals(expToken, infoDTO.getToken());
    }

    @Test
    public void login() throws Exception {
        String id = "123456";
        UserEntity exp = new UserEntity().setId(id);
        doReturn(exp).when(accountService).login(any(UserNameAccountLoginDTO.class));

        UserNameAccountEntity accountEntity = new UserNameAccountEntity()
                .setUserId(id);

        UserNameAccountLoginDTO dto = new UserNameAccountLoginDTO()
                .setUserName("test").setPassword("123456");

        ObjectMapper mapper = new ObjectMapper();
        MvcResult rst = mockMvc.perform(post("/account/username/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andDo(documentAPI("UserNameAccountLogin"))
                .andReturn();

        LoginInfoDTO infoDTO = this.convertResponseToObject(rst, LoginInfoDTO.class);
        String expToken = exp.getId();
        assertEquals(expToken, infoDTO.getToken());
    }
}
