import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
In task 4, given a number, 
return all possible word combinations from Dictionary that the number could represent. 

Tests should follow the following format:
number of test cases n
number_1
number_2
...
number_n

Assumption: numbers are assumed to be within the range 2 to 9 

Note: 	The original Dictionary was in RTF format. 
		Please use convert to plain text format and saved as Words.txt .
		Please set the file path in Line 66 according to the location you save the file.
*/

public class FindWordsInTheDictionary {
	private HashMap <Character, ArrayList<Character>> numToChar; // map the number to the letters it is associated with
	private Set<String> dictionary;
	private String pressStream;	// input number stream
	private ArrayList<ArrayList<Character>> pressList;	// list of possible letters in a list of keyboard presses
	private ArrayList<String> permutationResults;
	private ArrayList<String> inDictionaryResults;
	
	void PreProcess() {
		numToChar = new HashMap <Character, ArrayList<Character>>();
		
		// keyboard layout
		numToChar.put('2', new ArrayList<Character>(Arrays.asList('a', 'b', 'c')));
		numToChar.put('3', new ArrayList<Character>(Arrays.asList('d', 'e', 'f')));
		numToChar.put('4', new ArrayList<Character>(Arrays.asList('g', 'h', 'i')));
		numToChar.put('5', new ArrayList<Character>(Arrays.asList('j', 'k', 'l')));
		numToChar.put('6', new ArrayList<Character>(Arrays.asList('m', 'n', 'o')));
		numToChar.put('7', new ArrayList<Character>(Arrays.asList('p', 'q', 'r', 's')));
		numToChar.put('8', new ArrayList<Character>(Arrays.asList('t', 'u', 'v')));
		numToChar.put('9', new ArrayList<Character>(Arrays.asList('w', 'x', 'y', 'z')));
	}
	
	// recursive function to compute the string permutations
	void StringPermutation(ArrayList<String> results, String current, int depth) {
		if(depth == pressList.size()) {
			results.add(current);
			return;
		} else {
			for(int i = 0; i < pressList.get(depth).size(); i++) {
				StringPermutation(results, (current + pressList.get(depth).get(i)), (depth+1));
			}
		}
	}
	

	void run() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// converted the RTF document into plain text file and saved as Words.txt
		String path = "Words.txt"; // change to the path where the file is stored
		Scanner scFile = new Scanner(new FileReader(path));
		
		// read in the dictionary
		dictionary = new HashSet<String>();
		while(scFile.hasNext()) {
			dictionary.add(scFile.next());
		}
		
		int numTestCases = sc.nextInt(); // number of test cases in the input
		sc.nextLine();
		
		while (numTestCases-- > 0) {
			PreProcess();

			pressStream = sc.nextLine(); // one test case per line and the input is assumed to be a string of numbers
			pressList = new ArrayList<ArrayList<Character>>();
			
			// put all possible letters together
			for (char ch : pressStream.toCharArray()) {
				pressList.add(numToChar.get(ch));
			}
			
			// compute the combinations
			permutationResults = new ArrayList<String>();
			StringPermutation(permutationResults, "", 0);
			
			inDictionaryResults = new ArrayList<String>();
			for(String str : permutationResults) {
				if(dictionary.contains(str))
					inDictionaryResults.add(str);
			}
			
			System.out.print("[\"");
			for(int i = 0; i < inDictionaryResults.size(); i++) {
				System.out.print(inDictionaryResults.get(i));
				if(i != (inDictionaryResults.size()-1))
					System.out.print("\", \"");
			}
			System.out.print("\"]");

			if (numTestCases > 0)
				System.out.println();
		}

		sc.close();
		scFile.close();
	}

	public static void main(String[] args) throws Exception {
		FindWordsInTheDictionary task4 = new FindWordsInTheDictionary();
		task4.run();
	}
}
