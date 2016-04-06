package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiceLane {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(ServiceLane.class.getClassLoader().getResource("HackerRank/ServiceLane-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int n, t;
        n = scanner.nextInt();
        t = scanner.nextInt();
        List<Integer> l = new ArrayList();
        while (n-- != 0) {
            l.add(scanner.nextInt());
        }
        while (t-- != 0) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
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
