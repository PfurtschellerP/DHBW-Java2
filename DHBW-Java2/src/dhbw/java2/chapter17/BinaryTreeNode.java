package dhbw.java2.chapter17;
class BinaryTreeNode {
    private int value;                      // Daten des Knotens

    private BinaryTreeNode left = null;     // linker Kindknoten
    private BinaryTreeNode right = null;    // rechter Kindknoten

    BinaryTreeNode(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
    void setValue(int value) {
        this.value = value;
    }

    BinaryTreeNode getLeft() {
        return left;
    }
    void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    BinaryTreeNode getRight() {
        return right;
    }
    void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}