package searching;

public class Main {
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch(5);
//        bs.put(88,'a');
//        bs.put(2,'b');
//        bs.put(89,'c');
//        bs.put(7,'d');
//        bs.put(88,'d');
//        bs.show();
        //bs.get(88);
        CustomNode cn = new CustomNode();
        cn.add(88,'a');
        cn.add(2,'b');
        cn.add(89,'c');
        cn.add(7,'d');
        cn.add(88,'d');
        cn.show();
    }
}
