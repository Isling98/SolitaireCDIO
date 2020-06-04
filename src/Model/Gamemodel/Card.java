package Model.Gamemodel;

public class Card {


    // 1 = es, 2 = 2... 11 = knægt 12 = dronning 13 = konge
    private int value;
    private int suit;
    private static int spade = 0;
    private static int club =  1;
    private static int heart =  2;
    private static int diamond =  3;

    private int color; // 0 = sort , 1 = rød
    boolean faceup = false;


    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;

        if (getSuit() == spade || getSuit() == club){
            color = 0;
        }
        else if (getSuit() == heart || getSuit() == diamond){
            color = 1;
        }
    }

    public void flipCard(){
        if(!faceup){
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

    public boolean isFaceup()    {
        return faceup;
    }
}
