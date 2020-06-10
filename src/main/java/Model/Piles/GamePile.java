package Model.Piles;

import Model.Card;
import Model.Piles.CardPile;

public class GamePile extends CardPile {




    @Override
    public boolean canTake(Card card) {
        if (isEmpty()){
            return card.getValue() == 12; // Checks if card is a king if the pile is empty
        }
        return false;
    }


    @Override
    public Card getLowestAvailable() {
        Card TempCard = null;
        for (Card linkedCard : linkedCards) {
            if (linkedCard.isFaceup()) {
                TempCard = linkedCard;
            }
        }
        return TempCard;
    }
}
