package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 UVA 100 The 3n + 1 problem AC
 Ad Hoc
 Cache required to avoid TLE
 */

public class P100 {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static final Map map = new HashMap<>();

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(P100.class.getClassLoader().getResource("uva-100-in.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(P100.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();

        int a, b;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();

            out.printf("%d %d %d\n", a, b, getReuslt(a, b));
        }

    }

    private static int getCount(int num) {
        if (map.containsKey(num)) {
            return (int) map.get(num);
        } else {
            int count = 0;
            int n = num;
            while (n != 1) {
                ++count;
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = n * 3 + 1;
                }
            }
            map.put(num, ++count);
            return count;
        }
    }

    private static int getReuslt(int a, int b) {

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int result = 0;
        for (int i = a; i <= b; i++) {
            int res = getCount(i);
            if (res > result) {
                result = res;
            }
        }
        return result;
    }

}
