package Model;

import Model.Piles.CardPile;
import Simulation.SimGame;

public class AlgorithmSolitare {

    CardPile[] cardPiles2;

    public AlgorithmSolitare() {
        SimGame simGame = new SimGame();
        cardPiles2 = simGame.cardPiles;
    }

    public static void main(String[] args) {
        AlgorithmSolitare algoher = new AlgorithmSolitare();
        algoher.firstPrio();
    }

    public void firstPrio() {
        System.out.println("Metode 1");
        if (cardPiles2[11].isEmpty()){
            for (int i = 0; i <= cardPiles2[12].getSize(); i++) {
                cardPiles2[11].addCard(cardPiles2[12].popCard());
            }
        }
        for (int i = 7; i <= 10; i++) {
            while (cardPiles2[11].getSize() == 24) {
                if (cardPiles2[i].getSize() == 0) {
                    cardPiles2[12].addCard(cardPiles2[11].popCard());
                    secondPrio();
                }
            }
            secondPrio();
        }
    }


    public void secondPrio() {
        System.out.println("Metode 2");
        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 7; i <= 10; i++) {
                for (int j = 0; j < 6; j++) {
                    if (cardPiles2[i].canTake(cardPiles2[j].top())) {
                        cardPiles2[i].addCard(cardPiles2[j].popCard());
                        cardMoved = true;
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
        System.out.println("Metode 3");
        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 0; i <= 6; i++) {
                if (cardPiles2[i].top().getValue() == 13 && cardPiles2[i].getSize() > 1) {
                    for (int j = 0; j <= 6; j++) {
                        if (cardPiles2[j].isEmpty()) {
                            cardPiles2[j].addCard(cardPiles2[i].popCard());
                            cardMoved = true;
                            firstPrio();
                        }
                    }
                }
            }
            /*if (!cardMoved){
                fourthPrio();
            }*/
        }
    }


   /* public void fourthPrio() {
        for (int i = 0; i <= 6; i++) {

        }

        int size = 0;
        int antalUkendt = 0;
        for (int i = 0; i <= gamePile[i]; i++){
            if (size < gamePile[i].size) {
                size = gamePile[i].size;
                if (gamePile[i].contains(faceDown)) {
                    for (int j = 0; j <= gamePile[j]; j++) {
                        if (gamePile[j].faceDown) {
                            antalUkendt++;
                            if (antalUkendt > gamePile[j+1].faceDown || antalUkendt > gamePile[j-1].facedown){
                                for (int k = 0; k <= gamePile[k]; k++){
                                    if (gamePile[j].firstCard == gamePile[k].getLast.getValue + 1 && gamePile[j].getSuit != gamePile[k].getSuit){
                                        gamePile[k].add(popCard().getValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //lav et loop der kører alle gamePiles igennem og finder den pile der er størst (flest elementer i sit array)
        //og har flest faceDown kort. Derefter tjek at denne kan flyttes til en anden gamePile ved først at køre
        //gamePiles igennem igen for at finde en 'matchende' gamePile og derefter
        //tjekke den nye piles sidste element/kort og se om det er modsat farven af den første piles sidste kort +
        // at tallet er en større end den første piles kort.
    }


    public void fifthPrio() {
        if (discardPile.contains(suitPile.getValue + 1)){
            suitPile.add(popCard().getValue());
        }
        for (int i = 0; i <= gamePile[i]; i++){
            if (gamePile.getLast == suitPile.getValue + 1){
                suitPile.add(popCard().getValue());
            }
        }
    }*/

    public void sixthPrio() {
        System.out.println("Metode 6");
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
                                    //Her skal måske 'shuffles' alle kort fra discard tilbage til decket igen.

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
        System.out.println("Metode 7");
        boolean cardMoved = false;
        while (!cardMoved) {
            for (int i = 0; i < 6; i++) {
                if (cardPiles2[12].top().getValue() == cardPiles2[i].top().getValue() - 1 && cardPiles2[12].top().getColor() != cardPiles2[i].top().getColor()) {
                    cardPiles2[i].addCard(cardPiles2[12].popCard());
                    cardMoved = true;

                    firstPrio();
                }
            }
            if (!cardMoved){
                eighthPrio();
            }
        }
    }


    public void eighthPrio() {
        System.out.println("Metode 8");
        cardPiles2[12].addCard(cardPiles2[11].popCard());

        firstPrio();
    }
}
