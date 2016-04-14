package me.nasif.hackerrank.algo.wa;

import java.util.Scanner;

public class P10055_HashmatTheBraveWarrior {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            System.out.println(Math.abs(scan.nextLong() - scan.nextLong()));
        }

    }

}
