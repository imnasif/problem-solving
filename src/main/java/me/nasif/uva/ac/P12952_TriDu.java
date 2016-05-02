package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P12952_TriDu {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/12952.txt"));
//        scan = new Scanner(System.in);

        while (scan.hasNextInt()) {
            System.out.println(Math.max(scan.nextInt(), scan.nextInt()));
        }
    }

}
