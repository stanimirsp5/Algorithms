public class scratches {

    public static void main(String[] args) {
        System.out.println(foo(2));
    }

    public static int foo(int num){
        if(num > 4) return 10;
        return num += foo(num + 1);
//        return num;
    }

}

