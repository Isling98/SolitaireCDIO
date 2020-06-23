package Model.Piles;

import Model.Card;
import Util.PythonConnector;

import java.io.IOException;

public class DiscardPile extends CardPile {

    public DiscardPile(PythonConnector pc) {
        super(pc);
    }

    @Override
    public void addCard(Card card) throws IOException {
        if (!card.isFaceup()){
            card.getAndFlip(pc);
        }
        super.addCard(card);
    }

    public void showTop() throws IOException {
        if (linkedCards.isEmpty()){
            return ;
        }
        linkedCards.getFirst().getAndFlip(pc);
    }


    @Override
    public String printPile() {
        return  "DiscardPile: " + super.printPile();
    }
}
