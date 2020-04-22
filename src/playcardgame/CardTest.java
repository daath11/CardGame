package playcardgame;

public class CardTest {
    public static void main(String[] args){
        DeckBuilder db = new DeckBuilder();
        Deck mazzo = new Deck(db.getCards());

        mazzo.display();

    }
}
