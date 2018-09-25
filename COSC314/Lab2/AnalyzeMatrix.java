/* Program written by Kelly Mayhew (E01411860) for Lab 2, for the
 * Tuesday/Thursday 1PM section of COSC 314 (Winter 2018, CRN 25089).
 * 
 * This program takes in a matrix by asking for a size and then all the values. It then
 * finds out if that matrix is reflexive, symmetric, antisymmetric, and/or transitive
 * before telling the user whether not it is, and if it isn't, why it isn't.
 * */
import java.util.*;

public class AnalyzeMatrix {
	static boolean checkR = true;	//Hold whether or not the matrix is a property
	static boolean checkS = true;
	static boolean checkA = true;
	static boolean checkT = true;
	
	static String resultR;	//If fails, holds string explaining why
	static String resultS;
	static String resultA;
	static String resultT;
	
	static int n;	//The size of the n*n matrix
	
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
		
		//Run functions to check different properties
		checkReflexive(matrix);
		checkSymmetric(matrix);
		checkAntiSymmetric(matrix);
		checkTransitive(matrix);
		
		outputResults();	//Tell user the results
		
		keyboard.close();
	}
	
	/*This function finds whether or not the matrix is reflexive. It's set to false if
	 * one of the possible values (n,n) isn't set to 1.*/
	public static void checkReflexive(int[][] matrix) {
		for(int i = 0; i < n; i++) {
			if(matrix[i][i] != 1) {
				checkR = false;
				resultR = "Matrix is not reflexive because ("+i+", "+i+") is not in the set.";
				return;
			}
		}
	}
	
	/*This function finds whether or not the matrix is symmetric. It does so by checking
	 * (j,i) of each (i,j) that's set to 1. If the (j,i) isn't also set to 1, then it's false.*/
	public static void checkSymmetric(int[][] matrix) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 1) {
					if(matrix[j][i] != 1) {
						checkS = false;
						resultS = "Matrix is not symmetric because ("+i+", "+j+") is in the set"
								+" while ("+j+", "+i+") is not.";
						return;
					}
				}
			}
		}
	}
	
	/*This function finds whether or not the matrix is antisymmetric. It does so by checking
	 * (j,i) of each (i,j) (where i != j) that's set to 1. If the (j,i) is also 1, then it's
	 * set to false.*/
	public static void checkAntiSymmetric(int[][] matrix) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(matrix[i][j] == 1) {
						if(matrix[j][i] == 1) {
							checkA = false;
							resultA = "Matrix is not antisymmetric because both ("+i+", "+j
									+ ") and ("+j+", "+i+") are in the set.";
							return;
						}
					}
				}
			}
		}
	}
	
	/*This function finds whether or not the matrix is transitive. It does so by comparing
	 * the original matrix to the FoG of itself. It's set to false if the FoG isn't
	 * inside the original matrix.*/
	public static void checkTransitive(int[][] matrix) {
		//Get FoG of matrix using another function
		int[][] compareMatrix = fogMatrix(matrix);
		
		//Commented for testing
		/*System.out.println("Original:");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("FoG");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(compareMatrix[i][j]);
			}
			System.out.println();
		}*/
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if((compareMatrix[i][j] == 1) && (matrix[i][j] == 0)) {
					checkT = false;
					resultT = "Matrix is not transitive because the matrix, after being"
							+ " multiplied by itself, is not within the original matrix."
							+ " Ex: ("+i+", "+j+") of the original is 0 while ("+i+", "+j
							+ ") of the multiplied one is 1.";
				}
			}
		}
	}
	
	/*This function multiplies a matrix with itself and returns the result.*/
	public static int[][] fogMatrix(int[][] matrix) {
		int[][] returnVal = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					//returnVal[i][j] += matrix[i][k] + matrix[k][j];
					if(matrix[i][k] == 1 || matrix[k][j] == 1) {
						returnVal[i][j] = 1;
						break;
					}
				}
			}
		}
		
		return returnVal;
	}
	
	/*This function outputs results. If the matrix is true for a property, it says so,
	 * otherwise if outputs why it failed the test.*/
	public static void outputResults() {
		if(checkR)
			System.out.println("Matrix is reflexive.");
		else
			System.out.println(resultR);
		
		if(checkS)
			System.out.println("Matrix is symmetric.");
		else
			System.out.println(resultS);
		
		if(checkA)
			System.out.println("Matrix is antisymmetric.");
		else
			System.out.println(resultA);
		
		if(checkT)
			System.out.println("Matrix is transitive.");
		else
			System.out.println(resultT);
	}
	/* OUTPUT
	 * 3x3 Matrix:
	 * Matrix is not reflexive because (0, 0) is not in the set.
	Matrix is not symmetric because (0, 1) is in the set while (1, 0) is not.
	Matrix is not antisymmetric because both (1, 2) and (2, 1) are in the set.
	Matrix is not transitive because the matrix, after being multiplied by itself, 
	is not within the original matrix. Ex: (2, 2) of the original is 0 while (2, 2) 
	of the multiplied one is 1.
	 * 
	 * 4x4 Matrix:
	 * Matrix is not reflexive because (0, 0) is not in the set.
	Matrix is symmetric.
	Matrix is not antisymmetric because both (0, 1) and (1, 0) are in the set.
	Matrix is not transitive because the matrix, after being multiplied by itself,
	 is not within the original matrix. Ex: (3, 3) of the original is 0 while (3, 3)
	  of the multiplied one is 1.
	 * 
	 * 6x6 Matrix:
	 * Matrix is reflexive.
	Matrix is not symmetric because (0, 1) is in the set while (1, 0) is not.
	Matrix is antisymmetric.
	Matrix is not transitive because the matrix, after being multiplied by itself, 
	is not within the original matrix. Ex: (5, 3) of the original is 0 while (5, 3) 
	of the multiplied one is 1.
	 * */
}
