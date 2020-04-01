package Game.Model;

import javax.sound.sampled.Line;
import java.util.LinkedList;

public class DeckPile extends CardPile {

        LinkedList<Card> deckPopCard = new LinkedList<>();

        public LinkedList fjernTop() {
            /*
            Nedenstående kan nok laves lettere/pænere med et for-each loop
             */
            for (int i = 0; i < 3; i++) {
                deckPopCard.add(popCard());
                if (LinkedCards.size() == 2){
                    deckPopCard.add(popCard());
                    deckPopCard.add(popCard());
                }else if (LinkedCards.size() == 1){
                    deckPopCard.add(popCard());
                }else if (LinkedCards.isEmpty()){
                    LinkedCards.addAll(deckPopCard);
                    deckPopCard.removeAll(LinkedCards);
                }
            }
            return deckPopCard;
        }

}
