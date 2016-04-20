package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryFine {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/LibraryFine.txt"));
//        scan = new Scanner(System.in);

        int dAR, mAR, yAR, dER, mER, yER;
        dAR = scan.nextInt();
        mAR = scan.nextInt();
        yAR = scan.nextInt();
        dER = scan.nextInt();
        mER = scan.nextInt();
        yER = scan.nextInt();
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
