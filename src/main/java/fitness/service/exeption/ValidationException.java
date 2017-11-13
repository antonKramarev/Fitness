package fitness.service.exeption;

import java.util.Set;

/**
 * Created by toxa on 7/13/2017.
 */
public class ValidationException extends RuntimeException{

    private final Set<String> errorCodes;

    public ValidationException(Set<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
    public Set<String> getErrorCodes() {
        return errorCodes;
    }
}
