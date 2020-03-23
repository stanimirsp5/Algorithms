package graphs;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class In {
//    String pathName = "G:\\Documents\\Projects\\Algorithms\\src\\sources\\tinyG.txt";
    private Scanner scanner;

    public In(String pathName) throws FileNotFoundException {
        scanner = new Scanner(new FileReader(pathName));
    }

    public int readInt() throws FileNotFoundException {
        //Scanner in = new Scanner(new FileReader(pathName));
        return scanner.nextInt();
    }
}
//public In(String name) throws FileNotFoundException {
//        File file = new File(pathName);
//        if (file.exists()) {
//            // for consistency with StdIn, wrap with BufferedInputStream instead of use
//            // file as argument to Scanner
//            FileInputStream fis = new FileInputStream(file);
//            scanner = new Scanner(new BufferedInputStream(fis), CHARSET_NAME);
//            scanner.useLocale(LOCALE);
//            return;
//        }
//        scanner.useLocale(LOCALE);
//}
//    public int readInt() {
//        try {
//            return scanner.nextInt();
//        }
//        catch (InputMismatchException e) {
//            String token = scanner.next();
//            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
//                    + "but the next token is \"" + token + "\"");
//        }
//        catch (NoSuchElementException e) {
//            throw new NoSuchElementException("attemps to read an 'int' value from the input stream, "
//                    + "but no more tokens are available");
//        }
//    }

