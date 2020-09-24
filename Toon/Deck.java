import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck
 */
class Deck implements Comparable<Deck>{
    enum Suits {Space, Diamond, Heart , Club}
    enum Number {One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen}
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
        /* Deck deck = new Deck(Deck.Number.Eight,Deck.Suits.Space);
        Deck deck1 = new Deck(Deck.Number.Eight,Deck.Suits.Club);
        Deck deck2 = new Deck(Deck.Number.Eight,Deck.Suits.Diamond);
        Deck deck3 = new Deck(Deck.Number.Eight,Deck.Suits.Heart);
        List<Deck> list = new ArrayList<>();
        list.add(deck);
        list.add(deck1);
        list.add(deck2);
        list.add(deck3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list); */
        SinglyLinkist list = new SinglyLinkist();
        Deck d8d = new Deck(Deck.Number.Eight, Deck.Suits.Diamond);
        Deck d2s = new Deck(Deck.Number.Two, Deck.Suits.Space);
        Deck d2d = new Deck(Deck.Number.Two, Deck.Suits.Diamond);
        Deck d4c = new Deck(Deck.Number.Eight, Deck.Suits.Club);

        list.add(d8d);
        list.add(d2s);
        list.add(d2d);
        list.add(d4c);

        list.show();
        
    }


    @Override
    public int compareTo(Deck o) {
        // TODO Auto-generated method stub
        if(this.number.compareTo(o.number)==0)   
            return this.suits.compareTo(o.suits);
        else return this.number.compareTo(o.number);
    }
    Node sorted;
    @Override
    public String toString() {
        return "Deck [number=" + number + ", suits=" + suits + "]\n";
    }

    
    
    
}
