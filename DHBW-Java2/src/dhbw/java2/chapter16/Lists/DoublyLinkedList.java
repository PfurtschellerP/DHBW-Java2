package dhbw.java2.chapter16.Lists;
public class DoublyLinkedList extends LinkedList {
    private Node last = null;               // letzter Knoten der Liste

    /**
     * Liefert den letzten Knoten der Liste, der als Ausgangspunkt für einen umgekehrten Listendurchlauf dient.
     * 
     * @return letzter Knoten der Liste
     */
    public Node getLast() {
        return last;
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
            if (first != null) {
                first.setPrevious(node);
            }
            node.setPrevious(null);
            node.setNext(first);
            first = node;
        } else if (contains(previous)) {    // hinter Vorgängerknoten einfügen
            if (previous.getNext() != null) {
                previous.getNext().setPrevious(node);
            }
            node.setPrevious(previous);
            node.setNext(previous.getNext());
            previous.setNext(node);
        } else {
            throw new IllegalStateException("Der Vorgängerknoten " + previous + " ist nicht in der Liste enthalten.");
        }
        if (node.getNext() == null) {       // ggf. letzten Knoten aktualisieren
            last = node;
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
        } else if (!contains(node)){
            throw new IllegalStateException("Der zu entfernende Knoten " + node + " ist nicht in der Liste enthalten.");
        } else {                            // anderen Knoten entfernen
            node.getPrevious().setNext(node.getNext());
        }
        if (node.getNext() == null) {       // Zeiger auf Vorgänger aktualisieren
            last = node.getPrevious();
        } else {
            node.getNext().setPrevious(node.getPrevious());
        }
        node.setPrevious(null);             // entfernten Knoten zurücksetzen
        node.setNext(null);
    }
}