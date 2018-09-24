/*Kelly Mayhew
 * people.emich.edu/kmayhew/COSC%20311/Homework9.7%20Sorting/ListSorterBestVer.java
 * COSC 311
 * HW 09/07
 * FALL 2016
 * Based off psuedocode from Wikipedia.*/
import java.util.*;
import java.io.*;

public class ListSorterBestVer {
	
	public static void main(String[] args){
		try{
		Scanner input = new Scanner(new File("test10.txt"));
		int numArray[] = new int[25];
		int inNum = input.nextInt();
		for(int i = 0; i < numArray.length-1; i++){
			numArray[i] = inNum;
			input.nextLine();
			inNum = input.nextInt();
		}
		for(int i = 0; i < numArray.length; i++){
			int temp = numArray[i];
			int j = i - 1;
			while(j >= 0 && numArray[j] > temp){
				numArray[j+1] = numArray[j];
				j = j - 1;
			}
			numArray[j+1] = temp;
		}
		for(int i = 0; i < numArray.length; i++){
			System.out.println(numArray[i]);
		}
		input.close();
		}
		catch(FileNotFoundException e){
			System.out.print("I hate you.");
		}
	}
	
}
