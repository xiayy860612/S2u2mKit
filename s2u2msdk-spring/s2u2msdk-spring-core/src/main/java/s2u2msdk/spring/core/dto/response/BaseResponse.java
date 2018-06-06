package s2u2msdk.spring.core.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Base response.
 *
 * @author Amos Xia
 */
@Getter
@Setter
public abstract class BaseResponse {
    protected int code = 0;
}
