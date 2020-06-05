package Simulation;

import Model.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SimGame {

    CardPile[] cardPiles = new CardPile[13];
    GameModel gameModel = new GameModel();


    public void setup() {

        //Inserting all cards and shuffeling
        ArrayList<Card> allCards = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                Card card = new Card(j, i);
                allCards.add(card);
            }
        }
        Collections.shuffle(allCards);


        // Deck and Discard pile 11, 12



        //GamePiles 0...6
        for (int i = 0; i < 7; i++) {
            //
            cardPiles[i] = new GamePile();
            for (int j = 0; j <= i; j++) {
                cardPiles[i].addCard(allCards.remove(0));
            }
        }

        //SuitPile 7,8,9,10
        for (int i = 0; i < 4; i++) {
            cardPiles[i + 7] =  new SuitPile();
        }

        cardPiles[11] = DeckPile.getInstance();
        cardPiles[12] = DiscardPile.getInstance();


        int remainder = allCards.size();
        for (int i = 0; i < remainder; i++) {
            cardPiles[11].addCard(allCards.remove(0));
        }


        //Flipping the last card in the game piles
        for (int i = 0; i < 7; i++) {
            if (!cardPiles[i].LinkedCards.isEmpty()) {
                {
                    cardPiles[i].LinkedCards.getFirst().flipCard();
                }
            }
        }

        for (CardPile cardPile : cardPiles) {
            System.out.println(cardPile.LinkedCards);
        }


        cardPiles[11].select();
        cardPiles[11].select();
        cardPiles[11].select();
        cardPiles[11].select();


        for (CardPile cardPile : cardPiles) {
            System.out.println(cardPile.LinkedCards);
        }
    }
}
