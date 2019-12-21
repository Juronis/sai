package lt.vaidotas.sai.pokerHandsImpl;


import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public class PairMatcher extends AbstractPokerHandMatcher{

    public PairMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
        super(pStongerHandMatcher);
    }

    @Override
    public Card[] matchesHand(Card[] cards) {
        return findPair(cards);
    }

    @Override
    public String handName() {
        return "Pair";
    }
}
