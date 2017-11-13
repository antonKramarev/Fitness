package fitness.service.exeption;

import fitness.service.utils.ErrorCode;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */
public class ApiException extends RuntimeException {

    private final ErrorCode errorCode;
    private final transient Object[] params;

    public ApiException(ErrorCode errorCode, Object ... params) {
        this.errorCode = errorCode;
        this.params = params;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String errorCodeToString() {
        return errorCode.toString();
    }


    public Object[] getParams() {
        return params;
    }

    @Override
    public String getMessage() {
        return String.format(errorCode.getMessage(), params);
    }
}
