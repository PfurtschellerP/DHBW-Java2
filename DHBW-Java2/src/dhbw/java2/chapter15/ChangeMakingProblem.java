package dhbw.java2.chapter15;

import java.util.Arrays;

/**
 * @author Patrick Pfurtscheller
 *
 */
public class ChangeMakingProblem {

	/**
	 * Berechnet für einen gegebenen Cent Wert die Zerlegung in Scheinen und Münzen
	 * @param values Mögliche Schein-/Münzwerte
	 * @param sum Cent Betrag
	 * @return
	 */
	public static int[] change(int[] values, int sum) {
		
		int[] result = new int[values.length];
		
		for (int i = 0; i < values.length; i++) {
			result[i] = sum / values[i];
			sum -= (result[i] * values[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(change(new int[] {200, 100, 50, 20, 10, 5, 2, 1}, 469)));
		
	}

}
