package ternarysearchtree;

public class TSTNode {
	char ch;
	TSTNode left, mid, right;
	boolean eof;
	public TSTNode(char ch) {
		this.ch = ch;
		this.left = this.mid = this.right = null;
		this.eof = false;
	}
}
