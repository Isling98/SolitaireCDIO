package Model;

import Model.Piles.*;

import java.util.ArrayList;
import java.util.Collections;

public class GameModel {

    private CardPile[] cardPiles = new CardPile[13];


    public GameModel(){
           //Inserting all cards and shuffeling
        // Deck and Discard pile 11, 12

        //GamePiles 0...6
        for (int i = 0; i < 7; i++) {
            cardPiles[i] = new GamePile();
            }
        //SuitPile 7,8,9,10
        for (int i = 0; i < 4; i++) {
            cardPiles[i + 7] =  new SuitPile();
        }

        cardPiles[11] = new DeckPile();
        cardPiles[12] = new DiscardPile();
    }

    public CardPile[] getCardPiles() {
        return cardPiles;
    }

    public void setCardPiles(CardPile[] cardPiles) {
        this.cardPiles = cardPiles;
    }
}
