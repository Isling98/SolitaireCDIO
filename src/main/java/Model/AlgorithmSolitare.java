package Model;

import Model.Piles.CardPile;
import Simulation.SimGame;
import java.util.Scanner;

public class AlgorithmSolitare {

    CardPile[] cardPiles;
    Scanner scanner = new Scanner(System.in);

    public AlgorithmSolitare(CardPile[] cardPiles) {
            this.cardPiles = cardPiles;
    }


    public void firstPrio() {
        System.out.println("\nPress ENTER to make next move:");
        scanner.nextLine();

        if (cardPiles[11].isEmpty()){
            for (int i = 0; i <= cardPiles[12].getSize(); i++) {
                cardPiles[11].addCard(cardPiles[12].popCard());
            }
        }

        for (int i = 7; i <= 10; i++) {
            while (cardPiles[11].getSize() == 24) {
                if (cardPiles[i].getSize() == 0) {
                    cardPiles[12].addCard(cardPiles[11].popCard());

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
                    if (cardPiles[i].canTake(cardPiles[j].top())) {
                        cardPiles[i].addCard(cardPiles[j].popCard());
                        cardMoved = true;
                        System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
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
                if (cardPiles[i].top().getValue() == 13 && cardPiles[i].getSize() > 1) {
                    for (int j = 0; j <= 6; j++) {
                        if (cardPiles[j].isEmpty()) {
                            cardPiles[j].addCard(cardPiles[i].popCard());
                            cardMoved = true;
                            System.out.println("Metode 3. Flyt " + cardPiles[j].top() + "(kongen) til det tomme felt.");
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
                if (!cardPiles[a].isEmpty()) {
                    for (int i = 0; i <= cardPiles[11].getSize(); i++) {
                        cardPiles[12].addCard(cardPiles[11].popCard());
                        if (cardPiles[12].top().getValue() == 0) {
                            for (int j = 7; j <= 10; j++) {
                                if (cardPiles[j].canTake(cardPiles[12].top())) {
                                    cardPiles[j].addCard(cardPiles[12].popCard());
                                    cardMoved = true;

                                    for (int k = 0; k <= cardPiles[12].getSize(); k++) {
                                        cardPiles[11].addCard(cardPiles[12].popCard());
                                    }

                                    System.out.println("Metode 6. Træk indtil der kommer et es" +
                                                        " og derefter flyt " + cardPiles[j].top() + " til suitPile." +
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
                if (cardPiles[12].top().getValue() == cardPiles[i].top().getValue() - 1 && cardPiles[12].top().getColor() != cardPiles[i].top().getColor()) {
                    cardPiles[i].addCard(cardPiles[12].popCard());
                    cardMoved = true;

                    System.out.println("Metode 7. Flyt " + cardPiles[i].top() + " til tilsvarende bunke.");

                    firstPrio();
                }
            }
            if (!cardMoved){
                eighthPrio();
            }
        }
    }


    public void eighthPrio() {

        cardPiles[12].addCard(cardPiles[11].popCard());

        System.out.println("Metode 8. Træk et kort fra dækket.");

        firstPrio();
    }
}
