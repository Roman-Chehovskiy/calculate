import java.util.Scanner;

public class Main {
    static String[] rome = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    static final int[] arabic = {1, 4, 5, 9, 10, 40, 50, 90, 100};
    static int x = 0;
    static int y = 0;


    public static void main(String[] args) {

        String s = "";
        String str = new Scanner(System.in).nextLine();
        String[] mass = str.split(" ");
        if (mass.length == 3) {
            if (mass[1].equals("+") || mass[1].equals("-") || mass[1].equals("*") || mass[1].equals("/")) {
                if (checkRoman(mass[0]) && checkRoman(mass[2])) {
                    x = convertToArab(mass[0]);
                    y = convertToArab(mass[2]);
                    s = convertToRoman(matematic(mass[1]));
                    System.out.println(s);
                } else if (checkArabic(mass[0]) && checkArabic(mass[2])) {
                    x = Integer.parseInt(mass[0]);
                    y = Integer.parseInt(mass[2]);
                    System.out.println(convertToRoman(matematic(mass[1])));
                } else System.out.println("Неверно введены значения");
            } else System.out.println("Неверна операция");
        } else System.out.println(" долблеб");
    }

    static String convertToRoman(int c) {
        String str = "";
        for (int i = 0; i < arabic.length; i++) {
            if (c == arabic[i]) {
                str = rome[i];
                return str;
            }
        }
        int a = c / 10 * 10;
        int b = c % 10;
        if (a > 0) {
            for (int i = 0; i < arabic.length; i++) {
                if (a == arabic[i]) {
                    str = rome[i];
                    break;
                }
            }
            if (str.equals("")) {
                if (a <= 30 && a >= 10) {
                    for (int n = 0; n < a / 10; n++) str = str + "X";
                } else {
                    str = "L";
                    for (int n = 0; n < (a - 50) / 10; n++) str = str + "X";
                }
            }
        }
        if (b > 0) {
            for (int i = 0; i < arabic.length; i++) {
                if (b == arabic[i]) {
                    str = str + rome[i];
                    return str;
                }
            }
            if (b <= 3 && b >= 2) {
                for (int n = 0; n < b / 1; n++) str = str + "I";
            } else {
                str = str + "V";
                for (int n = 0; n < (b - 5) / 1; n++) str = str + "I";
            }
        }
        return str;
    }


    static boolean checkArabic(String str) {
        boolean chech = false;
        String[] massArabic = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < massArabic.length; i++) {
            if (str.equals(massArabic[i])) {
                chech = true;
                break;
            }
        }
        return chech;
    }

    static int matematic(String str) {
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

    static int convertToArab(String str) {
        String subStr = "";
        int i = 0;
        int result = 0;
        boolean check = false;
        while (i < str.length()) {
            subStr = str.substring(i);
            for (int n = 0; n < rome.length; n++) {
                if (subStr.equals(rome[n])) {
                    result = result + arabic[n];
                    str = str.substring(0, i);
                    System.out.println(str);
                    i = 0;
                    check = true;
                    break;
                }
            }
            if (!check) i++;
        }
        return result;
    }

    static boolean checkRoman(String str) {
        boolean check = false;
        String strRoman = "IVXL";
        for (int n = 0; n < str.length(); n++) {
            check = false;
            for (int i = 0; i < strRoman.length(); i++) {
                if (str.charAt(n) == strRoman.charAt(i)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

}
