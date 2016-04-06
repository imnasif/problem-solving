package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class TheGridSearch {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(TheGridSearch.class.getClassLoader().getResource("HackerRank/TheGridSearch-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int cases, R, C, r, c;
        cases = scanner.nextInt();

        while (cases-- != 0) {
            R = scanner.nextInt();
            C = scanner.nextInt();
            int[][] RC = getArray(R, C);

            r = scanner.nextInt();
            c = scanner.nextInt();
            int[][] rc = getArray(r, c);

            System.out.println(Arrays.deepToString(RC));
            System.out.println(Arrays.deepToString(rc));
        }

    }

    private static int[][] getArray(int row, int column) {
        int[][] RC = new int[row][column];
        for (int i = 0; i < row; i++) {
            String line = scanner.next();
            for (int j = 0; j < column; j++) {
                RC[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        return RC;
    }
}
