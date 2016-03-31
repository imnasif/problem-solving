package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 UVA 11172 - Relational Operators AC
 Easy Ad Hoc
 */
public class P11172 {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static final Map map = new HashMap<>();

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(P11172.class.getClassLoader().getResource("uva-11172-in.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(P11172.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();
        int cases = scanner.nextInt();
        while (cases-- != 0) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (a < b) {
                out.printf("%s\n", "<");
            } else if (a > b) {
                out.printf("%s\n", ">");
            } else {
                out.printf("%s\n", "=");
            }
        }
    }

}
