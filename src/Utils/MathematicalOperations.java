package Utils;

public class MathematicalOperations {

    public static int matematic(String str, int x, int y) {
        int c = 0;
        switch (str) {
            case "+":
                c = x + y;
                break;
            case "-":
                c = x - y;
                break;
            case "*":
                c = x * y;
                break;
            case "/":
                c = x / y;
                break;
        }
        return c;
    }
}
