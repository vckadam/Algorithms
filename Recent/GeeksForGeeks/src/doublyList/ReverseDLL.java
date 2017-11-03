package doublyList;

public class ReverseDLL {
	
	public Node createList(int[] array) {
		if(array == null || array.length == 0)
			return null;
		Node fakeHead = new Node(0);
		Node temp = fakeHead;
		for(int num : array) {
			temp.next = new Node(num);
			temp.next.prev = temp;
			temp = temp.next;
		}
		fakeHead.next.prev = null;
		return fakeHead.next;
	}
	
	public Node reverse(Node head) {
		if(head == null || head.next == null)
			return head;
		Node temp = null, next = null;
		while(head != null) {
			temp = head.next;
			head.next = next;
			if(next != null)
				next.prev = head;
			next = head;
			head = temp;
		}
		return next;
	}
}
