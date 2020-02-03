package searching.BST;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        //BST2 bst = new BST2();
        bst.put(1,1);
        bst.put(3,14);
        bst.put(2,87);
        bst.put(7,654);
        bst.put(6,25);
        bst.put(9,7);
        bst.put(12,9);

        System.out.println("min: "+bst.min());
        //System.out.println("Deleted min: "+bst.deleteMin());
//        bst.show();

//        BST2 bst2 = new BST2();
//        bst2.put(14,54);
//        bst2.put(3,12);
//        bst2.put(5,32);
//
//        System.out.println(bst2.floor(15));
    }
}
