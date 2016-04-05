package me.nasif.hackerrank.wa;

import me.nasif.hackerrank.ac.ChocolateFest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LisasWorkBook {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(ChocolateFest.class.getClassLoader().getResource("hr-LisasWorkBook-in.txt").getFile()));
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
        int n, k;
        List problemCount = new ArrayList();
        List problemsPerChapter = new ArrayList();
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            for (int i = 0; i < 5; i++) {
                problemCount.add(scanner.nextInt());
                if ((int) problemCount.get(i) % k == 0) {
                    System.err.println((int) problemCount.get(i) / k);
                } else {
                    System.err.println((int) problemCount.get(i) / k + 1);
                }

            }

        }

    }
}
