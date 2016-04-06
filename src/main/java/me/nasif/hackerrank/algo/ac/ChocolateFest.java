package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.Scanner;

public class ChocolateFest {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(ChocolateFest.class.getClassLoader().getResource("HackerRank/ChocolateFest-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int t, n, c, m;
        t = scanner.nextInt();
        while (t-- != 0) {
            n = scanner.nextInt();
            c = scanner.nextInt();
            m = scanner.nextInt();
            int canBuy = n / c;
            int result = canBuy;

            while (canBuy >= m) {
                result += canBuy / m;
                canBuy = canBuy / m + canBuy % m;
            }
            System.out.println(result);
        }
    }
}
