
class Deck implements Comparable<Deck> {
    enum Suits {
        Club, Heart, Diamond, Space
    }

    enum Number {
        One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Eleven, Twelve, Thirteen
    }

    private Number number;
    private Suits suits;
    SinglyLinkist sl;

    public Deck(Number number, Suits s) {
        this.number = number;
        this.suits = s;
    }

    public Number getNumber() {
        return number;
    }

    public Suits getSuits() {
        return suits;
    }

    public static void main(String[] args) {
        SinglyLinkist list = new SinglyLinkist();
        Deck dks = new Deck(Deck.Number.Thirteen, Deck.Suits.Space);
        Deck d3d = new Deck(Deck.Number.Three, Deck.Suits.Diamond);
        Deck d8h = new Deck(Deck.Number.Eight, Deck.Suits.Heart);
        Deck d7c = new Deck(Deck.Number.Seven, Deck.Suits.Club);
        Deck d2c = new Deck(Deck.Number.Two, Deck.Suits.Club);
        Deck d10h = new Deck(Deck.Number.Ten, Deck.Suits.Heart);
        Deck dqd = new Deck(Deck.Number.Twelve, Deck.Suits.Diamond);
        Deck d10d = new Deck(Deck.Number.Ten, Deck.Suits.Diamond);
        Deck d3s = new Deck(Deck.Number.Three, Deck.Suits.Space);

        list.add(dks);
        list.add(d3d);
        list.add(d8h);
        list.add(d7c);
        list.add(d2c);
        list.add(d10h);
        list.add(dqd);
        list.add(d10d);
        list.add(d3s);
        System.out.println("Before sort:");
        list.show();
        System.out.println();
        list.insertionSort(list.head);
        // System.out.print("After  sort:");
        //list.show();
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
            case One:
                string.append("A[" + suits + "], ");
                break;
            case Two:
                string.append("2[" + suits + "], ");
                break;
            case Three:
                string.append("3[" + suits + "], ");
                break;
            case Four:
                string.append("4[" + suits + "], ");
                break;
            case Five:
                string.append("5[" + suits + "], ");
                break;
            case Six:
                string.append("6[" + suits + "] ");
                break;
            case Seven:
                string.append("7[" + suits + "], ");
                break;
            case Eight:
                string.append("8[" + suits + "], ");
                break;
            case Nine:
                string.append("9[" + suits + "], ");
                break;
            case Ten:
                string.append("10[" + suits + "], ");
                break;
            case Eleven:
                string.append("J[" + suits + "], ");
                break;
            case Twelve:
                string.append("Q[" + suits + "], ");
                break;
            case Thirteen:
                string.append("K["+suits+"], ");
                break;
            default:
                break;
        }
        return string.toString();
    }

}
