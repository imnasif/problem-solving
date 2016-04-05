package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 UVA 191 - Intersection WA
 Geomtery, Ad Hoc
 */
public class P191 {

    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(P12611.class.getClassLoader().getResource("uva-12611-in.txt").getFile()));
        } catch (FileNotFoundException ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();
        int cases = scanner.nextInt();
        int x1, y1, x2, y2, xl, yt, xr, yb;
        while (cases-- != 0) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            xl = scanner.nextInt();
            yt = scanner.nextInt();
            xr = scanner.nextInt();
            yb = scanner.nextInt();
        }

    }

}
