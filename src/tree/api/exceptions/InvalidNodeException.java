package tree.api.exceptions;

/**
 * Exception to handle InvalidNode data
 * Created by Pavitra on 11/6/2015.
 */
public class InvalidNodeException extends Exception {

    private static final long serialVersionUID = 6149400755784494333L;

    private String errorCode = "Invalid_Node";

    public InvalidNodeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public String getErrorCode() {
        return this.errorCode;
    }
}
