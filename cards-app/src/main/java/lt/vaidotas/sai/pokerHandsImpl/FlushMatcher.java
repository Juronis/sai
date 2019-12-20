package lt.vaidotas.sai.pokerHandsImpl;


import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class FlushMatcher extends AbstractPokerHandMatcher{

	public FlushMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
		super(pStongerHandMatcher);
	}

	@Override
	public Card[] matchesHand(Card[] cards) {
		if(cards[0].getSuit().equals(cards[1].getSuit()) &&
		    cards[1].getSuit().equals(cards[2].getSuit()) &&	
		     cards[2].getSuit().equals(cards[3].getSuit()) &&
		      cards[3].getSuit().equals(cards[4].getSuit())){
			return cards;
		}
		else{ 
			return null;
		}
	}

	@Override
	public String handName() {
		return "Flush";
	}


}
