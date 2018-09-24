/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/ProgrammingProject1/OneBogosort.java
 * COSC 311
 * Programming Project 1: n-choose-k
 * FALL 2016*/
import java.util.*;

public class OneBogosort {
	
	//Program begins by initializing variables that multiple methods use.
	
	static Random chooser = new Random();
	static int[] choices = new int[]{6,30,100,45,72,34,64,88,76,3}; //The number of items chosen from (n) can be changed by changing the size of the array.
	static int[] chosen;
	
	//The main method records the start and end time of each use of the algorithm, then outputs it along with the algorithm's result.
	
	public static void main(String[] args){
		
		System.out.println("Algorithm: Bogosort 10/11/2016");
		
		for(int i = 0; i < 5; i++){									//The number of experiments run can be changed by changing the number i counts up to.
			long startTime = System.nanoTime();
			
			experiment(5);											//The number of items chosen can be changed by changing the int passed to the experiment function.
			
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println("Time: " + totalTime);
			
			for(int j = 0; j < chosen.length; j++)
				System.out.println(choices[chosen[j]]);
			
			System.out.println();
		}
		
	}
	
	//The experiment method sets the number of values chosen, has the choose method run, then checks to see if the set is valid. If not, it reruns.
	
	public static void experiment(int k){
		chosen = new int[k];
		choose();
		
		for(int i = 0; i < chosen.length; i++){
			for(int j = i + 1; j < chosen.length; j++){
				if(chosen[i] == chosen[j]){
					experiment(k);
				}
			}
		}
	}
	
	//The choose method picks a number (k, based off array's length) of the choices at random.
	
	public static void choose(){
		for(int i = 0; i < chosen.length; i++){
			chosen[i] = chooser.nextInt(choices.length);
		}
	}
	
}
