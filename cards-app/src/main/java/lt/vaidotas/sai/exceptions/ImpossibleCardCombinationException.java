package lt.vaidotas.sai.exceptions;

/**
 * 
 * @author Vaidotas
 * 
 * Exception thrown when there is an impossible card combination, like 
 * five aces or two same cards in one hand.
 */

public class ImpossibleCardCombinationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5062025254255751946L;
	
	public ImpossibleCardCombinationException(){
		super();
	}
	
	public ImpossibleCardCombinationException(String message, Throwable cause){
		super(message, cause);
	}

	public ImpossibleCardCombinationException(String message){
		super(message);
	}
	
	public ImpossibleCardCombinationException(Throwable cause){
		super(cause);
	}

}
