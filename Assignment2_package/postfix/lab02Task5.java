package postfix;

public class lab02Task5 {
    public static void main(String[] args) {
        ParsePost postfix = new ParsePost("23+75**");
        int output = postfix.doParse(); 
        System.out.println("Evaluates to " + output);
    }
}
