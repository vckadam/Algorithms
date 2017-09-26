package list;

public class RearrangeList {
	public Node rearrange(Node head) {
		if(head == null || head.next == null)
			return head;
		Node fakeHead = new Node(0);
		fakeHead.next = head;
		Node prev = fakeHead;
		int i = 1;
		while(head != null && head.next != null) {
			if((i % 2 != 0 && head.val > head.next.val) ||
			(i % 2 == 0 && head.val < head.next.val))
				head = swap(prev, head, head.next);
			prev = head;
			head = head.next;
			i++;
		}
		return fakeHead.next;
	}
	
	public Node swap(Node prev, Node head, Node next) {
		prev.next = head.next;
		head.next = next.next;
		next.next = head;
		return next;
	}
}
