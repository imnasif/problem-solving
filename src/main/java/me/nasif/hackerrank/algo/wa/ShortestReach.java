package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(ShortestReach.class.getClassLoader().getResource("HackerRank/ShortestReach-in.txt").getFile()));
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
            boolean[][] g = new boolean[v][v];
            for (int i = 0; i < e; i++) {
                int v1 = scanner.nextInt() - 1;
                int v2 = scanner.nextInt() - 1;
                g[v1][v2] = true;
                g[v2][v1] = true;
            }
            s = scanner.nextInt() - 1;
            Queue<Integer> q = new LinkedList<>();
            Map<Integer, Boolean> explored = new HashMap<>();
            Map<Integer, Integer> distance = new HashMap<>();
            for (int i = 0; i < v; i++) {
                explored.put(i, false);
                distance.put(i, -1);
            }

            q.add(s);
            distance.put(s, 0);
            while (!q.isEmpty()) {
                int c = q.remove();
                for (int i = 0; i < v; i++) {
                    if (g[c][i] && !explored.get(i)) {
                        q.add(i);
                        distance.put(i, distance.get(c) + 6);
                    }
                }
                explored.put(c, true);
            }

            for (Map.Entry<Integer, Integer> key : distance.entrySet()) {
                if (key.getValue() != 0) {
                    System.out.print(key.getValue() + " ");
                }
            }
            System.out.println();
        }
    }
}
