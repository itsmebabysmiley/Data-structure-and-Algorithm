package Tree;

public class BinaryTree {
    Treenode root;
    Treenode newNode;
    Treenode parent;
    Treenode Nodedelete;
    char child;
    int countlevel;

    public boolean isEmpty() {
        return root == null;
    }
    /**
     * if tree is empty add new item to root,
     * otherwise add new item in child.
     * @param newItem
     * @return root.
     */
    public Treenode insert(int newItem) {
        if(isEmpty()){
            newNode = new Treenode(newItem);
            root = newNode;
        }else{
            insertitem(root, newItem);
        }
        return root;
    }
    /**
     * if new item is less than child in node that means new item has to be left side of tree. if left child is null means no child at left side tree so add new item at left side child. and set referces left and right are null.
     * if there are already have left child move to next left subtree.
     * same algorithm if new item is more than child. go through right side of tree.
     * @param bst is tree node.
     * @param newItem
     */
    private void insertitem(Treenode bst, int newItem) {
        if(newItem < bst.item){ // new item less than child go left.
            if(bst.lChild == null){ //no child create new child
                newNode = new Treenode(newItem);
                bst.lChild = newNode; //set data portion with newItem
            }else //left child already exists.
                insertitem(bst.lChild, newItem);//move to next left subtree till left chile is null.
        }else{ //new item more than child. go right.
            if(bst.rChild == null){//no right child. create new one.
                newNode = new Treenode(newItem);
                bst.rChild = newNode; //set portion with new item.
            }else   
                insertitem(bst.rChild, newItem);//move to next right subtree.
        }
    }

    public void search(Treenode bst, int key) {
        if(key == bst.item){
            Nodedelete = bst;
        }else if(key < bst.item){
            parent = bst;
            child = 'l';
            search(bst.lChild, key);
        }else{
            parent = bst;
            child = 'r';
            search(bst.rChild, key);
        }
    }
    //search node with inorefer successor.
    //it's hard to understand. i know.
    public void inordersuccessor(Treenode bst) {
        if(bst.lChild != null){
            parent = bst;
            ++countlevel;
            inordersuccessor(bst.lChild);
        }else{
            Nodedelete.item = bst.item;
            if(countlevel == 0){
                Nodedelete.rChild = null;
            }else{
                parent.lChild = null;
            }
        }
    }
    //this shit is absolutely not human codeing.
    public void delete(int key) {
        if(isEmpty()){
            System.out.println("Tree is empty.");
        }else{
            parent = root;
            Nodedelete = null;
            search(root,key);
            Treenode lchild = Nodedelete.lChild;
            Treenode rchild = Nodedelete.rChild;
            if(lchild == null && rchild == null){
                //target is leaf node.
                if(child == 'l'){
                    parent.lChild = null;
                }else{
                    parent.rChild = null;
                }
            }else if(lchild != null && rchild != null){
                //target has 2 childs node.
                countlevel = 0;
                inordersuccessor(Nodedelete.rChild);
            }else{
                //target has only 1 child node.
                if(Nodedelete.lChild != null){
                    if(child == 'l'){
                        parent.lChild = Nodedelete.lChild;
                    }else{
                        parent.rChild = Nodedelete.lChild;
                    }
                }else{
                    if(child == 'l'){
                        parent.lChild = Nodedelete.rChild;
                    }else{
                        parent.rChild = Nodedelete.rChild;
                    }
                }
            }
        }
    }
    /**
     * node -> left -> right
     * @param rootnode
     */
    public void preOder(Treenode rootnode) {
        if(rootnode != null){
            System.out.print(rootnode.item+" ");
            preOder(rootnode.lChild);
            preOder(rootnode.rChild);
        }
    }
    /**
     * left -> node -> right
     * @param rootnode
     */
    public void inorder(Treenode rootnode) {
        if(rootnode != null){
            inorder(rootnode.lChild);
            System.out.print(rootnode.item+" ");
            inorder(rootnode.rChild);
        }
    }
    /**
     * left -> right -> node
     * @param rootnode
     */
    public void postorder(Treenode rootnode) {
        if(rootnode != null){
            postorder(rootnode.lChild);
            postorder(rootnode.rChild);
            System.out.print(rootnode.item+" ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Treenode root;
        root = tree.insert(60);
        tree.insert(20);
        tree.insert(10);
        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(70);
        System.out.print("Preorder: ");
        tree.preOder(root);
        // tree.delete(20);
        // System.out.println("delete 20");
        System.out.print("Preorder: ");
        tree.preOder(root);
        System.out.print("\nInorder: ");
        tree.inorder(root);
        System.out.print("\nPostorder: ");
        tree.postorder(root);
    }


}