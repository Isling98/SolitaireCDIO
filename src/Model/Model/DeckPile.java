package Model.Model;

import java.util.LinkedList;

public class DeckPile extends CardPile {



        public LinkedList fjernTop() {
            LinkedList<Card> deckPopCard = new LinkedList<>();
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

            /*
            Kan det ikke laves sådan her?
            for (int i = 0; i < 3; i++) {
                if (!LinkedCards.isEmpty()){
                    deckPopCard.add(popCard());
                }
            }

            Der  skal også laves en metode således at hvis deckpile er tom så bliver DiscardPile lavet om til DeckPile
            */
            
            
            
            
            return deckPopCard;
        }

}
