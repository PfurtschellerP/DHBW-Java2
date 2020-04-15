package dhbw.java2.chapter14;
import java.util.Arrays;

public class SortingAlgorithmEvaluator<T extends Comparable<T>> {

    /**
     * Prüft, ob das gegebene Feld sortiert ist.
     * 
     * @param values zu prüfendes Feld
     * @return <code>true</code> gdw. keine Feldkomponente ist größer als ihr rechter Nachbar
     */
    public boolean check(T[] values) {
        for (int index = 1; index < values.length; index++) {
            if (values[index - 1].compareTo(values[index]) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluiert den Sortierungslauf des vorgegebenen Sortieralgorithmus. Dabei werden
     * Vergleiche und Vertauschungen gezählt und die Korrektheit der Sortierung geprüft.
     *
     * @param algorithm Sortieralgorithmus, der evaluiert werden soll
     * @param values zu sortierendes Feld
     * @param verbose Konsolenausgabe aktivieren?
     * @return <code>true</code> gdw. fehlerfrei sortiert wurde
     */
    public boolean evaluate(SortingAlgorithm<T> algorithm, T[] values, boolean verbose) {
        algorithm.sort(values, verbose);        // sortiert die Daten mit dem Algorithmus
        boolean ok = check(values);             // prüft, ob korrekt sortiert wurde
        if (verbose) {
            System.out.print(ok ? "ok" : "ERROR: " + Arrays.toString(values));
            System.out.print(", #Vergleiche: " + algorithm.getComparisonCount());
            System.out.print(", #Vertauschungen: " + algorithm.getSwapCount());
//          System.out.print(", #zusätzliche Speicherplätze: " + algorithm.getExtraSpace());
            System.out.println();
            System.out.println();
        }
        return ok;
    }
}