package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluatePostFix {
	
	public int getEvaluation(String str) {
		/* 
		 * 56+
		 * 3 + 2 + 3  - 3 2 + 3 +
		 * 4 + 3 * 2 + 5 - 4 3 2 * + 5 +
		 * 3 * 2 + 2 = 3 2 * 2 +
		 * 3 * 3 + 4 * 4 = 3 3 * 4 4 * +
		 * 
		 * */
		if(str == null || str.length() == 0)
			throw new IllegalArgumentException("Illegal Argument"+str);
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') 
				stack.push(Integer.valueOf(str.charAt(i)));
			else {
				int b = stack.pop();
				int a = stack.pop();
				stack.push(performOperaiton(a,b,str.charAt(i)));
			}	
		}
		return stack.pop();
	}
	
	public int performOperaiton(int a, int b, char ch) {
		if(ch == '+') return a + b;
		else if(ch == '-') return a - b;
		else if(ch == '*') return a * b;
		else if(ch == '/') return a / b;
		else if(ch == '%') return a % b;
		else 
			throw new IllegalArgumentException("Illegal Argument"+ch);
	}
}
