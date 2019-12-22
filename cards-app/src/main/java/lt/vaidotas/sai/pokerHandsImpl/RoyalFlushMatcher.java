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
        if(cards.length != 5){
            return null;
        }
        if(cards[0].getSuit().equals(cards[1].getSuit()) &&
                cards[1].getSuit().equals(cards[2].getSuit()) &&    
                 cards[2].getSuit().equals(cards[3].getSuit()) &&
                  cards[3].getSuit().equals(cards[4].getSuit())){
                List<Card> cardList = Arrays.asList(cards);
                Collections.sort(cardList);
                if(cards[0].getRank().equals(Rank.TEN) &&
                    cards[1].getRank().equals(Rank.JACK) &&    
                     cards[2].getRank().equals(Rank.QUEEN) &&
                      cards[3].getRank().equals(Rank.KING)&&
                      cards[4].getRank().equals(Rank.ACE)){
                    return cards;
                } 
                else{
                    return null;
                }
            }
            else{ 
                return null;
            }
    }

    @Override
    public String handName() {
        return "Royal Flush";
    }


}
