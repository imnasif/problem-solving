package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.Scanner;

public class LibraryFine {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(LibraryFine.class.getClassLoader().getResource("HackerRank/LibraryFine-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int dAR, mAR, yAR, dER, mER, yER;
        dAR = scanner.nextInt();
        mAR = scanner.nextInt();
        yAR = scanner.nextInt();
        dER = scanner.nextInt();
        mER = scanner.nextInt();
        yER = scanner.nextInt();
        int fine;

        if (yAR > yER) {
            fine = 10000;
        } else if (yAR < yER) {
            fine = 0;
        } else {
            if (mAR < mER) {
                fine = 0;
            } else if (mAR > mER) {
                fine = 500 * (mAR - mER);
            } else {
                if (dAR <= dER) {
                    fine = 0;
                } else {
                    fine = 15 * (dAR - dER);
                }
            }
        }

        System.out.println(fine);

    }
}
