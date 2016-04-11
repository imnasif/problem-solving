package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import me.nasif.uva.ac.P10004_Bicoloring;

public class Pangrams {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(P10004_Bicoloring.class.getClassLoader().getResource("HackerRank/Pangrams-in.txt").getFile()));
//        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        Set set = new HashSet();
        for (int i = 0; i < line.length(); i++) {
            set.add(Character.toLowerCase(line.charAt(i)));
        }

        if (set.size() == 27) {
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }
}
