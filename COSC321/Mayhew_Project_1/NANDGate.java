/* This is basically a renamed Node class for use in the
 * Logic Circuit program. Each NAND gate will have 2 input
 * and 1 output variables determined by the input text file,
 * and a function that NANDs the inputs for the output.
 * 
 * It's also used for the inputs and outputs, in which case
 * the nand function runs differently, instead returning either
 * the value being input (for an input) or the output of a 
 * different NAND gate (for an output).
 * */

public class NANDGate {
	
	boolean isGate; //Tells if node is a NAND gate or input
	boolean isOutput; //If not a gate, is it an output?
	boolean toReturn; //If input, what is its charge?
	NANDGate inputOne; //If gate, what are the inputs?
	NANDGate inputTwo;
	
	public NANDGate(){ //Constructor for an input
		isGate = false;
		isOutput = false;
		toReturn = false;
	}
	
	public NANDGate(NANDGate one){ //Constructor for an output
		isGate = false;
		isOutput = true;
		inputOne = one; //Just use one gate as the output
	}
	
	public NANDGate(NANDGate one, NANDGate two){ //Constructor for a gate
		isGate = true;
		isOutput = false;
		inputOne = one;
		inputTwo = two;
	}
	
	/* The nand function returns either true or false depending
	 * on whether the node is an input, output, or gate. The return
	 * value is dependent on the inputs unless the node IS an input.
	 * */
	public boolean nand(){
		if(isGate){
			//If a gate, return the NAND of the inputs
			return !(inputOne.nand() && inputTwo.nand());
		}
		else if(isOutput){
			//If an output, return the out of the gate it's wired to
			return inputOne.nand();
		}
		else{
			//If an input, return the input value
			return toReturn;
		}
	}
	
	/* ToString returns the output of the node as 1 if it returns
	 * true, or 0 if it returns false. It's used to convert these
	 * values so they can be written to the output file.
	 * */
	public String toString(){
		boolean outValue = nand();
		
		if(outValue)
			return "1";
		else
			return "0";
	}
}
