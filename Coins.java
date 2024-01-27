
package A2;

import java.util.Scanner;

public class Coins {

	private static int PrintCounter = 1;

	public static void insertIntoSeq(int coin, int[] seq, int[] coins) {
		// Increment our counter in the correct position
		for (int i = 0; i < coins.length; i++) {
			if (coin == coins[i]) {
				seq[i] += 1;
			}
		}
	}

	// Decrement our counter in the correct position
	public static void deleteFromSeq(int coin, int[] seq, int[] coins) {
		for (int i = 0; i < coins.length; i++) {
			if (coin == coins[i]) {
				seq[i] -= 1;
			}
		}
	}

	// Print our counter in the proper format
	public static void printSeq(int[] seq, String[] coinNames) {
		// Check to make sure that we have atleast one coin to print out
		boolean hasAtleastOneCoin = false;
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] > 0) {
				hasAtleastOneCoin = true;
			}
		}
		if (hasAtleastOneCoin == false) {
			return;
		}

		// Print out all coins
		System.out.print(PrintCounter + ") ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < seq.length; i++) {
			if (seq[i] > 0) {
				if (result.length() > 0) {
					result.append(", ");
				}
				if (seq[i] > 1) {
					result.append(seq[i] + " " + coinNames[i] + "s");
				} else {
					result.append(seq[i] + " " + coinNames[i]);
				}
			}
		}

		// increment counter
		PrintCounter++;

		System.out.println(result.toString());
	}

	public static void recurseWays(int money, int[] coins, String[] coinNames, int[] seq, int lastUsed) {
		// If we have no more money then return
		if (money < 0) {
			return;
		}

		// Base case: we used all our money, print our result to the screen
		if (money == 0) {
			printSeq(seq, coinNames);
			return;
		}

		// For each coin
		for (int i = 0; i < coins.length; i++) {
			// Make sure that we are using coins descending by value
			// Skip coins larger than last used coin
			if (coins[i] <= lastUsed) {
				// Insert to our counter this coin
				insertIntoSeq(coins[i], seq, coins);

				// Recursive call on our money minus this coin
				recurseWays(money - coins[i], coins, coinNames, seq, coins[i]);

				// Remove this coin from our counter for future iterations
				deleteFromSeq(coins[i], seq, coins);
			}
		}
	}

	public static void ways(int money) {
		// Set up our coin system
		int[] coins = { 25, 10, 5, 1 }; // coins have to be descending order
		String[] coinNames = new String[] { "quarter", "dime", "nickel", "penny" };
		/* as per requirements this program will work with all other currencies
		 * simply change amounts in the coins array and names in coinNames. 
		*/
		// Our array that will count our coins
		int[] seq = new int[coins.length];

		// Print out initial message
		System.out.println("This amount can be changed in the following ways:");

		// Call recursive method
		recurseWays(money, coins, coinNames, seq, Integer.MAX_VALUE);
	}

	public static void waysWithInput() {
		// Read input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an amount in cents:\n");
		int money = sc.nextInt();

		// Call our ways method
		ways(money);
	}

	public static void main(String[] args) {
		waysWithInput(); // testing with user input.
//		ways(12);  // testing different numbers. 
//		ways(20);
//		ways(43);
//		ways(0);
//		ways(-22);

	}

}
