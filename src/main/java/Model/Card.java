package Model;

import View.GuiController;

import java.io.IOException;

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

    public Card(){
        value = 0;
        suit =0 ;

    }

    public void setCard(Card card){
        this.value = card.getValue();
        this.suit = card.getSuit();
    }

    public void getAndFlip() throws IOException {
        if (!faceup) {
            this.setCard(GuiController.pc.getSingleCard());
            faceup = true;
        }
    }
    public void flip()  {
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

    public boolean canItStack(Card card) {
        if (card == null) return false;
        return ((getValue() == card.getValue() - 1 && getColor() != card.getColor()));
    }


    @Override
    public String toString() {
        if (!isFaceup()) {
            return "fd";
        }
        else return
                valueToString(value)+suitToString(suit);
    }

    public String suitToString (int value){
        String returnMe ="";
        switch (value){
            case 0: returnMe = "s"; break;
            case 1: returnMe = "c"; break;
            case 2: returnMe = "h"; break;
            case 3: returnMe = "d"; break;
        }
        return returnMe;
    }

    public String valueToString(int value) {
        String returnMe = "";

        switch (value) {
            case 0:
                returnMe = "a";
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
                returnMe = "t";
                break;
            case 10:
                returnMe = "j";
                break;
            case 11:
                returnMe = "q";
                break;
            case 12:
                returnMe = "k";
                break;
        }
        return returnMe;
    }
}