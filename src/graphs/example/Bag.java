package graphs.example;
import java.util.Iterator;

public class Bag<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int size;

    public int size() {
        return size;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        size++;
    }


}