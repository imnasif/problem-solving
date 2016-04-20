package me.nasif.hackerrank.algo.ac;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
  
        int n = scan.nextInt();
        BigInteger res = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            res = res.multiply(new BigInteger(i + ""));
        }
        System.out.println(res);

    }

}
