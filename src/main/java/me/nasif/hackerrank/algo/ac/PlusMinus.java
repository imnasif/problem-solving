package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.Scanner;

public class PlusMinus {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(PlusMinus.class.getClassLoader().getResource("HackerRank/PlusMinus-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int n = scanner.nextInt();
        float plus = 0, minus = 0, zero = 0;
        int i = n;
        while (i-- != 0) {
            float num = scanner.nextFloat();
            if (num > 0) {
                ++plus;
            } else if (num < 0) {
                ++minus;
            } else {
                ++zero;
            }
        }

        System.out.println(plus / n);
        System.out.println(minus / n);
        System.out.println(zero / n);

    }
}
