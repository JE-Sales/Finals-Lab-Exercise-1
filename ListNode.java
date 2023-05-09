
public class ListNode {
	private TrieNode data;
	private ListNode next;
	
	ListNode(TrieNode data) {
		this.data = data;
		next = null;
	}

	public TrieNode getData() {
		return data;
	}

	public void setData(TrieNode data) {
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
		
}
