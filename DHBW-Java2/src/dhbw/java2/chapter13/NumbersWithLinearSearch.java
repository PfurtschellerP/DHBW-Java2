package dhbw.java2.chapter13;

public class NumbersWithLinearSearch extends Numbers {

	@Override
	public void add(int key) {
		if (count == data.length) {
			throw new IllegalStateException("Alle Plätze sind belegt");	
		}
		data[count++] = key;
	}

	@Override
	public int search(int key) {
		for (int index = 0; index < count; index++) {
			if (data[index] == key) {
				comparisons++;
				return index;
			}
			comparisons++;
		}
		return -1;
	}

	public static void main(String[] args) {
//		new NumbersWithLinearSearch().demo();
		new NumbersWithLinearSearch().demoAufgabe();

	}

}
