package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceLane {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/ServiceLane.txt"));
//        scan = new Scanner(System.in);
        
        int n, t;
        n = scan.nextInt();
        t = scan.nextInt();
        List<Integer> l = new ArrayList();
        while (n-- != 0) {
            l.add(scan.nextInt());
        }
        while (t-- != 0) {
            int i = scan.nextInt();
            int j = scan.nextInt();
            int min = Integer.MAX_VALUE;
            for (int k = i; k <= j; k++) {
                if (l.get(k) < min) {
                    min = l.get(k);
                }
            }
            System.out.println(min);
        }

    }
}
