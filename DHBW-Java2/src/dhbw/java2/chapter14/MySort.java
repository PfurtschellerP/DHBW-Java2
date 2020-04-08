package dhbw.java2.chapter14;

import java.util.Arrays;

/**
 * In dieser Klasse sollte ich selbst mal einen Sortieralgorithmus schreiben
 * @author Patrick Pfurtscheller
 * @version 1.0.0
 *
 */
public class MySort {

	
	/**
	 * Diese Methode sortiert ein Integer Array
	 * @param data Unsortiertes Array
	 * @return Sortiertes Array
	 */
	private static int[] sort(int[] data) {
		
		int[] dataSorted = new int[data.length];
		
		for (int j = 0; j < data.length; j++) {
			int kleinsteZahl = Integer.MAX_VALUE;
			int kleinsterIndex = 0;
			for (int i = 0; i < data.length; i++) {
				if (kleinsteZahl >= data[i]){
					kleinsteZahl = data[i];
					kleinsterIndex = i;
				}
			}
			dataSorted[j] = kleinsteZahl;
			data[kleinsterIndex] = Integer.MAX_VALUE;
		}
		return dataSorted;
	}
	
    /**
     * Main Methode
     * @param args Wird nicht gebraucht
     */
    public static void main(String[] args) {
        int[] data = new int[] {5, 4, 8, 6, 3, 10, 2, 7, 9, 1};
        
        
        System.out.println(Arrays.toString(sort(data)));
    }
}