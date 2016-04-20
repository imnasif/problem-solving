package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JourneyToTheMoon {

    private static boolean[] visited;
    private static final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static final HashMap<Integer, Integer> country = new HashMap<>();

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/JourneyToTheMoon.txt"));
//        scan = new Scanner(System.in);
        int v, e;
        v = scan.nextInt();
        e = scan.nextInt();
        visited = new boolean[v];

        for (int i = 0; i < e; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            addEdge(v1, v2);
            addEdge(v2, v1);
        }

        int countryCode = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> key : graph.entrySet()) {
            int parent = key.getKey();
            if (!visited[parent]) {
                country.put(++countryCode, 1);
                visit((int) parent, countryCode);
            }
        }

        long t = ((long) v * ((long) v - 1)) / 2;
        for (Map.Entry<Integer, Integer> key : country.entrySet()) {
            t -= ((long) key.getValue() * ((long) key.getValue() - 1)) / 2;
        }
        System.out.println(t);
    }

    private static void addEdge(int v1, int v2) {
        if (!graph.containsKey(v1)) {
            graph.put(v1, new ArrayList<>(Arrays.asList(v2)));
        } else {
            graph.get(v1).add(v2);
        }

    }

    private static void visit(int parent, int countryCode) {
        visited[parent] = true;
        ArrayList<Integer> children = graph.get(parent);
        children.stream()
                .filter((child) -> (!visited[(int) child]))
                .forEach((child) -> {
                    country.put(countryCode, country.get(countryCode) + 1);
                    visit((int) child, countryCode);
                });
    }

}
