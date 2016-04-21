package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P383_ShippingRoutes {

    private static Scanner scan;
    private static int nv, ne, nq;
    private static boolean[][] g;
    private static ArrayList<String> nodes;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/383.txt"));
//        scan = new Scanner(System.in);

        System.out.printf("%s\n\n", "SHIPPING ROUTES OUTPUT");

        int c = scan.nextInt();
        int caseNo = 1;

        while (c-- != 0) {
            System.out.printf("DATA SET  %d\n", caseNo++);
            System.out.println();
            nv = scan.nextInt();
            ne = scan.nextInt();
            nq = scan.nextInt();
            scan.nextLine();
            nodes = new ArrayList<>(Arrays.asList(scan.nextLine().split(" ")));
            g = new boolean[nv][nv];
            for (int i = 0; i < ne; i++) {
                int v1 = nodes.indexOf(scan.next());
                int v2 = nodes.indexOf(scan.next());
                scan.nextLine();
                g[v1][v2] = true;
                g[v2][v1] = true;
            }

            while (nq-- != 0) {

                int size = scan.nextInt();
                String v1 = scan.next();
                String v2 = scan.next();
                if (scan.hasNextLine()) {
                    scan.nextLine();
                }
                int src = nodes.indexOf(v1);
                int dest = nodes.indexOf(v2);

                int[] dist = new int[nv];
                Arrays.fill(dist, -1);

                Queue q = new LinkedList();
                q.add(src);
                dist[src] = 0;

                while (!q.isEmpty()) {
                    int cur = (int) q.remove();
                    for (int i = 0; i < dist.length; i++) {
                        if (g[cur][i] && dist[i] == -1) {
                            q.add(i);
                            dist[i] = dist[cur] + 1;
                        }
                    }

                }

                if (dist[dest] == -1) {
                    System.out.printf("%s\n", "NO SHIPMENT POSSIBLE");
                } else {
                    System.out.printf("$%d\n", 100 * size * dist[dest]);
                }
            }

            System.out.println();

        }

        System.out.printf("%s\n", "END OF OUTPUT");

    }

}
