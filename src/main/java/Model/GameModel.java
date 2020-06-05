package Model;

public class GameModel {

    public CardPile[] cardPiles;

    public GameModel(){
        cardPiles = new CardPile[]{
                new GamePile(),
                new GamePile(),
                new GamePile(),
                new GamePile(),
                new GamePile(),
                new GamePile(),
                new GamePile(),
                new SuitPile(),
                new SuitPile(),
                new SuitPile(),
                new SuitPile(),
                DeckPile.getInstance(),
                DiscardPile.getInstance()
        };
    }
}

