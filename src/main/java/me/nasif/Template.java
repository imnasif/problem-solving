package me.nasif;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Template {

    private static final boolean readFromFile = true;
    private static final PrintWriter out = new PrintWriter(System.out, true);
    private static Scanner scanner;

    private static final Map map = new HashMap<>();

    private static void initScanner() {
        if (readFromFile) {
            try {
                scanner = new Scanner(new File(Template.class.getClassLoader().getResource("INPUT_FILE_NAME.txt").getFile()));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Template.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            scanner = new Scanner(System.in);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        initScanner();
        readInt();

    }

    private static void readInt() {
        int a;
        while (scanner.hasNextInt()) {
            a = scanner.nextInt();
            out.printf("%d\n", a);
        }
    }

}
