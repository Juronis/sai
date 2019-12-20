package lt.vaidotas.sai.pokerHands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lt.vaidotas.sai.cards.Card;

public abstract class AbstractPokerHandMatcher {
	
	/**
	 * Link to the next stronger hand matcher 
	 */
	protected final AbstractPokerHandMatcher strongerHandMatcher;
	
	public AbstractPokerHandMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
        this.strongerHandMatcher = pStongerHandMatcher;
    }
	
	/**
	 * Simply checks if there is a given hand among the cards, 
	 * not looking if there may be a stronger hand. Returns cards that
	 * comprise the hand, null if no match is found.
	 * @param fiveCards
	 * @return
	 */
	public abstract Card[] matchesHand(Card[] cards);
	
	/**
	 * @return name of hand, like "High Card"
	 */
	public abstract String handName();
	
	/**
	 * Recursively goes through matcher chain and checks for a hand match
	 * @param cards
	 * @return
	 */
	public HandMatchInfo matchesAndGetHandCards(Card[] cards){
		// If no stronger matcher, this one is strongest
		if(strongerHandMatcher == null){
			Card[] matchesHand = matchesHand(cards);
			if(matchesHand != null){
				return new HandMatchInfo(handName(), matchesHand, 0);
			}
			else{
				return new HandMatchInfo(null, null, 0);
			}
		}
		HandMatchInfo stongerHandMatchInfo = 
				strongerHandMatcher.matchesAndGetHandCards(cards);
		if(stongerHandMatchInfo.getHandName() != null){
			return stongerHandMatchInfo;
		}
		else{
			Card[] matchesHand = matchesHand(cards);
			if(matchesHand != null){
				stongerHandMatchInfo.setCardsInHand(matchesHand);
				stongerHandMatchInfo.setHandName(handName());
				return stongerHandMatchInfo;
			}
			else{
				stongerHandMatchInfo.increaseMatcherNumber();
				return stongerHandMatchInfo;
			}
		}
	}
	
	/**
	 * 
	 * @param array of cards
	 * @return pair if cards if there are any
	 */
	public Card[] findPair(Card[] cards) {
		List<Card> cardList = Arrays.asList(cards);
		Collections.sort(cardList);
		Card previous = null;
		Card[] cardsInHand = new Card[2];
		for(Card card : cardList){
			if(previous == null){
				previous = card;
				continue;
			}
			if(previous.getRank().relativeValue() == card.getRank().relativeValue()){
				cardsInHand[0] = previous;
				cardsInHand[1] = card;
				break;
			}
		}
		if(cardsInHand[0] != null){
			return cardsInHand;
		}
		else{
			return null;
		}
	}
}
