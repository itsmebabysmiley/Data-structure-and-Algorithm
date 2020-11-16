package stack;

public class lab02Task1 {
    public static void main(String[] args) {
        StackX stack = new StackX(50);
        stack.push(5);
        stack.push(15);
        stack.push(25);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
