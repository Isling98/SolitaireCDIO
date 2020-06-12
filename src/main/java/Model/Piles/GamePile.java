package Model.Piles;

import Model.Card;
import Model.Piles.CardPile;

import java.util.LinkedList;

public class GamePile extends CardPile {




    @Override
    public boolean canTake(Card card) {
        if (isEmpty()){
            return card.getValue() == 12; // Checks if card is a king if the pile is empty
        }
        return false;
    }


    @Override
    public Card backCard() {
        Card TempCard = null;
        for (Card linkedCard : linkedCards) {
            if (linkedCard.isFaceup()) {
                TempCard = linkedCard;
            }
        }
        return TempCard;
    }

    @Override
    public LinkedList<Card> popAllFaceUp() {
        LinkedList<Card> tempList = new LinkedList<>();

        for (int i = 0; i < linkedCards.size(); i++) {
            if (linkedCards.get(i).isFaceup()){
                tempList.addLast(linkedCards.remove(i));
            }
            else if (!linkedCards.get(i).isFaceup()){
                break;
            }
        }
        return tempList;
    }

    @Override
    public String printPile() {
        return  "GamePile: " + super.printPile();
    }
}
