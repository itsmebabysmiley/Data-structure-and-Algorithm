public class lab03Task4 {
    public static void main(String[] args) {
        DArray array = new DArray(50);
        array.insert(11);
        array.insert(12);
        array.insert(8);
        array.insert(5);
        array.insert(3);
        array.insert(15);
        array.insert(20);
        array.insert(18);
        array.insert(36);
        array.insert(17);

        array.display();
        array.mergeSort();
        array.display();
    }
}
