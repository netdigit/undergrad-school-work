import java.util.*;

public class ArraySets {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many elements are in the set?"
				+ " (What is n?)");
		int n = keyboard.nextInt();
		System.out.println("What length of subsets would you like?"
				+ " (What is k?)");
		int k = keyboard.nextInt();
		
		int[] set = makeArray(n);
		
		ArrayList<int[]> powerset = powerset(set);
	}
	
	public static int[] makeArray(int n) {
		int[] result = new int[n];
		for(int i = n; i > 0; i--) {
			result[i-1] = i;
		}
		return result;
	}
	
	public static ArrayList<int[]> powerset(int[] set){
		ArrayList<int[]> result = new ArrayList<int[]>();
		if(set.length == 0) {
			
		}
		return result;
	}
	
}
