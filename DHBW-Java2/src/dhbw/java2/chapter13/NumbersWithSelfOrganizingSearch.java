package dhbw.java2.chapter13;

public class NumbersWithSelfOrganizingSearch extends Numbers {

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
				refactorArray(index);					// ziehe die gefundene Zahl nach vorne
				return 0;								// gebe den neuen Index (0) zurück
			}
			comparisons++;
		}
		return -1;
	}
	
	
	/**
	 * Zieht ein Element auf einem bestimmten Index ganz nach vorne
	 * @param index
	 */
	private void refactorArray(int index) {
		int i = index;
		int saveData = data[index];
		while (i > 0) {
			data[i] = data[i-1];
			i--;
		}
		data[0] = saveData;
	}

	public static void main(String[] args) {
		new NumbersWithSelfOrganizingSearch().demo();
//		new NumbersWithSelfOrganizingSearch().demoAufgabe();

	}

}
