package searching.ListSerach;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SequentialSerach unorderedLinkedList = new SequentialSerach();
        unorderedLinkedList.put(3,'d');
        unorderedLinkedList.put(0,'a');
        unorderedLinkedList.put(2,'c');
        unorderedLinkedList.put(1,'b');
        unorderedLinkedList.get(2);
    }
}
