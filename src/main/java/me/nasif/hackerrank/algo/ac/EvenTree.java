package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EvenTree {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("res/HackerRank/EvenTree.txt"));
//        Scanner scan = new Scanner(System.in);

       
        int v = scan.nextInt();
        int e = scan.nextInt();
        boolean[][] g = new boolean[v][v];
        for (int i = 0; i < e; i++) {
            int v1 = scan.nextInt() - 1;
            int v2 = scan.nextInt() - 1;
            g[v1][v2] = true;
            g[v2][v1] = true;
        }

        boolean[] visited = new boolean[v];
        int[] parentOf = new int[v];
        Arrays.fill(parentOf, -1);
        int[] childrenCount = new int[v];
        Queue q = new LinkedList();
        int root = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int s = (int) q.remove();
            for (int i = 0; i < v; i++) {
                if (g[s][i] && !visited[i]) {
                    q.add(i);
                    int parent = s;
                    parentOf[i] = parent;
                    ++childrenCount[parent];
                    while (parent != root) {
                        parent = parentOf[parent];
                        ++childrenCount[parent];
                    }
                }
            }
            visited[s] = true;
        }

        int res = 0;

        for (int i = 1; i < childrenCount.length; i++) {
            if (childrenCount[i] % 2 != 0) {
                ++res;
            }
        }
        System.out.println(res);
    }
}
