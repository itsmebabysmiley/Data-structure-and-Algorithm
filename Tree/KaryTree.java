package Tree;

public class KaryTree {
    Karynode root = new Karynode();;
    Karynode newNode;
    Karynode parent;
    Karynode nodedelete;
    Karynode nodechange;
    int indexparent;
    int indexdelete;
    int indexchange;
    int index;
    int k = root.getK()-1;;
    
    

    public boolean isEmpty() {
        return root.getItem(0) == -1;
    }
    /**
     * check item is empty or not.
     * @param node
     * @param newitem
     * @return
     */
    public int checkItem(Karynode node, int newitem){
        int indexfind;
        for (indexfind = 0; indexfind < k; indexfind++) {
            int item = node.getItem(indexfind);
            if(newitem < item || item == -1){
                break;
            }
        }
        return indexfind;
    }

    public void insertItem(Karynode node, int newitem) {
        index = checkItem(node, newitem);
        if(index != k && node.getItem(index) == -1){
            node.setItem(index, newitem);
        }else{
            if(node.getChild(index) == null){
                newNode = new Karynode();
                newNode.setItem(0, newitem);
                node.setChild(index, newNode);
            }else{
                insertItem(node.getChild(index), newitem);
            }
        }
    }

    public Karynode insert(int newitem){
        if(isEmpty()){
            newNode = new Karynode();
            newNode.setItem(0, newitem);
            root = newNode;
        }else{
            insertItem(root, newitem);
        }
        return root;
    }

    public void search(Karynode node, int index, int key) {
        if(index != k){
            if(key == node.getItem(index)){
                nodedelete = node;
                indexdelete = index;
            }else if(key < node.getItem(index)){
                parent = node;
                indexparent = index;
                node = node.getChild(index);
                if(node != null){
                    search(node, 0, key);
                }else{
                    nodedelete = null;
                }
            }else{
                search(node, index+=1, key);
            }
        }else{
            if(node.getChild(index) != null){
                parent = node;
                indexparent = index;
                search(node.getChild(index), 0, key);
            }
        }
    }

    public void inordersuccessor(Karynode node) {
        if(node.getChild(0) != null){
            parent = null;
            indexparent = 0;
            inordersuccessor(node.getChild(0));
        }else{
            nodechange = node;
        }
    }

    public void preordersuccessor(Karynode node) {
        if(node.getChild(0) != null){
            for (int i = k-1; i >= index; i--) {
                if(node.getItem(i) != -1){
                    if(node.getChild(i+1) != null){
                        parent = null;
                        indexparent = i;
                        preordersuccessor(node.getChild(i+1));
                    }
                }else{
                    nodechange = node;
                    indexchange = i;
                    break;
                }
            }
        }else{
            parent = node;
            indexparent = k;
            preordersuccessor(node.getChild(k));
        }
    }

    public void delete(Karynode node, int index) {
        int sibling = -1;
        Karynode lchild = node.getChild(index);
        Karynode rchlid = node.getChild(index+1);
        if(index != k-1){
            sibling = node.getItem(index+1);
        }
        if(lchild == null && rchlid == null && sibling == -1 &&indexdelete == 0){
            parent.setChild(indexparent,null);
        }else if(lchild == null && rchlid == null && sibling == -1){
            nodedelete.setItem(indexdelete, -1);
        }else if(lchild == null && rchlid == null && sibling != -1){
            for (int i = index; i < k-1; i++) {
                node.setItem(i, node.getItem(i+1));
                node.setChild(i, node.getChild(i+1));
            }
            if(node.getChild(k) != null){
                Karynode child = node.getChild(k);
                node.setItem(k-1, child.getItem(0));
                parent = node;
                indexparent = k;
                delete(child, 0);
            }else{
                node.setItem(k-1,-1);
            }
        }else{
            if(sibling == -1 && indexdelete == 0){
                parent.setChild(indexparent, nodechange.getChild(0));
            }else if(lchild != null){
                parent = node;
                indexparent = index;
                preordersuccessor(lchild);
                nodedelete.setItem(indexdelete, nodechange.getItem(indexchange));
                nodedelete = nodechange;
                indexdelete = indexchange;
                indexdelete = 0;
                delete(nodedelete, indexchange);
            }else{
                parent = node;
                indexparent = index;
                inordersuccessor(lchild);
                nodedelete.setItem(indexdelete, nodechange.getItem(0));
                nodedelete = nodechange;
                indexdelete = 0;
                delete(nodedelete, 0);
            }
        }
    }   

    public void deleteNode(int deleteitem){
        if(isEmpty()){
            System.out.println("empty");
        }else{
            parent = root;
            indexparent = 0;
            nodedelete = null;
            search(root, 0, deleteitem);
            if(nodedelete == null){
                System.out.println("not found");
            }else{
                delete(nodedelete, indexdelete);
            }
        }
    }
    public void preorder(Karynode rootnode) {
        int count;
        if(rootnode != null){
            for(count = 0; count < k; count++){
                if(rootnode.getItem(count) != -1){
                    System.out.print(rootnode.getItem(count)+" ");
                }
                preorder(rootnode.getChild(count));
            }
            preorder(rootnode.getChild(count));
        }
    }
    public static void main(String[] args) {
        KaryTree tree = new KaryTree();
        Karynode root;
        root = tree.insert(30);
        root = tree.insert(40);
        root = tree.insert(50);
        root = tree.insert(25);
        root = tree.insert(35);
        root = tree.insert(70);
        root = tree.insert(26);
        root = tree.insert(27);
        root = tree.insert(3);
        root = tree.insert(45);
        root = tree.insert(36);
        root = tree.insert(28);
        root = tree.insert(5);
        root = tree.insert(7);
        root = tree.insert(9);
        System.out.print("Preorder : ");
        tree.preorder(root);
        tree.deleteNode(5);
        System.out.println("\ndelete 5");
        System.out.print("Preorder : ");
        tree.preorder(root);

    }
}