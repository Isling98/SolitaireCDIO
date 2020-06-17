package Model.Piles;

import Model.Card;

import java.io.IOException;

public class DiscardPile extends CardPile {

    @Override
    public void addCard(Card card) throws IOException {
        if (!card.isFaceup()){
            card.getAndFlip();
        }
        super.addCard(card);
    }

    public void showTop() throws IOException {
        if (linkedCards.isEmpty()){
            return ;
        }
        linkedCards.getFirst().getAndFlip();
    }


    @Override
    public String printPile() {
        return  "DiscardPile: " + super.printPile();
    }
}
