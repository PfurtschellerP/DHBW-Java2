package dhbw.java2.chapter16;

import java.util.Arrays;

public class ArrayStack {
    private int[] values = new int[16];     // zugrundeliegendes Feld
    private int size = 0;                   // aktuelle Stapelgröße

    /**
     * Fügt den neuen Wert am oberen Stackende ein.
     * 
     * @param value
     */
    public void push(int value) {
        if ((size + 1) > values.length) {					// überprüfen, ob das Array noch reicht
        	int[] save = this.values;						// sichere altes Array
        	this.values = new int[this.values.length*2];	// erweitere values Array
        	for (int i = 0; i < save.length; i++) {			// kopiere die alten Werte in das neue Array
        		this.values[i] = save[i];
        	}
        }
        values[size++] = value;								// füge neues Element hinzu
    }

    /**
     * Liefert den Wert vom oberen Stackende und entfernt ihn dabei.
     * 
     * @return oberster Stackwert
     * @throws IllegalStateException wenn der Stack leer ist
     */
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Der Stack ist leer.");
        }
        if((values.length / 2) >= size) {				// Überprüfen, ob das Array nicht zu groß ist und ob nicht die Hälfte auch reicht
        	int[] save = this.values;					// sichere altes Array
        	this.values = new int[save.length / 2];		// verkleinere values Array
        	for (int i = 0; i < values.length; i++) {	// kopiere die alten Werte in das neue Array
        		values[i] = save[i];
        	}
        }
        int save = values[size-1];
        values[--size] = 0;
        return save;
    }

    /**
     * Prüft, ob der Stack leer ist, also ob er keine Knoten enthält.
     * 
     * @return <code>true</code> gdw. der Stack leer ist
     */
    public boolean isEmpty() {
        for (int value : values) {
        	if (value != 0) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stack mit " + size + " Elementen: " + Arrays.toString(values);
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();
        System.out.println(stack);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        System.out.println(stack);
        stack.push(17);
        System.out.println(stack);
        stack.push(18);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
//        stack.pop();                        // Stack leer -> Exception
        
    }
}