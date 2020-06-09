package Controller.Algorithm;

import Model.CardPile;
import Simulation.SimGame;

public class ALGOHER {

    CardPile[] cardPiles2;

    public ALGOHER() {
        SimGame simGame = new SimGame();
        cardPiles2 = simGame.setup();
    }

    public static void main(String[] args) {
        ALGOHER algoher = new ALGOHER();
        algoher.firstPrio();
    }

    public void firstPrio() {
        System.out.println("Metode 1");
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
    }

    public void sixthPrio() {
        for (int i = 0; i <= deckPile; i++){
            if(deckPile[i].getValue == Card.getValue(1)){
                suitPile.add(deckPile[i]);
                //Refresh deckPile her til sidst
            }
        }
    }

    public void seventhPrio() {
        for (int i = 0; i <= gamePile[i]; i++){
            if (gamePile[i].lastCard > discardPile.lastCard && gamePile[i].getSuit != discardPile.getSuit){
                gamePile[i].add(discardPile.popCard());
            }
        }

        //Få fat i det sidste/'øverste' kort i discardPile og tjek om det kan benyttes på en gamePile ved at gå alle
        //gamePiles igennem og tjek deres sidste kort. Hvis kortet fra discardPile er modsat farven af den gamepilens
        //sidste kort og at tallet er mindre end kortet fra gamePilen, så kan der flyttes.
    }

    public void eighthPrio() {
        fjernTop();
    }*/
}
