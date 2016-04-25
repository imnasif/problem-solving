package me.nasif.uva.wa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class P200_RareOrder {

    private static Scanner scan;
    private static HashMap<Character, Integer> inDegree = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/UVA/200.txt"));
//        scan = new Scanner(System.in);
        while (true) {
            char[] s = scan.nextLine().toCharArray();
            if (s[0] == '#') {
                inDegree = new HashMap<>();
                break;
            }

            inDegree.put(s[0], 0);
            for (int i = 1; i < s.length; i++) {
                if (!inDegree.containsKey(s[i])) {
                    inDegree.put(s[i], 0);
                }
                inDegree.put(s[i], inDegree.get(s[i - 1]) + 1);
            }
//            System.out.println(Arrays.toString(s));
            System.out.println(inDegree);
        }

    }

}
