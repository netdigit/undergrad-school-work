/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/ProgrammingProject2/PriorQ.java
 * COSC 311
 * Programming Project 2: Aging in a Priority Queue
 * FALL 2016*/
import java.util.*;
import java.io.*;

/*This is the PriorQ class. It takes a list of ints from a .txt file,
 * inserts them into a priority queue based on the number, records 
 * the time it entered the queue, deletes everything out of the queue,
 * and tells you which value was the oldest, and how long (by number
 * of inserts/deletes) the value was in the queue.*/

public class PriorQ {
	
	//This int is just used in place of a magic number to determine how large the array should be.
	//It needs to be at least as long as the list of inputs.
	
	static int size = 50;
	
	
	static Node[] arr = new Node[size];  //This array is used to hold all the values for the priority queue.
	
	
	//counter is the time-keeping device for this. It's incremented in insertions and deletions.
	//total keeps track of the number of items in the priority queue.
	
	static int counter = 0;
	static int total = 0;
	
	
	//maxAge and maxData store the age and data of whatever value's been in the queue the longest.
	
	static int maxAge = -1;
	static int maxData = -1;
	
	
	/*The main method runs the program. It takes input from a .txt file, inserts it into 
	 * the queue, deletes the queue, and outputs the result.*/
	
	public static void main(String[] args) throws FileNotFoundException{
			
		Scanner input = new Scanner(new File("values.txt"));	//input is used to read from a .txt file. The name can be changed as needed.
		
		//This chunk takes every int from the file and puts it into the queue using the insert method.
		
		while(input.hasNextInt()){
			insert(input.nextInt());
		}
		
		//This chunk removes everything from the queue using the delete method.
		
		while(total > 0){
			delete();
		}
		
		//This chunk outputs the result to the console and closes the file input.
		
		System.out.println("The oldest element is data = "
				+ maxData + ", with age = " + maxAge);
		
		input.close();
		
	}
	
	
	/*The maxAge method calculates how long a deleted value has been in the 
	 * queue, compares that time to the current longest time, and replaces 
	 * it if necessary.*/
	
	public static void maxAge(Node n){
		int tempMax = counter - n.timestamp;	//Compare current time to time when it entered to find time spent in queue.
		
		
		if(tempMax < maxAge)
			return;				//If the time spent in the queue is smaller than the current longest, do nothing.
		
		else{
			maxData = n.value;	//If the time's longer, you replace the current max values with the new ones.
			maxAge = tempMax;
			return;
		}
	}
	
	
	/*The insert method takes a number and puts it in the priority queue.*/
	
	public static void insert(int data){
		Node n = new Node(data, counter);		//First it makes the node to be inserted out of the number and current time.
		
		//The node is placed in the next available spot in the priority queue array.
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == null){
				arr[i] = n;
				break;
			}
		}
		
		//Both total and the counter are incremented to show the larger queue size and pass of time.
		
		total++;
		counter++;
		return;
		
	}
	
	
	/*The delete method finds the lowest value in the queue, and deletes it, making sure to 
	 * send the value to the maxAge method so the length of time it spent in the queue can 
	 * be checked.*/
	
	public static void delete(){
		
		int minLoc = 0;			//minLoc is used as a reference to the current minimum value in the array.
		
		while(arr[minLoc] == null){
			minLoc++;				//minLoc starts set to the first available value.
		}
		
		//The minimum value (minLoc) is compared to every value in the queue one-by-one to find the smallest one.
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != null){
				if(arr[i].value < arr[minLoc].value)
					minLoc = i;
			}
		}
		
		//The minimum is sent to maxAge to be compared before being deleted.
		
		maxAge(arr[minLoc]);
		arr[minLoc] = null;
		
		//counter is incremented to show pass of time, and total is decremented to show smaller priority queue.
		
		total--;
		counter++;
		return;
		
	}
	
	
	/*The private class Node is used to hold the values of each entry as well as the 
	 * time the value entered the priority queue (built here as an array of Nodes).*/
	
	private static class Node{
		
		int value;			//Contains int from the .txt file.
		int timestamp;		//Contains the time entered from counter when initialized.
		
		//The node's value and timestamp are set when it's made.
		
		public Node(int x, int y){
			value = x;
			timestamp = y;
		}
		
	}
	
}
