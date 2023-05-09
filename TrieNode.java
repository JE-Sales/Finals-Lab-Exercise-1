
public class TrieNode {
	private char data;
	private boolean isWord = false;
	private List children = new List();
	
	
	TrieNode() {
	}
	
	TrieNode(char data, Boolean isWord) {
		this.data = data;
		this.isWord = isWord;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}
	
}
