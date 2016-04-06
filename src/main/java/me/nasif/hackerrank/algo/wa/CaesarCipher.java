package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.util.Scanner;

public class CaesarCipher {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(CaesarCipher.class.getClassLoader().getResource("HackerRank/CaesarCipher-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int n, k;
        String s;
        n = scanner.nextInt();
        s = scanner.next();
        k = scanner.nextInt();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(getRes(s.charAt(i), k));
        }
        System.out.println();

    }

    private static char getRes(char s, int k) {
        int asc = (int) s;
        if (97 <= asc && asc <= 121) {
            return (char) (asc + k);
        } else if (asc == 122) {
            return (char) (97 + k);
        } else if (65 <= asc && asc <= 189) {
            return (char) (asc + k);
        } else if (asc == 122) {
            return (char) (65 + k);
        } else {
            return s;
        }
    }
}
