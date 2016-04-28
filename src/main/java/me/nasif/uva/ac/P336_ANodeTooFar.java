package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P336_ANodeTooFar {

    static int n, caseNo;
    static boolean[][] g;
    static Scanner scan;
    static HashMap<Integer, Integer> nodes;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/336.txt"));
//        scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            n = scan.nextInt();
            if (n == 0) {
                break;
            }
            nodes = new HashMap<>();
            g = new boolean[2 * n][2 * n];

            while (n-- != 0) {
                int v1 = getValue(scan.nextInt());
                int v2 = getValue(scan.nextInt());
                g[v1][v2] = true;
                g[v2][v1] = true;
            }

            while (scan.hasNext()) {
                int v = scan.nextInt();
                int d = scan.nextInt();
                if (v == 0 && d == 0) {
                    break;
                }
                System.out.printf("Case %d: %d nodes not reachable from node %d with TTL = %d.\n", ++caseNo, getResult(v, d), v, d);
            }

        }

    }

    private static int getValue(int v) {
        if (!nodes.containsKey(v)) {
            nodes.put(v, nodes.size());
        }
        return nodes.get(v);
    }

    private static int getResult(int vertex, int distance) {

        if (!nodes.containsKey(vertex)) {
            return nodes.size();
        }

        int root = getValue(vertex);

        Queue q = new LinkedList();
        int dist[] = new int[nodes.size()];
        Arrays.fill(dist, -1);
        q.add(root);
        dist[root] = 0;
        while (!q.isEmpty()) {
            int curr = (int) q.remove();
            for (int i = 0; i < nodes.size(); i++) {
                if (g[curr][i] && dist[i] == -1) {
                    q.add(i);
                    dist[i] = dist[curr] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > distance || dist[i] < 0) {
                ++res;
            }
        }

        return res;
    }

}
