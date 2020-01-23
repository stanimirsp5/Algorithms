package searching.BST;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
//        bst.add(1,1);
//        bst.add(3,14);
//        bst.add(2,87);
//        bst.show();
        BST2 bst2 = new BST2();
        bst2.put(14,54);
        bst2.put(3,12);
        bst2.put(5,32);

        System.out.println(bst2.max());
    }
}
