package uz.pdp.groupservice.exception;

public class DuplicateValueException extends RuntimeException{

    public DuplicateValueException(String message) {
        super(message);
    }
}