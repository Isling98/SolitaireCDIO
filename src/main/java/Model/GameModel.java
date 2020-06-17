package Model;

import Model.Piles.*;

public class GameModel {


    private CardPile[] cardPiles = new CardPile[13];
    String msg;


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

    @Override
    public String toString() {
        return msg;
    }

    void setMsg(String msg){
        this.msg = msg;
    }
}
