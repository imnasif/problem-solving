package me.nasif.hackerrank.wa;

import java.io.File;
import java.util.Scanner;

public class SherlockAndTheBeast {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(SherlockAndTheBeast.class.getClassLoader().getResource("HackerRank/SherlockAndTheBeast-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int digits = 0, cases = scanner.nextInt();
        while (cases-- != 0) {
            digits = scanner.nextInt();
            boolean yes = false;
            if (digits % 3 == 0) {
                while (digits-- != 0) {
                    System.out.print(5);
                }
                System.out.println();
                yes = true;
            } else if (digits % 5 == 0) {
                while (digits-- != 0) {
                    System.out.print(3);
                }
                System.out.println();
                yes = true;
            }

            if (!yes) {
                int n3 = 0, n5 = 0;
                for (int i = 0; i * 3 < digits && (digits - i * 3) % 5 == 0; i++) {
                    n5 = i * 3;
                    n3 = digits - n5;
                    yes = true;
                }
                if (yes) {
                    for (int i = 0; i < n5; i++) {
                        System.out.print(5);
                    }
                    for (int i = 0; i < n3; i++) {
                        System.out.print(3);
                    }
                    System.err.println();
                }

            }
            if (!yes) {
                System.out.println(-1);
            }
        }
    }
}
