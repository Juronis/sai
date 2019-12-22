package lt.vaidotas.sai.exceptions;

/**
 * 
 * @author Vaidotas
 * 
 * Exception thrown when input is not understood, for example 
 * too many cards, not enough cards, impossible cards etc.
 */

public class InvalidInputFormattingException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 5062025254255751946L;
    
    public InvalidInputFormattingException(){
        super();
    }
    
    public InvalidInputFormattingException(String message, Throwable cause){
        super(message, cause);
    }

    public InvalidInputFormattingException(String message){
        super(message);
    }
    
    public InvalidInputFormattingException(Throwable cause){
        super(cause);
    }

}
