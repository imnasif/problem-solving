package me.nasif.hackerrank.ac;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(CutTheSticks.class.getClassLoader().getResource("HackerRank/CutTheSticks-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int n;
        List<Integer> l = new ArrayList();
        n = scanner.nextInt();
        while (n-- != 0) {
            l.add(scanner.nextInt());
        }
        while (!l.isEmpty()) {
            Collections.sort(l);
            System.out.println(l.size());
            int lowest = l.get(0);
            for (int i = 0; i < l.size(); i++) {//                
                l.set(i, l.get(i) - lowest);
                if (l.get(i) == 0) {
                    l.remove(i);
                    --i;
                }
            }
        }
    }
}
