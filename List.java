
public class List {
	private ListNode head;
	private ListNode tail;
	
	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
		tail = head;
	}

	public ListNode getTail() {
		return tail;
	}

	public void setTail(ListNode tail) {
		this.tail = tail;
	}

	public void insert(TrieNode newTriNode) {
		if(head == null) {
			head = new ListNode(newTriNode);
			tail = head;
			return;
		}else {
			tail.setNext(new ListNode(newTriNode));
			tail = tail.getNext();
			return;
		}
		
	}
	
	public String getContents() {
		String contents = "";
		
		ListNode temp = head;
		while(temp != null) {
			contents += temp.getData().getData() + (temp == tail ? "" : ", ");
			temp = temp.getNext();
		}
		
		return contents;
	}
}
