package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class P10004_Bicoloring {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/10004.txt"));
//        scan = new Scanner(System.in);

        int v, e;
        while (scan.hasNextInt()) {
            v = scan.nextInt();
            if (v == 0) {
                break;
            }
            e = scan.nextInt();

            boolean[][] g = new boolean[v][v];
            for (int i = 0; i < e; i++) {
                int v1 = scan.nextInt();
                int v2 = scan.nextInt();
                g[v1][v2] = true;
                g[v2][v1] = true;
            }

            int[] color = new int[v];
            boolean[] visited = new boolean[v];
            Queue<Integer> q = new LinkedList<>();

            q.add(0);
            color[0] = 1;
            boolean colorable = true;
            while (!q.isEmpty()) {
                int s = q.remove();
                for (int i = 0; i < v; i++) {
                    if (g[s][i] && !visited[i]) {
                        visited[s] = true;
                        q.add(i);
                        if (color[i] == color[s]) {
                            colorable = false;
                            break;
                        }

                        if (color[s] == 1) {
                            color[i] = 2;
                        } else {
                            color[i] = 1;
                        }

                    }
                }
                if (!colorable) {
                    break;
                }
            }

            if (colorable) {
                System.out.println("BICOLORABLE.");
            } else {
                System.out.println("NOT BICOLORABLE.");
            }

        }
    }
}
