package me.nasif.uva;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P10346 {

    private static final boolean readFromFile = false;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(P10346.class.getClassLoader().getResource("uva-10346-in.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(P10346.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();

        int a, b;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();

            out.printf("%d\n", getResult(a, b));
        }

    }

    public static int getResult(int n, int k) {

        int result = n;
        while (n >= k) {
            result += n / k;
            n = n / k + n % k;
        }
        return result;
    }

}
