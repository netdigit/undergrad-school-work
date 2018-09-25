/* Program written by Kelly Mayhew (E01411860) for Lab 4, for the
 * Tuesday/Thursday 1PM section of COSC 314 (Winter 2018, CRN 25089).
 * 
 * This program takes in a matrix by asking for a size and then all the values. It asks for
 * the starting vertex, then uses Dijksta's algorithm to find the shortest distance between
 * the starting vertex and all other vertices.
 * */

import java.util.*;

public class Dijkstra {
	static int n;	//The size of the n*n matrix
	static int start;	//The starting vertex
	static Vertex[] graph;	//An array of nodes representing each vertex
	static int[] reached;	//An array showing distance of which nodes have been connected to
	static int[] reachable;	//An array containing distances of currently reachable nodes
	//0 is unreachable, and -1 is already reached
	
	public static void main(String[] args) {
		//Get input from user
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is the size of the matrix?");
		n = keyboard.nextInt();
		int[][] matrix = new int[n][n];
		System.out.println("Enter values:");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("("+i+","+j+"): ");
				matrix[i][j] = keyboard.nextInt();
			}
		}
		System.out.println("Which vertex are you starting at?");
		start = keyboard.nextInt();
		
		createGraph(matrix);	//Create a graph from the matrix
		reached = new int[n];	//Create arrays
		reachable = new int[n];
		reachable[start] = -1;	//Indicate the start has been reached
		
		//Start iterating through until it's done
		boolean done = false;
		while(!done) {
			iteration();
			done = true;
			for(int i = 0; i < reachable.length; i++) {
				if(reachable[i] != -1) {
					done = false;
					break;
				}
			}
		}
		
		//Output results
		outputResults();
		keyboard.close();
	}
	
	/*This function makes a representation of the matrix as a graph in the graph array.*/
	public static void createGraph(int[][] matrix) {
		graph = new Vertex[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new Vertex(n);
			graph[i].setConnections(matrix[i]);
		}
	}
	
	//This function does one "row" in the algorithm. It calculates the new distances, then
	//adds the shortest one to what's been reached
	public static void iteration() {
		updateDistance();
		int nearestVertex = Integer.MAX_VALUE;
		int nearestPath = Integer.MAX_VALUE;
		
		for(int i = 0; i < reachable.length; i++) {
			if(reachable[i] < nearestPath && reachable[i] > 0) {
				nearestPath = reachable[i];
				nearestVertex = i;
			}
		}
		
		reached[nearestVertex] = nearestPath;
		reachable[nearestVertex] = -1;
	}
	
	//This function updates the reachable array based on the reached array for use in iteration
	public static void updateDistance() {
		int distance;
		for(int i = 0; i < reachable.length; i++) {
			if(reachable[i] == -1) {
				for(int j = 0; j < graph[i].connections.length; j++) {
					if(graph[i].connections[j] != 0) {
						distance = graph[i].connections[j] + reached[i];
						if(reachable[j] == 0 || reachable[j] > distance) {
							reachable[j] = distance;
						}
					}
				}
			}
		}
	}
	
	//This function outputs the results
	public static void outputResults() {
		for(int i = 0; i < reached.length; i++) {
			System.out.println("Vertex "+i+" is "+reached[i]+" away from vertex "+start);
		}
	}
	
	//This is a node class for each vertex in a graph
	private static class Vertex{
		int[] connections;
		//An array representing what other vertices the vertex is connected to
		//If 0, they're not connected
		
		//Constructor creates a connections array of the proper size
		private Vertex(int n) {
			connections = new int[n];
		}
		
		//setConnections sets the values in the connections array
		private void setConnections(int[] row) {
			for(int i = 0; i < n; i++) {
				connections[i] = row[i];
			}
		}
		
		
	}
	/*OUTPUT
	 * 
	 * */
}
