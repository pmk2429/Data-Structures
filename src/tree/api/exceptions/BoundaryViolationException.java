package tree.api.exceptions;

/**
 * Created by Pavitra on 11/6/2015.
 */
public class BoundaryViolationException extends Exception {
    private static final long serialVersionUID = 1678881446877427675L;

    private String errorCode = "Boundary_Violated";


    public BoundaryViolationException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
