package Model;

import Model.Piles.CardPile;

public class AlgorithmSolitare  {
    int newCardCounter = 0;
    int moveTracker = 0;
    String msg = "";


    GameModel model = new GameModel();
    CardPile[] cardPiles;

    public GameModel nextMove(CardPile[] cardPiles){

        this.cardPiles = cardPiles;
       // printGame();
        moveTracker ++;
        if (checkGameWon()){
            model.setCardPiles(cardPiles);
        }
        else if (deckpileEmpty() != null){
            model.setCardPiles(cardPiles);
        }
        else if(moveToSuitPile() != null){
            model.setCardPiles(cardPiles);
        }
        else if (movePile() != null){
           model.setCardPiles(cardPiles);
        }
        else if (discardToGame() != null){
            model.setCardPiles(cardPiles);
        }
        else if(checkGameOver()){
            model.setCardPiles(cardPiles);
        }
        else {
            model.setCardPiles(newCardFromDeck());
        }
        model.setMsg(msg);
        return model;

    }

    private boolean checkGameWon(){
        int counter = 0;
        for (int i = 9; i < 13; i++) {
            if (cardPiles[i].getSize() == 13){
                counter++;
                if (counter == 4){
                    msg = "You won the game in: " + moveTracker + " moves.";
                    return true;

                }
            }
        }
        return false;
    }

    private CardPile[] deckpileEmpty()   {

        //Tjekker om suitPiles er fulde og spillet er vundet
        //Hvis deckpile er tomt skal discardpilen flyttes over
        if (cardPiles[7].isEmpty() && cardPiles[8].getSize() >1){
            while(!cardPiles[8].isEmpty()){
                cardPiles[7].addCard(cardPiles[8].pollLastCard());
            }
            msg = "Flip and move discardpile to deckpile";
            System.out.println("deckPileEmpty()");
            return cardPiles;
        }
        return null;
    }

    private   CardPile[] moveToSuitPile()  {
        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if (cardPiles[i].canTake(cardPiles[j].top())) {
                    cardPiles[i].addCard(cardPiles[j].popCard());
                    System.out.println("moveToSuitPile()");
                    msg = "Move " + cardPiles[i].top() + " to suitpile " + (i-8);
                 // System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
            if (cardPiles[i].canTake(cardPiles[8].top())) {
                cardPiles[i].addCard(cardPiles[8].popCard());
                System.out.println("moveToSuitPile()");
                msg = "Move " + cardPiles[i].top() + " to suitpile " + (i-8);
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
                    if (i == j || backCard == null) continue;
                    if (backCard.canItStack(cardPiles[j].top()) || (backCard.getValue() == 12 && cardPiles[j].isEmpty() && cardPiles[i].faceDownAmount() > 0)) {
                        cardPiles[j].addPile(cardPiles[i].popAllFaceUp());
                        msg = "move pile " + i + " to pile " + j;
                        System.out.println("movePile()");
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
                    cardPiles[i].addCard(cardPiles[8].popCard());
                    System.out.println("discardToGame()");
                    msg = "Move "  + cardPiles[i].top() + " to pile " + i;
                    newCardCounter = 0;
                    return cardPiles;
                }
            }
            if (!cardPiles[i].isEmpty()){
                if (cardPiles[8].top().getValue() == cardPiles[i].top().getValue() - 1
                        && cardPiles[8].top().getColor() != cardPiles[i].top().getColor()) {
                        cardPiles[i].addCard(cardPiles[8].popCard());
                        msg = "Move "  + cardPiles[i].top() + " to pile " + i;
                        System.out.println("discardToGame()");

                    newCardCounter = 0;
                    return cardPiles;
                }
            }
        }
        return null;
    }

    private boolean checkGameOver(){
        newCardCounter++;
        if (newCardCounter > cardPiles[7].getSize() + cardPiles[8].getSize()) {
            System.out.println("checkGameOver()");
            msg = "Game Over";
          //  System.out.println("Antal træk: " + moveTracker);
         //   System.exit(0);
            return true;
        }

        return false;
    }

    private  CardPile[] newCardFromDeck() {
        if (!cardPiles[7].isEmpty()) {
            cardPiles[8].addCard(cardPiles[7].popCard());
            System.out.println("newCardFromDeck()");
            msg = "Draw new card from the deckpile";

        }
        return cardPiles;
    }

    private void printGame(){
        for (CardPile cardPile : cardPiles) {
            System.out.println(cardPile.printPile());
        }
    }
}
