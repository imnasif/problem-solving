package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(BreadthFirstSearchShortestReach.class.getClassLoader().getResource("HackerRank/BreadthFirstSearchShortestReach-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int t, v, e, s;
        t = scanner.nextInt();
        while (t-- != 0) {
            v = scanner.nextInt();
            e = scanner.nextInt();
            int[][] g = new int[e][2];
            for (int i = 0; i < e; i++) {
                g[i][0] = scanner.nextInt();
                g[i][1] = scanner.nextInt();
            }
            s = scanner.nextInt();

            Queue<Integer> q = new LinkedList();
            Map<Integer, Boolean> visited = new HashMap();
            for (int i = 1; i <= v; i++) {
                visited.put(i, false);
            }

        }

    }

}
