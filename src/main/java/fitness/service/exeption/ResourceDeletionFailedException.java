package fitness.service.exeption;

import fitness.service.utils.ErrorCode;

/**
 * Created by toxa on 7/13/2017.
 */
public class ResourceDeletionFailedException extends ApiException {

    public ResourceDeletionFailedException(Object resourceId) {
        super(ErrorCode.RESOURCE_DELETE_FAILED, resourceId);
    }
}
