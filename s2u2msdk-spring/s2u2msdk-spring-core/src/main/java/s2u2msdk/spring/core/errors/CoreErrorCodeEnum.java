package s2u2msdk.spring.core.errors;

/**
 * enum CoreErrorCodeEnum
 *
 * @author xiayy860612
 * @date 2018/5/16
 */
public enum CoreErrorCodeEnum implements IErrorCodeEnum {


    // enum handler error
    IntEnumItemNotExisted(1000),

    // uid error
    GenerateUidError(1100),

    ;

    @Override
    public int getTypeCode() {
        return S2u2mErrorTypeConfig.CoreError;
    }

    @Override
    public int getCode() {
        return this.code;
    }
    private int code;
    CoreErrorCodeEnum(int code) {
        this.code = code;
    }
}
