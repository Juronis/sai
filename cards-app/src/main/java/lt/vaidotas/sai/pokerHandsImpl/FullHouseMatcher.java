package lt.vaidotas.sai.pokerHandsImpl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.exceptions.ImpossibleCardCombinationException;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class FullHouseMatcher extends AbstractPokerHandMatcher{

    public FullHouseMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
        super(pStongerHandMatcher);
    }

    @Override
    public Card[] matchesHand(Card[] cards) {
        //check if one pair exists
        Card[] pair = findPair(cards);
        if (pair != null) {
            //if it does, then either all other three are same (full house), or there is a third
            List<Card> allCardsList = new LinkedList<Card>(Arrays.asList(cards));
            Iterator<Card> i = allCardsList.iterator();
            Card card = null;
            List<Card> remainingCards = new ArrayList<Card>();
            List<Card> sameCards = new ArrayList<Card>();
            int removeCounter = 0;
            while (i.hasNext()) {
                card = (Card) i.next();
                if (card.compareTo(pair[0]) == 0) {
                    sameCards.add(card);
                    i.remove();
                    removeCounter++;
                    if(removeCounter == 3 && remainingCards.size() == 2 && 
                        remainingCards.get(0).getRank().relativeValue() == 
                        remainingCards.get(1).getRank().relativeValue()){
                        break;
                    }
                } else {
                    remainingCards.add(card);
                }
            } 
            if(sameCards.size() == 5){
                throw new ImpossibleCardCombinationException("Five cars of same rank appeared in hand.");
            }
            //Actual full house
            else if(remainingCards.size() == 3  && 
                    remainingCards.get(0).getRank().relativeValue() == 
                    remainingCards.get(1).getRank().relativeValue() && 
                    remainingCards.get(1).getRank().relativeValue() == 
                    remainingCards.get(2).getRank().relativeValue()){
                return (Card[])remainingCards.toArray(new Card[remainingCards.size()]);
            }
            //Another kind of full house
            else if(sameCards.size() == 3 && remainingCards.size() == 2 && 
                    remainingCards.get(0).getRank().relativeValue() == 
                    remainingCards.get(1).getRank().relativeValue()){
                return (Card[])sameCards.toArray(new Card[sameCards.size()]);
            } else{
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String handName() {
        return "Full House";
    }


}
