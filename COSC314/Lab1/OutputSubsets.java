import java.util.*;

public class OutputSubsets {
	
	/*public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many elements are in the set?"
				+ " (What is n?)");
		int n = keyboard.nextInt();
		System.out.println("What length of subsets would you like?"
				+ " (What is k?)");
		int k = keyboard.nextInt();
		
		Set<String> set = makeSet(n);
		System.out.println("Set: " + set);
		
		keyboard.close();
	}
	
	public static Set<String> makeSet(int n){
		Set<String> set = new Set<String>();
		
		for(int i = 1; i <= n; i++) {
			set.add("{"+i+"}");
		}
		
		return set;
	}*/
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many elements are in the set?"
				+ " (What is n?)");
		int n = keyboard.nextInt();
		System.out.println("What length of subsets would you like?"
				+ " (What is k?)");
		int k = keyboard.nextInt();
		
		ArrayList<String> set = makeSet(n);
		
		System.out.println("Set: " + set);
		
		//ArrayList<String> subsets = getSubsets(set, n, k);
		
		ArrayList<ArrayList<String>> powerset = powerset(set);
		System.out.println("Powerset: " + powerset);
		
		ArrayList<ArrayList<String>> subsets = new ArrayList<ArrayList<String>>();
		
		System.out.println("Result: " + subsets);
		keyboard.close();
	}
	
	public static ArrayList<String> makeSet(int n){
		ArrayList<String> set = new ArrayList<String>();
		
		for(int i = 1; i <= n; i++) {
			set.add("{"+i+"}");
		}
		
		return set;
	}
	
	public static ArrayList<ArrayList<String>> powerset(ArrayList<String> set){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(set.isEmpty()) {
			result.add(new ArrayList<String>());
			return result;
		}
		else {
			ArrayList<String> newSet = new ArrayList<String>(set);
			String head = newSet.get(0);
			ArrayList<String> rest = new ArrayList<String>(newSet.subList(1, newSet.size()));
			for (ArrayList<String> subset : powerset(rest)) {
				ArrayList<String> newOne = new ArrayList<String>();
				newOne.add(head);
				newOne.addAll(subset);
				result.add(newOne);
				result.add(subset);
			}
			return result;
		}
	}
	
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
	    Set<Set<T>> sets = new HashSet<Set<T>>();
	    if (originalSet.isEmpty()) {
	        sets.add(new HashSet<T>());
	        return sets;
	    }
	    List<T> list = new ArrayList<T>(originalSet);
	    T head = list.get(0);
	    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
	    for (Set<T> set : powerSet(rest)) {
	        Set<T> newSet = new HashSet<T>();
	        newSet.add(head);
	        newSet.addAll(set);
	        sets.add(newSet);
	        sets.add(set);
	    }       
	    return sets;
	} 
	
	public static ArrayList<String> getSubsets(ArrayList<String> set, int n, int k){
		Stack stack = new Stack();
		ArrayList<String> subsets = new ArrayList<String>();
		
		int startPos = 0;
		int toStack;
		
		while(true) {
			if(startPos == n-k+1)
				break;
			
			toStack = startPos;
			
			while(stack.size() != k) {
				
			}
		}
		
		return subsets;
	}
	
	/*public static ArrayList<ArrayList<String>> powerset(ArrayList<String> set){
		if(set.size() == 0) {
			ArrayList<ArrayList<String>> basecase = new ArrayList<ArrayList<String>>();
			ArrayList<String> emptyset = new ArrayList<String>();
			emptyset.add("{}");
			basecase.add(emptyset);
			return basecase;
		}
		else {
			ArrayList<ArrayList<String>> included = new ArrayList<ArrayList<String>>();
			ArrayList<String> firstItem = new ArrayList<String>();
			firstItem.add(set.get(0));
			included.add(firstItem);
			set.remove(0);
			ArrayList<ArrayList<String>> excluded = powerset(set);
			//return included + excluded;
			included.addAll(excluded);
			return included;
		}
	}*/
	
	//public static ArrayList<ArrayList<String>> genSubset(ArrayList<String> set){
		
	//}
	
}
