package uz.pdp.studentservice.exception;

public class DuplicateValueException extends RuntimeException{

    public DuplicateValueException(String message) {
        super(message);
    }
}