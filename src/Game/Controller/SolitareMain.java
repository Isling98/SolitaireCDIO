package Game.Controller;

import Game.Model.*;

public class SolitareMain {


    private CardPile[] cardPiles;

    public void setup(){
        cardPiles = new CardPile[13];

        for (int i = 0; i < 7 ; i++) {
            // Der skal laves kontruktør til GamePile
            cardPiles[i] = new GamePile();
        }

        for (int i = 7; i < 11; i++) {
            cardPiles[i] = new SuitPile();

        }
        cardPiles[11] = new DiscardPile();

        cardPiles[12] = new DeckPile();

    }

    public static void main(String[] args) {
        SolitareMain main = new SolitareMain();
        main.setup();
    }

}
