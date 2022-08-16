package exceptions;

public class ResourceBadRequestException extends RuntimeException {

    public ResourceBadRequestException(String message) {
        super(String.format("There was an error validating the request. Details: %s", message));
    }

}