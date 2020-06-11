package Model;

import Model.Piles.CardPile;
import Simulation.SimGame;
import Util.Observer;


import java.util.Observable;

import java.util.Scanner;

public class AlgorithmSolitare extends Observer {

    //SKAL SLETTES
    int antalMetode8 = 0;

    public AlgorithmSolitare(SimGame simGame){
        this.simGame = simGame;
        this.simGame.attach(this);
    }


    CardPile[] cardPiles;
    Scanner scanner = new Scanner(System.in);

    public void setCardPiles(CardPile[] cardPiles) {
        this.cardPiles = cardPiles;
    }

    public  CardPile[] startAlgorithm(CardPile[] cardPiles){
        this.cardPiles = cardPiles;
        printGame();
        return firstPrio();
    }


    public  CardPile[] firstPrio()   {

   /*     System.out.println("\nPress ENTER to make next move:");
        scanner.nextLine();*/
        //Hvis deckpile er tomt skal discardpilen flyttes over
        if (cardPiles[11].isEmpty()){

            for (int i = 1; i < cardPiles[12].getSize(); i++) {
                cardPiles[11].addCard(cardPiles[12].popCard());
            }
        }

        for (int i = 7; i <= 10; i++) {
            while (cardPiles[11].getSize() == 24) {
                if (cardPiles[i].getSize() == 0) {
                    cardPiles[12].addCard(cardPiles[11].popCard());
                    System.out.println("Metode 1. Træk et kort fra bunken.");
                    antalMetode8 = 0;
                    printGame();
                    return cardPiles;
                }
            }
        }
        return secondPrio();
    }


    public  CardPile[] secondPrio()  {

            for (int i = 7; i < 11; i++) {
                for (int j = 0; j < 7; j++) {
                    if (cardPiles[i].canTake(cardPiles[j].top())) {
                        cardPiles[i].addCard(cardPiles[j].popCard());
                        System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
                        antalMetode8 = 0;
                        printGame();
                        return cardPiles;
                    }
                }
            }
        return thirdPrio();
    }


    public  CardPile[] thirdPrio()  {

            for (int i = 0; i <= 6; i++) {
                if (!cardPiles[i].isEmpty()) {
                    if (cardPiles[i].top().getValue() == 13 && cardPiles[i].getSize() > 1) {
                        for (int j = 0; j < 7; j++) {
                            if (cardPiles[j].isEmpty()) {
                                cardPiles[j].addCard(cardPiles[i].popCard());
                                System.out.println("Metode 3. Flyt " + cardPiles[j].top() + "(kongen) til det tomme felt.");
                                antalMetode8 = 0;
                                printGame();
                                return cardPiles;
                            }
                        }
                    }
                }
            }

        return fourthPrio();
        }

//GENTJEKKE DENNE FORDI DET ER LIDT SVÆRT AT FINDE UD AF HVORDAN MAN SAMMENLIGNER ALLE PILES FOR AT FINNDE DEN MED FLEST FACEDOWN
    public CardPile[] fourthPrio() {

            for (int i = 0; i < 7; i++) {
                if (!cardPiles[i].isEmpty()) {
                    for (int j = 0; j <= 6; j++) {
                        if (!cardPiles[j].isEmpty()){
                        if (cardPiles[i].faceDownAmount() > cardPiles[j].faceDownAmount()) {
                            if (cardPiles[i].getLowestAvailable().getValue() == cardPiles[j].getLowestAvailable().getValue() - 1 &&
                                    cardPiles[i].getLowestAvailable().getColor() != cardPiles[j].getLowestAvailable().getColor()) {
                                System.out.println("Metode 4. Flyt bunken med " + cardPiles[i].getLowestAvailable() + " til " +
                                        "bunken med " + cardPiles[j].top() + ".");
                                cardPiles[j].addPile(cardPiles[i].linkedCards);
                                antalMetode8 = 0;
                                printGame();
                                return cardPiles;
                            }
                        }
                        }
                    }
                }
            }
        return seventhPrio();
        }



/* Denne er mere eller mindre sat sammen med priority 2.
    public void fifthPrio() {
        if (discardPile.contains(suitPile.getValue + 1)){
            suitPile.add(popCard().getValue());
        }
        for (int i = 0; i <= gamePile[i]; i++){
            if (gamePile.getLast == suitPile.getValue + 1){
                suitPile.add(popCard().getValue());
            }
        }
    }
    */


    /*public CardPile[] sixthPrio() {


            for (int a = 7; a < 11; a++) {
                if (cardPiles[a].isEmpty()) {
                    for (int i = 0; i < cardPiles[11].getSize(); i++) {
                        cardPiles[12].addCard(cardPiles[11].popCard());
                        if (cardPiles[12].top().getValue() == 0) {
                            for (int j = 7; j <= 10; j++) {
                                if (cardPiles[j].canTake(cardPiles[12].top())) {
                                    cardPiles[j].addCard(cardPiles[12].popCard());

                                   for (int k = 0; k <= cardPiles[12].getSize(); k++) {
                                        cardPiles[11].addCard(cardPiles[12].popCard());

                                    }

                                    System.out.println("Metode 6. Træk indtil der kommer et es" +
                                                        " og derefter flyt " + cardPiles[j].top() + " til suitPile." +
                                                        " Tilsidst 'shuffles' alle kort tilbage til dækket.");

                                    return cardPiles;
                                }
                            }
                        }
                    }
                }
            }
            return seventhPrio();
    }*/


    public  CardPile[] seventhPrio()  {
            for (int i = 0; i < 7; i++) {
                if (cardPiles[12].isEmpty()){
                    cardPiles[12].addCard(cardPiles[11].popCard());
                }
                if (!cardPiles[i].isEmpty()) {
                    if (cardPiles[12].top().getValue() == cardPiles[i].top().getValue() - 1 && cardPiles[12].top().getColor() != cardPiles[i].top().getColor()) {
                        cardPiles[i].addCard(cardPiles[12].popCard());
                        System.out.println("Metode 7. Flyt " + cardPiles[i].top() + " til tilsvarende bunke.");
                        antalMetode8 = 0;
                        printGame();
                        return cardPiles;
                    }
                }
            }
             return eighthPrio();
    }


    public  CardPile[] eighthPrio()  {
        try {
            antalMetode8++;
            if (antalMetode8 >24){
                System.out.println("ØV");
                System.exit(0);
            }
            cardPiles[12].addCard(cardPiles[11].popCard());
            System.out.println("Metode 8. Træk et kort fra dækket.");
            printGame();
            return  cardPiles;
        } catch (Exception e){
            System.out.println(e + " LEALAELRTAEWTGA");
            System.exit(0);
        }
        return null;

    }







    @Override
    public void update() {
        this.setCardPiles(simGame.getCardPiles());
        System.out.println("Noget er sket");
        simGame.setCardPiles(firstPrio());
    }


    public void printGame(){
        for (CardPile cardPile : cardPiles) {
            System.out.println(cardPile.printPile());
        }
    }
}
