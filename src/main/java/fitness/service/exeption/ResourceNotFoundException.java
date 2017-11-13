package fitness.service.exeption;

import fitness.service.utils.ErrorCode;

/**
 * Created by toxa on 7/13/2017.
 */
public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(Object resourceId) {
        super(ErrorCode.RESOURCE_NOT_FOUND, resourceId);
    }
}
