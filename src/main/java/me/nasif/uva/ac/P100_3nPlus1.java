package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 Ad Hoc : AC
*/
public class P100_3nPlus1 {

    private static final Map map = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(P100_3nPlus1.class.getClassLoader().getResource("UVA/100-in.txt").getFile()));
//        Scanner scanner = new Scanner(System.in);

        int a, b;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.printf("%d %d %d\n", a, b, getReuslt(a, b));
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
