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
		Node temp = head;
		int sum = 0;
		while(temp != null) {
			Node prev = fakeHead;
			int tempSum = sum;
			while(prev != temp) {
				if(tempSum == temp.val) {
					prev.next = temp.next;
					sum -= tempSum;
					break;
				}
				tempSum -= prev.val;
				prev = prev.next;
			}
			sum += temp.val;
			temp = temp.next;
		}
		return fakeHead.next;
	}
}
