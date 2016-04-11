package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 Ad Hoc : AC
 */
public class P11172_RelationalOperators {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(P11172_RelationalOperators.class.getClassLoader().getResource("UVA/11172-in.txt").getFile()));
//        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        while (cases-- != 0) {
            int a, b;
            a = scanner.nextInt();
            b = scanner.nextInt();
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
