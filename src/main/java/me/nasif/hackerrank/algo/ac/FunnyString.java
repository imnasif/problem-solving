package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FunnyString {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/FunnyString.txt"));
//        scan = new Scanner(System.in);
        int t = scan.nextInt();

        while (t-- != 0) {

            String line = scan.next();
            String reverse = new StringBuilder(line).reverse().toString();

            boolean funny = true;

            for (int i = 1; i < line.length(); i++) {
                if (Math.abs(line.charAt(i) - line.charAt(i - 1)) != Math.abs(reverse.charAt(i) - reverse.charAt(i - 1))) {
                    funny = false;
                    break;
                }
            }

            if (funny) {
                System.out.println("Funny");
            } else {
                System.out.println("Not Funny");
            }

        }

    }
}
