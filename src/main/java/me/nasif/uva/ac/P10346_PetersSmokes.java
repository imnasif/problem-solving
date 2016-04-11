package me.nasif.uva.ac;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Scanner;

/*
Ad Hoc : AC
*/

public class P10346_PetersSmokes {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(P10346_PetersSmokes.class.getClassLoader().getResource("UVA/10346-in.txt").getFile()));
//        Scanner scanner = new Scanner(System.in);
        
        int a, b;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            out.printf("%d\n", getResult(a, b));
        }
    }

    public static int getResult(int n, int k) {
        int result = n;
        while (n >= k) {
            result += n / k;
            n = n / k + n % k;
        }
        return result;
    }

}
