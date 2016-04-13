package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P12442_ForwardingEmails {

    static int v;
    static int[] g;
    static boolean[] visited;
    static int[] children;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(P12442_ForwardingEmails.class.getClassLoader().getResource("UVA/12442-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int caseNo = 1;

        while (caseNo++ <= n) {
            v = scan.nextInt();
            g = new int[v];
            children = new int[v];
            visited = new boolean[v];
            for (int i = 0; i < v; i++) {
                g[scan.nextInt() - 1] = scan.nextInt() - 1;
            }

            for (int i = 0; i < v; i++) {
                
            }

            int max = 0;
            int res = 0;
            for (int i = 0; i < children.length; i++) {
                System.out.printf("%d has %d children\n", i + 1, children[i]);
                if (children[i] > max) {
                    max = children[i];
                    res = i;
                }
            }
            System.out.printf("Case %d: %d\n", caseNo, res + 1);;
        }

    }

    private static int getNextChild(int root) {
        System.out.printf("%d %d\n", root, g[root]);
        return g[root];
    }

}
