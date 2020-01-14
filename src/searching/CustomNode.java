package searching;

import java.util.Arrays;

public class CustomNode<Key, Value>  {
    private Node first;

    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    public void add(Key key, Value val){
        first = new Node(key, val, first);
    }
    public void show(){
        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.val);
        }
    }
}
