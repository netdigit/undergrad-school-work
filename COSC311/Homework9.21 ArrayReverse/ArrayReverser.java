/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC%20311/Homework9.21%20ArrayReverse/ArrayReverser.java
 * COSC 311
 * HW 09/21
 * FALL 2016*/

public class ArrayReverser {
	
	public static void main(String[] args){
		int[] array = new int[]{1, 6, 4, 14, 86, 97, 100, 32, 93, 50, 62};
		int temp;
		
		for(int i = 0, j = array.length - 1; i <= array.length/2 - 1; i++, j--){
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
		}
	}
	
}
