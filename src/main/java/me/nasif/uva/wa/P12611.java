package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 UVA 12611 - Beautiful Flag
 Ad Hoc
 */
public class P12611 {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(P12611.class.getClassLoader().getResource("uva-12611-in.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(P12611.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            int r = scanner.nextInt();
            int l = r * 5;
            int w = r * 3;

            out.printf("Case %d:\n", i);
            out.printf("%d %d\n", -1 * l / 100 * 45, w / 2);
            out.printf("%d %d\n", l / 100 * 55, w / 2);
            out.printf("%d %d\n", l / 100 * 55, -1 * w / 2);
            out.printf("%d %d\n", -1 * l / 100 * 45, -1 * w / 2);

        }

    }

}
