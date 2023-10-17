package exception;

public class InvalidInputException extends Exception{
    public InvalidInputException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Invalid Input";
    }
}
