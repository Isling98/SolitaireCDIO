package Model;

import java.util.LinkedList;

public class DiscardPile extends CardPile {



    public void addCards(LinkedList<Card> list){
        LinkedCards.addAll(list);
    }

    public void showTop(){
        getLinkedCards().getFirst().flipCard();
    }
}
