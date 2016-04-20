package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Staircase {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/Staircase.txt"));
//        scan = new Scanner(System.in)

        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            while (spaces-- != 0) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }
}
