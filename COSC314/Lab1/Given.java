import java.util.*;

public class Given {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many elements are in the set?"
				+ " (What is n?)");
		int n = keyboard.nextInt();
		System.out.println("What length of subsets would you like?"
				+ " (What is k?)");
		int k = keyboard.nextInt();
		
		Set<String> set = makeSet(n);
		
		System.out.println("Set: " + set);
		
		//ArrayList<String> subsets = getSubsets(set, n, k);
		
		Set<Set<String>> powerset = powerSet(set);
		System.out.println("Powerset: " + powerset);
		
		HashSet<HashSet<String>> subsets = new HashSet<HashSet<String>>();
		
		for(int i = 0; i < powerset.size(); i++) {
			//if(powerset)
		}
		
		System.out.println("Result: " + subsets);
		keyboard.close();
	}
	
	public static HashSet<String> makeSet(int n){
		HashSet<String> set = new HashSet<String>();
		for(int i = 1; i <= n; i++) {
			set.add("{"+i+"}");
		}
		return set;
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
}
