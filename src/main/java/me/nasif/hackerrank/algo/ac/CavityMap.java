package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CavityMap {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/CavityMap.txt"));
//        scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[][] map = getArray(n, n);
        char[][] res = initResArray(n, map);

        int minX = 1, minY = 1, maxX = n - 1, maxY = n - 1;

        for (int i = minX; i < maxX; i++) {
            for (int j = minY; j < maxY; j++) {
                if (hasCavity(map, i, j)) {
                    res[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }

    }

    private static char[][] initResArray(int n, int[][] map) {
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = (Character.forDigit(map[i][j], 10));
            }
        }
        return res;
    }

    private static boolean hasCavity(int[][] map, int i, int j) {
        return map[i][j] > map[i][j - 1] && map[i][j] > map[i][j + 1] && map[i][j] > map[i - 1][j] && map[i][j] > map[i + 1][j];
    }

    private static int[][] getArray(int row, int column) {
        int[][] array = new int[row][column];
        for (int i = 0; i < row; i++) {
            String line = scan.next();
            for (int j = 0; j < column; j++) {
                array[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        return array;
    }
}
