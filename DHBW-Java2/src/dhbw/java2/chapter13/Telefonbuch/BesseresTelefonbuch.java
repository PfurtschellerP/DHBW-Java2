package dhbw.java2.chapter13.Telefonbuch;

import dhbw.java2.chapter13.Telefonbuch.EinfachesTelefonbuch.Telefonbucheintrag;


public class BesseresTelefonbuch {

	/**
	 * Eintr�ge des Telefonbuchs
	 */
	private Telefonbucheintrag[] eintraege = new Telefonbucheintrag[100];
	/**
	 * Anzahl der Eintr�ge, die sich zur Zeit im Telefonbuch befinden
	 */
	private int anzahlEintraege = 0;
	
	/**
	 * F�gt dem Telefonbuch einen neuen Eintrag hinzu
	 * @param eintrag Der Eintrag, der hinzugef�gt werden soll
	 */
	public void add(Telefonbucheintrag eintrag) {
		if (anzahlEintraege == eintraege.length) {
			throw new IllegalStateException("Das Telefonbuch ist schon voll!");
		}
		int index = ++anzahlEintraege;													// Erh�hen der Anzahl der Eintr�ge und setzen des Index auf den letzen Eintrag
		while(--index > 0) {															// Durchlaufe das Feld von rechts nach links
			if(eintraege[index-1] != null) {											// �berpr�fen, ob der zu �berpr�fende Eintrag nicht null ist
				if (eintrag.getName().compareTo(eintraege[index-1].getName()) < 0) {	// �berpr�fen, ob die Feldkomponente gr��er als der neue Wert ist
					eintraege[index] = eintraege[index-1];
				} else {
					break;																// neue Position gefunden
				}
			} else {
				break;
			}	
		}
		eintraege[index] = eintrag;
		
//		eintraege[anzahlEintraege-1] = eintrag;
	}
	
	/**
	 * Sucht einen Eintrag innerhalb des Telefonbuchs und gibt ihn zur�ck
	 * @param name Name der Person / des Unternehmens, nach welchem gesucht wird
	 * @return Eintrag der Person / des Unternehmens (wenn m�glich)
	 */
	public Telefonbucheintrag search(String name) {
		return anzahlEintraege == 0 ? null : search(name, 0, anzahlEintraege-1);
	}
	
	private Telefonbucheintrag search(String name, int fromIndex, int toIndex) {
		if (toIndex - fromIndex == 1) {															// nur noch eine Feldkomponente?
			return eintraege[fromIndex].getName().equals(name) ? eintraege[fromIndex] : null;
		}
		int centerIndex = (fromIndex + toIndex) / 2;
		if (eintraege[centerIndex].getName().compareTo(name) > 0) {								// Schl�sselvergleich (Ist der Eintrag in der Mitte gr��er als der, den wir suchen?)
			return search(name, fromIndex, centerIndex);										// linke H�lfte durchsuchen
		} else {
			return search(name, centerIndex, toIndex);											// rechte H�lfte durchsuchen
		}
	}
	
	/**
	 * Gibt eine Darstellung eines Telefonbuchs und seiner Eintr�ge als String aus
	 * @return Eine String Darstellung eines Telefonbuchs und seiner Eintr�ge
	 */
	@Override
	public String toString() {
		String ausgabe = "-------- Cooles Telefonbuch --------\n";
		
		for (int i = 0; i < eintraege.length; i++) {
			if (eintraege[i] != null) {
//				ausgabe += " " + (i+1) + ") " + eintraege[i].toString()+ "\n";
				ausgabe += " " + String.format("%04d", i+1) + ") " + eintraege[i].toString()+ "\n";
			}
		}
		
		/* Variante ohne Index
		for (Telefonbucheintrag telefonbucheintrag : eintraege) {
			if (telefonbucheintrag != null) {
				ausgabe += "- " + telefonbucheintrag.toString() + "\n";
			}
		}
		*/
		return ausgabe += "--------------- Ende ---------------";
	}
	
	/**
	 * Die Mainmethode, welche beim Start der Anwendung gestartet wird
	 * @param args wird nicht benutzt
	 */
	public static void main(String[] args) {
		BesseresTelefonbuch tb = new BesseresTelefonbuch();
		
		Telefonbucheintrag test = new Telefonbucheintrag("Max Meier", "012345678");
		Telefonbucheintrag test2 = new Telefonbucheintrag("Peter M�ller", "0987654312");
		Telefonbucheintrag test3 = new Telefonbucheintrag("Bob der Baumeister", "112233445566");
		Telefonbucheintrag test4 = new Telefonbucheintrag("Alfons Bauer", "1325451545");
		
//		System.out.println(test.toString());
		
		tb.add(test);
		tb.add(test2);
		tb.add(test3);
		tb.add(test4);
		
		System.out.println(tb.toString());
		
		System.out.println(tb.search("Max Meier"));
		
	}
}
