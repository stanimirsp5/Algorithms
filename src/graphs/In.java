package graphs;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class In {
    private Scanner scanner;

    public In(String pathName) throws FileNotFoundException {
        scanner = new Scanner(new FileReader(pathName));
    }

    public int readInt() {
        return scanner.nextInt();
    }
}

