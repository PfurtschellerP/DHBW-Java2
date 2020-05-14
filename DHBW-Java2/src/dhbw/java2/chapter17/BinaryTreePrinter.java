package dhbw.java2.chapter17;
import java.util.Arrays;

public class BinaryTreePrinter {

    private static final char[] NODES = new char[] {
        '⓪', '①', '②', '③', '④', '⑤', '⑥', '⑦', '⑧', '⑨',         // u24EA, u2460, …, u2468
        '⑩', '⑪', '⑫', '⑬', '⑭', '⑮', '⑯', '⑰', '⑱', '⑲',         // u2469, …, u2472
        '⑳', '㉑', '㉒', '㉓', '㉔', '㉕', '㉖', '㉗', '㉘', '㉙',         // u2473, u3251, …, u3259
        '㉚', '㉛', '㉜', '㉝', '㉞', '㉟', '㊱', '㊲', '㊳', '㊴',         // u325A, …, u325F, u32B1, …, u32B4
        '㊵', '㊶', '㊷', '㊸', '㊹', '㊺', '㊻', '㊼', '㊽', '㊾', '㊿'    // u32B5, …, u32BF
    };
    private static final char LEFT = '╱', RIGHT = '╲', EMPTY = ' ';     // u2571, u2572

    /**
     * Gibt eine pseudo-graphische Darstellung des binären Suchbaums in der Konsole aus.
     * 
     * @param tree binärer Suchbaum mit Knotenwerten im Bereich von 0 bis 50
     * @throw ArrayIndexOutOfBoundsException gdw. der Baum enthält Knotenwerte kleiner 0 oder größer 50
     */
    public static void printDiagram(BinarySearchTree tree) {
        BinaryTreeNode[] nodes = new BinaryTreeNode[] {tree.getRoot()};
        int maxLevel = tree.getHeight();
        for (int level = 0; level <= maxLevel; level++) {
            nodes = print(nodes, level, maxLevel);
        }
    }

    private static BinaryTreeNode[] print(BinaryTreeNode[] nodes, int level, int maxLevel) {
        BinaryTreeNode[] nextNodes = new BinaryTreeNode[2 << level];
        int nextNodesCount = 0;
        char[] spaces = new char[level == maxLevel ? 0 : (2 << (maxLevel - level - 1)) - 1];
        Arrays.fill(spaces, EMPTY);
        for (BinaryTreeNode node : nodes) {
            print(spaces, false, false, node == null ? EMPTY : NODES[node.getValue()]);
            print(spaces, false, false, EMPTY);
        }
        System.out.println();
        if (level < maxLevel) {
            for (BinaryTreeNode node : nodes) {
                boolean hasLeftChild = node != null && node.getLeft() != null;
                boolean hasRightChild = node != null && node.getRight() != null;
                nextNodes[nextNodesCount++] = hasLeftChild ? node.getLeft() : null;
                nextNodes[nextNodesCount++] = hasRightChild ? node.getRight() : null;
                print(spaces, hasLeftChild, false, EMPTY);
                print(spaces, false, hasRightChild, EMPTY);
            }
            System.out.println();
        }
        return nextNodes;
    }

    private static void print(char[] spaces, boolean left, boolean right, char tail) {
        if (left) {
            spaces[3 * spaces.length / 4] = LEFT;
        } else if (right) {
            spaces[spaces.length / 4] = RIGHT;
        }
        for (char space : spaces) {
            System.out.print(space + " ");
        }
        System.out.print(tail + (tail == EMPTY ? " " : ""));
        if (left || right) {
            spaces[spaces.length / 4] = spaces[3 * spaces.length / 4] = EMPTY;
        }
    }
}