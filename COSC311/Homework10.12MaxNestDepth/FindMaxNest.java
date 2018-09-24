/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/Homework10.12MaxNestDepth/FindMaxNest.java
 * COSC 311
 * HW 10/12
 * FALL 2016*/
import java.util.*;

public class FindMaxNest {
	
	static Scanner keyboard = new Scanner(System.in);
	static Stack stack = new Stack();
	static int currentDepth = 0;
	static int maxDepth = 0;
	
	public static void main(String[] args){
		System.out.print("Enter parentheses: ");
		String paren = keyboard.nextLine();
		System.out.print("Max depth: ");
		
		for(int i = 0; i < paren.length(); i++){
			if(paren.substring(i, i+1).equalsIgnoreCase("("))
				push();
			else if(paren.substring(i, i+1).equalsIgnoreCase(")"))
				pop();
		}
		
		if(!stack.isEmpty()){
			System.out.println(-1);
		}
		else{
			System.out.println(maxDepth);
		}
	}
	
	public static void push(){
		stack.push(1);
		if(currentDepth == maxDepth)
			maxDepth++;
		currentDepth++;
	}
	
	public static void pop(){
		stack.pop();
		currentDepth--;
	}
	
}
