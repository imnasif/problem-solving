package me.nasif.uva.ac;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11080_PlaceTheGuards {

    static class Sc {

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

    private static Sc read;
    private static final PrintWriter write = new PrintWriter(new BufferedOutputStream(System.out), true);
    private static int n, v, e;
    private static boolean[][] g;
    private static boolean[] visited;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        read = new Sc("res/UVA/11080.txt");
//        read = new Sc();
        n = read.nextInt();
        while (n-- != 0) {
            v = read.nextInt();
            e = read.nextInt();
            g = new boolean[v][v];
            visited = new boolean[v];

            while (e-- != 0) {
                int v1 = read.nextInt();
                int v2 = read.nextInt();
                g[v1][v2] = true;
                g[v2][v1] = true;
            }

            System.out.println(getResult());

        }

    }

    private static int getResult() {
        int res = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                int c = getMin(i);
                if (c == -1) {
                    res = -1;
                    break;
                }
                res += c;
            }
        }
        return res;
    }

    private static int getMin(int src) {

        int[] color = new int[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 1;
        while (!q.isEmpty()) {
            int cur = q.remove();
            visited[cur] = true;
            for (int i = 0; i < v; i++) {
                if (g[cur][i] && !visited[i]) {
                    if (color[i] == color[cur]) { // not bipartite
                        return -1;
                    }
                    q.add(i);
                    color[i] = -1 * color[cur];
                }
            }
        }

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < color.length; i++) {
            if (color[i] > 0) {
                ++c1;
            }
            if (color[i] < 0) {
                ++c2;
            }

        }
        int min = Math.min(c1, c2);
        return min == 0 ? 1 : min;
    }

}
