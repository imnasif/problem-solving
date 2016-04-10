package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManasaAndStones {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(ManasaAndStones.class.getClassLoader().getResource("HackerRank/ManasaAndStones-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- != 0) {
            int n = scan.nextInt() - 1;
            int a = scan.nextInt();
            int b = scan.nextInt();

            if (a == b) {
                System.out.println(n * a);

            } else {
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }

                int start = n * a;
                int end = n * b;
                int diff = b - a;

                for (int i = start; i <= end; i += diff) {
                    System.out.print(i + " ");
                }
                System.out.println("");

            }

        }
    }
}
