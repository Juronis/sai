package lt.vaidotas.sai.pokerHandsImpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class FourOfAKindMatcher extends AbstractPokerHandMatcher{

	public FourOfAKindMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
		super(pStongerHandMatcher);
	}

	@Override
	public Card[] matchesHand(Card[] cards) {
		//check if one pair exists
		Card[] pair = findPair(cards);
		if (pair != null) {
			//if it does, then either all other three are same (full house), or there is a third
			List<Card> allCardsList = Arrays.asList(cards);
			Iterator<Card> i = allCardsList.iterator();
			Card card = null;
			List<Card> sameCards = new ArrayList<Card>();
			int removeCounter = 0;
			while (i.hasNext()) {
				card = (Card) i.next();
				if (card.compareTo(pair[0]) == 0) {
					sameCards.add(card);
					i.remove();
					removeCounter++;
					if(removeCounter == 4){
						break;
					}
				}
			}
			if(sameCards.size() == 4){
				return (Card[])sameCards.toArray();}
			else{
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String handName() {
		return "Four of a kiond";
	}


}
