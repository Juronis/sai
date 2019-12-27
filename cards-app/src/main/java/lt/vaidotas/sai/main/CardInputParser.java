package lt.vaidotas.sai.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lt.vaidotas.sai.cards.*;
import lt.vaidotas.sai.exceptions.ImpossibleCardCombinationException;
import lt.vaidotas.sai.exceptions.InvalidInputFormattingException;
/**
 * 
 * @author Vaidotas
 *
 */
public class CardInputParser {
    
    /**
     * 
     * @param cardSequence String with card codes separated by spaces, 
     * like 2H 5S JC JD 8H 
     * @return list of Cards in same order, with no duplicates, InvalidInputFormattingException
     * if duplicates are found or input is illegal
     */
    public static List<Card> parseAndValidateDuplicateCards(String cardCodeSequence)
            throws InvalidInputFormattingException{
        List<Card> cards = parseCards(cardCodeSequence);
        checkDuplicates(cards);
        return cards;
    } 
    
    /**
     * 
     * @param cardSequence String with card codes separated by spaces, 
     * like 2H 5S JC JD 8H 10H 6D QS
     * @return list of Cards in same order, InvalidInputFormattingException
     * if input is illegal
     */
    public static List<Card> parseCards (String cardCodeSequence) throws 
        InvalidInputFormattingException{
        String[] cardCodes = splitAndVerifyInput(cardCodeSequence);
        List<Card> cards = new ArrayList<Card>();
        for(String cardCode : cardCodes){
            cards.add(parseCard(cardCode));
        }
        return cards;
    } 
    
    /**
     * 
     * @param cards list of cards, with possible duplicates among them
     * @return true if no duplicates are found, exception otherwise
     */
    private static boolean checkDuplicates(List<Card> cards){
        Set<Card> set = new HashSet<Card>();
        for (Card each: cards) if (!set.add(each)) {
            throw new ImpossibleCardCombinationException("Duplicate card: " + each.writtenName());
        }
        return true;
    }
    
    /**
     * 
     * @param stringToSplit list of symbol groups, separated by spaces,
     * representing a set of cards
     * 
     * @return List of Strings, each representing potentially a card code
     * InvalidInputFormattingException if input is definitely not a valid rank
     * but not always - extra check is needed, as exception is thrown only when
     * number of symbols is not 2 or 3.
     */
    private static String[] splitAndVerifyInput(String stringToSplit) throws 
        InvalidInputFormattingException{
        String[] words = stringToSplit.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String specialSymbolsRemoved = words[i].replaceAll("[^\\w]", "");
            if(specialSymbolsRemoved.length() != words[i].length()){
                throw new InvalidInputFormattingException("Illegal card found in " + words[i]
                        + " . Only letters and numbers are allowed.");
            }
            if(specialSymbolsRemoved.length() != 2 && 
                    specialSymbolsRemoved.length() != 3){
                throw new InvalidInputFormattingException("Illegal card found in " + words[i]
                        + " Card should be of 2 or three symbols, like JD, 8H or 10H.");
            }
        }
        return words;
    }
    
    /**
     * 
     * @param cardCode Card code from input, like 10H or KD 
     * @return Card object if input is right, 
     * InvalidInputFormattingException if input is not a valid card
     */
    public static Card parseCard(String cardCode){
        if(cardCode.length() == 2){
            Rank rank = covertStringToRank(cardCode.substring(0, 1));
            Suit suit = covertStringToSuit(cardCode.substring(1, 2));
            return new Card(rank, suit);
        }
        if(cardCode.length() == 3){
            Rank rank = covertStringToRank(cardCode.substring(0, 2));
            Suit suit = covertStringToSuit(cardCode.substring(2, 3));
            return new Card(rank, suit);
        }
        else {
            throw new InvalidInputFormattingException("Invalid card: " + cardCode);
        }
    }
    
    /**
     * 
     * @param rankCode Card rank code, a number 2-10 or one of letters A,K,Q,J
     * @return Rank object the rank represents, 
     * InvalidInputFormattingException if input is not a valid rank
     */
    public static Rank covertStringToRank(String rankCode){
        Rank rank = null;
        switch(rankCode.toUpperCase()) 
        { 
            case "2": 
                rank = Rank.TWO;
                break; 
            case "3": 
                rank = Rank.THREE;
                break; 
            case "4": 
                rank = Rank.FOUR;
                break; 
            case "5": 
                rank = Rank.FIVE;
                break; 
            case "6": 
                rank = Rank.SIX;
                break; 
            case "7": 
                rank = Rank.SEVEN;
                break; 
            case "8": 
                rank = Rank.EIGHT;
                break; 
            case "9": 
                rank = Rank.NINE;
                break; 
            case "10": 
                rank = Rank.TEN;
                break; 
            case "J": 
                rank = Rank.JACK;
                break; 
            case "Q": 
                rank = Rank.QUEEN;
                break; 
            case "K": 
                rank = Rank.KING;
                break; 
            case "A": 
                rank = Rank.ACE;
                break; 
            default: 
                rank = null; 
        } 
        if(rank == null){
            throw new InvalidInputFormattingException("Illegal card rank found: " + rankCode + ".");
        }    
        return rank;
    }
    
    /**
     * 
     * @param rankCode Card suit code, one of letters D,C,S,H
     * @return Suit object the rank represents, 
     * InvalidInputFormattingException if input is not a valid suit
     */
    public static Suit covertStringToSuit(String suitCode){
        Suit suit = null;
        switch(suitCode.toUpperCase()) 
        { 
            case "D": 
                suit = Suit.DIAMONDS;
                break; 
            case "C": 
                suit = Suit.CLUBS;
                break; 
            case "S": 
                suit = Suit.SPADES;
                break; 
            case "H": 
                suit = Suit.HEARTS;
                break; 
            default: 
                suit = null; 
        } 
        if(suit == null){
            throw new InvalidInputFormattingException("Illegal card suit found: " + suitCode + ".");
        }    
        return suit;
    }
}
