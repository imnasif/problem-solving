package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UtopianTree {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/UtopianTree.txt"));
//        scan = new Scanner(System.in)
        
        int cases, n;
        cases = scan.nextInt();
        while (cases-- != 0) {
            int h = 1;
            n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    h *= 2;
                } else {
                    h += 1;
                }
            }
            System.out.println(h);
        }
    }
}
