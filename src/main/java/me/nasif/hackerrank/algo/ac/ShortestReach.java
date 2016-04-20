package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestReach {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/ShortestReach.txt"));
//        scan = new Scanner(System.in)

        int t, v, e, s;
        t = scan.nextInt();
        while (t-- != 0) {
            v = scan.nextInt();
            e = scan.nextInt();
            boolean[][] g = new boolean[v][v];
            for (int i = 0; i < e; i++) {
                int v1 = scan.nextInt() - 1;
                int v2 = scan.nextInt() - 1;
                g[v1][v2] = true;
                g[v2][v1] = true;
            }
            s = scan.nextInt() - 1;

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
