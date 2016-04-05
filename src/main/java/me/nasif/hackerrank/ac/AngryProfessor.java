package me.nasif.hackerrank.ac;

import java.io.File;
import java.util.Scanner;

public class AngryProfessor {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(AngryProfessor.class.getClassLoader().getResource("HackerRank/AngryProfessor-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int cases, n, k, a, onTime;
        cases = scanner.nextInt();
        while (cases-- != 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            onTime = 0;
            while (n-- != 0) {
                a = scanner.nextInt();
                if (a <= 0) {
                    ++onTime;
                }
            }
            if (onTime < k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
