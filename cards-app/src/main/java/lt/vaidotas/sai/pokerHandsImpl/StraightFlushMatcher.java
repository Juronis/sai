package lt.vaidotas.sai.pokerHandsImpl;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.cards.Rank;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class StraightFlushMatcher extends AbstractPokerHandMatcher{

    public StraightFlushMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
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
            for(Card currentCard : cardList){
                if(previousCard == null){
                    previousCard = currentCard;
                    continue;
                }
                // low ace
                if(differenceSum == 3 && currentCard.getRank().equals(Rank.ACE) && 
                        cardList.get(0).getRank().equals(Rank.TWO)){
                    return cards;
                }
                int valueDifference = currentCard.getRank().relativeValue() - 
                        previousCard.getRank().relativeValue();
                
                if(valueDifference == 1){
                    differenceSum += valueDifference;
                }
                if(differenceSum == 4){
                    return cards;
                }
                previousCard = currentCard;
            }
            return null;
        }
        else{ 
            return null;
        }
    }

    @Override
    public String handName() {
        return "Straigth Flush";
    }


}
