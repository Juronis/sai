package lt.vaidotas.sai.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lt.vaidotas.sai.cards.Card;
import lt.vaidotas.sai.exceptions.InvalidInputFormattingException;
import lt.vaidotas.sai.pokerHands.AbstractPokerHandMatcher;
import lt.vaidotas.sai.pokerHands.HandMatchInfo;

public class App {

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
            List<Card> firstPlayerCards = getCardsFromInput(cardCodeSequence);
            System.out.println("Enter second player's hand hand:");
            cardCodeSequence = scanner.nextLine();
            List<Card> secondPlayerCards = getCardsFromInput(cardCodeSequence);
            HandOrdering handOrdering = new StandartPokerHandOrdering();
            AbstractPokerHandMatcher handMatcher = handOrdering
                    .orderedHandChain();
            HandMatchInfo firstHandMatchInfo = handMatcher
                    .matchesAndGetHandCards(
                            (Card[]) firstPlayerCards.toArray(new Card[5]));
            System.out.println(firstHandMatchInfo.getHandName());
            HandMatchInfo secondHandMatchInfo = handMatcher
                    .matchesAndGetHandCards(
                            (Card[]) secondPlayerCards.toArray(new Card[5]));
            System.out.println(secondHandMatchInfo.getHandName());
            if (firstHandMatchInfo
                    .getMatcherNumberFromStrongest() < secondHandMatchInfo
                            .getMatcherNumberFromStrongest()) {
                System.out.println("First wins as he has "
                        + firstHandMatchInfo.getHandName()
                        + " and second player has "
                        + secondHandMatchInfo.getHandName());
            } else if (firstHandMatchInfo
                    .getMatcherNumberFromStrongest() > secondHandMatchInfo
                            .getMatcherNumberFromStrongest()) {
                System.out.println("Second player wins as he has "
                        + secondHandMatchInfo.getHandName()
                        + " and first player has "
                        + firstHandMatchInfo.getHandName());
            } else {
                System.out.println("Both players have a "
                        + firstHandMatchInfo.getHandName());
                if (firstHandMatchInfo.returnHighCardOfMatch().compareTo(
                        secondHandMatchInfo.returnHighCardOfMatch()) > 0) {
                    System.out.println(
                            "First wins by high card: " + firstHandMatchInfo
                                    .returnHighCardOfMatch().symbolicName());
                } else if (firstHandMatchInfo.returnHighCardOfMatch().compareTo(
                        secondHandMatchInfo.returnHighCardOfMatch()) < 0) {
                    System.out.println(
                            "Second wins by high card: " + secondHandMatchInfo
                                    .returnHighCardOfMatch().symbolicName());
                } else {
                    System.out.println("Both hands are equaly strong.");
                }
            }
        }
    }

    private static List<Card> getCardsFromInput(String inputCardSequence) {
        try{
            List<Card> playerCards = CardInputParser.parseCards(inputCardSequence);
            if (playerCards.size() != 5) {
                System.out.println(
                        "Not enough cards. Expected 5, got " + playerCards.size());
                System.exit(1);
            }
            return playerCards;
        }
        catch (InvalidInputFormattingException e){
            System.out.println(e.getMessage());
            System.exit(1);
            return new ArrayList<Card>();
        }
    }

}
