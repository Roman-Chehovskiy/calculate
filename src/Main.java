import Utils.ArabicNumbers;
import Utils.MathematicalOperations;

import java.io.IOException;
import java.util.Scanner;

import static Utils.RomanNumbers.*;

public class Main {
    static int x = 0;
    static int y = 0;


    public static void main(String[] args) {

        String s = "";
        String str = new Scanner(System.in).nextLine();
        String[] mass = str.split(" ");
        try {
            if (mass.length == 3) {
                if (mass[1].equals("+") || mass[1].equals("-") || mass[1].equals("*") || mass[1].equals("/")) {
                    if (checkRoman(mass[0]) && checkRoman(mass[2])) {
                        x = convertToArab(mass[0]);
                        y = convertToArab(mass[2]);
                        s = convertToRoman(MathematicalOperations.matematic(mass[1], x, y));
                        System.out.println(s);
                    } else if (ArabicNumbers.checkArabic(mass[0]) && ArabicNumbers.checkArabic(mass[2])) {
                        x = Integer.parseInt(mass[0]);
                        y = Integer.parseInt(mass[2]);
                        System.out.println(MathematicalOperations.matematic(mass[1], x, y));
                    } else {
                        throw new NumberFormatException();
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            System.out.println(" неверно введено выражение");
        } catch (UnsupportedOperationException e) {
            System.out.println("Неверна операция");
        } catch (NumberFormatException e) {
            System.out.println("неверно введены числа");
        }
    }

}
