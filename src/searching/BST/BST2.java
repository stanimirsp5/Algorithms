package searching.BST;

import com.sun.jdi.Value;

import java.security.Key;

public class BST2<Key extends Comparable<Key>, Value> {

    Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int n;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public void put(Key key, Value val) {
       root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node first) {

        if (first == null) {
            return new Node(key, val, 1);
        }
        if(first.key.compareTo(key) > 0){ // left
            first.left = put(key, val, first.left);
        } else if(first.key.compareTo(key) < 0){ // right
            first.right = put(key, val, first.right);
        } else{ // == 0
           first.val = val;
        }
        first.n = size(first.left) + size(first.right) + 1;
        return first;
    }

    public void get(Key key){
        get(key, root);
    }
    private void get(Key key, Node node){
//         if (node == null) {
//             return new Node(key, val, 1);
//         }
        int comp = node.key.compareTo(key);
        if(comp < 0) { // left
            get(key, node.left);
        } else if(comp > 0){ // right
            get(key, node.right);
        }else if (comp == 0){
            System.out.println("search hit for key "+ node.key + " and val " + node.val);
        }
    }
    public int size(){
       return size(root);
    }
    private int size(Node node){
        if(node == null) return 0;
        else return node.n;
    }
    public Key min(){
        Key k = min(root);
        return k;
    }
    private Key min(Node node){
        if(node.left == null) return node.key;
        return min(node.left);
    }

    public Key max(){
        Key k = max(root);
        return k;
    }
    private Key max(Node node){
        if(node.right == null) return node.key;
        return max(node.right);
    }

    public Key floor(Key key){
        Node node = floor(root,key);
        return node.key;
    }

    private Node floor(Node node, Key key){
        if(node == null) return null;
        int comp = key.compareTo(node.key); // 3 < 5 => -1
        if(comp == 0) return node;
        if(comp < 0){ // left
            return floor(node.left,key);
        }
        Node t =  floor(node.right, key);
        if(t != null) return t;
        else return node;
    }

    public Key deleteMin(){
       Node node = deleteMin(root);
       return node.key;
    }
    private Node deleteMin(Node node){
        Node nodeToDel = null;
            if(node.left == null) {
                nodeToDel = node;// new Node(node.key, node.val, node.n);
                node = null;
            }
           deleteMin(node.left);
            return nodeToDel;
    }
}
