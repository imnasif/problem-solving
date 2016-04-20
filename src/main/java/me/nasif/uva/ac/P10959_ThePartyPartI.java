package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P10959_ThePartyPartI {

    private static int v, e;
    private static boolean[][] g;
    private static int[] dist;
    private static Queue q;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("res/UVA/12442.txt"));
//        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n-- != 0) {
            v = scan.nextInt();
            e = scan.nextInt();
            g = new boolean[v][v];
            dist = new int[v];
            Arrays.fill(dist, -1);
            while (e-- != 0) {
                int v1 = scan.nextInt();
                int v2 = scan.nextInt();
                g[v1][v2] = true;
                g[v2][v1] = true;
            }
            q = new LinkedList();
            q.add(0);
            dist[0] = 0;
            while (!q.isEmpty()) {
                int cur = (int) q.remove();
                for (int i = 0; i < v; i++) {
                    if (g[cur][i] && dist[i] == -1) {
                        q.add(i);
                        dist[i] = dist[cur] + 1;
                    }
                }
            }
            for (int i = 1; i < dist.length; i++) {
                System.out.println(dist[i]);
            }

            if (n != 0) {
                System.out.println();
            }

        }

    }

}
