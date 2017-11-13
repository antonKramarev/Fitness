package fitness.rest.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by toxa on 7/15/2017.
 */
public class ErrorsModel {

    private List<ErrorModel> errors;

    private ErrorsModel(List<ErrorModel> errors) {
        this.errors = errors;
    }

    private ErrorsModel(ErrorModel error) {
        this.errors = Arrays.asList(error);
    }

    public static ErrorsModel of(List<ErrorModel> errors) {
        return new ErrorsModel(errors);
    }
    public static ErrorsModel of(ErrorModel error) {
        return new ErrorsModel(error);
    }

    public static class ErrorModel{
        private String errorCode;
        private String description;
        private String pointer;

        private ErrorModel(String errorCode, String description, String pointer) {
            this.errorCode = errorCode;
            this.description = description;
            this.pointer = pointer;
        }

        public static ErrorModel of(String errorCode, String description, String pointer) {
            return new ErrorModel(errorCode, description, pointer);
        }
        public static ErrorModel of(String errorCode, String description) {
            return of(errorCode, description, null);
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getDescription() {
            return description;
        }

        public String getPointer() {
            return pointer;
        }
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }
}
