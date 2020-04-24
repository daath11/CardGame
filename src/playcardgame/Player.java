package playcardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Player {
    private static final String[] handRanks= {
            "High Card",
            "Pair",
            "Double Pair",
            "Three of a kind",
            "Straight",
            "Flush",
            "Full house",
            "Four of a kind",
            "Straight flush"
    };
    public static final int handSize = 5;



    private ArrayList<Card> hand;
    private String name;
    private int[] cardCounter;
    private int[] suitCounter;
    private boolean[] handFlags;
    private int points;
    private boolean lose;
    private String handRank;
    int lowCount = 0;
    int highCount= 0;
    boolean low;
    public Player(String name) {
        hand = new ArrayList<Card>();
        this.name = name;
        cardCounter = new int[13];
        handFlags = new boolean[8];
        suitCounter = new int[4];
        lose = false;
        handRank = handRanks[0];
        low = true;
    }

    public Player (String name, ArrayList<Card> hand){
        this(name);
        this.hand.addAll(hand);
    }

    public String handToString() {
        String s="";
        for (Card c:hand) {
            s +=c.toString();
        }
        return s;
    }

    public void display(){
        System.out.format("\n-----------------------------------------------------------------" +
                "\n%s:" +
                "\n%s" +
                // '  '+ handFlags[0]+' '+handFlags[1]+' '+handFlags[2]+' '+handFlags[3]+' '+handFlags[4]+' '+handFlags[5]+' '+handFlags[6]+' '+handFlags[7]+
                "\n%s",name,handToString(),handRank);
    }
    public void add(Card card){
        hand.add(card);
    }

    public void evaluateHandRank(){
        Collections.sort(hand);

        Arrays.fill(cardCounter,0);
        Arrays.fill(suitCounter,0);
        Arrays.fill(handFlags, false);
        handRank = handRanks[0];

        for (int i=0; i<hand.size(); i++){
            Card currentCard = hand.get(i);
            cardCounter[currentCard.getValue()-1]++;
            suitCounter[currentCard.getSuitValue()]++;
        }
        for (int i=0; i<4;i++) {
            if (suitCounter[i] == handSize) {
                handFlags[4] = true; // flush
            }
        }
        int pairCount =0;
        for (int i = 0; i < cardCounter.length; i++) {

            if(cardCounter[i] == 2)
                pairCount++;
            if(cardCounter[i] == 3)
                handFlags[2] = true;// three of a kind
            if(cardCounter[i] == 4)
                handFlags[6] = true;// four of a kind
        }
        if(pairCount != 0)
            handFlags[pairCount-1] = true; //pair and double pair
        handFlags[5] = (handFlags[0] && handFlags[2]); //full house


        int consecutive = 1;
        for (int i=0; i< handSize-1; i++){
            if(hand.get(0).getValue() == 1 && hand.get(4).getValue() ==13) {
                consecutive++;
                low = false;
            }
            else if(hand.get(i).getValue() == hand.get(i+1).getValue()-1)
                consecutive++;
        }
        handFlags[3] = (consecutive == 5);

        handFlags[7] = handFlags[4] && handFlags[3];

        for (int i=handFlags.length-1; i>= 0; i--){
            if(handFlags[i])
                handRank = handRanks[i+1];
        }
    }
}
