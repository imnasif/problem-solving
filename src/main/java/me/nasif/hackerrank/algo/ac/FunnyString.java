package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import me.nasif.hackerrank.algo.wa.CaesarCipher;

public class FunnyString {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(CaesarCipher.class.getClassLoader().getResource("HackerRank/FunnyString-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
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
