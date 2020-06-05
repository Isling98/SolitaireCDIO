package Model;

import java.util.LinkedList;

public class DiscardPile extends CardPile {

    private static final DiscardPile SINGLE_DiscardPile = new DiscardPile();

    public static DiscardPile getInstance(){
        return SINGLE_DiscardPile;
    }


    @Override
    public void addCard(Card card) {
        if (!card.isFaceup()){
            card.flipCard();
        }
        super.addCard(card);
    }

    public void showTop(){
        LinkedCards.getFirst().flipCard();
    }
}
