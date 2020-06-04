package Model;

public class GamePile extends  CardPile {





    public boolean canTake(Card card){
        if (isEmpty()){
            return card.getValue() == 12; // Checks if card is a king if the pile is empty
        }
        return false;
    }


}
