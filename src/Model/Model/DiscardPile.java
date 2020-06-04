package Model.Model;

import java.util.LinkedList;

public class DiscardPile extends CardPile {

    void addCard(LinkedList<Card> list){
        LinkedCards.addAll(list);

        /*
        Her skal også køres så det øverste kort er 'synligt', og så skal der tjekkes, hvad der skal ske
        med kortet. Hvis det passer på en suit bunke, skal det flyttes derover, hvis det passer nede i en af game-
        bunkerne skal det derned og ellers skal det bare blive liggende.
         */
    }
}
