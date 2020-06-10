package Model;

public class Card {


    // 0 = es, 1 = 1, 2 = 2... 11 = knægt 12 = dronning 13 = konge
    private int value;
    private int suit;

    private int color; // 0 = sort , 1 = rød
    boolean faceup;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
        faceup = false;

        if (getSuit() == 0 || getSuit() == 1) {
            color = 0;
        } else if (getSuit() == 2 || getSuit() == 3) {
            color = 1;
        }
    }

    public void flipCard() {
        if (!faceup) {
            faceup = true;
        }
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    public int getColor() {
        return color;
    }

    public boolean isFaceup() {
        return faceup;
    }

    @Override
    public String toString() {
        if (!isFaceup()) {
            return "FD";
        }
        else return
                suitToString(suit)+ " "+
                valueToString(value);
    }

    public String suitToString (int value){
        String returnMe =" ";
        switch (value){
            case 0: returnMe = " Spade"; break;
            case 1: returnMe = " Club"; break;
            case 2: returnMe = " Hearts"; break;
            case 3: returnMe = " Diamond"; break;
        }
        return returnMe;
    }

    public String valueToString(int value) {
        String returnMe = "";

        switch (value) {
            case 0:
                returnMe = "Ace";
                break;
            case 1:
                returnMe = "2";
                break;
            case 2:
                returnMe = "3";
                break;
            case 3:
                returnMe = "4";
                break;
            case 4:
                returnMe = "5";
                break;
            case 5:
                returnMe = "6";
                break;
            case 6:
                returnMe = "7";
                break;
            case 7:
                returnMe = "8";
                break;
            case 8:
                returnMe = "9";
                break;
            case 9:
                returnMe = "10";
                break;
            case 10:
                returnMe = "Jack";
                break;
            case 11:
                returnMe = "Queen";
                break;
            case 12:
                returnMe = "King";
                break;
        }
        return returnMe;
    }
}