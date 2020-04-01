package Game.Model;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class CardPile {

    String test ="hej";
    LinkedList<Card> LinkedCards = new LinkedList<>();

    public void addCard(Card card){
        LinkedCards.addLast(card);
    }

    public void popCard(){
        LinkedCards.pop();
    }

    public boolean isEmpty(){
        return LinkedCards.isEmpty();
    }

    public Card takeCard(){
        return LinkedCards.remove();
    }

    public LinkedList<Card> getLinkedCards() {
        return LinkedCards;
    }

}

