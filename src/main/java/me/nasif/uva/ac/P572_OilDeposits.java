package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P572_OilDeposits {

    private static Scanner scan;
    private static int r, c;
    private static boolean[][] g;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/572.txt"));
//        scan = new Scanner(System.in)

        while (scan.hasNext()) {

            r = scan.nextInt();
            c = scan.nextInt();
            if (r == 0) {
                break;
            }

            g = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String l = scan.next();
                for (int j = 0; j < c; j++) {
                    if (l.charAt(j) == '@') {
                        g[i][j] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j]) {
                        ++count;
                        visit(i, j);
                    }
                }
            }

            System.out.println(count);

        }
    }

    private static void visit(int row, int col) {
        g[row][col] = false;
        for (int i = 0; i < 8; i++) {
            int nx = row + xDir[i];
            int ny = col + yDir[i];
            if (isValid(nx, ny) && g[nx][ny]) {
                visit(nx, ny);
            }
        }
    }

    private static final int[] xDir = new int[]{-1, 1, -1, 1, -1, 1, 0, 0};
    private static final int[] yDir = new int[]{-1, 1, 1, -1, 0, 0, 1, -1};

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < r && y >= 0 && y < c);
    }

}
