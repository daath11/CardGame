package playcardgame;

import java.util.ArrayList;
import java.util.Arrays;

public class CardTest {
    public static void main(String[] args){
        Dealer dealer = new Dealer(4);
        dealer.deal();
        dealer.evaluateHandsRank();
        dealer.display();
        /*Player p = new Player("TestScala",  new ArrayList<Card>( Arrays.asList(new Card('H',1,true),new Card('H',10,true),new Card('H',11,true),new Card('H',12,true),new Card('H',13,true))));
        p.evaluateHandRank();
        p.display();*/
    }
}
