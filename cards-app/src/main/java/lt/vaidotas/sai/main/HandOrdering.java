package lt.vaidotas.sai.main;

import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;

public interface HandOrdering {
    public AbstractPokerHandMatcher orderedHandChain();
}
