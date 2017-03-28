# README
This is the description on how the solutions are organised.


There are 2 directories, namely code and tests. 


# code folder 
It contains solutions to the four tasks separately and a "Words.txt" file, which is for task 4.


## Task 1: CountKeyPresses.java
Requirement: Given a word, return the total number of key presses required to spell the word using the keypad. 

Tests for task 1 should follow the following format:
number of test cases n
word_1
word_2
...
word_n

Assumption: words are assumed to contain only lower case alphabets a-z 


## Task 2: GettingPressSequence.java
Requirement: Given a word, return the the number that the word could represent.

Tests for task 2 should follow the following format:
number of test cases n
word_1
word_2
...
word_n

Assumption: words are assumed to contain only lower case alphabets a-z 


## Task 3: GettingAllCombinations.java
Requirement: Given a number, return all possible letter combinations that the number could represent.

Tests for task 3 should follow the following format:
number of test cases n
number_1
number_2
...
number_n

Assumption: numbers are assumed to be within the range 2 to 9 


## Task 4: FindWordsInTheDictionary.java
Requirement: Given a number, return all possible word combinations from Dictionary that the number could represent.

Tests for task 4 should follow the following format:
number of test cases n
number_1
number_2
...
number_n

Assumption: numbers are assumed to be within the range 2 to 9 

Note: 	The original Dictionary "WordsRTF.rtf" was in RTF format. 
		Please use convert to plain text format and saved as "Words.txt".
		Please set the file path in Line 66 according to the location you save the file.


# test folder
The test cases are in the test folder. For task 1, the input file is "task1.in" and it should return the same output as "task1.out". Similarly for other tasks.
