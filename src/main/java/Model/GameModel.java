package Model;

import Model.Piles.*;

import java.util.ArrayList;
import java.util.Collections;

public class GameModel {

    private CardPile[] cardPiles = new CardPile[13];


    public GameModel(){
           //Inserting all cards and shuffeling
        // Deck and Discard pile 11, 12

        //GamePiles
        for (int i = 0; i < 7; i++) {
            cardPiles[i] = new GamePile();
            }

        cardPiles[7] = new DeckPile();
        cardPiles[8] = new DiscardPile();

        //SuitPile
        for (int i = 9; i < 13; i++) {
            cardPiles[i] =  new SuitPile();
        }
    }

    public CardPile[] getCardPiles() {
        return cardPiles;
    }

    public void setCardPiles(CardPile[] cardPiles) {
        this.cardPiles = cardPiles;
    }
}
