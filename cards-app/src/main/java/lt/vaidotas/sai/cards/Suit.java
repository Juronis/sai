package lt.vaidotas.sai.cards;

/**
 * 
 * @author Vaidotas
 * 
 * Enum representing suit of the card
 */
public enum Suit {
	SPADE("S"){
		@Override
        public String symbol() {
            return "♠";
        }
	},
	HEART("H"){
		@Override
        public String symbol() {
            return "♠";
        }
	},
	DIAMOND("D"){
		@Override
        public String symbol() {
            return "♦";
        }
	},
	CLUB("C"){
		@Override
        public String symbol() {
            return "♣";
        }
	};
	
	private final String suitCode;

	Suit(String pSuit) {
		this.suitCode = pSuit;
	}

	public String getSuitCode() {
		return this.suitCode;
	}
	
	public abstract String symbol();
}
