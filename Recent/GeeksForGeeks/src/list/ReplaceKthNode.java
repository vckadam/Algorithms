package list;

public class ReplaceKthNode {
	public Node replace(Node head, int k) {
		Node fakeHead = new Node(0);
		fakeHead.next = head;
		Node startPrev = fakeHead, endPrev = fakeHead;
		int i = 1;
		while(head != null) {
			if(i < k) {
				startPrev = startPrev.next;
			} else if(i > k) {
				endPrev = endPrev.next;
			}
			i++;
			head = head.next;
		}
		if(startPrev == endPrev)
			return fakeHead.next;
	}
}
