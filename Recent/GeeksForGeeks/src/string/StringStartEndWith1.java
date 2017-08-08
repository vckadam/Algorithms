package string;

public class StringStartEndWith1 {
	public int getCountOfSubString(String str) {
		if(str == null) 
			throw new IllegalArgumentException();
		int ret = 0, oneCount = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				ret += oneCount;
				oneCount++;
			}
		}
		return ret;
	}
}
