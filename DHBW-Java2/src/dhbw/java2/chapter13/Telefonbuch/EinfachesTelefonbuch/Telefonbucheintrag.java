package dhbw.java2.chapter13.Telefonbuch.EinfachesTelefonbuch;

public class Telefonbucheintrag {
	
	/**
	 * Name der Person / des Unternehmens
	 */
	private String name;
	/**
	 * Telefonnummer der Person / des Unternehmens
	 */
	private String telefonnummer;
	
	/**
	 * @param name				<code>Name</code> der Person / des Unternehmens
	 * @param telefonnummer		<code>Telefonnummer</code> der Person / des Unternehmens
	 */
	public Telefonbucheintrag(String name, String telefonnummer) {
		this.name = name;
		this.telefonnummer = telefonnummer;
	}

	/**
	 * Gibt den <code>Namen<code> der Person / des Unternehmens zurück
	 * @return Name der Person / des Unternehmens
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setzt den <code>Namen</code> der Person / des Unternehmens
	 * @param name Der neue Name der Person / des Unternehmens
	 */
	public void setName(String name) {
		this.name = name;
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
		return "Name: " + name + ", Telefonnummer: " + telefonnummer;
	}
	
}
