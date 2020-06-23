package Model.Piles;

import Model.Card;
import Util.PythonConnector;

import java.io.IOException;
import java.util.LinkedList;

public class GamePile extends CardPile {


    public GamePile(PythonConnector pc) {
        super(pc);
    }

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
    public LinkedList<Card> popAllFaceUp() throws IOException {
        LinkedList<Card> tempList = new LinkedList<>();
        while (linkedCards.size() > 0 && this.top().isFaceup()) {
            tempList.addLast(linkedCards.pop());
        }
        this.getAndFlip();
        return tempList;
    }

    @Override
    public String printPile() {
        return  "GamePile: " + super.printPile();
    }
}
