package Model.Piles;

import Model.Card;

import java.util.EmptyStackException;
import java.util.LinkedList;

public abstract class CardPile {

    public LinkedList<Card> linkedCards = new LinkedList<Card>();

    public final Card top() {
        //Retrieves, but does not remove, the head (first element) of this list.
        return linkedCards.peek();
    }

    public boolean isEmpty(){
        return linkedCards.isEmpty();
    }

    //removes and returns the first element of this list
    public Card popCard(){
        try {

            Card tempcard = linkedCards.pop();
            if (linkedCards.size()> 0){
                linkedCards.getFirst().flipCard();
            }

            return tempcard;
        }
        catch (EmptyStackException e) {return null;}

    }
    public int getSize (){
        return linkedCards.size();
    }

    // Sometimes overridden

    public void addCard(Card card){
        linkedCards.push(card);
    }

    public void addPile(LinkedList<Card> pile){
        linkedCards.addAll(pile);
    }

    public void select (){ ;
    }

    public Card getLowestAvailable (){
        return null;
    }


    public boolean canTake (Card card) {return false;}


    public String printPile() {
        if (!linkedCards.isEmpty()) {

            return linkedCards.toString();
        }
        else return "empty";
    }


}

