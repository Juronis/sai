package lt.vaidotas.sai.hands;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.cards.Rank;
import lt.vaidotas.sai.cards.Suit;
import lt.vaidotas.sai.exceptions.InvalidInputFormattingException;
import lt.vaidotas.sai.main.MainLauncher;

public class InputTest {
    
    @Test(expected = InvalidInputFormattingException.class)
    public void testIllegalCard(){
        MainLauncher.getFiveCardsFromInput("1H 2H JD QD 3H");
    }
    
    @Test(expected = InvalidInputFormattingException.class)
    public void testIllegalCard2(){
        MainLauncher.getFiveCardsFromInput("10H 2HH JD QD 3H");
    }
    
    @Test(expected = InvalidInputFormattingException.class)
    public void testIllegalCard3(){
        MainLauncher.getFiveCardsFromInput("3. 2H JD QD 3H");
    }
    
    @Test(expected = InvalidInputFormattingException.class)
    public void testTooManyCards(){
        MainLauncher.getFiveCardsFromInput("5H 2H JD QD 3H 4H");
    }
    
    @Test(expected = InvalidInputFormattingException.class)
    public void testNotEnoughCards(){
        MainLauncher.getFiveCardsFromInput("5H QH 6S 4H");
    }
    
    @Test(expected = InvalidInputFormattingException.class)
    public void testDuplicateCard(){
        MainLauncher.getFiveCardsFromInput("5H 2H 3H 4H 3H");
    }
    
    @Test
    public void testValidHand(){
        List<Card> cards = MainLauncher.getFiveCardsFromInput("QH 2C KS 4H 6D");
        Assert.assertEquals(cards.get(0), new Card(Rank.QUEEN, Suit.HEARTS));
        Assert.assertEquals(cards.get(1), new Card(Rank.TWO, Suit.CLUBS));
        Assert.assertEquals(cards.get(2), new Card(Rank.KING, Suit.SPADES));
        Assert.assertEquals(cards.get(3), new Card(Rank.FOUR, Suit.HEARTS));
        Assert.assertEquals(cards.get(4), new Card(Rank.SIX, Suit.DIAMONDS));
    }
    
    @Test
    public void testCardEquality(){
        List<Card> cards = MainLauncher.getFiveCardsFromInput("QH 2C KS 4H 6D");
        Assert.assertNotEquals(cards.get(0), new Card(Rank.QUEEN, Suit.CLUBS));
        Assert.assertNotEquals(cards.get(1), new Card(Rank.TWO, Suit.DIAMONDS));
        Assert.assertEquals(cards.get(2), new Card(Rank.KING, Suit.SPADES));
        Assert.assertNotEquals(cards.get(3), new Card(Rank.THREE, Suit.CLUBS));
        Assert.assertEquals(cards.get(4), new Card(Rank.SIX, Suit.DIAMONDS));
    }
}
