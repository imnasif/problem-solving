package me.nasif.hackerrank.wa;

import java.io.File;
import java.util.Scanner;

public class Staircase {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(Staircase.class.getClassLoader().getResource("HackerRank/Staircase-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            while (spaces-- != 0) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }
}
