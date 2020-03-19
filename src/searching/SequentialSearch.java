package searching;

public class SequentialSearch<Key, Value> {
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
    public Value get(Key key){
        for (Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)){
                return x.val;  // search hit
            }
        }
        return null; // search miss
    }
    public void put(Key key, Value val){ // Search for key
        for (Node x = first; x != null ; x = x.next) {
            if(key.equals(x.key)){
                x.val = val; // search hit: update value
                return;
            }
        }
        first = new Node(key, val, first); // search miss: add new node
    }
}
