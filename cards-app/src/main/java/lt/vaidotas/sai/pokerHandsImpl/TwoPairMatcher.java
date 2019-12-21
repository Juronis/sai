package lt.vaidotas.sai.pokerHandsImpl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class TwoPairMatcher extends AbstractPokerHandMatcher {

    public TwoPairMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
        super(pStongerHandMatcher);
    }

    @Override
    public Card[] matchesHand(Card[] cards) {
        //check if one pair exists
        Card[] pair = findPair(cards);
        if (pair != null) {
            //if it does, remove it and search for another
            List<Card> cardsList = new LinkedList<Card>(Arrays.asList(cards));
            Iterator<Card> i = cardsList.iterator();
            Card card = null;
            int removeCounter = 0;
            while (i.hasNext()) {
                card = (Card) i.next();
                if (card.isSameCard(pair[0]) || card.isSameCard(pair[1])) {
                    i.remove();
                    removeCounter++;
                    if(removeCounter == 2){
                        break;
                    }
                }
            }
            Card[] anotherPair = findPair((Card[])cardsList.toArray(new Card[cardsList.size()]));
            if(anotherPair!= null && anotherPair.length == 2 ){
                return ArrayUtils.addAll(pair, findPair((Card[])cardsList.toArray(
                        new Card[cardsList.size()])));
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String handName() {
        return "Two Pair";
    }

}
