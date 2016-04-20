package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P118_MutantFlatworldExplorers {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point max;
    static Point cur;
    static Point dir;
    static char[] ins;
    static ArrayList<Point> scents;

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/118.txt"));
//        scan = new Scanner(System.in)

        max = new Point(scan.nextInt(), scan.nextInt());
        scents = new ArrayList<>();
        while (scan.hasNext()) {
            cur = new Point(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
            setDirection(scan.next().toCharArray()[0]);
            ins = scan.next().toCharArray();

            boolean lost = false;
            for (int i = 0; i < ins.length; i++) {
                if (ins[i] == 'R' || ins[i] == 'L') {
                    changeDirection(ins[i]);
                } else {
                    if (isInsideArea()) {
                        moveForward();
                    } else {
                        if (!hasScent()) {
                            addScent();
                            System.out.printf("%d %d %s LOST\n", cur.x, cur.y, getCurrentDirection());
                            lost = true;
                            break;
                        }
                    }
                }
            }

            if (!lost) {
                System.out.printf("%d %d %s\n", cur.x, cur.y, getCurrentDirection());
            }
        }
    }

    private static void changeDirection(char c) {
        switch (c) {
            case 'L':
                dir = new Point(dir.y * (-1), dir.x);
                break;
            case 'R':
                dir = new Point(dir.y, dir.x * (-1));
                break;
        }
    }

    private static void setDirection(char c) {
        switch (c) {
            case 'E':
                dir = new Point(1, 0);
                break;
            case 'S':
                dir = new Point(0, -1);
                break;
            case 'W':
                dir = new Point(-1, 0);
                break;
            case 'N':
                dir = new Point(0, 1);
                break;
        }
    }

    private static char getCurrentDirection() {
        if (dir.x == 1 && dir.y == 0) {
            return 'E';
        } else if (dir.x == 0 && dir.y == -1) {
            return 'S';
        } else if (dir.x == -1 && dir.y == 0) {
            return 'W';
        } else {
            return 'N';
        }
    }

    private static boolean isInsideArea() {
        Point next = getNextPosition();
        return (next.x >= 0
                && next.x <= max.x
                && next.y >= 0
                && next.y <= max.y);
    }

    private static Point getNextPosition() {
        return new Point(cur.x + dir.x, cur.y + dir.y);
    }

    private static boolean hasScent() {
        for (Point scent : scents) {
            if (cur.x == scent.x && cur.y == scent.y) {
                return true;
            }
        }
        return false;
    }

    private static void moveForward() {
        cur = getNextPosition();
    }

    private static void addScent() {
        scents.add(cur);
    }

}
