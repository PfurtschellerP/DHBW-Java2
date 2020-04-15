package dhbw.java2.chapter14;
import java.util.Arrays;

public abstract class SortingAlgorithm<T extends Comparable<T>> {
    private T[] values;                                     // Feld mit den zu sortierenden Werten
    private long comparisonCount;                           // Anzahl der durchgeführten Vergleiche
    private long swapCount;                                 // Anzahl der durchgeführten Vertauschungen
    private boolean verbose;                                // Flag für Konsolenausgabe

    /**
     * Sortiert den angegebenen Abschnitt des vorgegebenen Feldes aufsteigend.
     * 
     * @param startIndex linker Rand (inkl.)
     * @param endIndex rechter Rand (exkl.)
     */
    protected abstract void sort(int startIndex, int endIndex);

    /**
     * Prüft, ob die erste Feldkomponente kleiner ist als die zweite.
     * 
     * @param first Index der ersten Feldkomponente
     * @param second Index der zweiten Feldkomponente
     * @return <code>true</code> gdw. die erste Komponente kleiner ist als die zweite
     */
    protected final boolean isLessThan(int first, int second) {
        comparisonCount++;
        return values[first].compareTo(values[second]) < 0;
    }

    /**
     * Prüft, ob die erste Feldkomponente größer ist als die zweite.
     * 
     * @param first Index der ersten Feldkomponente
     * @param second Index der zweiten Feldkomponente
     * @return <code>true</code> gdw. die erste Komponente größer ist als die zweite
     */
    protected final boolean isGreaterThan(int first, int second) {
        comparisonCount++;
        return values[first].compareTo(values[second]) > 0;
    }

    /**
     * Prüft, ob die erste Feldkomponente gleich der zweiten ist.
     * 
     * @param first Index der ersten Feldkomponente
     * @param second Index der zweiten Feldkomponente
     * @return <code>true</code> gdw. die erste Komponente gleich der zweiten ist
     */
    protected final boolean isEqualTo(int first, int second) {
        comparisonCount++;
        return values[first].compareTo(values[second]) == 0;
    }

    /**
     * Vertauscht die erste Feldkomponente mit der zweiten.
     * 
     * @param first Index der ersten Feldkomponente
     * @param second Index der zweiten Feldkomponente
     */
    protected final void swap(int first, int second) {
        swapCount++;
        T tmp = values[first];
        values[first] = values[second];
        values[second] = tmp;
        if (verbose) {
            printSwap(first, second);
        }
    }

    /**
     * Visualisiert die Vertauschung in der Konsole.
     * 
     * @param first Index der ersten Feldkomponente
     * @param second Index der zweiten Feldkomponente
     */
    private void printSwap(int first, int second) {
        for (int index = 0; index < values.length; index++) {
            boolean swapped = (index == first || index == second);
            System.out.print("" + (swapped ? '<' : ' ') + values[index] + (swapped ? '>' : ' ') + ' ');
        }
        System.out.println();
    }

    /**
     * Sortiert das Feld und zählt die dabei durchgeführten Vergleiche und Vertauschungen.
     * 
     * @param values zu sortierendes Feld
     * @param verbose Konsolenausgabe aktivieren?
     */
    public final void sort(T[] values, boolean verbose) {
        this.values = values;
        this.verbose = verbose;
        comparisonCount = swapCount = 0;
        if (verbose) {
            System.out.println(getClass().getSimpleName());
            for (int index = 0; index < values.length; index++) {
                System.out.print(" " + values[index] + "  ");
            }
            System.out.println();
        }
        sort(0, values.length);
    }

    /**
     * Liefert die Anzahl der durchgeführten Vergleiche.
     * 
     * @return Anzahl der Vergleiche
     */
    public final long getComparisonCount() {
        return comparisonCount;
    }

    /**
     * Liefert die Anzahl der durchgeführten Vertauschungen.
     * 
     * @return Anzahl der Vertauschungen
     */
    public final long getSwapCount() {
        return swapCount;
    }

    @Override
    public String toString() {
        return Arrays.toString(values) + " #comparisons=" + comparisonCount + " #swaps=" + swapCount;
    }
}