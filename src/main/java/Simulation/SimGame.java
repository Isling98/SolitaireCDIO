package Simulation;

import Model.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SimGame {
    CardPile[] cardPiles = new CardPile[13];

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

        //GamePiles
        for (int i = 0; i < 7; i++) {
            //
            cardPiles[i] = new GamePile(i + 1);
            for (int j = 0; j <= i; j++) {
                cardPiles[i].addCard(allCards.remove(0));
            }
        }

        //SuitPile 7,8,9,10
        for (int i = 7; i < 11; i++) {
            cardPiles[i] = new SuitPile();
        }

        //DiscardPile
        cardPiles[11] = new DiscardPile();

        //DeckPile
        cardPiles[12] = new DeckPile();

        int remainder = allCards.size();
        for (int i = 0; i < remainder; i++) {
            cardPiles[12].addCard(allCards.remove(0));
        }


        //Flipping the last card in the game piles
        for (int i = 0; i <7 ; i++) {
            if (!cardPiles[i].getLinkedCards().isEmpty()){{
                cardPiles[i].getLinkedCards().getLast().flipCard();
            }}
        }


      /*
      for (CardPile pile: cardPiles){
            System.out.println(pile.printPile());
        }*/
    }
}
