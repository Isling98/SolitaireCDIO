package Simulation;

import Model.*;
import Model.Piles.*;
import Util.Observer;

import java.util.*;

public class SimGame  {

    public CardPile[] cardPiles = new CardPile[13];

    private List<Observer> observers = new ArrayList<Observer>();


    public CardPile[] getCardPiles() {
        return cardPiles;
    }

    public void setCardPiles(CardPile[] cardPiles){
        this.cardPiles = cardPiles;
        notifyUpdate();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }
    public void notifyUpdate(){
        for (Observer observer: observers){
            observer.update();
        }
    }

    public SimGame(){
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

        //SuitPile 7,8,9,10
        for (int i = 0; i < 4; i++) {
            cardPiles[i + 7] =  new SuitPile();
        }

        cardPiles[11] = new DeckPile();
        cardPiles[12] = new DiscardPile();


        int remainder = startDeck.size();
        for (int i = 0; i < remainder; i++) {
            cardPiles[11].addCard(startDeck.remove(0));
        }


        /*//Flipping the last card in the game piles
        for (int i = 0; i < 7; i++) {
            if (!cardPiles[i].linkedCards.isEmpty()) {
                {
                    cardPiles[i].linkedCards.getFirst().flipCard();
                }
            }
        }*/
    }

    private ArrayList<Card> initDeck(ArrayList<Card> deck){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(j, i);
                deck.add(card);
            }
        }
        Collections.shuffle(deck);

        return deck;
    }
}
