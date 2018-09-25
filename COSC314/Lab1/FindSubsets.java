/* Program written by Kelly Mayhew (E01411860) for Lab 1, for the
 * Tuesday/Thursday 1PM section of COSC 314 (Winter 2018, CRN 25089).
 * 
 * This program finds all subsets of a set n that are length k. It does this
 * by creating a set, finding all subsets of the set via a powerset function,
 * and outputting only those subsets that are length k.
 * */

import java.util.*;

public class FindSubsets {
	
	public static void main(String[] args) {
		//Get input from user.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many elements are in the set?"
				+ " (What is n?)");
		int n = keyboard.nextInt();
		System.out.println("What length of subsets would you like?"
				+ " (What is k?)");
		int k = keyboard.nextInt();
		
		//Create set and powerset based on user input.
		ArrayList<String> set = makeSet(n);
		//System.out.println("Set: " + set);
		ArrayList<ArrayList<String>> powerset = powerset(set);
		//System.out.println("Powerset: " + powerset);
		
		//Make a subset of subsets from the powerset that are length k.
		ArrayList<ArrayList<String>> subsets = new ArrayList<ArrayList<String>>();
		while(!powerset.isEmpty()) {
			ArrayList<String> check = powerset.get(0);
			if(check.size() == k)
				subsets.add(check);
			powerset.remove(0);
		}
		
		//Output results.
		System.out.println("Result: " + subsets);
		keyboard.close();
	}
	
	/*This function makes the initial set by adding all numbers 1-n as strings.*/
	public static ArrayList<String> makeSet(int n){
		ArrayList<String> set = new ArrayList<String>();
		for(int i = 1; i <= n; i++) {
			set.add(""+i);
		}
		return set;
	}
	
	/* This function outputs the powerset of a set. It's based off a recursive algorithm
	 * found online.*/
	public static ArrayList<ArrayList<String>> powerset(ArrayList<String> set){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		//Base case is the empty set
		if(set.isEmpty()) {
			result.add(new ArrayList<String>());
			return result;
		}
		//Otherwise, it splits the set into a head and tail and runs through all possibilities.
		else {
			String head = set.get(0);
			ArrayList<String> tail = new ArrayList<String>(set.subList(1, set.size()));
			/*The for loop is done for each result from recursive calls of the powerset
			function, or every subset of the original set. includeHead covers subsets
			where the first element of the set (the head) is included, and excludeHead
			covers subsets where it's excluded.*/
			for (ArrayList<String> excludeHead : powerset(tail)) {
				ArrayList<String> includeHead = new ArrayList<String>();
				includeHead.add(head);
				includeHead.addAll(excludeHead);
				result.add(includeHead);
				result.add(excludeHead);
			}
			return result;
		}
	}
	/* OUTPUT
	 * n = 4 & k = 2:
	 * [[3, 4], [2, 4], [1, 4], [2, 3], [1, 3], [1, 2]]
	 * 
	 * n = 5 & k = 3:
	 * [[3, 4, 5], [2, 4, 5], [1, 4, 5], [2, 3, 5], [1, 3, 5], [1, 2, 5],
	 * [2, 3, 4], [1, 3, 4], [1, 2, 4], [1, 2, 3]]
	 * */
}