package me.nasif.uva.ac;

import java.io.*;
import java.util.*;

public class P280_Vertex {

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

    private static Scanner read;
    private static final PrintWriter write = new PrintWriter(new BufferedOutputStream(System.out), true);
    private static int nv;
    private static boolean[][] g;
    private static boolean[] connected;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        read = new Scanner(new File("res/UVA/280.txt"));
//        read = new Scanner(System.in);
        while (read.hasNextInt()) {
            nv = read.nextInt();
            if (nv == 0) {
                break;
            }
            read.nextLine();
            g = new boolean[nv][nv];
            String l1;
            do {
                l1 = read.nextLine();
                if (l1.length() != 1) {
                    String[] a1 = l1.split(" ");
                    int v1 = Integer.parseInt(a1[0]) - 1;
                    for (int i = 1; i < a1.length - 1; i++) {
                        int v2 = Integer.parseInt(a1[i]) - 1;
                        g[v1][v2] = true;
                    }
                }

            } while (l1.length() != 1);
            String[] a2 = read.nextLine().split(" ");
            int nq = Integer.parseInt(a2[0]);

            for (int srcN = 1; srcN <= nq; srcN++) {
                int src = Integer.parseInt(a2[srcN]) - 1;
                connected = new boolean[nv];
                dfs(src);
                ArrayList<Integer> disconnected = new ArrayList<>();
                int res = 0;
                for (int i = 0; i < connected.length; i++) {
                    if (!connected[i]) {
                        disconnected.add(i);
                        ++res;
                    }
                }

                if (res != 0) {
                    write.printf("%d ", res);
                    for (int i = 0; i < disconnected.size() - 1; i++) {
                        write.printf("%d ", disconnected.get(i) + 1);
                    }
                    write.printf("%d", disconnected.get(disconnected.size() - 1) + 1);
                } else {
                    write.printf("%d", res);
                }
                write.println();
            }

        }

    }

    private static void dfs(int src) {
        for (int i = 0; i < nv; i++) {
            if (g[src][i] && !connected[i]) {
                connected[i] = true;
                dfs(i);
            }
        }
    }

}
