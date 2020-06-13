package Model;

import Model.Piles.CardPile;
import Simulation.SimGame;
import Util.Observer;


import java.util.Scanner;

public class AlgorithmSolitare extends Observer {


    int formeget = 0;


    int træk = 0;

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
        return firstPrio();
    }

    // Tjekker at der er kort i deckpile ellers sætter den kort fra discard over
    // Hvad hvis der ikke er flere kort tilbage?
    public  CardPile[] firstPrio()   {
        printGame();

        System.out.println("\nPress ENTER to make next move:");
        scanner.nextLine();
        //Tjekker om suitPiles er fulde og spillet er vundet
        int counter = 0;
        for (int i = 9; i < 13; i++) {
            if (cardPiles[i].getSize() == 13){
                counter++;
                if (counter == 4){
                    System.out.println("Du har vundet bruv :)");
                    System.out.println("Antal træk: " + træk);
                }
            }
        }

        //Hvis deckpile er tomt skal discardpilen flyttes over
        if (cardPiles[7].isEmpty() && cardPiles[8].getSize() >1){
            while(!cardPiles[8].isEmpty()){
                cardPiles[7].addCard(cardPiles[8].pollLastCard());
            }
        }
        return flytTilSuit();
    }

    // Tjekker hvis kort fra Gamepile og deckpile kan sættes op i suitpile
    public  CardPile[] flytTilSuit()  {
        for (int i = 9; i < 13; i++) {
            for (int j = 0; j < 7; j++) {
                if (cardPiles[i].canTake(cardPiles[j].top())) {
                    cardPiles[i].addCard(cardPiles[j].popCard());
                    System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
                    formeget = 0;
                    return cardPiles;
                }
            }
            if (cardPiles[i].canTake(cardPiles[8].top())) {
                cardPiles[i].addCard(cardPiles[8].popCard());
                System.out.println("Metode 2. Flyt " + cardPiles[i].top() + " til suitPile.");
                formeget = 0;
                return cardPiles;
            }
        }
        return movePile();
    }


    // Flytter en pile til en anden pile
    /*  Tjek alle bunker
     Find bunke med flest faceup kort
    Flyt til enten tom plads (Hvis konge) eller oven på anden pile
    GENTJEKKE DENNE FORDI DET ER LIDT SVÆRT AT FINDE UD AF HVORDAN MAN SAMMENLIGNER ALLE PILES FOR AT FINNDE DEN MED FLEST FACEDOWN
    Hvis der er 2 eller flere bunker der kan flyttes til den samme position skal den længeste bunke flyttes.
    Hvis bunken kan flyttes til 2 forskellige positioner, flyttes den til den længeste. ellers den med mindst facedown.*/
    int tooMuch = 0;
    public CardPile[] flytEnBunke() {
        int highestStreak = 1;
        int selectedPile = 0;

        // Finder den pile med flest faceup kort
        for (int i = 0; i < 7; i++) {
            if (!cardPiles[i].isEmpty()){
                if (cardPiles[i].faceUpAmount() > highestStreak){
                    for (int j = 0; j < 7; j++) {
                         if (cardPiles[j] != null && cardPiles[i] != null) {
                             if (cardPiles[i].canItStack(cardPiles[j])) {
                                 selectedPile = i;
                                 highestStreak = cardPiles[i].faceUpAmount();
                             }
                         }
                    }
                }
            }
        }
        if (highestStreak < 2 ){
            return flytEnkeltKort();
        }

        // Hvis pilen starer på konge:
        if (cardPiles[selectedPile].backCard().getValue() == 12 && cardPiles[selectedPile].faceDownAmount() > 0){
            for (int i = 0; i < 7; i++) {
                if (cardPiles[i].isEmpty()){
                    cardPiles[i].addPile(cardPiles[selectedPile].popAllFaceUp());
                    System.out.println("Flytter konge / kongebunke");
                    return cardPiles;
                }
            }
        }

        int receiverStreak = 0;
        int recieverPile = 0;
        for (int i = 0; i < 7; i++) {
            if (!cardPiles[i].isEmpty()) {
                if (cardPiles[selectedPile].canItStack(cardPiles[i]) && cardPiles[i].faceUpAmount() > receiverStreak) {
                    recieverPile = i;
                    receiverStreak = cardPiles[i].faceUpAmount();
                }
            }
        }
        if (recieverPile > 0){
            cardPiles[recieverPile].addPile(cardPiles[selectedPile].popAllFaceUp());
            tooMuch++;
            if (tooMuch > 20){
                System.out.println("Too much");
                System.exit(0);


            }
            System.out.println("flytter bunke " + cardPiles[selectedPile].top().toString() + " til " + cardPiles[recieverPile].top().toString());
            return cardPiles;
        }

        return flytEnkeltKort();
    }

    public CardPile[] movePile() {
        for(int i = 0; i < 7; i++) {
            Card backCard = cardPiles[i].backCard();
                for (int j = 0; j < 7; j++) {
                    if (i == j || backCard == null) continue;
                    if (backCard.canItStack(cardPiles[j].top()) || (backCard.getValue() == 12 && cardPiles[j].isEmpty() && cardPiles[i].faceDownAmount() > 0)) {
                        cardPiles[j].addPile(cardPiles[i].popAllFaceUp());
                        System.out.println("moved pile " + i + " to " + j);
                        formeget = 0;
                        return cardPiles;
                    }

                }

        }
        return flytEnkeltKort();
    }


    public CardPile[] flytEnkeltKort(){
        for (int i = 0; i < 7 ; i++) {
            if (!cardPiles[i].isEmpty()){
                for (int j = 0; j < 7 ; j++) {
                    if (!cardPiles[j].isEmpty() || cardPiles[i].top().getValue() == 12) {
                        if (j != i) {
                            if (cardPiles[i].top().canItStack(cardPiles[j].top()) && cardPiles[i].faceUpAmount() <= cardPiles[j].faceUpAmount()) {
                                System.out.println("Metode 4: Kortet: " + cardPiles[i].top().toString() + " er flyttet fra bunke " + i + " til bunke " + j);
                                cardPiles[j].addCard(cardPiles[i].popCard());
                                formeget = 0;
                                return cardPiles;
                            }
                        }
                    }
                }
            }
        }
        return discardTilGame();
    }




    // Tjekker hvis kort fra deckpile/discard kan komme på gamepile plads
    // Mulighed for at finde den bedste list at tilføje et kort til.
    public  CardPile[] discardTilGame() {
        if (cardPiles[8].isEmpty()){
            return eighthPrio();
        }
        for (int i = 0; i < 7; i++) {
            if (cardPiles[i].isEmpty()) {
                if (cardPiles[8].top().getValue() == 12) {
                    cardPiles[i].addCard(cardPiles[8].popCard());
                    System.out.println("Metode 7. Flyt " + cardPiles[i].top() + " til tilsvarende bunke.");
                    formeget = 0;
                    return cardPiles;
                }
            }
            if (!cardPiles[i].isEmpty()){
                if (cardPiles[8].top().getValue() == cardPiles[i].top().getValue() - 1
                        && cardPiles[8].top().getColor() != cardPiles[i].top().getColor()) {
                    cardPiles[i].addCard(cardPiles[8].popCard());
                    System.out.println("Metode 7. Flyt " + cardPiles[i].top() + " til tilsvarende bunke.");
                    formeget = 0;
                    return cardPiles;
                }
            }
        }
        return eighthPrio();
    }



    public  CardPile[] eighthPrio()  {
        formeget ++;
        if (formeget > cardPiles[7].getSize()+ cardPiles[8].getSize()){
            System.out.println("Tabt");
            System.out.println("Antal træk: " + træk);
            System.exit(0);
        }
        cardPiles[8].addCard(cardPiles[7].popCard());
        System.out.println("Metode 8. Træk et kort fra dækket.");
        return  cardPiles;
    }


    @Override
    public void update() {
        System.out.println();
        System.out.println("YAKKA");
        træk++;
        this.setCardPiles(simGame.getCardPiles());
        simGame.setCardPiles(firstPrio());
    }


    public void printGame(){
        for (CardPile cardPile : cardPiles) {
            System.out.println(cardPile.printPile());
        }
    }
}
