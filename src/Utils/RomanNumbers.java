package Utils;

public class RomanNumbers {
    static String[] rome = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    static final int[] arabic = {1, 4, 5, 9, 10, 40, 50, 90, 100};

    public static boolean checkRoman(String str) {
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

    public static String convertToRoman(int c) {
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

    public static int convertToArab(String str) {
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
                    i = 0;
                    check = true;
                    break;
                }
            }
            if (!check) i++;
        }
        return result;
    }

}
