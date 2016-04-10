package me.nasif.hackerrank.algo.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JourneyToTheMoon {

    private static boolean[][] g;
    private static int[] country;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(JourneyToTheMoon.class.getClassLoader().getResource("HackerRank/JourneyToTheMoon-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        int v, e;
        v = scan.nextInt();
        e = scan.nextInt();
        g = new boolean[v][v];

        for (int i = 0; i < e; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            g[v1][v2] = true;
            g[v2][v1] = true;
        }

        country = new int[v];
        int c = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (g[i][j] && country[i] == 0) {
                    visitNeighbours(i, ++c);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < country.length; i++) {
            if (map.containsKey(country[i])) {
                map.put(country[i], (int) map.get(country[i]) + 1);
            } else {
                map.put(country[i], 1);
            }
        }

        long t = v * (v - 1) / 2;

        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            if (key.getValue() != 0) {
                t -= key.getValue() * (key.getValue() - 1) / 2;
            }
        }

        System.out.println(t);

    }

    private static void visitNeighbours(int s, int c) {
        country[s] = c;
        for (int i = 0; i < g.length; i++) {
            if (g[s][i] && country[i] == 0) {
                visitNeighbours(i, c);
            }
        }
    }

}
