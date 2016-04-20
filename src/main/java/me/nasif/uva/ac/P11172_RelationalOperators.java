package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 Ad Hoc : AC
 */
public class P11172_RelationalOperators {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/11172.txt"));
//        scan = new Scanner(System.in)

        int cases = scan.nextInt();
        while (cases-- != 0) {
            int a, b;
            a = scan.nextInt();
            b = scan.nextInt();
            if (a < b) {
                System.out.println("<");
            } else if (a > b) {
                System.out.println(">");
            } else {
                System.out.println("=");
            }
        }
    }
}
