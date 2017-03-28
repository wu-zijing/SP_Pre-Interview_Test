import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
In task 3, given a number, 
return all possible letter combinations that the number could represent. 

Tests should follow the following format:
number of test cases n
number_1
number_2
...
number_n

Assumption: numbers are assumed to be within the range 2 to 9 
*/

public class GettingAllCombinations {
	private HashMap <Character, ArrayList<Character>> numToChar; // map the number to the letters it is associated with
	private String pressStream;	// input number stream
	private ArrayList<ArrayList<Character>> pressList;	// list of possible letters in a list of keyboard presses
	private ArrayList<String> permutationResults;
	
	void PreProcess() {
		numToChar = new HashMap <Character, ArrayList<Character>>();
		
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
			
			System.out.print("[\"");
			for(int i = 0; i < permutationResults.size(); i++) {
				System.out.print(permutationResults.get(i));
				if(i != (permutationResults.size()-1))
					System.out.print("\", \"");
			}
			System.out.print("\"]");

			if (numTestCases > 0)
				System.out.println();
		}

		sc.close();
	}

	public static void main(String[] args) throws Exception {
		GettingAllCombinations task3 = new GettingAllCombinations();
		task3.run();
	}

}
