package exception;

public class InsufficientTextException extends Exception{
    public InsufficientTextException(String msg){
        super(msg);
    }

    public String getMessage(){
        return "Insufficient text for search";
    }
}


