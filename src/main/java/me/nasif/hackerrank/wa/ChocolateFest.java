package me.nasif.hackerrank.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChocolateFest {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(ChocolateFest.class.getClassLoader().getResource("hr-chocolatefest-in.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChocolateFest.class.getName()).log(Level.SEVERE, null, ex);
                scanner = new Scanner(System.in);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();
        int t, n, c, m;
        t = scanner.nextInt();
        while (t-- != 0) {
            n = scanner.nextInt();
            c = scanner.nextInt();
            m = scanner.nextInt();
            int canBuy = n / c;
            int result = canBuy;

            while (canBuy >= m) {
                result += canBuy / m;
                canBuy = canBuy / m + canBuy % m;
            }

            out.printf("%d\n", result);
        }

    }

}
