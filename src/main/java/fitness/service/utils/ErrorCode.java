package fitness.service.utils;

/**
 * Created by Anton_Kramarev on 6/22/2017.
 */
public enum ErrorCode {

    INTERNAL_SERVER_ERROR("Unknown server error occurred"),
    RESOURCE_DELETE_FAILED("Resource with id: %s cannot be deleted"),
    RESOURCE_NOT_FOUND("Resource with id: %s not found");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
