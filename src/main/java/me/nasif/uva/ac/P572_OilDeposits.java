package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 Flood Fill :  AC
 */
class Point {

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
}

public class P572_OilDeposits {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(P572_OilDeposits.class.getClassLoader().getResource("UVA/572-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int r, c;
            r = scan.nextInt();
            c = scan.nextInt();
            if (r == 0) {
                break;
            }

            boolean[][] g = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                String l = scan.next();
                for (int j = 0; j < c; j++) {
                    if (l.charAt(j) == '@') {
                        g[i][j] = true;
                    }
                }
            }

            boolean[][] visited = new boolean[r][c];
            int res = 0;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (g[i][j] && !visited[i][j]) {
                        visitNeighbours(g, r, c, i, j, visited);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    private static final int[] xDir = new int[]{-1, 1, -1, 1, -1, 1, 0, 0};
    private static final int[] yDir = new int[]{-1, 1, 1, -1, 0, 0, 1, -1};

    private static void visitNeighbours(boolean[][] g, int r, int c, int x, int y, boolean[][] visited) {

        Queue q = new LinkedList();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point current = (Point) q.remove();
            visited[current.x][current.y] = true;
            for (int i = 0; i < 8; i++) {
                Point n = new Point(current.x + xDir[i], current.y + yDir[i]);
                if (isValid(n.x, n.y, r, c) && g[n.x][n.y] && !visited[n.x][n.y]) {
                    q.add(n);
                }
            }
        }
    }

    private static boolean isValid(int x, int y, int r, int c) {
        return (x >= 0 && x < r && y >= 0 && y < c);
    }

}
