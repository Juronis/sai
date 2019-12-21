package lt.vaidotas.sai.main;

import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;
import lt.vaidotas.sai.pokerHandsImpl.*;

/**
 * 
 * @author Vaidotas
 * Class resposible for creating a hand matcher chain which corresponds to
 * actual standard poker hands in standard order from royal flush to high card. 
 */
public class StandartPokerHandOrdering implements HandOrdering{
    
    public AbstractPokerHandMatcher orderedHandChain(){
        AbstractPokerHandMatcher royalMatcher  = new RoyalFlushMatcher(null);
        AbstractPokerHandMatcher straightFlushMatcher  = new StraightFlushMatcher(royalMatcher);
        AbstractPokerHandMatcher fourOfAKindMatcher  = new FourOfAKindMatcher(straightFlushMatcher);
        AbstractPokerHandMatcher fullHouseMatcher  = new FullHouseMatcher(fourOfAKindMatcher);
        AbstractPokerHandMatcher flushMatcher  = new FlushMatcher(fullHouseMatcher);
        AbstractPokerHandMatcher straightMatcher  = new StraightMatcher(flushMatcher);
        AbstractPokerHandMatcher threeOfAKindMatcher  = new ThreeOfAKindMatcher(straightMatcher);
        AbstractPokerHandMatcher twoPairMatcher  = new TwoPairMatcher(threeOfAKindMatcher);
        AbstractPokerHandMatcher pairMatcher  = new PairMatcher(twoPairMatcher);
        AbstractPokerHandMatcher highCardMatcher  = new HighCardMatcher(pairMatcher);
        return highCardMatcher;
    }
}
