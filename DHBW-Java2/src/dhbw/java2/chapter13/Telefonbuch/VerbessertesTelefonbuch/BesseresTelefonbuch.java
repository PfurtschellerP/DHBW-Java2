package dhbw.java2.chapter13.Telefonbuch.VerbessertesTelefonbuch;

//import dhbw.java2.chapter13.Telefonbuch.EinfachesTelefonbuch.Telefonbucheintrag;


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
	 * Fügt dem Telefonbuch einen neuen Eintrag hinzu
	 * @param eintrag Der Eintrag, der hinzugefügt werden soll
	 */
	public void add(Telefonbucheintrag eintrag) {
		if (anzahlEintraege == eintraege.length) {
			throw new IllegalStateException("Das Telefonbuch ist schon voll!");
		}
		int index = ++anzahlEintraege;														// Erhöhen der Anzahl der Einträge und setzen des Index auf den letzen Eintrag
		while(--index > 0) {																// Durchlaufe das Feld von rechts nach links
			if(eintraege[index-1] != null) {												// Überprüfen, ob der zu überprüfende Eintrag nicht null ist
				if (eintrag.getName().compareTo(eintraege[index-1].getName()) < 0) {		// Überprüfen, ob die Feldkomponente größer als der neue Wert ist
					eintraege[index] = eintraege[index-1];
				} else {
					break;																	// neue Position gefunden
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
	 * @param name Name des Unternehmens, nach welchem gesucht wird
	 * @return Eintrag des Unternehmens (wenn m�glich)
	 */
	public Telefonbucheintrag search(String name) {
		return anzahlEintraege == 0 ? null : search(name, 0, anzahlEintraege-1);
	}
	
	/**
	 * Sucht einen Eintrag innerhalb des Telefonbuchs und gibt ihn zurück
	 * @param name Name der Persons, nach welcher gesucht wird
	 * @return Eintrag der Person (wenn möglich)
	 */
	public Telefonbucheintrag search(String vorName, String Nachname) {
		String name = Nachname + " " + vorName;
		return anzahlEintraege == 0 ? null : search(name, 0, anzahlEintraege-1);
	}
	
	private Telefonbucheintrag search(String name, int fromIndex, int toIndex) {
		if (toIndex - fromIndex == 1) {															// nur noch eine Feldkomponente?
			return eintraege[fromIndex].getVollerName().equals(name) ? eintraege[fromIndex] : null;
		}
		int centerIndex = (fromIndex + toIndex) / 2;
		if (eintraege[centerIndex].getVollerName().compareTo(name) > 0) {								// Schlüsselvergleich (Ist der Eintrag in der Mitte größer als der, den wir suchen?)
			return search(name, fromIndex, centerIndex);										// linke Halfte durchsuchen
		} else {
			return search(name, centerIndex, toIndex);											// rechte Hälfte durchsuchen
		}
	}
	
	/**
	 * Gibt eine Darstellung eines Telefonbuchs und seiner Einträge als String aus
	 * @return Eine String Darstellung eines Telefonbuchs und seiner Einträge
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
		
		Telefonbucheintrag test = new Telefonbucheintrag("Max", "Meier", "012345678");
		Telefonbucheintrag test2 = new Telefonbucheintrag("Peter", "Müller", "0987654312");
		Telefonbucheintrag test3 = new Telefonbucheintrag("Bob", "Baumeister", "112233445566");
		Telefonbucheintrag test4 = new Telefonbucheintrag("Alfons", "Bauer", "1325451545");
		Telefonbucheintrag test5 = new Telefonbucheintrag("Peter", "Adler", "123456789");
		Telefonbucheintrag test6 = new Telefonbucheintrag("Dachbau GmbH", "81512345");
		Telefonbucheintrag test7 = new Telefonbucheintrag("Tobias", "Meier", "012345678");
		
//		System.out.println(test.toString());
		
		tb.add(test);
		tb.add(test2);
		tb.add(test3);
		tb.add(test4);
		tb.add(test5);
		tb.add(test6);
		tb.add(test7);
		
		System.out.println(tb.toString());
		
		System.out.println(tb.search("Max", "Meier"));
		System.out.println(tb.search("Dachbau GmbH"));
		
	}
}
