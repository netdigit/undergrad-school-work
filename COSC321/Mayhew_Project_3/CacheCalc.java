/*For Programming Project 3, COSC 321
 * Written by Kelly Mayhew*/
import java.util.*;
import java.io.*;

public class CacheCalc{
	
	static int blockSize = 8; //Number of words stored in a cache line
	static int lineNum = 4; //Number of cache lines
	static int cacheTime = 2; //Time needed to access the cache
	static int memTime = 20; //Time needed to access main memory
	
	static Scanner keyboard = new Scanner(System.in); //Keyboard input
	static int[] location = new int[100]; //Array holding assigned locations for words
	
	public static void main(String[] args){
		//User is given instructions
		System.out.println("You are running the CacheCalculator.");
		System.out.println("To run a simulation, type 'run'.");
		System.out.println("To configure system parameters, type 'config'.");
		System.out.println("To view system parameters, type 'view'.");
		System.out.println("To quit the simulation, type 'quit'.");
		
		//Program asks user what to do forever until told to quit
		while(true){
			System.out.println("What would you like to do?");
			String response = keyboard.next();
			
			if(response.equals("run")) //Simulate accessing words from memory
				runSim();
			else if(response.equals("config")) //Change parameters for simulation
				configSim();
			else if(response.equals("view")) //View parameters for simulation
				viewSim();
			else if(response.equals("quit")){ //Exit program
				keyboard.close();
				System.exit(0);
			}
			else //If user gives other command, let them retype it
				System.out.println("Did not recognize command. Please type 'run', 'config', 'view', or 'quit'.");
		}
	}
	
	/*This method takes a list of words to access from a txt file
	 * and simulates trying to grab them from the cache. At the end,
	 * it tells the user the hit ratio and effective access time.*/
	public static void runSim(){
		assignLocations(); //First figure out where each word is mapped
		
		System.out.println("What file would you like to use as input?");
		String inFile = keyboard.next();
		
		double total = 0; //Total number of words checked
		double hitNum = 0; //Words found in cache
		double missNum = 0; //Words found in main memory
		
		int[][] cache = new int[lineNum][blockSize]; //Array of the cache itself
		for(int i = 0; i < lineNum; i++){ // Set all values in cache to -1 to prevent issue with word 0
			for(int j = 0; j < blockSize; j++)
				cache[i][j] = -1;
		}
		
		try{
			Scanner in = new Scanner(new File(inFile));
			
			//Read each word from file, check if it's in the cache, and increment counters accordingly
			while(in.hasNext()){
				int search = in.nextInt();
				total++;
				
				boolean inCache = false;
				
				for(int i = 0; i < blockSize; i++){
					if(cache[location[search]][i] == search){
						inCache = true;
						break;
					}
				}
				
				if(inCache)
					hitNum++;
				else{
					missNum++;
					loadLine(search, cache); //If not in cache, load entire line to cache
				}
			}
			
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Could not find input file.");
			return; //If file not found, start over
		}
		
		//Calculate hit ratio here
		double hitPercent = 100 * (hitNum/total);
		System.out.println("Hit ratio = " + hitNum + "/" + total
				+ " = " + hitPercent + "%.");
		
		//Caculate effective access time here
		double accessTime = ((hitNum/total)*cacheTime) + ((missNum/total)*memTime);
		System.out.println("Effective access time = " + accessTime + "nsec.");
	}
	
	/*This method sets up the map that'll be used when loading cache lines.*/
	public static void assignLocations(){
		int blockAssigned = 0; //The cache line to be assigned to words
		
		//First for loop assigns location for each word
		for(int i = 0; i < location.length;){
			//Second for loop assigns correct number of words to block
			for(int j = 0; j < blockSize; j++){
				location[i] = blockAssigned;
				i++;
				if(i == location.length)
					break;
			}
			if(blockAssigned == lineNum-1)
				blockAssigned = 0;
			else
				blockAssigned++;
		}
	}
	
	/*This method loads an entire line to the cache when a word isn't found there.*/
	public static void loadLine(int foundNum, int[][] cache){
		int toLine = location[foundNum]; //The cache line words will be moved to
		int firstLoaded = foundNum; //This will be the first word loaded in the line
		
		//Decrement firstLoaded until it's the first in the set to be loaded
		while(firstLoaded != 0 && location[firstLoaded-1] == toLine){
			firstLoaded--;
		}
		
		//Load the words into the cache line
		for(int i = firstLoaded; i < location.length && location[i] == toLine;){
			for(int j = 0; j < blockSize; j++){
				cache[toLine][j] = i;
				i++;
			}
		}
		
	}
	
	/*This method changes the parameters for the simulation with user input.*/
	public static void configSim(){
		System.out.println("How large should a cache line be?");
		blockSize = keyboard.nextInt();
		System.out.println("How many cache lines should there be?");
		lineNum = keyboard.nextInt();
		System.out.println("How long should it take to access the cache?");
		cacheTime = keyboard.nextInt();
		System.out.println("How long should it take to access main memory?");
		memTime = keyboard.nextInt();
		System.out.println("Values set.");
	}
	
	/*This method tells the user the simulation parameters.*/
	public static void viewSim(){
		System.out.println("Size of Cache Line = " + blockSize + " words.");
		System.out.println("Number of Cache Lines = " + lineNum + " lines.");
		System.out.println("Cache Access Time = " + cacheTime + " nsec.");
		System.out.println("Memory Access Time = " + memTime + " nsec.");
	}
	
}