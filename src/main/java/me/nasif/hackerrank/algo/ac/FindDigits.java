package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindDigits {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/FindDigits.txt"));
//        scan = new Scanner(System.in);
 
        int cases, n;
        cases = scan.nextInt();
        while (cases-- != 0) {
            n = scan.nextInt();
            int temp, res = 0;
            temp = n;
            while (temp > 0) {
                if (temp % 10 != 0 && n % (temp % 10) == 0) {
                    ++res;
                }
                temp /= 10;
            }
            System.out.println(res);
        }
    }
}
