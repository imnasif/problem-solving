package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scan = new Scanner(new File(FibonacciModified.class.getClassLoader().getResource("HackerRank/FibonacciModified-in.txt").getFile()));
        Scanner scan = new Scanner(System.in);
        int n;
        BigInteger a, b;
        a = scan.nextBigInteger();
        b = scan.nextBigInteger();
        n = scan.nextInt();
        BigInteger[] val = new BigInteger[n];
        val[0] = a;
        val[1] = b;

        for (int i = 2; i < n; i++) {
            val[i] = (val[i - 1].pow(2)).add(val[i - 2]);
        }
        System.out.println(val[n - 1]);
    }

}
