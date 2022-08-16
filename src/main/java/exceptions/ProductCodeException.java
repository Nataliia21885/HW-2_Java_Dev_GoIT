package exceptions;

public class ProductCodeException extends RuntimeException {

    public ProductCodeException(String message) {
        super(String.format("There was an error during CalculationService: %s", message));
    }

}
