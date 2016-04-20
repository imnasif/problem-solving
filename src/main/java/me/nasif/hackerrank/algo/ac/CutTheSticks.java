package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/CutTheSticks.txt"));
//        scan = new Scanner(System.in);
        
        int n;
        List<Integer> l = new ArrayList();
        n = scan.nextInt();
        while (n-- != 0) {
            l.add(scan.nextInt());
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
