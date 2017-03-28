import java.util.HashMap;
import java.util.Scanner;

/*
 In task 1, given a word, 
 return the total number of key presses required to spell the word using the keypad. 
 
 Tests should follow the following format:
 number of test cases n
 word_1
 word_2
 ...
 word_n
 
 Assumption: words are assumed to contain only lower case alphabets a-z 
*/

public class CountKeyPresses {
	private String word;
	private int nPress;
	private HashMap<Character, Integer> nPressMap; // map the letter to the number of press it needs

	void PreProcess() {
		nPressMap = new HashMap<Character, Integer>();

		// according to the keyboard layout
		nPressMap.put('a', 1);
		nPressMap.put('b', 2);
		nPressMap.put('c', 3);
		nPressMap.put('d', 1);
		nPressMap.put('e', 2);
		nPressMap.put('f', 3);
		nPressMap.put('g', 1);
		nPressMap.put('h', 2);
		nPressMap.put('i', 3);
		nPressMap.put('j', 1);
		nPressMap.put('k', 2);
		nPressMap.put('l', 3);
		nPressMap.put('m', 1);
		nPressMap.put('n', 2);
		nPressMap.put('o', 3);
		nPressMap.put('p', 1);
		nPressMap.put('q', 2);
		nPressMap.put('r', 3);
		nPressMap.put('s', 4);
		nPressMap.put('t', 1);
		nPressMap.put('u', 2);
		nPressMap.put('v', 3);
		nPressMap.put('w', 1);
		nPressMap.put('x', 2);
		nPressMap.put('y', 3);
		nPressMap.put('z', 4);

	}

	void run() throws Exception {
		Scanner sc = new Scanner(System.in);

		int numTestCases = sc.nextInt(); // number of test cases in the input
		sc.nextLine();
		
		while (numTestCases-- > 0) {
			PreProcess();

			word = sc.nextLine(); // one test case per line and the input is assumed to be a word
			nPress = 0;
			
			// total number of presses needed is the sum of presses needed for each character
			for (char ch : word.toCharArray()) {
				nPress = nPress + nPressMap.get(ch);
			}

			System.out.println(nPress);

			if (numTestCases > 0)
				System.out.println();
		}

		sc.close();
	}

	public static void main(String[] args) throws Exception {
		CountKeyPresses task1 = new CountKeyPresses();
		task1.run();
	}

}