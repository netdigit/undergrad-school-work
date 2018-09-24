Written by Kelly Mayhew for Project 3, COSC 321

This is a java program that takes an input file that has the numbers 0-99,
each representing a word in memory, separated by lines and calculates
what the hit ratio and effective access time would be if a directly mapped
cache tried to read those words. The simulation parameters and input file
can be freely changed between simulations, and the program runs until the
user tells it to exit.

Commands:
run - Runs simulation using input file.
config - Changes simulation parameters.
view - Lists simulation parameters.
quit - Exits program.

Input File Layout:
#0-99
#0-99
#0-99

The input file is just a list of numbers 0-99. Each number must be on its
own line.