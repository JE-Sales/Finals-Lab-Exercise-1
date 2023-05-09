import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, InterruptedException {
		Trie trie = new Trie();
		int stringCount = 0;

		while (true) {
			try {
				System.out.print("How many strings? ");
				stringCount = Integer.parseInt(input.readLine());
				break;
			} catch (Exception e) {
				System.out.println("Enter number only.");
			}
		}

		System.out.println("\nEnter " + stringCount + " strings:");
		for (int i = 0; i < stringCount; i++) {
			trie.insert(input.readLine());
		}

		System.out.println("Standard trie created!");
		trie.display();

		while (true) {
			System.out.print("\nTry Again(Y/N)? ");
			char choice = getInputChar();

			switch (choice) {
			case 'Y':
			case 'y':
				// Display Trie
				trie.display();
				break;

			case 'N':
			case 'n':
				// Exit
				System.out.print("\n--Exit--" + "\nProgram will be terminated");
				for (int i = 0; i < 3; i++) {
					Thread.sleep(1000);
					System.out.print(".");
				}
				System.out.print("\nProgram terminated.");
				System.exit(0);
				break;

			default:
				System.out.println("The only options are Y for Yes and N for No.");
				System.out.println("Please Try Again.");
			}
		}

	}

	public static char getInputChar() throws IOException {
		String str;
		while (true) {
			str = input.readLine();
			if (str.length() > 1) {
				System.out.println("Please enter single character only.");
				System.out.print("Enter choice: ");
			} else if (isParsable(str)) {
				System.out.println("Please enter a character from the alphabet only.");
				System.out.print("Enter choice: ");
			} else {
				break;
			}
		}
		return str.charAt(0);
	}

	public static boolean isParsable(String s) {
		try {
			Integer.parseInt(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
