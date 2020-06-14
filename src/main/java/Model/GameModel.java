package Model;

import Model.Piles.*;
import Util.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameModel {


    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }
    public void notifyUpdate(){
        for (Observer observer: observers){
            observer.update(); }
    }
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
