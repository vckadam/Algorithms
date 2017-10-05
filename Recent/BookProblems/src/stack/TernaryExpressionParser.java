package stack;

public class TernaryExpressionParser {
	public char evaluate(String str) {
		if(str == null || str.length() == 0)
			throw new IllegalArgumentException("Illegal Argument Exception");
		int i = str.length()-1;
		char second = str.charAt(i--), first = '\0';
		while(i >= 0) {
			char op = str.charAt(i--);
			if(op == ':') {
				first = str.charAt(i--);
			} else if(op == '?' && str.charAt(i--) == 'T') {
				second = first;
			}
		}
		return second;
	}
}
