import java.util.Scanner;

public class Appmain {
    public static void main(String[] args) {
        SinglyLinkist linklist = new SinglyLinkist();
        linklist.add("two", 2);
        linklist.add("one", 1);
        linklist.add("Twenty", 20);
        linklist.add("Sixtynine", 69);
        linklist.add("Eight", 8);
        linklist.add("three", 3);
        linklist.add("Nineteen", 19);
        //linklist.show();
        Scanner scan = new Scanner(System.in);
        System.out.print("Input number to search: ");
        int key = scan.nextInt();
        String result = linklist.search(key);
        System.out.println(result);
        scan.close();
    }
}
