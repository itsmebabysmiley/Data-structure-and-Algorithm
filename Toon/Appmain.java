public class Appmain {
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
        list.show(list.head);
        System.out.println();
        list.insertionSort(list.head);
        System.out.println("After  sort:");
        list.show(list.head);
    }
}
