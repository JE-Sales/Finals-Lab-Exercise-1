import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trie {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	TrieNode root = new TrieNode();

	public void insert(String data) {
		TrieNode trieNodePointer = root;
		TrieNode newTrieNode;
		int wordLength = data.length();

		for (int i = 0; i < wordLength; i++) {
			newTrieNode = new TrieNode();
			newTrieNode.setData(data.charAt(i));
			newTrieNode.setWord(i == wordLength - 1 ? true : false);

			ListNode tempListNode = trieNodePointer.getChildren().getHead();
			while (tempListNode != null) {
				if (tempListNode.getData().getData() == newTrieNode.getData()) {
					tempListNode.getData().setWord(i == wordLength - 1 ? true : false);
					break;
				}
				tempListNode = tempListNode.getNext();
			}
			if (tempListNode == null) {
				if (trieNodePointer.getChildren().getHead() == null) {
					trieNodePointer.getChildren().setHead(new ListNode(newTrieNode));
					trieNodePointer = trieNodePointer.getChildren().getTail().getData();
				} else {
					trieNodePointer.getChildren().getTail().setNext(new ListNode(newTrieNode));
					trieNodePointer.getChildren().setTail(trieNodePointer.getChildren().getTail().getNext());

					trieNodePointer = trieNodePointer.getChildren().getTail().getData();
				}
			} else {
				trieNodePointer = tempListNode.getData();
			}

		}

	}

	public void display() throws IOException {
		TrieNode trieNodePointer = root;
		ListNode tempListNode;
		char choice;
		String display = "";
		Boolean cont = true;


		while ((trieNodePointer.isWord() == false || trieNodePointer.getChildren().getHead() != null) && cont) {
			if (trieNodePointer.isWord() == true) {
				System.out.println("\"" + display + "\" is already a word.");
				cont = cont();
				if (!cont) {
					break;
				}
			}
			if (trieNodePointer.getChildren().getHead().getNext() == null) {
				trieNodePointer = trieNodePointer.getChildren().getHead().getData();
				display += trieNodePointer.getData() + " ";
				continue;
			}

			if (trieNodePointer == root) {
				System.out
						.print("\nSelect child from root node (" + trieNodePointer.getChildren().getContents() + "): ");
			} else {
				System.out.println("Display: " + display);
				System.out.print("Select child node from " + trieNodePointer.getData() + " ("
						+ trieNodePointer.getChildren().getContents() + "): ");
			}

			tempListNode = trieNodePointer.getChildren().getHead();

			choice = getInputChar();

			while (tempListNode != null) {
				if (choice == tempListNode.getData().getData()) {
					trieNodePointer = tempListNode.getData();
					break;
				}
				tempListNode = tempListNode.getNext();
			}

			if (tempListNode == null) {
				System.out.println("Wrong Input. Please choose from the characters in the close and open parenthesis.");
				continue;
			}

			display += trieNodePointer.getData() + " ";
		}

		System.out.println("Display: " + display);
	}

	public boolean cont() throws IOException {
		char decision;
		System.out.print("\nDo you wish to continue(Y/N)? ");
		decision = getInputChar();
		while (true) {
			switch (decision) {
			case 'Y':
				return true;
			case 'N':
				return false;
			default:
				System.out.println("Wrong input.");
			}
		}

	}
	
	public static char getInputChar() throws IOException {
		String str;
		while (true) {
			str = input.readLine();
			if(str.length() > 1) {
				System.out.println("Please enter single character only.");
				System.out.print("Enter choice: ");
			}else if(isParsable(str)) {
				System.out.println("Please enter a character from the alphabet only.");
				System.out.print("Enter choice: ");
			}else {
				break;
			}
		}
		return str.charAt(0);
	}
	
	public static boolean isParsable(String s) {
		try {
			Integer.parseInt(s);
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
