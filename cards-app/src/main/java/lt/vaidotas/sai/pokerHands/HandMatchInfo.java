package lt.vaidotas.sai.pokerHands;

import java.util.Arrays;
import java.util.Collections;

import lt.vaidotas.sai.cards.Card;
/**
 * 
 * @author Vaidotas
 * Class for holding information about what hand was matched 
 * from set of cards
 */
public class HandMatchInfo {
	
	/**
	 * Human-readable info about what hand it is
	 */
	private String handName;

	/**
	 * which cards compose the hand combination
	 */
	private Card[] cardsInHand;
	
	/**
	 * How many stronger hands did not match
	 */
	private int matcherNumberFromStrongest;
	
	public HandMatchInfo(String pHandName,Card[] pCardsInHand, 
			int pMatcherNumberFromStrongest ){
		this.handName = pHandName;
		this.cardsInHand = pCardsInHand;
		this.matcherNumberFromStrongest = pMatcherNumberFromStrongest;
	}

	public String getHandName() {
		return handName;
	}
	
	public void setHandName(String handName) {
		this.handName = handName;
	}
	
	public Card[] getCardsInHand() {
		return cardsInHand;
	}

	public void setCardsInHand(Card[] cardsInHand) {
		this.cardsInHand = cardsInHand;
	}

	public void setMatcherNumberFromStrongest(int matcherNumberFromStrongest) {
		this.matcherNumberFromStrongest = matcherNumberFromStrongest;
	}
	
	public int getMatcherNumberFromStrongest() {
		return matcherNumberFromStrongest;
	}
	
	public Card returnHighCardOfMatch(){
		return highestCardOutOfSet(cardsInHand);
	}
	
	public static Card highestCardOutOfSet(Card[] cards){
		if(cards == null || cards.length == 0){
			return null;
		}
		return Collections.max(Arrays.asList(cards));
	}
	
	public void increaseMatcherNumber(){
		matcherNumberFromStrongest++;
	}
}
