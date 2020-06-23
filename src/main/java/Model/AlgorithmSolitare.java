package Model;

import Model.Piles.CardPile;

import java.io.IOException;

public class AlgorithmSolitare  {
    int newCardCounter = 0;
    int moveTracker = 0;


    GameModel model;
    CardPile[] cardPiles;

    public AlgorithmSolitare(GameModel model) throws IOException {
    this.model = model;
    }



    public GameModel nextMove(CardPile[] cardPiles) throws IOException {
        this.cardPiles = cardPiles;
        moveTracker ++;

        if(moveToSuitPile() != null){ //
            model.setCardPiles(cardPiles);
        }
        else if (movePile() != null){
           model.setCardPiles(cardPiles);
        }
        else if (discardToGame() != null){
            model.setCardPiles(cardPiles);
        }
        else if (deckpileEmpty() != null){ //
            model.setCardPiles(cardPiles);
        }
        else if(checkGameOver()){ //
            model.setCardPiles(cardPiles);
        }
        else {
            model.setCardPiles(newCardFromDeck()); //
        }

        if (checkGameWon()){
            model.setCardPiles(cardPiles);
        }
    //    printGame();
        return model;
    }

    public boolean checkGameWon(){

        //Tjekker om suitPiles er fulde og spillet er vundet

        int counter = 0;
        for (int i = 9; i < 13; i++) {
            if (cardPiles[i].getSize() == 13){
                counter++;
                if (counter == 4){
                    model.setGameWon(true);
                    return true;
                }
            }
        }
        return false;
    }

    public CardPile[] deckpileEmpty() throws IOException {
        //Hvis deckpile er tomt skal discardpilen flyttes over
        if (cardPiles[7].isEmpty() && cardPiles[8].getSize() >1){
            while(!cardPiles[8].isEmpty()){
                cardPiles[7].addCard(cardPiles[8].popCard());
            }
          //  System.out.println("deckPileEmpty()");
            return cardPiles;
        }
        return null;
    }

    public   CardPile[] moveToSuitPile() throws IOException {
        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if (cardPiles[i].canTake(cardPiles[j].top())) {
                    cardPiles[i].addCard(cardPiles[j].popCard());
               //     System.out.println("moveToSuitPile()");
                 // System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
            if (cardPiles[i].canTake(cardPiles[8].top())) {
                cardPiles[i].addCard(cardPiles[8].popCard());
          //      System.out.println("moveToSuitPile()");
                newCardCounter = 0;
                return cardPiles;
            }
        }
        return null;
    }

    public CardPile[] movePile() throws IOException {
        for(int i = 0; i < 7; i++) {
            Card backCard = cardPiles[i].backCard();
                for (int j = 0; j < 7; j++) {
                    if (i == j || backCard == null){ continue;}
                    if (backCard.canItStack(cardPiles[j].top()) || (backCard.getValue() == 12 && cardPiles[j].isEmpty() && cardPiles[i].faceDownAmount() > 0)) {
                        cardPiles[j].addPile(cardPiles[i].popAllFaceUp());
            //            System.out.println("movePile()");
                        newCardCounter = 0;
                        return cardPiles;
                    }
                }
        }
        return null;
    }

    public  CardPile[] discardToGame() throws IOException {
        if (cardPiles[8].isEmpty()){
            return null;
        }
        for (int i = 0; i < 7; i++) {
            if (cardPiles[i].isEmpty()) {
                if (cardPiles[8].top().getValue() == 12) {
                    cardPiles[i].addCard(cardPiles[8].popCard());
           //         System.out.println("discardToGame()");
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
            if (!cardPiles[i].isEmpty()){
                if (cardPiles[8].top().getValue() == cardPiles[i].top().getValue() - 1
                        && cardPiles[8].top().getColor() != cardPiles[i].top().getColor()) {
                        cardPiles[i].addCard(cardPiles[8].popCard());
           //             System.out.println("discardToGame()");

                    newCardCounter = 0;
                    return cardPiles;
                }
            }
        }
        return null;
    }

    public boolean checkGameOver(){
        newCardCounter++;
        if (newCardCounter > 25){//  cardPiles[7].getSize() + cardPiles[8].getSize()) {
      //      System.out.println("checkGameOver()");
          //  System.out.println("Antal træk: " + moveTracker);
         //   System.exit(0);
            model.setGameLost(true);
            return true;
        }

        return false;
    }

    public  CardPile[] newCardFromDeck() throws IOException {
        if (!cardPiles[7].isEmpty()) {
            cardPiles[8].addCard(cardPiles[7].popCard());
      //      System.out.println("newCardFromDeck()");
        }
        return cardPiles;
    }

    public void printGame(){
        for (CardPile cardPile : cardPiles) {
            System.out.println(cardPile.printPile());
        }
    }
}
