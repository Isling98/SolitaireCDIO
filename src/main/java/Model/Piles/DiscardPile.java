package Model.Piles;

import Model.Card;

public class DiscardPile extends CardPile {

    @Override
    public void addCard(Card card) {
        if (!card.isFaceup()){
            card.flipCard();
        }
        super.addCard(card);
    }

    public void showTop(){
        if (linkedCards.isEmpty()){
            return ;
        }
        linkedCards.getFirst().flipCard();
    }
}
