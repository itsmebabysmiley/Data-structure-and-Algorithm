package Tree;

public class Treenode {

    protected int item;
    protected Treenode lChild;
    protected Treenode rChild;
    //default constructor.
    public Treenode(int newItem ){
        item = newItem;
        lChild = null;
        rChild = null;
    }
    /**
     * Create tree with child.
     */
    public Treenode(int item, Treenode lChild, Treenode rChild) {
        this.item = item;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Treenode getlChild() {
        return lChild;
    }

    public void setlChild(Treenode lChild) {
        this.lChild = lChild;
    }

    public Treenode getrChild() {
        return rChild;
    }

    public void setrChild(Treenode rChild) {
        this.rChild = rChild;
    }

    

    

}