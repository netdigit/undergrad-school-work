/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/ProgrammingProject1/TwoUsedArray.java
 * COSC 311
 * Programming Project 1: n-choose-k
 * FALL 2016*/
import java.util.*;

public class TwoUsedArray {
	
	//Program begins by initializing variables that multiple methods use.
	
	static Random chooser = new Random();
	static int[] choices = new int[]{6,30,100,45,72,34,64,88,76,3};  //The number of items chosen from (n) can be changed by changing the size of the array.
	static boolean[] used = new boolean[10];						 //The size of this array must match the size of the above array.
	static int chosen;
	
	//The main method runs the experiment for a set amount of trials, resetting the used array after each one.
	
	public static void main(String args[]){
		
		System.out.println("Algorithm: Used Array 10/11/2016");
		
		for(int i = 0; i < 5; i++){									 //The number of experiments run can be changed by changing the number i counts up to.
			experiment(5);											 //The number of items chosen can be changed by changing the int passed to the experiment function.
			System.out.println();
			
			for(int j = 0; j < used.length; j++){
				used[j] = false;
			}
		}
		
	}
	
	//The experiment method records the time taken to run the algorithm, runs the algorithm, then outputs the results to the console.
	
	public static void experiment(int k){
		long startTime = System.nanoTime();
		
		for(int i = 0; i < k; i++)
			choose();
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Time: " + totalTime);
		for(int i = 0; i < used.length; i++){
			if(used[i])
				System.out.println(choices[i]);
		}
		return;
	}
	
	//The choose method chooses the next int for the experiment function. It checks to make sure the int isn't already used before returning the result.
	
	public static void choose(){
		
		while(used[chosen])
			chosen = chooser.nextInt(choices.length);
			
		used[chosen] = true;
		
	}
	
}
