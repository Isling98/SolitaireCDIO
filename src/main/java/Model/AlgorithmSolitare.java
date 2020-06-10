package Model;

import Model.Piles.CardPile;
import Simulation.SimGame;
import java.util.Scanner;

public class AlgorithmSolitare {

    CardPile[] cardPiles2;
    Scanner scanner = new Scanner(System.in);

    public AlgorithmSolitare() {
        SimGame simGame = new SimGame();
        cardPiles2 = simGame.cardPiles;
    }

    public static void main(String[] args) {
        AlgorithmSolitare algoher = new AlgorithmSolitare();
        algoher.firstPrio();
    }

    public void firstPrio() {
        System.out.println("\nPress ENTER to make next move:");
        scanner.nextLine();

        if (cardPiles2[11].isEmpty()){
            for (int i = 0; i <= cardPiles2[12].getSize(); i++) {
                cardPiles2[11].addCard(cardPiles2[12].popCard());
            }
        }

        for (int i = 7; i <= 10; i++) {
            while (cardPiles2[11].getSize() == 24) {
                if (cardPiles2[i].getSize() == 0) {
                    cardPiles2[12].addCard(cardPiles2[11].popCard());

                    System.out.println("Metode 1. Træk et kort fra bunken.");

                    firstPrio();
                }
            }
            secondPrio();
        }
    }


    public void secondPrio() {

        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 7; i <= 10; i++) {
                for (int j = 0; j < 6; j++) {
                    if (cardPiles2[i].canTake(cardPiles2[j].top())) {
                        cardPiles2[i].addCard(cardPiles2[j].popCard());
                        cardMoved = true;

                        System.out.println("Metode 2. Flyt " + cardPiles2[i].top() + " til suitPile.");

                        firstPrio();
                    }
                }
            }
            if (!cardMoved) {
                thirdPrio();
            }
        }
    }


    public void thirdPrio() {

        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 0; i <= 6; i++) {
                if (cardPiles2[i].top().getValue() == 13 && cardPiles2[i].getSize() > 1) {
                    for (int j = 0; j <= 6; j++) {
                        if (cardPiles2[j].isEmpty()) {
                            cardPiles2[j].addCard(cardPiles2[i].popCard());
                            cardMoved = true;

                            System.out.println("Metode 3. Flyt " + cardPiles2[j].top() + "(kongen) til det tomme felt.");

                            firstPrio();
                        }
                    }
                }
            }
            if (!cardMoved){
                //fourthPrio();
                sixthPrio();
            }
        }
    }


    /*public void fourthPrio() {
        int sizeUkendt = 0;
        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 0; i <= 6; i++) {
                if (!cardPiles2[i].isEmpty()) {
                    for (int j = 0; j <= cardPiles2[i].getSize(); j++) {
                        if (!cardPiles2[i].linkedCards.get(j).isFaceup()) {
                            sizeUkendt = cardPiles2[i].getSize(faceup);
                            if (sizeUkendt > cardPiles2[i + 1].getSize().faceup || sizeUkendt > cardPiles2[i - 1].getSize().faceup) {
                                for (int k = 0; k < 6; k++) {
                                    if (cardPiles2[k].getLowestAvailable().getValue() == cardPiles2[i].getLowestAvailable().getValue() - 1 &&
                                            cardPiles2[k].getLowestAvailable().getColor() != cardPiles2[i].getLowestAvailable().getColor()) {
                                        cardPiles2[k].addPile(cardPiles2[i]);
                                        cardMoved = true;

                                        firstPrio();
                                    }
                                }
                            } else sizeUkendt = 0;
                        }
                    }
                }
            }
            if (!cardMoved){
                sixthPrio();
            }
        }
    }*/


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


    public void sixthPrio() {

        boolean cardMoved = false;
        while (!cardMoved) {
            for (int a = 7; a < 10; a++) {
                if (!cardPiles2[a].isEmpty()) {
                    for (int i = 0; i <= cardPiles2[11].getSize(); i++) {
                        cardPiles2[12].addCard(cardPiles2[11].popCard());
                        if (cardPiles2[12].top().getValue() == 0) {
                            for (int j = 7; j <= 10; j++) {
                                if (cardPiles2[j].canTake(cardPiles2[12].top())) {
                                    cardPiles2[j].addCard(cardPiles2[12].popCard());
                                    cardMoved = true;

                                    for (int k = 0; k <= cardPiles2[12].getSize(); k++) {
                                        cardPiles2[11].addCard(cardPiles2[12].popCard());
                                    }

                                    System.out.println("Metode 6. Træk indtil der kommer et es" +
                                                        " og derefter flyt " + cardPiles2[j].top() + " til suitPile." +
                                                        " Tilsidst 'shuffles' alle kort tilbage til dækket.");

                                    firstPrio();
                                }
                            }
                        }
                    }
                }
            }
            if (!cardMoved){
                seventhPrio();
            }
        }
    }


    public void seventhPrio() {

        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 0; i < 6; i++) {
                if (cardPiles2[12].top().getValue() == cardPiles2[i].top().getValue() - 1 && cardPiles2[12].top().getColor() != cardPiles2[i].top().getColor()) {
                    cardPiles2[i].addCard(cardPiles2[12].popCard());
                    cardMoved = true;

                    System.out.println("Metode 7. Flyt " + cardPiles2[i].top() + " til tilsvarende bunke.");

                    firstPrio();
                }
            }
            if (!cardMoved){
                eighthPrio();
            }
        }
    }


    public void eighthPrio() {

        cardPiles2[12].addCard(cardPiles2[11].popCard());

        System.out.println("Metode 8. Træk et kort fra dækket.");

        firstPrio();
    }
}
