package dhbw.java2.chapter17;
public class BinaryTreeDemo {

    private static void printContainedValues(BinarySearchTree tree) {
        System.out.print("contains:");
        for (int value = 0; value <= 13; value++) { // Test für die Werte 0 bis 13
            if (tree.contains(value)) {
                System.out.print(" " + value );     // Ausgabe falls im Baum enthalten
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryTreePrinter.printDiagram(tree);       // Ausgabe des Baumdiagramms
        printContainedValues(tree);                 // Ausgabe der enthaltenen Knoten

        for (int value : new int[] {6, 4, 1, 11, 8, 3, 7, 10, 5, 9, 12, 2}) {
            tree.insert(value);                     // Knoten einfügen
            BinaryTreePrinter.printDiagram(tree);
            System.out.println(tree.isAVL(tree.getRoot()));;
            printContainedValues(tree);
        }

//      System.out.println();                       // 17.3.5 Traversierungen ausgeben
//      BinaryTreeTraversal.printInorder(tree);
//      BinaryTreeTraversal.printPreorder(tree);
//      BinaryTreeTraversal.printPostorder(tree);
//      BinaryTreeTraversal.printLevelorder(tree);
//      System.out.println();

//      for (int value : new int[] {5, 4, 10, 8, 1, 6, 3, 12, 2, 7, 11, 9}) {
//          tree.remove(value);                     // 17.3.4 Knoten entfernen
//          BinaryTreePrinter.printDiagram(tree);
//          printContainedValues(tree);
//      }
    }
}