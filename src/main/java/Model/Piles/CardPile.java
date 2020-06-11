package Model.Piles;

import Model.Card;

import java.util.EmptyStackException;
import java.util.LinkedList;

public abstract class CardPile {

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
            if (linkedCards.size()> 0){
                linkedCards.getFirst().flipCard();
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
        if (backCard().getValue() == 13 && cardPile == null){
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


    public int faceUpAmount(){
        int counter = 0;
        for (int i = 0; i < linkedCards.size(); i++) {
            if (linkedCards.get(i).isFaceup()){
                counter++;
            }
        }
        return counter;
    }

    // Sometimes overridden

    public void addCard(Card card){
        linkedCards.push(card);
    }


    public LinkedList<Card> popAllFaceUp(){
        return null;
    }



    public void addPile(LinkedList<Card> pile){
        linkedCards.addAll(pile);
    }

    public void select (){ ;
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

