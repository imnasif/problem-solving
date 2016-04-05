package me.nasif.hackerrank.wa;

import java.io.File;
import java.util.Scanner;

public class SherlockAndTheBeast {

    private static Scanner scanner;

    private static void initScanner() {
        try {
            scanner = new Scanner(new File(SherlockAndTheBeast.class.getClassLoader().getResource("HackerRank/SherlockAndTheBeast-in.txt").getFile()));
        } catch (Exception ex) {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) {
        initScanner();
        int digits = 0, cases = scanner.nextInt();
        while (cases-- != 0) {
            digits = scanner.nextInt();
            if (digits % 3 == 0) {
                while (digits-- != 0) {
                    System.out.print(5);
                }
                System.out.println();
            } else if (digits % 5 == 0) {
                while (digits-- != 0) {
                    System.out.print(3);
                }
                System.out.println();
            } else {
                boolean yes = false;
                for (int i = 0; i * 5 < digits; i++) {
                    if ((digits - i * 5) % 3 == 0) {
                        int n3 = i * 5;
                        int n5 = digits - n3;
                        while (n5-- != 0) {
                            System.out.print(5);
                        }
                        while (n3-- != 0) {
                            System.out.print(3);
                        }
                        System.out.println();
                        yes = true;
                        break;
                    }
                }
                if(!yes){
                    System.out.println(-1);
                }
            }
        }
    }
}
