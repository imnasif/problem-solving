package me.nasif.uva.ac;

import java.io.*;
import java.util.*;

public class P12602_NiceLicencePlates {

    private static Scanner scan;
    private static int k;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/12602.txt"));
//        scan = new Scanner(System.in);

        k = scan.nextInt();
        scan.nextLine();
        while (k-- != 0) {
            String[] l = scan.nextLine().split("-");
            char[] ca = l[0].toCharArray();
            int n1 = Integer.parseInt(l[1]);
            int n2 = 0;
            for (int i = 0; i < ca.length; i++) {
                n2 += (ca[i] - 65) * (int) Math.pow(26, ca.length - 1 - i);
            }

            int res = Math.abs(n1 - n2);
            if (res <= 100) {
                System.out.println("nice");
            } else {
                System.out.println("not nice");
            }

        }

    }

}
