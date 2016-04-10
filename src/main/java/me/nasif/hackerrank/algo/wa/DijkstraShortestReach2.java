package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraShortestReach2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(DijkstraShortestReach2.class.getClassLoader().getResource("HackerRank/DijkstraShortestReach2-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        int cases;
        cases = scan.nextInt();
        while (cases-- != 0) {
            int v, e, s;
            v = scan.nextInt();
            e = scan.nextInt();
            int[][] g = new int[v][v];
            for (int[] row : g) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int i = 0; i < e; i++) {
                int v1 = scan.nextInt() - 1;
                int v2 = scan.nextInt() - 1;
                int w = scan.nextInt();
                if (w < g[v1][v2]) {
                    g[v1][v2] = w;
                    g[v2][v1] = w;
                }
            }
            s = scan.nextInt();

            int[] distance = new int[v];
            Arrays.fill(distance, Integer.MAX_VALUE);
            PriorityQueue pq = new PriorityQueue();
            pq.add(10);
            pq.add(5);
            pq.add(8);
            pq.add(7);
            pq.add(-1);
            pq.add(3);

            Iterator it = pq.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
                it.remove();
            }

        }
    }
}
