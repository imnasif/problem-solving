package me.nasif.uva.ac;

import java.io.*;
import java.util.*;

public class P12502_ThreeFamilies {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/12502.txt"));
//        scan = new Scanner(System.in);

        int k = scan.nextInt();
        while (k-- != 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int m = scan.nextInt();
            System.out.println(m*(2*a-b)/(a+b));
        }

    }

}
