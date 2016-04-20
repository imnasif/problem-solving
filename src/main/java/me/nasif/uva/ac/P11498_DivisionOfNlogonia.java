package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P11498_DivisionOfNlogonia {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/11498.txt"));
//        scan = new Scanner(System.in)
        
        while (scan.hasNextInt()) {
            int k = scan.nextInt();
            if (k == 0) {
                break;
            }
            Point c = new Point(scan.nextInt(), scan.nextInt());
            while (k-- != 0) {
                Point p = new Point(scan.nextInt(), scan.nextInt());
                if (p.x == c.x || p.y == c.y) {
                    System.out.println("divisa");
                } else if (p.x - c.x > 0 && p.y - c.y > 0) {
                    System.out.println("NE");
                } else if (p.x - c.x < 0 && p.y - c.y < 0) {
                    System.out.println("SO");
                } else if (p.x - c.x > 0 && p.y - c.y < 0) {
                    System.out.println("SE");
                } else {
                    System.out.println("NO");
                }
            }

        }

    }
}
