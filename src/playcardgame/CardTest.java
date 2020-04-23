package playcardgame;

public class CardTest {
    public static void main(String[] args){
        Dealer dealer = new Dealer(4);
        dealer.deal();
        dealer.evaluateHandsRank();
        dealer.display();

    }
}
