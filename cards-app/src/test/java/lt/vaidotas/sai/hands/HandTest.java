package lt.vaidotas.sai.hands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lt.vaidotas.sai.cards.*;
import lt.vaidotas.sai.main.HandOrdering;
import lt.vaidotas.sai.main.StandartPokerHandOrdering;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;
import lt.vaidotas.sai.pokerHands.HandMatchInfo;
import lt.vaidotas.sai.pokerHandsImpl.*;

/**
 * @author Vaidotas
 * Unit test checking hand combinations.
 */
public class HandTest
{
    
    private AbstractPokerHandMatcher handMatcher;
    
    @Before
    public void initMatcher(){
        HandOrdering handOrdering = new StandartPokerHandOrdering();
        this.handMatcher  = handOrdering.orderedHandChain();
    }
    
    @Test
    public void testHighCard(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.CLUBS),
                    new Card(Rank.QUEEN, Suit.HEARTS),
                    new Card(Rank.SIX, Suit.CLUBS),
                    new Card(Rank.JACK, Suit.DIAMONDS),
                    new Card(Rank.TWO, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new HighCardMatcher(null)).handName());
    }
    
    @Test
    public void testPair(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.CLUBS),
                    new Card(Rank.ACE, Suit.HEARTS),
                    new Card(Rank.JACK, Suit.CLUBS),
                    new Card(Rank.JACK, Suit.DIAMONDS),
                    new Card(Rank.QUEEN, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new PairMatcher(null)).handName());
    }
    
    @Test
    public void testTwoPair(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.CLUBS),
                    new Card(Rank.ACE, Suit.HEARTS),
                    new Card(Rank.JACK, Suit.DIAMONDS),
                    new Card(Rank.KING, Suit.DIAMONDS),
                    new Card(Rank.JACK, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new TwoPairMatcher(null)).handName());
    }
    
    @Test
    public void testThreeOfAKind(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.CLUBS),
                    new Card(Rank.ACE, Suit.HEARTS),
                    new Card(Rank.JACK, Suit.CLUBS),
                    new Card(Rank.JACK, Suit.DIAMONDS),
                    new Card(Rank.JACK, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new ThreeOfAKindMatcher(null)).handName());
    }
    
    @Test
    public void testStraight(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.FOUR, Suit.CLUBS),
                    new Card(Rank.SIX, Suit.HEARTS),
                    new Card(Rank.EIGHT, Suit.CLUBS),
                    new Card(Rank.FIVE, Suit.DIAMONDS),
                    new Card(Rank.SEVEN, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new StraightMatcher(null)).handName());
    }
    
    @Test
    public void testFlush(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.HEARTS),
                    new Card(Rank.ACE, Suit.HEARTS),
                    new Card(Rank.TWO, Suit.HEARTS),
                    new Card(Rank.THREE, Suit.HEARTS),
                    new Card(Rank.NINE, Suit.HEARTS)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new FlushMatcher(null)).handName());
    }

    @Test
    public void testFullHouse(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.CLUBS),
                    new Card(Rank.KING, Suit.DIAMONDS),
                    new Card(Rank.TWO, Suit.HEARTS),
                    new Card(Rank.KING, Suit.HEARTS),
                    new Card(Rank.TWO, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new FullHouseMatcher(null)).handName());
    }
    
    @Test
    public void testFourOfAKind(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.KING, Suit.CLUBS),
                    new Card(Rank.TWO, Suit.SPADES),
                    new Card(Rank.KING, Suit.DIAMONDS),
                    new Card(Rank.KING, Suit.HEARTS),
                    new Card(Rank.KING, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new FourOfAKindMatcher(null)).handName());
    }
    
    @Test
    public void testStraightFlush(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.FIVE, Suit.DIAMONDS),
                    new Card(Rank.FOUR, Suit.DIAMONDS),
                    new Card(Rank.THREE, Suit.DIAMONDS),
                    new Card(Rank.SIX, Suit.DIAMONDS),
                    new Card(Rank.SEVEN, Suit.DIAMONDS)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new StraightFlushMatcher(null)).handName());
        handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.ACE, Suit.DIAMONDS),
                    new Card(Rank.FOUR, Suit.DIAMONDS),
                    new Card(Rank.THREE, Suit.DIAMONDS),
                    new Card(Rank.TWO, Suit.DIAMONDS),
                    new Card(Rank.FIVE, Suit.DIAMONDS)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new StraightFlushMatcher(null)).handName());
        handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.ACE, Suit.DIAMONDS),
                    new Card(Rank.KING, Suit.DIAMONDS),
                    new Card(Rank.THREE, Suit.DIAMONDS),
                    new Card(Rank.TWO, Suit.DIAMONDS),
                    new Card(Rank.FIVE, Suit.DIAMONDS)});
        Assert.assertNotEquals(handMatchInfo.getHandName(), (new StraightFlushMatcher(null)).handName());
        handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                    new Card(Rank.ACE, Suit.DIAMONDS),
                    new Card(Rank.KING, Suit.DIAMONDS),
                    new Card(Rank.QUEEN, Suit.DIAMONDS),
                    new Card(Rank.JACK, Suit.DIAMONDS),
                    new Card(Rank.TEN, Suit.DIAMONDS)});
        Assert.assertNotEquals(handMatchInfo.getHandName(), (new StraightFlushMatcher(null)).handName());
    }
    
    @Test
    public void testRoyalFlush(){
        HandMatchInfo handMatchInfo =  handMatcher.matchesAndGetHandCards(
                new Card[]{
                        new Card(Rank.ACE, Suit.SPADES),
                        new Card(Rank.KING, Suit.SPADES),
                        new Card(Rank.QUEEN, Suit.SPADES),
                        new Card(Rank.JACK, Suit.SPADES),
                        new Card(Rank.TEN, Suit.SPADES)});
        Assert.assertEquals(handMatchInfo.getHandName(), (new RoyalFlushMatcher(null)).handName());
    }
}
