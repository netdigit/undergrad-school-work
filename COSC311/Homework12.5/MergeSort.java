/*Kelly Mayhew
 *http://people.emich.edu/kmayhew/COSC311/Homework12.5/MergeSort.java
 *COSC 311
 *HW 12/5
 *FALL 2016*/
import java.util.*;
import java.io.*;

public class MergeSort {
	
	public static int counter = 0;
	static String[] names = new String[17];
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("Names.txt"));
		
		for(int i = 0; i < names.length; i++){
			names[i] = input.nextLine();
		}
		
		input.close();
		
		String[] sorted = sort(names);
		
		for(int i = 0; i < names.length; i++){
			System.out.println(sorted[i]);
		}
		System.out.print("Counter: " + counter);
		
	}
	
	public static String[] sort(String[] arr){
		counter++;
		if(arr.length <= 1){
			return arr;
		}
		
		String[] arrOne = new String[arr.length/2];
		String[] arrTwo = new String[arr.length - arrOne.length];
		
		System.arraycopy(arr, 0, arrOne, 0, arrOne.length);
		System.arraycopy(arr, arrOne.length, arrTwo, 0, arrTwo.length);
		
		String[] sArrOne = sort(arrOne);
		String[] sArrTwo = sort(arrTwo);
		
		String[] arrTotal = new String[arr.length];
		System.arraycopy(sArrOne, 0, arrTotal, 0, sArrOne.length);
		System.arraycopy(sArrTwo, 0, arrTotal, sArrOne.length, sArrTwo.length);
		
		Arrays.sort(arrTotal);
		
		return arrTotal;
	}
	
}
