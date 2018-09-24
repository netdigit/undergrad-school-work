/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/Homework10.10StackMax/StackMax.java
 * COSC 311
 * HW 10/10
 * FALL 2016*/

public class StackMax {
	
	static int[] values = new int[10];
	static int[] maxes = new int[10];
	static int valuesTop = -1;
	static int maxesTop = -1;
	
	public static void main(String[] args){
		
		System.out.println("Pushing values onto stack: 13, 4, 19, 2");
		
		push(13);
		push(4);
		push(19);
		push(2);
		
		System.out.println("Top of stack: " + peek());
		System.out.println("Max value in stack: " + max());
		
		System.out.println("Popping 2 values in stack.");
		
		pop();
		pop();
		
		System.out.println("Top of stack: " + peek());
		System.out.println("Max value in stack: " + max());
		
	}
	
	static public void push(int x){
		
		if(valuesTop == -1){
			values[valuesTop + 1] = x;
			valuesTop++;
			maxes[maxesTop + 1] = x;
			maxesTop++;
		}
		
		else{
			values[valuesTop + 1] = x;
			valuesTop++;
			if(x >= maxes[maxesTop]){
				maxes[maxesTop + 1] = x;
				maxesTop++;
			}
		}
	}
	
	static public void pop(){
		
		if(valuesTop == -1){
			return;
		}
		
		else{
			if(values[valuesTop] == maxes[maxesTop]){
				maxesTop--;
			}
			valuesTop--;
		}
	}
	
	static public int peek(){
		
		if(valuesTop == -1){
			System.out.println("No values in stack. Returning 0.");
			return 0;
		}
		
		else{
			return values[valuesTop];
		}
	}
	
	static public int max(){
		
		if(valuesTop == -1){
			System.out.println("No values in stack. Returning 0.");
			return 0;
		}
		
		else{
			return maxes[maxesTop];
		}
	}
	
}
