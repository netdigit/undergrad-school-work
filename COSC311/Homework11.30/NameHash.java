/*Kelly Mayhew
 *http://people.emich.edu/kmayhew/COSC311/Homework11.30/NameHash.java
 *COSC 311
 *HW 11/30
 *FALL 2016*/
import java.util.*;
import java.io.*;

public class NameHash{
	
	static String[] hash = new String[8];
	static int capacity = 0;
	static String nextName;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner textFile = new Scanner(new File("Names.txt"));
		
		while(textFile.hasNextLine()){
			nextName = textFile.nextLine();
			insert(nextName);
			if(capacity/hash.length > .75){
				System.out.println("Current table:");
				for(int i = 0; i < hash.length; i++)
					System.out.println(i + "    " + hash[i]);
				rehash();
			}
		}
		
		System.out.println("Final hash table:");
		for(int i = 0; i < hash.length; i++)
			System.out.println(i + "    " + hash[i]);
		
		textFile.close();
		
	}
	
	public static void insert(String x){
		int place = hashCode(x);
		while(hash[place] != null){
			place++;
			if(place >= hash.length)
				place = 0;
		}
		hash[place] = x;
		capacity++;
	}
	
	public static void rehash() throws FileNotFoundException{
		hash = new String[hash.length*2];
		Scanner textFile = new Scanner(new File("Names.txt"));
		int origCapacity = capacity;
		for(int i = 0; i < origCapacity; i++){
			String name = textFile.nextLine();
			insert(name);
		}
		capacity = origCapacity;
		textFile.close();
	}
	
	public static int hashCode(String x){
		int code = x.hashCode();
		if(code < 0)
			code = code*-1;
		while(code >= hash.length)
			code = code/10;
		return code;
	}
	
}