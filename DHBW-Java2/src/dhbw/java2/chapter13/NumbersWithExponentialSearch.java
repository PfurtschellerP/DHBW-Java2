package dhbw.java2.chapter13;

public class NumbersWithExponentialSearch extends Numbers {

	@Override
	public void add(int key) {
        if (count == data.length) {
            throw new IllegalStateException("Alle Plätze sind belegt.");
        }
        int index = ++count;
        while (--index > 0) {                               // durchlaufe Feld von rechts nach links
            if (data[index-1] > key) {                      // Feldkomponente größer als neuer Wert?
                data[index] = data[index-1];                // schiebt Feldkomponente nach rechts
            } else {
                break;                                      // Einfügeposition gefunden
            }
        }
        data[index] = key;                                  // neuen Wert einfügen
	}

	@Override
	public int search(int key) {
		// Unbehandelte Ausnahme wenn index*=2 größer als das Array ist
		int index = 1;
		System.out.println(index);
		comparisons++;
		while (data[index-1] < key) {
			index *= 2;
			System.out.println(index);
			comparisons++;
		}
		
		return binarySearch(key, 0, index);
	}
	
	
    public int binarySearch(int key) {                      // überprüft nur "mittlere" Elemente
        return count == 0 ? -1 : binarySearch(key, 0, count);     // ganzes Feld durchsuchen
    }

    private int binarySearch(int key, int fromIndex, int toIndex) {
        if (toIndex - fromIndex == 1) {                     // nur noch eine Feldkomponente?
        	comparisons++;
            return data[fromIndex] == key ? fromIndex : -1; // Schlüsselvergleich
        }
        int centerIndex = (fromIndex + toIndex) / 2;
        comparisons++;
        if (data[centerIndex] > key) {                      // Schlüsselvergleich
            return binarySearch(key, fromIndex, centerIndex);     // linke Hälfte durchsuchen
        } else {
            return binarySearch(key, centerIndex, toIndex);       // rechte Hälfte durchsuchen
        }
    }

	public static void main(String[] args) {
//		new NumbersWithExponentialSearch().demo();
		new NumbersWithExponentialSearch().demoAufgabe();
	}

}
