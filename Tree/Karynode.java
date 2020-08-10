package Tree;

public class Karynode {
    int k =4;
    private int item[];
    private Karynode child[];

    public Karynode(){
        item = new int[k-1];
        child = new Karynode[k];
        for (int i = 0; i < k-1; i++) {
            item[i] = -1;
        }
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getItem(int index) {
        return item[index];
    }

    public void setItem(int index, int newitem) {
        item[index] = newitem;
    }

    public Karynode getChild(int index) {
        return child[index];
    }

    public void setChild(int index, Karynode nextNode) {
        child[index] = nextNode;
    }

    
}