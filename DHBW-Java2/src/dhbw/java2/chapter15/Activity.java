package dhbw.java2.chapter15;

public class Activity{

	private int anfang;
	private int ende;
	
	public Activity(int anfang, int ende) {
		this.anfang = anfang;
		this.ende = ende;
	}	
	
	public int getAnfang() {
		return anfang;
	}
	
	public int getEnde() {
		return ende;
	}
	
	public int getDauer() {
		return ende - anfang + 1;
	}
	
	@Override
	public String toString() {
		return "von " + anfang + " bis " + ende;
	}

	public int compareTo(Activity o) {
		if(o != null) {
			if (this.ende > o.ende) {
				return 1;
			} else if (this.ende < o.ende) {
				return -1;
			}else {
				return 0;
			}	
		}
		throw new IllegalArgumentException("Activity can't be null");
		
	}
}
