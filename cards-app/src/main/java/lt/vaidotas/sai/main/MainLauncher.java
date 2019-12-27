package lt.vaidotas.sai.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.exceptions.InvalidInputFormattingException;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;
import lt.vaidotas.sai.pokerHands.HandMatchInfo;

public class MainLauncher {

    /**
     * main method, which handles user interface
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(
                "Enter first player's hand in the form of 5 cards, separated"
                    + " by spaces. Ranks are denoted by numbers 2-10, and "
                    + "letters J, Q, K, A representing Jack, Queen, King, "
                    + "Ace respectively. Suits are denoted by "
                    + " letters D, S, C, H, representing Diamonds, Spades, "
                    + " Clubs and Hearts."
                    + " Sample input would look like: \"2H 5S JC JD 8H\".");
        try (Scanner scanner = new Scanner(System.in)) {
            String cardCodeSequence = scanner.nextLine();
            List<Card> firstPlayerCards = getCardsWithExit(cardCodeSequence);
            System.out.println("Enter second player's hand hand:");
            cardCodeSequence = scanner.nextLine();
            List<Card> secondPlayerCards = getCardsWithExit(cardCodeSequence);
            HandOrdering handOrdering = new StandartPokerHandOrdering();
            AbstractPokerHandMatcher handMatcher = handOrdering
                    .orderedHandChain();
            HandMatchInfo firstHandMatchInfo = handMatcher
                    .matchesAndGetHandCards(
                            (Card[]) firstPlayerCards.toArray(new Card[5]));
            HandMatchInfo secondHandMatchInfo = handMatcher
                    .matchesAndGetHandCards(
                            (Card[]) secondPlayerCards.toArray(new Card[5]));
            if (firstHandMatchInfo
                    .getMatcherNumberFromStrongest() < secondHandMatchInfo
                            .getMatcherNumberFromStrongest()) {
                System.out.printf("First wins as he has %s and second player has %s",
                        firstHandMatchInfo.getHandName(), 
                        secondHandMatchInfo.getHandName());
            } else if (firstHandMatchInfo
                    .getMatcherNumberFromStrongest() > secondHandMatchInfo
                            .getMatcherNumberFromStrongest()) {
                System.out.printf("Second player wins as he has %s and first player has %s",
                        secondHandMatchInfo.getHandName(), 
                        firstHandMatchInfo.getHandName());
            } else {
                System.out.printf("Both players have a %s",
                        firstHandMatchInfo.getHandName());
                if (firstHandMatchInfo.returnHighCardOfMatch().compareTo(
                        secondHandMatchInfo.returnHighCardOfMatch()) > 0) {
                    System.out.printf(
                            "First wins by high card: %s", firstHandMatchInfo
                                    .returnHighCardOfMatch().writtenName());
                } else if (firstHandMatchInfo.returnHighCardOfMatch().compareTo(
                        secondHandMatchInfo.returnHighCardOfMatch()) < 0) {
                    System.out.printf(
                            "Second wins by high card: %s", secondHandMatchInfo
                                    .returnHighCardOfMatch().symbolicName());
                } else {
                    System.out.println("Both hands are equaly strong.");
                }
            }
        }
    }

    /**
     * 
     * @param inputCardSequence String representing 5 cards
     * @return list of cards 
     * Exits program if input is invalid in any way.
     */
    private static List<Card> getCardsWithExit(String inputCardSequence) {
        try{
            return getFiveCardsFromInput(inputCardSequence);
        }
        catch (InvalidInputFormattingException e){
            System.out.println(e.getMessage());
            System.exit(1);
            return new ArrayList<Card>();
        }
    }
    
    /**
     * 
     * @param inputCardSequence String representing 5 cards
     * @return list of cards 
     * InvalidInputFormattingException if input is invalid in any way, 
     * like number of cards is not 5, duplicate cards are found, 
     * invalid cards are found, etc.
     */
    public static List<Card> getFiveCardsFromInput(String inputCardSequence)
        throws InvalidInputFormattingException{
        List<Card> playerCards = CardInputParser.parseAndValidateDuplicateCards(inputCardSequence);
        if (playerCards.size() != 5) {
            throw new InvalidInputFormattingException(
                    "Not enough cards. Expected 5, got " + playerCards.size());
        }
        return playerCards;
    }
}
