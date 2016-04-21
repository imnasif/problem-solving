package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P10116_RobotMotion {

    private static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Point() {

        }

    }

    private static Scanner scan;
    private static int r, c, sc;
    private static char[][] g;
    private static int[][] vis;
    private static Point cur;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/10116.txt"));
//        scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            r = scan.nextInt();
            c = scan.nextInt();
            sc = scan.nextInt();

            if (r == 0 && c == 0 && sc == 0) {
                break;
            }

            g = new char[r][c];
            vis = new int[r][c];
            cur = new Point(0, sc - 1);

            for (int i = 0; i < r; i++) {
                g[i] = scan.next().toCharArray();
            }

            int steps = 0;
            int loopCount = 0;
            boolean loop = false;
            while (true) {
                Point next = getNextPoint();
                if (isValid(next)) {
                    cur = next;
                    if (vis[cur.x][cur.y] == 0) {
                        ++steps;
                        ++vis[cur.x][cur.y];
                    } else if (vis[cur.x][cur.y] == 1) {
                        loop = true;
                        --steps;
                        ++loopCount;
                        ++vis[cur.x][cur.y];
                    } else {
                        break;
                    }

                } else {
                    break;
                }

            }

            if (!loop) {
                System.out.printf("%d step(s) to exit\n", ++steps);
            } else {
                if (vis[0][sc - 1] == 2) { // Start point starts the loop
                    System.out.printf("%d step(s) before a loop of %d step(s)\n", steps, loopCount);
                } else {
                    System.out.printf("%d step(s) before a loop of %d step(s)\n", ++steps, loopCount);
                }

            }

        }

    }

    private static Point getNextPoint() {
        Point p = new Point(cur.x, cur.y);
        switch (g[cur.x][cur.y]) {
            case 'N':
                p.x -= 1;
                break;
            case 'E':
                p.y += 1;
                break;
            case 'S':
                p.x += 1;
                break;
            case 'W':
                p.y -= 1;
                break;
        }
        return p;
    }

    private static boolean isValid(Point p) {
        return (p.x >= 0 && p.x < r && p.y >= 0 && p.y < c);
    }
}
