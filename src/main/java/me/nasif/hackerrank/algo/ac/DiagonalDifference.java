package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.Scanner;

public class DiagonalDifference {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(DiagonalDifference.class.getClassLoader().getResource("HackerRank/DiagonalDifference-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        System.out.println(Math.abs(sum1 - sum2));

    }
}
