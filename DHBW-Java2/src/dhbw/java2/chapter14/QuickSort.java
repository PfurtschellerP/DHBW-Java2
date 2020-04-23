package dhbw.java2.chapter14;
public class QuickSort<T extends Comparable<T>> extends SortingAlgorithm<T> {

    @Override
    protected void sort(int startIndex, int endIndex) {
        if (startIndex + 1 < endIndex) {
            int leftIndex = startIndex - 1;
            int rightIndex = endIndex - 1;
            do {
                while (isLessThan(++leftIndex, endIndex - 1));                                  // der linke Index läuft von links ins Feld, solange der zugehörige Wert kleiner als das Pivotelement ist
                while (--rightIndex > leftIndex && isGreaterThan(rightIndex, endIndex - 1));    // der rechte Index läuft von rechts ins Feld, solange der zugehörige Wert größer als das Pivotelement ist
                if (leftIndex < rightIndex) {                                                   // sind beide verschieden, ...
                    swap(leftIndex, rightIndex);                                                // ... wird der linke Wert mit dem rechten Wert vertauscht
                }
            } while (leftIndex < rightIndex);                                                   // der Vorgang wiederholt sich, bis beide Indizes zusammenstoßen
            if (leftIndex != endIndex - 1) {
                swap(leftIndex, endIndex - 1);                                                  // der Treffpunkt wird mit dem Pivotelement vertauscht, es sei denn beide stimmen überein
            }
            sort(startIndex, leftIndex);                                                        // der linke Teil wird rekursiv sortiert
            sort(leftIndex + 1, endIndex);                                                      // der rechte Teil wird rekursiv sortiert
        }
    }

    public static void main(String[] args) {
        new SortingAlgorithmEvaluator<Integer>().evaluate(
            new QuickSort<>(), new Integer[] { 5, 4, 8, 6, 3, 10, 2, 7, 9, 1 }, true
        );
    }
}