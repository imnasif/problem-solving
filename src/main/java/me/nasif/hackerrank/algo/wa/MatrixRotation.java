package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.util.Scanner;

public class MatrixRotation {

    private static Scanner scan;

    private static void initScanner() {
        try {
            scan = new Scanner(new File(MatrixRotation.class.getClassLoader().getResource("HackerRank/MatrixRotation-in.txt").getFile()));
        } catch (Exception ex) {
            scan = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int r, c, t;
        r = scan.nextInt();
        c = scan.nextInt();
        t = scan.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        t = t % (2 * c + 2 * (r - 2));
        rotate(arr, r, c, t);

    }

    public static int[][] rotate(int[][] arr, int r, int c, int t) {
        int[][] rotated = new int[r][c];

        return rotated;
    }

}
