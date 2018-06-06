package s2u2msdk.spring.core.dto;

import s2u2msdk.spring.core.dto.response.DataResponse;
import s2u2msdk.spring.core.dto.response.VoidResponse;

/**
 * @author Amos Xia
 * @date 2018/4/24
 */
public class ResponseBuilder {
    public static <T> DataResponse<T> build(Object obj, Class<T> tClass) {
        T data = tClass.cast(obj);
        return build(data);
    }

    public static <T> DataResponse<T> build(T data) {
        DataResponse<T> response = new DataResponse<>();
        response.setData(data);
        return response;
    }

    public static VoidResponse nothing() {
        return new VoidResponse();
    }
}
