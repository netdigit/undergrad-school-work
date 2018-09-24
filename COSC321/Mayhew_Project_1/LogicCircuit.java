import java.util.*;
import java.io.*;

public class LogicCircuit {

	static NANDGate a = new NANDGate();
	static NANDGate b = new NANDGate();
	static NANDGate c = new NANDGate();
	static NANDGate[] gates = {
			new NANDGate(), //1 All these gates are individually
			new NANDGate(), //2 initialized because otherwise you
			new NANDGate(), //3 get a null pointer exception.
			new NANDGate(), //4
			new NANDGate(), //5
			new NANDGate(), //6
			new NANDGate(), //7
			new NANDGate(), //8
			new NANDGate(),}; //9
	static NANDGate y = new NANDGate();
	static NANDGate z = new NANDGate();
	
	public static void main(String[] args){
		try{
			
			/* First we will read the input file and wire everything
			 * according to what it says.*/
			
			Scanner in = new Scanner(new File("NANDinput.txt"));
			
			while(in.hasNext()){
				String gateSelect = in.next();
				
				NANDGate chosenGate = finder(gateSelect);
				
				if(chosenGate.equals(y)){
					String outGate = in.next();
					NANDGate input = finder(outGate);
					y = new NANDGate(input);
				}
				else if(chosenGate.equals(z)){
					String outGate = in.next();
					NANDGate input = finder(outGate);
					z = new NANDGate(input);
				}
				else{
					String inOne = in.next();
					String inTwo = in.next();
					NANDGate inputOne = finder(inOne);
					NANDGate inputTwo = finder(inTwo);
					gates[Integer.parseInt(gateSelect)-1] = new NANDGate(inputOne, inputTwo);
				}
				
			}
			
			in.close();
			
			/* Now we will create an output file, test the 8 cases,
			 * and write their results to the output.*/
			
			PrintWriter out = new PrintWriter("NANDoutput.txt");
			out.println("A B C Y Z");
			
			write(out);			//I'm sure there's a more elegant
			c.toReturn = true;	//way to do this, but that's for
			write(out);			//another time.
			b.toReturn = true;
			c.toReturn = false;
			write(out);
			c.toReturn = true;
			write(out);
			a.toReturn = true;
			b.toReturn = false;
			c.toReturn = false;
			write(out);
			c.toReturn = true;
			write(out);
			b.toReturn = true;
			c.toReturn = false;
			write(out);
			c.toReturn = true;
			write(out);
			
			out.close();
			
		}
		catch(FileNotFoundException e){
			System.out.println("Could not find input file.");
		}
		
	}
	
	/* Finder is a method used when wiring to convert the 
	 * given gate number or output letter from the input file
	 * to the corresponding NAND gate. */
	public static NANDGate finder(String s){
		if(s.equalsIgnoreCase("a"))
			return a;
		else if(s.equalsIgnoreCase("b"))
			return b;
		else if(s.equalsIgnoreCase("c"))
			return c;
		else if(s.equalsIgnoreCase("y"))
			return y;
		else if(s.equalsIgnoreCase("z"))
			return z;
		else{
			int gateNumber = Integer.parseInt(s);
			return gates[gateNumber-1];
		}
	}
	
	/* Write is a method used so I don't need to retype
	 * formatting to put in the output file every time. 
	 * It should be called after the input values are set. */
	public static void write(PrintWriter out){
		String toPrint = a + " " + b + " " + c + " " + y + " " + z;
		out.println(toPrint);
	}
	
}
