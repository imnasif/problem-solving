package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 UVA 10189 - Minesweeper
 Ad Hoc, String, Corner Cases
 */
public class P10189 {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static final Map map = new HashMap<>();

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(P10189.class.getClassLoader().getResource("uva-10189-in.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(P10189.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        initScanner();
        int r, c;
        while (true) {
            r = scanner.nextInt();
            c = scanner.nextInt();
            if (r == 0 && c == 0) {
                break;
            }

            for (int i = 0; i < r; i++) {
                String s = scanner.next();
                System.err.println(Arrays.toString(s.toCharArray()));
            }

        }

    }

}
