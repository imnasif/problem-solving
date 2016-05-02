package me.nasif.uva.wa;

import java.io.*;
import java.util.*;

public class P12247_Jollo {

    private static Scanner scan;
    private static final List<Integer> bl = new ArrayList<>(), gl = new ArrayList<>(), all = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/12247.txt"));
//        scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            for (int i = 0; i < 3; i++) {
                gl.add(scan.nextInt());
            }
            for (int i = 0; i < 2; i++) {
                bl.add(scan.nextInt());
            }
            all.addAll(bl);
            all.addAll(gl);
            Collections.sort(bl);
            Collections.sort(gl);
            if (cantWin()) {

            } else if (alreadyWon()) {

            } else {
                int res = getResult();
            }

        }

    }

    private static boolean cantWin() {
        return bl.get(1) < gl.get(0);
    }

    private static boolean alreadyWon() {
        return bl.get(0) > gl.get(2);
    }

    private static int getResult() {
        int min = Integer.MAX_VALUE;
        int w = 0;
        int l = 0;
        // b 0 1
        // g 0 1
        if (bl.get(0) > gl.get(0)) {
            res = 
        }

        // b 0 1
        // g 1 0
        // b 0 1
        // g 1 2
        // b 0 1
        // g 2 1
        // b 0 1
        // g 0 2
        // b 0 1
        // g 2 0
    }

}
