package playcardgame;

public class Card implements Comparable<Card> {

    public static final char SPADES = '\u2660';
    public static final char CLUBS = '\u2663';
    public static final char HEARTS = '\u2665';
    public static final char DIAMONS = '\u2666';

    private char suit;
    private char glyph;
    private SUIT suitValue;
    private int value;
    private boolean face; //T: coperta; F: scoperta

    private enum SUIT{
        HEARTS(0), DIAMONS(1), CLUBS(2), SPADES(3);
        private final int suitCode;

        private SUIT(int suitCode) {
            this.suitCode = suitCode;
        }

        public int getSuitCode() {
            return suitCode;
        }
        public char toChar(){
            char sc = ' ';
            switch (suitCode) {
                case 0: sc = 'H'; break;
                case 1: sc = 'D'; break;
                case 2: sc = 'C'; break;
                case 3: sc = 'S'; break;
            }
            return sc;
        }
    }

    public Card(char suit, int value, boolean face) {
        this.suit = suit;
        this.value = value;
        this.face = face;

        switch(suit) {
            case 'H': glyph = HEARTS; break;
            case 'D': glyph = DIAMONS; break;
            case 'C': glyph = CLUBS; break;
            case 'S': glyph = SPADES; break;
        }
    }

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceDown() {
        return face;
    }

    public void flipFace(boolean face) {
        this.face = !face;
    }

    @Override
    public int compareTo(Card c) {
        if (this.equals(c))
            return 0;
        if (this.value != c.value)
            return (this.value - c.value);
        else return (this.suitValue.getSuitCode() - c.suitValue.getSuitCode());
    }

    @Override
    public String toString() {
        return " "+value+glyph;
    }
}
