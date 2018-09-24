/*Kelly Mayhew
 * http://people.emich.edu/kmayhew/COSC311/Homework11.07RecursiveBalance/RecursiveBalance.java
 * COSC 311
 * HW 11/07
 * FALL 2016*/
 
 public class RecursiveBalance{
	 
	 static Node head;
	 
	 public static void main(String[] args){
		 insert(10);
		 insert(5);
		 insert(15);
		 insert(3);
		 insert(13);
		 insert(17);
		 insert(18);
		 insert(22);
		 insert(21);
		 System.out.println(balance(head));
	 }
	 
	 public static void insert(int x){
		 if(head == null)
			 head = new Node(x);
		 else{
			 Node newNode = new Node(x);
			 head.getChild(newNode);
		 }
	 }
	 
	 public static int height(Node start){
		 if(start == null)
			return 0;
		 if(start.leftChild == null && start.rightChild == null)
			 return 0;
		 else{
			 return 1 + Math.max(height(start.rightChild), height(start.leftChild));
		 }
	 }
	 
	 public static int balance(Node start){
		 if(start == null)
			 return 0;
		 if(start.leftChild == null && start.rightChild == null)
			 return 0;
		 else{
			 return height(start.rightChild) - height(start.leftChild);
		 }
	 }
	 
	 private static class Node{
		 
		 Node leftChild = null;
		 Node rightChild = null;
		 int value;
		 
		 public Node(int x){
			 value = x;
		 }
		 
		 public void getChild(Node child){
			 if(child.value <= value){
				 if(leftChild != null)
					 leftChild.getChild(child);
				 else
					 leftChild = child;
			 }
			 else{
				 if(rightChild != null)
					 rightChild.getChild(child);
				 else
					 rightChild = child;
			 }
		 }
	 }
	 
 }