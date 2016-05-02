package me.nasif.uva.ac;

import java.io.*;
import java.util.*;

public class P978_Lemmings_Battle {

    private static class Sc {

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

    private static Sc sc;
    private static int k, bf, ng, nb;
    private static Queue<Integer> g, b;
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

    public static void main(String[] args) throws Exception {
        sc = new Sc("res/UVA/978.txt");
//        sc = new Sc();
        k = sc.nextInt();
        while (k-- != 0) {
            bf = sc.nextInt();
            ng = sc.nextInt();
            nb = sc.nextInt();
            g = new PriorityQueue<>(ng, Collections.reverseOrder());
            b = new PriorityQueue<>(nb, Collections.reverseOrder());
            while (ng-- != 0) {
                g.add(sc.nextInt());
            }
            while (nb-- != 0) {
                b.add(sc.nextInt());
            }

            while (getMinBf() != 0) {
                ArrayList<Integer> gs = new ArrayList<>();
                ArrayList<Integer> bs = new ArrayList<>();
                for (int i = 0; i < bf; i++) {
                    gs.add(g.poll());
                    bs.add(b.poll());

                }
                for (int i = 0; i < bf; i++) {
                    int pg = gs.get(i);
                    int pb = bs.get(i);
                    if (pg > pb) {
                        g.offer(pg - pb);
                    }
                    if (pb > pg) {
                        b.offer(pb - pg);
                    }
                }

            }

            if (g.isEmpty() && b.isEmpty()) {
                out.println("green and blue died");

            } else if (b.isEmpty()) {
                out.println("green wins");
                while (!g.isEmpty()) {
                    out.println(g.poll());
                }
            } else {
                out.println("blue wins");
                while (!b.isEmpty()) {
                    out.println(b.poll());
                }
            }

            if (k != 0) {
                out.println();
            }

        }

    }

    private static int getMinBf() {
        bf = Math.min(bf, Math.min(g.size(), b.size()));
        return bf;
    }

}
