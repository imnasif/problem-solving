package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
 Ad Hoc : AC
 */
public class P10346_PetersSmokes {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/10346.txt"));
//        scan = new Scanner(System.in)

        int a, b;
        while (scan.hasNextInt()) {
            a = scan.nextInt();
            b = scan.nextInt();
            out.printf("%d\n", getResult(a, b));
        }
    }

    private static int getResult(int n, int k) {
        int result = n;
        while (n >= k) {
            result += n / k;
            n = n / k + n % k;
        }
        return result;
    }

}
