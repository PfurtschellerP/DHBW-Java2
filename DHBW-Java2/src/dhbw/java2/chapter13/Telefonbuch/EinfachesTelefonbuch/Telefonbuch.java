package dhbw.java2.chapter13.Telefonbuch.EinfachesTelefonbuch;

public class Telefonbuch {

	/**
	 * Einträge des Telefonbuchs
	 */
	private Telefonbucheintrag[] eintraege = new Telefonbucheintrag[100];
	/**
	 * Anzahl der Einträge, die sich zur Zeit im Telefonbuch befinden
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
		anzahlEintraege++;
		eintraege[anzahlEintraege-1] = eintrag;
	}
	
	/**
	 * Sucht einen Eintrag innerhalb des Telefonbuchs und gibt ihn zurück
	 * @param name Name der Person / des Unternehmens, nach welchem gesucht wird
	 * @return Eintrag der Person / des Unternehmens (wenn möglich)
	 */
	public Telefonbucheintrag search(String name) {
		for (Telefonbucheintrag telefonbucheintrag : eintraege) {
			if (telefonbucheintrag.getName().equals(name)) {
				return telefonbucheintrag;
			}
		}
		return null;
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
		Telefonbuch tb = new Telefonbuch();
		
		Telefonbucheintrag test = new Telefonbucheintrag("Max Meier", "012345678");
		Telefonbucheintrag test2 = new Telefonbucheintrag("Peter Müller", "0987654312");
		Telefonbucheintrag test3 = new Telefonbucheintrag("Bob der Baumeister", "112233445566");
		
//		System.out.println(test.toString());
		
		tb.add(test);
		tb.add(test2);
		tb.add(test3);
		
		System.out.println(tb.toString());
		
		System.out.println(tb.search("Max Meier"));
		
	}
}
