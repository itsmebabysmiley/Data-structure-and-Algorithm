
class Deck implements Comparable<Deck> {
    // enum is like turple in python
    enum Suits {Club, Heart, Diamond, Space}
    enum Number {One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Eleven, Twelve, Thirteen}

    private Number number;
    private Suits suits;


    public Deck(Number number, Suits s) {
        this.number = number;
        this.suits = s;
    }

    
    @Override
    public int compareTo(Deck o) {
        // if number is equal then we compare with suit.
        if (this.number.compareTo(o.number) == 0)
            return this.suits.compareTo(o.suits);
        else
            return this.number.compareTo(o.number);
    }


    @Override
    public String toString() {
        StringBuffer string = new StringBuffer();
        switch (number) {
            case One:       string.append("A[" + suits + "], ");break;
            case Two:       string.append("2[" + suits + "] ");break;
            case Three:     string.append("3[" + suits + "] ");break;
            case Four:      string.append("4[" + suits + "] ");break;
            case Five:      string.append("5[" + suits + "] ");break;
            case Six:       string.append("6[" + suits + "] ");break;
            case Seven:     string.append("7[" + suits + "] ");break;
            case Eight:     string.append("8[" + suits + "] ");break;
            case Nine:      string.append("9[" + suits + "] "); break;
            case Ten:       string.append("10[" + suits + "] ");break;
            case Eleven:    string.append("J[" + suits + "] ");break;
            case Twelve:    string.append("Q[" + suits + "] ");break;
            case Thirteen:  string.append("K[" + suits +  "] ");break;
            default:
                break;
        }
        return string.toString();
    }
    public Number getNumber() {
        return number;
    }

    public Suits getSuits() {
        return suits;
    }

}
