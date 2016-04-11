package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JourneyToTheMoon {

    private static boolean[] visited;
    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static final HashMap<Integer, Integer> country = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(JourneyToTheMoon.class.getClassLoader().getResource("HackerRank/JourneyToTheMoon-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        int v, e;
        v = scan.nextInt();
        e = scan.nextInt();
        visited = new boolean[v];

        for (int i = 0; i < e; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();

            if (!graph.containsKey(v1)) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(v2);
                graph.put(v1, l);
            } else {
                graph.get(v1).add(v2);
            }
            if (!graph.containsKey(v2)) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(v1);
                graph.put(v2, l);
            } else {
                graph.get(v2).add(v1);
            }
        }

        int countryCode = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> key : graph.entrySet()) {
            int parent = key.getKey();
            if (!visited[parent]) {
                country.put(++countryCode, 1);
                visit((int) parent, countryCode);
            }
        }

        long t = ((long)v * ((long)v - 1)) / 2;
        for (Map.Entry<Integer, Integer> key : country.entrySet()) {
            t -= ((long)key.getValue() * ((long)key.getValue() - 1)) / 2;
        }
        System.out.println(t);
    }

    private static void visit(int parent, int countryCode) {
        visited[parent] = true;
        ArrayList<Integer> children = graph.get(parent);
        for (Object child : children) {
            if (!visited[(int) child]) {
                country.put(countryCode, country.get(countryCode) + 1);
                visit((int) child, countryCode);
            }
        }
    }

}
