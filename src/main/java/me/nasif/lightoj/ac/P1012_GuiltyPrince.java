package me.nasif.lightoj.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P1012_GuiltyPrince {

    private static Scanner scan;
    private static int k, nr, nc, res;
    private static boolean g[][];

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/LightOJ/P1012_GuiltyPrince.txt"));
//        scan = new Scanner(System.in);
        k = scan.nextInt();
        int cn = 0;
        while (k-- != 0) {
            nc = scan.nextInt();
            nr = scan.nextInt();
            scan.nextLine();
            g = new boolean[nr][nc];
            int sx = 0, sy = 0;
            for (int i = 0; i < nr; i++) {
                String l = scan.nextLine();
                for (int j = 0; j < nc; j++) {
                    if (l.charAt(j) == '.') {
                        g[i][j] = true;
                    }
                    if (l.charAt(j) == '@') {
                        sx = i;
                        sy = j;
                    }
                }
            }

            res = 0;
            dfs(sx, sy);
            System.out.printf("Case %d: %d\n", ++cn, ++res);

        }

    }

    private static final int[] xDir = {-1, 0, 1, 0};
    private static final int[] yDir = {0, -1, 0, 1};

    private static void dfs(int sx, int sy) {
        g[sx][sy] = false;
        for (int i = 0; i < 4; i++) {
            int nx = sx + xDir[i];
            int ny = sy + yDir[i];
            if (isValid(nx, ny) && g[nx][ny]) {
                ++res;
                dfs(nx, ny);
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < nr && y >= 0 && y < nc);
    }
}
