package Model;

import java.util.LinkedList;

public abstract class CardPile {

    public String name = this.getClass().getSimpleName();

    protected LinkedList<Card> LinkedCards = new LinkedList<Card>();

    public void addCard(Card card){
        LinkedCards.addLast(card);
    }

    public Card popCard(){
        return LinkedCards.pop();
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


    public String printPile() {
        return LinkedCards.toString();
    }
}

