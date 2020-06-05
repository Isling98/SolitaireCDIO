package Model;

import java.util.LinkedList;
import java.util.List;

public class DeckPile extends CardPile {


    private static final DeckPile SINGLE_Deckpile = new DeckPile();


    public static DeckPile getInstance(){
        return SINGLE_Deckpile;
    }

        @Override
        public void select() {
            System.out.println("Test");

                if (!LinkedCards.isEmpty()){
                    top().flipCard();
                    DiscardPile.getInstance().addCard(popCard());
                }


            /*
            Der  skal også laves en metode således at hvis deckpile er tom så bliver DiscardPile lavet om til DeckPile
            */


        }

}
