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

    static Point currentPosition, direction;
    static char[][] field;
    static char[] instructions;
    static int r, c, s;

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/11831.txt"));
//        scan = new Scanner(System.in)

        while (true) {
            r = scan.nextInt();
            c = scan.nextInt();
            s = scan.nextInt();
            if (r == 0 && c == 0 && s == 0) {
                break;
            }
            field = new char[r][c];
            instructions = new char[s];
            for (int i = 0; i < r; i++) {
                String line = scan.next();
                for (int j = 0; j < c; j++) {
                    field[i][j] = line.charAt(j);
                    if (field[i][j] == 'N' || field[i][j] == 'L' || field[i][j] == 'S' || field[i][j] == 'O') {
                        currentPosition = new Point(i, j);
                        setDirection(field[i][j]);
                    }

                }
            }
            instructions = scan.next().toCharArray();

            int res = 0;

            for (int i = 0; i < instructions.length; i++) {
                char v = instructions[i];
                if (v == 'D' || v == 'E') {
                    changeDirection(v);
                } else {
                    moveForward();
                    if (field[currentPosition.x][currentPosition.y] == '*') {
                        field[currentPosition.x][currentPosition.y] = '.';
                        ++res;
                    }

                }
            }
            System.out.println(res);

        }

    }

    private static void setDirection(char c) {
        switch (c) {
            case 'N':
                direction = new Point(-1, 0);
                break;
            case 'L':
                direction = new Point(0, 1);
                break;
            case 'S':
                direction = new Point(1, 0);
                break;
            case 'O':
                direction = new Point(0, -1);
                break;
            default:
                break;
        }
    }

    private static void changeDirection(char c) {
        switch (c) {
            case 'D':
                direction = new Point(direction.y, direction.x * (-1));
                break;
            case 'E':
                direction = new Point(direction.y * (-1), direction.x);
                break;
            default:
                break;
        }
    }

    private static void moveForward() {
        if (isValidMove()) {
            currentPosition.x += direction.x;
            currentPosition.y += direction.y;
        }
    }

    private static boolean isValidMove() {
        int nx = currentPosition.x + direction.x;
        int ny = currentPosition.y + direction.y;
        return (nx >= 0
                && nx < r
                && ny >= 0
                && ny < c
                && field[nx][ny] != '#');
    }
}
