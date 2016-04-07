package me.nasif.hackerrank.algo.ac;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    private static Scanner scanner;

    private static void initScanner() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        initScanner();
        int n = scanner.nextInt();
        BigInteger res = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            res = res.multiply(new BigInteger(i + ""));
        }
        System.out.println(res);

    }

}
