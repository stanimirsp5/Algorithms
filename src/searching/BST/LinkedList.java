package searching.BST;
//import com.sun.jdi.Value;
import java.security.Key;
public class LinkedList<Key, Value> {
        private Node first;
        private class Node
        {
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
            for (Node x = first; x != null; x = x.next) {
                if(x.key == key){
                    x.val = val;
                    return;
                }
            }
            first = new Node(key,val, first);
        }

        public void show(){
            for (Node nextNode = first; nextNode != null ; nextNode = nextNode.next) {
                System.out.println("all vals "+nextNode.val);
            }
        }
    }
