package Model.Controller;

import Model.Model.*;

public class SolitareMain {


    private CardPile[] cardPiles;


    public static void main(String[] args) {
        SolitareMain main = new SolitareMain();
        main.setup();
    }

    public void setup(){
        cardPiles = new CardPile[13];
        //GamePile
        for (int i = 0; i < 7 ; i++) {
            // Der skal laves kontruktør til GamePile
            cardPiles[i] = new GamePile();
        }

        //SuitPile
        for (int i = 7; i < 11; i++) {
            cardPiles[i] = new SuitPile();

        }

        //DiscardPile
        cardPiles[11] = new DiscardPile();

        //DeckPile
        cardPiles[12] = new DeckPile();
    }

    



}
