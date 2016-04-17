package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 BFS : AC
*/

public class P10653_BombsNoTheyAreMines {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static Scanner scan;
    static int r, c, n, rn, m;
    static boolean[][] grid;
    static int[][] dist;
    static Point src;
    static Point dest;
    static Queue q;

    static final int[] xDir = new int[]{0, 1, -1, 0};
    static final int[] yDir = new int[]{1, 0, 0, -1};

    public static void main(String[] args) throws FileNotFoundException {

        scan = new Scanner(new File("res/UVA/10653.txt"));
//       scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            r = scan.nextInt();
            c = scan.nextInt();
            if (r == 0 && c == 0) {
                break;
            }
            grid = new boolean[r][c];
            dist = new int[r][c];
            n = scan.nextInt();
            for (boolean[] row : grid) {
                Arrays.fill(row, true);
            }
            for (int[] d : dist) {
                Arrays.fill(d, -1);
            }
            while (n-- != 0) {
                rn = scan.nextInt();
                m = scan.nextInt();
                while (m-- != 0) {
                    grid[rn][scan.nextInt()] = false;
                }
            }

            src = new Point(scan.nextInt(), scan.nextInt());
            dest = new Point(scan.nextInt(), scan.nextInt());

            q = new LinkedList();
            q.add(src);
            dist[src.x][src.y] = 0;

            int res = 0;
            boolean found = false;

            while (!q.isEmpty()) {
                Point curr = (Point) q.remove();
                for (int dir = 0; dir < 4; dir++) {
                    Point next = new Point(curr.x + xDir[dir], curr.y + yDir[dir]);
                    if (isInGrid(next) && grid[next.x][next.y] && dist[next.x][next.y] == -1) {
                        dist[next.x][next.y] = dist[curr.x][curr.y] + 1;
                        q.add(next);
                    }
                    if (next.x == dest.x && next.y == dest.y) {
                        res = dist[next.x][next.y];
                        found = true;
                        break;
                    }

                }
                if (found) {
                    break;
                }

            }
            System.out.println(res);

        }

    }

    private static boolean isInGrid(Point p) {
        return (p.x >= 0 && p.x < r && p.y >= 0 && p.y < c);
    }

}
