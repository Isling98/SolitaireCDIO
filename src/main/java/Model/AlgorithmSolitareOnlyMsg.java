package Model;

import Model.Piles.CardPile;

import java.io.IOException;

public class AlgorithmSolitareOnlyMsg {
    int newCardCounter = 0;
    int moveTracker = 0;
    String msg = "";


    GameModel model;
    CardPile[] cardPiles;

    public AlgorithmSolitareOnlyMsg(GameModel model) {
    this.model = model;
    }



    public GameModel nextMsg(CardPile[] cardPiles) {
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

    private boolean checkGameWon(){

        //Tjekker om suitPiles er fulde og spillet er vundet

        int counter = 0;
        for (int i = 9; i < 13; i++) {
            if (cardPiles[i].getSize() == 13){
                counter++;
                if (counter == 4){
                    return true;

                }
            }
        }
        return false;
    }

    private CardPile[] deckpileEmpty() {
        //Hvis deckpile er tomt skal discardpilen flyttes over
        if (cardPiles[7].isEmpty() && cardPiles[8].getSize() >1){
            return cardPiles;
        }
        return null;
    }

    private   CardPile[] moveToSuitPile() {
        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if (cardPiles[i].canTake(cardPiles[j].top())) {
                    // System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
            if (cardPiles[i].canTake(cardPiles[8].top())) {
                newCardCounter = 0;
                return cardPiles;
            }
        }
        return null;
    }

    private CardPile[] movePile() {
        for(int i = 0; i < 7; i++) {
            Card backCard = cardPiles[i].backCard();
                for (int j = 0; j < 7; j++) {
                    if (i == j || backCard == null){ continue;}
                    if (backCard.canItStack(cardPiles[j].top()) || (backCard.getValue() == 12 && cardPiles[j].isEmpty() && cardPiles[i].faceDownAmount() > 0)) {
                        newCardCounter = 0;
                        return cardPiles;
                    }
                }
        }
        return null;
    }

    private  CardPile[] discardToGame() {
        if (cardPiles[8].isEmpty()){
            return null;
        }
        for (int i = 0; i < 7; i++) {
            if (cardPiles[i].isEmpty()) {
                if (cardPiles[8].top().getValue() == 12) {
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
            if (!cardPiles[i].isEmpty()){
                if (cardPiles[8].top().getValue() == cardPiles[i].top().getValue() - 1
                        && cardPiles[8].top().getColor() != cardPiles[i].top().getColor()) {
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
        }
        return null;
    }

    private boolean checkGameOver(){
        newCardCounter++;
        if (newCardCounter > 25){//  cardPiles[7].getSize() + cardPiles[8].getSize()) {
            return true;
        }
        return false;
    }

    private  CardPile[] newCardFromDeck() {
        if (!cardPiles[7].isEmpty()) {
        }
        return cardPiles;
    }
}
