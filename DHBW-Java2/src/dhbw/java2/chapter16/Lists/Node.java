package dhbw.java2.chapter16.Lists;
public class Node {
    private Node previous = null;   // Vorgängerknoten (oder null, falls erster)
    private Node next = null;       // Nachfolgerknoten (oder null, falls letzter)
    private int value;              // eigentliche Daten

    public Node(int value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}