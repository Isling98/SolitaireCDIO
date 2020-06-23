package Model.Piles;

import Model.Card;
import Util.PythonConnector;

import java.util.EmptyStackException;

public class DeckPile extends CardPile {
    public DeckPile(PythonConnector pc) {
        super(pc);
    }

    // Kan ikke huske hvorfor dette blev indsat

    @Override
    public Card popCard(){
        try {
            return linkedCards.pop();
        }
        catch (EmptyStackException e) {
            System.out.println(e);
            return null;}
    }

    @Override
    public String printPile() {
        return  "DeckPile: " + super.printPile();
    }

    // Denne klasse kan muligvis være tom

/*
        @Override
        public Card select() {
                     if (!linkedCards.isEmpty()){
                    top().flipCard();
                    return popCard();
                }
            *//*
            Der  skal også laves en metode således at hvis deckpile er tom så bliver DiscardPile lavet om til DeckPile
            *//*
        }*/
}
