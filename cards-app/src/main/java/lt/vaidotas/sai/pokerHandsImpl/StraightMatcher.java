package lt.vaidotas.sai.pokerHandsImpl;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.cards.Rank;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class StraightMatcher extends AbstractPokerHandMatcher{

    public StraightMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
        super(pStongerHandMatcher);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Card[] matchesHand(Card[] cards) {
        List<Card> cardList = Arrays.asList(cards);
        Collections.sort(cardList);
        int differenceSum = 0;
        Card previousCard = null;
        for(Card card : cardList){
            if(previousCard == null){
                previousCard = card;
                continue;
            }
            // low ace
            if(differenceSum == 3 && card.getSuit().equals(Rank.ACE) && 
                    cardList.get(0).getRank().equals(Rank.TWO)){
                return cards;
            }
            int valueDifference = card.getRank().relativeValue() - 
                    previousCard.getRank().relativeValue();
            
            if(valueDifference == 1){
                differenceSum += valueDifference;
            }
            if(differenceSum == 4){
                return cards;
            }
            previousCard = card;
        }
        return null;
    }

    @Override
    public String handName() {
        return "Straight";
    }


}
