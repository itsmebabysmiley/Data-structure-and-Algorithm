package bracket;

public class lab02Task3 {
    public static void main(String[] args) {
        BracketChecker bracket = new BracketChecker("f(x) = 2x(8 + xsin(2x - 6)))");
        bracket.check();
    }
}
