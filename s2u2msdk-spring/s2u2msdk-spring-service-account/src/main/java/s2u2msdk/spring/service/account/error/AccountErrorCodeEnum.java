package s2u2msdk.spring.service.account.error;

import s2u2msdk.spring.common.error.ServiceErrorTypeEnum;
import s2u2msdk.spring.core.errors.IErrorCodeEnum;
import s2u2msdk.spring.core.errors.S2u2mErrorTypeConfig;

/**
 * enum AccountErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/20
 */
public enum AccountErrorCodeEnum implements IErrorCodeEnum {

    //
    UnAuth(50),
    NotSetUserEntityDuringAuth(51),

    UserNameOrPasswordFormatInvalid(101),
    UserNameAccountExisted(102),
    UserNameAccountNotExisted(103),;

    private int code;

    AccountErrorCodeEnum(int code) {
        this.code = code;
    }

    @Override
    public int getTypeCode() {
        return ServiceErrorTypeEnum.AccountService.getValue();
    }

    @Override
    public int getCode() {
        return this.code;
    }
}
