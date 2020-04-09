package dhbw.java2.chapter13.Telefonbuch.VerbessertesTelefonbuch;

public class Telefonbucheintrag {
	
	/**
	 * Vorname einer Person
	 */
	private String vorName;
	/**
	 * Nachname der Person / Name des Unternehmens
	 */
	private String name;
	/**
	 * Telefonnummer der Person / des Unternehmens
	 */
	private String telefonnummer;
	
	/**
	 * @param name				<code>Name</code> des Unternehmens
	 * @param telefonnummer		<code>Telefonnummer</code> des Unternehmens
	 */
	public Telefonbucheintrag(String name, String telefonnummer) {
		this.name = name;
		this.telefonnummer = telefonnummer;
	}
	
	/**
	 * @param vorName			<code>Vorname</code> einer Person
	 * @param name				<code>Nachname</code> einer Person
	 * @param telefonnummer		<Telefonnummer</code> einer Person
	 */
	public Telefonbucheintrag(String vorName, String name, String telefonnummer) {
		this(name, telefonnummer);
		this.vorName = vorName;
	}

	/**
	 * Gibt den <code>Vornamen</code> der Person zurück
	 * @return Vorname der Person
	 */
	public String getVorName() {
		return vorName;
	}
	
	/**
	 * Setzt den <code>Vornamen</code> der Person
	 * @param vorName Der neue Vorname der Person
	 */
	public void setVorName(String vorName) {
		this.vorName = vorName;
	}
	
	/**
	 * Gibt den <code>Nachname<code> der Person / <code>Namen</code> des Unternehmens zurück
	 * @return Nachname der Person / Name des Unternehmens
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt den <code>Nachamen</code> der Person / <code>Namen</code>des Unternehmens
	 * @param name Der neue Nachname der Person / Name des Unternehmens
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVollerName() {
		if (this.vorName == null) {
			return this.name;
		} else {
			return this.name + " " + this.vorName;
		}
	}
	
	/** Gibt die <code>Telefonnummer</code> der Person / des Unternehmens zurück
	 * @return	Die Telefonnummer der Person / des Unternehmens
	 */
	public String getTelefonnummer() {
		return telefonnummer;
	}

	/**
	 * Setzt die <code>Telefonnummer</code> der Person / des Unternehmens
	 * @param telefonnummer Die neue Telefonnummer der Person / des Unternehmens
	 */
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
	/**
	 * Gibt den Namen und die Telefonnummer einer Person / eines Unternehmens als String aus
	 * @return Den Namen und die Telefonnummer einer Person / eines Untenehmens
	 */
	@Override
	public String toString() {
		if (this.vorName != null) {
			return "Name: " + name + ", " + vorName + ", Telefonnummer: " + telefonnummer;
		} else {
			return "Name: " + name + ", Telefonnummer: " + telefonnummer;
		}
		
	}
	
}
	
