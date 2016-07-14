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
  17. If we are using comparator with the object in that case we always need to create another class which implements the comparator interface and implements the compare method in that classs. And we can use the 
  methods such as Array.sort(array, new object()) or Collections.sort(list, new Object());
  18. copy one array into another array System.arraycopy(src, srcPos, dest, destPos, length)
  19. sort array in reverse Arrays.sort(nums, Collection.reverseOrder());
  20. When ever we need to find two same array form group of arrays. we can generate hashCode for the each array
  using Arrays.hashCode(array) this code will be same for two same arrays.
  21. array creating : 
  int[] array = new int[3]; array[0] = 1; array[1] = 2; array[2] = 3;
  int[] array = {1,2,3};
  int[] array = new int[] {1,2,3};
  22. in String Builder add = sb.append(anything);
  and delete sb.deleteCharAt(index); for range sb.delete(start,end+1);
  23. to conver a string to lower case letter str = str.toLowerCase();
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
	
	// array [1,2,5] and amount = 11 how many minimum number of coins needed to form amount // 
	
	Not working 
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
/////////////////// another 
public int coinChange(int[] coins, int amount) { // no need to sort
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < coins.length; i--) {
            for(int j = coins[i]; j <= amount; j++) {
                if(dp[j-coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
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
//////////////////////////////////////// optimized
public boolean isUgly(int num) {
        if(num == 0) return false;
        List<Integer> list = new ArrayList<Integer>();
        list.add(2); list.add(3); list.add(5);
        int i = 0;
        while(num != 1 && i < list.size()) {
            if(num % list.get(i) == 0) {
                while(num != 1 && num % list.get(i) == 0) num /= list.get(i);
            } 
            i++;
        }
        return (num == 1);
    }
///////////////////// another
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

Window `position                Max
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
////////////////////////////////////////another

public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0 || k > n) return ret;
        List<Integer> curr = new ArrayList<Integer>();
        helper(ret, curr, n , k, 0);
        return ret;
    }
    public void helper(List<List<Integer>> ret, List<Integer> curr, int n, int k, int counter) {
        if(counter > n) return;
        if(curr.size() == k) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = counter; i < n; i++) {
            curr.add(i+1);
            helper(ret,curr,n,k,i+1);
            curr.remove(curr.size()-1);
        }
    } 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
49. Group Anagrams

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
n - length of string array k - max length amoung all the string
time complexity : O(nklogk + nlogn)
public List<List<String>> groupAnagrams(String[] strs) {
    if(strs==null || strs.length == 0){
        return new ArrayList<List<String>>();
    }
    HashMap<String, List<String>> map = new HashMap<String, List<String>>();
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
////////////////////////// another 
public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> hm = new HashMap<String,List<String>>();
        if(strs.length == 0) return result;
        for(String str: strs) {
            String key = getKey(str);
            if(!hm.containsKey(key)) hm.put(key,new ArrayList<String>());
            hm.get(key).add(str);
        }
        for(List<String> list: hm.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    public String getKey(String str) {
        if(str.length() == 0 || str.length() == 1) return str;
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
In-place replace multiple occurrences of a pattern substring
Given a string and a pattern, replace multiple occurrences of a pattern by character ‘X’. The conversion should be in-place and solution should replace multiple consecutive (and non-overlapping) occurrences of a pattern by a single ‘X’.

String – GeeksForGeeks
Pattern – Geeks
Output: XforX
 
String – GeeksGeeks
Pattern – Geeks
Output: X

String – aaaa
Pattern – aa
Output: X

String – aaaaa
Pattern – aa
Output: Xa

package Awesome;

public class StingReplaceMain {
	public static int[] getArray(String str) {
		int[] ret = new int[str.length()];
		int j = 0 ,i = 1; 
		while(i < ret.length) {
			if(str.charAt(i)==str.charAt(j)){
				ret[i] = j + 1;
				i++; j++;
			}
			else {
				if(j == 0) i++;
				else {
					j = ret[j-1];
				}
			}
		}
		return ret;
	}
	public static String reArrange(String s, String pat) {
		int[] pre = getArray(pat);
		StringBuilder result = new StringBuilder();
		StringBuilder cur = new StringBuilder();
		int j = 0, i = 0;
		while(i < s.length()) {
			if(s.charAt(i) == pat.charAt(j)) {
				cur.append(s.charAt(i));
				i++;
				j++;
				if(j == pre.length) {
					j = 0;
					if(result.length() == 0|| result.charAt(result.length()-1) != 'X')
						result.append("X");
					cur = new StringBuilder();
				}
			}
			else {
				if(j == 0) {
					result.append(s.charAt(i));
					i++;
				}
				else {
					j = pre[j-1];
					result.append(cur.toString());
					cur = new StringBuilder(pat.substring(0,j+1));
				}
			}			
		}
		return result.toString();
	}
	public static void main(String[] args) {
		String s = "abceeabcdabcdklmabcd";
		System.out.println(reArrange(s,"abcd"));

	}

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Check whether a given string consists the substring of type “ab*c”


public static boolean isSubstring(String str, String substr) {
		if(str.length() == 0 || substr.length() == 0) return false;
		String[] sArray = substr.split("\\*");		
		int k = 0;
		if(sArray[0].length() != 0) {
			int[] pre1 = getPreArray(sArray[0]);
			k = isSubstring(str,sArray[0],pre1);
			//if(k == -1) return false;
			//else if(k != -1 && sArray.length == 1) return true;
			if(sArray.length == 1 || k == -1) return (k != -1);
		}
		if(sArray.length > 1 && sArray[1].length() != 0) {
			int[] pre2 = getPreArray(sArray[1]);
			k = isSubstring(str.substring(k),sArray[1],pre2);
			//return(k == -1)?false:true;	
			return (k != -1);
		}
		return false;
	}
	public static int isSubstring(String str, String substr,int[] pre) {
		if(str.length() == 0) return -1;
		int i = 0, j = 0;
		while(i < str.length()) {
			if(str.charAt(i) == substr.charAt(j)) {
				i++;j++;				
			}
			else {
				if(j == 0) i++;
				else j = pre[j-1];
			}
			if(j == pre.length) return i;
		}
		return -1;
	}
	public static int[] getPreArray(String str) {
		int[] result = new int[str.length()];
		int j = 0, i = 1;
		while(i < str.length()) {
			if(str.charAt(i) == str.charAt(j)) {
				result[i] = j + 1;
				i++; j++;
			}
			else {
				if(j == 0) i++;
				else j = result[j-1];
			}
		}
		return result;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        String result = "";          /// StringBuilder sb = new StringBuilder();
        while(n != 0) {
            char ch = (char)((n-1) % 26 + 'A');
            n = (n-1)/26;
            result = ch+result;    /// sb.insert(0,ch);
        }
        return result;             /// sb.toString();
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
////////////////////////// again another 
 public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if(nums.length == 0) return ret;
        int i = 1, start = nums[0], end = nums[0];
        for(; i < nums.length; i++) {
            if(nums[i] == end+1) end = nums[i];
            else {
                ret.add(getRange(start,end));
                start = end = nums[i];
            }
        }
        ret.add(getRange(start,end));
        return ret;
    }
    public String getRange(int start, int end) {
        return (start == end)?String.valueOf(start):String.valueOf(start)+"->"+String.valueOf(end);
    }
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
	result.add(left,hi);
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

116. Populating Next Right Pointers in Each Node

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
////////////////////////// optimized 
public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode prev = root, cur = null;
        prev.next = null;
        while(prev.left != null) {
            cur = prev;
            while(cur != null) {
                cur.left.next = cur.right;
                if(cur.next != null) cur.right.next = cur.next.left;
                else cur.right.next = null;
                cur = cur.next;
            }
            prev = prev.left;
        }
        return;
}
//////////////////////////// another 	
public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        TreeLinkNode prev = null;
        q.offer(null);
        while(!q.isEmpty()) {
            TreeLinkNode temp = q.poll();
            if(prev != null) {
                prev.next = temp;
            }
            prev = temp;
            if(temp != null) {
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
            else {
                if(!q.isEmpty()) q.offer(null);
            }
            
        }
        return;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.

If n == 1, there would be k-ways to paint.

if n == 2, there would be two situations:

2.1 You paint same color with the previous post: k*1 ways to paint, named it as same
2.2 You paint differently with the previous post: k*(k-1) ways to paint this way, named it as dif
So, you can think, if n >= 3, you can always maintain these two situations, You either paint the same color with the previous one, or differently.

Since there is a rule: "no more than two adjacent fence posts have the same color."

We can further analyze:

from 2.1, since previous two are in the same color, next one you could only paint differently, and it would form one part of "paint differently" case in the n == 3 level, and the number of ways to paint this way would equal to same*(k-1).
from 2.2, since previous two are not the same, you can either paint the same color this time (dif*1) ways to do so, or stick to paint differently (dif*(k-1)) times.
Here you can conclude, when seeing back from the next level, ways to paint the same, or variable same would equal to dif*1 = dif, and ways to paint differently, variable dif, would equal to same*(k-1)+dif*(k-1) = (same + dif)*(k-1)

public int numsWays(int n, int k) {
	if(n <= 0) {
		return 0;
	}
	if(n == 1) return k;
	same = k;
	diff = k*(k-1);
	for(int i = 3; i <= n; i++) {
		int temp = diff;
		diff = (same + diff)*(k-1);
		same = diff;
	}
	return (same+diff);
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

public List<Integer> diffWaysToCompute(String input) {
        if(input.length() == 0) return new ArrayList<Integer>();
        HashMap<String,List<Integer>> hm = new HashMap<>();  // avoid the overlapping subproblems
        return helper(input, hm);  // call helper with map
    }
    public List<Integer> helper(String input, HashMap<String,List<Integer>> hm) {
        if(hm.containsKey(input)) return hm.get(input);  // if that string exist in map return;
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            List<Integer> ret = new ArrayList<Integer>();  // input doesn't contains any operator means only number
            ret.add(Integer.valueOf(input));              // return that number
            hm.put(input,ret);
            return ret;
        } 
        List<Integer> ret = new ArrayList<Integer>();       // if contains atleast one operator then go through 
        for(int i = 0; i < input.length(); i++) {           // entrire string 
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {       // and when ever we hit operator divide the string.
                List<Integer> left = helper(input.substring(0,i),hm);
                List<Integer> right = helper(input.substring(i+1),hm);
                for(Integer n1: left) {
                    for(Integer n2: right) {
                        switch(ch) {
                            case '+' : ret.add(n1+n2); break;
                            case '-' : ret.add(n1-n2); break;
                            case '*' : ret.add(n1*n2); break;
                        }
                    }
                }
            }
        }
        return ret;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
95. Unique Binary Search Trees II

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return helper(1,n);
    }
    public List<TreeNode> helper(int left, int right) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(left > right) {
            ret.add(null);
            return ret;
        }
        if(left == right) {
            TreeNode newNode = new TreeNode(left);
            newNode.left = null;
            newNode.right = null;
            ret.add(newNode);
            return ret;
        }
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftTree = helper(left, i-1);
            List<TreeNode> rightTree = helper(i+1,right);
            for(TreeNode leftNode: leftTree) {
                for(TreeNode rightNode: rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   public int numTrees(int n) {
        if(n == 0) return 0;
        int[] array = new int[n+1];
        array[0] = 1;
        array[1] = 1;
        for(int i = 2; i <= n; i++) {
            int num = 0;
            for(int j = 0; j < i; j++) {
                num += array[j]*array[i-j-1];
            }
            array[i] = num;
        }
        return array[n];
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Moving Average from Data Stream (Java)

Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

import java.util.*;
class MovingAvg{
	int size, count, sum;
	Queue<Integer> q;
	public MovingAvg(int size) {
		q = new LinkedList<Integer>();
		sum = 0;
		this.size = size;
		count = 0;
	}
	public double getNext(int val) {
		q.add(val);
		sum += val;
		count++;
		if(count <= size) return (double)sum / count;
		else {
			sum -= q.remove();
			return (double)sum/size;
		}
	}
}
public class MovingAvgMain {
	public static void main(String[] arg) {
		MovingAvg  ma = new MovingAvg(3);
		System.out.println(ma.getNext(1));
		System.out.println(ma.getNext(2));
		System.out.println(ma.getNext(3));
		System.out.println(ma.getNext(4));
		System.out.println(ma.getNext(5));
		System.out.println(ma.getNext(6));
		System.out.println(ma.getNext(7));
		
	}
}
///// output 

1.0
1.5
2.0
3.0
4.0
5.0
6.0
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.

public boolean isPalindrome1(String str) {
	if(str.length() == 0) return true;
	int[] array = new int[256];
	int count = 0;
	for(int i = 0; i < str.length(); i++) {
		if(array[str.charAt(i)] > 0) array[str.charAt(i)]--;
		else array[str.charAt(i)]++;
	}
	for(int i = 0; i < 256; i++) {
		if(array[i] != 0) count++;
	}
	return (count<=1);
}
///////////////// another 

public boolean isPalindrome2(String str) {
	if(str.length() == 0) return true;
	Set<Character>  s = new HashSet<Character>();
	for(int i = 0; i < str.length(); i++) {
		if(s.contains(str.charAt(i))) s.remove(str.charAt(i));
		else s.add(str.charAt(i));
	}
	return s.size()<=1;
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

LEETCODE 243 SHORTEST WORD DISTANCE

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

public int getDiff1(List<String> al, String word1, String word2) {
		int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
		for(int i = 0; i < al.size(); i++) {
			if(al.get(i).equals(word1)) p1 = i;
			if(al.get(i).equals(word2)) p2 = i;
			if(p1 != -1 && p2 != -1) min = Math.min(min,Math.abs(p1-p2));
		}
		return min;
	}
////////////////////////////////// another 

public int getDiff(List<String> al, String word1, String word2) {
		int minDiff = Integer.MAX_VALUE;
		int prev = 0, i = 0;
		 while( i < al.size() && !al.get(i).equals(word1) && !al.get(i).equals(word2)) i++;
		 prev = i++;
		 for(;i < al.size(); i++) {
			 if(al.get(i).equals(word1) || al.get(i).equals(word2)){
				 if(al.get(i).equals(al.get(prev))) prev = i;
				 else {
					 minDiff = Math.min(minDiff, i-prev);
					 prev = i;
				 }
			 }
		 }
		 return minDiff;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
for three words

public int getDiff1(List<String> al, String word1, String word2,String word3) {
		int p1 = -1, p2 = -1, p3 = -1,min = Integer.MAX_VALUE;
		for(int i = 0; i < al.size(); i++) {
			if(al.get(i).equals(word1)) p1 = i;
			if(al.get(i).equals(word2)) p2 = i;
			if(al.get(i).equals(word3)) p3 = i;
			if(p1 != -1 && p2 != -1 && p3 != -1) {
				min = Math.min(min, Math.max(Math.abs(p1-p2), Math.max(Math.abs(p1-p3),Math.abs(p2-p3))));
			}
		}
		return min;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Shortest Word Distance II

This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
public class solution {
	HashMap<String, List<Integer>> hm;
	int count;
	public solution(String[] wordList) {
		hm = new HashMap<String,List<Integer>>();
		count = 0;
		for(int i = 0; i < wordList.length; i++) {
			add(wordList[i]);
		}
	}
	public void add(String str) {
		if(!hm.containsKey(str)) {
			hm.put(str,new ArrayList<Integer>());
		}
		//hm.put(str,count++);
		hm.get(str).add(count++);
	}
	public int minDistance(String str1, String str2) {
		int minDist = Integer.MAX_VALUE, i = 0, j = 0;
		List<Integer> l1 = hm.get(str1);
		List<Integer> l2 = hm.get(str2);
		while(i < l1.size() && j < l2.size()) {
			int n1 = l1.get(i), n2 = l2.get(j);
			if(n1 < n2) {
				minDist = Math.min(minDist, n2-n1);
				i++;
			}
			else {
				minDist = Math.min(minDist, n1-n2);
				j++;
			}
		}
		return minDist;
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Shortest Word Distance III
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

	public static int minDistance(String[] strArray,String word1, String word2) {
		int p1 = -1, p2 = -1, minDist = Integer.MAX_VALUE;
		if(strArray.length == 0 || strArray.length == 1) return 0;
		boolean flag1 = true, flag2 = true;
		if(word1.equals(word2)) flag2 = false;
		for(int i = 0; i < strArray.length; i++) {
			if(flag1 && strArray[i].equals(word1)) {
				p1 = i; 
				if(!flag2) { flag2 = true; flag1 = false; }
			}
			else if(flag2 && strArray[i].equals(word2)) {
				p2 = i;
				if(!flag1) { flag1 = true; flag2 = false; }
			}
			if(p1 != -1 && p2 != -1) 
				minDist = Math.min(minDist, Math.abs(p1-p2));
		}
		return (minDist==Integer.MAX_VALUE)?0:minDist;
	}
	public static void main(String[] args) {
		String[] strArray = {"practice","practice", "makes", "perfect", "coding", "makes","makes","practice"};
		System.out.println(minDistance(strArray,"practice","practice"));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
max Distance between two words

public static int maxDistance(char[] chars, char ch1, char ch2) {
		int min1 = chars.length, min2 = chars.length, max1 = -1, max2 = -1;
		boolean flag1 = false, flag2 = false;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == ch1) {
				min1 = Math.min(min1, i);
				max1 = Math.max(max1, i);
				flag1 = true;
			}
			if(chars[i] == ch2) {
				min2 = Math.min(min2, i);
				max2 = Math.max(max2, i);
				flag2 = true;
			}
		}
		if(ch1 == ch2) return max1-min1;
		if(flag1 && flag2) return Math.max(max2-min1, max1-min2);
		else return -1;
		
	}
	public static void main(String[] args) {
		char[] array = {'a','b','c','d','e','b','b','e','m','l','a',};
		System.out.println(maxDistance(array,'a','b'));

	}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Flip Game

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
Write a function to compute all possible states of the string after one valid move.
For example, given s = "++++", after one move, it may become one of the following states:
[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
Understand the problem:
The problem only asks for flipping "++" into "--", NOT -- to ++. So the solution is to move all consecutive "++" into "--".

public List<String> getNextState(String s) {
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
				result.add(s.substring(0,i)+"--"+s.substring(i+2));
			}
		}
		return result;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Meeting Rooms
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

class Interval{
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
 }
 
 class IntervalCompare implements Comparator<Interval> {
	public int compare(Interval a1, Interval a2) {
		return a1.start-a2.start;
	}
}
///////////////////////////// method for array of Interval
public boolean willAttendAll(Interval[] al) {
		if(al.length == 0) return true;
		Arrays.sort(al, new IntervalCompare());
		for(int i = 1; i < al.length; i++) {
			if(al[i].start < al[i-1].end) return false;
		}
		return true;		
	}
/////////////////////////////// method for list of Interval	
	public boolean willAttendAll(List<Interval> al) {
		if(al.size() == 0) return true;
		Collections.sort(al,new IntervalCompare());
		for(int i = 1; i < al.size(); i++) {
			if(al.get(i).start < al.get(i-1).end) return false;			
		}
		return true;		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

import java.util.*;

class Interval7{
	int start, end;
	public Interval7(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class MeetingRoomMain {

	public static void main(String[] args) {
		Interval7 s1 = new Interval7(1,5);
		Interval7 s2 = new Interval7(2,4);
		Interval7 s3 = new Interval7(4,9);
		Interval7 s4 = new Interval7(3,8);
		Interval7 s5 = new Interval7(7,9);
		Interval7[] array = new Interval7[5];
		array[0] = s1; array[1] = s2; array[2] = s3; array[3] = s4; array[4] = s5;
		System.out.println(minimumRooms(array));

	}
	public static int minimumRooms(Interval7[] array) {
		if(array.length == 0) return 0;
		int[] start = new int[array.length],end = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			start[i] = array[i].start;
			end[i] = array[i].end;
		}
		Arrays.sort(start); Arrays.sort(end);
		int room = 0, endInd = 0;
		for(int i = 0; i < start.length; i++) {
			if(start[i] < end[endInd]) room++;
			else endInd++;
		}
		return room;
	}

}
////////////////////////////////////// another method minimumRooms
public static int minimumRooms(Interval7[] array) {
		if(array.length == 0) return 0;
		int[] start = new int[array.length],end = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			start[i] = array[i].start;
			end[i] = array[i].end;
		}
		Arrays.sort(start); Arrays.sort(end);
		int i = 0, j = 0, activeRoom = 0,minRoom = 0;
		while(i < array.length && j < array.length) {
			if(start[i] < end[j]) {
				activeRoom++;
				minRoom = Math.max(minRoom,activeRoom);
				i++;
			}
			else {
				activeRoom--; j++;
			}
		}
		return minRoom;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Strobogrammatic Number

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to determine if a number is strobogrammatic. The number is represented as a string.
For example, the numbers "69", "88", and "818" are all strobogrammatic.
Understand the problem:
The key of the problem is to understand what is called "strobogrammatic number". As defined, the number 0, 1 and 8 are strobogrammatic. However, 6 and 9 are kind of special. E.g. 
6 0 0 9, return True
66 000 99, return True;
6969 return true; 
6996, return true;

public boolean isStrobogrammatic(String s) {
		if(s.length() == 0) return true;
		int left = 0, right = s.length()-1;
		while(left <= right) {
			if(s.charAt(left) == s.charAt(right)) {
				if(s.charAt(left) == '1' || s.charAt(left) == '0' || s.charAt(left) == '8'|| s.charAt(left) == ' ') {
					left++; right--;
				}
				else return false;
			}
			else {
				if(s.charAt(left)=='6' && s.charAt(right) == '9') {
					left++; right--;
				}
				else if(s.charAt(left) == '9' && s.charAt(right) == '6') {
					left++; right--;
				}
				else return false;
			}
		}
		return true;	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Group Shifted Strings

Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

import java.util.*;
public class GroupStrings {
	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(strings.length == 0) return result;
		Map<String, List<String>> hm = new HashMap<String, List<String>>();
		for(String str: strings) {
			String key = getKey(str);
			if(!hm.containsKey(key)) hm.put(key, new ArrayList<String>());
			hm.get(key).add(str);
		}
		for(List<String> list: hm.values()) {
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
	public static String getKey(String str) {
		if(str.length() == 0) return str;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i)-str.charAt(0);
			if(val < 0) val += 26;
			sb.append((char)val);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z","zab","yza","yz",""};
		List<List<String>> result = groupStrings(strings);
		System.out.println(result.toString());

	}

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Maximum Size Subarray Sum Equals k

Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

public static int subArraySumK(int[] array, int k){
		if(array.length == 0) return 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
		hm.put(0, -1);            // very important because at index -1 sum is 0 and that sum can be 0 later index
		int sum = 0, maxLen = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++){
			sum+=array[i];
			if(!hm.containsKey(sum)) hm.put(sum, i); // if not contains then and only then we need to put.
			if(hm.containsKey(sum-k)) {
				maxLen = Math.max(maxLen,i-hm.get(sum-k));
			}
		}
		return maxLen;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
LeetCode - Nested List Weight Sum

Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
  public int depthSum(List<NestedInteger> nestedList) {
	  if(nestedList.size() == 0) return 0;
	  return helper(nestedList, 1);
  }
  public int helper(List<NestedInteger> list, int level) {
	  int sum = 0;
	  for(NestedInteger item: list) {
		  if(item.isInteger()) sum += item.getInteger()*level;
		  else sum += helper(item.getList(), level+1);
	  }
	  return sum;
  }
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  278. First Bad Version
  
  You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
////////////////////// optimized version
public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
        while(left < right) {
            mid = left + (right - left)/2;
            if(!isBadVersion(mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
//////////////////////////////// another version
public int firstBadVersion(int n) {
        int left = 1, right = n, mid;
        while(left < right) {
            mid = left + (right - left)/2;
            if(left + 1 == right) break;
            if(isBadVersion(mid)) right = mid;
            else left = mid;
        }
        return (!isBadVersion(left) && isBadVersion(right))?right:1;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
50. Pow(x, n)

Implement pow(x, n).

public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(n % 2 != 0) {
            if(n > 0) {
                return x * myPow(x,n-1);
            }
            else {
                return (1/x)*myPow(x,n+1);
            }
        }
        else {
            double temp = myPow(x,n/2);
            return temp*temp;
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
69. Sqrt(x) 

Implement int sqrt(int x).

Compute and return the square root of x.

public int mySqrt(int x) {
        if( x == 0 || x == 1) return x;
        long left = 1, right = x/2;
        long mid;
        while(left < right) {
            mid = left + (right - left)/2;
            if(mid * mid == x || (mid * mid < x && ((mid+1) * (mid+1)) > x)) return (int)mid;
            else if(mid * mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return (int)left;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
1	Two Sum
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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
167	Two Sum II - Input array is sorted 

Two Sum II - Input array is sorted

Array of integers that AN GIVEN IS already  sorted in Ascending the Order , that the Find TWO SUCH They Numbers up to the Add A specific target The Number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

The INPUT:  Numbers = {2,. 7,. 11, 15}, target The =. 9 the Output:  index1 = 1, 2 index2 =


	public static void sum2(int[] array,int sum) {
		int left = 0, right = array.length-1;
		while(left < right) {
			if(array[left] + array[right] == sum)  {
				System.out.println(left+" "+right);
				return;
			}
			else if(array[left]+ array[right] < sum) {
				left++;
			}
			else right--;
		}
		System.out.println("Sum doesn't exist");
		return;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Leetcode: Two Sum III - Data structure design
Design and implement a TwoSum class. It should support the following operations: add and find.
add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.
For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

Follow-up: 
What if you add a few, but search very heavily? You need to make sure search only takes O(1) time. Add(num), add num with all the previous added numbers 
search(target), only takes O(1) time. 

import java.util.*;
class TwoSumIII {
	HashMap<Integer, Integer> hm;
	public TwoSumIII(){
		hm = new HashMap<Integer,Integer>();
	}
	public void add(int num) {
		hm.put(num, hm.getOrDefault(num,0)+1);
	}
	public boolean find(int num) {
		for(Integer key: hm.keySet()) {
			if(key != num-key) {
				if(hm.containsKey(num-key)) return true;
			}
			else {
				if(hm.get(key) >= 2) return true;
			}
		}
		return false;
	}
}
class TwoSumSet {
	Set<Integer> set;
	ArrayList<Integer> alist;
	public TwoSumSet() {
		set = new HashSet<Integer>();
		alist = new ArrayList<Integer>();
	}
	public void add(int num) {
		if(!alist.isEmpty()) {
			for(Integer n: alist) {
				set.add(num + n);
			}
		}
		alist.add(num);
	}
	public boolean find(int num) {
		return set.contains(num);
	}
}
public class TwoSumIIIMain {

	public static void main(String[] args) {
		TwoSumIII ts = new TwoSumIII();
		ts.add(1); ts.add(3); ts.add(3); ts.add(5);
		System.out.println(ts.find(4));
		System.out.println(ts.find(6));
		System.out.println(ts.find(9));
		TwoSumSet ts1 = new TwoSumSet();
		ts1.add(1); ts1.add(3); ts1.add(3); ts1.add(5);
		System.out.println(ts1.find(4));
		System.out.println(ts1.find(6));
		System.out.println(ts1.find(9));

	}

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Unique Word Abbreviation

An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true


The description (A word's abbreviation is unique if no other word from the dictionary has the same abbreviation) is clear however a bit twisting. It took me a few "Wrong Answer"s to finally understand what it's asking for.
We are trying to search for a word in a dictionary. If this word (also this word’s abbreviation) is not in the dictionary OR this word and only it’s abbreviation in the dictionary. We call a word’s abbreviation unique.
EX:

1) [“dog”]; isUnique(“dig”);   
//False, because “dig” has the same abbreviation with “dog" and “dog” is already in the dictionary. It’s not unique.

2) [“dog”, “dog"]; isUnique(“dog”);  
//True, because “dog” is the only word that has “d1g” abbreviation.

3) [“dog”, “dig”]; isUnique(“dog”);   
//False, because if we have more than one word match to the same abbreviation, this abbreviation will never be unique

public static boolean isExistAbbreviation(String[] words, String word) {
		HashMap<String, String> hm = new HashMap<String,String>();
		for(String str: words) {
			String key = getAbbreviation(str);
			if(!hm.containsKey(key)) hm.put(key, str);
			else {
				hm.put(key, "");
			}
		}
		return !hm.containsKey(getAbbreviation(word)) || hm.get(getAbbreviation(word)).equals(word);
	}
	public static String getAbbreviation(String str) {
		if(str.length() <= 2) return str;
		else return str.charAt(0)+String.valueOf(str.length()-2)+str.charAt(str.length()-1);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Read N Characters Given Read4

he API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.

public int read(char[] buf, int n) {
  boolean eof = false;      // end of file flag
  int total = 0;            // total bytes have read
  char[] tmp = new char[4]; // temp buffer

  while (!eof && total < n) {
    int count = read4(tmp);

    // check if it's the end of the file
    eof = count < 4;

    // get the actual count
    count = Math.min(count, n - total);

    // copy from temp buffer to buf
    for (int i = 0; i < count; i++) 
      buf[total++] = tmp[i];
  }

  return total;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
29. Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1 ) return Integer.MAX_VALUE;
        int sign = (dividend < 0)^(divisor < 0)?-1:1;  // xor to decide the sign
        long divd = Math.abs((long)dividend);  // convert them to positive
        long divs = Math.abs((long)divisor);
        int result = 0;
        while(divs <= divd) {   /// at the last iteration divs will be equal to div and then 1 will be added
            long temp = divs;
            int mul = 1;
            while(divd >= temp<<1) {  // if 3 then will check 6 is grater of not.
                temp<<=1; mul<<=1;    // set mul and temp according to that.. 
            }
            divd -= temp;
            result+= mul;
        }
        return result*sign;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
264. Ugly Number II

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
////// explaination
/*The idea of this solution is from this page:http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

Every step we choose the smallest one, and move one step after,including nums with same value.*/

public int nthUglyNumber(int n) {
        int[] array = new int[n];
        array[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i++) {
            array[i] = Math.min(2*array[p2],Math.min(3*array[p3], 5*array[p5]));
            if(array[i] == 2*array[p2]) p2++;
            if(array[i] == 3*array[p3]) p3++;
            if(array[i] == 5*array[p5]) p5++;
        }
        return array[n-1];
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
313. Super Ugly Number

Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

public int nthSuperUglyNumber(int n, int[] primes) {
        int[] array = new int[n];
        int[] count = new int[primes.length];
        array[0] = 1;
        for(int i = 1; i < n; i++) {
            array[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) 
                array[i] = Math.min(array[i],primes[j]*array[count[j]]);
            for(int j = 0; j < primes.length; j++)  {
                if(primes[j]*array[count[j]] <= array[i]) count[j]++; // <= because we don't need other dublicate
            }
        }
        return array[n-1];
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
279. Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i]+1);
            }
        }
        return dp[n];
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
43. Multiply Strings

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
////////////////////// optimized 
public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] array = new int[n+m];
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                int indx1 = i + j, indx2 = indx1 + 1;
                int sum = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + array[indx2];
                array[indx2] = sum % 10;
                array[indx1] = array[indx1] + sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num: array) {
            if(sb.length()==0 && num == 0) continue;
            sb.append(num);
        }
        return (sb.length()==0)?"0":sb.toString();
    }
////////////////////////////////// another 
public String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] array = new int[n+m];
        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int indx1 = i + j, indx2 = indx1 + 1;
                int sum = mul + array[indx2];
                array[indx2] = sum % 10;
                array[indx1] = array[indx1] + sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num: array) {
            if(!(sb.length()==0 && num == 0)) sb.append(num);
        }
        return (sb.length()==0)?"0":sb.toString();
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
300. Longest Increasing Subsequence

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(dp[i] > max) max = dp[i];
                }
            }
        }
        return max+1;
    }
/////////////////////// with better time complexity
//// if the current element is smaller than the first element of the new array then change first element of 
new array
/// if the current element is greater than the last element of the new array then add new element in the array.
/// if current element is inbetween we need to find it's perfect location using binary search, but lenght won't change.
public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] array = new int[nums.length];
        array[0] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < array[0]) array[0] = nums[i];
            else if(nums[i] > array[len-1]) array[len++] = nums[i];
            else array[findIndex(array,0,len-1,nums[i])] = nums[i];
        }
        return len;
    }
    public int findIndex(int[] nums, int left, int right, int num) {
        int mid; 
        while(left < right) {
            mid = left + (right-left)/2;
            if(nums[mid] >= num) right = mid;
            else left = mid + 1;
        }
        return right;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Ceilling function using binary search
	public static int findCeilling(int[] nums, int num) {
		int left = 0, right = nums.length-1, mid;
		if(num <= nums[left]) return nums[left];
		if(num > nums[right]) return -1;
		while(left < right) {
			mid = left + (right-left)/2;
			if(nums[mid] >= num) right = mid;
			else left = mid + 1;
		}
		return nums[right];
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Floor function using binary search

	public static int findFloor(int[] nums, int num) {
		int left = 0, right = nums.length-1, mid;
		if(num < nums[left]) return -1;
		if(num >= nums[right]) return nums[right];
		while(left < right) {
			mid = left + (right - left)/2;
			if(nums[mid] > num) right = mid -1;
			else {
				 if(nums[mid+1] <= num) left = mid + 1;
				 else right = mid;
			}
		}
		return nums[left];
	}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
334. Increasing Triplet Subsequence 

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
/////////////////////////optimized
	public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= first) first = nums[i];  // remember to put == otherwise there will be wrong answer in
            else if(nums[i] <= second) second = nums[i];  // case of dublicate
            else return true;
        }
        return false;
    }
//////////////////////// another
	public boolean increasingTriplet(int[] nums) {
        int prev1 = Integer.MIN_VALUE,prev2 = Integer.MIN_VALUE,len = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > prev1 && nums[i] > prev2) {
                prev2 = prev1;
                prev1 = nums[i];
                len++;
            }
            else if(nums[i] > prev2 && nums[i] < prev1) prev1 = nums[i];
            else if(nums[i] < prev1 && nums[i] < prev2) prev2 = nums[i];
            if(len == 3) return true;
        }
        return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
274. H-Index

Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

	public int hIndex(int[] citations) {
        int len = citations.length;
        int[] count = new int[len+1];
        for(int num : citations) {
            if(num >= len) count[len]++;
            else count[num]++;
        }
        int total = 0;
        for(int i = count.length-1; i >= 0; i--) {
            total+=count[i];
            if(total >= i) return i;
        }
        return 0;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Maximum value K such that array has at-least K elements that are >= K
Given an array of positive integers, find maximum possible value K such that the array has at-least K elements that are greater than or equal to K. The array is unsorted and may contain duplicate values.

Examples :

Input: [2, 3, 4, 5, 6, 7]
Output: 4
Explanation : 4 elements [4, 5, 6, 7] 
            are greater than equal to 4

Input: [1, 2, 3, 4]
Output: 2
Explanation : 3 elements [2, 3, 4] are 
               greater than equal to 2

Input: [4, 7, 2, 3, 8]
Output: 3 
Explanation : 4 elements [4, 7, 3, 8] 
          are greater than equal to 3
 

Input: [6, 7, 9, 8, 10]
Output: 5
Explanation : All 5 elements are greater
              than equal to 5 
			  
	public static void printElement(int[] array) {
		if(array.length == 0) {
			System.out.println("Not Possible");
			return;
		}
		int n = array.length,i,total = 0;
		int[] count = new int[n+1];
		for(i = 0; i < n; i++) {
			if(array[i] < n) {
				count[array[i]]++;
			}
			else count[n]++;
		}
		
		for(i = n; i>=0; i--) if((total+=count[i]) >= i) break;
		if(i >= 0) System.out.println(i);
		else System.out.println("Not possible");
		
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
275. H-Index II

Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.

	public int hIndex(int[] citations) {
        if(citations.length == 0 || citations[citations.length-1] == 0) return 0;
        int len = citations.length, left = 0, right = len-1, mid, total = len;
        while(left < right) {
            mid = left + (right - left)/2;
            total = len-mid;
            if(total <= citations[mid]) right = mid;
            else left = mid+1;
        }
        return len-left;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
307. Range Sum Query - Mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly

public class NumArray {
    int[] fenwick;
    int[] nums;
    public NumArray(int[] nums) {
        fenwick = new int[nums.length+1];
        this.nums = new int[nums.length];
        this.nums = nums;
        for(int i = 0; i < nums.length; i++) {
            changeFenwick(i,nums[i]);
        }
    }
    void update(int i, int val) {
        changeFenwick(i,val-nums[i]); // remember to pass val-nums[i];
        nums[i] = val;
    }
    public int sumRange(int i, int j) {
        if(i == 0) return getSum(j);
        return getSum(j)-getSum(i-1);  // remember
    }
    
    void changeFenwick(int i,int val) {
        i += 1;
        while(i <= fenwick.length-1) {
            fenwick[i]+=val;
            i += (i&(~i+1));
        }
    }
    
    public int getSum(int ind) {
        ind+=1;
        int sum = 0;
        while(ind > 0) {
            sum+=fenwick[ind];
            ind -= (ind&(~ind + 1));
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
304. Range Sum Query 2D - Immutable

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.

public class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        if(matrix.length != 0) {
            mat = new int[matrix.length][matrix[0].length];
            mat[0][0] = matrix[0][0];
            for(int j = 1; j < mat[0].length; j++) {
                mat[0][j] = mat[0][j-1]+matrix[0][j];
            }
            for(int i = 1; i < mat.length; i++) {
                mat[i][0] = mat[i-1][0] +matrix[i][0];
            }
            for(int i = 1; i < mat.length; i++) {
                for(int j = 1; j < mat[0].length; j++) {
                    mat[i][j] = matrix[i][j] + mat[i-1][j] + mat[i][j-1] - mat[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) return mat[row2][col2];
        int sum = mat[row2][col2];
        int i  = row2, j = col1-1;
        if(i >= 0 && i <= mat.length && j >= 0 && j <= mat[0].length) sum-=mat[i][j];
        i = row1-1; j = col2;
        if(i >= 0 && i <= mat.length && j >= 0 && j <= mat[0].length) sum-=mat[i][j];
        i = row1-1; j = col1-1;
        if(i >= 0 && i <= mat.length && j >= 0 && j <= mat[0].length) sum+=mat[i][j];
        return sum;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
5. Longest Palindromic Substring

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

public class Solution {
    int start = 0, maxLen = Integer.MIN_VALUE;
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        for(int i = 0; i < s.length()-1; i++) {
            expand(s,i,i);
            expand(s,i,i+1);
        }
        return s.substring(start,start+maxLen);
    }
    public void expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--; j++;
        }
        if(j-i-1 > maxLen) {
            maxLen = j-i-1;
            start = i+1;
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
127. Word Ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList.size() == 0 || beginWord.length() == 0) return 0;
        Set<String> current = new HashSet<String>();
        current.add(beginWord);
        int dist = 1;
        wordList.remove(beginWord);
        wordList.add(endWord);
        while(!current.contains(endWord)) {
            Set<String> next = new HashSet<String>();
            for(String str : current) {
                for(int i = 0; i < str.length(); i++) {
                    char[] array = str.toCharArray();  // put out side of char loop
                    for(char c = 'a'; c <= 'z'; c++) {
                        array[i] = c;
                        String nextStr = new String(array);
                        if(wordList.contains(nextStr)) {
                            next.add(nextStr);
                            wordList.remove(nextStr);
                        }
                    }
                }
            }
            dist++;
            if(next.size()==0) return 0;
            current = next;
        }
        return dist;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
3. Longest Substring Without Repeating Characters 

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
////////////////////// optimized
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> hm = new HashMap<Character,Integer>();
        int maxLen = 0,i = 0,j = 0;
        for(; i < s.length(); i++) {
            if(hm.containsKey(s.charAt(i))) {
                maxLen = Math.max(maxLen,i-j);
                j = Math.max(j,hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i),i);
        }
        return  Math.max(maxLen,i-j);
    }
/////////////////////// another
	public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character, Integer> hm = new HashMap<Character,Integer>();
        int maxLen = Integer.MIN_VALUE , i = 0;
        while(i < s.length()) {
            if(!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i),i);
                i++;
            }
            else {
                i = hm.get(s.charAt(i)) + 1;
                maxLen = Math.max(maxLen, hm.size());
                hm.clear();
            }
        }
        maxLen = Math.max(maxLen,hm.size());
        return maxLen;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
///////////////////////////////////////// optimized 
public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
               if(grid[i][j] == '1') {
                   count++;
                   mark(grid,i,j);
               }
            }
        }
        return count;
    }
    public void mark(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] =='0') return;
        grid[i][j] = '0';
        mark(grid,i-1,j); 
        mark(grid,i+1,j);
        mark(grid,i,j-1);
        mark(grid,i,j+1);
    }
//////////////////////////////////////////// another
class Node{
    public int i,j;
    public Node(int i,int j) {
        this.i = i;
        this.j = j;
    }
}
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
               if(flag[i][j] || grid[i][j] == '0') continue;
                Queue<Node> q = new LinkedList<Node>();
                q.add(new Node(i,j));
                while(!q.isEmpty()) {
                    Node temp = q.remove();
                    flag[temp.i][temp.j] = true;
                    if(temp.i-1 >= 0 && grid[temp.i-1][temp.j] == '1' && !flag[temp.i-1][temp.j]) {
                        q.add(new Node(temp.i-1,temp.j));
                    }
                    if(temp.i+1 < grid.length && grid[temp.i+1][temp.j] == '1' && !flag[temp.i+1][temp.j]) {
                        q.add(new Node(temp.i+1,temp.j));
                    }
                    if(temp.j-1 >= 0 && grid[temp.i][temp.j-1] == '1' && !flag[temp.i][temp.j-1]) {
                        q.add(new Node(temp.i,temp.j-1));
                    }
                    if(temp.j+1 < grid[0].length && grid[temp.i][temp.j+1] == '1' && !flag[temp.i][temp.j+1]) {
                        q.add(new Node(temp.i,temp.j+1));
                    }
                }
                count++;
            }
        }
        return count;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
130. Surrounded Regions

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
//////////////////////////////////// optimized 
public void solve(char[][] board) {
        if(board.length == 0) return ;
        if(board.length == 1 || board[0].length == 1) return;
        int h = board.length, w = board[0].length;
        for(int i = 0; i < h; i++) {
            if(board[i][0] == 'O') set(board,i,0);
            if(board[i][w-1] == 'O') set(board,i,w-1);
        }
        for(int j = 0; j < w; j++) {
            if(board[0][j] == 'O') set(board,0,j);
            if(board[h-1][j] == 'O') set(board,h-1,j);
        }
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'M') board[i][j] = 'O';
            }
        }
    }
    public void set(char[][] board,int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        board[i][j] = 'M';
        if(i-1 >= 0 && board[i-1][j] == 'O') set(board,i-1,j);
        if(j-1 >= 0 && board[i][j-1] == 'O') set(board,i,j-1);
        if(i+1 < board.length && board[i+1][j] == 'O') set(board,i+1,j);
        if(j+1 < board[0].length && board[i][j+1] == 'O') set(board,i,j+1);
    }
//////////////////////////////////// another
public void solve(char[][] board) {
        if(board.length == 0) return ;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    char[][] temp = new char[board.length][board[0].length];
                    for(int k = 0; k < board.length; k++) {
                        System.arraycopy(board[k],0,temp[k],0,board[k].length);
                    }
                    if(check(temp,i,j)) {
                        change(board,i,j);
                    }
                }
            }
        }
    }
    public boolean check(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length||board[i][j] == 'X') return true;
        if(board[i][j] == 'O' && i-1 < 0 || i+1 >= board.length || j-1 < 0 || j+1 >= board[0].length) return false;
        board[i][j] = 'X';
        boolean left = true, right = true, up = true, down = true;
        if(board[i-1][j] == 'O') left = check(board,i-1,j);
        if(board[i+1][j] == 'O') right = check(board,i+1,j);
        if(board[i][j-1] == 'O') up = check(board,i,j-1);
        if(board[i][j+1] == 'O') down = check(board,i,j+1);
        return (left && right && up && down);
    }
    public void change(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        board[i][j] = 'X';
        if(board[i-1][j] == 'O') change(board,i-1,j);
        if(board[i+1][j] == 'O') change(board,i+1,j);
        if(board[i][j-1] == 'O') change(board,i,j-1);
        if(board[i][j+1] == 'O') change(board,i,j+1);
        return;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Flip Game II

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
Write a function to determine if the starting player can guarantee a win.
For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

public boolean canWin(String s) {
	if(s.length() == 0) return false;
	char[] array = s.toCharArray();
	return helper(array);
}
public boolean helper(char[] array) {
	for(int i = 0; i < array.length-1; i++) {
		if(array[i] == '+' && array[i+1] == '+') {
			array[i] = '-';
			array[i+1] = '-';
			boolean flag = !helper(array)
			array[i] = '+';
			array[i+1] = '+';
			if(flag) return true;
		}
	}
	return false;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
221. Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int result = 0;
        for(int i = 1; i <= matrix.length; i++) {
            for(int j = 1; j <= matrix[0].length; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    result = Math.max(dp[i][j],result);
                }
            }
        }
        return result*result;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Wiggle Sort
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

public void wiggleSort(int[] nums) {
	if(nums.length == 0) return;
	for(int i = 0; i < nums.length-1; i++) {
		if(i % 2 == 0 && nums[i] > nums[i+1]) swap(nums,i,i+1);
		if(i % 2 != 0 && nums[i] < nums[i+1]) swap(nums,i,i+1);
	}
}
public void swap(int[] nums, int i, int j) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode wiggleSort 2
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

public void wiggleSortII(int[] nums) {
	if(nums.length < 2) return;
	Arrays.sort(nums);
	int len = nums.length,i = 0, mid, k = 0;
	mid = (len % 2 == 0)? len/2-1:len/2;
	int[] temp = new int[nums.length];
	while(i <= mid) {
		temp[k++] = nums[mid-i];
		if(k < nums.length) temp[k++] = nums[len-i-1];
		i++;
	}
	for(int j = 0; j < temp.length; j++) nums[j] = temp[j];
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

public boolean canFinish(int n, int[][] pre) {
        ArrayList[] graph = new ArrayList[n];
        Set<Integer> set1 = new HashSet<Integer>(), set2 = new HashSet<Integer>(), set3 = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
            set1.add(i);
        }
        for(int i = 0; i < pre.length; i++) {
            graph[pre[i][1]].add(pre[i][0]);
        }
        while(set1.size() > 0) {
            int v = set1.iterator().next();
            if(dfs(v,set1,set2,set3,graph)) return false;
        }
        return true;
    }
    public boolean dfs(int v,Set<Integer> set1, Set<Integer> set2, Set<Integer> set3, ArrayList[] graph) {
        move(v, set1, set2);
        ArrayList<Integer> list = graph[v];
        for(int n : list) {
            if(set3.contains(n)) continue;
            if(set2.contains(n)) return true;
            if(dfs(n,set1,set2,set3,graph)) return true;
        }
        move(v, set2, set3);
        return false;
    }
    public void move(int v,Set<Integer> src, Set<Integer> dst) {
        src.remove(v);
        dst.add(v);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

public int[] findOrder(int n, int[][] pre) {
        ArrayList[] graph = new ArrayList[n];
        Set<Integer> set1 = new HashSet<Integer>(), set2 = new HashSet<Integer>(), set3 = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < n ; i++) {
            set1.add(i);
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < pre.length; i++) {
            graph[pre[i][1]].add(pre[i][0]);
        }
        while(set1.size() > 0) {
            int k = set1.iterator().next();
            if(dfs(k,set1,set2,set3,graph,result)) return new int[0];
        }
        return result.stream().mapToInt(i->i).toArray();
        
    }
    public boolean dfs(int v, Set<Integer> set1, Set<Integer> set2, Set<Integer> set3, ArrayList[] graph, ArrayList<Integer> result) {
        move(v, set1, set2);
        ArrayList<Integer> list = graph[v];
        for(int n : list) {
            if(set3.contains(n)) continue;
            if(set2.contains(n)) return true;
            if(dfs(n,set1,set2,set3,graph,result)) return true;
        }
        result.add(0,v);
        move(v, set2, set3);
        return false;
    }
    public void move(int v, Set<Integer> src, Set<Integer> dst) {
        src.remove(v); 
        dst.add(v);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
134. Gas Station

There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
////////////////////////////////////////optimized 
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int extra = 0, prev = 0, start = 0;
        for(int i = 0; i < gas.length; i++) {
           extra += (gas[i]-cost[i]);
           if(extra < 0) {
               start = i+1;
               prev += extra;
               extra = 0;
           }
        }
        return (extra+prev < 0)?-1:start;
    }
///////////////////////////////////////// another
	public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
           if(helper(i, gas, cost)) return i;
        }
        return -1;
    }
    public boolean helper(int index, int[] gas, int[] cost) {
        int k = gas.length, i = 0, extra = 0;
        while(i < k) {
            extra += (gas[index] - cost[index]);
            if(extra < 0) return false;
            index = (index+1)%k;
            i++;
        }
        return true;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
93. Restore IP Addresses

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i < 4 && i < len-2; i++) {
            for(int j = i+1; j < i+4 && j < len-1; j++) {
                for(int k = j+1; k < j+4 && k < len; k++) {
                    String s1 = s.substring(0,i), s2 =s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return result;
    }
    public boolean isValid(String str) {
        if(str.length() == 0 || str.length() > 3 || (str.charAt(0)=='0' && str.length() > 1) || Integer.parseInt(str) > 255) 
        return false;
        return true;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
79. Word Search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
//// optimized 
	public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(dfs(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int count) {
        if(count == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(count) != board[i][j]) return false;
        board[i][j] = '*';
        boolean flag = (dfs(board,word,i-1,j,count+1) ||
                        dfs(board,word,i+1,j,count+1) ||
                        dfs(board,word,i,j-1,count+1) ||
                        dfs(board,word,i,j+1,count+1));
        board[i][j] = word.charAt(count);
        return flag;
    }
////////////////////////////// another but will not work for third case it will return true; but best for dfs
public boolean exist(char[][] board, String word) {
        if(board.length == 0) return false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(dfs(board,word,i,j,0,"")) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int count,String s) {
        if(count >= word.length()) return false;
        s+=board[i][j];
        if(s.equals(word)) return true;
        boolean left = false,right = false ,up = false,down = false;
		board[i][j] = '*';
        if(i-1 >= 0 && word.charAt(count+1) == board[i-1][j]) {
            left = dfs(board,word,i-1,j,count+1,s);
        }
         
        if(i+1 < board.length && word.charAt(count+1) == board[i+1][j]) {
            right = dfs(board,word,i+1,j,count+1,s);
        }
           
        if(j-1 >= 0 && word.charAt(count+1) == board[i][j-1]) {
            up = dfs(board,word,i,j-1,count+1,s);
        }
           
        if(j+1 < board[0].length && word.charAt(count+1) == board[i][j+1]) {
            down = dfs(board,word,i,j+1,count+1,s);
        }
		board[i][j] = word.charAt(count);
        return (left || right || up || down);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
211. Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
///////////////////////////////////// solution based on tries 
class TrieNode {
    TrieNode[] children;
    boolean eow;
    public TrieNode() {
        children = new TrieNode[26];
        eow = false;
    }
}
public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            if(current.children[word.charAt(i)-'a'] == null) {
                current.children[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i)-'a'];
        }
        current.eow = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode current = root;
        return helper(word,current,0);
    }
    public boolean helper(String word,TrieNode current, int count) {
        if(count == word.length()) return current.eow;
        if(word.charAt(count)=='.') {
            for(int i = 0; i < 26; i++) {
                if(current.children[i] != null && helper(word,current.children[i],count+1)) return true;
            }
            return false;
        }
        if(current.children[word.charAt(count)-'a'] == null) return false;
        else current = current.children[word.charAt(count)-'a'];
        return helper(word,current,count+1);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
///////////////////////////////////////////////////// another solution
public class WordDictionary {
    HashMap<Integer,List<String>> hm = new HashMap<Integer,List<String>>();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(!hm.containsKey(word.length())) hm.put(word.length(),new ArrayList<String>());
        hm.get(word.length()).add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(!hm.containsKey(word.length())) return false;
        else {
            List<String> list = hm.get(word.length());
            for(String str: list) {
                int i;
                for(i = 0; i < str.length(); i++) {
                    if(word.charAt(i) == '.') continue;
                    if(word.charAt(i) != str.charAt(i)) break;
                }
                if(i == str.length()) return true;
            }
            return false;
        }
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
208. Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children;
    boolean eow;
    public TrieNode() {
        children = new TrieNode[26];
        eow = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            if(current.children[word.charAt(i)-'a'] == null) {
                current.children[word.charAt(i)-'a'] = new TrieNode();
            }
            current = current.children[word.charAt(i)-'a'];
        }
        current.eow = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            if(current.children[word.charAt(i)-'a'] == null) return false;
            current = current.children[word.charAt(i)-'a'];
        }
        return current.eow;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            if(current.children[prefix.charAt(i)-'a'] == null) return false;
            current =current.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Walls and Gates

You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
import java.util.*;
public class WallGatesMain {
	public static void wallsGates(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				if(array[i][j] == 0) {
					dfs(array,i-1,j,1);
					dfs(array,i+1,j,1);
					dfs(array,i,j+1,1);
					dfs(array,i,j-1,1);
				}
			}
		}
		return;
	}
	public static void dfs(int[][] array, int i, int j, int count) {
		if(i < 0 || i >= array.length || j < 0 || j >= array[0].length || array[i][j] == 0 || array[i][j] == -1) return;
		int temp = Math.min(count, array[i][j]);
		array[i][j] = -1;
		dfs(array,i-1,j,count+1);
		dfs(array,i+1,j,count+1);
		dfs(array,i,j-1,count+1);
		dfs(array,i,j+1,count+1);
		array[i][j] = temp;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Problem Statement
    	Fabian is in charge of a law firm working on an important case. For a case coming up, he needs a specific folder which is stored in one of the filing cabinets arranged in a line against the wall of the records room. He has assigned a number of workers to find the folder from the filing cabinets. He doesn't want the workers to get in each other's way, nor does he want folders from different filing cabinets getting mixed up, so he has decided to partition the cabinets, and assign a specific section to each worker. Each worker will have at least 1 cabinet to search through.



More specifically, Fabian wants to divide the line of filing cabinets into N sections (where N is the number of workers) so that every cabinet that the ith worker looks through is earlier in the line than every cabinet that the jth worker has to look through, for i < j.



His initial thought was to make all the sections equal, giving each worker the same number of filing cabinets to look through, but then he realized that the filing cabinets differed in the number of folders they contained. He now has decided to partition the filing cabinets so as to minimize the maximum number of folders that a worker would have to look through. For example, suppose there were three workers and nine filing cabinets with the following number of folders:

10 20 30 40 50 60 70 80 90


He would divide up the filing cabinets into the following sections:

10 20 30 40 50 | 60 70 | 80 90


The worker assigned to the first section would have to look through 150 folders. The worker assigned to the second section would have to search through 130 folders, and the last worker would filter through 170 folders. In this partitioning, the maximum number of folders that a worker looks through is 170. No other partitioning has less than 170 folders in the largest partition.



Write a class FairWorkload with a method getMostWork which takes a int[] folders (the number of folders for each filing cabinet) and an int workers (the number of workers). The method should return an int which is the maximum amount of folders that a worker would have to look through in an optimal partitioning of the filing cabinets. For the above example, the method would have returned 170.
 

 public class WorkLoadMain {

	public static void main(String[] args) {
		int[] jobs = {10, 7, 8, 12, 6, 8};
		int workers = 4;
		System.out.println(minimumWorkLoad(jobs,workers));
	}
	public static int minimumWorkLoad(int[] jobs, int workers) {
		int left = 0, right = 0, maxJob = 0, result = 0, mid = 0;
		for(int i = 0; i < jobs.length; i++)  {
			maxJob = Math.max(maxJob, jobs[i]);
			right += jobs[i];
		}
		result = right;
		while(left <= right) {
			mid = (left + right)/2;
			if(mid >= maxJob && isPossible(mid,jobs, workers)) {
				result = Math.min(result, mid);
				right = mid - 1;
			}
			else left = mid + 1;
		}
		return result;
	}
	public  static boolean isPossible(int result, int[] jobs, int workers) {
		int count = 1, currentTime = 0, i = 0;
		while(i < jobs.length) {
			if(currentTime+jobs[i] > result)  {
				count++;
				currentTime = 0;
			}
			else {
				currentTime += jobs[i++];
			}
		}
		return (count <= workers);		
	}
0
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
DisJointSEt 
Design disjoint sets which supports makeSet, union and findSet operations. Uses union by rank and path compression for optimization.

import java.util.*;
class SetNode {
	int data, rank;
	SetNode parent;
	public SetNode(int data) {
		this.data = data;
		rank = 0;
		parent = this;
	}
}
class DisjointSet {
	HashMap<Integer,SetNode> hm;
	public DisjointSet() {
		hm = new HashMap<Integer,SetNode>();
	}
	public void makeSet(int data) {
		SetNode node = new SetNode(data);
		hm.put(data, node);
	}
	public void unionSet(int n1, int n2) {
		SetNode node1 = hm.get(n1);
		SetNode node2 = hm.get(n2);
		SetNode parent1 = findParent(node1);
		SetNode parent2 = findParent(node2);
		if(parent1 == parent2) return;
		if(parent1.rank >= parent2.rank) {
			parent1.rank = (parent1.rank == parent2.rank)?parent1.rank+1:parent1.rank;
			parent2.parent = parent1;
		}
		else parent1.parent = parent2;
	}
	public int findSet(int data) {
		SetNode current = hm.get(data);
		SetNode parent = findParent(current);
		return parent.data;
		
	}
	public SetNode findParent(SetNode node) {
		SetNode current = node.parent;
		if(current.parent == current) {
			return current;
		}
		node.parent = findParent(node.parent);
		return node.parent;
	}
}
public class DisjointSetMain {

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1); ds.makeSet(2); ds.makeSet(3); ds.makeSet(4); ds.makeSet(5);
		ds.makeSet(6); ds.makeSet(7);
		ds.unionSet(1, 2); ds.unionSet(2, 3); ds.unionSet(4, 5); ds.unionSet(6, 7);
		ds.unionSet(5, 6); ds.unionSet( 3, 7);
		System.out.println(ds.findSet(1)); 
		System.out.println(ds.findSet(2)); 
		System.out.println(ds.findSet(3)); 
		System.out.println(ds.findSet(4)); 
		System.out.println(ds.findSet(5)); 
		System.out.println(ds.findSet(6)); 
		System.out.println(ds.findSet(7)); 
	}

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Topological sort in graph

Generate topologically sorted order for directed acyclic graph. 

import java.util.*;
class Graph{
	int vertex;
	ArrayList[] graph;
	public Graph(int n, int[][] edges) {
		vertex = n;
		graph = new ArrayList[n];
		for(int i = 0; i < n; i++) graph[i] = new ArrayList<Integer>();
		for(int i = 0; i < edges.length; i++) {
			graph[edges[i][0]].add(edges[i][1]);
		}
	}
	public List<Integer> topologicalSort() {
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < vertex; i++) {
			if(!set.contains(i)) helper(stack,set,i);
		}
		while(!stack.isEmpty()) result.add(stack.pop());
		return result;
	}
	public void helper(Stack<Integer> result, Set<Integer> set, int current) {
		set.add(current);
		List<Integer> temp = graph[current];
		for(int i = 0; i < temp.size(); i++) {
			if(!set.contains(temp.get(i)))helper(result,set,temp.get(i));
		}
		result.push(current);
	}
}
public class TopologicalSortMain {

	public static void main(String[] args) {
		int array[][] = {{0,2},{1,2},{1,3},{2,4},{3,5},{4,7},{4,5},{5,6}};
		Graph graph = new Graph(8,array);
		List<Integer> result = graph.topologicalSort();
		System.out.println(result.toString());
	}

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

355. Design Twitter 

Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.
unfollow(followerId, followeeId): Follower unfollows a followee.
Example:

Twitter twitter = new Twitter();

// User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5);

// User 1's news feed should return a list with 1 tweet id -> [5].
twitter.getNewsFeed(1);

// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6);

// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.getNewsFeed(1);

// User 1 unfollows user 2.
twitter.unfollow(1, 2);

// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
twitter.getNewsFeed(1);

public class Twitter {
    HashMap<Integer,List<Tweet>> userTweet;
    HashMap<Integer,List<Integer>> followers;
    int count;
    class Tweet {
        int id, counter;
        public Tweet(int id) {
            this.id = id;
            counter = count++;
        }
    }
    class TweetCompare implements Comparator<Tweet>{
        public int compare(Tweet t1, Tweet t2) {
            return t2.counter-t1.counter;
        }
    }
    /** Initialize your data structure here. */
    public Twitter() {
        userTweet = new HashMap<Integer,List<Tweet>>();
        followers = new HashMap<Integer,List<Integer>>();
        count = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        if(!userTweet.containsKey(userId)) userTweet.put(userId,new ArrayList<Tweet>());
        userTweet.get(userId).add(0,tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<Integer>();
        List<Tweet> temp = new ArrayList<Tweet>();
        if(userTweet.containsKey(userId)) temp.addAll(userTweet.get(userId));
        if(followers.containsKey(userId)) {
            List<Integer> follower = followers.get(userId);
            for(Integer i: follower) {
                if(userTweet.containsKey(i)) temp.addAll(userTweet.get(i));
            }
        }
        Collections.sort(temp,new TweetCompare());
        for(int j = 0; j < 10 && j < temp.size(); j++) {
            result.add(temp.get(j).id);
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!followers.containsKey(followerId)) followers.put(followerId,new ArrayList<Integer>());
        if(!followers.containsKey(followeeId)) followers.put(followeeId, new ArrayList<Integer>());
        List<Integer> follower = followers.get(followerId);
        if(!follower.contains(followeeId)) {
            follower.add(followeeId);
            followers.put(followerId, follower);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
       if(followerId == followeeId) return;
       if(followers.containsKey(followerId)) {
           List<Integer> follower = followers.get(followerId);
           if(follower.contains(followeeId))  {
               follower.remove(follower.indexOf(followeeId));
               followers.put(followerId, follower);
           }
       }
    }
} 

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Paint House

There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
/// from index 1
//// currentRedCost = min(prevBlueCost, prevGreenCost) + currentRedCost;
	public static int paintHouseMinCost(int[][] cost) {
		if(cost.length == 0) return 0;
		int len = cost.length;
		for(int i = 1; i < len; i++) {
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		return Math.min(cost[len-1][0], Math.min(cost[len-1][1], cost[len-1][2]));
	}
	public static void main(String[] args) {
		int[][] cost = {{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
		System.out.println(paintHouseMinCost(cost));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Paint House II
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
Note:
All costs are positive integers.
Follow up:
Could you solve it in O(nk) runtime?

public static int paintHouseMinCost2(int[][] cost) {
		if(cost.length == 0 || cost.length > 1 && cost[0].length == 1) return 0;
		int n = cost.length-1, m = cost[0].length-1;
		for(int i = 1; i <= n; i++) {
			int[] min = findMin(cost[i-1]);
			for(int j = 0; j <= m; j++) {
				if(min[0] != j) cost[i][j] += cost[i-1][min[0]];
				else cost[i][j] += cost[i-1][min[1]]; 
			}
		}
		int result = Integer.MAX_VALUE;	
		for(int j = 0; j <= m; j++) {
			result = Math.min(result, cost[n][j]);
		}
		return result;
	}
	public static int[] findMin(int[] array) {
		int[] result = new int[2];
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			if(array[i] <= min1) {
				result[1] = result[0];
				result[0] = i;
				min2 = min1;
				min1 = array[i];
			}
			else if(array[i] <= min2) {
				result[1] = i;
				min2 = array[i];
			}
		}
		return result;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
LeetCode 281 - Zigzag Iterator

Suppose you have a Iterator class with has_next() and get_next() methods.
Please design and implement a ZigzagIterator class as a wrapper of two iterators.
For example, given two iterators:
i0 = [1,2,3,4]
i1 = [5,6]
ZigzagIterator it(i0, i1);

while(it.has_next()) {
    print(it.get_next());
}
The output of the above pseudocode would be [1,5,2,6,3,4].
/////////////////////// using list iterator
class ZigZagList {
	Iterator<Integer> i, j ,temp;
	public ZigZagList(List<Integer> l1, List<Integer> l2) {
		i = l2.iterator();
		j = l1.iterator();
	}
	public boolean hasNext() {
		return i.hasNext()||j.hasNext();
	}
	public int getNext() {
		if(j.hasNext()) { temp = i; i = j; j = temp; }
		return i.next();
	}
	
}
/////////////////////// using array 
class ZigZagIterator {
	int[] array1, array2;
	int i, j;
	boolean flag;
	public ZigZagIterator(int[] array1, int[] array2) {
		this.array1 = array1;
		this.array2 = array2;
		i = 0; j = 0; flag = true;
	}
	public boolean hasNext() {
		return (i < array1.length|| j < array2.length);
	}
	public int getNext(){
		if(!hasNext()) return -1;
		if(i < array1.length && j < array2.length) {
			if(flag) {
				flag = false;
				return array1[i++];
			}
			else {
				flag = true;
				return array2[j++];
			}
		}
		else if(i < array1.length) return array1[i++];
		else return array2[j++];
	}
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Number of Connected Components in an Undirected Graph
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges

public class ConnectedComponentMain {
	public static int connectedComponent(int n, int[][] array){
		ArrayList[] graphlist = new ArrayList[n];
		Set<Integer> set = new HashSet<Integer>();
		int counter = 0;
		for(int i = 0; i < n; i++) graphlist[i] = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++)  {
			graphlist[array[i][0]].add(array[i][1]);
			graphlist[array[i][1]].add(array[i][0]);
		}
		for(int i = 0; i < n; i++) {
			if(!set.contains(i)){ dfs(i,set,graphlist); counter++; }
		}
		return counter;
	}
	public static void dfs(int v, Set<Integer> set, ArrayList[] graph) {
		if(set.contains(v)) return;
		set.add(v);
		List<Integer> neighbours = graph[v];
		for(int n: neighbours) {
			if(!set.contains(n)) dfs(n,set,graph);
		}
	}
	public static void main(String[] args) {
		int[][] array = {{0, 1},{1, 2},{3, 4},{2, 3}};
		System.out.println(connectedComponent(5,array));
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
LeetCode 348 - Design Tic-Tac-Toe

Design a Tic-tac-toe game that is played between two players on a n x n grid.
You may assume the following rules:
A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
TicTacToe toe = new TicTacToe(3);
toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | | // Player 1 makes a move at (0, 0).
| | | |
toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | | // Player 2 makes a move at (0, 2).
| | | |
toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | | // Player 1 makes a move at (2, 2).
| | |X|
toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| | // Player 2 makes a move at (1, 1).
| | |X|
toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| | // Player 1 makes a move at (2, 0).
|X| |X|
toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| | // Player 2 makes a move at (1, 0).
|X| |X|
toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| | // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
Hint:
Could you trade extra space such that move() operation can be done in O(1)?
You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.

/////////////////////////////////// O(1) time 

class TicTacToe2 {
	int[] rows, cols;
	int diagonal, antiDiagonal;
	public TicTacToe2(int n) {
		rows = new int[n];
		cols = new int[n];
		diagonal = 0; antiDiagonal = 0;
	}
	public int move(int i, int j, int player) {
		int n = rows.length;
		int sign = (player == 1)?1:-1;
		rows[i]+=sign; cols[j]+=sign;
		if(i == j) diagonal+=sign;
		if(i+j+1 == n) antiDiagonal+=sign;
		if(Math.abs(rows[i]) == n || 
		   Math.abs(cols[j]) == n ||
		   Math.abs(diagonal) == n || 
		   Math.abs(antiDiagonal)== n) return player;
		return 0;
	}
}
/////////////////////////////////////O(n) time 

class TicTacToe {
	char[][] mat;
	boolean win;
	public TicTacToe(int n) {
		mat = new char[n][n];
		win = false;
	}
	public int move(int i, int j, int player) {
		char sign = (player == 1)?'X':'O';
		if(win) return -1;
		if(mat[i][j] == 'O' || mat[i][j] == 'X') return -1;
		mat[i][j] = sign;
		int n = mat.length;
		boolean flag1 = true, flag2 = true, flag3 = false, flag4 = false;
		if(i == j) flag3 = true;
		if(i+j+1 == n) flag4 = true;
		for(int k = 0; k < n; k++) {
			if(mat[k][j] != sign) flag1 = false;
			if(mat[i][k] != sign) flag2 = false;
			if(i == j && mat[k][k] != sign) flag3 = false;
			if(i+j+1 == n && mat[k][n-k-1] != sign) flag4 = false;
		}
		if(flag1 || flag2 || flag3 || flag4) win = true;
		return (flag1 || flag2 || flag3 || flag4 )?player:0;
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
357. Count Numbers with Unique Digits 
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Hint:

A direct way is to use the backtracking approach.
Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
Let f(k) = count of numbers with unique digits with length equals k.
f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].

public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int count = 9, result = 10;
        for(int i = 2; i <= n; i++) {
            count*=(9-i+2);
            result+=count;
        }
        return result;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode 156: Binary Tree Upside Down

Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},


    1
   / \
  2   3
 / \
4   5

return the root of the binary tree [4,5,2,#,#,3,1].


   4
  / \
 5   2
    / \
   3   1  
//// optimized  O(n) solution
public Node upsideDown2(Node root) {
		if(root == null|| root.leftNode == null && root.rightNode == null) return root;
		Node newNode = upsideDown2(root.leftNode);
		root.leftNode.leftNode = root.rightNode;
		root.leftNode.rightNode = root;
		root.leftNode = null; root.rightNode = null;
		return newNode;
	}
//////////// O(n) iterative 
	public Node upsideDown3(Node root) {
		Node next = null, prev = null, temp = null, curr = root;
		while(curr != null) {
			next = curr.leftNode;
			curr.leftNode = temp;
			temp = curr.rightNode;
			curr.rightNode = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
//////////// O(n2) solution
	public Node upsideDown(Node root) {
		if(root == null) return null;
		if(root.getLeftNode() == null && root.getRightNode() == null) return root;
		Node l = upsideDown(root.leftNode);
		Node r = upsideDown(root.rightNode);
		Node temp = l;
		while(l.rightNode != null) l = l.rightNode;
		l.leftNode = r;
		l.rightNode = root;
		root.leftNode = null; root.rightNode = null;
		return temp;		
	}
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
  Leetcode: 3Sum Smaller
  
 Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]

	public static int threeSum(int[] array,int k) {
		Arrays.sort(array);
		int count = 0;
		for(int i = 0; i <= array.length-3; i++) {
			int left = i+1,right = array.length-1;
			while(left < right) {
				if(array[i]+array[left]+array[right] < k) {
					count += (right-left);
					left++;
				}
				else right--;
			}
		}
		return count;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Verify preorder sequence of Binary Search Tree

You have an array of preorder traversal of Binary Search Tree ( BST). Your program should verify whether it is a correct sequence or not.

10,5,2,7,15 - true; 10,5,2,7,15,4 - false;

	public static boolean isPreorder2(int[] array) {
		if(array.length == 0) return false;
		int i = -1, low = Integer.MIN_VALUE;
		for(int n: array) {
			if(n < low) return false;
			while(i >= 0 && n > array[i]) low = array[i--];
			array[++i] = n;
		}
		return true;
	}
	public static boolean isPreorder(int[] array) {
		if(array.length == 0) return false;
		Stack<Integer> stack = new Stack<Integer>();
		int low = Integer.MIN_VALUE;
		for(int n: array) {
			if(n < low) return false;
			while(!stack.isEmpty() && n > stack.peek()) low = stack.pop();
			stack.push(n);
		}
		return true;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Binary Tree Longest Consecutive Sequence

Given a binary tree, find the length of the longest consecutive sequence path.
The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

	int max = 0;
	public int longestSequence(Node root) {
		if(root == null) return 0;
		helper1(root,root.getData(),0);
		return max;
	}
	public void helper1(Node root, int val, int count) {
		if(root == null) return;
		if(root.getData() == val) count++; 
		else count = 1;
		max = Math.max(max, count);
		helper1(root.leftNode,root.getData()+1,count);
		helper1(root.rightNode, root.getData()+1,count);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Count Univalue Subtrees
Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.
For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
int count = 0;
public int countUnivalueSubtree(Node root) {
	if(root == null) return 0;
	helper(root);
	return count;
}
public boolean helper(Node root) {
	if(root == null) return true;
	if(root.left == null && root.right == null) {
		count++; 
		return true;
	}
	boolean l = helper(root.left);
	boolean r = helper(root.right);
	if(l && r) {
		if(root.left == null && root.val == root.right.val || root.right == null && root.val == root.left.val
		   || root.val == root.left.val && root.val == root.right.val ) {
			count++; 
			return true;
		}
	}
	return false;
}
///////////////////// usint count array

	public int countUniTree(Node root) {
		if(root == null) return 0;
		int[] count = new int[1];
		helperUni(root, count);
		return count[0];
	}
	
	public boolean helperUni(Node root, int[] count) {
		if(root == null) return true;
		if(root.leftNode == null && root.rightNode == null) {
			count[0]++;
			return true;
		}
		boolean l = helperUni(root.leftNode, count);
		boolean r = helperUni(root.rightNode, count);
		if(l && r) {
			if(root.leftNode == null && root.data == root.rightNode.data ||
			   root.rightNode == null && root.data == root.leftNode.data ||
			   root.data == root.leftNode.data && root.data == root.rightNode.data) {
				count[0]++;
				return true;
			}
		}
		return false;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Inorder Successor in BST
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
Note: If the given node has no in-order successor in the tree, return null.
/////////////////////////////////// optimized 
	public int inOrderSuccessor2(Node root, int val) {
		if(root == null) return 0;
		int result = 0;
		while(root != null) {
			if(val < root.data) {
				result = root.data;
				root = root.leftNode;
			}
			else root = root.rightNode;
		}
		return result;
	}
////////////////////////////////// another
	public int inOrderSuccessor(Node root,int val) {
		if(root == null) return 0;
		Stack<Node> stack = new Stack<Node>();
		while(root.data != val) {
			stack.push(root);
			if(val < root.data) root = root.leftNode;
			else root = root.rightNode;
		}
		if(root.rightNode != null) {
			root = root.rightNode;
			while(root.leftNode != null) root = root.leftNode;
			return root.data;
		}
		else {
			while(!stack.isEmpty() && stack.peek().data < val) stack.pop();
			return (!stack.isEmpty())?stack.peek().data:0;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Find the Celebrity

Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

/////////The first pass is to pick out the candidate. If candidate knows i, then switch candidate. The second pass is to check whether the candidate is real.

public int findCelebrity(int[] array) {
	int candidate = 0;
	for(int i = 1; i < array.length; i++) {
		if(knows(candidate,i)) candidate = i;
	}
	for(int i = 0; i < array.length; i++) {
		if(i != candidate && (knows(candidate,i) || !knows(i,candidate))) return -1;
	}
	return candidate;
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
[LeetCode] Logger Rate Limiter recording rate limiter
 

The Design A Logger System that the receive Stream of messages along the with the ITS timestamps, the each Message SHOULD BE Printed IF and only IF IT IS Not Printed in at The Last 10 seconds The. The Given A Message and A timestamp (in seconds The granularity), return to true IF at The Message Printed in at The BE GIVEN SHOULD timestamp, otherwise Returns to false. It IS Possible messages that arrive Roughly AT 'several' at The Same Time. Example: Logger = Logger new new Logger (); // the logging String "foo" AT timestamp 1 logger.shouldPrintMessage (1 , "foo"); Returns to true; // the logging String "Bar" AT timestamp 2 logger.shouldPrintMessage (2, "Bar"); Returns to true; // the logging String "foo" AT timestamp 3 logger.shouldPrintMessage (3, " foo "); Returns to false; // the logging String" Bar "AT timestamp. 8 logger.shouldPrintMessage (. 8," Bar "); Returns to false; // the logging String" foo "AT timestamp 10 logger.shouldPrintMessage (10," foo " ); Returns to false; // the logging String "foo" AT timestamp. 11 logger.shouldPrintMessage (. 11, "foo"); Returns to true; Credits: Special Thanks to the this problem 


import java.util.*;
class Logger {
	HashMap<String, Integer> hm;
	public Logger() {
		hm = new HashMap<String,Integer>();
	}
	public boolean shouldPrintMessage(int timeStamp, String msg) {
		if(!hm.containsKey(msg)) {
			hm.put(msg, timeStamp);
			return true;
		}
		else {
			if(timeStamp < hm.get(msg)+10) return false;
			else {
				hm.put(msg, timeStamp);
				return true;
			}
		}
	}
}
public class LoggerMain {

	public static void main(String[] args) {
		Logger l = new Logger();
		System.out.println(l.shouldPrintMessage(1,"foo"));
		System.out.println(l.shouldPrintMessage(2,"Bar"));
		System.out.println(l.shouldPrintMessage(3,"foo"));
		System.out.println(l.shouldPrintMessage(8,"Bar"));
		System.out.println(l.shouldPrintMessage(10,"foo"));
		System.out.println(l.shouldPrintMessage(11,"foo"));
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

points

++++++
group the collinear points form set of points are return max group size

		array[0] = new LinePoint(-6,-5);
		array[1] = new LinePoint(-3,-3);
		array[2] = new LinePoint(0,0);
		array[3] = new LinePoint(3,1);
		array[4] = new LinePoint(6,3);
		array[5] = new LinePoint(1,1);
		array[6] = new LinePoint(2,2);
		array[7] = new LinePoint(3,3);
		array[8] = new LinePoint(4,4);
		System.out.println(isCollinear(array));
		
output 
(3,1)(-6,-5)(-3,-3)(6,3)
(1,1)(2,2)(0,0)(4,4)(-3,-3)(3,3)
6

import java.util.*;
class LinePoint {
	int x;
	int y;
	LinePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class ColinearPointMain {
	public static boolean collinear(LinePoint p1, LinePoint p2, LinePoint p3) {
		return (p2.y - p1.y)*(p3.x-p2.x) == (p3.y-p2.y)*(p2.x-p1.x);
	}
	public static int isCollinear(LinePoint[] array) {
		if(array.length == 0 || array.length == 1) return array.length;
		ArrayList<Set<LinePoint>> resultlist = new ArrayList<Set<LinePoint>>();
		int result = 2, count;
		for(int i = 0; i < array.length; i++) {
			for(int j = i+1; j < array.length; j++) {
				count = 2;
				Set<LinePoint> current = new HashSet<LinePoint>();
				current.add(array[i]);
				current.add(array[j]);
				for(int k = 0; k < array.length; k++)  {
					if(k == i || k == j) continue;
					if(collinear(array[i],array[j],array[k])) {						
						current.add(array[k]);
						count++;
					}
				}
				if(current.size()>2 && !resultlist.contains(current)) resultlist.add(current);
				result = Math.max(count, result);
			}
		}
		for(int i = 0; i < resultlist.size(); i++) {
			for(LinePoint p: resultlist.get(i)) {
				System.out.print("("+p.x+","+p.y+")");
			}
			System.out.println();
		}
		return result;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
remove dublicate points 

(2,3),(2,5), (2,2),(2,6),(2,6),(2,5),(2,2),(2,3),(2,2)

output : (2,2)(2,3)(2,5)(2,6)

class LinePoint implements Comparator<LinePoint>{
	int x;
	int y;
	LinePoint() { }
	LinePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int compare(LinePoint p1, LinePoint p2) {
		if(p1.x != p2.x) return p1.x-p2.x;
		else return p1.y-p2.y;
	}
	
}

	public static LinePoint[] removeDublicate(LinePoint[] array) {
		Arrays.sort(array, new LinePoint());
		int i = 0, j = -1;
		while(i < array.length) {
			if(i == 0) {
				array[++j] = array[i++];
			}
			else {
				if(array[j].x == array[i].x && array[j].y == array[i].y) i++;
				else array[++j] = array[i++];
			}
		}
		LinePoint[] result = new LinePoint[j+1];	
		/// System.arraycopy(array,0,result,0,j+1);
		for(i = 0; i < result.length;i++) {
			result[i] = array[i];
			System.out.print("("+array[i].x+","+array[i].y+")");
		}
		return result;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Leetcode: Strobogrammatic Number II
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Find all strobogrammatic numbers that are of length = n.
For example,
Given n = 2, return ["11","69","88","96"].

///////////// optimized iterative

	public static List<String> strobogrammatic(int n) {
		List<String> l1 = new ArrayList<String>(Arrays.asList(""));
		List<String> l2 = new ArrayList<String>(Arrays.asList("0","1","8"));
		if(n == 0) return l1; 
		if(n == 1) return l2;
		List<String> curr = (n % 2 == 0)?l1:l2;
		int i = (n % 2 == 0)?2:3;
		for(;i<=n; i+=2) {
			List<String> next = new ArrayList<String>();
			for(String s: curr) {
				if(i != n) next.add("0"+s+"0");
				next.add("1"+s+"1");
				next.add("8"+s+"8");
				next.add("6"+s+"9");
				next.add("9"+s+"6");
			}
			curr = next;
		}
		return curr;
	}
//////////////// another recursive

public static void StrobogrammaticNumber(int n) {
		List<String> result = helper(n,n);
		System.out.println(result.toString());
		return;
	}
	public static List<String> helper(int n, int m) {
		if(n == 0) return new ArrayList<String>(Arrays.asList(""));
		if(n == 1) return new ArrayList<String>(Arrays.asList("1","8","0"));
		List<String> temp = helper(n-2,m);
		List<String> curr = new ArrayList<String>();
		for(String s: temp) {
			if(n != m) curr.add("0"+s+"0");
			curr.add("1"+s+"1");
			curr.add("8"+s+"8");
			curr.add("6"+s+"9");
			curr.add("9"+s+"6");
		}
		return curr;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
284. Peeking Iterator

Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer curr = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    curr = iter.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return curr;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = curr;
	    curr = (iter.hasNext())?iter.next():null;
	    return temp;
	    
	}

	@Override
	public boolean hasNext() {
	    return (curr != null);
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Sort transformed array

Given a sorted array of integers and integer values a, b and c, apply a function of the form f(x) = ax^2+bx+c to each element x in the array.

The returned array should be sorted.

Example:

Given x = [-4 , -2 , 2 , 4] , a=1 , b=3 , c=5, output should be [3, 9, 15, 33].
Given x = [-4 , -2 , 2 , 4] , a=-1 , b=3 , c=5, output should be [-23, -5, 1, 7].

Expected time complexity : O(n);

	public static void transformedSort(int[] array, int a, int b, int c) {
		int left = 0, n = array.length-1, right = n;
		int[] result = new int[n+1];
		int index = (a >= 0)?n:0;
		while(left <= right) {
			if(a >= 0) {
				result[index--] = func(array[left],a,b,c) >= func(array[right],a,b,c) ? func(array[left++],a,b,c):func(array[right--],a,b,c);
			}
			else {
				result[index++] = func(array[left],a,b,c) <= func(array[right],a,b,c) ? func(array[left++],a,b,c): func(array[right--],a,b,c);
			}
		}
		for(int num: result) System.out.print(num+" ");
	}
	public static int func(int n, int a, int b, int c){
		return a * n * n + b * n+ c;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Detect Cycle in a an Undirected Graph

A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. A union-find algorithm is an algorithm that performs two useful operations on such a data structure:

Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.

Union: Join two subsets into a single subset.	

In this post, we will discuss an application of Disjoint Set Data Structure. The application is to check whether a given graph contains a cycle or not.

Union-Find Algorithm can be used to check whether an undirected graph contains cycle or not. Note that we have discussed an algorithm to detect cycle. This is another method based on Union-Find. This method assumes that graph doesn’t contain any self-loops.

	public static boolean isExistCycle(int n, int[][] edges) {
		int[] array = new int[n];
		Arrays.fill(array, -1);
		for(int i = 0; i < edges.length; i++) {
			int x = find(array,edges[i][0]);
			int y = find(array,edges[i][1]);
			if(x == y) return false;
			array[x] = y;   // this is union operation.
		}
		return true;
	}
	public static int find(int[] array, int i) {
		if(array[i] == -1) return i;
		return find(array,array[i]);
	}
	Time - O(n2) Space - O(n)
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: One Edit Distance

Given two strings S and T, determine if they are both one edit distance apart.

/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
      s: a B c
      t: a D c
 * 2) Delete 1 char from s: 
      s: a D  b c
      t: a    b c
 * 3) Delete 1 char from t
      s: a   b c
      t: a D b c
 */
 
	public static boolean isOneDistance(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
		if(len1 == 0 && len2 == 0 ||Math.abs(len1-len2)>1) return false;
		for(int i = 0; i < Math.min(len1, len2); i++) {
			if(s1.charAt(i)!= s2.charAt(i)) {
				if(len1 == len2) return s1.substring(i+1).equals(s2.substring(i+1));
				else if(len1 < len2) return s1.substring(i).equals(s2.substring(i+1));
				else return s1.substring(i+1).equals(s2.substring(i));
			}
		}
		return true; /// if both string's are same
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Reverse Words in a String II
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated by a single space.
For example,
Given s = "the sky is blue",
return "blue is sky the".
Could you do it in-place without allocating extra space?

/////////////////////////// if the input is string 

public static String reverseString(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			sb.insert(0, st.nextToken()+" ");			
		}
		return sb.toString().trim();
	}
///////////////////////////// if input is an array and operation should perfome in O(n) space and O(n.m) time
//// m = average word length
	public static String reverse(char[] array) {
		int left = 0, right = array.length-1,i=0;
		rearrange(array,left,right);
		for(;i < array.length; i++) {
			if(array[i] == ' ' ) {
				rearrange(array,left,i-1);
				left = i+1;
			}
		}
		rearrange(array,left,i-1);
		return new String(array);
	}
	public static void rearrange(char[] array,int i, int j) {
		while(i < j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++; j--;
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
[LeetCode] Line Reflection linear symmetry

Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

Example 1:
GIVEN Points = [[1,1], [- 1,1]] , return to true .

Example 2:
GIVEN Points = [[1,1], [- 1, -1]] , return to false .

Up the Follow:
Could you do of Better Within last O ( N 2 )?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.


The idea is quite simple. If there exists a line reflecting the points, then each pair of symmetric points will have their x coordinates adding up to the same value, including the pair with the maximum and minimum x coordinates. So, in the first pass, I iterate through the array, adding each point to the hash set, and keeping record of the minimum and maximum x coordinates. Then, in the second pass, I check for every point to the left of the reflecting line, if its symmetric point is in the point set or not. If all points pass the test, then there exists a reflecting line. Otherwise, not.

By the way, here, to hash the content of an array, rather than the reference value, I use Arrays.hashCode(int[]) first, and then re-hash this hash code. You can also use Arrays.toString(int[]) to first convey the 2d array to a string, and then hash the string. But the second method is slower.

	public static boolean isReflect(LinePoint[] points) {
		if(points.length == 0) return false;
		int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, sum;
		Set<Integer> set = new HashSet<Integer>();
		for(LinePoint p: points) {
			maxX = Math.max(maxX, p.x);  /// finding min and max we sure that these two are reflecting...
			minX = Math.min(minX, p.x);
			set.add(Arrays.hashCode(new int[]{p.x,p.y}));
		}
		sum = maxX + minX;
		for(LinePoint p: points) {
			if(!set.contains(Arrays.hashCode(new int[]{sum-p.x,p.y}))) return false;
		}
		return true;
	}
/////////////////// for general case if m and c is also given as input
public static boolean general(LinePoint[] array, int m, int c) {
		if(array.length == 0) return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for(LinePoint p: array) {
			set.add(Arrays.hashCode(new double[]{p.x,p.y}));
		}
		for(LinePoint p: array) {
			double[] newp = getReflection(p,m,c);
			if(!set.contains(Arrays.hashCode(newp))) return false;
		}
		return true;
	}
	public static double[] getReflection(LinePoint p, int m, int c) {
		double[] result = new double[2];
		double d = (p.x + (p.y-c)*m)/(1+Math.pow(m, 2));
		result[0] = 2*d - p.x;
		result[1] = 2*d*m - p.y + 2*c;
		return result;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Closest Binary Search Tree Value II

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)
//////////////////// usint two stack
	public List<Integer> getKClosest2(Node root, int k, double target) {
		if(root == null) return new ArrayList<Integer>();
		Stack<Integer> start = new Stack<Integer>();
		Stack<Integer> last = new Stack<Integer>();
		helperInorder(root,start,target,false);
		helperInorder(root,last,target,true);
		List<Integer> result = new ArrayList<Integer>();
		while(k-- > 0) {
			if(last.isEmpty()) result.add(start.pop());
			else if(start.isEmpty()) result.add(last.pop());
			else if(Math.abs(target-start.peek()) < Math.abs(target-last.peek())) 
				result.add(start.pop());
			else result.add(last.pop());
		}
		return result;
	}
	public void helperInorder(Node root, Stack<Integer> stack, double target, boolean reverse) {
		if(root != null) {
			helperInorder(!reverse?root.leftNode:root.rightNode,stack,target,reverse);
			if(!reverse && root.data > target || reverse && root.data <= target) return;
			stack.push(root.data);
			helperInorder(!reverse?root.rightNode:root.leftNode,stack,target,reverse);
		}
	}
/////////////////// using treeSet
	public List<Integer> getKClosest(Node root,int k,double target) {
		if(root == null) return new ArrayList<Integer>();
	    TreeMap<Double,List<Integer>> hm = new TreeMap<Double,List<Integer>>();
	    List<Integer> result = new ArrayList<Integer>();
		helperk(root,hm,target);
		int i = 1;
		for(List<Integer> l: hm.values()) {
			for(Integer val: l) {
				if(i <= k) {
					result.add(val);
					i++;
				}
				else break;
			}
		}
		return result;
	}
	public void helperk(Node root, TreeMap<Double,List<Integer>> hm, double k){
		if(root != null) {
			helperk(root.leftNode,hm,k);
			double diff = Math.abs(root.data - k);
			if(!hm.containsKey(diff)) hm.put(diff, new ArrayList<Integer>());
			hm.get(diff).add(root.data);
			helperk(root.rightNode,hm,k);
		}
	}
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Factor Combinations
Numbers can be regarded as product of its factors. For example,
8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.
Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

public static List<List<Integer>> getFactorCombo(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result,n,2,new ArrayList<Integer>());
		return result;
	}
	public static void helper(List<List<Integer>> result,int n,int start,List<Integer> list){
		if(n <= 1) {
			if(list.size() > 1) {
				result.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for(int i = start; i <= n; i++) {
			if(n % i == 0)  {
				list.add(i);
				helper(result,n/i,i,list);
				list.remove(list.size()-1);
			}
		}
	}
/////////////////////////////////////////// little modification

public static void helper(List<List<Integer>> result,int n,int start,List<Integer> list){
		if(n <= 1) {
			if(list.size() > 1) {
				result.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for(int i = start; i <= (int)Math.sqrt(n); i++) {
			if(n % i == 0)  {
				list.add(i);
				helper(result,n/i,i,list);
				list.remove(list.size()-1);
			}
		}
		int i = n;
		list.add(i);
		helper(result,n/i,i,list);
		list.remove(list.size()-1);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Binary Tree Vertical Order Traversal

Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.
Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]

int min1 = 0, max1 = 0;
	public void getVerticalGroup(Node root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		computeRange(root,0);
		Queue<Node> qNode = new LinkedList<Node>();
		Queue<Integer> qInd = new LinkedList<Integer>();
		for(int i = min1; i <= max1; i++) result.add(new ArrayList<Integer>());
		qNode.offer(root);
		qInd.offer(-min1);
		while(!qNode.isEmpty()) {
			Node currNode = qNode.poll();
			Integer ind = qInd.poll();
			result.get(ind).add(currNode.data);
			if(currNode.leftNode != null) {
				qNode.offer(currNode.leftNode);
				qInd.offer(ind-1);
			}
			if(currNode.rightNode != null) {
				qNode.offer(currNode.rightNode);
				qInd.offer(ind+1);
			}
		}
		for(List<Integer> list: result) System.out.println(list.toString());
	}
	public void computeRange(Node root,int col) {
		if(root == null) return;
		min1 = Math.min(min1, col);
		max1 = Math.max(max1, col);
		computeRange(root.leftNode,col-1);
		computeRange(root.rightNode,col+1);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
[LeetCode] Android Unlock Patterns Android unlock pattern

Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.
 



Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
 

The Move Invalid:  4 - 1 - 3 -. 6 
Line 1 - 3 thepassesproject through Key 2 Which HAD Not been in the Selected at The pattern.

The Move Invalid:  4 - 1 -. 9 - 2
Line 1 - 5. 9 thepassesproject through Key Not Which HAD been in the Selected at The pattern.

The Move! Valid:  2 - 4 - 1 - 3 -. 6
Line 1 - 3 IT IS Because Valid through thepassesproject Key 2, Which HAD been at The pattern in the Selected

The Move! Valid:  . 6 - 5 - 4 - 1 -. 9 - 2
Line 1 - Valid Because IT IS thepassesproject. 9 through Key 5, Which HAD been in the Selected at The pattern.

Example: 
the Given m = 1, N = 1, return. 9.

public static int numberOfPattern(int m, int n) {
		/*
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * 
		 */
		 // Skip array represents number to skip between two pairs
		int[][] skip = new int[10][10];
		boolean[] visited = new boolean[10];
		skip[1][3] = skip[3][1] = 2;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
		int ret = 0;
		// DFS search each length from m to n
		for(int i = m; i <= n; i++) {
			ret += DFS(skip,visited,1,i-1)*4;   // 1, 3, 7, 9 are symmetric
			ret += DFS(skip,visited,2,i-1)*4;	// 2, 4, 6, 8 are symmetric
			ret += DFS(skip,visited,5,i-1);		// 5
		}
		return ret;
	}
	public static int DFS(int[][] skip, boolean[] visited, int i, int k) {
		//if(k < 0) return 0;
		if(k == 0) return 1;
		visited[i] = true;
		int ret = 0;
		for(int j = 1; j <= 9; j++) {
			// If visited[j] is not visited and (two numbers are adjacent or skip number is already visited)
			if(!visited[j] && (skip[j][i] == 0 || visited[skip[j][i]])) {
				ret+=DFS(skip,visited,j,k-1);
			}
		}
		visited[i] = false;
		return ret;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
11. Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water. 

Note: You may not slant the container. 

public int maxArea(int[] height) {
        if(height.length == 0) return 0;
        int maxArea = 0, left = 0, right = height.length-1;
        while(left < right) {
            maxArea = Math.max(maxArea, (right-left)*Math.min(height[left],height[right]));
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram. 
/*
http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
*/
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.


For example,
 Given heights = [2,1,5,6,2,3],
 return 10

 public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int maxArea = 0,h;
        Stack<Integer> s = new Stack<Integer>();
        for(int i = 0; i <= heights.length; i++) {
            h = (i == heights.length)?0:heights[i];
            if(s.isEmpty() || h >= heights[s.peek()]) s.push(i);
            else {
                int ind = s.pop();
                maxArea = Math.max(maxArea, heights[ind]*(s.isEmpty()?i:i-s.peek()-1));
                i--;
            }
        }
        return maxArea;
    }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 201. Bitwise AND of Numbers Range
 
 Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4. 

 public int rangeBitwiseAnd(int m, int n) {
        while(m < n) n &= (n-1);
        return n;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Find the largest BST subtree in a given Binary Tree
 

Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.

Input: 
      5
    /  \
   2    4
 /  \
1    3

Output: 3 
The following subtree is the maximum size BST subtree 
   2  
 /  \
1    3


Input: 
       50
     /    \
  30       60
 /  \     /  \ 
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the maximum size BST subtree 
      60
     /  \ 
   45    70
        /  \
      65    80

	/// array[0]  - size array[1] - min, array[2] - max;
	static int maxSize = 0;

	public static int largestBST(Node root) {

	    if(root == null) return 0;

        helper(root,null);

		return maxSize;

	}

	public static int[] helper(Node root,Node parent) {

	    if(root == null) return new int[]{0,parent.data,parent.data};

	    int[] left = helper(root.left,root);

	    int[] right = helper(root.right,root);

	    if(left[0] == -1 || right[0] == -1 || root.data < left[2] || root.data > right[1]) {

	        left[0] = -1; left[1] = 0; left[2] = 0; 

	        return left;

	    }

	    int size = left[0]+right[0]+1;

	    maxSize = Math.max(maxSize,size);

	    left[0] = size; left[2] = right[2];

	    return left;

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Geek for Geek

Count the invesion in the array 

	public static int countInversion(int[] array) {
		if(array.length <= 1) return 0;	
		int[] temp = new int[array.length];
		return helper(array,temp,0,array.length-1);
	}
	public static int helper(int[] array,int[] temp, int left, int right) {	
		if(left >= right) return 0;
		int mid , count = 0;		
		mid = left + (right - left)/2;
		count += helper(array,temp,left,mid);
		count += helper(array,temp,mid+1,right);
		count += merge(array,temp,left, mid+1,right);		
		return count;
	}
	public static int merge(int[] array, int[] temp, int left, int mid, int right) {
		int i = left, j = mid, k = left, count = 0;
		while(i <= mid-1 && j <= right) {
			if(array[i] <= array[j]) temp[k++] = array[i++];
			else {
				temp[k++] = array[j++];
				count += mid - i;				
			}
		}
		while(i <= mid-1) temp[k++] = array[i++];
		while(j <= right) temp[k++] = array[j++];
		for(i = left; i <= right; i++) array[i] = temp[i];
		return count;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Geek for Geek 

Given two Binary Search Trees, find common nodes in them. In other words, find intersection of two BSTs

/*			5
		   /\
		  1  10
		 /\  /
		0  4 7
		      \
			   9
			   
			10
			/\
		   7  20
          /\ 
         4  9   		  
*/

public static void countCommonNode2(Node root1, Node root2) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		while(true) {
			if(root1 != null) {
				s1.push(root1);
				root1 = root1.leftNode;
			}
			else if(root2 != null) {
				s2.push(root2);
				root2 = root2.leftNode;
			}
			else if(!s1.isEmpty() && !s2.isEmpty()) {
				root1 = s1.peek();
				root2 = s2.peek();
				if(root1.data == root2.data) {
					System.out.print(root1.data+" ");
					s1.pop();
					s2.pop();
					root1 = root1.rightNode;
					root2 = root2.rightNode;
				}
				else if(root1.data < root2.data){
					s1.pop();
					root1 = root1.rightNode;
					root2 = null;
				}
				else {
					s2.pop();
					root2 = root2.rightNode;
					root1 = null;
				}
			}
			else break;
		}
	}
	////////////// another solution
	
	public static List<Integer> countCommonNode(Node root1, Node root2) {
		List<Integer> result = new ArrayList<Integer>();
		helper(root1,root2,result);
		return result;
	}
	public static void helper(Node root1, Node root2, List<Integer> result){
		if(root1 == null || root2 == null) return;
		if(root1.data == root2.data) {
			if(!result.contains(root1.data)) 
			result.add(root1.data);
			helper(root1.leftNode,root2.leftNode,result);
			helper(root1.rightNode,root2.rightNode,result);
		}
		else if(root1.data < root2.data) {
			helper(root1,root2.leftNode,result);
			helper(root1.rightNode,root2,result);
		}
		else {
			helper(root1.leftNode,root2,result);
			helper(root1,root2.rightNode,result);
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Print the corner node of the tree.  IMP

/*			5
		   /\
		  1  10
		 /\  /
		0  4 7
		      \
			   9
			   
			10
			/\
		   7  20
          /\ 
         4  9   		  
*/
output 1: 5 1 10 0 7 9 
output 2: 10 7 20 4 9 

public void printCornerNode(Node root) {
		if(root == null) return;
		boolean first = true, isOne = true;
		Node temp = null, prev = null;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root); q.offer(null);		
		while(!q.isEmpty()) {
			prev = temp;
			temp = q.poll();
			if(temp != null) {
				if(first) {
					System.out.print(temp.data+" ");
					first = false; isOne = true;
				}
				else {
					isOne = false;
				}
				if(temp.leftNode != null) q.offer(temp.leftNode);
				if(temp.rightNode != null) q.offer(temp.rightNode);
			}
			else {
				if(!isOne) System.out.print(prev.data+" ");
				first = true;
				if(!q.isEmpty()) q.offer(null);
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Pangram Checking
Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.

Examples : The quick brown fox jumps over the lazy dog ” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
“The quick brown fox jumps over the dog” is not a Pangram [Doesn’t contains all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing]

	public static boolean isPanagram(String str) {
		boolean[] flag = new boolean[26];
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') flag[str.charAt(i)-'A']= true;
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') flag[str.charAt(i)-'a'] = true;
		}
		for(boolean b: flag) if(!b) return false;
		return true;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
K’th Non-repeating Character
Given a string and a number k, find the k’th non-repeating character in the string. Consider a large input string with lacs of characters and a small character set. How to find the character by only doing only one traversal of input string?

Examples:

Input : str = geeksforgeeks, k = 3
Output : r
First non-repeating character is f,
second is o and third is r.

Input : str = geeksforgeeks, k = 2
Output : o

Input : str = geeksforgeeks, k = 4
Output : Less than k non-repeating
         characters in input.
		 
	public static char kthNonRepeating(String str, int k) {
		Set<Character> all = new HashSet<Character>();
		Set<Character> repeat = new HashSet<Character>();
		for(char ch: str.toCharArray()) {
			if(!all.add(ch)) repeat.add(ch);
		}
		int i = 0;
		for(char ch: str.toCharArray()) {
			if(!repeat.contains(ch)) {
				i++;
				if(i == k) return ch;
			}
		}
		return '\0';
	}
/////////////////////////////////////////////////// if length > 256 

	public static char kthNonRepeating2(String str, int k) {
		int[] count = new int[256];
		int[] index = new int[256];
		Arrays.fill(index, str.length());
		for(int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
			if(count[str.charAt(i)] == 1) index[str.charAt(i)] = i;
			else index[str.charAt(i)] = str.length();
		}
		Arrays.sort(index);
		return (index[k-1] != str.length())?str.charAt(index[k-1]):'\0';
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Generate all binary strings from given pattern
Given a string containing of ‘0’, ‘1’ and ‘?’ wildcard characters, generate all binary strings that can be formed by replacing each wildcard character by ‘0’ or ‘1’.

Input str = "1??0?101"
Output: 
        10000101
        10001101
        10100101
        10101101
        11000101
        11001101
        11100101
        11101101
		
		
	public static void printAllBinaryPatter(String str) {
		List<String> ret = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		helper(str,ret,sb,0);
		System.out.println(ret.toString());
		return;
	}
	public static void helper(String str, List<String> ret, StringBuilder sb, int start) {
		while(start < str.length() && str.charAt(start) != '?') sb.append(str.charAt(start++));
		if(start == str.length()) {
			System.out.println(sb.toString());
			ret.add(new String(sb.toString()));
			return;
		}
		helper(str,ret,sb.append('0'),start+1);
		sb.delete(start, sb.length());
		helper(str,ret,sb.append('1'),start+1);	
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find three closest elements from given three sorted arrays
Given three sorted arrays A[], B[] and C[], find 3 elements i, j and k from A, B and C respectively such that max(abs(A[i] – B[j]), abs(B[j] – C[k]), abs(C[k] – A[i])) is minimized. Here abs() indicates absolute value.

Example :

Input: A[] = {1, 4, 10}
       B[] = {2, 15, 20}
       C[] = {10, 12}
Output: 10 15 10
10 from A, 15 from B and 10 from C

Input: A[] = {20, 24, 100}
       B[] = {2, 19, 22, 79, 800}
       C[] = {10, 12, 23, 24, 119}
Output: 24 22 23
24 from A, 22 from B and 23 from C

	public static void getClosestNumber(int[] a1, int[] a2, int[] a3) {
		if(a1.length == 0|| a2.length == 0|| a3.length == 0) {
			System.out.println("Not possible");
			return;
		}
		int i = 0, j = 0, k = 0, eleA = 0, eleB = 0, eleC = 0, diff = Integer.MAX_VALUE;
		while(i < a1.length && j < a2.length && k < a3.length) {
			int min = Math.min(a1[i], Math.min(a2[j],a3[k]));
			int max = Math.max(a1[i], Math.max(a2[j], a3[k]));
			if(max - min < diff) {
				diff = max - min;
				eleA = a1[i]; eleB = a2[j]; eleC = a3[k];
			}
			if(min == a1[i]) i++;
			else if(min == a2[j]) j++;
			else k++;
		}
		System.out.println("Array 1:"+eleA+" Array 2:"+eleB+" Array 3:"+eleC);
		return;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find the element before which all the elements are smaller than it, and after which all are greater
Given an array, find an element before which all elements are smaller than it, and after which all are greater than it. Return index of the element if there is such an element, otherwise return -1.

Examples:

Input:   arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
Output:  Index of element is 4
All elements on left of arr[4] are smaller than it
and all elements on right are greater.
 
Input:   arr[] = {5, 1, 4, 4};
Output:  Index of element is -1
Expected time complexity is O(n).
/////////////////////////////////// optimized
	public static int getIndex(int[] array) {
		if(array.length == 0) return -1;
		if(array.length == 1) return array[0];
		int n = array.length-1;
		int[] beforeMax = new int[array.length];
		int afterMin = Integer.MAX_VALUE;
		beforeMax[0] = Integer.MIN_VALUE;
		for(int i = 1; i < array.length; i++) {
			beforeMax[i] = Math.max(beforeMax[i-1], array[i-1]);
		}
		for(int i = n; i >= 0; i--) {
			if(array[i] > beforeMax[i] && array[i] < afterMin) return i;
			afterMin = Math.min(array[i], afterMin);
		}
		return -1;
	}
/////////////////////////////////// another two array 
	public static int getIndex(int[] array) {
		if(array.length == 0) return -1;
		if(array.length == 1) return array[0];
		int n = array.length-1;
		int[] beforeMax = new int[array.length];
		int[] afterMin = new int[array.length];
		beforeMax[0] = array[0];
		afterMin[n] = array[n];
		for(int i = 1; i < array.length; i++) {
			beforeMax[i] = Math.max(beforeMax[i-1], array[i]);
			afterMin[n-i] = Math.min(afterMin[n-i+1], array[n-i]);
		}
		for(int i = 0; i < array.length; i++) {
			if(array[i] >= beforeMax[i] && array[i] <= afterMin[i]) return i;
		}
		return -1;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Search an element in an array where difference between adjacent elements is 1
Given an array where difference between adjacent elements is 1, write an algorithm to search for an element in the array and return the position of the element (return the first occurrence).

Examples:

Let element to be searched be x

Input: arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3} 	
       x = 3
Output: Element 3 found at index 7

Input: arr[] =  {1, 2, 3, 4, 5, 4}
       x = 5
Output: Element 5 found at index 4

	public static int getIndex(int[] array, int num) {
		int i = 0; 
		while(i < array.length) {
			if(array[i] == num) return i;
			i += Math.abs(array[i]-num);
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 4};
		System.out.println(getIndex(array,5));

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find the odd appearing element in O(Log n) time
Given an array where all elements appear even number of times except one. All repeating occurrences of elements appear in pairs and these pairs are not adjacent (there cannot be more than two consecutive occurrences of any element). Find the element that appears odd number of times.

Note that input like {2, 2, 1, 2, 2, 1, 1} is valid as all repeating occurrences occur in pairs and these pairs are not adjacent. Input like {2, 1, 2} is invalid as repeating elements don’t appear in pairs. Also, input like {1, 2, 2, 2, 2} is invalid as two pairs of 2 are adjacent. Input like {2, 2, 2, 1} is also invalid as there are three consecutive occurrences of 2.

Example:

Input: arr[] = {1, 1, 2, 2, 1, 1, 2, 2, 13, 1, 1, 40, 40, 13, 13}
Output: 13

Input: arr[] = {1, 1, 2, 2, 3, 3, 4, 4, 3, 600, 600, 4, 4}
Output: 3

public static int oddOccurance(int[] array) {
		if(array.length <= 1) return -1;
		int left = 0, right = array.length-1, mid;
		while(left < right) {
			mid = left + (right - left)/2;
			if(mid % 2 == 0) {
				if(array[mid] == array[mid+1]) left = mid + 2;
				else right = mid;
			}
			else {
				if(array[mid] == array[mid-1]) left = mid + 1;
				else right = mid - 1;
			}
		}
		return array[left];
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
above algorithm also works for 
Find the element that appears once in a sorted array
Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.

Example:

Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
Output:  4

Input:   arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output:  8
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find a pair with maximum product in array of Integers
Given an array with both +ive and -ive integers, return a pair with highest product.

Examples:

Input: arr[] = {1, 4, 3, 6, 7, 0}  
Output: {6,7}  

Input: arr[] = {-1, -3, -4, 2, 0, -5} 
Output: {-4,-5} 

	public static void printPair(int[] array) {
		int posMax = Integer.MIN_VALUE, posMax2 = Integer.MIN_VALUE;
		int nevMin = Integer.MAX_VALUE, nevMin2 = Integer.MAX_VALUE;
		for(int n: array) {
			if(n > posMax) {
				posMax2 = posMax;
				posMax = n;				
			}
			else if(n > posMax2) posMax2 = n;
			if(n < nevMin) {
				nevMin2 = nevMin;
				nevMin = n;
			}
			else if(n < nevMin2) nevMin2 = n;
		}
		if(posMax*posMax2 >= nevMin*nevMin2)System.out.println(posMax+" "+posMax2);
		else System.out.println(nevMin+" "+nevMin2);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
131. Palindrome Partitioning 

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]

 public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s.length() == 0) return result;
        List<String> current = new ArrayList<String>();
        helper(s,result,current,0);
        return result;
    }
    public void helper(String s, List<List<String>> result, List<String> current, int start) {
        if(start == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)) {
                current.add(s.substring(start,i+1));
                helper(s,result,current,i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right) {
        if(left == right) return true;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Palindrome Permutation
Given a string, determine if a permutation of the string could form a palindrome.
For example,
"code" -> False, "aab" -> True, "carerac" -> True.

	public static boolean isPossible(String str) {
		if(str.length() == 0) return false;
		Set<Character> set = new HashSet<Character>();
		for(char ch:str.toCharArray()) if(!set.add(ch)) set.remove(ch);
		return (set.size() <= 1);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Palindrome Permutation II
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
For example:
Given s = "aabb", return ["abba", "baab"].
Given s = "abc", return [].

import java.util.*;
public class PalindromPermutationAllMain {
	public static void printAllPelindrome(String str) {
		Map<Character,Integer> map = new HashMap<>();
		int odd = 0;
		String mid = "";
		for(char ch:str.toCharArray()) {
			map.put(ch,map.getOrDefault(ch, 0)+1);
			odd+=(map.get(ch)%2==0)?-1:1;
		}
		if(odd > 1) return;
		List<Character> charList = new ArrayList<Character>();
		List<Integer> count = new ArrayList<Integer>();
		for(Character key: map.keySet()) {
			int value = map.get(key);
			if(value % 2 != 0) {
				mid+=key;
				if(value > 1) {
					charList.add(key);
					count.add((value-1)/2);
				}
			}
			else {
				charList.add(key);
				count.add(value/2);
			}
		}
		int[] countArray = count.stream().mapToInt(i->i).toArray();
		List<String> result = new ArrayList<String>();
		helper(result,charList,countArray,new StringBuilder(),0,mid);
		System.out.println(result.toString());
		return;	
			
	}
	public static void helper(List<String> result, List<Character> list,int[] count,StringBuilder sb,int counter,String mid) {
		if(sb.length() == list.size()) {
			result.add(sb.toString()+mid+sb.reverse().toString());
			sb.reverse();
			return;
		}
		for(int i = 0; i < list.size(); i++) {			
			if(count[i]==0) continue;
			count[i]--;
			sb.append(list.get(i));
			helper(result,list,count,sb,counter+1,mid);
			sb.deleteCharAt(sb.length()-1);
			count[i]++;			
		}
	}
	public static void main(String[] args) {
		String str = "aabbccc";
		printAllPelindrome(str);
	}

}
output :- [abcccba, acbcbca, bacccab, bcacacb, cabcbac, cbacabc]
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String subset or string combination
String = "AABC";
output:-  [, A, AA, B, AB, AAB, C, AC, AAC, BC, ABC, AABC]
public static void getAllSubset(String str) {
		List<String> ret = new ArrayList<String>();
		ret.add("");
		for(char ch: str.toCharArray()) {
			int n = ret.size();
			for(int i = 0; i < n; i++) {
				if(!ret.contains(ret.get(i)+Character.toString(ch)))ret.add(ret.get(i)+Character.toString(ch));
			}
		}
		System.out.println(ret.toString());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Leetcode: Encode and Decode Strings
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.


	public static String encode(String[] sArray) {
		if(sArray.length == 0) return "";
		StringBuilder sb = new StringBuilder();
		for(String s: sArray) {
			sb.append(s.length()+"#");
			sb.append(s);
		}
		return sb.toString();
	}
////3#abc3#cde4#45nu7#dkljfoh0#11#aierkbfsadf
	public static List<String> decode(String s) {
		if(s.length() == 0) return new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int i = 0;
		while(i < s.length()) {
			int hashInd = s.indexOf('#',i);
			int size = Integer.valueOf(s.substring(i,hashInd));
			ret.add(s.substring(hashInd+1,hashInd+size+1));
			i = hashInd+size+1;
		}
		return ret;
	}
////[abc, cde, 45nu, dkljfoh, , aierkbfsadf]
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
310. Minimum Height Trees

For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

Show Hint 
Note:

(1) According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

(2) The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        ArrayList[] list = new ArrayList[n];
        for(int i = 0; i < n; i++) list[i] = new ArrayList<Integer>();
        for(int i = 0; i < edges.length; i++) {
            list[edges[i][0]].add(edges[i][1]);
            list[edges[i][1]].add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) if(list[i].size() == 1) leaves.add(i);
        while(n > 2) {
            n-=leaves.size();
            List<Integer> next = new ArrayList<Integer>();
            for(int i: leaves) {
                int j = (int)list[i].iterator().next();
                list[j].remove(list[j].indexOf(i));
                if(list[j].size() == 1) next.add(j);
            }
            leaves = next;
        }
        return leaves;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Keypad typing

ou are given N strings of alphabet characters and the task is to find their matching decimal representation as on the shown keypad. Output the decimal representation corresponding to the string. For ex: if you are given “amazon” then its corresponding decimal representation will be 262966.



Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line containing a string.

Output:

For each test case, print in a new line, the corresponding decimal representation of the given string.

Constraints:

1 ≤ T ≤ 100
1 ≤ length of String ≤ 100

Example:

Input
2
geeksforgeeks
geeksquiz

Output
4335736743357
433577849

class GFG {
    public static void printNumber(String str) {
        if(str.length() == 0) System.out.println("");
        StringBuilder sb = new StringBuilder();
        str = str.toLowerCase();
        for(char ch: str.toCharArray()) {
            if(ch >= 'a' && ch <= 'r') {
                int k = ch-'a';
                sb.append(k/3+2);
            }
            else if(ch == 's') sb.append(7);
            else if(ch >= 't' && ch <= 'v') sb.append(8);
            else if(Character.isLetter(ch)) sb.append(9);
            else {
                System.out.println("Not possible"); break;
            }
        }
        System.out.println(sb.toString());
    }
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine().trim().toString());
		for(int i = 0; i < n; i++) {
		    printNumber(br.readLine().trim());
		}
		
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Angle between hour and minute hand
Calculate the angle between hour hand and minute hand.

There can be two angles between hands, we need to print minimum of two. Also, we need to print floor of final result angle. For example, if the final angle is 10.61, we need to print 10.

 

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consists of one line conatining two space separated numbers h and m where h is hour and m is minute.

Output:
Coresponding to each test case, print the angle b/w hour and min hand in a separate line.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 12
1 ≤ A[i] ≤ 60

Example:

Input
2
9 60
3 30

Output
90
75

	public static void printAngle(double hour, double minute) {
        minute %= 60;
        double hAngle = hour*30 + minute/2;
        double mAngle = minute*6;
        double ret = Math.abs(hAngle-mAngle);
        if(ret > 180) ret = 360 - ret;
        System.out.println((int)Math.floor(ret));
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.valueOf(br.readLine().trim());
		for(int i = 0; i < n; i++) {
		    String[] str = br.readLine().split(" ");
		    printAngle(Double.valueOf(str[0]),Double.valueOf(str[1]));
		}
	    
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Generate Binary Numbers

Given a number n, Write a program that generates and prints all binary numbers with decimal values from 1 to n.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print all binary numbers with decimal values from 1 to n in a single line.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 500

Example:

Input
2
2
5

Output
1 10
1 10 11 100 101
 
 
 public static void printBinary(int n) {
        if(n == 0) System.out.println(0);
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        System.out.print(sb.toString());
        for(int i = 2; i <=n ; i++) {
            sb = new StringBuilder(helper(sb.toString()));
            System.out.print(" "+sb.toString());
        }
        System.out.println();
    }
    public static String helper(String str) {
        int count = 1, i = str.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i >= 0) {
            if(str.charAt(i) == '1' && count == 1) {
                sb.insert(0,0); count = 1;
            }
            else if(str.charAt(i) == '0' && count == 1) {
                sb.insert(0,1); break;
            }
            i--;
        }
        return (i >= 0)?sb.insert(0,str.substring(0,i)).toString():sb.insert(0,1).toString();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
287. Find the Duplicate Number

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
////////////////////// optimized 
public int findDuplicate(int[] nums) {
        if(nums.length <= 1) return -1;
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
////////////////////// another 

public int findDuplicate(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) if((nums[i]^nums[i-1]) == 0) return nums[i];
        return -1;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void isItCorrect(char[][] chars, int row, int col, int guess) {
        boolean flag = false;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(chars[i][j] == 'M') {
                    flag = dfs(chars,i-1,j,guess,1,0) ||
                       dfs(chars,i+1,j,guess,1,0) ||
                       dfs(chars,i,j-1,guess,1,1) ||
                       dfs(chars,i,j+1,guess,1,1);
                }
            }
        }
        if(flag) System.out.println("Impressed"); else System.out.println("Oops!");
    }  
    public static boolean dfs(char[][] chars, int i, int j, int guess, int count, int dir) {
        if(i < 0 || j < 0 || i == chars.length || j == chars[0].length || chars[i][j] == 'X' || chars[i][j] = '#') return false;
        if(chars[i][j] == '*' && count == guess) return true;
        char temp = chars[i][j];
        chars[i][j] = '#';
        if(dfs(chars, i-1,j,guess,(dir == 0)?count:count+1,(dir == 0)?0:1) ||
        dfs(chars, i+1,j,guess,(dir == 0)?count:count+1,(dir == 0)?0:1) ||
        dfs(chars, i,j-1,guess,(dir == 1)?count:count+1,(dir == 1)?1:0) ||
        dfs(chars, i,j+1,guess,(dir == 1)?count:count+1,(dir == 1)?1:0)) return true;
        chars[i][j] = temp;
        return false; 
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.valueOf(br.readLine().trim());
        for(int j = 0; j < l; j++) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.valueOf(s[0]);
            int m = Integer.valueOf(s[1]);
            char[][] chars = new char[n][m];
            for(int i = 0; i < n; i++) {
                chars[i] = br.readLine().trim().toCharArray();
            }
            int guess = Integer.valueOf(br.readLine().trim());
            isItCorrect(chars,n,m,guess);
        }
    }	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Longest Common Prefix | Set 2 (Character by Character Matching)
Given a set of strings, find the longest common prefix.

Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output : "gee"

Input  : {"apple", "ape", "april"}
Output : "ap"

public static String printPrefix(String[] array) {
		String temp = array[0];
		int l = 0;
		boolean flag = true;
		while(flag && l < temp.length()) {
			for(int i = 1; i < array.length; i++) {
				if(l == array[i].length()|| array[i].charAt(l)!=temp.charAt(l)) return temp.substring(0,l);
			}
			l++;
		}
		return temp;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Count pairs with given sum
Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.

Examples:
Input  :  arr[] = {1, 5, 7, -1}, 
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5}, 
          sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &
                     (1, 5)         

Input  :  arr[] = {1, 1, 1, 1}, 
          sum = 2
Output :  6
There are 3! pairs with sum 2.

Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
                   5, 4, 2, 1, 1, 1}, 
          sum = 11
Output :  9
Expected time complexity O(n)


	public static int countPair(int[] array, int sum) {
		if(array.length <= 1) return 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		int count = 0;
		for(int i = 0;i < array.length; i++) {
			if(hm.containsKey(sum-array[i])) count+= hm.get(sum-array[i]);
			hm.put(array[i], hm.getOrDefault(array[i],0)+1);
		}
		return count;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Largest Sum Contiguous Subarray
Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum. 

Kadane’s Algorithm:
{-2, -3, 4, -1, -2, 1, 5, -3}
output : 7
public static int kadeneMaxSubarraySum(int[] array) {
		int currSum = array[0], ret = array[0];
		for(int n: array) {
			currSum = Math.max(n,currSum+n);
			ret = Math.max(ret, currSum);
		}
		return ret;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
little modification in above algorithm to find lowest sum contiguous subArray
{-2, -3, 4, -1, -2, 1, 5, -3}
output : -5
/// first invert the intire array 
/// then find the max sum subArray using kandene and store result in the temp array
/// then invert this temp array and find minimum in this array and return it
/// we can modify it by making sum changes

	public static int kadeneMinSubarraySum(int[] array) {
		int currSum = -array[0], ret = -array[0];
		for(int i = 1; i < array.length; i++) {
			currSum = Math.max(-array[i],currSum-array[i]);
			ret = Math.max(ret, currSum);
		}
		return -ret;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Maximum absolute difference between sum of two contiguous sub-arrays
Given an array of integers, find two non-overlapping contiguous sub-arrays such that the absolute difference between the sum of two sub-arrays is maximum.

For example,

Input: [-2, -3, 4, -1, -2, 1, 5, -3]
Output: 12
Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]

Input: [2, -1, -2, 1, -4, 2, 8]
Output: 16
Two subarrays are [-1, -2, 1, -4] and [2, 8] 

public static int[] getLeftMax(int[] array) {
		int[] ret = new int[array.length];
		int maxCurr = ret[0] = array[0],  maxSoFar = array[0];
		for(int i = 1; i < array.length; i++) {
			maxCurr = Math.max(array[i], maxCurr+array[i]);
			maxSoFar = Math.max(maxSoFar, maxCurr);
			ret[i] = maxSoFar; 
		}
		return ret;
	}
	public static int[] getRightMax(int[] array) {
		int n = array.length-1;
		int[] ret = new int[array.length];
		int maxCurr = ret[n] = array[n], maxSoFar = array[n];
		for(int i = n-1; i >= 0; i--) {
			maxCurr = Math.max(array[i], maxCurr+array[i]);
			maxSoFar = Math.max(maxSoFar, maxCurr);
			ret[i] = maxSoFar;
		}
		return ret;
	}
	public static int twoSubArrayMaxSum(int[] array) {
		int[] leftMax = getLeftMax(array);
		int[] rightMax = getRightMax(array);
		for(int i = 0; i < array.length; i++) array[i] = -array[i];
		int[] leftMin = getLeftMax(array);
		int[] rightMin = getRightMax(array);
		for(int i = 0; i < array.length; i++) array[i] = -array[i];
		for(int i = 0; i < array.length; i++) leftMin[i] = -leftMin[i];
		for(int i = 0; i < array.length; i++) rightMin[i] = -rightMin[i];
		int ret = Integer.MIN_VALUE;
		for(int i = 0; i < array.length-1; i++) {
			ret = Math.max(ret, Math.abs(rightMax[i+1]-leftMin[i]));
			ret = Math.max(ret, Math.abs(leftMax[i]-rightMin[i+1]));
		}
		return ret;
	}
//////////////////// little modification combined two methods in one
	public static int[] getSum(int[] array, boolean f) {
		int[] ret = new int[array.length];
		int n = array.length-1,i;
		int maxCurr = ret[(f)?0:n]= array[(f)?0:n],  maxSoFar = array[(f)?0:n];
		for(i = (f)?1:n-1; (f)?i < array.length:i>=0;) {
			maxCurr = Math.max(array[i], maxCurr+array[i]);
			maxSoFar = Math.max(maxSoFar, maxCurr);
			ret[i] = maxSoFar; 
			if(f)i++; else i--;
		}
		return ret;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Maximum circular subarray sum
Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.

Examples:

Input: a[] = {8, -8, 9, -9, 10, -11, 12}
Output: 22 (12 + 8 - 8 + 9 - 9 + 10)

Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1} 
Output:  23 (7 + 6 + 5 - 4 -1 + 10) 

Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
There can be two cases for the maximum sum:

Case 1: The elements that contribute to the maximum sum are arranged such that no wrapping is there. Examples: {-10, 2, -1, 5}, {-2, 4, -1, 4, -1}. In this case, Kadane’s algorithm will produce the result.

Case 2: The elements which contribute to the maximum sum are arranged such that wrapping is there. Examples: {10, -12, 11}, {12, -5, 4, -8, 11}. In this case, we change wrapping to non-wrapping. Let us see how. Wrapping of contributing elements implies non wrapping of non contributing elements, so find out the sum of non contributing elements and subtract this sum from the total sum. To find out the sum of non contributing, invert sign of each element and then run Kadane’s algorithm.
Our array is like a ring and we have to eliminate the maximum continuous negative that implies maximum continuous positive in the inverted arrays.

	public static int getMaxSubArray(int[] array) {
		int maxCurr = array[0], maxSoFar = array[0];
		for(int i = 1; i < array.length; i++) {
			maxCurr = Math.max(array[i], maxCurr+array[i]);
			maxSoFar = Math.max(maxSoFar, maxCurr);
		}
		return maxSoFar;
	}
	public static int cirCularSum(int[] array) {
		int sum1 = getMaxSubArray(array);
		int sum2 = 0;
		for(int i = 0; i < array.length; i++) {
			sum2 += array[i];
			array[i] = -array[i];
		}
		sum2 += getMaxSubArray(array);
		return Math.max(sum1, sum2);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the intgers in the subsequence are sorted in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10

	public static int getSum(int[] array) {
		if(array.length == 0) return 0;
		int[] dp = new int[array.length];
		int ret = array[0];
		Arrays.fill(dp,Integer.MIN_VALUE);
		dp[0] = array[0];
		for(int i = 1; i < array.length; i++) {
			for(int j = 0; j < i; j++) {
				if(array[i] > array[j] && array[i]+dp[j] > dp[i]) {
					dp[i] = array[i]+dp[j];
					ret = Math.max(dp[i], ret);
				}
			}
		}
		return ret;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find if string is K-Palindrome or not
Given a string, find out if the string is K-Palindrome or not. A k-palindrome string transforms into a palindrome on removing at most k characters from it.

Examples :

Input : String - abcdecba, k = 1
Output : Yes
String can become palindrome by remo-
-ving 1 character i.e. either d or e)


Input  : String - abcdeca, K = 2
Output : Yes
Can become palindrome by removing
2 characters b and e.

Input : String - acdcb, K = 1
Output : No
String can not become palindrome by
removing only one character.
//////////////// dynamic programming for this
public static int helper2(String s1, String s2) {
		int n = s1.length();
		int[][] dp = new int[n+1][n+1];
		for(int i = 0; i < n; i++) {
			dp[i][0] = i;
			dp[0][i] = i;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[n][n];
	}
//////////////////////////////// with recurrsion
public static boolean isKPalindrom(String str, int k) {
		if(str.length() == 0) return false;
		int n = str.length();
		StringBuilder sb = new StringBuilder(str);
		int count = helper(str, sb.reverse().toString(),n,n);
		return count <= k*2;
	}
	public static int helper(String s1, String s2, int n, int m) {
		if(n == 0) return m;
		if(m == 0) return n;
		if(s1.charAt(n-1) == s2.charAt(m-1)) return helper(s1,s2,n-1,m-1);
		else return 1 + Math.min(helper(s1,s2,n-1,m),helper(s1,s2,n,m-1));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Dynamic Programming | Set 5 (Edit Distance)
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

public static int editDistanceDP(String s1, String s2) {
		int n = s1.length(), m = s2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i <= n; i++) dp[i][0] = i;
		for(int j = 0; j <= m; j++) dp[0][j] = j;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
				else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]);
				}				
			}
		}
		return dp[n][m];
	}
/////////////////////////////////// recurssive
	public static int editDistance(String s1, String s2) {
		if(s1.length() == 0 && s2.length() == 0) return 0;
		return helper(s1,s2,s1.length(),s2.length());
	}
	public static int helper(String s1, String s2, int n, int m) {
		if(m == 0) return n;
		if(n == 0) return m;
		if(s1.charAt(n-1) == s2.charAt(m-1)) return helper(s1, s2, n-1, m-1);
		else return 1 + Math.min(helper(s1,s2,n-1,m), 
						Math.min(helper(s1,s2,n,m-1), 
						helper(s1,s2,n-1,m-1)));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find maximum length Snake sequence
Given a grid of numbers, find maximum length Snake sequence and print it. If multiple snake sequences exists with the maximum length, print any one of them.

A snake sequence is made up of adjacent numbers in the grid such that for each number, the number on the right or the number below it is +1 or -1 its value. For example, if you are at location (x, y) in the grid, you can either move right i.e. (x, y+1) if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1.

For example,

9, 6, 5, 2
8, 7, 6, 5
7, 3, 1, 6
1, 1, 1, 7

In above grid, the longest snake sequence is: (9, 8, 7, 6, 5, 6, 7)
/////////////////////// optimal using dynamic programming
public static List<Integer> snakeSeq(int[][] array) {
		List<Integer> ret = new ArrayList<Integer>();
		int maxLen = 0, maxI = 0, maxJ = 0;
		int n = array.length, m = array[0].length;
		int[][] dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(i == 0 && j == 0) continue;
				if(i > 0 && Math.abs(array[i-1][j] - array[i][j]) == 1){
					dp[i][j] = Math.max(dp[i][j],dp[i-1][j] + 1);
					if(dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						maxI = i; maxJ = j;
					}
				}
				if(j > 0 && Math.abs(array[i][j-1] - array[i][j]) == 1) {
					dp[i][j] = Math.max(dp[i][j],dp[1][j-1] + 1);
					if(dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						maxI = i; maxJ = j;
					}
				}
			}
		}
		ret.add(0,array[maxI][maxJ]);
		while(dp[maxI][maxJ] != 0) {
			if(maxI > 0 && dp[maxI][maxJ] - 1 == dp[maxI-1][maxJ]) {
				ret.add(0,array[maxI-1][maxJ]);
				maxI--;
			}
			else if(maxJ > 0 && dp[maxI][maxJ] - 1 == dp[maxI][maxJ-1]) {
				ret.add(0,array[maxI][maxJ-1]);
				maxJ--;
			}
		}
		return ret;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Minimum time to finish tasks without skipping two consecutive
Given time taken by n tasks. Find the minimum time needed to finish the tasks such that skipping of tasks is allowed, but can not skip two consecutive tasks.

Examples :

Input : arr[] = {10, 5, 7, 10}
Output : 12
We can skip first and last task and
finish these task in 12 min.

Input : arr[] = {10}
Output : 0
There is only one task and we can
skip it.

Input : arr[] = {10, 30}
Output : 10

Input : arr[] = {10, 5, 2, 4, 8, 6, 7, 10}
Output : 22
Expected Time Complexity is O(n) and extra space is O(1).

public static int getMinTime(int[] array) {
		if(array.length <= 1) return 0;
		int take = array[0], avoid = 0;
		for(int i = 1; i < array.length; i++) {
			int temp = Math.min(take, avoid);
			avoid = take;
			take = temp + array[i];
		}
		return Math.min(take, avoid);
	}

/////////////////////// another dfs

public static List<Integer> getSnakeSequence(int[][] array) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[0].length; j++) {
				curr.add(array[i][j]);
				dfs(array,ret,curr,i+1,j,array[i][j]);
				dfs(array,ret,curr,i,j-1,array[i][j]);
				curr.remove(curr.size()-1);
			}
		}
		return ret.get(0);
	}
	public static void dfs(int[][] array,List<List<Integer>> ret, List<Integer> curr, int i, int j, int prev) {
		if(i < 0 || j < 0 || i == array.length || j == array[0].length || Math.abs(array[i][j]-prev)!=1) return;
		curr.add(array[i][j]);
		if(curr.size() > ret.size()) ret.add(0,new ArrayList<Integer>(curr));
		dfs(array,ret,curr,i+1,j,array[i][j]);
		dfs(array,ret,curr,i,j+1,array[i][j]);
		curr.remove(curr.size()-1);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Pair with given product | Set 1 (Find if any pair exists)
Given an array and a number x, find if there is a pair with product equal to x.

Examples :

Input : arr[] = {10, 20, 9, 40};
        int x = 400;
Output : Yes

Input : arr[] = {10, 20, 9, 40};
        int x = 190;
Output : No

Input : arr[] = {-10, 20, 9, -40};
        int x = 400;
Output : Yes

Input : arr[] = {-10, 20, 9, 40};
        int x = -400;
Output : Yes

Input : arr[] = {0, 20, 9, 40};
        int x = 0;
Output : Yes
///////////////////////////////// optimized
public static boolean isExistPair(int[] array, int x) {
		if(array.length <= 1) return false;
		Set<Integer> set = new HashSet<Integer>();
		for(int n: array) {
			if(n == 0) {
				if(n == x) return true;
				continue;
			}
			if(x % n == 0 && set.contains(x/n)) return true;
			set.add(n);
		}
		return false;
	}
//////////////////////////////// another
public static boolean isExistPair(int[] array, int x) {
		if(array.length <= 1) return false;
		Set<Double> set = new HashSet<Double>();
		for(int n: array) {
			if(n == 0) {
				if(n == x) return true;
				continue;
			}
			if(set.contains((double)x/n)) return true;
			set.add((double)n);
		}
		return false;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find maximum product of a triplet in array
Given an integer array, find a maximum product of a triplet in array.

Examples:

Input:  [10, 3, 5, 6, 20]
Output: 1200
Multiplication of 10, 6 and 20
 
Input:  [-10, -3, -5, -6, -20]
Output: -90

Input:  [1, -4, 3, -6, 7, 0]
Output: 168

	public static int getMaxTripletProduct(int[] array) {
		if(array.length <= 2) return 0;
		int max1, max2, max3, min1, min2;
		max1 = max2 = max3 = Integer.MIN_VALUE;
		min1 = min2 = Integer.MAX_VALUE;
		for(int n : array) {
			if(n > max1) { max3 = max2; max2 = max1; max1 = n; }
			else if(n > max2) { max3 = max2; max2 = n; }
			else if(n > max3) { max3 = n; }
			if(n < min1) { min2 = min1; min1 = n; }
			else if(n < min2) { min2 = n; }
		}
		return Math.max(max1*max2*max3, max1*min1*min2);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Count pairs formed by distinct element sub-arrays
Given an array, count number of pairs that can be formed from all possible contiguous sub-arrays containing distinct numbers. The array contains positive numbers between 0 to n-1 where n is the size of the array.

Examples:

Input:  [1, 4, 2, 4, 3, 2]
Output: 8
The subarrays with distinct elements 
are [1, 4, 2], [2, 4, 3] and [4, 3, 2].
There are 8 pairs that can be formed 
from above array.
(1, 4), (1, 2), (4, 2), (2, 4), (2, 3),
(4, 3), (4, 2), (3, 2)


Input:  [1, 2, 2, 3]
Output: 2
There are 2 pairs that can be formed
from above array.
(1, 2), (2, 3)
///////
The idea is to use Sliding Window for the given array. Let us use a window covering from index left to index right and an Boolean array visited to mark elements in current window. The window invariant is that all elements inside the window are distinct. We keep on expanding the window to the right and if a duplicate is found, we shrink the window from left till all elements are distinct again. We update the count of pairs in current window along the way. An observation showed that in an expanding window, number of pairs can be incremented by value equal to window size – 1. For example,

Expanding Window   Count
  
[1]              Count = 0

[1, 2]           Count += 1 pair  
                 i.e. (1, 2)

[1, 2, 3]        Count += 2 pairs 
                 i.e. (1, 3) and (2, 3)

[1, 2, 3, 4]     Count += 3 pairs 
                 i.e. (1, 4), (2, 4) 
                 and (3, 4)
So, total Count for above window of size 4 containing distinct elements is 6. Nothing need to be done when the window is shrinking.
	public static int countPair2(int[] array) {
		if(array.length <= 1) return 0;
		int count = 0,i = 0; 
		Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
		List<Integer> list = new ArrayList<Integer>();
		while(i < array.length) {
			if(!hm.containsKey(array[i])) {
				list.add(array[i]);
				count+=(list.size()-1);
				hm.put(array[i], i++);
			}
			else {
				list = new ArrayList<Integer>();
				i = hm.get(array[i])+1;
				hm.remove(array[i]);
			}
		}
		return count;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Absolute distinct count in a sorted array
Given a sorted array of integers, return the number of distinct absolute values among the elements of the array. The input can contain duplicates values.

Input: [-3, -2, 0, 3, 4, 5]
Output: 5
There are 5 distinct absolute values
among the elements of this array, i.e.
0, 2, 3, 4 and 5)

Input:  [-1, -1, -1, -1, 0, 1, 1, 1, 1]
Output: 2

Input:  [-1, -1, -1, -1, 0]
Output: 2

Input:  [0, 0, 0]
Output: 1 
The solution should do only one scan of the input array and should not use any extra space. i.e. expected time complexity is O(n) and auxiliary space is O(1).
////////////////// optimize time - O(n)  space - O(1);
public static void countAbsolute2(int[] array) {
		if(array.length == 0) System.out.println(0);
		int left = 0, right = array.length - 1;
		int count = 0;
		while(left <= right) {
			while(left < array.length-1 && Math.abs(array[left]) == Math.abs(array[left+1])) left++;
			while(right > 0 && Math.abs(array[right]) == Math.abs(array[right-1])) right--;
			count+=1;
			if(left > right) break;
			if(Math.abs(array[left]) == Math.abs(array[right])) {
				left++; right--;
			}
			else if(Math.abs(array[left]) > Math.abs(array[right])) left++;
			else right--;
		}
		System.out.println(count);
	}
//////////////////////// another time - O(n) space - O(1)

public static void countAbsolute(int[] array) {
		if(array.length == 0) System.out.println(0);
		Set<Integer> set = new HashSet<Integer>();
		for(int n: array) set.add(Math.abs(n));
		System.out.println(set.size());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Rearrange array in alternating positive & negative items with O(1) extra space | Set 2
Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa. Order of elements in output doesn’t matter. Extra positive or negative elements should be moved to end.

Examples

Input :
arr[] = {-2, 3, 4, -1}
Output :
arr[] = {-2, 3, -1, 4} OR {-1, 3, -2, 4} OR ..

Input :
arr[] = {-2, 3, 1}
Output :
arr[] = {-2, 3, 1} OR {-2, 1, 3} 

Input : 
arr[] = {-5, 3, 4, 5, -6, -2, 8, 9, -1, -4}
Output :
arr[] = {-5, 3, -2, 5, -6, 4, -4, 9, -1, 8}

	public static void reArrange(int[] array) {
		if(array.length <= 1) return;
		int left = 0, right = 0;
		while(right < array.length) {
			if(array[right] < 0) swap(array, left++, right++);
			else right++;
		}
		right = left;
		left = 1;
		while(left < array.length && right < array.length) {
			swap(array,left,right);
			right++;
			left+=2;
		}
	}
	public static void swap(int[] array, int left, int right) {
		if(left == right) return;
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find subarray with given sum
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.

Source: Google Interview Question

public static void printIndex(int[] array, int sum) {
		if(array.length == 0) return;
		int curr_sum = array[0],start = 0;
		for(int i = 1; i <= array.length; i++) {
			while(start < i-1 && curr_sum > sum) curr_sum -= array[start++];
			if(sum == curr_sum){
				System.out.println(""+start+" "+(i-1));
				return;
			}
			if(i < array.length) curr_sum += array[i];
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
You are given an array of characters which is basically a sentence. However there is no space between different words and the first letter of every word is in uppercase. You need to put a single space between these words and convert the uppercase letters to lowercase. There are some extra spaces available in the array at the end.

Eg. “MyNameIsRam ” , you need to convert this to “my name is ram”

public static void arrangeIt(char[] array) {
		if(array.length == 0) return;
		int r = array.length-1, l = array.length-1;
		while(array[l] == '\0') l--;
		while(l >= 0) {
			if(Character.isLowerCase(array[l])) array[r--] = array[l--];
			else {
				array[r--] = Character.toLowerCase(array[l--]);
				if(l >= 0) array[r--] = ' ';
			}
		}
		System.out.println(new String(array));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Find minimum number of merge operations to make an array palindrome
Given an array of positive integers. We need to make the given array a ‘Palindrome’. Only allowed operation on array is merge. Merging two adjacent elements means replacing them with their sum. The task is to find minimum number of merge operations required to make given array a ‘Palindrome’.

To make an array a palindromic we can simply apply merging operations n-1 times where n is the size of array (Note a single element array is alway palindrome similar to single character string). In that case, size of array will be reduced to 1. But in this problem we are asked to do it in minimum number of operations.

Example:

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.

public static int mergeOperation(int[] array) {
		if(array.length <= 1) return 0;
		int left = 0, right = array.length-1, count = 0;
		while(left <= right) {
			if(array[left] == array[right]) {
				left++;
				right--;
			}
			else if(left + 1 < right && array[left]+array[left+1] == array[right]){
				left+=2; right--; 
				count++;
			}
			else if(left + 1 < right && array[right]+array[right-1] == array[left]) {
				left++; right-=2; count++;
			}
			else if(array[left] < array[right]) {
				array[left+1] += array[left];
				count++; left++;
			}
			else {
				array[right-1] += array[right];
				count++; right--;
			}
		}
		return count;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Count minimum steps to get the given desired array
Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

Incremental operations:Choose 1 element from the array and increment its value by 1.
Doubling operation: Double the values of all the elements of array.
We are given desired array target[] containing n elements. Compute and return the smallest possible number of the operations needed to change the array from all zeros to desired array.

Sample test cases:

Input: target[] = {2, 3}
Output: 4
To get the target array from {0, 0}, we 
first increment both elements by 1 (2 
operations), then double the array (1 
operation). Finally increment second
element (1 more operation)

Input: target[] = {2, 1}
Output: 3
One of the optimal solution is to apply the 
incremental operation 2 times to first and 
once on second element.

Input: target[] = {16, 16, 16}
Output: 7
The output solution looks as follows. First 
apply an incremental operation to each element. 
Then apply the doubling operation four times. 
Total number of operations is 3+4 = 7
////////////////// idea
The idea is to follow reverse steps, i.e. to convert target to array of zeros. Below are steps.

Take the target array first. 

Initialize result as 0. 

If all are even, divide all elements by 2 
and increment result by 1. 

Find all odd elements, make them even by 
reducing them by 1. and for every reduction,
increment result by 1.

Finally we get all zeros in target array.
////////////////////////////
public static int desiredOperation(int[] array) {
		if(array.length == 0) return 0;
		int ret = 0;
		while(true) {
			int zero = 0,i;
			for(i = 0; i < array.length; i++) {
				if(array[i] % 2 != 0) break;				
				if(array[i] == 0)zero++;
			}
			if(zero == array.length) return ret;
			else if(i < array.length){
				for(int j = i; j < array.length; j++) {
					if(array[j] % 2 != 0) {
						array[j]--; ret++;
					}
				}
			}
			else {
				for(int j = 0; j < array.length; j++) array[j] /= 2;
				ret++;
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number is higher or lower.

You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
1 : My number is higher
0 : Congrats! You got it!
Example:
n = 10, I pick 6.

Return 6.

public int guessNumber(int n) {
int left = 1, right = n, mid = 0;
while(left <= right) {
mid = left + (right - left)/2;
if(guess(mid) == 0) return mid;
else if(guess(mid) < 0) right = mid - 1;
else left = mid + 1;
}
return mid;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

371. Sum of Two Integers

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
/////////////////// optimized 
public int getSum(int a, int b) {
        int carray = 0, ret = 0, curr = 0, i = 0;
        while(i <  32) {
            int sum = (a&1) + (b&1) + carray;
            curr = (sum % 2 == 0)?0:1;
            carray = (sum <= 1)?0:1;
            ret|=(curr<<=i);
            a >>= 1;
            b >>= 1;
            i++;
        }
        return ret;
        
    }
///////////////////// another 
public int getSum(int a, int b) {
int carray = 0, ret = 0, curr = 0;
StringBuilder sb = new StringBuilder();
int i = 32;
while(i-- >  0) {
int a0 = a & 1;
int b0 = b & 1;
int sum = a0 + b0 + carray;
if(sum == 0) {
curr = 0;
carray = 0;
}
else if(sum == 1) {
curr = 1;
carray = 0;
}
else if(sum == 2) {
curr = 0;
carray = 1;
}
else if(sum == 3) {
curr = 1;
carray = 1;
}
curr <<= (32-i-1);
ret|=curr;
a >>= 1;
b >>= 1;
}
return ret;

}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

373. Find K Pairs with Smallest Sums  QuestionEditorial Solution  My Submissions
Total Accepted: 3021
Total Submissions: 12312
Difficulty: Medium
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]

public class Solution {
    class arrange implements Comparator<int[]> {
        public int compare(int[] array1, int[] array2) {
            return (array1[0]+array1[1]) - (array2[0]+array2[1]);
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0) return new ArrayList<int[]>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new arrange());
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++){
                int[] newArray = new int[2];
                newArray[0] = nums1[i];
                newArray[1] = nums2[j];
                pq.add(newArray);
            }
        }
        List<int[]> ret = new ArrayList<int[]>();
        for(int i = 0; i < k; i++) {
            if(!pq.isEmpty()) ret.add(pq.poll());
        }
        return ret;
        
    }
}
/////////////////////////////////////////////////////////////////////////////////////////

345. Reverse Vowels of a String

345. Reverse Vowels of a String  QuestionEditorial Solution  My Submissions
Total Accepted: 28938
Total Submissions: 80354
Difficulty: Easy
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

public String reverseVowels(String s) {
        if(s.length() < 2) return s;
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length()-1;
        while(left < right){
            while(left < right && Character.toLowerCase(sb.charAt(left)) != 'a' && Character.toLowerCase(sb.charAt(left)) != 'e' && Character.toLowerCase(sb.charAt(left)) != 'i' && Character.toLowerCase(sb.charAt(left)) != 'o' && Character.toLowerCase(sb.charAt(left)) != 'u') left++;
            while(left < right && Character.toLowerCase(sb.charAt(right)) != 'a' && Character.toLowerCase(sb.charAt(right)) != 'e' && Character.toLowerCase(sb.charAt(right)) != 'i' && Character.toLowerCase(sb.charAt(right)) != 'o' && Character.toLowerCase(sb.charAt(right)) != 'u') right--;
            if(left < right) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right,temp);
                left++;right--;
            }
            
        }
        return sb.toString();
    }

///////////////////////////////////////////////////////////////////////////////////////////

6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 public String convert(String s, int numRows) {
        if(s.length() == 0) return s;
        StringBuilder[] sb= new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();
        int k = 0;
        while(k < s.length()) {
            int i = 0; 
            while(k < s.length() && i < numRows) sb[i++].append(s.charAt(k++));
            i = numRows-2;
            while(k < s.length() && i > 0) sb[i--].append(s.charAt(k++));
        }
        for(int i = 1; i < sb.length; i++) sb[0].append(sb[i].toString());
        return sb[0].toString();
    }
//////////////////////////////////////////////////////////////////////////////////////////




