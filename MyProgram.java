////Errors;
  1. String - use length() instead of length in the for loop
  2. take care of the brakets specially when you write hm.containsKey(), there are 3 in the last
  3. In java, object type is implicitely pointers, so the object parameter
  can be used to change its data, but direct assignment is not allowed.
  4. In binary tree, make note that if we are going only in the one of the sub tree not both
  in that case use the iterative approach instead of reccursion... like binary tree closest element
  5.  for counting occurance in hashmap use only one statement
   hm.put(nums[i],(!hm.containsKey(nums[i])?1:hm.get(nums[i])+1)); /// remember to put +1 instead of ++
   Instead we can use this new syntex hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
  6. for looping over hashmap, remember to cast (Map.Entry)it.next();, (int)me.getValue();,(int)me.getKey();
  because it return object type
  just run the loop over keyset for(int key : hm.keySet()) 
   7. in quick sort kind of case when passing one fun to another function remember to pass a.length-1 not a.length
  8. to create a string from cha array is new String(array);
  9. remember to put increment and decrement in while
  10. to convert char to int put  charAt(i)-'0' to convert int to char  1 + (int)'0'
  11. to convert arraylist or hashset to array in one line 
  int[] result = al.stream().mapToInt(i->i).toArray();
  12. to convert array to list 
  ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(array))
  /// this will only work if the array is Integer[] not int[] take care of this.
  13. In hashset, if we are finding any element that is occured more than once.. than if we store result
  in arraylist, in case of 1,2,1,2,1... 1 will store twice so use another hashset to store the number.
  14. if we need to form a reverse string with word we do result = st.nextToken() + result. but this is 
  not optimul way.. good way is to use stringBuilder and for that method to add word at the start is
  sb.insert(0,"string"); this will add word at the begining and move other ahead;
  15. same with arraylist add method with index and value parameters
  16. remember to write break in the case of switch 

// Find Maximum size of substring, in which no duplicate characters:

static String findMax2(String s) {
		HashMap<Character, Character> mainMap = new HashMap<Character, Character>();
		HashMap<Character, Character> currentMap = new HashMap<Character, Character>();
		String result="";
		for ( int i = 0; i < s.length(); i++ ) {
			if(!currentMap.containsKey(s.charAt(i))) {
				currentMap.put(s.charAt(i), s.charAt(i));
			}
			else {
				if(currentMap.size() > mainMap.size()) {
					mainMap = (HashMap<Character, Character>) currentMap.clone();
				}
				currentMap.clear();
				currentMap.put(s.charAt(i), s.charAt(i));
			}
		}
		Iterator i = mainMap.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			result+=(Character)me.getKey();
		}
		return result;
	}
// input : "Mr John Smith    " , 13
// output : "Mr%20John%20Smith"
static String modifyString(String s, int len) {
		char[] charString = s.toCharArray();
		for( int i = len-1, j = charString.length-1; i > 0; ) {
			if(charString[i] != ' ') {
				charString[j] = charString[i];
				i--;
				j--;
			}
			else {
				charString[j--] = '0';
				charString[j--] = '2';
				charString[j--] = '%';
				i--;
			}
		}
		return new String(charString);
	}
	// when we are creating string from the character array we need to create string from that char array.
	// we can create char array from string from toCharArray() 
	// In case of string, best way is to start from the last because we have extra buffer there.
	//
	
	// compress string aabbaaabb to a2b2a3b2
	//
	
	static String compressString(String s) {
		char[] toCompressArray = s.toCharArray();
		StringBuffer compressString = new StringBuffer();
		char current = toCompressArray[0];
		int count = 0;
		for(int i = 0; i < toCompressArray.length; i++) {
			if(toCompressArray[i] == current) {
				count++;
			}
			else {
				compressString.append(current);
				compressString.append(count);
				current = toCompressArray[i];
				count = 1;
			}
		}
		compressString.append(current);
		compressString.append(count);
		return compressString.toString();
	}
//////////////////////////////////////////////////////////////////////////////////////////////
179. Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

////////////// optimized solution

public String largestNumber(int[] nums) {
        if(nums.length == 0) return "";
        String[] snums = new String[nums.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) snums[i] = String.valueOf(nums[i]);
        Arrays.sort(snums,new Comparator<String>() {
            public int compare(String p, String q) {
                String s1 = p + q;
                String s2 = q + p;
                return s2.compareTo(s1);
            }});
        if(snums[0].charAt(0) == '0') return "0";
        for(int i = 0; i < snums.length; i++) sb.append(snums[i]);
        return sb.toString();
    }
/////////////////// another

 public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        if (strs[strs.length-1].charAt(0) == '0') return "0";
        String res = new String();
        for (int i = 0; i < strs.length; i++) {
            res = strs[i]+res;
        }
        return res;
    
    }
}
	// string concate nation runs in O(n2 ) time. So the better way to use string buffer and string builder
	// even better. we just need to append() funciton and it's easy.
	// When we want to print int and string array using same function, we just define the parameter as Object[] 
	// because we are passing Interger and String class parameter so it will work and then we just use for
	// like this for(Object o:array) { print obj}. It will print desired result.
	
	// custom comparator 
	class Checker{
    public Comparator<Player> desc = new  Comparator<Player>() {
        public int compare(Player p1, Player p2) {
            if(p1.score != p2.score) {
                return (int)(p2.score - p1.score);
            }
            else {
                return (p2.name).compareTo(p1.name);
            }
        }
    };
}
// here we have defined custome comparator, in which we have to sort the array of objects of the player class
// so it is defined by Arrays.sort(Players, check.desc) check.desc is comparator.
// here we defined a new comparator which is defined above
// we just to override the compare method which return int. for int we just use - operator
// for string we use compare to 
// for ascending we use p1 first
// for descending we use p2 first
//input
//5
//amy 100
//david 100
//heraldo 50
//aakansha 75
//aleksa 150
// out put for this 
//aleksa 150
//david 100
//amy 100
//aakansha 75
//heraldo 50
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Checker{
    public Comparator<Player> desc = new  Comparator<Player>() {
        public int compare(Player p1, Player p2) {
            if(p1.score != p2.score) {
                return (int)(p2.score - p1.score);
            }
            else {
                return (p2.name).compareTo(p1.name);
            }
        }
    };
}

class Player {
	String name;
	int score;
}
public class StringInput {
	public static void main(String[] str) throws NumberFormatException, IOException {
		System.out.println("Please enter string");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		Checker check = new Checker();
		Player[] player = new Player[n];
		for(int i = 0; i < n ; i++) {
			player[i] = new Player();
			String s = br.readLine().trim();
			st = new StringTokenizer(s);
			player[i].name = st.nextToken();
			player[i].score = Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(player, check.desc);
		for(int i = 0; i < player.length; i++ )  {
			System.out.printf("%s %s", player[i].name,player[i].score);
			System.out.println();
		}
	}
// if the call of the function is like this checkPrime(5,6,7,8,9); 
// then we have to write defination of function like this public void checkPrime(int... numbers)

/// to print prime number 
import static java.lang.System.in;
class Prime {
    public static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i < n/2+1; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void checkPrime(int... numbers) {
        for(int n: numbers) {
            if(isPrime(n)) {
                System.out.print(n+" ");
            }
        }
        System.out.println();
    }
}


pascal triangle with the help of reccursion
static List<Integer> pascal(int n){
		if(n == 2 ) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(1);
			l.add(1);
			return l;	
			
		}
		List<Integer> l1 = pascal(n-1);
		
		List<Integer> l3 = new ArrayList<Integer>();
		for(int i = 0; i <= l1.size(); i++) {
			if(i == 0 ) {
				l3.add(1);
			}
			else if(i == l1.size()) {
				l3.add(1);
			}
			else {
				l3.add(l1.get(i) + l1.get(i-1));
			}
			
			
		}
		return l3;
	}
	
	////////////////////// iterative pascal triagle
	
	Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> al = new ArrayList<Integer>();
        if(numRows == 0) return result;
        al.add(1);
        result.add(al);
        if(numRows == 1) {
            return result;
        }
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1); prev.add(1);
        result.add(prev);
        if(numRows == 2) {
            return result;
        }
        List<Integer> current = new ArrayList<Integer>();
        for(int i = 3; i<=numRows; i++) {
            current.add(1);
            for(int j = 1; j <= i-2; j++) {
                current.add(prev.get(j)+prev.get(j-1));
            }
            current.add(1);
            result.add(current);
            prev = current;
            current = new ArrayList<Integer>();
        }
        return result;
        
    }
////////////////////////////////////////////////////////////////////////////
	//1->2->3->4->5->null
    //1->3->5->2->4->null
	
	public void reorder(SinglyLinkedListNode head) {
		SinglyLinkedListNode last = head, x = head, temp = null;
		int leng = 1;
		while(last.getNext()!= null) {
			leng++;
			last = last.getNext(); /// find the length and also reach at last position.
		}
		for(int i = 1; i <= (int)Math.ceil(leng/2); i++) {
			temp = x.getNext();   // store 2 in temp
			x.setNext(x.getNext().getNext()); // 1->3			
			x = x.getNext();  // x = 3
			last.setNext(temp);  // 5 -> 2
			temp.setNext(null);  // 2 -> null
			last = last.getNext(); // last = 2
		}
	}
	all the odd positon at the begining and all the even position at the end.
	
	/// NO loop or reccursion - Find that number is power of Three.
	
	static boolean isPowerOfThree(int n) {
		double x = Math.log10(n) / Math.log10(3); // just divide log of number with log of 3
		if(x == (int)x ) {						// if the result is interger then its true
			return true;						/// else it is false
		}
		else {
			return false;
		}
	}
	
	// array [1,2,5] and amount = 11 how many minimum number of coins needed to form amount
	public static int coinChange(int[] coins, int amount) {
	        Arrays.sort(coins); // sort arraay
	        int a = 0, b, x = -1;
	        for(int i = coins.length-1; i >= 0; i--) { // max amount first so reverse loop
	            if(amount%coins[i] == 0) { // if amount is divisible by 0 just return it.
	                a = a + (amount/coins[i]); // 
	                return a;	                    
	                
	            }
	            else {
	                b = (int)amount / coins[i];  /// if not divisible by that amount.
	                a = a + b;
	                amount = amount - (b*coins[i]);
	                if (i == 0 ) {
	                    x = -1;
	                }
	            }
	            
	        }
	        return x;
	    
	}

	// Merge sort
	// so here we have two array and if we are given only one array as the input parameter in the 
	// function in that case what to do is only call other function with whatever argument you want
	// this will simply solve the problem.
	public static void MergeSort(int[]a , int[] b, int start, int end) {
			int mid;
			if(end > sta
			rt) {
				mid = (start + end) / 2;
				MergeSort(a, b, start, mid);
				MergeSort(a, b, mid+1, end);
				Merge(a, b, start, mid+1, end);
			}
		}
		public static void Merge(int[] a , int[] b, int left, int mid, int right) {
			int i = left;
			int size = right-left +1;
			int left_end = mid-1;
			while(left<=left_end && mid <= right) {
				if(a[left] <= a[mid]) {
					b[i] = a[left];
					left++;
					i++;
				}
				else {
					b[i] = a[mid];
					mid++;
					i++;
				}
			}
			while(mid <= right) {
				b[i] = a[mid];
				i++;
				mid++;
			}
			while(left <= left_end) {
				b[i] = a[left];
				i++;
				left++;
			}
			for(int j = 0; j < size; j++) {
				a[right] = b[right];
				right--;
			}
		}
		
		/// insertion sort 
		*******************************
		public static void insertion(int[] a) {
		int n = a.length, j, key;
		for(int i = 1; i<n; i++) {
			key = a[i];
			j = i-1;
			while(j>=0 && a[j] > key) {
				a[j+1] = a[j];
				j= j-1;
			}
			a[j+1] = key; 
		}
	}
	*******************************
	/// quick sort
	public static void quickSort(int[] a, int start, int end) {
		int pivot;
		if(end > start) {
			pivot = findPivot(a, start, end);
			quickSort(a, start, pivot-1);
			quickSort(a, pivot+1,end);
		}
	}
	public static int findPivot(int[] a,int left,int right) {
		int temp = a[left], low = left, high = right;
		while(left < right) { 
			while(a[left] <= temp) {
				left++;
			}
			while(a[right] > temp) {
				right--;
			}
			if(left < right) {
				int temp1 = left;
				left = right;
				right = temp1;
			}
		}
		a[low] = a[right];
		a[right] = temp;
		return right;
	}
	****************************************
	//shellsort
	public static void shellSort(int[] a ) {
		int i, j, key, h = 1, len = a.length;
		while(h < len) {
			h = h*3+1;
		}
		while(h > 0) {
			for(i = h+1; i < len; i++) {
				key = a[i];
				j = i;
				while(j > h && a[j-h] > key) {
					a[j] = a[j-h];
					j -=h;
				}
				a[j] = key;
			}
			h = (h-1)/3;
		}
	}
	***************************************
	4 2 3 we know that all elements are less than or equal to 4
	so we create arrray of 5 element from 0 to 4
	and that array 0 0 1 1 1
	0 0 1 2 3
	2 3 4
	
	counting sort
	
	public static void countingSort(int[] a, int[] b, int k) {
		int[] c = new int[k+1];
		int n = a.length;
		for(int i = 0; i < k; i++) {
			c[i] = 0;
		}	
		for(int i = 0; i <  n; i++){
			c[a[i]] = c[a[i]] + 1;			
		}
		for(int i = 1; i < k; i++) {
			c[i] = c[i] + c[i-1];
		}
		for(int i = n-1; i >= 0; i--) {
			b[c[a[i]]-1] = a[i];
			c[a[i]] = c[a[i]]-1;
		}
	}
	
	/// bucket sort
	
	static int size = 10;
	public static void bucketSort(int[] a) {
		int n = a.length;
		int[] b = new int[size];
		for(int i = 0; i < n; i++) {
			b[a[i]]++;
		}
		for(int i = 0, m = 0; i < size; i++) {
			for(int k = b[i]; k > 0; k--) {
				a[m++] = i;
			}
		}
	}
	/// Heap sort
	
	import java.util.*;
public class HeapSortMain {
	public static void HeapSort(int[] array)  {
		Integer[] heap = new Integer[array.length];
		Integer counter = array.length-1;
		
		for(int i = 0; i < array.length; i++) {
			heap[i] = array[i];
		}
		for(int i = (array.length-2)/2; i>=0; i--) {
			reArrange(i, heap);
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i] = deleteMin(heap,counter);
			counter--;
			System.out.print(array[i]+" ");
		}
		
	}
	public static Integer deleteMin(Integer[] heap, int counter) {
		Integer min = heap[0];
		heap[0] = heap[counter];
		heap[counter] = null;
		reArrange(0, heap);
		return min;
	}
	public static void reArrange(int i, Integer[] heap) {
		Integer left = getLeftChildIndex(i, heap.length), right = getRightChildIndex(i, heap.length), min = i, temp;
		if(left != null && heap[left] != null){
			 if(heap[left] < heap[i]){
				 	min = left;
			 }
		}
		else {
			min = i;
		}
		if(right != null && heap[right] != null) {
			if(heap[right] < heap[min]) {
				min = right;
			}
		}
		if(min != i) {
			temp = heap[min];
			heap[min] = heap[i];
			heap[i] = temp;
			reArrange(min, heap);
		}
		
	}
	public static Integer getLeftChildIndex(int i, int length) {
		if(i*2+1 > length-1) {
			return null;
		}
		return i*2+1;
	}
	public static Integer getRightChildIndex(int i, int length) {
		if(i*2+2 > length-1) {
			return null;
		}
		return i*2+2;
	}
	public static void main(String[] args) {
		int[] array = {3, 2, 5, 4, 1};
		HeapSort(array);

	}

}
//// convert array of 0's 1's and 2's in the ascending order
input
int[] rearrange = {0,0,2,2,2,1,2,1,0,2,1,0,2,1};
output 
0 0 0 0 1 1 1 1 2 2 2 2 2 2 
public static void arrangeZero(int[] array ) {
		int val = 0;
		int left = 0, right = array.length -1 ,temp;
		while(left < right) {
			while(array[left] == val && left < right){
				left++;
			}
			while(array[right] != val && left < right)  {
				right--;
			}
			if(left < right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
			if(left == right && val == 0) {
				val = 1;
				right = array.length-1;
			}
			
		}
		
		
public static int[] changeThem(int[] array) {
		int left = 0, right = array.length-1, temp;
		while(left < right) {
			while(array[left] == 0 && left < right) {
				left++;
			}
			while(array[right] != 0 && left < right) {
				right--;
			}
			if( left < right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				i++; j--;
			}
		}
		right = array.length-1;
		while(left < right) {
			while(array[left] == 1 && left < right) {
				left++;
			}
			while(array[right] != 1 && left < right) {
				right--;
			}
			if(left < right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				i++; j--;
			}
		}
		return array;
	}
	/// find min and max using divide and counquer 
	
	public static int[] findMinMaxDivideAndConqur(int[] array, int left, int right) {
		int[] finalArray = new int[2];
		finalArray[0] = findMin(array, left, right);
		finalArray[1] = findMax(array, left,right);
		return finalArray;
		
	}
	public static int findMin(int[] array, int left, int right) {
		int mid = left + (right-left) / 2, min1, min2;
		
		if(left == right) {
			return array[left];
		}
		if(left+1 == right) {
			return (array[left]>array[right])?array[right]:array[left];
		}
		min1 = findMin(array, left, mid);
		min2 = findMin(array,mid+1, right);
		return (min1>min2)?min2:min1;
	}
	public static int findMax(int[] array, int left, int right) {
		int mid = left + (right-left) / 2, min1, min2;
		
		if(left == right) {
			return array[left];
		}
		if(left+1 == right) {
			return (array[left]<array[right])?array[right]:array[left];
		}
		min1 = findMax(array, left, mid);
		min2 = findMax(array,mid+1, right);
		return (min1<min2)?min2:min1;
	}
	// find the maximum sum of contiguous sub sequece;
	public static int maxSeqSum(int[] array, int left, int right) {
		int mid = left + (right - left) / 2, leftMax, rightMax;
		if(left == right) {
			if(array[left] > 0 ) {
				return array[left];
			}
			else {
				return 0;
			}
		}
		leftMax = maxSeqSum(array, left, mid);
		rightMax = maxSeqSum(array, mid+1, right);
		int i = mid, currentLeftSum = 0, currentRightSum = 0, maxleftcrosssum = 0, maxrightcrosssum = 0;
		while(i >= 0) {
			currentLeftSum += array[i];
		
			if(currentLeftSum > maxleftcrosssum) {
				maxleftcrosssum = currentLeftSum;
			}
			i--;
		}
		i = mid+1;
		while(i <= right) {
			currentRightSum += array[i];
			if(currentRightSum > maxrightcrosssum) {
				maxrightcrosssum = currentRightSum;
			}
			i++;
		}
		return Math.max(Math.max(leftMax, rightMax),Math.max(maxleftcrosssum+maxrightcrosssum, 0));
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////
125. Valid Palindrome

 Given a string, determine if it is a palindrome, considering only alphanumeric characters 
 and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome. 

public boolean isPalindrome(String s) {
        if(s.length() == 0|| s.length() == 1) return true;
        int left = 0, right = s.length()-1;
        s = s.toLowerCase();
        while(left <= right) {
            while(left <= right && (s.charAt(left)-'a' < 0 || s.charAt(left)-'a' > 25) && (s.charAt(left)-'0' < 0 || s.charAt(left)-'0' > 9)) left++;
            while(left <= right && (s.charAt(right)-'a' < 0 || s.charAt(right)-'a' > 25) && (s.charAt(right)-'0' < 0 || s.charAt(right)-'0' > 9)) right--;
            if(left <= right && s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
	/// If there are extra space and the special symbol we need to negalate in the string and we need
	 to check that is that string is pelindrome or not in theat case we can use following algorithm.
	 public static boolean isPalindrome(String s) {
	        s = s.toLowerCase();
	        char[] c = s.toCharArray();
	        
	        int i = 0, j = c.length-1, temp1, temp2;
	        while(i < j) {
	            temp1 =(int)c[i];
	            temp2 = (int)c[j];
	            while(temp1 < 97 || temp1 > 122) {
	                i++;
	                temp1 = (int)c[i];
	            }
	            while(temp2 < 97 || temp2 > 122) {
	                j--;
	                temp2 = (int)c[j];
	            }
	            if(temp1 != temp2) {
	                return false;
	                
	            }
	            i++;
	            j--;
	            
	        }
	        return true;
	    }
		////
		//// if input is given as a1, a2, a3, a4, b1, b2,b3, b4 then we have to arrange it 
		//// as follow a1, b1, a2, b2, a3, b3, a4, b4 
		/// what is the catch in it.
		/// if the we solve it above sequence it will work because number of pairs are even.
		/// but what when the number of pairs are odd. for that we need to write new code.
		
		public static void makearrange(int[] array, int left, int right) {
		 int len = (right-left)+1,  mid2, temp;
		 int mid = left + (right - left) / 2, i = mid, j = mid+1;
		 /* 
		 if(left == mid) {
			 return;
		 }
		 */
		 len = len/2;
		 if(len % 2 != 0 ) {
			 temp = array[mid];
			 while(i < right-1) {
				 array[i] = array[i+1];
				 i++;
			 }
			 array[i] = temp;
			 makearrange(array, left, right-2);
		 }
		 else {
			 mid2 = left + (mid - left) / 2;
			 i = mid2+1; j = mid+1;
			 while(i <= mid) {
				 temp  = array[i];
				 array[i] = array[j];
				 array[j] = temp;
				 i++;
				 j++;
			 }
			 if(left == mid) {
				 return;
			 }
			 makearrange(array, left, mid);
			 makearrange(array, mid+1, right);
			 
		 }
		 
		 
	 }
	 ///// very import/// kth smallest element using median of median
	 /// using sorting we can solve this problem in O(nlogn), but using this method we can
	 // solve this problem in O(n) time...
	 public static int kthsmallestelement(int[] array,int left, int right, int k) {
		if(k >= left && k <= array.length) {
			int mom = medianofmedian(Arrays.copyOfRange(array,left, right+1), right-left+1);
			int pivot = partition(array, left, right, mom);
			if(pivot == k - 1) {
				return array[pivot];
			}
			if(k-1 > pivot) {
				
				return kthsmallestelement(array,pivot+1, right, k);
			}
			else {
				
				return kthsmallestelement(array,left, pivot-1, k);	
			}
		}
		else {
			return -1;
		}
	}
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	public static int partition(int[] array, int left, int right, int mom) {
		for(int i = left; i <= right; i++) {
			if(array[i] == mom) {
				array[i] = array[right];
				array[right] = mom;
				break;
			}
		}
		int temp = array[0], p = left;
		for(int j = left; j <= right; j++) {
			if(array[j] < array[right]) {
				swap(array, p, j);
				p++;
			}
		}
		swap(array,p, right);
		return p;
		
		
	}
	public static int findMedian(int[] array) {
		if(array.length == 0 ) {
			return 0;
		}
		Arrays.sort(array);
		if(array.length == 1 || array.length == 2) {
			return array[0];
		}		
		return array[array.length/2];
	}
	 public static int medianofmedian(int[] array, int len) {
		 int z;
		 if(len%5 == 0) {
			z = 0;
		 }
		 else {
			 z = 1;
		 }
		 int[] median = new int[len/5+z];
		 int j = 0, i = 0;
		 if(len >= 5){
		 for(i = 0; i < len/5; i++) {
			 median[i] = findMedian(Arrays.copyOfRange(array, j, j+5));
			 j+=5;
		 } }
		 if( j < len) {
			 median[i] = findMedian(Arrays.copyOfRange(array,j,len));
		 }
		 //System.out.println(median[0] + " " + median[1]);
		 
		 return findMedian(median);
	 }
	 
	 //// find median of two sorted list 
	 public static int medianOftwo(int[] array1,int aleft, int aright, int[] array2, int bleft, int bright) {
		int med1 = aleft + (aright-aleft)/2;
		int med2 = bleft + (bright-bleft)/2;
		if(array1[med1] == array2[med2]) {
			return array1[med1];
		}
		else if(med1 != med2 && aleft == aright && bleft == bright) {
			return (array1[med1]<array2[med2])?array1[med1]:array2[med2];
		}
		else if(array1[med1] < array2[med2]) {
			return medianOftwo(array1, med1+1, aright, array2, bleft, med2);
		}
		else {
			return medianOftwo(array1, aleft, med1, array2, med2+1, bright);
		}
	}
	
	
	// tree searlize and deseralize
	deseralize - make array
	seralize - crate tree
	public Integer[] deseralize(Node root)  {
		
		int level = countLevel(root), i;
		int size1 = (int)Math.pow(2,(level+1)) - 1;
		//System.out.println(level);
		Integer[] array = new Integer[size1];
		Queue<Node> q1 = new LinkedList<Node>();
		if( root == null) {
			return null;
		}
		else {
			i = 0;
			q1.add(root);
			array[i] = root.getData();
			
			while(!q1.isEmpty()) {
				Node temp = q1.remove();
				while(array[i] == null) {
					i++;
				}				
				if(temp.getLeftNode() != null) {
					q1.add(temp.getLeftNode());
					array[i*2+1] = temp.getLeftNode().getData();					
				}
				else {
					array[i*2+1] = null;
				}
				if(temp.getRightNode() != null) {
					q1.add(temp.getRightNode());
					array[i*2+2] = temp.getRightNode().getData();
					
				}
				else {
					array[i*2+2] = null;
				}
				i++;
			}
			
		}
		return array;
	}
	public int countLevel(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.getLeftNode() == null && root.getRightNode() == null) {
			return 1;
		}
		int left = countLevel(root.getLeftNode());
		int right = countLevel(root.getRightNode());
		return (left > right)?left+1:right+1;
	}
	///////////////////////////////////
	public Tree seralize(Integer[] deser) {
		int i = 1;
		Tree t2 = new Tree();
		t2.insert(deser[0]); 
		t2.root.setLeftNode(new Node(deser[1]));
		t2.root.setRightNode(new Node(deser[2]));
		
		while(i*2+1 < deser.length-1) {
			if(deser[i] != null) {
				t2.root = find(t2.root, deser[i], deser[i*2+1], deser[i*2+2]);
			}
			i++;
		}
		return t2;
	}
	public Node find(Node root, Integer node, Integer left, Integer right) {
		
		if(root.getData() == node){
			
			if(root.getRightNode() == null) {
				if( right != null) {
					root.setRightNode(new Node(right));
					//return root;
				}
				else {
					root.setRightNode(null);
					//return root;
				}
			}
			if(root.getLeftNode() == null) {
				if( left != null) {
					root.setLeftNode(new Node(left));
				}
				else {
					root.setLeftNode(null);
				}
			}
			/*
			if(root.getRightNode() != null) {
				find(root.getRightNode(), node, left, right);
				//return;
			}*/
			return root;
		}
		if(node < root.getData()) {
			find(root.getLeftNode(), node, left, right);
		}
		else {
			find(root.getRightNode(), node, left, right);
		}
		return root;
	}
	/// zigzag tree
	////////////// optimized 
	
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> future = new Stack<TreeNode>();
        List<Integer> al = new ArrayList<Integer>();
        int i = 0;
        current.push(root);
        while(!current.isEmpty()) {
            TreeNode temp = current.pop();
            al.add(temp.val);
            if(i % 2 == 0) {
                if(temp.left != null) future.push(temp.left);
                if(temp.right != null) future.push(temp.right);
            }
            else {
                if(temp.right != null) future.push(temp.right);
                if(temp.left != null) future.push(temp.left);
            }
            if(current.isEmpty()) {
                result.add(al);
                al = new ArrayList<Integer>();
                current = future;
                future = new Stack<TreeNode>();
                i++;
            }
        }
        return result;
    }
    ////////////// another 
	public void zigzag(Node root) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		int i = 1;
		if(root == null) {
			return;
		}
		else {
			stack1.push(root);
			while(!stack1.isEmpty()){
				Node temp = stack1.pop();
				System.out.print(temp.getData()+"->");
				if(i % 2 != 0) {
					if(temp.getLeftNode() != null) {
						stack2.push(temp.getLeftNode());
					}
					if(temp.getRightNode() != null) {
						stack2.push(temp.getRightNode());
					}
				}
				else {
					if(temp.getRightNode() != null) {
						stack2.push(temp.getRightNode());
					}
					if(temp.getLeftNode() != null) {
						stack2.push(temp.getLeftNode());
					}
				}
				if(stack1.isEmpty()) {
					stack1 = (Stack<Node>) stack2.clone();
					stack2.clear();
					i++;
				}
				
				
			}
			
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]


 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> finallist = new ArrayList<List<Integer>>();
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> future = new Stack<>();
        List<Integer> al = new ArrayList<Integer>();
        TreeNode temp;
        int i = 0;
        current.push(root);
        while(!current.isEmpty()) {
            temp = current.pop();
            al.add(temp.val);
            if(i == 0) {
                if(temp.left != null) {
                    future.push(temp.left);
                }
                if(temp.right != null) {
                    future.push(temp.right);
                }
            }
            else if(i == 1) {
                if(temp.right != null) {
                    future.push(temp.right);
                }
                if(temp.left != null) {
                    future.push(temp.left);
                }
            }
            if(current.isEmpty()) {
                i = (i == 0)?1:0;
                current = (Stack<TreeNode>)future.clone();
                future.clear();
                finallist.add(new ArrayList<Integer>(al));
                al.clear();
                
            }
        }
        return finallist;
    }
	/// Dynamic programming
	// count the minimum number of coins
	//  inputs 
	// int[] coinValues = {7,2,3,6};
	//	int number = 13;
	//  countCoins(number, coinValues);
	
	public static void countCoins(int num, int[] array) {
		/*
		 * num : 3, array : 1 ,5 ,10
		 * ay1 : 0 , 1 , 2 , 3
		 * track: inf, 0, 1, 2
		 * 
		 */
		int[] ay1 = new int[num+1];
		int[] track = new int[num+1];
		for(int i = 0; i < ay1.length; i++) {
			ay1[i] = Integer.MAX_VALUE -1;
			track[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < array.length && array[i] <= num; i++) { // 7
			ay1[0] = 0;
			//int j = array[i];
			for(int j = array[i]; j <= num; j++) { // j = 7 run till 13
				if(ay1[j - array[i]] + 1 < ay1[j]) { // 
					ay1[j] = ay1[j - array[i]] + 1;
					track[j] = i;
				}
			}
		
		}
		
		//for(int i = 0; i < ay1.length; i++) {
		    //System.out.print(ay1[i]+" ");
		//}
		//for(int i = 0; i < ay1.length; i++) {
			//System.out.print(track[i]+" ");
		//}
		int i = ay1[ay1.length-1];
		int j = num;
		ArrayList<Integer> al = new ArrayList<Integer>();
		while( i > 0) {
			al.add(array[track[j]]);
			i--;
			j = j - array[track[j]];
		}
		while(!al.isEmpty()) {
			System.out.print(al.remove(0)+" ");
		}
	}
	
	///  minimum number of jump
	//    inputs 
	//    int[] array1 = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
	//    System.out.println(minJump(array1));
	public static int minJump(int[] array) {
		/*
		 *   2, 3, 1, 1, 2, 4, 2, 0, 1, 1
		 *   0  1  2  3  4  5  6  7  8  9
		 *   0  1  1
		 *   i : 1 to length-1
		 *   j : 0 to i-1
		 *   mJump : array length
		 *   track : array length
		 */
		Stack<Integer> s = new Stack<Integer>();
		int[] mJump = new int[array.length];
		int[] track = new int[array.length];
		mJump[0] = 0;
		for(int i = 1; i < array.length; i++) {
			mJump[i] = Integer.MAX_VALUE;
		}
		for( int i = 1; i < array.length; i++)  {
			for(int j = 0; j < i; j++) {
				if(i <= j + array[j] && mJump[j] + 1 <= mJump[i]) {
					mJump[i] = mJump[j] + 1;
					track[i] = j;
				}
			}
		}
		int i = track.length-1;
		while(i > 0) {
			s.push(i);
			i = track[i];
		}
		s.push(0);
		while(!s.isEmpty()) {
			System.out.print(s.pop()+"->");
		}
		System.out.println();
		return mJump[mJump.length-1];
		
	}
	
//// Longest increasing subsequence
//
public static int longestIncreasingSubsequence(int[] array) {
		/*  array: 3 4 -1 0 6 2 3
		 *  lis   : 1 2  1 2 3 3 4 
		 *  track : -1 0 -1 2 3 3 5        
		 */
		Stack<Integer> s = new Stack<Integer>();
		int[] lis = new int[array.length];
		int[] track = new int[array.length];
		int max = 0, maxIndex = 0, f = 0;
		lis[0] = 1;
		track[0] = -1;
		
		for(int i = 1; i < array.length; i++) {
			lis[i] = Integer.MIN_VALUE;
			track[i] = -1;
		}
		for(int i = 1; i < array.length; i++) {
			f = 0;
			for(int j = 0; j < i; j++) {
				if(array[j] < array[i] && lis[j]+1 > lis[i]) {
					//max = lis[j] + 1;
					lis[i] = lis[j] + 1;
					track[i] = j;	
					f = 1;
				}
			}
			if(f == 0) {
				lis[i] = 1;
			}
		}
		for(int i = 0; i < array.length; i++) {
			if(lis[i] > max) {
				max = lis[i];
				maxIndex = i;
			}
		}
		while(maxIndex != -1) {
			s.push(array[maxIndex]); // 3 
			maxIndex = track[maxIndex]; // 5
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		return max;
		
		
	}					 0 1 2 3 4 5 6
	/*					 A B C B D A B
					   0 0 0 0 0 0 0 0 
					B  0 					
					D  0
					C  0
					A  0
					B  0
					A  0
	*/
	public static void main(String[] str) {
		int i = 0;
		int k = 4;
		int m = 34;
	int rootTotheNode(Node root) {
		if(root == null) {
			return root;
		}
		int left = rootTotheNode(root.getLeftNode());
	}
	}
	/// if an array is rotate then how to find element in that array // bitonic
	public int search(int[] nums, int target) {
        
        int left = 0, right = nums.length-1, mid;
        while(left <= right) {
           mid = left + (right - left)/2;
           if(nums[mid] == target) {
               return mid;
           }
           if(nums[left] <= nums[mid]) {
               if(nums[left] <= target && target <= nums[mid]) {
                   right = mid -1;
               }
               else {
                   left = left + 1;
               }
           }
           else {
               if(nums[mid] <= target && target <= nums[right]) {
                   left = left + 1;
               }
               else {
                   right = right - 1;
               }
           }
        } 
        return -1;
}


// rotate an array by k point to right /// 
// go to right hand side and think about the k element from the last // make them an group and make other group of remainings
// for the left start from the left and select first k element and form a group // and make group of remainings 
//now rotate first group /// rotate second group
// rotate the entire array // time complexity is O(n) and space complexity is O(1)

public static void rotate(int[] arr, int order) {
	order = order % arr.length;   // if the order = 3 and elements are 2 in that case we just need to rotate 1. so 3 %2 = 1
 
	if (arr == null || order < 0) {
		throw new IllegalArgumentException("Illegal argument!");
	}
	if(order == 0 || arr.length == 1) {
		return;
	}
	//length of first part
	int a = arr.length - order; 
 
	reverse(arr, 0, a-1);                    /// reverse(arr,0,arr.length-k-1)
	reverse(arr, a, arr.length-1);           // reverse(arr, arr.length-k, arr.length-1)
	reverse(arr, 0, arr.length-1);           // reverse(arr, 0, arr.length-1)
 
}
 
public static void reverse(int[] arr, int left, int right){
	if(arr == null || arr.length == 1) 
		return;
 
	while(left < right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
	}	
}
////Write a program to check whether a given number is an ugly number.

//Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

//Note that 1 is typically treated as an ugly number.

public boolean isUgly(int num) {
        if(num <= 0) {
            return false;
        }
        while(num%2 == 0) {
            num = num / 2;
        }
        if(num == 1) {        /// no need to write this one. we can write at the end,
            return true;
        }
        while(num%3 == 0) {
            num = num/3;
        }
        if(num == 1) {
            return true;
        }
        while(num%5 == 0){
            num = num/5;
        }
        if(num == 1) {
            return true;
        }
        return false;
    }
	
	////Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
	 public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        if(nums.length == 0) {               /// if zero element just return null list
            return l;
        }
        if(nums.length == 1) {             // if one element add that element into the list
            l.add(nums[0]);
            return l;
        }
        int temp = nums[0], count = 2, temp1;     // find first element trick is just increment counter 2 at the every time.
        for(int i = 1; i < nums.length; i++) {   // 
            if(nums[i] == temp) {
                count+=2;
            }
            else{
                count--;
                if(count == 0) {
                    temp = nums[i];
                    count = 1;                  // if zero then set counter at 1;
                }
            }
        }
        count = 0;
        for(int i = 0; i < nums.length; i++) {             /// then count occurse of first element 
            if(nums[i] == temp) {
                count++;
            }
        }
        if(count > Math.floor(nums.length/3)) {                      /// if greater than n/3 then add that element
            l.add(temp);
        }
        temp1 = temp;                             /// now for second element just follow the traditional method.
        temp = nums[0];
        count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == temp1){                    /// add this sentense.. if it is same as first element then just continue the loop.
                continue;
            }  
            else if(nums[i] == temp) {
                count++;
            }
            else {
                count--;
                if(count == 0) {
                    temp = nums[i];
                    count = 1;
                }
            }
        }
        count  = 0;
        for(int i = 0; i < nums.length; i++) {          /// count its occurance
            if(nums[i] == temp) {
                count++;
            }
        }
        if(count > Math.floor(nums.length/3)) {            /// greater than n/3 just add
            if(temp != temp1) {
                l.add(temp);
            }
            
        }
        return l;
    }
	
	//Given an array of non-negative integers, you are initially positioned at the first index of the array.

	//Each element in the array represents your maximum jump length at that position.

	//Determine if you are able to reach the last index.

	//For example:
//A = [2,3,1,1,4], return true.

//A = [3,2,1,0,4], return false.

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return true;
        }
        int farPos = nums[0], curFarPos = 0;
        for(int i = 1; i <= farPos; i++) {
            if(farPos >= nums.length-1) {
                return true;
            }
            curFarPos = i + nums[i];
            if(curFarPos > farPos) {
                farPos = curFarPos;
            }
        }
        return false;
    }
}

1->4->5->null
3->4->6->null
4->9->1->null

//sum of number if they are in the linkedlist

public static SinglyLinkedListNode linkedListSum(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
		SinglyLinkedListNode finalHead = null, curNode = null, newNode, head1 = l1, head2 = l2;
		head1 = reverseLinkedList(head1);
		head2 = reverseLinkedList(head2);
		int carry = 0, sum, reminder;
		curNode = new SinglyLinkedListNode(0);
		finalHead = curNode;
		while(head1 != null || head2 != null || carry != 0) {
			sum = (head1 != null?head1.getData():0)+(head2 != null?head2.getData():0)+carry;
			carry = sum / 10;
			reminder = sum%10;
			newNode = new SinglyLinkedListNode(reminder);
			curNode.setNext(newNode);
			curNode = curNode.getNext();
			head1 = (head1.getNext()!= null? head1.getNext(): null);
			head2 = (head2.getNext()!= null? head2.getNext(): null);
		}
		finalHead = finalHead.getNext();
		finalHead = reverseLinkedList(finalHead);
		return finalHead;
	}
	
	///Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

	//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
	
	 public boolean isValid(String s) {
        if(s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        Character cur;
        
        for(int i = 0; i < s.length(); i++) {
           
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                
            } 
            else {
                
                if(stack.isEmpty()) {
                    return false;
                }
                cur = stack.pop();
                if((s.charAt(i) == ')' && cur != '(' )|| (s.charAt(i) == '}' && cur != '{') || (s.charAt(i) == ']' && cur != '[')) {  
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
	//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            sum = sum - root.val;
            return (sum == 0);
        }
        sum = sum - root.val;
        return (hasPathSum(root.left, sum) || hasPathSum(root.right,sum));
    }
	
	
	////Given:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//return its length 5.
	public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == "" || endWord == "") {
            return 0;
        }
        if(beginWord.length() != endWord.length()) {
            return 0;
        }
        if(beginWord == endWord) {
            return 1;
        }
        if(beginWord.length() == 1 ) {
            return 1;
        }
        String curWord = beginWord;
        while(curWord != endWord) {
            curWord = find(beginWord,curWord, wordList);
            if(curWord == "") {
                return 0;
            }
        }
        return 1;
    }
    public String find(String beginWord, String curWord, Set<String> wordList) {
        Iterator<String> i = wordList.iterator();
        String curString = "";
        int count;
        while(i.hasNext()) {
            curString = i.next();
            count = 0;
            for(int j = 0; j < curString.length(); j++ ) {
                if(curWord.charAt(j) != curString.charAt(j)) {
                    count++;
                }
            }
            if(count == 1 && curString != beginWord) {
                return curString;
            }
            
        }
        return "";
        
    }
}
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and 
//the difference between i and j is at most k.
 IMP : always try to find the less time what will happen. In this case it is match. so put it inside the loop and most of time it won't match so put it 
 out side.
public boolean containsNearbyDuplicate(int[] nums, int k) {
        
       Set<Integer> s = new HashSet<Integer>();
       for(int i = 0; i < nums.length; i++){
           if(i > k) {
               s.remove(nums[i-k-1]);
           }
           if(!s.add(nums[i])) {
               return true;
           }
       }
       return false;
      
}
 /////Reverse a linked list from position m to n. Do it in-place and in one-pass.

//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,

//return 1->4->3->2->5->NULL.

//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode finalNode = new ListNode(0);   //
        finalNode.next = head;
        ListNode x = head, prev = finalNode, revprev = null, revtemp = null, y;
        int i = 1;
        while(i < m) {
            prev = x;
            x = x.next;
            i++;
        }
        y = x;
        while(i <= n && y != null) {
            revtemp = y.next;
            y.next = revprev;
            revprev = y;
            y = revtemp;
            i++;
        }
        prev.next = revprev;
        x.next = y;
        return finalNode.next;
    }
    
}

Given a collection of integers that might contain duplicates, nums, return all possible subsets.


////
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Integer[] array = new Integer[treeSize(root)];
        int count = 0;
        List<List<Integer>> finalList = new List<List<Integer>>();
        storePath(root, sum, finalList, array, count);
        return finalList;
    }
    public void storePath(TreeNode root, int sum, List<List<Integer>> finalList,Integer[] array, int count) {
        if(root.left == null && root.right == null) {
            array[count] = root.val;
            sum = sum - root.val;
            if(sum == 0) {
                finalList.add(new ArrayList<Integer>(Arrays.asList(array)));
                return;
            }
        }
        Array[count++] = root.val;
        sum = sum - root.val;
        storePath(root.left, sum , finalList, array, count);
        storePath(root.right, sum , finalList, array, count);
    }
    public int treeSize(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return (treeSize(root.left) + treeSize(root.right) + 1);
    }
}
/// sort linked list using merge sort 
public static SinglyLinkedListNode sort(SinglyLinkedListNode head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		SinglyLinkedListNode fptr = head, sptr = head, head2;
		while(fptr.getNext() != null && fptr.getNext().getNext() != null) {
			fptr = fptr.getNext().getNext();
			sptr = sptr.getNext();
		}
		head2 = sptr.getNext();
		sptr.setNext(null);
		//SinglyLinkedListNode l = sort(head);
		head = sort(head);
		//SinglyLinkedListNode r = sort(head2);
		head2 = sort(head2);
		//SinglyLinkedListNode finalhead = merge(l, r);
		head = merge(head, head2);
		//return finalhead;
		return head;
	}
	public static SinglyLinkedListNode merge(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedList newlist = new SinglyLinkedList();
		//newlist.head = new SinglyLinkedListNode(0);
		SinglyLinkedListNode fakehead = new SinglyLinkedListNode(0);
		//SinglyLinkedListNode temp = newlist.head;
		SinglyLinkedListNode temp = fakehead;
		while(head1 != null && head2 != null) {
			if(head1.getData() < head2.getData()) {
				temp.setNext(new SinglyLinkedListNode(head1.getData()));
				temp = temp.getNext();
				head1 = head1.getNext();
			}
			else if(head2.getData() < head1.getData()) {
				temp.setNext(new SinglyLinkedListNode(head2.getData()));
				temp = temp.getNext();
				head2 = head2.getNext();
			}
			else {
				temp.setNext(new SinglyLinkedListNode(head1.getData()));
				temp.getNext().setNext(new SinglyLinkedListNode(head2.getData()));
				temp = temp.getNext().getNext();
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
		}
		while(head1 != null) {
			temp.setNext(new SinglyLinkedListNode(head1.getData()));
			temp = temp.getNext();
			head1 = head1.getNext();
		}
		while(head2 != null) {
			temp.setNext(new SinglyLinkedListNode(head2.getData()));
			temp = temp.getNext();
			head2 = head2.getNext();
		}
		//return newlist.head.getNext();
		return fakehead.getNext();
	}
	
	/// Given a binary tree, determine if it is height-balanced.

//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//// update 
optimised solution;

public boolean isBalanced(TreeNode root) {
      if(root == null) {
          return true;
      }
      return (helper(root) != -1);
    }
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1) {
            return -1;
        }
        if(Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left,right)+1;
    }
	/// simply perform task of height, but do some modification that if difference become more than 1 than start to return -1 if one -1 is encountered just 
	/// start to return -1
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] flag = new boolean[1];
        flag[0] = true;
        int temp = isBalancedHelper(root, flag);
        return flag[0];
    }
    public int isBalancedHelper(TreeNode root, boolean[] flag) {
        if(root == null) {
            return 0;
        }
        int left = isBalancedHelper(root.left, flag);
        int right = isBalancedHelper(root.right, flag);
        if(Math.abs(left - right) > 1) {
            flag[0] = false;
        }
        return (Math.max(left , right) + 1);
    }
}

///Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    public TreeNode helper(int[] nums, int left , int right) {
        if(left > right) {
            return null;
        }
        if(left == right) {
            TreeNode newNode = new TreeNode(nums[left]);
            newNode.left = null;
            newNode.right = null;
            return newNode;
        }
        int mid = left + (right - left) / 2;
        //TreeNode leftTemp = helper(nums, left, mid-1);
        //TreeNode rightTemp = helper(nums, mid+1, right);
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = helper(nums, left, mid-1);
        newNode.right = helper(nums, mid+1, right);
        return newNode;
    }
}
/// other solution  // above solution is more efficient;

public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}

///For example:

//Secret number:  "1807"
//Friend's guess: "7810"
//Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
//Please note that both secret number and friend's guess may contain duplicate digits, for example:

//Secret number:  "1123"
//Friend's guess: "0111"
//In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
//Secret number:  "1022"
//Friend's guess: "1222"
// for this example we need to saperate cow and bull counting.
/// new solution // only one pass
public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        if (secret.charAt(i) == guess.charAt(i)) bulls++;
        else {
            if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
            if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
        }
    }
    return bulls + "A" + cows + "B";
    }
}

/// lessons: so no need to remember the ascill code - just minus the first element.
/////////////////  for the first string increament from 0 and check for the less in the map.
/////////////////  for the second string decrement from 0 and check for more than 1 in the map to check whether it is in the first string.
public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int val, bull = 0, cow = 0;
        String finalString;
        for(int i = 0; i < secret.length(); i++) {
            if(!hm.containsKey(secret.charAt(i))) {
                hm.put(secret.charAt(i), 1);
            }
            else {
                val = hm.remove(secret.charAt(i));
                val++;
                if(val > 0) {
                    hm.put(secret.charAt(i), val);
                }
            }
        }
        
        for( int i = 0; i < guess.length(); i++) {
            if(guess.charAt(i) == secret.charAt(i)) {
                bull++;
                val = hm.remove(guess.charAt(i));
                val--;
                if(val > 0) {
                    hm.put(guess.charAt(i), val);
                }
            }
        }
        for(int i = 0; i < guess.length(); i++) {
            
            if(guess.charAt(i) != secret.charAt(i))  {
                    if(hm.containsKey(guess.charAt(i))) {
                        cow++;
                        val = hm.remove(guess.charAt(i));
                        val--;
                        if(val > 0) {
                         hm.put(guess.charAt(i), val);
                        }
                }
            }
        }
        finalString = bull+"A"+cow+"B";
        return finalString;
    }
}
////  Not yet working
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        Integer val;
        if(s.length() == 0 || words.length == 0) {
            return result;
        }
        fillTheMap(hm, words);
        int count;
        //for(int i = 0; i <= s.length() - words.length * words[0].length() ; i=i+words[0].length()) {
        for(int i = 0; i <= s.length()-words.length*words[0].length(); i++) {
           // String str = s.substring(i, i+ words.length * words[0].length());
            //hm.clear();
           // fillTheMap(hm, words);
            HashMap<String, Integer> newhm =  new HashMap<String, Integer>(hm);
            count = 0;
            for(int j = i; j < words.length*words[0].length(); j = j + words[0].length()) {
                String strtemp = s.substring(j, j+words[0].length());
                if(newhm.containsKey(strtemp)) {
                    count++;
                    val = (Integer)newhm.remove(strtemp);
                    val--;
                    if(val > 0) {
                         newhm.put(strtemp, val);
                    }
                   
                   // hm.remove(strtemp);
                }
                else {
                    break;
                }
            }
            if(count == words.length && newhm.isEmpty() ) {
                result.add(i);
            }
        }
        return result;
    }
    public void fillTheMap(HashMap hm, String[] words) {
        hm.clear();
        Integer val;
        for(int i = 0; i < words.length; i++) {
            hm.put(words[i], hm.containsKey(words[i])?(Integer)hm.get(words[i])+1:1);
            /*if(!hm.containsKey(words[i])) {
                hm.put(words[i], 1);
            }
            else {
                val = (Integer)hm.remove(words[i]);
                val++;
                hm.put(words[i], val);
                
            }*/
        }
    }
}

//// Window of k continue sum of element.
int[] window = {4,5,9,3,5,2,5,8,4,5,6,2,9};
		System.out.println(sumOfWindow(window, 5));
public static int sumOfWindow(int[] array, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		int cur_sum = 0, max_sum = 0, start_index = 0;
		for(int i = 0; i < k; i++) {
			cur_sum+=array[i];
			q.add(array[i]);
			
		}
		max_sum = cur_sum;
		for(int i = k ; i < array.length; i++) {
			cur_sum -=q.remove();
			cur_sum += array[i];
			q.add(array[i]);
			if(cur_sum > max_sum) {
				max_sum = cur_sum;
				start_index = i-k+1;
			}
		}
		System.out.println(start_index);
		return max_sum;
	}
	public static boolean isPossible(String str) {
		int counter = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'S') {
				counter++;
			}
			if(str.charAt(i) == 'X') {
				counter--;
				if(counter < 0) {
					return false;
				}
			}
		}
		return true;
	}
	//// Stack operation possible
	String msn = "SSXXSSSSXXSSXXXSSSSXXXXX";
		System.out.println(msn);
		System.out.println(isPossible(msn))
		
		
		public static boolean isPossible(String str) {
		int counter = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'S') {
				counter++;
			}
			if(str.charAt(i) == 'X') {
				counter--;
				if(counter < 0) {
					return false;
				}
			}
		}
		return true;
	}
	///// Can we form this sequence using stack operation
	
	char[] array = {'1', '2', '3' ,'4' ,'5', '6'};
		String str1 = "154632";
		System.out.println(isStackOp(array, str1));
		
		
		
		public static String isStackOp(char[] array, String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		int i = 0, j = 0;
		while(i < array.length) {
			while(array[i] != (char)str.charAt(j) && i < array.length) {
				stack.push(array[i++]);
				sb.append("S");
			}
			if(i < array.length) {
				stack.push(array[i++]);
				sb.append("S");
			}
			while(!stack.isEmpty() && stack.peek() == str.charAt(j)) {
				stack.pop();
				sb.append("X");
				j++;
			}
		}
		if(i == j && stack.isEmpty()) {
			return sb.toString();
		}
		else {
			return "Not possible";
		}
	}
	
	///// find the minimum distance between two elements in the array.
	public static int minimum_index_distance(int[] array, int x, int y) {
		int prev = 0, i = 0, min_diff = Integer.MAX_VALUE;
		for(i = 0; i < array.length; i++) {
			if(array[i] == x || array[i] == y) {
				prev = i;
				break;
			}
		}
		for(; i < array.length; i++) {
			if(array[i] == x || array[i] == y) {
				if(array[i] != array[prev] && i-prev < min_diff) {
					min_diff = i - prev;
					prev = i;
				}
				else {
					prev = i;
				}
			}
		}
		return min_diff;
	}
	//// minimum distance between three elements;
	public static int minimum_index_distance(int[] array, int x, int y, int z) {
		int i ,prev1 = -1, prev2 = -1, min_diff = Integer.MAX_VALUE;
		for(i = 0; i < array.length; i++) {
			if(array[i] == x || array[i] == y || array[i] == z ) {
				if(prev1 == -1 || array[i] == array[prev1]) {
					prev1 = i;	
				}
				else {
					prev2 = i;
					break;
				}
			}
			
		}
		for(; i < array.length; i++) {
			if(array[i] == x || array[i] == y || array[i] == z) {
				if(array[i] != array[prev1] && array[i] != array[prev2] && i-Math.min(prev1, prev2) < min_diff) {
					min_diff = i - Math.min(prev1, prev2);
					if(prev1 == Math.min(prev1, prev2)) {
						prev1 = i;
					}
					else {
						prev2 = i;
					}
				}
				else if(array[i] == array[prev1]) {
					prev1 = i;
				}
				else if(array[i] == array[prev2]){
					prev2 = i;
				}
			}
		}
		return min_diff;
	}
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

public int nthSuperUglyNumber(int n, int[] primes) {
    int[] ret    = new int[n];
          ret[0] = 1;

    int[] indexes  = new int[primes.length];

    for(int i = 1; i < n; i++){
        ret[i] = Integer.MAX_VALUE;

        for(int j = 0; j < primes.length; j++){
            ret[i] = Math.min(ret[i], primes[j] * ret[indexes[j]]);
        }

        for(int j = 0; j < indexes.length; j++){
            if(ret[i] == primes[j] * ret[indexes[j]]){
                indexes[j]++;
            }
        }
    }

    return ret[n - 1];
}

//////////////////////////////////////////////////////////////////////////////////////////////////////
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root);
    }
    public TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if(left == null && right == null) {
            return root;
        }
        if(left != null && right != null) {
            root.left = null;
            root.right = left;
            TreeNode node = root;
            while(node.right != null) {
                node = node.right;
            }
            node.right = right;
        }
        if(left == null) {
            root.left = null;
            root.right = right;
        }
        if(right == null) {
            root.left = null;
            root.right = left;
        }
        return root;
    }
}
////////////////////////////////////////////////////////////////////////////////

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs1 = new HashSet<Character>();
        HashSet<Character> hs2 = new HashSet<Character>();
        int ptr = 0;
        for(int i = 0; i < board.length; i++){
            hs1.clear();
            hs2.clear();
           for(int j = 0; j < board.length; j++) {
               if(board[i][j] != '.') {
                   if(!hs1.add(board[i][j])){
                       return false;
                   }
               }
               
               if(board[j][i] != '.') {
                   if(!hs2.add(board[j][i])) {
                       return false;
                   }
               }
              
           }
          
        }
        for(int i = 0; i < board.length; i = i+3) {
            for(int j = 0; j < board.length; j = j+3){
                hs1.clear();
                for(int p = i; p < i+3; p++) {
                    for(int q = j; q < j+3; q++) {
                        if(board[p][q] != '.') {
                            if(!hs1.add(board[p][q])) {
                                return false;
                            }   
                        }
                       
                    }
                }
                
            }
        }
        return true;
    }
}

////////////////////////////////////////////////////////////////////////////
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}
//// solution
- split first and second half.
- reverse second half.
- then join first and second half.

public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode ptr1 = head, ptr2 = head, head2, temp1, temp2;
        while(ptr2.next != null && ptr2.next.next != null) {
            ptr2 = ptr2.next.next;
            ptr1 = ptr1.next;
        }
        head2 =ptr1.next;
        ptr1.next = null;
        head2 = reverse(head2);
        while(head2 != null) {
            temp1 = head.next;
            temp2 = head2.next;
            head.next = head2;
            head2.next = temp1;
            head = temp1;
            head2 = temp2;
        }
    }
    public ListNode reverse(ListNode head) {
        ListNode temp = null, prev = null;
        while(head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head, ptr2 = head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        if(head == null || n == 0) {
            return null;
        }
        int i = 1;
        while(ptr1.next != null) {
            ptr1 = ptr1.next;
            if(i >= n) {
                prev = ptr2;
                ptr2 = ptr2.next;
            }
            i++;
        }
        prev.next = prev.next.next;
        ptr2.next = null;
        return fakeHead.next;
    }
	
/////////////////////////////////////////////////////////////////////////////////////////////////////
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.


 public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if(head == null) {
            return null;
        }
        while(temp != null && temp.next != null) {
            if(temp.val == temp.next.val) {
               temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

 public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode temp = head, prev = fakeHead;
        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val) {
                while(temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                prev.next = temp.next;
                temp = temp.next;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        return fakeHead.next;
    }
	
	//////////////////////////////////////////////////////////////////////////////////////
	int[] a1 = {12,2,3,4,5,6};
		int[] b1 = {25,3,4,5,6,7,8};
		ArrayList<Integer> finalal = findSumArray(a1,b1);
		System.out.println(finalal.toString());
		
		public static ArrayList<Integer> findSumArray(int[] a1, int[] b1) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		int i = 0, j = 0, k = 0, p;
		String s;
		while(i != a1.length && j != b1.length) {
			s = ""+(a1[i++] + b1[j++]);
			p = 0;
			while(p < s.length()){
				arraylist.add((int)s.charAt(p)-'0');
				p++;
			}
		}
		while(i < a1.length) {
			arraylist.add(a1[i++]);
		}
		while(j < b1.length) {
			arraylist.add(b1[j++]);
		}
		return arraylist;
	}
	
	lesson : every time need to convert number into its character just convert into string;
	
	
	////  print path with minimum sum
	
	public static int heightOfTree(Node root) {
		if(root == null){
			return 0;
		}
		return Math.max(heightOfTree(root.getLeftNode()),heightOfTree(root.getRightNode()))+1;
	}
	static int min_sum = Integer.MAX_VALUE;
	public static void printMinSumPath(Node root) {
		int[] a = new int[heightOfTree(root)];
		int[] b = new int[heightOfTree(root)];
		int count = 0;
		int sum = 0;
		helper(root,a,b,count,sum);
		System.out.println(min_sum);
		for(int i = 0; i < b.length; i++) {
			System.out.print(" "+b[i]);
		}
	}
	public static void helper(Node root,int[] a, int[] b, int count, int sum) {
		
		if(root.getLeftNode() == null && root.getRightNode() == null) {
			sum = sum + root.getData();
			a[count] = root.getData();
			if(sum < min_sum) {
				min_sum = sum;
				for(int i = 0; i <= count; i++) {
					b[i] = a[i];
				}
			}
			return;
		}
		sum = sum + root.getData();
		a[count++] = root.getData();
		helper(root.getLeftNode(),a,b,count,sum);
		helper(root.getRightNode(),a,b,count,sum);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	Maximum sliding window to find the maximum
	Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

 public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 && k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k +1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        int i, p =0;
        for(i = 0; i < k; i++) {
            while(!ad.isEmpty() && ad.peekLast() < nums[i]) {
                ad.pollLast();
            }
            ad.offer(nums[i]);
        }
        result[p++] = ad.peek();
        for(; i < nums.length; i++) {
            if(ad.peek() == nums[i-k]) {
                ad.poll();
            }
             while(!ad.isEmpty() && ad.peekLast() < nums[i]) {
                ad.pollLast();
            }
            ad.offer(nums[i]);
            result[p++] = ad.peek();
        }
        return result;
    }
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	combination of number from 1, n with k digits
	
	ArrayList<ArrayList<Integer>> finalcomb = findCombination(4,2);
		System.out.println(finalcomb.toString());
		
	public static ArrayList<ArrayList<Integer>> findCombination(int n, int k) {
		ArrayList<ArrayList<Integer>> finallist = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		helper(finallist, al, n, 1, k);
		return finallist;
	}
	public static void helper(ArrayList<ArrayList<Integer>> finallist, ArrayList<Integer> al, int n, int start, int k) {
		if( k == 0) {
			finallist.add(new ArrayList<Integer>(al));
		}
		for(int i = start; i <= n; i++) {
			al.add(i);
			helper(finallist, al , n, i+1,k-1);
			al.remove(al.size()-1);
		}
	}
	
	///// sum of three element 0 find all in O(n^2)
	/// lesson : for the dublicate we use the contains method on the arraylist 
	/// for decreasing time we add while loop in the if avoid the same 
	
	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
	
	
	 public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> finallist =new  ArrayList<List<Integer>>();
        if(nums.length == 0) {
            return finallist;
        }
        Arrays.sort(nums);
        int left, right;
        for(int i = 0; i <= nums.length-3; i++) {
            left = i+1;
            right = nums.length-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0 ) {
                    List<Integer> al = new ArrayList<>();
                    al.add(nums[i]);
                    al.add(nums[left]);
                    al.add(nums[right]);
                    if(!finallist.contains(al)) {
                        finallist.add(al);
                    }
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return finallist;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	
	public int threeSumClosest(int[] nums, int target) {
        int diff, min_diff = Integer.MAX_VALUE ;
        int sum = Integer.MAX_VALUE; 
        if(nums.length == 0 ) {
            return 0;
        }
        Arrays.sort(nums);
        int left, right;
        for(int i = 0; i <= nums.length-3; i++) {
            left = i+1;
            right = nums.length-1;
            while(left < right) {
                 diff =Math.abs((nums[i] + nums[left] + nums[right]) - target) ;
                 if(diff < min_diff) {
                     sum = nums[i] + nums[left] + nums[right];
                     min_diff = diff;
                 }
                 if(nums[i] + nums[left] + nums[right] > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return sum;
    }
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
	
	
	 public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> finallist = new ArrayList<List<Integer>>();
        if(nums.length == 0) {
            return finallist;
        }
        Arrays.sort(nums);
        int left , right;
        for(int i = 0; i <= nums.length-4; i++) {
            for(int j = i+1; j <= nums.length-3; j++) {
                left = j+1;
                right = nums.length-1;
                while(left < right) {
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        if(!finallist.contains(al)) {
                             finallist.add(al);
                        }
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return finallist;
    }
////// least common ancester (LCA) of binary search tree;
1. find that both the nodes are present in the binary search tree; // write another function which will iterate to the entire tree;
if yes then only go with the finding process 

public static boolean f1 = false, f2 = false;           /// flag to check both nodes are present in the tree;
	public int LCAB(Node root, int a, int b) {
		f1 = false;
		f2 = false;
		helper(root,a,b);
		if(f1 && f2) {
			return LCABhelper(root, a, b);  // if present then only call this method.
		}
		return -1;
	}
	public void helper(Node root, int a, int b) {
		if(root == null) {      
			return;
		}
		if(root.getData() == a) {
			f1 = true;
		}
		if(root.getData() == b) {
			f2 = true;
		}
		helper(root.getLeftNode(), a , b);
		helper(root.getRightNode(), a, b);
	}
	public int LCABhelper(Node root, int a, int b) {         /// we have established that both the nodes are present
															//// so the recursive function will not hit any node which is null;
		if(root.getData() < a && root.getData() < b) {       /// consider the both the given number so no need for the order
			return LCAB(root.getRightNode(), a, b);          ////  if root.data less than both go to right tree.
		}
		if(root.getData() > b && root.getData() > a) {      /// greater than both go to left subtree;
			return LCAB(root.getLeftNode(), a , b);
			
		}		    
		return root.getData();                     /// if the data is in between inclusive than return that particular nood.
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	least common ancester for Binary tree; (LCS)
	public static boolean f1, f2;
	public int LCANB(Node root, int a, int b) {
		f1 = false;
		f2 = false;
		isExist(root, a, b);
		if(f1 && f2) {
			return LCANBhelper(root, a, b);
		}
		return -1;
	}
	public int LCANBhelper(Node root, int a ,int b) {
		if(root == null) {
			return 0;
		}
		if(root.getData() == a || root.getData() == b) {    ///  write this one... 
			return root.getData();
		}
		int left = LCANBhelper(root.getLeftNode(), a, b);
		int right = LCANBhelper(root.getRightNode(), a, b);
		if(left != 0 && right != 0) {
			return root.getData();
		}
		return (left != 0? left: right);
	}
	public void isExist(Node root, int a, int b) {
		if(root == null) {
			return;
		}
		if(root.getData() == a) {
			f1 = true;
		}
		if(root.getData() == b) {
			f2 = true;
		}
		isExist(root.getLeftNode(), a, b);
		isExist(root.getRightNode(), a, b);
	}
	////////////////////////////////////////////////////////////////////////
	minimum depth of the tree;
	//// root node means depth is 1 
	//// only consider the node that are present
	/// if the depth of root node is considered 0 in that case just replace 0 with -1;
	public class Solution {
    public int minDepth(TreeNode root) {
       if(root == null) {
           return 0;
       }
       int left = minDepth(root.left);
       int right = minDepth(root.right);
       if(left == 0 || right == 0) {
           return left+right+1;
       }
       else {
           return Math.min(left, right)+1;
       }
    }
	
	lesson : we can only divide return in two part
	 if node has two child it will return min + 1
	 if node has only one child we will return left + right + 1
	 
	//////////////////////////////////////////////////////////////////////////////////
	
	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

 public int sumNumbers(TreeNode root) {
       return helper(root, 0);
    }
    public int helper(TreeNode root, int s) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return s*10+root.val;
        }
        int left = helper(root.left, s*10 + root.val) ;
        int right = helper(root.right, s*10 + root.val);
        return left+right;
    }
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.

///if small value comes set the as the small value; 
//if intermidiate value comes set as second small value;
//if any value if greater than these two values than return true;
public boolean increasingTriplet(int[] nums) {
       int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
       for(int i = 0; i < nums.length; i++) {
           if(nums[i] <= firstSmall) {
               firstSmall = nums[i];
           }
           else if(nums[i] <= secondSmall) {
               secondSmall = nums[i];
           }
           else return true;
       }
       return false;
       
    }
	//////////////////////////////////////////////////////////////////////////////////////////
	Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 ) {
            return 0;
        }
        int[] result = new int[nums.length];
        int i, j, max = 0;
        for(i = 1; i < nums.length; i++) {
            for(j = 0; j < i; j++) {
                if(nums[j] < nums[i] && result[j]+1 > result[i]) {
                    result[i] = result[j] + 1;
                    if(result[i] > max) {
                        max = result[i];
                    }
                }
            }
        }
        return max+1;
        
    }
	////// O(nlogn) solution
	
	 public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums.length == 1 ) {
            return nums.length;
        }
        int[] result = new int[nums.length];
        helper(nums, result, 0, nums.length-1);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < result.length; i++) {
            if(result[i] > max) {
                max = result[i];
            }
        }
        return max;
        
    }
    public void helper(int[] A, int[] B, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == right) {
            B[left] = 1;
            return;
        }
        int mid = left + (right-left)/2;
        helper(A,B,left,mid);
        helper(A,B,mid+1,right);
        count(A,B,left,mid,right);
        
    }
    public void count(int[] A, int[] B, int left, int mid, int right) {
        int j = mid+1;
        for(int i = left; i <= mid; i++) {
            j = mid+1;
            while(j <= right) {
                if(A[j] > A[i] && B[j] < B[i]+1) {
                   B[j] = B[i] + 1;
                }
                j++;
            }
        }
        for(int i = mid+2; i <= right; i++) {
            for(j = mid+1; j < i; j++) {
                if(A[i] > A[j] && B[j] + 1 > B[i]) {
                    B[i] = B[j]+1;
                }
            }
        }
		
		/////////////////////////////////////////////////////////////
		Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

public boolean isAnagram(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        if(s.length() == 0 || t.length() == 0 || s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for(int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a']++;
            array[t.charAt(i)-'a']--;
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] != 0) {
                return false;
            }
        }
        return true;
    }
	///////////////////////////////////////////////////
	Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]

public List<List<String>> groupAnagrams(String[] strs) {
    if(strs==null || strs.length == 0){
        return new ArrayList<List<String>>();
    }
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    //Arrays.sort(strs);
    for (String s:strs) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String keyStr = String.valueOf(ca);
        if(!map.containsKey(keyStr))
            map.put(keyStr, new ArrayList<String>());
        map.get(keyStr).add(s);
    }

    for(String key: map.keySet()) {
        Collections.sort(map.get(key));
    }
    return new ArrayList<List<String>>(map.values());
///////////////////////////////////////////////////////////////////////////////////////////
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finallist = new ArrayList<List<Integer>>();
        finallist.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int n = finallist.size();
            for(int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<Integer>(finallist.get(j));
                temp.add(nums[i]);
                finallist.add(temp);
            }
        }
        return finallist;
    }
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

 public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> finallist = new ArrayList<List<Integer>>();
        Integer[] result = new Integer[height(root)];
        helper(root, sum, result, finallist, 0);
        return finallist;
    }
    public void helper(TreeNode root, int sum, Integer[] result, List<List<Integer>> finallist, int count) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            sum = sum - root.val;
            result[count++] = root.val;
            if(sum == 0) {
                finallist.add(new ArrayList<Integer>(Arrays.asList(Arrays.copyOfRange(result, 0, count))));
            }
            return;
        }
        result[count++] = root.val;
       
        sum = sum - root.val;
        helper(root.left, sum, result, finallist,count);
        helper(root.right,sum, result, finallist,count);
        
    }
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right))+1;
    }
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length, s2.length);
        for(int i = 0; i < n; i++) {
            Integer n1 = (i < s1.length)?Integer.parseInt(s1[i]):0;
            Integer n2 = (i < s2.length)?Integer.parseInt(s2[i]):0;
            int compare = n1.compareTo(n2);
            if(compare != 0) {
                return compare;
            }
        }
        return 0;
    }
////////////////////another 

public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");
        int len = Math.max(first.length, second.length);
        int i = 0; 
        while(i < len) {
            int p = (i < first.length)?Integer.parseInt(first[i]):0;
            int q = (i < second.length)?Integer.parseInt(second[i]):0;
            if(p > q) return 1;
            else if(p < q) return -1;
            else i++;
        }
        return 0;
    }
	/////////////////////////////////////////////////////////////////////////////////
	205. Isomorphic Strings
	Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
/////// optimized 
public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0) return true;
        if(s.length() != t.length()) return false;
        char value;
        HashMap<Character,Character> hm = new HashMap<Character,Character>();
        for(int i = 0; i < s.length(); i++) {
            if(hm.containsKey(s.charAt(i))) {
                value = hm.get(s.charAt(i));
                if(value != t.charAt(i)) return false;
            }
            else {
                if(hm.containsValue(t.charAt(i))) return false;
                else hm.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
	//////////// another
 public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                if(!map.containsValue(t.charAt(i))) {
                    map.put(s.charAt(i), t.charAt(i));
                }
                else {
                    return false;
                }
            }
            else {
                if(map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
//////////////////////////////////////////////////////////////////////////////////////////

290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase 
letters separated by a single space

public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 && str.length() == 0) return true;
        StringTokenizer st = new StringTokenizer(str);
        if(pattern.length() != st.countTokens()) return false;
        HashMap<Character,String> hm = new HashMap<>();
        String value;
        int i = 0;
        while(st.hasMoreTokens()) {
            if(hm.containsKey(pattern.charAt(i))) {
                if(!(hm.get(pattern.charAt(i)).equals(st.nextToken()))) return false;
            }
            else {
                value = st.nextToken();
                if(hm.containsValue(value)) return false;
                else hm.put(pattern.charAt(i),value);
            }
            i++;
        }
        return true;
    }

//////////////////////////////////////////////////////////////
	Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
///////////// optimized 

public String reverseWords(String s) {
        if(s == null) return null;
        StringTokenizer st = new StringTokenizer(s," ");
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
           sb.insert(0,st.nextToken());
           sb.insert(0," ");
        }
        return sb.toString().trim();
    }
//////// another
public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) {
            return "";
        }
        StringTokenizer st = new StringTokenizer((String)s," ");
        String finalstring = "";
        while(st.hasMoreTokens()) {
            finalstring = st.nextToken()+" "+ finalstring;
        }
        
        return finalstring.trim();
    }
	
	//////////////////////////////////////////////////////////////////////////
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m = m - 1;
        n = n - 1;
        while(m >= 0 && n >=0) {
            nums1[k--] = (nums1[m] > nums2[n])?nums1[m--]:nums2[n--];
        }
        while(m >= 0) {
            nums1[k--] = nums1[m--];
        }
        while(n >= 0) {
            nums1[k--] = nums2[n--];
        }
    }
	//////////////////////////////////////////////////////////////////
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
	
	
	////////////////////////////////////////////////////////////////////////////
	Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.


public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0, i;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[left] < nums[mid] || nums[mid] > nums[right]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if(nums[mid] < nums[right] || nums[left] > nums[mid]){
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                right--;
            }
        }
        return false;
    }
	/////////////////////////////////////////////////////////////////////////////////////////
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Always draw for this elements.

Find the minimum element.

You may assume no duplicate exists in the array.
public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
        if(left == right) {
            return nums[left];
        }
        while(left + 1 != right) {
            mid = left + (right-left)/2;
            if(nums[left] < nums[mid]) {         /// if left is sorted
                if(nums[left] < nums[right]) {   
                    return nums[left];
                }
                else {
                    left = mid;
                }
            }
            else {                              /// if right is sorted && left is not sorted
                if(nums[mid+1] > nums[mid]) {
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
        }
        return Math.min(nums[left],nums[right]);
    }
	////////////////////////////////////////////////
	optimised
	
	public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
        if(left == right) {
            return nums[left];
        }
        while(left + 1 != right) {
            mid = left + (right-left)/2;
            if(nums[left] < nums[mid]) {   /// if left is sorted and left most element is less than right most element in that case entire array is sorted
                if(nums[left] < nums[right]) {
                    return nums[left];
                }
                else {                      /// left most element is grater thant right most element than min is at the right side
                    left = mid;
                }
            }
            else {               /// if left is unsorted means the min is definately in the left side.
                right = mid;
            }
        }
        return Math.min(nums[left],nums[right]);
    }
	////////////////////////////////////////////////////////////////////////////////////////////////
	Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
        if(left == right) {
            return nums[left];
        }
        while(left + 1 != right) {
            mid = left + (right-left)/2;
            if(nums[left] <= nums[mid] && nums[mid] > nums[right]) {   /// surely left is sorted with == because all elements can be same //also sorted, and surely right is unsorted, so go to unsorted side;
                left = mid;
            }
            else if(nums[mid] <= nums[right] && nums[left] > nums[mid]){ /// surely right is sorted and left is unsorted, go to left side;
                right = mid;
            }
            else {
                right--;  // else decrement one element;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
	///////////////////////////////////////
	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
// no need to write for single element and two element it will work fine.
// if array has [2,0,0] in that case we need to elemenate left++ and right-- from the if(left < right) condition.
 public void sortColors(int[] nums) {
        int left = 0 , right = nums.length-1, val = 0 , temp;
        while(left < right) {
            while(nums[left] == val && left < right) {
                left++;
            }
            while(nums[right] != val && left < right) {
                right--;
            }
            if(left < right) {
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if(left == right && val == 0) {  // need to perform only once when val == 0
                right = nums.length - 1;
                val = 1;
            }
        }
    }
	////////////////////////////////////////////////////////////////////
	You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
    public int climbStairs(int n) {
       int[] array = new int[n+1];
       array[0] = 0;
       if(n == 0 ) {
           return 0;
       }
       array[1] = 1;
       if(n == 1) {
           return 1;
       }
       array[2] = 2;
       if(n == 2) {
           return 2;
       }
       
       for(int i = 3; i <= n; i++) {
           array[i] = array[i-1] + array[i-2];
       }
       return array[n];
        
    }
}
////////////////////////////////////////////////////////////////////////
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    
	 ArrayList<Integer> finallist = new ArrayList<Integer>();
	 ArrayList<Integer> current = new ArrayList<Integer>();
	 
	 for(int i = 0; i < a.size(); i++) {
	     if(a.get(i) >= 0) {
	         current.add(a.get(i));
	     }
	     else {
	         if(current.size() > finallist.size()) {
	             finallist = (ArrayList<Integer>)current.clone();
	             current.clear();
	         }
	     }
	 }
	 if(current.size() > finallist.size()) {
	     finallist = (ArrayList<Integer>)current.clone();
	 }
	 return finallist;
	}
}

/////////////////////////////////////
There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).



public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length == 0 && nums2.length == 0 ) { //// if both arrays are empty
            return 0;
        }
        else if(nums1.length == 0) {  // if only first array is empty
            if(nums2.length % 2 == 0) {  /// if second array has even number of elements
                return (double)(nums2[(nums2.length - 1) / 2]+nums2[(nums2.length - 1) / 2+1])/2;
            }
            else {  /// if second array has odd number of elements
                return (double)nums2[nums2.length/2];
            }
            
        }
        else if(nums2.length == 0) {  // if only second array is empty
            if(nums1.length % 2 == 0) { /// if first array has even number of elements
                return (double)(nums1[(nums1.length-1)/2]+nums1[(nums1.length-1)/2+1])/2;
            }
            else {  /// if first array has odd number of elements
                return (double)nums1[nums1.length/2];
            }
            
        }
        else {
            int[] mA,nB;   /// first array must be with less number of elements
            int imin, imax,temp, i, j, m , n;
            double left_max, right_min;
            if(nums1.length < nums2.length) {  /// 
                mA = nums1;
                nB = nums2;
            }
            else {
                mA = nums2;
                nB = nums1;
            }  /// so after this mA will be with less number of elements and nB with more number of elements
            
            m = mA.length;
            n = nB.length;
            
            imin = 0;
            imax = m;
            
            temp = (n + m + 1)/2;  /// this is to set the j in the second loop
            
            while(imin <= imax) {
                
                i = (imin+imax)/2;   
                j = temp - i;
                
                if(j > 0 && i < m && nB[j-1] > mA[i]) {  // 5][ 6 7  /// 2 3 ] [ 4 5  will compare 3 and 6 
                    imin = i + 1;
                }
                else if(i > 0 && j < n && mA[i-1] > nB[j]) {// 5][ 6 7  /// 2 3 ] [ 4 5  will compare 5 and 4 
                    imax = i - 1;
                }
                else {   /// this only encountered when we have prefect both first halof and both second prefect 
                    if( i == 0 ) { left_max = nB[j-1]; }  //  ][5 6 7 /// 2 3 ] [ 4 5
                    else if( j == 0 ) { left_max = mA[i-1]; }//  5 6 ][7 /// ][2 3 4 5
                    else { left_max = Math.max(mA[i-1], nB[j-1]); }// 5][ 6 7  /// 2 3 ] [ 4 5
                    
                    if((n + m ) % 2 == 1) { return left_max; } // if overall array has odd number of elements
                    
                    if( i == m ) { right_min = nB[j]; } //  5 6 7][ /// 2 3 ][4 5
                    else if( j == n ) { right_min = mA[i]; } //  5 6][ 7 /// 2 3 4 5][
                    else { right_min = Math.min(mA[i],nB[j]); }// 5][ 6 7  /// 2 3 ] [ 4 5
                    
                    return (left_max + right_min)/2; // if overall array has even number of elements
                }
            }
        }
        return 0;
    }
	//////////////////////// Explaination 
	To solve this problem, we need to understand "What is the use of median". In statistics, the median is used for dividing a set into two equal length subsets, that one subset is always greater than the other. If we understand the use of median for dividing, we are very close to the answer.

First let's cut A into two parts at a random position i:

      left_A             |        right_A
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
Since A has m elements, so there are m+1 kinds of cutting( i = 0 ~ m ). And we know: len(left_A) = i, len(right_A) = m - i . Note: when i = 0 , left_A is empty, and when i = m , right_A is empty.

With the same way, cut B into two parts at a random position j:

      left_B             |        right_B
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
Put left_A and left_B into one set, and put right_A and right_B into another set. Let's name them left_part and right_part :

      left_part          |        right_part
A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
If we can ensure:

1) len(left_part) == len(right_part)
2) max(left_part) <= min(right_part)
then we divide all elements in {A, B} into two parts with equal length, and one part is always greater than the other. Then median = (max(left_part) + min(right_part))/2.

To ensure these two conditions, we just need to ensure:

(1) i + j == m - i + n - j (or: m - i + n - j + 1)
    if n >= m, we just need to set: i = 0 ~ m, j = (m + n + 1)/2 - i
(2) B[j-1] <= A[i] and A[i-1] <= B[j]
(For simplicity, I presume A[i-1],B[j-1],A[i],B[j] are always valid even if i=0/i=m/j=0/j=n . I will talk about how to deal with these edge values at last.)

So, all we need to do is:

Searching i in [0, m], to find an object `i` that:
    B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )
And we can do a binary search following steps described below:

<1> Set imin = 0, imax = m, then start searching in [imin, imax]

<2> Set i = (imin + imax)/2, j = (m + n + 1)/2 - i

<3> Now we have len(left_part)==len(right_part). And there are only 3 situations
     that we may encounter:
    <a> B[j-1] <= A[i] and A[i-1] <= B[j]
        Means we have found the object `i`, so stop searching.
    <b> B[j-1] > A[i]
        Means A[i] is too small. We must `ajust` i to get `B[j-1] <= A[i]`.
        Can we `increase` i?
            Yes. Because when i is increased, j will be decreased.
            So B[j-1] is decreased and A[i] is increased, and `B[j-1] <= A[i]` may
            be satisfied.
        Can we `decrease` i?
            `No!` Because when i is decreased, j will be increased.
            So B[j-1] is increased and A[i] is decreased, and B[j-1] <= A[i] will
            be never satisfied.
        So we must `increase` i. That is, we must ajust the searching range to
        [i+1, imax]. So, set imin = i+1, and goto <2>.
    <c> A[i-1] > B[j]
        Means A[i-1] is too big. And we must `decrease` i to get `A[i-1]<=B[j]`.
        That is, we must ajust the searching range to [imin, i-1].
        So, set imax = i-1, and goto <2>.
When the object i is found, the median is:

max(A[i-1], B[j-1]) (when m + n is odd)
or (max(A[i-1], B[j-1]) + min(A[i], B[j]))/2 (when m + n is even)
Now let's consider the edges values i=0,i=m,j=0,j=n where A[i-1],B[j-1],A[i],B[j] may not exist. Actually this situation is easier than you think.

What we need to do is ensuring that max(left_part) <= min(right_part). So, if i and j are not edges values(means A[i-1],B[j-1],A[i],B[j] all exist), then we must check both B[j-1] <= A[i] and A[i-1] <= B[j]. But if some of A[i-1],B[j-1],A[i],B[j] don't exist, then we don't need to check one(or both) of these two conditions. For example, if i=0, then A[i-1] doesn't exist, then we don't need to check A[i-1] <= B[j]. So, what we need to do is:

Searching i in [0, m], to find an object `i` that:
    (j == 0 or i == m or B[j-1] <= A[i]) and
    (i == 0 or j == n or A[i-1] <= B[j])
    where j = (m + n + 1)/2 - i
And in a searching loop, we will encounter only three situations:

<a> (j == 0 or i == m or B[j-1] <= A[i]) and
    (i == 0 or j = n or A[i-1] <= B[j])
    Means i is perfect, we can stop searching.

<b> j > 0 and i < m and B[j - 1] > A[i]
    Means i is too small, we must increase it.

<c> i > 0 and j < n and A[i - 1] > B[j]
    Means i is too big, we must decrease it.
	////////////////////////////////////////////////////////////////////////////////////
	Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h 
nodes inclusive at the last level h.

public int height(TreeNode root) {
        return (root == null)?-1:1+height(root.left);
    }
    public int countNodes(TreeNode root) {
       if(root == null) {
           return 0;
       }
       int h = height(root);
       return (height(root.right) == h-1)?(1 << h) + countNodes(root.right):(1 << h-1) + countNodes(root.left);
       
    }
	// time complexity is O(log(n)^2)
	// at any node left subtree nodes are 2^h - 1 and right sub tree nodes are 2^(h-1) - 1 
	// so if we decide to go to either sub tree we need to add 1 every time therefor (1<<h ~ 2^h)
		
	
	//////////////////////////////////////////////////////////////////////////////
	59. Spiral Matrix II
	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int k = 1, rowStart = 0, colStart = 0, rowEnd = n-1, colEnd = n-1;
        while( k <= Math.pow(n,2)) {
            for(int j = colStart; j <= colEnd; j++) {
                result[rowStart][j] = k++;
            }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++) {
                result[i][colEnd] = k++;
            }
            colEnd--;
            for(int j = colEnd; j >= colStart; j--) {
                result[rowEnd][j] = k++;
            }
            rowEnd--;
            for(int i = rowEnd; i >= rowStart; i--) {
                result[i][colStart] = k++;
            }
            colStart++;
        }
        return result;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	Given a matrix of m * n elements (m rows, n columns), 
	return all elements of the matrix in spiral order.
	[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]

[1, 2, 3, 6, 9, 8, 7, 4, 5]
	
	
	public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int i_min = 0, j_min = 0, i_max = a.get(0).size()-1, j_max = a.size()-1;
		 int k = 1;
		 
		 while( k <= a.get(0).size()*a.size()) {
		     for(int i = i_min; i <= i_max; i++) {
		         result.add(a.get(j_min).get(i));
		          k++;
		     }
		     j_min++;
			 if(k > a.get(0).size()*a.size()) break;
		     for(int j = j_min; j <= j_max; j++) {
		         result.add(a.get(j).get(i_max));
		         k++;
		     }
		     i_max--;
			 if(k > a.get(0).size()*a.size()) break;
		     for(int i = i_max; i >= i_min; i--) {
		         result.add(a.get(j_max).get(i));
		          k++;
		     }
		     j_max--;
			 if(k > a.get(0).size()*a.size()) break;
		     for(int j = j_max; j >= j_min; j--) {
		         result.add(a.get(j).get(i_min));
		         k++;
		     }
		     i_min++;
			 if(k > a.get(0).size()*a.size()) break;
		    
		 }
		 return result;
	}
	/////////////////////////////////////////////////////////////////////
	binary tree closest element
	public int closestValue(TreeNode root, double target) {
    int ret = root.val;   
    while(root != null){
        if(Math.abs(target - root.val) < Math.abs(target - ret)){
            ret = root.val;
        }      
        root = root.val > target? root.left: root.right;
    }     
    return ret;
}
//////////////////////////////////////////////////////////////////////
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int maxKey = 0, maxValue;
        Iterator it;
        if(k == 0 || k > nums.length) {
            return result;
        }
        
        for(int i = 0; i < nums.length; i++) {
           // hm.put(nums[i],(!hm.containsKey(nums[i])?1:hm.get(nums[i])+1));
		   hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        for(int i = 0; i < k; i++) {
            maxValue = Integer.MIN_VALUE;
			for(int key : hm.keySet()) {
                if(hm.get(key) > maxValue) {
                    maxValue = hm.get(key);
                    maxKey = key;
                }
            }
           /* it = hm.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry me = (Map.Entry)it.next();
                if((int)me.getValue() > maxValue) {
                    maxValue = (int)me.getValue();
                    maxKey = (int)me.getKey();
                }
            }*/
            result.add(maxKey);
            hm.remove(maxKey);
        }
        return result;
    }
	///////////////////////////////////////////////////////////////////////
	Find the kth largest element in an unsorted array. Note that it is the kth largest 
	element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,nums.length-k,0,nums.length-1);
    }
    public int findKthLargest(int[] nums,int k, int start, int end) {
        int pivot = nums[end], left = start;
        for(int i = start; i < end; i++) {  // 
            if(nums[i] <= pivot) {
                swap(nums,left++,i);
            }
        }
        swap(nums,left,end);
        if(k == left) {
            return nums[k];
        }
        else if( k > left) {
            return findKthLargest(nums,k,left+1,end);
        }
        else {
            return findKthLargest(nums,k,start,left-1);
        }
    }
    public void swap(int[] nums, int left, int right) {
        if(left == right) return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

////////////////////////////////////////////////////////////////////////////////////
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

public String reverseVowels(String s) {
        if(s == null) {
            return s;
        }
        int left = 0, right = s.length()-1;
        char[] array = s.toCharArray();
        while(left < right) {
            while(array[left] != 'a' && array[left] != 'e' && array[left] != 'i' && array[left] != 'o' && array[left] != 'u' && array[left] != 'A' && array[left] != 'E' && array[left] != 'I' && array[left] != 'O' && array[left] != 'U' && left < right) {
                left++;
            }
            while(array[right] != 'a' && array[right] != 'e' && array[right] != 'i' && array[right] != 'o' && array[right] != 'u' && array[right] != 'A' && array[right] != 'E' && array[right] != 'I' && array[right] != 'O' && array[right] != 'U' && left < right) {
                right--;
            }
            if(left < right) {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return new String(array);
    }
//////////////////////////////////////////////////////////////////////////////////////
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
/// so start from the end because if we start from the begining then
/// there will be difficult with 10 like example 100 respresent nothing.
// now the location n index set 1 just to use in program
// now if we encounter 0 just continue and that location we be set as 0
// if we encounter any substring grater than 9 and less than 11 just add i+1 and i+2 location
// if not just copy i+1 location value;
public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int[] nums = new int[n+1];
        nums[n] = 1;
        if(s.charAt(n-1) == '0') {
            nums[n-1] = 0;
        }
        else {
            nums[n-1] = 1;
        }
        for(int i = n-2; i >= 0; i--) {
            if(s.charAt(i) == '0') continue;
            else if(Integer.parseInt(s.substring(i,i+2)) > 9 && Integer.parseInt(s.substring(i,i+2)) <= 26 ) {
                nums[i] = nums[i+1] + nums[i+2];
            } 
            else {
                nums[i] = nums[i+1];
            }
        }
        return nums[0];
	}
	/////// second solution
	public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int[] nums = new int[n];
        
        if(s.charAt(n-1) == '0') {  // if last is 0 then start with 0
            nums[n-1] = 0;
        }
        else {
            nums[n-1] = 1;   // if not 0 then put 1
        }
        if(s.length() == 1) return nums[0];  // if length == 1 just return from here otherwise outofbound error
        if(s.charAt(n-2) == '0') {  // if second last location is 0 then put 0 because 03 not right
            nums[n-2] = 0;
        }
        else if(Integer.parseInt(s.substring(n-2,n)) > 9 && Integer.parseInt(s.substring(n-2,n)) <= 26 ) {
            nums[n-2] = nums[n-1] + 1;  // if last two location together is proper than increament last one
        }
        else {
            nums[n-2] = nums[n-1]; // if not proper like 35 then put take the last one and copy
        }
        for(int i = n-3; i >= 0; i--) {  // just repeat this process for the all remaining elements
            if(s.charAt(i) == '0') continue;
            else if(Integer.parseInt(s.substring(i,i+2)) > 9 && Integer.parseInt(s.substring(i,i+2)) <= 26 ) {
                nums[i] = nums[i+1] + nums[i+2];
            } 
            else {
                nums[i] = nums[i+1];
            }
        }
        return nums[0];
    }
	//////////////////////////////////////////////////////////////////////////////////
	Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

public int[] countBits(int num) {
        if(num == 0) {
            return new int[1];
        }
        int[] result = new int[num+1];
        for(int i = 1; i <= num; i++) {
            if(i % 2 == 1) {
                result[i] = result[i/2]+1;
            }
            else {
                result[i] = result[i/2];
            }
        }
        return result;
    }
	//////////////////////////////////////////////////////////////////////////////////////
	Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

public String addBinary(String a, String b) {
        int carry = 0;
        String result ="";
        int i = a.length()-1, j = b.length()-1, l , r;
        while(i >= 0 || j >= 0 || carry != 0) {
            l = (i >= 0)?a.charAt(i--)-'0':0;  /// remember to put increment or decrement in while
            r = (j >= 0)?b.charAt(j--)-'0':0;
            if(carry == 0) {
                if(l == 0 && r == 0) {
                    result = "0"+result;
                    carry = 0;
                }
                else if(l == 1 && r == 1) {
                    result = "0"+result;
                    carry = 1;
                }
                else {
                    result = "1"+result;
                    carry = 0;
                }
            }
            else {
                if(l == 0 && r == 0) {
                    result = "1"+result;
                    carry = 0;
                }
                else if(l == 1 && r == 1) {
                    result = "1"+result;
                    carry = 1;
                }
                else {
                    result = "0"+result;
                    carry = 1;
                }
            }
            
        }
        return result;
    }
	/////////////////////////////////////////////////////////////
	Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
	/// iterative solution
	public int kthSmallest(TreeNode root, int k) {
       if(root == null) {
           return 0;
       }
       Stack<TreeNode> s = new Stack<TreeNode>();
       int count = 0;
       while(true) {
           while(root != null) {
               s.push(root);
               root = root.left;
           }
           if(s.isEmpty()) break;
           root = s.pop();
           count++;
           if(count == k) {
               return root.val;
           }
           root = root.right;
       }
       return 0;
    }
	////////////////////////////////////////////////////////////////////////////////////
	just come up with one of the solution for the post order iterative
	Stack<TreeNode> s = new Stack<TreeNode>();
	TreeNode temp;
	while(true) {
		while(root != null) {
			s.push(root);
			root = root.left;
		}
		if(s.isEmpty()) break;
		if(s.top().right == null) {
			temp = s.pop();
			if(s.top().right == temp) {
				s.pop();
			}
		}
		else {
			root = s.top().right;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////
	Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is 
defined between two nodes v and w as the lowest node in T that has both v and w 
as descendants (where we allow a node to be a descendant of itself).”
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of 
nodes 2 and 4 is 2,since a node can be a descendant of itself according to the LCA definition.

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null) return null;
       if(p.val < root.val && q.val < root.val) {
           return lowestCommonAncestor(root.left, p, q);
       }
       else if(p.val > root.val && q.val > root.val) {
           return lowestCommonAncestor(root.right, p, q);
       }
       else {
           return root;
       }
    }
	
/////////////////////////////////////////////////////////////////////////////////////////////////
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between 
two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a 
node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself 
according to the LCA definition.
////// compare root with p and q not with its value because two node can have same value
/// there is only one unique node
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q ) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return (left == null)?right:left;
        
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

public List<Integer> rightSideView(TreeNode root) {
        List<Integer> finallist = new ArrayList<Integer>();
        if(root == null) return finallist;
        TreeNode prev = null, current = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()) {
            prev = current;
            current = queue.poll();
            if(current != null) {
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            else {
                if(!queue.isEmpty()) {
                    queue.offer(null);
                }
                finallist.add(prev.val);
            }
        }
        return finallist;
    }
	//////////////////////////////////// recursive solution
	public List<Integer> rightSideView(TreeNode root) {
       List<Integer> finallist = new ArrayList<Integer>();
       helper(root, finallist,0);
       return finallist;
    }
    public void helper(TreeNode root, List<Integer> finallist, int depth) {
        if(root == null) return;
        if(depth == finallist.size()) finallist.add(root.val);
        helper(root.right, finallist, depth+1);
        helper(root.left, finallist, depth+1);
    }
	
	/////////////////////////////////////////////////////////////////////////////////////
	Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = null;
        if(root == null) return result;
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
	////////////////////////////////////////////////////////////////////////////////////
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with
 the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.

public class BSTIterator {
    Stack<TreeNode> s = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
         fillStack(root);
    }
    public void fillStack(TreeNode root) {
        while(root!= null) {
             s.push(root);
             root = root.left;
         }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!s.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = s.pop();
        if(temp.right != null) {
            fillStack(temp.right);
        }
        return temp.val;
    }
}
/////////////////////////////////////////////////////////////////////////////
Given a BST and 2 numbers a,b. Find the number of hops to reach from a to b. 

public Node LCA(Node root, Node a, Node b) {
		if(root == null) return null;
		if(a.getData() < root.getData() && b.getData() < root.getData()) {
			return LCA(root.getLeftNode(), a, b);
		}
		else if(a.getData() > root.getData() && b.getData() > root.getData()) {
			return LCA(root.getRightNode(), a, b);
		}
		else {
			return root;
		}
	}
	public int countHopes(Node root, Node a, Node b) {
		Node lca = LCA(root,a,b);
		int left = 0, right = 0;
		Node temp = lca;
		if(lca != a || lca != b) {
			while(temp != a) {
				if(a.getData() < temp.getData()) {
					temp = temp.getLeftNode();
				}
				else {
					temp = temp.getRightNode();
				}
				left++;
			}
			temp = lca;
			while(temp != b) {
				if(b.getData() < temp.getData()) {
					temp = temp.getLeftNode();
				}
				else{
					temp = temp.getRightNode();
				}
				right++;
			}
			return left+right+1;
		}
		else {
			left = 0;
			temp = (lca == a)?a:b;
			Node temp2 = (lca != a)?a:b;
			while(temp != temp2) {
				if(temp2.getData() < temp.getData()) {
					temp = temp.getLeftNode();
				}
				else {
					temp = temp.getRightNode();
				}
				left++;
			}
			return left+1;
		}
		
	}
	//////////////////////////////////////////////////////////////////////////
	remove half node from tree
	public Node removeHalfNode(Node root) {
		if(root == null) return null;
		root.setLeftNode(removeHalfNode(root.getLeftNode()));  // root.left = removeHalfNode(root.left);
		root.setRightNode(removeHalfNode(root.getRightNode()));
		if(root.getLeftNode() == null && root.getRightNode() == null) return root;
		if(root.getLeftNode() == null) return root.getRightNode();
		if(root.getRightNode() == null) return root.getLeftNode();
		return root;
	}
	//////////////////////////////////////////////////////////////////////////
	remove leaf Node
	
	public Node removeLeafNode(Node root) {
		if(root == null || (root.getLeftNode() == null && root.getRightNode()== null)) return null;
		root.setLeftNode(removeLeafNode(root.getLeftNode()));
		root.setRightNode(removeLeafNode(root.getRightNode()));
		return root;
	}
	/////////////////////////////////////////////////////////////////////////////////
	
	remove the Node which is out of range 
	
	public Node removeNodeInRange(Node root, int a, int b) {
		if(root == null) return null;
		root.setLeftNode(removeNodeInRange(root.getLeftNode(),a,b));
		root.setRightNode(removeNodeInRange(root.getRightNode(),a,b));
		if(root.getData() < a) return root.getRightNode();
		if(root.getData() > b) return root.getLeftNode();
		return root;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

best solution 

public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, secondHead = head.next;
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = secondHead;
        return head;
    }
	////////////////////// another solution
public ListNode oddEvenList(ListNode head) {
       if(head == null || head.next == null) return head;
       ListNode temp = head, last = null, prev = null;
       int l = 0;
       while(temp != null) {
           last = temp;
           temp = temp.next;
           l++;
       }
       int i = 1;
       temp = head;
       while(i <= l) {
           if(i % 2 == 0) {
               last.next = prev.next;
               last = last.next;
               prev.next = temp.next;
               prev = temp;
               temp = temp.next;
               last.next = null;
               
           }
           else {
                prev = temp;
                temp = temp.next;
           }
           i++;
       }
       return head;
    }
	/////////////////solution 2-
	public ListNode oddEvenList(ListNode head) {
       if(head == null || head.next == null) return head;
       ListNode fakeHead = new ListNode(0);
       ListNode temp = head, temp1 = null, ftemp = fakeHead, prev = null;
       while(temp!= null && temp.next!= null) {
           temp1 = temp.next;
           temp.next = temp.next.next;
           ftemp.next = temp1;
           ftemp = ftemp.next;
           ftemp.next = null;
           prev = temp;
           temp = temp.next;
       }
       if(temp != null) {
           temp.next = fakeHead.next;
       }
       else {
           prev.next = fakeHead.next;
       }
       return head;
    }
    ////////////////////////////////////////////////////////////////////////////
	in an string shift all the spaces to the left side 
	"a bc d e"   becomes    |   abcde|
	
	public static String shiftSpaceLast(String s) {
		char[] array = s.toCharArray();
		int i = s.length()-1, j = s.length()-1;
		char temp;
		for(;i >= 0; i--)  {
			if(array[i] != ' ') {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j--;
			}
		}
		return new String(array);
	}
	////////////////////////////////////////////////////////////////////////////
	in an string shift all the spaces to the right side 
	"a bc d e"   becomes    |abcde   |
	
	public static String shiftSpace(String s) {
		char[] array = s.toCharArray();
		int i = 0, j = 0;
		char temp;
		for(i = 0; i < s.length(); i++)  {
			if(array[i] != ' ') {
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				j++;
 			}
		}
		return new String(array);
	}
	/////////////////////////////////////////////////////////////////////////
	separeate negative and positive elements in array and preseve relative positions
	-5,3,2,-1,4,-8,0    becomes   -5 -1 -8 3 4 2 0 
	
	
	public static void separateNevPos(int[] array) {
		int i = 0, j = 0;
		int temp;
		for(; i < array.length; i++) {
			if(array[i] < 0) {
				if(i != j) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				j++;
			}
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////
	separe array based on the provided element
	
	-5,3,2,-1,4,-8,0    -1    becomes  -5 -8 -1 0 4 3 2 
	
	public static void separate(int[] array, int a)  {
		int i,j;
		for(i = 0; i < array.length; i++) {
			if(array[i]== a) {
				break;
			}
		}
		int temp = array[i];
		array[i] = array[array.length-1];
		array[array.length-1] = temp;
		i = 0;
		j = 0;
		for(;i < array.length-1; i++) {
			if(array[i] < array[array.length-1]) {
				if(i != j ) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				j++;
			}
			
		}
		temp = array[j];
		array[j] = array[array.length-1];
		array[array.length-1] = temp;
	}
	////////////////////////////////////////////////////////////
	shuffle the cards 
	
	1,2,3,4,5,6,7,8
	
	becomes 
	
	5 2 7 8 4 3 6 1 
	2 7 8 4 5 1 6 3 
	
	public static void suffleIt(int[] array) {
		int r, temp;
		for(int i = 0; i < array.length; i++) {
			r = i + (int)(Math.random()*(array.length-i));
			temp = array[i];
			array[i] = array[r];
			array[r] = temp;
		}
	}
	////////////////////////////////////////////////////////////////
	count 1 bit in the number usint bitwise operator
	
	99 - 4
	
	public static int count1(int n) {
		int count = 0;
		while(n != 0) {
			count += n & 1;
			n >>= 1;
		}
		return count;
	}
	/////////////////////////////////////////////////////////////////
	Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see 
below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.

Avoid the spaces in the starting
consider there can be + or - sign in the start
consider overflow condition for integer

public int myAtoi(String str) {
        if(str.length() == 0 ) return 0;
        int index = 0,sign = 1,num = 0; // set sign as 1
        while(str.charAt(index) == ' ') index++;  /// if space in start just inc index
        if(str.charAt(index) == '+' || str.charAt(index) =='-') { // if + or - is there set sign
            sign = (str.charAt(index) == '+')?1:-1;
            index++;
        } 
        while(index < str.length() ) {  //
            if(str.charAt(index)-'0' < 0 || str.charAt(index)-'0' > 9 ) break; // if any other character than break the process
            if(num > Integer.MAX_VALUE/10 || num == Integer.MAX_VALUE/10 && str.charAt(index)-'0'>Integer.MAX_VALUE%10) {
                return (sign == 1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            } // this is for overflow (/10) because we are multiplying after this so check before multiplication
		
            num = 10*num + (str.charAt(index)-'0');
            index++;
        }
        return num*sign;
        
    }
	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	Find the sub string in the provided string in the time complexity of O(n+m) 
	where n = size of string m = size of substring
	
	KMP algorithm
	
	public static boolean isExistSubString(char[] string, char[] pattern) {
		int[] pat = prefixArrayCreation(pattern);  // create prefix array for calculation
		int i = 0, j = 0;
		while(i < string.length) {
			if(string[i] == pattern[j]) { 
				i++;
				j++;				
			}
			else {
				if(j == 0) {
					i++;
				}
				else {
					j = pat[j-1];
				}
			}
			if(j == pattern.length) return true;
		}
		return false;
	}
	public static int[] prefixArrayCreation(char[] pattern) {
		int j = 0, i = 1;
		int[] result = new int[pattern.length];
		while(i < pattern.length) {
			if(pattern[i] == pattern[j]) {
				result[i] = j + 1;
				i++;
				j++;
			}
			else {
				if(j == 0)  i++;
				else {
					j = result[j-1];
				}
			}
		}
		return result;
	}
	////////////////////////////////////////////////////////////////////////////////////
Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
(also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
so the function should return 3.
>> - used with signed number and fill the left most position with signed bits
>>> - used with unsigned number and fill the left most position always with 0

public int hammingWeight(int n) {
        if(n == 0) return 0;
        int count = 0;
        while(n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

//////////////////////////////////////////////////////////////////////////////////////////////
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

public int reverseBits(int n) {
        if(n == 0) return 0;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res = (res<<1)|(n&1);
            n >>>=1;
        }
        return res;
    }
/////////////////////////////////////////////////////////////////////////////////////////////
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head, newHead;
        boolean flag = true;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverse(slow.next);
        newHead = slow.next;
        while(newHead != null) {
            if(head.val != newHead.val) flag = false;
            head = head.next;
            newHead = newHead.next;
        }
        slow.next = reverse(slow.next);
        return flag;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null, temp = null;
        while(head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }	
	////////////////////////////////////////////////////////////////////////////////////////
	Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 
case 1 : consider the val is first element in that case we need fakeHead
///////////////////// recursive 
public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        head.next = removeElements(head.next,val);
        return (head.val==val)?head.next:head;
    }
/////////////////////iterative

//// easy one 

public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head != null && head.val == val) head = head.next;
        ListNode temp = head;
        while(temp != null && temp.next != null) {
            if(temp.next.val == val) temp.next = temp.next.next;
            else  temp = temp.next;
        }
        return head;
    }
	//////////// another one
public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        while(head != null) {
            if(head.val == val) {
                prev.next = head.next;
                head = head.next;
            }
            else {
                prev = head;
                head = head.next;
            }
        }
        return fakeHead.next;
    }
	
	/////////////////////////////////////////////////////////////////////////////////////////
	Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.

public int removeElement(int[] nums, int val) {
        int ptr = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[ptr++] = nums[i];
            }
        }
        return ptr;
    }
	
//////////////////////////////////////////////////////////////////////////////////////////////
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums 
being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 
//////////////////// optimised solution // compare with j not with i
public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(j < 1 || nums[i] > nums[j-1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
////////////////////////////// another one...
public int removeDuplicates(int[] nums) {
        int ptr = 0, i = 0;
        while(i < nums.length) {
            nums[ptr++] = nums[i++];
            while(i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return ptr;
    }
//////////////////////////////////////////////////////////////////////////////////////////////

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 
1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
///////////////////// optimise solution 

public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(j < 2 || nums[i] > nums[j-2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
	/////////////////////// another one......
public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int i = 0, j = 0;
        boolean flag = false;
        while(i < nums.length) {
            nums[j++] = nums[i++];
            while(i < nums.length && nums[i] == nums[i-1] && flag) i++;
            if(i < nums.length && nums[i] == nums[i-1]) flag = true;
            else flag = false;
        }
        return j;
    }
	
//////////////////////////////////////////////////////////////////////////////////////////////
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

	///////// optimized code
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        boolean flag1 = false, flag2 = false;
        ListNode ptr1 = headA, ptr2 = headB;
        while(ptr1 != ptr2) {
            ptr1 = (ptr1 == null)?headB:ptr1.next;
            ptr2 = (ptr2 == null)?headA:ptr2.next;
            if(ptr1 == ptr2) break;
            if(flag1 && flag2 && ptr1 == headB) return null;
            if(ptr1 == headB) flag1 = true;
            if(ptr2 == headA) flag2 = true;
            
        }
        return ptr1;
    }
	//////////////// another length
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int nA = length(headA);
        int nB = length(headB);
        int diff = Math.abs(nA-nB);
        if(nA > nB) {
            while(diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        else {
            while(diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while(headA != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    public int length(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
//////////////////////////////////////////////////////////////////////////////////////////////
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
	
//////////////////////////////////////////////////////////////////////////////////////////////
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        boolean flag = false;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                flag = true;
                break;
            }
        }
        if(flag) {
            slow = head;
            while(slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
///////////////////////////////////////////////////////////////////////////////////

partition the likedlist and collect all less one side and all grater on another side

if that element is exit in list one or more time it will work

public ListNode partition(ListNode head, int x) {
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        ListNode fakeHead3 = new ListNode(0);
        if(head == null) return null;
        ListNode temp1 = fakeHead1, temp2 = fakeHead2,temp3 = fakeHead3, cur = null, finalHead = null;
        while(head != null) {
            if(head.val < x) {
                temp1.next = head;
                temp1 = temp1.next;
                head = head.next;
                temp1.next = null;
            }
            else if(head.val > x) {
                temp2.next = head;
                temp2 = temp2.next;
                head = head.next;
                temp2.next = null;
            }
            else {
                temp3.next = head;
                temp3 = temp3.next;
                head = head.next;
                temp3.next = null;
            }
        }
        if(temp1 != fakeHead1) {
            if(temp3 != fakeHead3) {
                temp1.next = fakeHead3.next;
                while(temp1.next != null) temp1 = temp1.next;
                temp1.next = fakeHead2.next;
            }
            else {
                temp1.next = fakeHead2.next;
            }
            finalHead = fakeHead1.next;
        }
        else {
            if(temp3 != fakeHead3) {
                finalHead = fakeHead3.next;
                while(temp3.next != null) temp3 = temp3.next;
                temp3.next = fakeHead2.next;
            }
            else {
               finalHead = fakeHead2.next;
            }
        }
        return finalHead;
    }
////////////////////////////////////////////////////////////////////////////////////////
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5. 

public ListNode partition(ListNode head, int x) {
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead3 = new ListNode(0);
        if(head == null) return null;
        ListNode temp1 = fakeHead1,temp3 = fakeHead3,finalHead = null;
        while(head != null) {
            if(head.val < x) {
                temp1.next = head;
                temp1 = temp1.next;
                head = head.next;
                temp1.next = null;
            }
            else {
                temp3.next = head;
                temp3 = temp3.next;
                head = head.next;
                temp3.next = null;
            }
        }
        if(temp1 != fakeHead1) {
            temp1.next = fakeHead3.next;
            finalHead = fakeHead1.next;
        }
        else {
            finalHead = fakeHead3.next;
        }
        return finalHead;
    }
//////////////////////////////////////////////////////////////////////////////////////////////
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode fakeHead = new ListNode(0);
        ListNode temp = fakeHead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
                temp.next = null;
            }
            else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
                temp.next = null;
            }
        }
        if(l1 != null) temp.next = l1;
        if(l2 != null) temp.next = l2;
        return fakeHead.next;
    }
	////// recurrsion 
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode newNode;
        if(l1.val < l2.val) {
            newNode = l1;
            newNode.next = mergeTwoLists(l1.next,l2);
        }
        else {
            newNode = l2;
            newNode.next = mergeTwoLists(l1,l2.next);
        }
        return newNode;
    }
////////////////////////////////////////////////////////////////////////////////////////////
Sort a linked list using insertion sort.

public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead, cur = head, next = null;
        while(cur != null) {
            next = cur.next;
            while(prev.next != null && prev.next.val < cur.val) {
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            prev = fakeHead;
            cur = next;
        }
        return fakeHead.next;
    }
	////////////////////////////////////////////////////////////////////////////////////
	
	sort a linked list merge sort 
	
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, head2 = null;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        head2 = slow.next;
        slow.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        head = merge(head,head2);
        return head;
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode fakeNode = new ListNode(0);
        ListNode temp = fakeNode;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;                
            }
            else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) temp.next = head1;
        if(head2 != null) temp.next = head2;
        return fakeNode.next;
    }
	////////////////////////////////////////////////////////////////////////
	pangram
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] array = new int[26];
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean flag = true;
        int i = 0;
        while(i < str.length()) {
            if(str.charAt(i)-'A' >= 0 && str.charAt(i)-'A' <= 25) array[str.charAt(i)-'A']++;
            if(str.charAt(i)-'a' >= 0 && str.charAt(i)-'a' <= 25) array[str.charAt(i)-'a']++;
            i++;
        }
        for(int j = 0; j < array.length; j++) {
            if(array[j] == 0) {                
                flag = false;
            }
        }
        if(flag) System.out.println("pangram");
        else System.out.println("not pangram");   
        
        
    }
	////////////////////////////////////////////////////////////////////////////////////////
	Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> al = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++) hs.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++) {
            if(hs.contains(nums2[i])) al.add(nums2[i]);
        }
        return al.stream().mapToInt(i->i).toArray();
    }
	///////////////////////////////////////////////////////////////////////////////////
	remove dublicate from an array 
	
	return Arrays.stream(nums1).distinct().toArray();
	////////////////////////////////////////////////////////////////////////////////////
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[2];
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(hm.containsKey(target-nums[i])) {
                result[0] = hm.get(target-nums[i]);
                result[1] = i;
                break;
            }
            if(!hm.containsKey(nums[i])) hm.put(nums[i],i);
        }
        return result;
        
    }
	///////////////////////////////////////////////////////////////////////////////////////////
	Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

public int reverse(int x) {
        int result = 0;
        String s = x+"";
        int sign = 1, range = 0;
        if(s.charAt(0) == '-') {
            sign = -1;
            range++;
        }
        for(int i = s.length()-1; i>=range; i--) {
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && s.charAt(i)-'0'>Integer.MAX_VALUE%10)) {
                return 0;
            }
            result = 10*result + s.charAt(i)-'0';
        }
        return result*sign;
    }
	//////////////////////////////////////////////////////////////////////////////////////////////
	Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
////////////////////////  optimized ////////////////////////////////
public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, len = Integer.MAX_VALUE;
        while(end < nums.length) {
            while(end < nums.length && sum < s) {
                sum +=nums[end++];
            }
            if(sum < s) break;
            while(start < end && sum >= s) {
                sum -= nums[start++];
            }
            if(end - start + 1 < len) len = end - start + 1;
        }
        return (len == Integer.MAX_VALUE)?0:len;
    }
	///////////////////// another //////////////////////////
public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0, sum = 0, len = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<Integer>();
        while(i < nums.length) {
            while(i < nums.length && sum < s) {
                q.add(nums[i]);
                sum = sum + nums[i];
                i++;
            }
            if(i == nums.length && sum < s) break;
            if(q.size() < len) {
                len = q.size();
            }
            while(!q.isEmpty() && sum >= s) {
                sum = sum - q.remove();
            }
            if(q.size()+1 < len) {
                len = q.size()+1;
            }
        }
        if(len == Integer.MAX_VALUE) return 0;
        else return len;
    }
	/////////////////////////////////////////////////////////////////////////
	Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if(sum > maxSum) maxSum = sum; // write this befor sum < 0 because it will help with -1 is only element
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 
are m and n respectively.

public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while(i >= 0) nums1[k--] = nums1[i--];
        while(j >= 0) nums1[k--] = nums2[j--];
    }
////////////////////////////////////////////////////////////////////////////////////////
152. Maximum Product Subarray 
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6. 

public int maxProduct(int[] nums) {
       int min = nums[0], max = nums[0], result = nums[0], temp;
       for(int i = 1; i < nums.length; i++) {
           temp = max;
           max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
           min = Math.min(Math.min(temp*nums[i], min*nums[i]),nums[i]);
           if(max > result) result = max;
       }
       return result;
    }
////////////////////////////////////////////////////////////////////////////////////////////
44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
///// 1. if we hit match or ? just take diagonal value;
///// 2. if we hit * and left and above if true set true or set false;
///// 3. if doen't match set false;
public boolean isMatch(String s, String p) {
        boolean[][] array = new boolean[s.length()+1][p.length()+1];
        array[0][0] = true;
        for(int j = 1; j <= p.length(); j++) {
            if(p.charAt(j-1) != '*') array[0][j] = false;
            else array[0][j] = (array[0][j-1] == true)?true:false;
        }
        for(int i = 1; i <= s.length(); i++) {
            array[i][0] = false;
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') array[i][j] = array[i-1][j-1];
                else if(p.charAt(j-1) == '*') array[i][j] = array[i-1][j] || array[i][j-1];
                else array[i][j] = false;
            }
        }
        return array[s.length()][p.length()];
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finallist = new ArrayList<List<Integer>>();
        if(nums.length == 0) {
            List<Integer> newlist = new ArrayList<Integer>();
            finallist.add(newlist);
            return finallist;
        }
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++) count[i] = 1;
        Integer[] result = new Integer[nums.length];
        combination(nums, count, result, 0, finallist);
        return finallist;
    }
    public void combination(int[] nums, int[] count,Integer[] result, int level, List<List<Integer>> finallist) {
        if(level == nums.length) {
            List<Integer> newlist = new ArrayList<Integer>(Arrays.asList(result));
            finallist.add(newlist);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(count[i] == 0) continue;
            result[level] = nums[i];
            count[i]--;
            combination(nums,count,result,level+1,finallist);
            count[i]++;
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> finallist = new ArrayList<List<Integer>>();
        if(nums.length == 0) {
            List<Integer> newlist = new ArrayList<Integer>();
            finallist.add(newlist);
            return finallist;
        }
        TreeMap<Integer,Integer> hm = new TreeMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int[] newnums = new int[hm.size()];
        int[] count = new int[hm.size()];
        int j = 0;
        for(Integer key : hm.keySet()) {
            newnums[j] = key;
            count[j] = hm.get(key);
            j++;
        }
        Integer[] result = new Integer[nums.length];
        combination(newnums, count, result, 0, finallist);
        return finallist;
    }
    public void combination(int[] nums, int[] count,Integer[] result, int level, List<List<Integer>> finallist) {
        if(level == result.length) {
            List<Integer> newlist = new ArrayList<Integer>(Arrays.asList(result));
            finallist.add(newlist);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(count[i] == 0) continue;
            result[level] = nums[i];
            count[i]--;
            combination(nums,count,result,level+1,finallist);
            count[i]++;
        }
    }
	/////////////////////////////////////////////////////////////////////////////
	273. Integer to English Words
	Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

	
	//////////////////////// optimized version
	public class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num); 
    }

    private String helper(int num) {
        String result = new String();
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num -10];
        else if (num < 100) result = belowHundred[num/10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
	//////////////////////////////////////////////////
For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//// in the first place write code for singles, doubles and tens
//// second tens and third again singles
//// again for first - right code for extra
//// use trim in the loop as well as last
///  count with go from 0 to 2 and again go to 0
/// p will start with 0 and go ahead
public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String result = "";
        String[] singles = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] doubles = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] extra ={"","Thousand","Million","Billion","Trillian"};
        int count = 0, p = 0;
        String s = String.valueOf(num);
        for(int i = s.length()-1; i>=0; i--){
            if(count == 0) {
                if(p != 0 && (s.charAt(i) != '0' ||i>=1 && s.charAt(i-1) != '0' || i>=2 && s.charAt(i-2) != '0')) {
                    result = extra[p]+" "+result;
                }
                if(s.charAt(i)!='0' && i > 0 && s.charAt(i-1)=='1') {
                    result = doubles[s.charAt(i)-'0'] + " "+result;
                    i--;
                    count++;
                }
                else if(s.charAt(i) == '0') {
                    i--;
                    count++;
                    if(i >= 0 && s.charAt(i) != '0') {
                        result = tens[s.charAt(i)-'0']+ " "+result;
                    }
                }
                else if(s.charAt(i) != '0') {
                    result = singles[s.charAt(i)-'0']+" "+result;
                }
                count++;
            }
            else if(count == 1) {
                if(s.charAt(i) != '0') {
                    result = tens[s.charAt(i)-'0'] + " "+result;
                }
                count++;
            }
            else if(count == 2) {
                if(s.charAt(i) != '0') {
                    result = singles[s.charAt(i)-'0']+ " " + "Hundred" +" "+result;
                }
                count = 0;
                p++;
            }
            result.trim();
        }
        return result.trim();
    }
	//////////////////////////////////////////////////////////////////////////////////////////
	Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int val;
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums1.length; i++) {
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(hm.containsKey(nums2[i])) {
                val = hm.get(nums2[i]);
                al.add(nums2[i]);
                val--;
                if(val == 0) {
                    hm.remove(nums2[i]);
                }
                else {
                    hm.put(nums2[i],val);
                }
            }
        }
        return al.stream().mapToInt(i->i).toArray();
    }
/////////////////////////////////////////////////////////////////////////////////////////////
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int i = 0, j = 0, temp;
        for(;i < nums.length; i++) {
            if(nums[i] != 0) {
                temp = nums[j];
                nums[j]= nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
106. Construct Binary Tree from Inorder and Postorder Traversal 

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
/// postorder start from the end of the postorder that is the root node
/// right of the node will set first and that will be between inindex+1 and end
	int postindex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postindex = postorder.length-1;
        int start = 0, end = inorder.length-1;
        return helper(inorder, postorder,start,end);
    }
    public TreeNode helper(int[] inorder,int[] postorder, int start, int end) {
        if(start > end) return null;
        TreeNode newNode = new TreeNode(postorder[this.postindex]);
        int inindex = find(postorder[this.postindex],inorder,start,end);
        this.postindex--;
        newNode.right = helper(inorder,postorder,inindex+1,end);
        newNode.left = helper(inorder,postorder,start,inindex-1);
        return newNode;
    }
    public int find(int item,int[] inorder, int start, int end) {
        for(int i = start; i <= end; i++) {
            if(item == inorder[i]) {
                return i;
            }
        }
        return 0;
    }
	/////////////////////////////////////////////////////////////////////////////////////////////////
	Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
///// optimized with hashmap
int postindex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postindex = postorder.length-1;
        int start = 0, end = inorder.length-1;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i],i);
        }
        return helper(inorder, postorder,start,end,hm);
    }
    public TreeNode helper(int[] inorder,int[] postorder, int start, int end,HashMap<Integer,Integer> hm) {
        if(start > end) return null;
        TreeNode newNode = new TreeNode(postorder[this.postindex]);
        int inindex = hm.get(postorder[this.postindex]);
        this.postindex--;
        newNode.right = helper(inorder,postorder,inindex+1,end,hm);
        newNode.left = helper(inorder,postorder,start,inindex-1,hm);
        return newNode;
    }
///////////////////////////////// another solution
int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int start = 0, end = inorder.length-1;
        return helper(preorder,inorder,start,end);
    }
    public TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) return null;
        TreeNode newNode = new TreeNode(preorder[this.preindex]);
        int inindex = find(preorder[this.preindex],inorder,start,end);
        this.preindex++;
        newNode.left = helper(preorder,inorder,start,inindex-1);
        newNode.right = helper(preorder,inorder,inindex+1,end);
        return newNode;
    }
    public int find(int item, int[] inorder,int start,int end) {
        for(int i = start; i <= end; i++) {
            if(item == inorder[i]) return i;
        }
        return -1;
    }
	////////////////////////////////////////////////////////////////////////////////////////
	Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
	
	public String convertToTitle(int n) {
        String result = "";
        while(n != 0) {
            char ch = (char)((n-1) % 26 + 'A');
            n = (n-1)/26;
            result = ch+result;
        }
        return result;
    }
	//////////////////////////////////////////////////////////////////////////////////////////
	Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
	public int titleToNumber(String s) {
        int i = s.length()-1, p = 1, result = 0,n;
        for(;i>=0;i--) {
            n = (s.charAt(i)-'A')+1;
            n = n * p;
            p *= 26;
            result +=n;
        }
        return result;
    }
	/////////////////////////////////////////////////////////////////////////////////////////////
	Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:

public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
	///////////////////////////////////////////////////////////////////////////////////////////
	100. Same Tree 
	Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the 
same value.
public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        if(!left || !right) return false;
        return true;
    }
	/////////////////////////////////////////////////////////////////////////////////////////////
292. Nim Game 

 You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend. 

public boolean canWinNim(int n) {
        return (n%4 != 0);
    }
////////////////////////////////////////////////////////////////////////////////////////////////
258. Add Digits
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime? 

public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 != 0) return num%9;
        else return 9;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
202. Happy Number

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
/// if the sigle digit is 1 or 7 only in that case we have the happy number.
 public boolean isHappy(int n) {
        if(n == 0) return false;
        if(n == 1 || n == 7) return true;
        while(true){
            n = calculate(n);
            if(n / 10 == 0) {
                return (n == 1 || n == 7);
            }
        }
    }
    public int calculate(int n) {
        int sum = 0;
        while(n != 0) {
            sum +=(n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
217. Contains Duplicate 

public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n:nums) {
            if(!set.add(n)) return true;
        }
        return false;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
220. Contains Duplicate III

Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the difference between nums[i] and nums[j] is at most t and the difference between i and j 
is at most k. 

public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int ws = t + 1,id;
        for(int i = 0; i < nums.length; i++) {
            id = getId(nums[i],ws);
            if(hm.containsKey(id)) return true;
            if(hm.containsKey(id-1) && Math.abs(nums[i]-hm.get(id-1)) < ws) return true;
            if(hm.containsKey(id+1) && Math.abs(nums[i]-hm.get(id+1)) < ws) return true;
            hm.put(id,nums[i]);
            if(i >= k) hm.remove((int)nums[i-k]/ws);
        }
        return false;
    }
    public int getId(int n, int ws) {
        return(n < 0)?(n+1)/ws-1:n/ws;
    }
////////////////////////////////////////////////////////////////////////////////////////////////
169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

public int majorityElement(int[] nums) {
        int temp = nums[0],count = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == temp) count++;
            else {
                count--;
                if(count == 0) {
                    temp = nums[i];
                    count = 1;
                }
            }
        }
        return temp;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
13. Roman to Integer

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> jo = new HashMap<>();
        jo.put('I',1);
        jo.put('V',5);
        jo.put('X',10);
        jo.put('L',50);
        jo.put('C',100);
        jo.put('D',500);
        jo.put('M',1000);
        int i = s.length()-1, prev = jo.get(s.charAt(i--)), current,sum = prev;
        for(;i>=0;i--) {
            current = jo.get(s.charAt(i));
            if(current < prev) sum -= current;
            else sum += current;
            prev = current;
        }
        return sum;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
12. Integer to Roman 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
//////////////// optimized solution 
public String intToRoman(int num) {
        String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] C ={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] M = {"","M","MM","MMM"};
        return M[num/1000]+C[(num%1000)/100]+X[(num%100)/10]+I[(num%10)];
    }
	
	////// my solution working
public String intToRoman(int num) {
        String result = "";
        if(num <= 0) return result;
        String[] array = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(1,"I");
        hm.put(5,"V");
        hm.put(10,"X");
        hm.put(50,"L");
        hm.put(100,"C");
        hm.put(500,"D");
        hm.put(1000,"M");
        int p = String.valueOf(num).length(), digit;
        p = (int)Math.pow(10,p-1);
        while(p != 1) {
            digit = num % p;
            if(hm.containsKey(num-digit)) result = result + hm.get(num-digit);
            else result = result + findString(num-digit,array,hm);
            num = digit;
            p = p / 10;
        }
        return result + array[num];
    }
    public String findString(int n, String[] array, HashMap<Integer,String> hm) {
        String result = "";
        if(n <= 0) return result;
        while(true) {
            if(hm.containsKey(n)) {
                return hm.get(n)+result;
            }
            if(n < 50) {
                if(n <= 30) {
                    result = "X"+result;
                    n -= 10;
                }
                else return "XL"+result;
            }
            else if(n < 100) {
                if( n < 90) {
                    result = "X" + result;
                    n -= 10;
                }
                else return "XC" + result;
            }
            else if(n < 500) {
                if(n < 400) {
                    result = "C" + result;
                    n -= 100;
                }
                else return "CD"+result;
            }
            else if(n < 1000) {
                if(n < 900) {
                    result = "C" + result;
                    n -= 100;
                }
                else return "CM"+result;
            }
            else {
                result = "M"+result;
                n = n - 1000;
            }
        }
        
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory? 

public int singleNumber(int[] nums) {
        int x = 0;
        for(int n : nums) {
            x = x ^ n;
        }
        return x;
    }
	
//////////////////////////////////////////////////////////////////////////////////////////////////
260. Single Number III

 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

	
	public int[] singleNumber(int[] nums) {
        int[] result = {0,0};
        int x = 0,set;
        for(int n: nums) x ^=n;
        x &= -x;  // x &= ~(x-1);
        for(int n: nums) {
            if((n & x) == 0) result[0]^=n;
            else result[1]^=n;
        }
        return result;
    }
	///////////////////////////////////////////////////////////////////////////////////////////////
	137. Single Number II
	
	Given an array of integers, every element appears three times except for one. Find that single one. 
	
	public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int n : nums) {
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }
        return ones;
    }
	////////////////////////////////////////////////////////////////////////////////////////////
	268. Missing Number
	
	 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2. 

public int missingNumber(int[] nums) {
        int x = 0,i;
        for(i = 0; i < nums.length; i++) {
            x ^= i;
            x ^= nums[i];
        }
        return x^i;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
187. Repeated DNA Sequences

 All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].


public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        for(int i = 0; i <= s.length()-10; i++) {
            if(!set.add(s.substring(i,i+10))) result.add(s.substring(i,i+10));
        }
        return new ArrayList<String>(result);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(true) {
            while(root != null) {
                s.push(root);
                result.add(root.val);
                root = root.left;
            }
            if(s.isEmpty()) return result;
            root = s.pop();
            root = root.right;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////
198. House Robber

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
each of them is that adjacent houses have security system connected and it will automatically contact 
the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
///////////////////// optimized 

public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0],nums[1]),temp;
        for(int i = 2; i < nums.length; i++) {
            temp = Math.max(prev2,nums[i]+prev1);
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }
	///// another solution
public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] array = new int[nums.length];
        array[0] = nums[0];
        array[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i++) {
            array[i] = Math.max(array[i-1],nums[i]+array[i-2]);
        }
        return array[nums.length-1];
    }
//////////////////////////////////////////////////////////////////////////////////////////
213. House Robber II

Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, the security system for these 
houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));
    }
    public int helper(int[] nums,int left,int right) {
        if(left == right) return nums[left];
        int prev1 = nums[left++], prev2 = Math.max(prev1,nums[left++]), temp;
        for(int i = left; i <= right; i++) {
            temp = Math.max(prev2, nums[i]+prev1);
            prev1 = prev2;
            prev2 = temp;
        }
        return prev2;
    }
	
////////////////////////////////////////////////////////////////////////////////////////////////
337. House Robber III

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.


public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0],result[1]);
    }
    public int[] helper(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;                                  
    }
///////////////////////////////////////////////////////////////////////////////////////////////////
232. Implement Queue using Stacks

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
//////////////////// optimized
class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if(s2.isEmpty()) while(!s1.isEmpty()) s2.push(s1.pop());
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (s1.isEmpty() && s2.isEmpty());
    }
}
/////////////////////// another
class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s1.isEmpty()) s2.push(s1.pop());
        s2.pop();
        while(!s2.isEmpty()) s1.push(s2.pop());
    }

    // Get the front element.
    public int peek() {
        while(!s1.isEmpty()) s2.push(s1.pop());
        int temp = s2.peek();
        while(!s2.isEmpty()) s1.push(s2.pop());
        return temp;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (s1.isEmpty());
    }
}
////////////////////////////////////////////////////////////////////////////////////////

107. Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        List<Integer> current = new ArrayList<Integer>();
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp != null) {
                current.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            else {
                result.add(0,current);
                current = new ArrayList<Integer>(); /// clear is not working better create new list
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return result;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
   
 public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return (helper(root1.left,root2.right) && helper(root1.right,root2.left));
    }
//////////iterative
public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()) {
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            q.offer(node1.left);
            q.offer(node2.right);
            q.offer(node1.right);
            q.offer(node2.left);
        }
        return true;
    }
/////////////////////////////////////////////////////////////////////////////////
66. Plus One

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

public int[] plusOne(int[] digits) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int carray = 1;
        for(int i = digits.length-1;i>=0;i--) {
            int sum = digits[i]+carray;
            al.add(0,sum%10);
            carray = sum/10;
        }
        if(carray != 0) al.add(0,carray);
        return al.stream().mapToInt(i->i).toArray();
    }
///////////////////////////////////////////////////////////////////////////////////////////
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            count = count + (n/5);
            n = n / 5;
        }
        return count;
    }
//////////////////////////////////////////////////////////////////////////////////////////
58. Length of Last Word

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,
Given s = "Hello World",
return 5. 

public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
///////////////////////////////////////////////////////////////////////////////////////////////
102. Binary Tree Level Order Traversal 

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> al = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp != null) {
                al.add(temp.val);
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            else {
                result.add(al);
                al = new ArrayList<Integer>();
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return result;
    }
///////////////////////////////////////////////////////////////////////////////////////////////
238. Product of Array Except Self

 Given an array of n integers where n > 1, nums, return an array output such that output[i] is 
 equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra 
space for the purpose of space complexity analysis.)


public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        int p = nums[0];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }
        p = nums[nums.length-1];
        for(int i = nums.length-2; i>=0; i--) {
            result[i] *= p;
            p *= nums[i];
        }
        return result;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
139. Word Break

 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 

public boolean wordBreak(String s, Set<String> wordDict) {
        if(s.length() == 0) return false;
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(flag[j] && wordDict.contains(s.substring(j,i))) {
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////

331. Verify Preorder Serialization of a Binary Tree

One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #

For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
///////////////////////////////// optimized 
Some used stack. Some used the depth of a stack. Here I use a different perspective. In a binary tree, if we consider null as leaves, then

    all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
    all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

Suppose we try to build this tree. During building, we record the difference between out degree and in degree diff = outdegree - indegree. When the next node comes, we then decrease diff by 1, because the node provides an in degree. If the node is not null, we increase diff by 2, because it provides two out degrees. If a serialization is correct, diff should never be negative and diff will be zero when finished.

public boolean isValidSerialization(String preorder) {
        int diff = 1;
        String[] array = preorder.split(",");
        for(String s: array) {
            diff--;
            if(diff < 0) return false;
            if(!s.equals("#")) diff+=2;
        }
        return (diff == 0);
    }
/////////////////////// another
public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return false;
        if(preorder.length() == 1 && preorder.charAt(0)=='#') return true;/// if input is "#" then only return true;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        while(i < preorder.length()) {
            if(preorder.charAt(i) == ',') i++;  /// if comma just go to next
            else if(Character.isDigit(preorder.charAt(i))) {
                while(i < preorder.length() && Character.isDigit(preorder.charAt(i)))i++; // create number from digit
                s.push(2);  // for every number add 2 into the stack. because there should be two children.
            }
            else if(preorder.charAt(i) == '#') {  
                if(!s.isEmpty()) s.push(s.pop()-1);   /// if we hit # just decrease 1 from the top element 
                else return false;                    /// if we hit # and stack is empty just return false;
                while(!s.isEmpty() && s.peek() == 0) {  // if top of stack become 0 then remove it and also decrease 1 from top
                    s.pop();                           // continue this process till we get 1 at the top of the stack or empty stack
                    if(!s.isEmpty()) s.push(s.pop()-1);
                }
                if(i < preorder.length()-1 && s.isEmpty()) return false;  // stack only get empty at the last point 
                i++;                                      /// if it happens before just return false;
            }
            else return false;
        }
        return (s.isEmpty());
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
150. Evaluate Reverse Polish Notation 

 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

  
  public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> s = new Stack<Integer>();
        for(String token: tokens) {
            if(Character.isDigit(token.charAt(token.length()-1))) {
                s.push(Integer.parseInt(token));
            }
            else {
                int n2 = s.pop();
                int n1 = s.pop();
                switch(token) {
                    case "+" : s.push(n1+n2); break;
                    case "-" : s.push(n1-n2); break;
                    case "*" : s.push(n1*n2); break;
                    case "/" : s.push((int)n1/n2); break;
                }
            }
        }
        return s.pop();
    }  
///////////////////////////////////////////////////////////////////////////////////////////////////////
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        for(int i = 1; i < grid.length; i++) grid[i][0] = grid[i-1][0]+grid[i][0];
        for(int j = 1; j < grid[0].length; j++) grid[0][j] = grid[0][j-1] + grid[0][j];
        for(int i = 1; i < grid.length; i++) {
            for(int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
75. Sort Colors

 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem. 

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

public void sortColors(int[] nums) {
        int left = 0, right = nums.length-1;
        for(int i = 0; i <= right; i++) {
            while(nums[i] == 2 && i < right) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            while(nums[i] == 0 && i > left) {
                int temp = nums[i];
                nums[i]  = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
204. Count Primes 

Description:

Count the number of prime numbers less than a non-negative number, n.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
//////////////////////////// Sieve of Eratosthenes 

public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] array = new boolean[n];
        array[0] = true; array[1] = true;
        int count = 0;
        for(int i = 2; i*i < n; i++) {
            if(array[i]) continue;
            for(int j = i*i; j < n; j+=i) array[j] = true;
        }
        for(int i = 0; i < n; i++) if(!array[i]) count++;
        return count;
    }
	space complexity = O(n) time complexity = O(nloglogn)

/////////////////////////// optimized 
public int countPrimes(int n) {
        if(n <= 2) return 0;
        boolean[] array = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!array[i]) {
                count++;
                int j = i;
                while(j < n) {
                    array[j] = true;
                    j = j + i;
                }
            }
        }
        return count;
    }
//////////////////// another
public int countPrimes(int n) {
        if(n < 2) return 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(2);al.add(3);
        if(n <= 3) return n-1;
        int count = 0;
        boolean flag = false;
        for(int i = 4; i <= n; i++) {
            flag = false;
            for(int j = 0; j < al.size(); j++) {
                if(i % al.get(j) == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) al.add(i);
        }
        return al.size();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

0             6            12             18

1       5     7      11    13       17    19

2    4        8  10        14  16         20

3             9            15             21 
//////////////////////////// optimized 
public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        StringBuilder[] sarray = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sarray[i] = new StringBuilder();
        }
        int i = 0;
        while(i < s.length()) {
            for(int j = 0; j < numRows && i < s.length(); j++) {
                sarray[j].append(s.charAt(i++)); 
            }
            for(int j = numRows-2; j > 0 && i < s.length(); j--) {
                sarray[j].append(s.charAt(i++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < numRows; j++) {
            sb.append(sarray[j].toString());
        }
        return sb.toString();
    }
/////////////////// another 
public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        int row = 0, col = 0, i = 0;
        String[] array = new String[numRows];
        for(i = 0; i < numRows; i++) {
            array[i] = "";
        }
        i = 0;
        while(i < s.length()) {
            if(col % (numRows-1) == 0) {
                while(i < s.length() && row < numRows) {
                    StringBuilder sb = new StringBuilder(array[row]);
                    sb.append(s.charAt(i));
                    i++;
                    array[row++] = sb.toString();
                }
                row = numRows-2;
            }
            else {
                if(i < s.length() && row > 0) {
                    StringBuilder sb = new StringBuilder(array[row]);
                    sb.append(s.charAt(i)); 
                    i++;
                    array[row] = sb.toString();
                    row--;
                }
            }
            col++;
        }
        StringBuilder result = new StringBuilder();
        for(i = 0; i < numRows; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
228. Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
////////////////////////// optimized 
public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0) return result;
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(i+1 < nums.length && nums[i+1]-nums[i] == 1) i++;
            if(nums[i] != num) result.add(num+"->"+nums[i]);
            else result.add(num+"");
        }
        return result;
    }
///////////////////////////// another
public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0) return result;
        StringBuilder sb = new StringBuilder();
        int prev = nums[0];
        sb.append(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1] == 0 || nums[i]-nums[i-1] == 1) {
                prev = nums[i];
            }
            else {
                if(Integer.parseInt(sb.toString()) != prev) {
                    sb.append("->"+prev);
                }
                result.add(sb.toString());
                sb = new StringBuilder();
                sb.append(nums[i]);
                prev = nums[i];
            }
        }
        if(Integer.parseInt(sb.toString()) != prev) {
            sb.append("->"+String.valueOf(prev));
        }
        result.add(sb.toString());
        return result;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
Missing Ranges

Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

public List<String> findMissingRange(int[] nums,int lo, int hi) {
	List<String> result = new ArrayList<String>();
	int left = lo;
	for(int i = 0; i < nums.length; i++) {
		if(left > nums[i])continue;   /// for dublicate
		if(left == nums[i]){         /// if same the next starting value will be increment by 1
			left++;
		}
		else {
			result.add(getRange(left,nums[i]-1));
			left = nums[i]+1;
		}
	}
}
public String getRange(int n1, int n2) {
	return (n1==n2)?String.valueOf(n1):n1+"->"+n2;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s; 
    Stack<Integer> min; 
    public MinStack() {
        s = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(s.isEmpty() || x <= min.peek()) min.push(x);
        s.push(x);
    }
    
    public void pop() {
        if(!s.isEmpty()){
            int temp = s.pop();
            if(temp == min.peek()) min.pop();
        }
    }
    
    public int top() {
        if(!s.isEmpty()) return s.peek();
        return -1;
    }
    
    public int getMin() {
        if(!s.isEmpty()) return min.peek();
        return -1;
    }
}

