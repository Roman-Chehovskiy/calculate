package Utils;

public class ArabicNumbers {

    public static boolean checkArabic(String str) {
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
}
