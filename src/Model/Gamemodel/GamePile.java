package Model.Gamemodel;

public class GamePile extends  CardPile{

    private Card topCard;

    public GamePile(Card topCard) {
        this.topCard = topCard;
    }

    public GamePile() {}

    public Card getTopCard() {
        return topCard;
    }
}
