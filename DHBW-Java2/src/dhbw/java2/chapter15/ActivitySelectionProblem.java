package dhbw.java2.chapter15;

import java.util.Arrays;

public class ActivitySelectionProblem {


	public boolean[] choose(int[]start, int[] end) {
		Activity[] activities = new Activity[start.length];
		for (int i = 0; i < start.length; i++) {
			activities[i] = new Activity(start[i], end[i]);
		}
		
		System.out.println("Unsorted Activites");
		printActivites(activities);
		System.out.println("Sorted Activies");
		sortAsc(activities);
		printActivites(activities);
		
		boolean[] canAttend = new boolean[activities.length];
		canAttend[activities.length -1] = true;										// letzte Activität true setzen
		
		for (int i = activities.length - 2; i >= 0; i--) {
			for ( int j = i+1; j < canAttend.length; j++) {
				if (canAttend[j]) {
					if (activities[i].getEnde() >= activities[j].getAnfang()) {
						canAttend[i] = false;
					} else {
						canAttend[i] = true;
					}
					break;
				}
			}

			
		}
		return canAttend;
	}
	
	private void printActivites(Activity[] activities){
		for (int i = 0; i < activities.length; i++) {
			System.out.print(activities[i].getAnfang() + "   ");
		}
		System.out.println();
		for (int i = 0; i < activities.length; i++) {
			System.out.print(activities[i].getEnde() + "   ");
		}
		System.out.println();
	}
	
	public Activity[] sortAsc(Activity[] activities) {
        Activity d;
        int fromIndex = 0;
        int toIndex = activities.length;
        
        for (int currentIndex = fromIndex; currentIndex < toIndex; currentIndex++) 
        {
            int indexToMove = currentIndex;
            for (int tempIndexInLoop = currentIndex + 1; tempIndexInLoop < toIndex; tempIndexInLoop++) 
            {
                if ((activities[indexToMove]).compareTo(activities[tempIndexInLoop]) > 0) 
                {
                    //Swapping
                    indexToMove = tempIndexInLoop;
                }
            }
            d = activities[currentIndex];
            activities[currentIndex] = activities[indexToMove];
            activities[indexToMove] = d;
        }
        return activities;
	}
	
	public static void main(String[] args) {
		ActivitySelectionProblem asp = new ActivitySelectionProblem();
		System.out.println(Arrays.toString(asp.choose(new int[] {43, 11, 28, 52, 10, 34, 21, 46, 2, 51}, new int[] {52, 24, 35, 58, 11, 46, 31, 51, 10, 52})));
	}
}
