package dhbw.java2.chapter15;

import java.util.Arrays;

/**
 * @author Patrick Pfurtscheller
 *
 */
public class ChangeMakingProblem {

	public static int[] change(int[] values, int sum) {
		
		int[] result = new int[values.length];
		
		for (int i = 0; i < values.length; i++) {
			result[i] = sum / values[i];
			sum -= (result[i] * values[i]);
		}
		return result;
	}
	
	public static int[] change(int[] values, int sum, String currency) {
		
		int[] result = new int[values.length];
		
		switch (currency) {
		case "EUR":
		case "USD":
		case "GBP":
			for (int i = 0; i < values.length; i++) {
				result[i] = sum / values[i];
				sum -= (result[i] * values[i]);
			}
			break;
		default:
			System.out.println("Not yet implemented");
			return null;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(change(new int[] {200, 100, 50, 20, 10, 5, 2, 1}, 469)));
		System.out.println(Arrays.toString(change(new int[] {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1}, 12569, "EUR")));
		
	}

}
