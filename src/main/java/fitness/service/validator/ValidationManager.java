package fitness.service.validator;

import fitness.service.exeption.ValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by toxa on 7/13/2017.
 */

@Service
public class ValidationManager {

    private Validator validator;

    public ValidationManager() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    public <T> Set<String> validate(T validationObject) {
        Set<ConstraintViolation<T>> violations = validator.validate(validationObject);
        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
    }

    public <T> void validateAndThrow(T validationObject) {
        Set<String> errorCodes = validate(validationObject);
        if (!errorCodes.isEmpty()) {
            throw new ValidationException(errorCodes);
        }
    }
}


