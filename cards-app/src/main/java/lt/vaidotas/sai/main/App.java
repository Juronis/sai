package lt.vaidotas.sai.main;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.cards.Rank;
import lt.vaidotas.sai.cards.Suit;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;
import lt.vaidotas.sai.pokerHandsImpl.HighCardMatcher;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( args[0] );
        AbstractPokerHandMatcher f  = new HighCardMatcher(null);
        f.matchesHand(new Card[]{new Card(Rank.ACE, Suit.CLUB),
                new Card(Rank.ACE, Suit.HEART),
                new Card(Rank.JACK, Suit.DIAMOND),
                new Card(Rank.TEN, Suit.SPADE)});
        for(Rank o : Rank.class.getEnumConstants()){
        	System.out.println(o);
        }
        System.out.println(Rank.valueOf("ACE"));
    }
}
