package Model;

import Model.*;
import Model.Piles.*;
import View.GuiController;

import java.io.IOException;
import java.util.*;

public class GameModel {

    String msg;
    public CardPile[] cardPiles = new CardPile[13];
    public CardPile[] getCardPiles() {
        return cardPiles;
    }
    public void setCardPiles(CardPile[] cardPiles){
        this.cardPiles = cardPiles;
    }


    public GameModel() throws IOException {
        ArrayList<Card> startDeck = new ArrayList<>();
        //Inserting all cards and shuffeling
        initDeck(startDeck);
        // Deck and Discard pile 11, 12

        //GamePiles 0...6
        for (int i = 0; i < 7; i++) {
            //
            cardPiles[i] = new GamePile();
            for (int j = 0; j <= i; j++) {
                cardPiles[i].addCard(startDeck.remove(0));
            }
        }
        cardPiles[7] = new DeckPile();
        cardPiles[8] = new DiscardPile();

        //SuitPile
        for (int i = 9; i < 13; i++) {
            cardPiles[i] =  new SuitPile();
        }


        int remainder = startDeck.size();
        for (int i = 0; i < remainder; i++) {
            cardPiles[7].addCard(startDeck.remove(0));
        }

        // Method to retreive one card
       /* Card card = GuiController.pc.getSingleCard();
        cardPiles[0].top().setCard(card.getValue(),card.getSuit());
        cardPiles[0].top().flipCard();*/


        Card[] startCards = GuiController.pc.getStartDeck();
        for (int i = 0; i < 7; i++) {
            if (!cardPiles[i].linkedCards.isEmpty()) {
                {
                    Card tempCard = startCards[i];
                    cardPiles[i].top().setCard(tempCard);
                    cardPiles[i].onlyFlip();
                }
            }
        }
    }


    private void initDeck(ArrayList<Card> deck){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card();
                deck.add(card);
            }
        }

    }

    @Override
    public String toString() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
