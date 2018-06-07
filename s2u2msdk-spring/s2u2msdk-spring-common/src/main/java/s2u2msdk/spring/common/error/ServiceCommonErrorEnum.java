package s2u2msdk.spring.common.error;

import s2u2msdk.spring.core.enumhandler.IIntEnum;
import s2u2msdk.spring.core.errors.IErrorCodeEnum;

/**
 * enum ServiceCommonErrorEnum
 *
 * @author xiayy860612
 * @date 2018/6/7
 */
public enum ServiceCommonErrorEnum implements IErrorCodeEnum {
    ;

    @Override
    public int getTypeCode() {
        return ServiceErrorTypeEnum.Common.getValue();
    }

    @Override
    public int getCode() {
        return this.code;
    }

    private int code;
    ServiceCommonErrorEnum(int code) {
        this.code = code;
    }
}
