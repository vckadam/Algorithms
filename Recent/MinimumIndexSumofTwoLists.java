/* 
599. Minimum Index Sum of Two Lists

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.

*/

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if(list1 == null || list2 == null || list1.length == 0 || list2.length == 0) return new String[0];
        List<String> ret = new ArrayList<String>();
        int leastInd = list1.length + list2.length;
        Map<String,Integer> hm = new HashMap<String,Integer>();
        int ind1 = 0, ind2 = 0;
        while(ind1 < list1.length || ind2 < list2.length) {
            if(ind1 < list1.length) {
                leastInd = helper(ret, hm, list1, ind1++, leastInd);
            }
            if(ind2 < list2.length) {
                leastInd = helper(ret, hm, list2, ind2++, leastInd);
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
    
    public int helper(List<String> ret, Map<String,Integer> hm, String[] list, int ind, int leastInd) {
        int retInd = -1;
        if(hm.containsKey(list[ind])) {
            if(leastInd > ind + hm.get(list[ind])) {
                ret.clear();
                ret.add(list[ind]);
                retInd = ind + hm.get(list[ind]);
            } else if(leastInd == ind + hm.get(list[ind])) {
                ret.add(list[ind]);
            }
        } else {
            hm.put(list[ind], ind);
        }
        return retInd != -1 ? retInd : leastInd;
    }
}