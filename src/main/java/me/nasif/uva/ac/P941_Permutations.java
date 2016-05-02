package me.nasif.uva.ac;

import java.util.Scanner;

public class P941_Permutations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLong()) {
            long s = scan.nextLong();
            if (s == 0) {
                return;
            }

            long x, y;
            long b = (long) Math.floor(Math.sqrt(s)) + 1;
            long d = s - (b - 1) * (b - 1);

            if (d == 0) {
                x = 1;
                y = b - 1;
            } else if (d <= b) {
                x = d;
                y = b;
            } else {
                x = b;
                y = 2 * b - d;
            }

            if (b % 2 == 1) {
                long temp = x;
                x = y;
                y = temp;
            }

            System.out.println(x + " " + y);
        }
    }
}
