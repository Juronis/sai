package lt.vaidotas.sai.cards;
/**
 * 
 * @author Vaidotas
 * 
 * Class representing a playing card
 */
public class Card implements Comparable<Card>{
    
    private final Rank rank;
    private final Suit suit;
    
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    public Card(Rank pRank, Suit pSuit){
        this.rank = pRank;
        this.suit = pSuit;
    }
    
    public boolean isSameSuit(Card anotherCard){
        return anotherCard.getSuit().equals(getSuit());
    }
    
    public boolean isSameRank(Card anotherCard){
        return anotherCard.getRank().equals(getRank());
    }

    public boolean isSameCard(Card anotherCard){
        return isSameRank(anotherCard) && isSameSuit(anotherCard);
    }
    
    public String symbolicName(){
        return rank.getRankName() + suit.symbol();
    }
    
    public String writtenName(){
        return rank.getRankName() + suit.getSuitCode();
    }
    
    public boolean isNextBetterThan(Card anotherCard){
        return (getRank().relativeValue()-1) == anotherCard.getRank().relativeValue();
    }

    @Override
    public int compareTo(Card anotherCard) {
        return (new Integer(getRank().relativeValue())).compareTo(
                new Integer(anotherCard.getRank().relativeValue()));
    }
    
    @Override
    public boolean equals(Object o) { 
        if (o == this) { 
            return true; 
        } 
        if (!(o instanceof Card)) { 
            return false; 
        } 
        Card c = (Card) o; 
        return this.isSameCard(c); 
    } 
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.rank != null ? this.rank.name().hashCode() : 0);
        hash = 53 * hash + this.suit.name().hashCode();
        return hash;
    }
}
