package s2u2msdk.spring.core.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Error response.
 *
 * @author Amos Xia
 */
@Getter
@Setter
public class ErrorResponse extends BaseResponse {
    private String errMsg = "";
}
