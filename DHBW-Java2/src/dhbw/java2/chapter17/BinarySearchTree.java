package dhbw.java2.chapter17;
public class BinarySearchTree implements SortedList {
    private BinaryTreeNode root = null;             // Wurzel des binären Suchbaums
    private int size = 0;                           // Anzahl der Knoten des Baums

    BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(BinaryTreeNode node, int value) {
        if (node == null) {                         // leerer Teilbaum: gesuchter Wert ist nicht enthalten
            return false;
        }
        if (value == node.getValue()) {             // Wert gleich der Wurzel: gesuchter Wert gefunden
            return true;
        } else if (value < node.getValue()) {       // Wert kleiner als Wurzel: im linken Teilbaum suchen
            return contains(node.getLeft(), value);
        } else {                                    // Wert größer als Wurzel: im rechten Teilbaum suchen
            return contains(node.getRight(), value);
        }
    }
    
    @Override
    public void insert(int value) {
        root = insert(root, value);
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {                     // leerer Teilbaum: durch neuen Knoten ersetzen
            size++;
            return new BinaryTreeNode(value);
        }
        if (value < node.getValue()) {          // Wert kleiner als Wurzel: in linken Teilbaum einfügen
            node.setLeft(insert(node.getLeft(), value));
        } else {                                // sonst: in rechten Teilbaum einfügen
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }
    
    @Override
    public void remove(int value) {
        root = remove(root, value);
    }

    private BinaryTreeNode remove(BinaryTreeNode node, int value) {
        if (node == null) {                         // leerer Teilbaum: fertig
            return null;
        }
        if (value == node.getValue()) {             // Wert gleich der Wurzel: der aktuelle Knoten muss entfernt werden
            if (node.getLeft() == null) {           // linker Teilbaum leer: Baum durch rechten Teilbaum ersetzen
                size--;
                return node.getRight();
            } else if (node.getRight() == null) {   // rechter Teilbaum leer: Baum durch linken Teilbaum ersetzen
                size--;
                return node.getLeft();
            } else {                                // sonst: Knotenwert durch Minimum des rechten Teilbaums ersetzen
                int minimum = getMinimum(node.getRight());
                node.setValue(minimum);
                node.setRight(remove(node.getRight(), minimum));
            }
        } else if (value < node.getValue()) {       // Wert kleiner als Wurzel: aus linkem Teilbaum entfernen
            node.setLeft(remove(node.getLeft(), value));
        } else {                                    // Wert größer als Wurzel: aus rechtem Teilbaum entfernen
            node.setRight(remove(node.getRight(), value));
        }
        return node;
    }

    private int getMinimum(BinaryTreeNode node) {
        return node.getLeft() == null ? node.getValue() : getMinimum(node.getLeft());
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode node) {
        return node == null ? -1 : 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    @Override
    public String toString() {
        return "BinarySearchTree of height " + getHeight() + " with " + getSize() + " nodes: " + toString(root);
    }

    private String toString(BinaryTreeNode node) {
        return node == null ? "" : "(" + toString(node.getLeft()) + node.getValue() + toString(node.getRight()) + ")";
    }
    
    public boolean isAVL(BinaryTreeNode root) {
    	if(root.getLeft() == null && root.getRight() == null) {
    		return true;
    	}
    	if (Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight())) > 1) {
    		return false;
    	} 
    	boolean left = root.getLeft() == null ? true : isAVL(root.getLeft());					// Umgehen der Null Pointer Exceptions
    	boolean right = root.getRight() == null ? true : isAVL(root.getRight());
    	
    	if (!(left && right)) {
    		return false;
    	}
    	
    	return true;
    }
}