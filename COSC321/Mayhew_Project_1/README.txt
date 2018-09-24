Written by Kelly Mayhew for Project 1, COSC 321

This is a java program that takes an input file describing the wiring
for a 3x3 grid of NAND gates and outputs the result from all combinations
of inputs going through that grid. The input file must be there to run, 
but the output file is generated. It's made of two files that are both
original code. To run it, use whatever method to compile and interpret
java you'd like, such as opening it in an IDE or compiling and running
via a Mac's terminal.

Input File Name: NANDinput.txt
Output File Name: NANDoutput.txt

Compile-Time Parameters:
3x3 grid of NAND gates (m = 3, n = 3)
3 inputs: A, B, and C (j = 3)
2 outputs: Y and Z (k = 2)

Input File Layout:
Gate Line: <GATE#> <INPUT> <INPUT>
Output Line: <OUPUT> <GATE#>

The input file has 9 lines (one for each gate) + 2 (one for each output),
making a total of eleven lines. Gate lines tell the gate and what its
inputs are, and output lines list the output and what gate it pulls from.

Output File Layout:
A B C Y Z
# # # # #

The output file has a line of the inputs (A, B, C) and outputs (Y, Z) at 
the top, followed by lines of 1s and 0s. A "1" indicates "true" while a 
"0" indicates "false."

The program uses two files:
LogicCircuit.java - sets up the NAND gate grid by reading in the wiring
list, then changes input values and outputs the results to a new file.
NANDGate.java - a node class used to represent each gate, input, and 
output. Used to make getting the results from each gate convenient.