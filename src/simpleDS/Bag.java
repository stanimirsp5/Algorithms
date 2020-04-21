package simpleDS;

//import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int size;


    private class Node{
        Item item;
        Node next;
    }

    public int size(){ return size;}

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
    private boolean hasNext(Node node){
        return node.next != null;
    }

    public void print(){
        Node node = first;
        while (true){
            System.out.println(node.item);
            if(!hasNext(node)){
                break;
            }
            node = node.next;
        }
    }
    public int[] getConnectedVertices(){
        Node node = first;
        int[] connectedVertices = new int[size];
        int i =0;
        while (true){
            connectedVertices[i] =Integer.parseInt(node.item.toString()); // attempting to cast an Object to an int
            if(!hasNext(node)){
                break;
            }
            node = node.next;
            i++;
        }
        return connectedVertices;
    }

    //@NotNull // p.155 from the book
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }
        public void remove(){}
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
