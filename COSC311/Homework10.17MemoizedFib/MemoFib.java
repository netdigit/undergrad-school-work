/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/Homework10.17MemoizedFib/MemoFib.java
 * COSC 311
 * HW 10/17
 * FALL 2016*/
import java.util.*;

public class MemoFib {
	
	static int[] fib = new int[25];
	
	public static void main(String[] args){
		fib[0] = 1;
		fib[1] = 1;
		
		Scanner keyboard = new Scanner(System.in);
		boolean cont = true;
		int k;
		int result;
		
		while(cont){
			System.out.print("Enter number between 0 and 24 to be calculated: ");
			k = keyboard.nextInt();
			
			result = fibonacci(k);
			System.out.println("Number " + k + " in Fibonacci sequence is " + result);
			
			System.out.print("Would you like to calculate another? (y/n): ");
			if(keyboard.next().equalsIgnoreCase("n"))
				cont = false;
		}
		
		keyboard.close();
	}
	
	public static int fibonacci(int k){
		if(fib[k] != 0){
			return fib[k];
		}
		else{
			return fibonacci(k-1) + fibonacci(k-2);
		}
	}
	
}
