package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SherlockAndSquares {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/SherlockAndSquares.txt"));
//        scan = new Scanner(System.in)
        
        int cases, a, b;
        cases = scan.nextInt();
        while (cases-- != 0) {
            a = scan.nextInt();
            b = scan.nextInt();
            int res = (int) Math.ceil(Math.sqrt(b) - 1) - (int) Math.ceil(Math.sqrt(a) - 1);
            if ((int) Math.pow((int) Math.sqrt(b), 2) == b) {
                ++res;
            }
            System.out.println(res);

        }
    }
}
