package lt.vaidotas.sai.cards;

/**
 * 
 * @author Vaidotas
 * 
 * Enum representing suit of the card
 */
public enum Suit {
    SPADES("S"){
        @Override
        public String symbol() {
            return "♠";
        }
    },
    HEARTS("H"){
        @Override
        public String symbol() {
            return "♠";
        }
    },
    DIAMONDS("D"){
        @Override
        public String symbol() {
            return "♦";
        }
    },
    CLUBS("C"){
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
