package Model;

import java.util.LinkedList;
import java.util.List;

public class DeckPile extends CardPile {


        public LinkedList<Card> fjernTop() {
            LinkedList<Card> deckPopCard = new LinkedList<Card>();
            for (int i = 0; i < 3; i++) {
                if (!LinkedCards.isEmpty()){
                    deckPopCard.add(popCard());
                }
            }
            /*
            Der  skal også laves en metode således at hvis deckpile er tom så bliver DiscardPile lavet om til DeckPile
            */

            return deckPopCard;
        }

}
