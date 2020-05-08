package dhbw.java2.chapter16.Lists;

public interface List {

    /**
     * Fügt den neuen Knoten hinter dem angegebenen Knoten in die Liste ein.
     * 
     * @param node Knoten, der eingefügt werden soll
     * @param previous Vorgängerknoten (oder <code>null</code>,
     *        wenn der neue Knoten am Beginn der Liste eingefügt werden soll)
     * @throws NullPointerException wenn der einzufügende Knoten <code>null</code> ist
     * @throws IllegalStateException wenn der einzufügende Knoten bereits in der Liste ist
     *                               oder wenn der Vorgängerknoten nicht in der Liste ist
     */
    void insert(Node node, Node previous);

    /**
     * Entfernt den angegebenen Knoten aus der Liste.
     * 
     * @param node Knoten, der entfernt werden soll
     * @throws NullPointerException wenn der zu entfernende Knoten <code>null</code> ist
     * @throws IllegalStateException wenn der zu entfernende Knoten nicht in der Liste ist
     */
    void remove(Node node);

    /**
     * Prüft, ob der angegebene Knoten in der Liste enthalten ist.
     * 
     * @param node
     * @return <code>true</code> gdw. die Liste den Knoten enthält
     */
    boolean contains(Node node);

    /**
     * Sucht beginnend bei dem vorgegebenen Startknoten den nächsten Knoten aus der Liste,
     * der den angegebenen Wert enthält.
     * 
     * @param value Wert, der übereinstimmen soll
     * @param start Startknoten (oder <code>null</code>, wenn die Suche am Beginn der Liste starten soll)
     * @return der nächste Listenknoten, dessen Wert dem vorgegebenen gleicht
     *         (oder <code>null</code>, falls es keinen solchen gibt)
     * @throws IllegalStateException wenn der Startknoten nicht in der Liste ist
     */
    Node search(int value, Node start);

    /**
     * Liefert die Länge der Liste, das heißt die Anzahl der enthaltenen Knoten.
     * 
     * @return Länge der Liste
     */
    int getLength();

    /**
     * Prüft, ob die Liste leer ist, also ob sie keine Knoten enthält.
     * 
     * @return <code>true</code> gdw. die Liste leer ist
     */
    boolean isEmpty();
}