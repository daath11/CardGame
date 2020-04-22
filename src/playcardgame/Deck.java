package playcardgame;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck implements Serializable {
    private Stack<Card> deck;

    public Deck (List<Card> cards) {
        for (Card pc: cards) {
            deck.push(pc);
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void sort() {
        Collections.sort(deck);
    }

   public void display() {
       for (Card pc: deck) {
           System.out.print(pc.toString());
       }
   }


}
