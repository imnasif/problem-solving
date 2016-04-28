package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class P10044_ErdosNumbers {

    private static Scanner scan;
    private static int k, n, m;
    private static Map<String, Integer> dist;
    private static Map<String, ArrayList<String>> graph;
    private static Queue<String> q;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/10044.txt"));
//        scan = new Scanner(System.in);

        k = scan.nextInt();
        scan.nextLine();
        int caseN = 0;
        while (k-- != 0) {
            n = scan.nextInt();
            m = scan.nextInt();
            scan.nextLine();
            graph = new HashMap<>();
            while (n-- != 0) {
                String[] ns = scan.nextLine().split(":")[0].split(",");
                List<String> names = new ArrayList<>();

                for (int x = 0; x < ns.length; x += 2) {
                    names.add((ns[x].trim() + "," + ns[x + 1].trim()).replaceAll(" ", ""));
                }

                for (String self : names) {
                    if (!graph.containsKey(self)) {
                        graph.put(self, new ArrayList<>());
                    }
                    ArrayList<String> value = new ArrayList<>();
                    for (String neigh : names) {
                        if (!neigh.equals(self) && !value.contains(neigh)) {
                            value.add(neigh);
                        }
                    }
                    graph.get(self).addAll(value);
                }

            }

            q = new LinkedList();
            dist = new HashMap<>();
            q.add("Erdos,P.");
            dist.put("Erdos,P.", 0);

            while (!q.isEmpty()) {
                String cur = q.remove();
                for (String neigh : graph.get(cur)) {
                    if (!dist.containsKey(neigh)) {
                        dist.put(neigh, dist.get(cur) + 1);
                        q.add(neigh);
                    }
                }
            }

            System.out.printf("Scenario %d\n", ++caseN);
            while (m-- != 0) {
                String a = scan.nextLine();
                if (dist.get(a.replaceAll(" ", "")) == null) {
                    System.out.printf("%s infinity\n", a);
                } else {
                    System.out.printf("%s %d\n", a, dist.get(a.replaceAll(" ", "")));
                }

            }
        }

    }

}
