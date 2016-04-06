package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.Scanner;

public class UtopianTree {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(UtopianTree.class.getClassLoader().getResource("HackerRank/UtopianTree-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int cases, n;
        cases = scanner.nextInt();
        while (cases-- != 0) {
            int h = 1;
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    h *= 2;
                } else {
                    h += 1;
                }
            }
            System.out.println(h);
        }
    }
}
