package playcardgame;

import java.util.ArrayList;

public class Dealer {
    private int playersAmount;

    private Deck deck;
    private ArrayList<Player> players;


    public Dealer(int playersAmount){
        this.playersAmount = playersAmount;
        deck = new Deck((new DeckBuilder().getCards()));
        deck.shuffle();
        players = new ArrayList<Player>();
        for(int i = 1; i <=playersAmount; i++)
            players.add(new Player("Player"+i));
    }

    public void display(){
        for (Player player : players) {
            player.display();
        }
    }

    public void deal() {
        for (int i = 0; i < playersAmount; i++) {
            for (int j = 0; j < Player.handSize; j++)
                players.get(i).add(deck.Draw());
        }
    }

    public void evaluateHandsRank(){
        for (int i = 0; i < playersAmount; i++)
            players.get(i).evaluateHandRank();
    }
}
