package fitness.rest.advice;

import fitness.rest.model.ErrorsModel;
import fitness.service.exeption.ResourceDeletionFailedException;
import fitness.service.exeption.ResourceNotFoundException;
import fitness.service.exeption.ValidationException;
import fitness.service.utils.ErrorCode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Anton_Kramarev on 6/19/2017.
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsModel apiInternalServerErrorHandler(Throwable throwable) {
        throwable.printStackTrace();
        return ErrorsModel.of(ErrorsModel.ErrorModel.of(ErrorCode.INTERNAL_SERVER_ERROR.toString(),
                ErrorCode.INTERNAL_SERVER_ERROR.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsModel emptyDataExceptionHandler(ResourceNotFoundException exception) {
        return ErrorsModel.of(ErrorsModel.ErrorModel.of(exception.errorCodeToString(), exception.getMessage(), "id"));
    }

    @ResponseBody
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsModel validationExceptionHandler(ValidationException exception) {
        Set<String> errorCodes = exception.getErrorCodes();
        List<ErrorsModel.ErrorModel> errors = errorCodes.stream()
                .map(s -> ErrorsModel.ErrorModel.of(s, resolveDescription(s), resolvePointer(s)))
                .collect(Collectors.toList());
        return ErrorsModel.of(errors);

    }

    private String resolvePointer(String code) {
        return "pointer" + code;
    }

    private String resolveDescription(String code) {
        return "description" + code;
    }
}
