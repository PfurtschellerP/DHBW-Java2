package dhbw.java2.chapter16.Lists;
public class LinkedList implements List {
    protected Node first = null;            // erster Knoten der Liste

    /**
     * Liefert den ersten Knoten der Liste, der als Ausgangspunkt für einen Listendurchlauf dient.
     * 
     * @return erster Knoten der Liste
     */
    public Node getFirst() {
        return first;
    }

    @Override
    public void insert(Node node, Node previous) {
        if (node == null) {
            throw new NullPointerException("Der einzufügende Knoten darf nicht null sein.");
        }
        if (contains(node)) {
            throw new IllegalStateException("Der einzufügende Knoten " + node + " ist bereits in der Liste enthalten.");
        }
        if (previous == null) {             // am Beginn der Liste einfügen
            node.setNext(first);
            first = node;
        } else if (contains(previous)) {    // hinter Vorgängerknoten einfügen
            node.setNext(previous.getNext());
            previous.setNext(node);
        } else {
            throw new IllegalStateException("Der Vorgängerknoten " + previous + " ist nicht in der Liste enthalten.");
        }
    }

    @Override
    public void remove(Node node) {
        if (node == null) {
            throw new NullPointerException("Der zu entfernende Knoten darf nicht null sein.");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Die Liste ist leer.");
        }
        if (first == node) {                // ersten Knoten entfernen
            first = node.getNext();
        } else {                            // Vorgängerknoten suchen
            Node current = first;
            while (current != null && current.getNext() != node) {
                current = current.getNext();
            }
            if (current == null) {          // kein Vorgängerknoten gefunden
                throw new IllegalStateException("Der zu entfernende Knoten " + node + " ist nicht in der Liste enthalten.");
            }
            current.setNext(node.getNext());// darauf folgenden Knoten entfernen
        }
        node.setNext(null);                 // entfernten Knoten zurücksetzen
    }

    @Override
    public boolean contains(Node node) {
        if (node == null) {
            return false;                   // alternativ: NullPointerException werfen
        }
        Node current = first;
        while (current != null && current != node) {
            current = current.getNext();    // Liste durchlaufen, bis Ende oder Treffer
        }
        return current != null;
    }

    @Override
    public Node search(int value, Node start) {
        if (start == null) {
            start = first;                  // Suche am Listenbeginn starten
        } else if (!contains(start)) {
            throw new IllegalStateException("Der Startknoten " + start + " ist nicht in der Liste enthalten.");
        }
        Node current = start;
        while (current != null && current.getValue() != value) {
            current = current.getNext();    // Liste durchlaufen, bis Ende oder Treffer
        }
        return current;
    }

    @Override
    public int getLength() {
        int count = 0;
        Node current = first;
        while (current != null) {
            current = current.getNext();    // Liste durchlaufen, bis Ende
            count++;                        // dabei die Knoten zählen
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        String result = "Liste der Länge " + getLength() + ": ";
        Node current = first;
        while (current != null) {
            result += " " + current;
            current = current.getNext();    // Liste durchlaufen, bis Ende
        }
        return result;
    }
    
//    private Node getLast() {
//    	Node current = first;
//    	while(current.getNext() != null) {
//    		current = current.getNext();
//    	}
//    	return current;
//    }
//    
//    public LinkedList reverse(LinkedList list) {
//    	LinkedList newList = new LinkedList();
//    	newList.first = list.getLast();
//    	
//    }
}