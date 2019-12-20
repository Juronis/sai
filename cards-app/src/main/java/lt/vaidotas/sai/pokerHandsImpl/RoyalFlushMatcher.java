package lt.vaidotas.sai.pokerHandsImpl;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.cards.Rank;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

/**
 * Class for checking if hand is a royal flush
 * @author Vaidotas
 *
 */
public class RoyalFlushMatcher extends AbstractPokerHandMatcher{

	public RoyalFlushMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
		super(pStongerHandMatcher);
	}

	@Override
	public Card[] matchesHand(Card[] cards) {
		if(cards[0].getSuit().equals(cards[1].getSuit()) &&
			    cards[1].getSuit().equals(cards[2].getSuit()) &&	
			     cards[2].getSuit().equals(cards[3].getSuit()) &&
			      cards[3].getSuit().equals(cards[4].getSuit())){
				List<Card> cardList = Arrays.asList(cards);
				Collections.sort(cardList);
				int differenceSum = 0;
				Card previousCard = null;
				for(Card card : cardList){
					if(previousCard == null){
						previousCard = card;
						continue;
					}
					int valueDifference = card.getRank().relativeValue() - 
							previousCard.getRank().relativeValue();
					if(valueDifference != 0){
						differenceSum += valueDifference;
					}
					//high ace
					if(differenceSum == 5 && cardList.get(4).getRank().equals(Rank.ACE)){
						return cards;
					}
				}
				return null;
			}
			else{ 
				return null;
			}
	}

	@Override
	public String handName() {
		return null;
	}


}
