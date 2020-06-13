package Model.Piles;

import Model.Card;
import Model.Piles.CardPile;

public class SuitPile extends CardPile {



    boolean isFinished = false;

    // Method that checks if card is allowed to be placed
    @Override
    public boolean canTake(Card card) {
        // If the pile is empty only allow aces

        if (card == null){
            return false;
        } else if (card.isFaceup()) {
            if (isEmpty()) {
                return card.getValue() == 0;
            }
            // Checks if the card is same suit and one value above the current top.
            else {
                return card.getSuit() == top().getSuit() && card.getValue() - 1 == top().getValue();
            }
        } else return false;
    }

    @Override
    public String printPile() {
        return  "SuitPile: " + super.printPile();
    }


}
