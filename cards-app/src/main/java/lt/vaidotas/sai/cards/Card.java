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
	
	public boolean isNextBetterThan(Card anotherCard){
		return (getRank().relativeValue()-1) == anotherCard.getRank().relativeValue();
	}

	@Override
	public int compareTo(Card anotherCard) {
		return (new Integer(getRank().relativeValue())).compareTo(
				new Integer(anotherCard.getRank().relativeValue()));
	}
}
