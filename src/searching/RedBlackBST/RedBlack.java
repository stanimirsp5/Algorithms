package searching.RedBlackBST;

//import com.sun.jdi.Value;

import java.util.EmptyStackException;

public class RedBlack <Key extends Comparable<Key>, Value>{

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = true;
    private class Node{
        int n;
        Node left,right;
        Key key;
        Value val;
        boolean color;

        public Node(Key key,Value val, int n, boolean color){
            this.key = key;
            this.val = val;
            this.n = n;
            this.color = color;
        }
    }
    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }
    public int size() {
        return size(root);
    }
    private int size(Node x){
        if(x == null) return 0;
        return x.n;
    }

//    private Node rotateLeft(Node h){
//        Node x = h.right;
//        h.right = x.left;
//        x.left = h;
//        x.color = h.color;
//        h.color = RED;
//        x.n = h.n;
//        h.n = 1 + size(h.left) + size(h.right);
//        return x;
//    }
//    private Node rotateRight(Node h){
//        Node x = h.left;
//        h.left = x.right;
//        x.right = h;
//        x.color = h.color;
//        h.color = RED;
//        x.n = h.n;
//        h.n = 1 + size(h.left) + size(h.right);
//        return x;
//    }
    private Node rotateRight(Node h) {
        // assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return x;
    }

    // make a right-leaning link lean to the left
    private Node rotateLeft(Node h) {
        // assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.n = h.n;
        h.n = size(h.left) + size(h.right) + 1;
        return x;
    }
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    public void put(Key key, Value val){
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val){
        if(h == null)
            return new Node(key, val, 1, RED);

        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key,val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.right)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    public Key get(Key key){
       Node node = get(root, key);
       return node.key;
    }
    private Node get(Node node, Key key){
        if(root == null) return node;
        int comp = node.key.compareTo(key);
        // 1 bigger // -1 smaller // 0 equal
        if(comp > 0){
           return get(node.right, key);
        }else if(comp < 0){
            return get(node.left, key);
        }else{
            return node;
        }
    }
}
