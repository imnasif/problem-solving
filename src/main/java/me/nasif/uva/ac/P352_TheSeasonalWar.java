package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P352_TheSeasonalWar {

    private static Scanner scan;
    private static int n;
    private static boolean[][] g;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/352.txt"));
//        scan = new Scanner(System.in);
        int cn = 0;
        while (scan.hasNextInt()) {
            n = scan.nextInt();
            scan.nextLine();
            g = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String l = scan.nextLine();
                for (int j = 0; j < l.length(); j++) {
                    if (l.charAt(j) == '1') {
                        g[i][j] = true;
                    }
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g[i][j]) {
                        ++count;
                        dfs(i, j);
                    }
                }
            }
            System.out.printf("Image number %d contains %d war eagles.\n", ++cn, count);

        }

    }

    private static void dfs(int row, int col) {
        g[row][col] = false;
        for (int i = 0; i < 8; i++) {
            int nx = row + xDir[i];
            int ny = col + yDir[i];
            if (isValid(nx, ny) && g[nx][ny]) {
                dfs(nx, ny);
            }
        }

    }

    private static final int[] xDir = new int[]{-1, 1, -1, 1, -1, 1, 0, 0};
    private static final int[] yDir = new int[]{-1, 1, 1, -1, 0, 0, 1, -1};

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
}
