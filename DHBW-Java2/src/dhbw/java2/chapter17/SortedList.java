package dhbw.java2.chapter17;
public interface SortedList {
    /**
     * Fügt den angegebenen Wert an geeigneter Stelle in die sortierte Liste ein.
     * 
     * @param value Wert, der eingefügt werden soll
     */
    void insert(int value);

    /**
     * Entfernt den angegebenen Wert aus der Liste.
     * 
     * @param value Wert, der entfernt werden soll
     */
    void remove(int value);

    /**
     * Prüft, ob der angegebene Wert in der Liste enthalten ist.
     * 
     * @param value
     * @return <code>true</code> gdw. die Liste den Wert enthält
     */
    boolean contains(int value);

    /**
     * Liefert die Länge der Liste, das heißt die Anzahl der enthaltenen Knoten.
     * 
     * @return Länge der Liste
     */
    int getSize();

    /**
     * Prüft, ob die Liste leer ist, also ob sie keine Knoten enthält.
     * 
     * @return <code>true</code> gdw. die Liste leer ist
     */
    boolean isEmpty();
}