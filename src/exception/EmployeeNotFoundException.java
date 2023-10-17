package exception;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "Employee not found";
    }
}
