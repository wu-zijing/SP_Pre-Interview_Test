import java.util.HashMap;
import java.util.Scanner;

/*
In task 2, given a word, 
return the the number that the word could represent.

Tests should follow the following format:
number of test cases n
word_1
word_2
...
word_n

Assumption: words are assumed to contain only lower case alphabets a-z 
*/

public class GettingPressSequence {
	private String word;
	private HashMap<Character, Integer> keyboardMap; // map the letter to the number it is associated with

	void PreProcess() {
		keyboardMap = new HashMap<Character, Integer>();

		// according to the keyboard layout
		keyboardMap.put('a', 2);
		keyboardMap.put('b', 2);
		keyboardMap.put('c', 2);
		keyboardMap.put('d', 3);
		keyboardMap.put('e', 3);
		keyboardMap.put('f', 3);
		keyboardMap.put('g', 4);
		keyboardMap.put('h', 4);
		keyboardMap.put('i', 4);
		keyboardMap.put('j', 5);
		keyboardMap.put('k', 5);
		keyboardMap.put('l', 5);
		keyboardMap.put('m', 6);
		keyboardMap.put('n', 6);
		keyboardMap.put('o', 6);
		keyboardMap.put('p', 7);
		keyboardMap.put('q', 7);
		keyboardMap.put('r', 7);
		keyboardMap.put('s', 7);
		keyboardMap.put('t', 8);
		keyboardMap.put('u', 8);
		keyboardMap.put('v', 8);
		keyboardMap.put('w', 9);
		keyboardMap.put('x', 9);
		keyboardMap.put('y', 9);
		keyboardMap.put('z', 9);
	}

	void run() throws Exception {
		Scanner sc = new Scanner(System.in);

		int numTestCases = sc.nextInt(); // number of test cases in the input
		sc.nextLine();

		while (numTestCases-- > 0) {
			PreProcess();

			word = sc.nextLine(); // one test case per line and the input is assumed to be a word
			for (char ch : word.toCharArray()) {
				System.out.print(keyboardMap.get(ch));
			}
			System.out.printf("\n");

			if (numTestCases > 0)
				System.out.println();
		}

		sc.close();
	}

	public static void main(String[] args) throws Exception {
		GettingPressSequence task2 = new GettingPressSequence();
		task2.run();
	}

}
