package dhbw.java2.chapter14;
public class SelectionSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

    @Override
    protected void sort(int startIndex, int endIndex) {
        for (int sortedIndex = startIndex; sortedIndex + 1 < endIndex; sortedIndex++) { // sortierter Bereich wächst von links nach rechts
            int minIndex = findMinIndex(sortedIndex, endIndex);                         // bestimme Minimum des restlichen Feldes und ...
            if (minIndex != sortedIndex) {
                swap(sortedIndex, minIndex);                                            // ... vertausche es ggf. mit erstem Wert desselben
            }
        }
    }

    private int findMinIndex(int startIndex, int endIndex) {                            // sucht das Minimum im Bereich startIndex bis endIndex-1
        int minIndex = startIndex;
        for (int index = startIndex + 1; index < endIndex; index++) {
            if (isLessThan(index, minIndex)) {
                minIndex = index;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        new SortingAlgorithmEvaluator<Integer>().evaluate(
//            new SelectionSort<>(), new Integer[] { 5, 4, 8, 6, 3, 10, 2, 7, 9, 1 }, true
            new SelectionSort<>(), new Integer[] {5,2,1,7,4,6,3}, true
        );
    }
}