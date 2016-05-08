package me.nasif.uva.ac;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Sc {

    BufferedReader br;
    StringTokenizer st;

    public Sc() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public Sc(String filePath) throws FileNotFoundException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        String str = "";
        str = br.readLine();
        return str;
    }
}

public class P924_SpreadingTheNews {

    private static Sc read;
    private static final PrintWriter write = new PrintWriter(new BufferedOutputStream(System.out), true);
    private static int v, nq;
    private static boolean[][] g;
    private static int[] d;
    private static Queue<Integer> q;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        read = new Sc("res/UVA/924.txt");
//        read = new Sc();
        v = read.nextInt();
        g = new boolean[v][v];
        for (int i = 0; i < v; i++) {
            int nf = read.nextInt();
            while (nf-- != 0) {
                int f = read.nextInt();
                g[i][f] = true;
            }
        }
        nq = read.nextInt();
        while (nq-- != 0) {
            int src = read.nextInt();
            d = new int[v];
            Arrays.fill(d, -1);
            q = new LinkedList<>();
            q.add(src);
            d[src] = 0;
            while (!q.isEmpty()) {
                int cur = q.remove();
                for (int i = 0; i < v; i++) {
                    if (g[cur][i] && d[i] == -1) {
                        q.add(i);
                        d[i] = d[cur] + 1;
                    }
                }
            }
            Arrays.sort(d);
            if (d[d.length - 1] == 0) {
                write.printf("%d\n", 0);
                continue;
            }

            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < d.length; i++) {
                if (d[i] > 0) {
                    if (!m.containsKey(d[i])) {
                        m.put(d[i], 1);
                    } else {
                        m.put(d[i], m.get(d[i]) + 1);
                    }
                }

            }
            int maxBoom = -1;
            int day = 0;

            for (Map.Entry<Integer, Integer> e : m.entrySet()) {
                if (e.getValue() > maxBoom) {
                    maxBoom = e.getValue();
                    day = e.getKey();
                }
            }

            write.printf("%d %d\n", maxBoom, day);

        }

    }

}
