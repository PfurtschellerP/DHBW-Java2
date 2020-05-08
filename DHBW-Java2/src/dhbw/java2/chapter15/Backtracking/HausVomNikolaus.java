package dhbw.java2.chapter15.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class HausVomNikolaus {
	
//	private static ArrayList<Integer> loesungen = new ArrayList<Integer>();
//
//	private static final int[][] moeglicheZuege = new int[][] {
//		/*
//		 *   5
//		 *   ^
//		 *  3_4
//		 *  | |
//		 *  1_2
//		 */ 
//		{1, 2, 4}, 	// von Punkt 1
//		{1, 3, 5},	// von Punkt 2
//	 	{2, 3, 6},	// von Punkt 3
//	 	{4, 5, 6},	// von Punkt 4
//	 	{7, 8}		// von Punkt 5
//	};
//	
//	private static void loesungenFinden() {
//		for( int i = 1; i <= 5; i++) {			// Für alle Punkte
//
//		}
//	}
	
	private static ArrayList<Kante> kanten = new ArrayList<Kante>();
	private static int[][] loesungen = new int[50][8];
	private static int anzahlLoesungen = 0;
	private static int pfadPosition = -1;
	
	public static void kantenErstellen() {
		kanten.add(new Kante(1, 2));
		kanten.add(new Kante(1, 3));
		kanten.add(new Kante(1, 4));
		kanten.add(new Kante(2, 3));
		kanten.add(new Kante(2, 4));
		kanten.add(new Kante(3, 4));
		kanten.add(new Kante(3, 5));
		kanten.add(new Kante(4, 5));
	}
	
	public static void loesungenFinden(ArrayList<Kante> kanten, int startpunkt, int[] pfad) {
		if (kanten.isEmpty()) {
			loesungen[anzahlLoesungen++] = pfad;
			return;
		}
		
        for (int i = 0; i < kanten.size(); i++) {
            Kante kante = kanten.get(i);
            if (kante.beinhaltet(startpunkt)) {
                int neuerStartpunkt = kante.getAndere(startpunkt);
                kanten.remove(kante);
                pfadPosition++;
                pfad[pfadPosition] = startpunkt;
                System.out.println(Arrays.toString(pfad));
                loesungenFinden(kanten, neuerStartpunkt, pfad);
                kanten.add(i, kante);
            }
        }
	}
	
	public static void main(String[] args) {
		kantenErstellen();
		for (int i = 1; i <= 5; i++) {	// Für alle Startpunkte
			loesungenFinden(kanten, i, new int[10]);
		}
	}
	
}

class Kante{
	private int punkt1;
	private int punkt2;
	
	public Kante(int punkt1, int punkt2) {
		this.punkt1 = punkt1;
		this.punkt2 = punkt2;
	}
	
	public boolean beinhaltet(int punkt) {
		return punkt1 == punkt || punkt2 == punkt;
	}
	
	public int getAndere(int punkt) {
		if (punkt == punkt1) return punkt2;
		if (punkt == punkt2)  return punkt1;
		return -1;
	}
}
