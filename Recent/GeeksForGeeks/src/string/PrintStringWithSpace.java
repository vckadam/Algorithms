package string;

import java.util.ArrayList;
import java.util.List;

public class PrintStringWithSpace {
	public List<String> getAllCombo(String str) {
		if(str == null)
			return null;
		List<String> ret = new ArrayList<String>();
		helper(str,0,ret);
		return ret;
	}
	
	public void helper(String str, int start, List<String> ret) {
		if(start == str.length())
			return;
		ret.add(str);
		for(int i = start+1; i <= str.length(); i++) {
			helper(str.substring(0,i)+" "+str.substring(i), i+1, ret);
		}
	}
}
