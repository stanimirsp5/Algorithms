public class scratches {
//$ java MyProg -f file.txt
// https://stackoverflow.com/questions/890966/what-is-string-args-parameter-in-main-method-java
    // javac scratches.java - compile code
    // java scratches -f file.txt pass arguments
    public static void main(String[] args) {
        System.out.println(args.length);
//        System.out.println(foo(2));
    }

    public static int foo(int num){
        if(num > 4) return 10;
        return num += foo(num + 1);
//        return num;
    }

}
