package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(ShortestReach.class.getClassLoader().getResource("HackerRank/ShortestReach-in.txt").getFile()));
//        Scanner scanner = new Scanner(System.in);
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
            int[] distance = new int[v];
            Arrays.fill(distance, -1);

            q.add(s);
            distance[s] = 0;
            while (!q.isEmpty()) {
                int c = q.remove();
                for (int i = 0; i < v; i++) {
                    if (g[c][i] && distance[i] == -1) {
                        q.add(i);
                        distance[i] = distance[c] + 6;
                    }
                }
            }

            for (int i = 0; i < distance.length; i++) {
                if (distance[i] != 0) {
                    System.out.print(distance[i] + " ");
                }
            }

            System.out.println();
        }
    }
}
