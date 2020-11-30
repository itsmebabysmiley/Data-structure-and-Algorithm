/**
 * Nopparat Pengsuk
 * Section 2
 * 6288103
 */
class Hashtable {
    private Item[] hasharray;
    private Item item;
    private int size;
    Hashtable(int i) {
        hasharray = new Item[i];
        this.size = i;
    }
    /**
     * if tablehash is not full.
     * do insert by linear prob.
     */
    public void insert(String word) {
        if(isFull()){
            System.out.println("Hash is full.");
            return;
        }
        int index = hashfunc(word);
        item  = new Item(word);
        //hasharray[index] = item;
        while (hasharray[index] != null) {
            ++index; // go to next cell
            index %= size; // wraparound if necessary
        }
        hasharray[index] = item; // insert item
    }
    
    public boolean isFull() {
        for(int i = 0; i<hasharray.length; i++){
            if(hasharray[i] == null){
                return false;
            }
        }
        return true;
    }
    /**
     * convert word to number. theb find index by use number mod with table size.
     * @param word
     * @return index
     */
    public int hashfunc(String word) {
        /*convert word to number*/
        int _length = word.length()-1;
        int value = 0;  //maybe out of range int
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            int ch_int = (int) ch - 'a' + 1;
            //int x = ch_int * (int) Math.pow(27, _length);
            value += ch_int * Math.pow(26,_length--);
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
