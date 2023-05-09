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
		String display = "";

		while (trieNodePointer.isWord() == false) {// Bugged
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

			ListNode tempListNode = trieNodePointer.getChildren().getHead();

			char choice = input.readLine().charAt(0);

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

}
