package me.nasif.templates;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

public class IO {

    private static Sc read;
    private static final PrintWriter write = new PrintWriter(new BufferedOutputStream(System.out), true);
    private static int n;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        read = new Sc("res/.txt");
        read = new Sc();
        n = read.nextInt();

    }

}
