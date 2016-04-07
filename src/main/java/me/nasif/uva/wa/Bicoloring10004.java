package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Bicoloring10004 {

    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        
        scanner = new Scanner(new File(Bicoloring10004.class.getClassLoader().getResource("UVA/Bicoloring10004-in.txt").getFile()));
        scanner = new Scanner(System.in);

        int v, e;
        while (scanner.hasNextInt()) {
            v = scanner.nextInt();
            if (v == 0) {
                break;
            }
            e = scanner.nextInt();

            boolean[][] g = new boolean[v][v];
            for (int i = 0; i < e; i++) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
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
