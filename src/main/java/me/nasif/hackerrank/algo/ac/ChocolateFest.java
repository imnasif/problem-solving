package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChocolateFest {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/ChocolateFest.txt"));
//        scan = new Scanner(System.in);
        
        int t, n, c, m;
        t = scan.nextInt();
        while (t-- != 0) {
            n = scan.nextInt();
            c = scan.nextInt();
            m = scan.nextInt();
            int canBuy = n / c;
            int result = canBuy;

            while (canBuy >= m) {
                result += canBuy / m;
                canBuy = canBuy / m + canBuy % m;
            }
            System.out.println(result);
        }
    }
}
