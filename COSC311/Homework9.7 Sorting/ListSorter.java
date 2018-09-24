/*Kelly Mayhew
 * people.emich.edu/kmayhew/COSC%20311/Homework9.7%20Sorting/ListSorter.java
 * COSC 311
 * HW 09/07
 * FALL 2016
 * Based off insertion sort psuedocode from Wikipedia.*/
import java.util.*;
import java.io.*;

public class ListSorter {
	
	public static void main(String[] args){
		Scanner input = new Scanner(new File("test10.txt"));
		int numArray[] = new int[25];
		int inNum = input.nextInt();
		for(int i = 0; i < numArray.length-1; i++){
			numArray[i] = inNum;
			input.nextLine();
			inNum = input.nextInt();
		}
		for(int i = 0; i < numArray.length; i++){
			int sortNum = numArray[i];
			int swapNum = i - 1;
			while(swapNum >= 0 && numArray[swapNum] > sortNum){
				numArray[swapNum+1] = numArray[swapNum];
				swapNum = swapNum - 1;
			}
			numArray[swapNum+1] = sortNum;
		}
		for(int i = 0; i < numArray.length; i++){
			System.out.println(numArray[i]);
		}
	
	}
}
