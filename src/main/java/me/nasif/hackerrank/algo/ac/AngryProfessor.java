package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AngryProfessor {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/AngryProfessor.txt"));
//        scan = new Scanner(System.in);
        
        int cases, n, k, a, onTime;
        cases = scan.nextInt();
        while (cases-- != 0) {
            n = scan.nextInt();
            k = scan.nextInt();
            onTime = 0;
            while (n-- != 0) {
                a = scan.nextInt();
                if (a <= 0) {
                    ++onTime;
                }
            }
            if (onTime < k) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
