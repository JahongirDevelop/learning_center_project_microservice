package uz.pdp.studentservice.exception;


public class SendVerificationCodeException extends RuntimeException{
    public SendVerificationCodeException(String message) {
        super(message);
    }
}