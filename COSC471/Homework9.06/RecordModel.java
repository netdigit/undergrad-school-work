/*Written for homework assignment 0906 by Kelly Mayhew.
 * Source code can be found at 
 * https://people.emich.edu/kmayhew/COSC471/Homework9.06/RecordModel.java
 * Code written and tested in Eclipse, if that makes a difference.
 * */

import java.util.Scanner;

public class RecordModel {
	public static char[] records;	//Char array of records
	public static int fieldSize = 20;	//Size of a field
	public static int recordSize = 60;	//Size of a record
	public static int lastFilled;	//The last index in the array that has data in it
	
	public static void main(String args[]) {
		initializeRecords();	//Basic Manipulation(II) #1
		
		//Data Structure(III)
		//Set lastFilled to the last filled spot in the array+1
		lastFilled = 3*recordSize + 1;
		
		//Basic Manipulation(II) #2
		//Print each record separated by line
		for(int i = 0; i < records.length; i+=recordSize) {
			for(int j = 0; j < recordSize && i+j < 3*recordSize; j++) {
				System.out.print(records[i+j]);
			}
			System.out.println();
		}
		
		//Basic Manipulation(II) #3
		//Print each record without any changes
		for(int i = 0; i < lastFilled; i++) {
			System.out.print(records[i]);
		}
		System.out.println();
		
		
		//Inserting data one record at a time(IV)
		Scanner keyboard = new Scanner(System.in);
		for(int i = 0; i < 3; i++) {	//Repeat once for each command
			System.out.print("Enter command: ");
			String nextCommand = keyboard.nextLine();
			
			//Get command. Must be format "INSERT ("A", "a", "0")"
			String enteredCommand = nextCommand.substring(0, 6);
			
			//If correct format, continue
			if(enteredCommand.equalsIgnoreCase("INSERT")) {
				String[] splitString = nextCommand.split("\"", 0);
				//Every other entry in the array is one of the inputs for the record. Get inputs
				String char1 = splitString[1];
				String char2 = splitString[3];
				String char3 = splitString[5];
				
				insertRecord(char1, char2, char3);	//Insert into array
			}
			
			else {
				System.out.println("Invalid command!");
			}
		}
		
		//Outputting data one record at a time(V)
		//Get record number from user
		System.out.print("Enter record number: ");
		String whichRecord = keyboard.nextLine();
		
		//Locate record, then output
		int getRecord = 60*Integer.parseInt(whichRecord);
		for(int i = 0; i < recordSize; i++) {
			System.out.print(records[getRecord+i]);
		}
		
		keyboard.close();
	}
	
	
	/*This method sets up the array of records by filling it with ' ', then the
	 * required data.*/
	public static void initializeRecords() {
		records = new char[200];
		for(int i = 0; i < records.length; i++) {
			records[i] = ' ';
		}
		records[(0*recordSize) + (0*fieldSize)] = 'A';
		records[(0*recordSize) + (1*fieldSize)] = 'a';
		records[(0*recordSize) + (2*fieldSize)] = '0';
		records[(1*recordSize) + (0*fieldSize)] = 'B';
		records[(1*recordSize) + (1*fieldSize)] = 'b';
		records[(1*recordSize) + (2*fieldSize)] = '1';
		records[(2*recordSize) + (0*fieldSize)] = 'C';
		records[(2*recordSize) + (1*fieldSize)] = 'c';
		records[(2*recordSize) + (2*fieldSize)] = '2';
	}
	
	
	/*This method takes 3 string inputs, then overwrites the record indicated by
	 * char3 with the inputs given. When done, it updates which index in the records
	 * array is the last index that has a value.*/
	public static void insertRecord(String char1, String char2, String char3) {
		//Use char3 to find which record to edit
		int recordNumber = recordSize*Integer.parseInt(char3);
		
		//Enter field 1
		char[] fieldOne = char1.toCharArray();
		for(int i = 0; i < fieldSize && i < fieldOne.length; i++) {
			records[recordNumber+i] = fieldOne[i];
		}
		
		//Enter field 2
		char[] fieldTwo = char2.toCharArray();
		for(int i = 0; i < fieldSize && i < fieldTwo.length; i++) {
			records[recordNumber+fieldSize+i] = fieldTwo[i];
		}
		
		//Enter field 3
		char[] fieldThree = char3.toCharArray();
		for(int i = 0; i < fieldSize && i < fieldThree.length; i++) {
			records[recordNumber+(2*fieldSize)+i] = fieldThree[i];
			
			//If this is the last char to input, update lastFilled to the new length
			if(i+1 == fieldSize || i+1 == fieldThree.length) {
				lastFilled = recordNumber+(2*fieldSize)+i + 1;
			}
		}
	}
	
}
