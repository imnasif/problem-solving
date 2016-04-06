package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.Scanner;

public class SherlockAndSquares {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(SherlockAndSquares.class.getClassLoader().getResource("HackerRank/SherlockAndSquares-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int cases, a, b;
        cases = scanner.nextInt();
        while (cases-- != 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            int res = (int) Math.ceil(Math.sqrt(b) - 1) - (int) Math.ceil(Math.sqrt(a) - 1);
            if ((int) Math.pow((int) Math.sqrt(b), 2) == b) {
                ++res;
            }
            System.out.println(res);

        }
    }
}
