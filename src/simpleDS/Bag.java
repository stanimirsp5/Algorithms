package simpleDS;

public class Bag<Item>{
    private class Node{
        Item item;
        Node next;
    }

    private Node first;
    private int size;

    public int size(){ return size;}

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }
    private boolean hasNext(Node node){
        return first.next != null;
    }
    public void print(){
        Node node = first;
        while (hasNext(node)){
            System.out.println(node.item);
            node = first.next;
        }
    }

}
