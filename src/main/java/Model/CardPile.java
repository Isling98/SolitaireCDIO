package Model;

import java.util.EmptyStackException;
import java.util.LinkedList;

public abstract class CardPile {

    //Måske unødvendigt
    public String name = this.getClass().getSimpleName();

    public LinkedList<Card> LinkedCards = new LinkedList<Card>();


    public final Card top() {
        //Retrieves, but does not remove, the head (first element) of this list.
        return LinkedCards.peek();
    }

    public boolean isEmpty(){
        return LinkedCards.isEmpty();
    }

    //removes and returns the first element of this list
    public Card popCard(){
        try {
            return LinkedCards.pop();
        }
        catch (EmptyStackException e) {return null;}

    }

    // Sometimes overridden

    public void addCard(Card card){
        LinkedCards.push(card);
    }

    public void addPile(LinkedList<Card> pile){
        LinkedCards.addAll(pile);
    }

    public void select (){ ;
    }


    public boolean canTake (Card card) {return false;}


    public String printPile() {
        if (!LinkedCards.isEmpty()) {

            return LinkedCards.toString();
        }
        else return "empty";
    }


}

