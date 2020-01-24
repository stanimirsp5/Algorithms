package searching.BST;

import com.sun.jdi.Value;

import java.security.Key;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root; // root of BST
    private class Node
    {
        Key key;
        Value val;
        Node left;  // links in subtrees
        Node right; // links in subtrees
        int n; // nodes in subtree

        public Node(Key key, Value val, int n){
            this.key = key;
            this.val = val;
            this.n = n;
        }
    }

    public Value get(Key key){
        return get(root, key);
    }
    private Value get(Node x, Key key){
        // Return value associated with key in the subtree rooted at x
        // return null
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0) {
            return get(x.left, key);
        }
        else if(cmp > 0){
            return get(x.right,key);
        }
        else {
            return x.val;
        }
    }

    public void put(Key key, Value val){
        // Search for key. Update table if found; grow table if new
        put(root, key, val);
    }
    private Node put(Node x,Key key, Value val){
        // Change key's value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = put(x.left, key, val);
        }
        else if(cmp > 0){
            x.right = put(x.right, key, val);
        }
        else{
            x.val = val;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x == null) return 0;
        else return x.n;
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

    public Key ceiling(Key key){
        Node node = ceiling(root,key);
        return node.key;
    }

    private Node ceiling(Node node, Key key){
        if(node == null) return null;
        int comp = key.compareTo(node.key);
        if(comp == 0) return node;
        if(comp < 0){ // left
            return ceiling(node.right,key);
        }
        Node t =  ceiling(node.left, key);
        if(t != null) return t;
        else return node;
    }

    public void show(){
        show(root);
    }
    private void show(Node x){



//        for (Node nextNode = first; nextNode != null ; nextNode = nextNode.next) {
//            System.out.println("all vals "+nextNode.val);
//        }
    }
}
