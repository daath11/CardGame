package playcardgame;

//import java.io.*;
import java.util.ArrayList;

public class DeckBuilder {
    private ArrayList<Card> cards;

    public DeckBuilder(){
        cards = new ArrayList<Card>();
        char[] suits = "HDCS".toCharArray();
        for(int i = 0; i<4; i++)
            for(int j =1; j<=13; j++){
                cards.add(new Card(suits[i],j,true));
            }
    }

    public ArrayList<Card> getCards(){
        return cards;
    }
}
