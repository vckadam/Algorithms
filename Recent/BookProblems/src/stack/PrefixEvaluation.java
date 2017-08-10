package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrefixEvaluation {
	
	public int getResult(String str) {
		if(str == null)
			throw new IllegalArgumentException("Illegal Argument");
		if(str.length() == 0)
			return 0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for(int i = str.length()-1; i >= 0; i--) {
			char currCh;
			if((currCh = str.charAt(i)) >= '0' && currCh <= '9') 
				stack.push(currCh-'0');
			else if(isValidOp(currCh)){
				if(stack.size() < 2) 
					throw new IllegalArgumentException("Illegal Argument"); 
				stack.push(performOperation(stack.pop(), stack.pop(), currCh));
			}
			else 
				throw new IllegalArgumentException("Illegal Argument"); 
		}
		if(stack.size() != 1)
			throw new IllegalArgumentException("Illegal Argument"); 
		return stack.pop(); 
	}
	
	public boolean isValidOp(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
	
	public int performOperation(int num1, int num2, char op) {
		if(op == '+')
			return num1 + num2;
		else if(op == '-')
			return num1 - num2;
		else if(op == '*')
			return num1 * num2;
		else if(op == '/')
			return num1 / num2;
		else 
			throw new IllegalArgumentException("Illegal Argument"); 
	}
}
