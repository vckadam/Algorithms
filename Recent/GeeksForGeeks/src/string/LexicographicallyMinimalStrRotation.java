package string;

public class LexicographicallyMinimalStrRotation {
	
	public String getMinString(String str) {
		/* abc 
		 * abcabc
		 * 012345 
		 * 0-> 2 (str.length-1)
		 * 
		 *  
		 */
		
		if(str != null && str.length() > 0) {
			String temp = str + str;
			String minimal = str, curr = "";
			for(int i = 1; i < str.length(); i++) {
				if((curr = temp.substring(i,i+str.length())).compareTo(minimal) < 0) {
					minimal = curr;
				}
			}
			return minimal;
		}
		else return str;
	}
}
