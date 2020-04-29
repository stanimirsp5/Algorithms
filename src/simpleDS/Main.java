package simpleDS;

public class Main {
    public static void main(String[] args) {

//        Bag bag = new Bag();
////        bag.add("test");
////        bag.add(123);
////        bag.add("asd");
////        bag.add("asd2");
////        bag.add(5465460);
////        bag.print();

        System.out.println(recNum(5));
    }
    public static int recNum(int num){
        if(num > 6){
            return num;
        }
        num += recNum(num + 1);
        return num;
    }
}
