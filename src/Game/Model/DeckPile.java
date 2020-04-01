package Game.Model;

import java.util.LinkedList;

public class DeckPile extends CardPile{

    LinkedList<Card> deckPopCard = new LinkedList<>();

    public LinkedList fjernTop() {
        for (int i = 0; i < 3; i++) {
            //popCard();
            deckPopCard.add(popCard());
        }
        return deckPopCard;
    }
}
