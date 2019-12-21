package lt.vaidotas.sai.pokerHandsImpl;


import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;
import lt.vaidotas.sai.pokerHands.HandMatchInfo;

public class HighCardMatcher extends AbstractPokerHandMatcher{

    public HighCardMatcher(AbstractPokerHandMatcher pStongerHandMatcher) {
        super(pStongerHandMatcher);
    }

    @Override
    public Card[] matchesHand(Card[] cards) {
        return new Card[]{HandMatchInfo.highestCardOutOfSet(cards)};
    }

    @Override
    public String handName() {
        return "High Card";
    }



}
