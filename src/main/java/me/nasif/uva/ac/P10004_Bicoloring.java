package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/*
 Flood FIll : AC
 */
public class P10004_Bicoloring {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/10004.txt"));
//        scan = new Scanner(System.in)

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

            Map<Integer, Boolean> explored = new HashMap<>();
            Map<Integer, Integer> color = new HashMap<>();
            Queue<Integer> q = new LinkedList<>();

            for (int i = 0; i < v; i++) {
                explored.put(i, false);
                color.put(i, -1);
            }

            q.add(0);
            color.put(0, 0);
            boolean colorable = true;
            while (!q.isEmpty()) {
                int s = q.remove();
                for (int i = 0; i < v; i++) {
                    if (g[s][i] && !explored.get(i)) {
                        if ((int) color.get(i) == (int) color.get(s)) {
                            colorable = false;
                            break;
                        }
                        q.add(i);
                        if (color.get(s) == 0) {
                            color.put(i, 1);
                        } else {
                            color.put(i, 0);
                        }

                    }
                }
                explored.put(s, true);
            }

            if (colorable) {
                System.out.println("BICOLORABLE.");
            } else {
                System.out.println("NOT BICOLORABLE.");
            }

        }
    }
}
