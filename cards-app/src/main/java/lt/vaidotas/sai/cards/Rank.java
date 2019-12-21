package lt.vaidotas.sai.cards;

/**
 * 
 * @author Vaidotas
 * 
 * Enum representing rank of the card
 */
public enum Rank {
    TWO("2"){
        @Override
        public int relativeValue() {
            return 2;
        }
    },
    THREE("3"){
        @Override
        public int relativeValue() {
            return 3;
        }
    },
    FOUR("4"){
        @Override
        public int relativeValue() {
            return 4;
        }
    },
    FIVE("5"){
        @Override
        public int relativeValue() {
            return 5;
        }
    },
    SIX("6"){
        @Override
        public int relativeValue() {
            return 6;
        }
    },
    SEVEN("7"){
        @Override
        public int relativeValue() {
            return 7;
        }
    },
    EIGHT("8"){
        @Override
        public int relativeValue() {
            return 8;
        }
    },
    NINE("9"){
        @Override
        public int relativeValue() {
            return 9;
        }
    },
    TEN("10"){
        @Override
        public int relativeValue() {
            return 10;
        }
    },
    JACK("J"){
        @Override
        public int relativeValue() {
            return 11;
        }
    },
    QUEEN("Q"){
        @Override
        public int relativeValue() {
            return 12;
        }
    },
    KING("K"){
        @Override
        public int relativeValue() {
            return 13;
        }
    },
    ACE("A"){
        @Override
        public int relativeValue() {
            return 14;
        }
    };
    
    private final String rankName;

    Rank(String pRank) {
        this.rankName = pRank;
    }

    public String getRankName() {
        return this.rankName;
    }
    
    public abstract int relativeValue();
}
