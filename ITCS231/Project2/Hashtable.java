class Hashtable {
    private Item[] hasharray;
    private Item item;
    private int size;
    Hashtable(int i) {
        hasharray = new Item[i];
        this.size = i;
    }

    public void insert(String word) {
        int index = hashfunc(word);
        item  = new Item(word);
        //hasharray[index] = item;
        while (hasharray[index] != null) {
            ++index; // go to next cell
            index %= size; // wraparound if necessary
        }
        hasharray[index] = item; // insert item
    }
    
    private boolean isFull() {
        return false;
    }

    public int hashfunc(String word) {
        //convert word to number
        int _length = word.length()-1;
        int value = 0;  //maybe out of range int
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int ch_int = (int) ch - 'a' + 1;
            //int x = ch_int * (int) Math.pow(27, _length);
            value += ch_int * Math.pow(27,_length--);
        }
        return value % this.size;
    }

    
    public void display() {
        for (int i = 0; i < size; i++) {
            if(hasharray[i] != null)
                System.out.println("index: " + i + " " + hasharray[i].toString());
            else 
                System.out.println("index: " + i + " -");
        }

    }
}

class Hashapp {

    public static void main(String[] args) {
        int size = 14*2;
        Hashtable h = new Hashtable(size);
        //System.out.println(h.hashfunc("cats"));
        
        h.insert("gate");
        h.insert("ice");
        h.insert("court");
        h.insert("yard");
        h.insert("hat");
        h.insert("praise");
        h.insert("mark");
        h.insert("courage");
        h.insert("ear");
        h.insert("east");
        h.insert("wheel");
        h.insert("advice");
        h.insert("day");
        h.insert("clock");
        h.display();

    }
}
class Item{
    public String data;

    Item(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}