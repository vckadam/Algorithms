/* 
638. Shopping Offers My SubmissionsBack to Contest
User Accepted: 186
User Tried: 322
Total Accepted: 188
Total Submissions: 791
Difficulty: Medium
In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:
Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
Example 2:
Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
Note:
There are at most 6 kinds of items, 100 special offers.
For each item, you need to buy at most 6 of them.
You are not allowed to buy more items than you want, even if that would lower the overall price.
*/
public class Solution {
    int minPrice = 0;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(price == null || needs == null || price.size() == 0 || needs.size() == 0 || price.size() != needs.size())
            return 0;
        minPrice = getPriceWithoutOffer(price,needs);
        if(special == null || special.size() == 0) return minPrice;
        helper(price, special, needs, 0);
        return minPrice;        
    }
    
    public void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int amount) {       
        for(int i = 0; i < special.size(); i++) {
            if(isPossibleToTake(special.get(i),needs)) {
                int lastInd = special.get(i).size()-1;
                amount += (special.get(i).get(lastInd)); // Change it back after call.
                List<Integer> newNeeds = new ArrayList<Integer>(needs); // Always create anoter for ref variable
                for(int j = 0; j < needs.size(); j++) {
                    int val = needs.get(j) - special.get(i).get(j);
                    newNeeds.set(j, val);
                }
                helper(price, special, newNeeds, amount);
                amount -= (special.get(i).get(lastInd));
            }
        }
        //System.out.println(needs.toString());
        //System.out.println(amount);
        for(int k = 0; k < needs.size(); k++) {
            amount += (needs.get(k) * price.get(k));
        }
        //System.out.println(amount);
        minPrice = Math.min(minPrice, amount);        
    }
    
    public boolean isPossibleToTake(List<Integer> offer, List<Integer> needs) {
        for(int i = 0; i < needs.size(); i++) {
            if(offer.get(i) > needs.get(i)) return false;
        }
        return true;
    }
    public int getPriceWithoutOffer(List<Integer> price, List<Integer> needs) {
        int ret = 0;
        for(int i = 0; i < price.size(); i++) {
            ret += (price.get(i)*needs.get(i));
        }
        return ret;
    }
}