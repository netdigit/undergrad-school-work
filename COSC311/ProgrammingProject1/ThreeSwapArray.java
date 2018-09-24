/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/ProgrammingProject1/ThreeSwapArray.java
 * COSC 311
 * Programming Project 1: n-choose-k
 * FALL 2016*/
import java.util.*;

public class ThreeSwapArray {
	
	//Program begins by initializing variables that multiple methods use.
	
	static Random chooser = new Random();
	static int[] choices = new int[]{6,30,100,45,72,34,64,88,76,3};  //The number of items chosen from (n) can be changed by changing the size of the array.
	static int choice;
	static int temp;
	
	//The main method runs the experiment for the number of times specified.
	
	public static void main(String[] args){
		
		System.out.println("Algorithm: Swapped Array 10/11/2016");
		
		for(int i = 0; i < 5; i++){									 //The number of experiments run can be changed by changing the number i counts up to.
			experiment(5);											 //The number of items chosen can be changed by changing the int passed to the experiment function.
			System.out.println();
		}
		
	}
	
	//The experiment method records the time taken to run the algorithm, runs the algorithm, then outputs the results to the console.
	
	public static void experiment(int k){
		long startTime = System.nanoTime();
		int numChosen = choices.length;
		
		for(int i = 0, j = choices.length; i < k; i++, j--){
			choose(j);
			numChosen--;
		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		
		System.out.println("Time: " + totalTime);
		for(numChosen = numChosen; numChosen < choices.length; numChosen++){
			System.out.println(choices[numChosen]);
		}
		return;
	}
	
	//The choose method is the algorithm. It picks a random number, then moves it to the back of the array.
	
	public static void choose(int arrLength){
		choice = chooser.nextInt(arrLength);
		temp = choices[choice];
		choices[choice] = choices[arrLength-1];
		choices[arrLength-1] = temp;
		return;
	}
}
