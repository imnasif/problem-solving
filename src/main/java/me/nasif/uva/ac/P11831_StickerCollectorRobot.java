package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 Ad hoc :  AC
 */

public class P11831_StickerCollectorRobot {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point pos, o;
    static char[][] g;
    static int r, c, s;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(P11831_StickerCollectorRobot.class.getClassLoader().getResource("UVA/11831-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        while (true) {
            r = scan.nextInt();
            c = scan.nextInt();
            s = scan.nextInt();
            if (r == 0 && c == 0 && s == 0) {
                break;
            }
            g = new char[r][c];
            char[] q = new char[s];
            for (int i = 0; i < r; i++) {
                String line = scan.next();
                for (int j = 0; j < c; j++) {
                    g[i][j] = line.charAt(j);
                    check(i, j);
                }
            }
            q = scan.next().toCharArray();

            int res = 0;

            for (int i = 0; i < q.length; i++) {
                char v = q[i];
                if (v == 'D' || v == 'E') {
                    changeOrientation(v);
                } else {
                    moveForward();
                    if (g[pos.x][pos.y] == '*') {
                        g[pos.x][pos.y] = '.';
                        ++res;
                    }

                }
            }
            System.out.println(res);

        }

    }

    private static void check(int i, int j) {
        switch (g[i][j]) {
            case 'N':
                pos = new Point(i, j);
                o = new Point(-1, 0);
                break;
            case 'L':
                pos = new Point(i, j);
                o = new Point(0, 1);
                break;
            case 'S':
                pos = new Point(i, j);
                o = new Point(1, 0);
                break;
            case 'O':
                pos = new Point(i, j);
                o = new Point(0, -1);
                break;
            default:
                break;
        }
    }

    private static void changeOrientation(char c) {
        switch (c) {
            case 'D':
                o = new Point(o.y, o.x * (-1));
                break;
            case 'E':
                o = new Point(o.y * (-1), o.x);
                break;
            default:
                break;
        }
    }

    private static void moveForward() {
        if (isValidMove()) {
            pos.x += o.x;
            pos.y += o.y;
        }
    }

    private static boolean isValidMove() {
        int nx = pos.x + o.x;
        int ny = pos.y + o.y;
        return (nx >= 0
                && nx < r
                && ny >= 0
                && ny < c
                && g[nx][ny] != '#');
    }
}
