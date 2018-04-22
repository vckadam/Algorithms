/*
822. Card Flipping Game

On a table are N cards, with a positive integer printed on the front and back of each card (possibly different).

We flip any number of cards, and after we choose one card. 

If the number X on the back of the chosen card is not on the front of any card, then this number X is good.

What is the smallest number that is good?  If no number is good, output 0.

Here, fronts[i] and backs[i] represent the number on the front and back of card i. 

A flip swaps the front and back numbers, so the value on the front is now on the back and vice versa.

Example:

Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
Output: 2
Explanation: If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
We choose the second card, which has number 2 on the back, and it isn't on the front of any card, so 2 is good.
 

Note:

1 <= fronts.length == backs.length <= 1000.
1 <= fronts[i] <= 2000.
1 <= backs[i] <= 2000.
*/

class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        int ret = 2001;
        Map<Integer,List<Integer>> front = new HashMap<Integer,List<Integer>>();
        Map<Integer,List<Integer>> back = new HashMap<Integer,List<Integer>>();
        Set<Integer> bothSide = new HashSet<Integer>();
        for(int i = 0; i < fronts.length; i++) {
            addToMap(front, fronts[i], i);
            addToMap(back, backs[i], i);
        }
        ret = Math.min(ret, helper(fronts, backs, back, bothSide, ret));
        ret = Math.min(ret, helper(backs, fronts, front, bothSide, ret));
        return ret == 2001 ? 0 : ret;
    }
    
    public int helper(int[] arr1, int[] arr2, Map<Integer,List<Integer>> map, Set<Integer> bothSide, int r) {
        int ret = r;
        for(int i = 0; i < arr1.length; i++) {
            if(bothSide.contains(arr1[i]) || arr1[i] >= ret)
                continue;
            if(arr1[i] == arr2[i]) {
                bothSide.add(arr1[i]);
                continue;
            }
            if(!map.containsKey(arr1[i])) {
                ret = arr1[i];
            } else {
                List<Integer> others = map.get(arr1[i]);
                boolean status = false;
                for(Integer num : others) {
                    if(arr1[num] == arr1[i]) 
                        status = true;
                }
                if(!status) ret = arr1[i];
            }
        }
        return ret;
    }
    
    public void addToMap(Map<Integer,List<Integer>> map, int num, int i) {
        if(!map.containsKey(num)) {
            map.put(num, new ArrayList<Integer>());
        }
        map.get(num).add(i);
    }
}