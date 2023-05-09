import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException, InterruptedException {
		Trie trie = new Trie();
		int stringCount = 0;
		boolean cont = true;
		
		//String Count
		System.out.print("How many strings? ");
		stringCount = Integer.parseInt(input.readLine()); 
		
		System.out.println("\nEnter " + stringCount + " strings:");
		for(int i = 0; i < stringCount; i++) {
			trie.insert(input.readLine());
		}
		
		System.out.println("Standard trie created!");
		trie.display();
		
		while(true) {
			System.out.print("\nTry Again? ");	
			String choice = input.readLine();
		
			switch (choice) {
			case "Y":
				//Display Trie
				trie.display();
				break;
				
			case "N":
				//Exit
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

}
