package infix;

public class lab02Task4 {
    public static void main(String[] args) {
        InToPost infix = new InToPost("2 + ((2 + 3) * (7 - 1)))");
         String str = infix.doTrans();
         System.out.println(str);
    }
}
