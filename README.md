# Computer Science 1027

A repository of the assignments completed as part of the CS 1027 course at the University of Western Ontario. Note that many of these files were pre-coded by the professors and teaching assistants. Following is a short description of each assignment.

## Assignment 1
A program that calculates customer quotes for a flooring contractor. All floors are rectangular, but the material type of the flooring will change the amount of material needed and the waste produced from leftover materials. The following flooring options are available: poured (ex. concrete), rolls (ex. carpets, linoleum), planks (ex. wood planks), and square tiles (ex. ceramic), and quotes are calculated based off the price per square inch of the materials plus a contractor markup. Beyond classes for each material type, an additional class to calculate the cheapest and least wasteful option is presented. **GRADE: 100%**
<br>
<br>
Personally-coded files: 
- Flooring.java
- Plank.java
- Roll.java
- Tile.java
- QuoteTable.java

## Assignment 2
The "Monster Mash" assignment. Each of the three monster types have a specific dance movement set that allows them to move around on a square dance floor, made of an array of linked lists. The **Blub** monster slides back and forth between two adjacent squares, defined by either horizontal or vertical movement. If a movement will take it off the dance floor, the Blub will not move. 
<br>
The **Grink** monster is given a linked list of movements that can contain any cardinal direction, and the list typically ends with "repeat", restarting the entire sequence. If at any point the next action takes the Grink off the dance floor, it will simply skip the action and proceed to the next one.
<br>
The **Orbin** monster always moves along the edge of the dance floor in a clockwise direction. If its origin is not on the perimeter, it will move in the specified direction until it reaches the wall, but then never moves away from the perimeter again. **GRADE: 100%**
<br>
<br>
Personally-coded files: 
- Blub.java
- Grink.java
- Orbin.java
- LinkedGrid.java

## Assignment 3
A type of decoding assignment where the objective is to convert Roman numerals its Arabic value, as well as checking for invalid inputs as dictated by the rules of Roman numerals. Additionally, another class compares one Roman numeral to another to decide which is larger. **GRADE: 100%**
<br>
<br>
Personally-coded files: 
- RomanNumeralException.java
- Roman2Arabic.java
- RomanNumeral.java

## Assignment 4
This assignment models DNA as a sequence of characters in order to find **palindromic sequences** (ex. ATGCCGTA) and **tandem repeats** (repeating sequences of a certain length and number of repetitions, ex. GGAGGAGGAGGA) within a sequence of input DNA. The palindrome checker class recognizes palindroms of a certain legnth, and the repeat checker recognizes seauences of a certain legnth that is repeated a certiain number of times. An additional analyer class takes a sequence to check for specific types of sequences. **GRADE: 100%**
<br>
<br>
Personally-coded files: 
- Checker.java
- PalindromeChecker.java
- RepeatCheckDnaAnalyser.java
- DnaAnalyser.java 
