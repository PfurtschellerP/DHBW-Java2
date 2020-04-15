package dhbw.java2.chapter14;
public class InsertionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

    @Override
    protected void sort(int startIndex, int endIndex) {
        for (int sortedIndex = startIndex; sortedIndex + 1 < endIndex; sortedIndex++) {                         // sortierter Bereich wächst von links nach rechts
            for (int index = sortedIndex; index >= startIndex && isGreaterThan(index, index + 1); index--) {    // der nächste Wert rutscht solange nach links, ...
                swap(index, index + 1);                                                                         // ... bis der linke Nachbar nicht mehr größer ist
            }
        }
    }

    public static void main(String[] args) {
        new SortingAlgorithmEvaluator<Integer>().evaluate(
        	new InsertionSort<>(), new Integer[] { 5, 4, 8, 6, 3, 10, 2, 7, 9, 1 }, true
//        	new InsertionSort<>(), new Integer[] {5,2,1,7,4,6,3}, true
        );
    }
}