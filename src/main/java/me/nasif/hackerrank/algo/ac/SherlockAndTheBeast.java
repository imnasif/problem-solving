package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SherlockAndTheBeast {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/SherlockAndTheBeast.txt"));
//        scan = new Scanner(System.in)

        int digits = 0, cases = scan.nextInt();
        while (cases-- != 0) {
            digits = scan.nextInt();
            boolean yes = false;
            for (int i = 0; i * 5 < digits; i++) {
                if ((digits - i * 5) % 3 == 0) {
                    int n3 = i * 5;
                    int n5 = digits - n3;
                    while (n5-- != 0) {
                        System.out.print(5);
                    }
                    while (n3-- != 0) {
                        System.out.print(3);
                    }
                    System.out.println();
                    yes = true;
                    break;
                }
            }
            if (!yes) {
                if (digits % 5 == 0) {
                    while (digits-- != 0) {
                        System.out.print(3);
                    }
                    System.out.println();
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}
