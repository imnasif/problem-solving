package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConnectedCelIinAGrid {

    private static Scanner scan;
    private static int r, c;
    private static boolean[][] g;
    private static int[] comp;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/ConnectedCelIinAGrid.txt"));
//        scan = new Scanner(System.in);

        r = scan.nextInt();
        c = scan.nextInt();
        g = new boolean[r][c];
        comp = new int[110];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {                
                if (scan.nextInt() == 1) {
                    g[i][j] = true;
                }
            }
        }

        int compIndex = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (g[i][j]) {
                    dfs(i, j, ++compIndex);
                }
            }
        }
//        System.out.println(Arrays.stream(comp).max().getAsInt());
        System.out.println(getMaxComp());
        scan.close();
    }

    private static final int[] xDir = new int[]{1, -1, 1, 0, 0, -1, -1, 1};
    private static final int[] yDir = new int[]{1, -1, 0, 1, -1, 0, 1, -1};

    private static void dfs(int x, int y, int compIndex) {
        ++comp[compIndex];
        g[x][y] = false;
        for (int i = 0; i < 8; i++) {
            int nr = x + xDir[i];
            int nc = y + yDir[i];
            if (inGrid(nr, nc) && g[nr][nc]) {
                dfs(nr, nc, compIndex);
            }
        }
    }

    private static boolean inGrid(int i, int j) {
        return (i >= 0 && i < r && j >= 0 && j < c);
    }

    private static int getMaxComp() {
        int max = -1;
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] > max) {
                max = comp[i];
            }
        }
        return max;
    }

}
