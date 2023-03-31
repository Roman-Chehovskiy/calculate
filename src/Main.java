import Utils.ArabicNumbers;
import Utils.MathematicalOperations;
import exception.InterException;

import java.util.Scanner;

import static Utils.RomanNumbers.*;

public class Main {
    static int x = 0;
    static int y = 0;


    public static void main(String[] args) throws InterException {

        String str = "";
        String[] mass;
        String s = "";
        String arithmeticChar = "";

        System.out.println("Калькулятор принимает только числа от 1 до 10");
        System.out.println("Выполняет только следующие арифметические действия \"+\", \"-\", \"*\", \"/\"");
        System.out.println("Работает только одновремено либо с римскими, либо с арабскими числами");
        System.out.println("Введите выражение");


        str = new Scanner(System.in).nextLine();
        str = str.replace(" ", "");
        mass = str.split("[+-/\\*]");
        if (mass.length == 2) {

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                    arithmeticChar = String.valueOf(str.charAt(i));
                }
            }

            if (checkRoman(mass[0]) && checkRoman(mass[1])) {
                x = convertToArab(mass[0]);
                y = convertToArab(mass[1]);
                if (x > 0 && x <= 10 && y > 0 && y <= 10) {
                    s = convertToRoman(MathematicalOperations.matematic(arithmeticChar, x, y));
                    System.out.println(s);
                } else {
                    throw new InterException("Неверно введены операнды");
                }
            } else if (ArabicNumbers.checkArabic(mass[0]) && ArabicNumbers.checkArabic(mass[1])) {
                x = Integer.parseInt(mass[0]);
                y = Integer.parseInt(mass[1]);
                System.out.println(MathematicalOperations.matematic(arithmeticChar, x, y));
            } else {
                throw new InterException("Неверно введены операнды");
            }
        } else {
            throw new InterException("Неверная операция или формат выражения");
        }
    }

}


