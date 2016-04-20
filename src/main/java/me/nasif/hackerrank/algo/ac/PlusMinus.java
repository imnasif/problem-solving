package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PlusMinus {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/PlusMinus.txt"));
//        scan = new Scanner(System.in);

        int n = scan.nextInt();
        float plus = 0, minus = 0, zero = 0;
        int i = n;
        while (i-- != 0) {
            float num = scan.nextFloat();
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
