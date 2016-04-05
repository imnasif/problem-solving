package me.nasif.hackerrank.ac;

import java.io.File;
import java.util.Scanner;

public class FindDigits {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(FindDigits.class.getClassLoader().getResource("HackerRank/FindDigits-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int cases, n;
        cases = scanner.nextInt();
        while (cases-- != 0) {
            n = scanner.nextInt();
            int temp, res = 0;
            temp = n;
            while (temp > 0) {
                if (temp % 10 != 0 && n % (temp % 10) == 0) {
                    ++res;
                }
                temp /= 10;
            }
            System.out.println(res);
        }
    }
}
