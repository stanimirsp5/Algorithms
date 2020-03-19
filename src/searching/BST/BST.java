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
       root = put(root, key, val);
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
        if(comp == 0) return node; // if we find the key, that's the floor
        if(comp < 0){ // if we go on the left, we find the floor of the one on the left
            return floor(node.left,key);
        }
        Node t =  floor(node.right, key); // if we go on the right
        if(t != null) return t; // return floor of the right subtree
        else return node; // return root itself
    }

    public Key ceiling(Key key){
        Node node = ceiling(root,key);
        return node.key;
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

    public Key select(int k){
        if(k < 0 || k >= size()) throw new IllegalArgumentException();
        Node x = select(root,k);
        return x.key;
    }
    private Node select(Node node, int k){
        // Return node containing key of rank k
        if(node == null) return null;
        int t = size(node.left);
        if(t > k) return select(node.left, k);
        else if(t < k)return select(node.right, k-t-1);
        else return node;
    }

    public int rank(Key key){
        return rank(key, root);
    }

    /** How many keys < k */
    private int rank(Key key, Node node){
        // Return number of keys less than key in the subtree rooted at 'node'
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) return rank(key, node.left);
        else if(cmp > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
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
