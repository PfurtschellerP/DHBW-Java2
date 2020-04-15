package dhbw.java2.chapter14;
public class BubbleSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

    @Override
    protected void sort(int startIndex, int endIndex) {
        for (int count = 0; count < endIndex - startIndex - 1; count++) {           // zählt, wie viele Elemente am rechten Rand bereits stabil sind
            for (int index = startIndex; index + 1 < endIndex - count; index++) {   // durchläuft den noch unsortierten Bereich von links nach rechts
                if (isGreaterThan(index, index + 1)) {
                    swap(index, index + 1);                                         // vertauscht ein benachbartes Paar, das verkehrt herum steht
                }
            }
        }
    }

    public static void main(String[] args) {
        new SortingAlgorithmEvaluator<Integer>().evaluate(
            new BubbleSort<>(), new Integer[] { 5, 4, 8, 6, 3, 10, 2, 7, 9, 1 }, true
//        	new BubbleSort<>(), new Integer[] { 5,2,1,7,4,6,3 }, true
        );
    }
}