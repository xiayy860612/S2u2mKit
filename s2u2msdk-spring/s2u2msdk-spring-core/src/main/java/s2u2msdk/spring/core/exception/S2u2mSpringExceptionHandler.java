package s2u2msdk.spring.core.exception;

import javax.servlet.http.HttpServletRequest;

import s2u2msdk.spring.core.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class S2u2mSpringExceptionHandler {

    @ExceptionHandler(S2u2mSpringException.class)
    @ResponseStatus(HttpStatus.OK)
    public ErrorResponse s2u2mExceptionHandler(
            S2u2mSpringException exception, HttpServletRequest httpServletRequest) {
        log.error(exception.toString());
        ErrorResponse response = new ErrorResponse();
        response.setCode(exception.getErrCode());
        response.setErrMsg(exception.getErrMsg());
        return response;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String innerError(Exception exception, HttpServletRequest request) {
        exception.printStackTrace();
        return exception.toString();
    }
}
