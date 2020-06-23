package Model.Piles;

import Model.Card;
import Util.PythonConnector;

import java.io.IOException;
import java.util.LinkedList;

public abstract class CardPile {

    PythonConnector pc;
    public CardPile(PythonConnector pc){
        this.pc = pc;
    }

    public LinkedList<Card> linkedCards = new LinkedList<Card>();

    public final Card top() {
        //Retrieves, but does not remove, the head (first element) of this list.
        return linkedCards.peek();
    }

    public boolean isEmpty(){
        return linkedCards.isEmpty();
    }

    //removes and returns the first element of this list
    public Card popCard(){
        try {

            Card tempcard = linkedCards.pop();
            if (linkedCards.size() > 0){
                linkedCards.getFirst().getAndFlip(pc);
            }

            return tempcard;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;}
    }

    public void getAndFlip() throws IOException {
        if (linkedCards.size() > 0) {
            this.top().getAndFlip(pc);
        }
    }
    public void onlyFlip()  {
        if (linkedCards.size() > 0) {
            this.top().flip();
        }
    }



    public Card pollLastCard(){
        try {

            Card tempcard = linkedCards.pollLast();
            if (linkedCards.size()> 0){
                linkedCards.getFirst().getAndFlip(pc);
            }

            return tempcard;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;}


    }
    public int getSize (){
        return linkedCards.size();
    }

    public boolean canItStack(CardPile cardPile){
        try{
        if (backCard().getValue() == 12 && cardPile == null){
            return  true;
        }
        else return backCard().getValue() == cardPile.top().getValue() - 1 && backCard().getColor() != cardPile.top().getColor();
        }catch (NullPointerException e){
            return false;
        }

    }

    public int faceDownAmount(){
        int counter = 0;
        for (Card linkedCard : linkedCards) {
            if (!linkedCard.isFaceup()) {
                counter++;
            }
        }
        return counter;
    }


    // Sometimes overridden

    public void addCard(Card card) throws IOException {
        linkedCards.push(card);
    }


    public LinkedList<Card> popAllFaceUp() throws IOException {
        return null;
    }


    public void addPile(LinkedList<Card> pile){
        for(int i = pile.size() - 1; i >= 0; i--) {
            linkedCards.add(0, pile.get(i));
        }

    }

    public Card backCard(){
        return null;
    }


    public boolean canTake (Card card) {return false;}


    public String printPile() {
        if (!linkedCards.isEmpty()) {

            return linkedCards.toString();
        }
        else return "empty";
    }


}

