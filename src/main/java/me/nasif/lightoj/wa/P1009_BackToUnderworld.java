package me.nasif.lightoj.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class P1009_BackToUnderworld {

    private static Scanner scan;
    private static int nc, ne;
    private static final Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    private static final Map<Integer, Integer> color = new HashMap<>();
    private static final Set<Integer> visited = new HashSet<>();
    private static final Set<Integer> nodes = new HashSet<>();
    private static final Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/LightOJ/1009.txt"));
//        scan = new Scanner(System.in);

        nc = scan.nextInt();
        int cn = 0;

        while (nc-- != 0) {
            graph.clear();
            nodes.clear();
            visited.clear();
            ne = scan.nextInt();
            while (ne-- != 0) {
                int v1 = scan.nextInt() - 1;
                int v2 = scan.nextInt() - 1;
                nodes.add(v1);
                nodes.add(v2);
                addEdge(v1, v2);
                addEdge(v2, v1);
            }
            
            System.out.println(nodes.size());

            int res = 0;
            for (Integer node : nodes) {
                if (!visited.contains(node)) {
                    res += getMax(node);
                }

            }
            System.out.printf("Case %d: %d\n", ++cn, res);

        }
    }

    private static void addEdge(int v1, int v2) {
        if (!graph.containsKey(v1)) {
            graph.put(v1, new ArrayList<>(Arrays.asList(v2)));
        } else {
            graph.get(v1).add(v2);
        }
    }

    private static int getMax(int src) {
        q.clear();
        color.clear();

        q.add(src);
        color.put(src, 1);

        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int neigh : graph.get(cur)) {
                if (!visited.contains(neigh)) {
                    color.put(neigh, color.get(cur) * -1);
                    q.add(neigh);
                }
            }
            visited.add(cur);
        }

        int colA = 0, colB = 0;
        for (Map.Entry<Integer, Integer> c : color.entrySet()) {
            if (c.getValue() > 0) {
                ++colA;
            } else {
                ++colB;
            }
        }
        return Math.max(colA, colB);

    }

}
