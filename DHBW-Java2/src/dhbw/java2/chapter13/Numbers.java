package dhbw.java2.chapter13;
public abstract class Numbers {
    protected int[] data = new int[31];     // Feld für abgespeicherte Zahlen
    protected int count = 0;                // Anzahl der abgespeicherten Zahlen
    protected int comparisons = 0;

    /**
     * Fügt eine Zahl zum Feld hinzu
     * @param key Hinzuzufügende Zahl
     */
    public abstract void add(int key);      // fügt eine Zahl hinzu

    /**
     * Sucht eine Zahl in dem Feld
     * @param key Zu suchende Zahl
     * @return Index der gesuchten Zahl
     */
    public abstract int search(int key);    // sucht den Index einer Zahl (-1: fehlt)

    public void print() {                   // Ausgabe der abgespeicherten Zahlen
        System.out.print("Feld:");
        for (int index = 0; index < count; index++) {
            System.out.print(" " + data[index]);
        }
        System.out.println();
    }

    public void demo() {                    // Vorführungsmethode
        print();
        add(6);
        print();
        add(9);
        print();
        add(2);
        print();
        add(3);
        print();
        for (int key = 0; key < 10; key++) {
            System.out.println(key + "? " + search(key));
            print();										// erneute Ausgabe des ggf. umgebauten Feldes
        }
    }
    
    public void demoAufgabe() {
    	// add numbers
    	add(3);
    	add(4);
    	add(8);
    	add(10);
    	add(15);
    	add(17);
    	add(20);
    	add(24);
    	add(26);
    	add(29);
    	add(32);
    	add(36);
    	add(37);
    	add(44);
    	add(45);
    	add(52);
    	add(54);
    	add(57);
    	add(58);
    	add(60);
    	add(62);
    	add(66);
    	add(74);
    	add(75);
    	add(80);
    	add(83);
    	add(84);
    	add(89);
    	add(93);
    	add(95);
    	add(99);
    	// search 20
    	search(20);
    	// print out comparisons needed
    	System.out.println("Comparisons needed: " + comparisons);
    }
}