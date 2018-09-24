/*Kelly Mayhew
 * people.emich.edu/kmayhew/COSC%20311/Homework9.14%20RandomSelection/RandomSelector.java
 * COSC 311
 * HW 09/14
 * FALL 2016*/
import java.util.*;

public class RandomSelector {
	
	public static void main(String[] args){
		
		int options[] = new int[]{32, 65, 11, 87, 3, 10, 5, 44, 25, 16};
		Random chooser = new Random();
		int choice;
		int chosen[] = new int[]{-1, -1, -1};
		
		for(int i = 0; i < 3; i++){
			choice = chooser.nextInt(10);
			
			while(choice == chosen[0] || choice == chosen[1] || choice == chosen[2]){
				choice = chooser.nextInt(10);
			}
			
			chosen[i] = choice;
		}
		
		for(int i = 0; i < 3; i++){
			System.out.println(options[chosen[i]]);
		}
		
	}
	
}
