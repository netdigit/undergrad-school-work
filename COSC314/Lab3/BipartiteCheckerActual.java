/* Program written by Kelly Mayhew (E01411860) for Lab 3, for the
 * Tuesday/Thursday 1PM section of COSC 314 (Winter 2018, CRN 25089).
 * 
 * This program takes in a matrix by asking for a size and then all the values. It then
 * determines if the matrix is bipartite by generating a graph and coloring each vertex.
 * When done, it tells the user the result.
 * */

import java.util.*;

public class BipartiteCheckerActual {
	static int n;	//The size of the n*n matrix
	static Vertex[] graph;	//An array of nodes representing each vertex
	
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
		
		createGraph(matrix);	//Create a graph from the matrix
		boolean result = color();	//Color said graph
		
		//If true, the graph was successfully colored, and is therefore bipartite
		if(result) {
			System.out.println("Matrix is bipartite.");
			System.out.println("Bipartitions:");
			System.out.print("Group 1: Vertices ");
			for(int i = 0; i < graph.length; i++) {
				if(graph[i].color == 1)
					System.out.print(i+" ");
			}
			System.out.print("Group 2: Vertices ");
			for(int i = 0; i < graph.length; i++) {
				if(graph[i].color == 2)
					System.out.print(i+" ");
			}
		}
		else
			System.out.println("Matrix is not bipartite.");
		
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
	
	/*color goes through the graph over and over again until every vertex is colored.*/
	public static boolean color() {
		//Check for self-loop
		for(int i = 0; i < graph.length; i++) {
			if(graph[i].connections[i]) {
				System.out.println("Self-loop");
				return false;
			}
		}
		
		int toColor = 1;	//Start with red
		graph[0].setColor(toColor);	//Set first vertex to red
		boolean fullyColored = false;	//Graph is not yet colored
		
		while(!fullyColored) {
			boolean wasColored = coloring();	//Try coloring the graph
			
			if(!wasColored)
				return false;	//If failed to color, the graph isn't bipartite
			
			fullyColored = true;
			//If for whatever reason a vertex is uncolored, go back over it and color again
			for(int i = 0; i < graph.length; i++) {
				if(graph[i].color == 0)
					fullyColored = false;
			}
		}
		return true;	//If all goes well, the graph is bipartite
	}
	
	/*coloring does one sweep of the graph, coloring vertices in order depending on
	 * their connections*/
	public static boolean coloring() {
		for(int i = 0; i < graph.length; i++) {
			//First set the color that this vertex will try to color all its neighbors
			int setColor = 0;
			if(graph[i].color == 1)
				setColor = 2;
			else if(graph[i].color == 2)
				setColor = 1;
			
			if(setColor == 0)	//if still unset, skip to next
				continue;
			
			//For each vertex this vertex is connected to, try to color them
			for(int j = 0; j < graph[i].connections.length; j++) {
				if(graph[i].connections[j]) {
					boolean wasSet = graph[j].setColor(setColor);
					if(!wasSet)
						return false;	//If there's any failure, graph isn't bipartite
				}
			}
		}
		return true;	//If all goes well, graph is bipartite
	}
	
	//This is a node class for each vertex in a graph
	private static class Vertex{
		boolean[] connections;
		//An array representing what other vertices the vertex is connected to
		int color;	//What color the vertex is. 0 is unset, 1 is red, 2 is blue
		
		//Constructor creates a connections array of the proper size, and blanks the color value
		private Vertex(int n) {
			connections = new boolean[n];
			color = 0;
		}
		
		//setConnections sets the values in the connections array
		private void setConnections(int[] row) {
			for(int i = 0; i < n; i++) {
				if(row[i] == 1)
					connections[i] = true;
				else
					connections[i] = false;
			}
		}
		
		//setColor tries to change the color of the vertex and tells the user if it was
		//successful or not
		private boolean setColor(int n) {
			if(color == 0) {
				color = n;
				return true;
			}
			else {
				if(color == n)
					return true;
				else
					return false;
			}
		}
	}
	/*OUTPUT
	 * For matrix 1:
	 * 	Matrix is bipartite.
	 * 	Bipartitions:
	 *	Group 1: Vertices 0 1 2 Group 2: Vertices 3 4 5 
	 * For matrix 2:
	 * 	Matrix is not bipartite.
	 * */
}
