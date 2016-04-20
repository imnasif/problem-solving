package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LonelyInteger {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/LonelyInteger.txt"));
//        scan = new Scanner(System.in);

        int n = scan.nextInt();
        List l = new ArrayList();
        while (n-- != 0) {
            l.add(scan.nextInt());
        }

        if (l.size() == 1) {
            System.out.println(l.get(0));
        } else {
            Collections.sort(l);
            int result = -1;
            for (int i = 0; i < l.size() - 1; i += 2) {
                if (l.get(i) != l.get(i + 1)) {
                    result = (int) l.get(i);
                    break;
                }
            }
            if (result == -1) {
                System.out.println(l.get(l.size() - 1));
            } else {
                System.out.println(result);
            }
        }

    }

}
