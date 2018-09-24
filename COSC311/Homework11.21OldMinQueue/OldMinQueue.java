/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/Homework11.21OldMinQueue/OldMinQueue.java
 * COSC 311
 * HW 11/21
 * FALL 2016*/
import java.util.*;

public class OldMinQueue {
	
	static int counter = 0;
	static int maxAge = -1;
	static int maxData = -1;
	static Node head = null;
	
	public static void main(String[] args){
		System.out.println("Inserting values: 1, 7, 3, 4, 5, 6, 1, 2, 3");
		insert(1);
		insert(7);
		insert(3);
		insert(4);
		insert(5);
		insert(6);
		insert(1);
		insert(2);
		insert(3);
		
		System.out.println("Deleting all values...");
		delete();
		delete();
		delete();
		delete();
		delete();
		delete();
		delete();
		delete();
		delete();
		
		System.out.println("The oldest element is data = "
				+ maxData + ", with age = " + maxAge);
	}
	
	public static void maxAge(Node n){
		int tempMax = Math.max((counter - n.timestamp), maxAge);
		if(tempMax < maxAge)
			return;
		else{
			maxData = n.data;
			maxAge = tempMax;
			return;
		}
	}
	
	public static void insert(int data){
		Node n = new Node(data, counter);
		if(head == null){
			head = n;
			counter++;
		}
		else{
			head.getNode(n);
			counter++;
		}
	}
	
	public static void delete(){
		maxAge(head);
		head = head.next;
		counter++;
		return;
	}
	
	private static class Node{
		 
		 Node next = null;
		 Node prev = null;
		 int data;
		 int timestamp;
		 
		 public Node(int x, int y){
			 data = x;
			 timestamp = y;
		 }
		 
		 public void getNode(Node n){
			 if(next == null){
				 next = n;
				 n.rearrange();
				 return;
			 }
			 else{
				 next.getNode(n);
			 }
		 }
		 
		 public void rearrange(){
			 if(prev == null){
				 return;
			 }
			 else if(data < prev.data){
				 Node x = prev;
				 x.prev.next = x.next;
				 x.next = next;
				 prev = x.prev;
				 x.prev = x.prev.next;
				 rearrange();
			 }
		 }
		 
	 }
	
}
