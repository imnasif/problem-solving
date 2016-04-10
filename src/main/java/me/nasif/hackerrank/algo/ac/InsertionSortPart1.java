package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InsertionSortPart1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(InsertionSortPart1.class.getClassLoader().getResource("HackerRank/InsertionSortPart1-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);
        int s, v;
        s = scan.nextInt();
        int[] arr = new int[s];

        for (int i = 0; i < s; i++) {
            arr[i] = scan.nextInt();
        }
        v = arr[s - 1];
        int p = 0;

        for (int i = s - 2; i >= 0 && arr[i] > v; i--) {
            arr[i + 1] = arr[i];
            p = i;
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println("");
        }
        arr[p] = v;

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println("");

    }

}
