package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLadders {

    private static Scanner scan;
    private static int k, nl, ns;
    private static Map<Integer, ArrayList<Integer>> g;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/SnakesAndLadders.txt"));
//        scan = new Scanner(System.in);

        k = scan.nextInt();
        while (k-- != 0) {
            g = new HashMap<>();
            for (int i = 1; i <= 100; i++) {
                ArrayList l = new ArrayList();
                for (int j = 1; j < 7; j++) {
                    if (i + j <= 100) {
                        l.add(i + j);
                    }

                }
                g.put(i, l);
            }

            nl = scan.nextInt();
            while (nl-- != 0) {
                int lf = scan.nextInt();
                int lt = scan.nextInt();
                for (int i = lf - 6; i < lf; i++) {
                    if (i > 0) {
                        g.get(i).remove(new Integer(lf));
                        g.get(i).add(lt);
                        g.get(lf).clear();
                        Collections.sort(g.get(i));
                    }
                }
            }
            ns = scan.nextInt();
            while (ns-- != 0) {
                int sf = scan.nextInt();
                int st = scan.nextInt();
                for (int i = sf - 6; i < sf; i++) {
                    g.get(i).remove(new Integer(sf));
                }
            }

            int[] dist = new int[101];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList();
            q.add(1);
            dist[1] = 0;
            boolean found = false;
            while (!q.isEmpty()) {
                int cur = q.remove();
                for (Integer node : g.get(cur)) {
                    if (dist[node] == -1) {
                        dist[node] = dist[cur] + 1;
                        q.add(node);
                    }
                    if (node == 100) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }

            }
            System.out.println(dist[100]);

        }

    }

}
