package simpleDS;

public class Bag<Item>{
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

}
