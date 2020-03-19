package searching.RedBlackBST;

public class Main {
    public static void main(String[] args){
        RedBlack rb = new RedBlack();
        rb.put(-6781,'a');
        rb.put(8,'b');
        rb.put(5,'c');
        rb.put(3,'d');
        rb.put(76,'e');
        rb.put(56,'f');
        System.out.println(rb.get(5));
    }
//    public static void main(String[] args) {
//        RedBlack0<String, Integer> st = new RedBlack0<String, Integer>();
//        for (int i = 0; !StdIn.isEmpty(); i++) {
//            String key = StdIn.readString();
//            st.put(key, i);
//        }
//        StdOut.println();
//        for (String s : st.keys())
//            StdOut.println(s + " " + st.get(s));
//        StdOut.println();
//    }
}
