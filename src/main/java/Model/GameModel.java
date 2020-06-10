package Model;

import Model.Piles.*;

import java.util.ArrayList;
import java.util.Collections;

public class GameModel {

    private static final GameModel INSTANCE = new GameModel();
    private CardPile[] cardPiles = new CardPile[13];

    public Card[] getCardPiles(int index) {
        Card[] cards = new Card[cardPiles[index].getSize()];
        for(int i=0; i<cardPiles[index].getSize(); i++){
            cards[i] = cardPiles[index].popCard();
        }

        return cards;
    }

    public static GameModel getINSTANCE() {
        return INSTANCE;
    }
    //  CardPile DiscardPile = new DiscardPile();
 //   CardPile DeckPile = new DeckPile();

    public GameModel(){
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

        cardPiles[11] = DeckPile.getInstance();
        cardPiles[12] = DiscardPile.getInstance();

        int remainder = startDeck.size();
        for (int i = 0; i < remainder; i++) {
            cardPiles[11].addCard(startDeck.remove(0));
        }


        //Flipping the last card in the game piles
        for (int i = 0; i < 7; i++) {
            if (!cardPiles[i].linkedCards.isEmpty()) {
                {
                    cardPiles[i].linkedCards.getFirst().flipCard();
                }
            }
        }
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
