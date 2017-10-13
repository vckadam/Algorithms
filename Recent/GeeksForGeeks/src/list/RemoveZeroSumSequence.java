package list;
/*
 * Given some resources in the form of linked list you have to canceled out all the resources whose sum up to 0(Zero) and return the remaining list. 

E.g-->> 6 -6 8 4 -12 9 8 -8 

the above example lists which gets canceled : 
6 -6 
8 4 -12 
8 -8 
o/p : 9 
case 3 : 4 6 -10 8 9 10 -19 10 -18 20 25 
O/P : 20 25
 */
public class RemoveZeroSumSequence {
	public Node getUpdatedList(Node head) {
		if(head == null)
			return head;
		Node fakeHead = new Node(0);
		fakeHead.next = head;
		int sum = 0;
		while(head != null) {
			Node prev = fakeHead;
			int tempSum = sum;
			while(prev != head) {
				tempSum -= prev.val;
				if(tempSum == -head.val) {
					prev.next = head.next;
					head = head.next;
					sum -= tempSum;
					break;
				}
				prev = prev.next;
			}
			if(head != null) {
				sum += head.val;
				head = head.next;
			}
		}
		return fakeHead.next;
	}
}
