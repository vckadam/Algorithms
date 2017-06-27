/* 
621. Task Scheduler
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        int max = 0 ,ret = 0;
        for(char ch: tasks) {
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            max = Math.max(max, hm.get(ch));
        }
        System.out.println(hm.toString());
        StringBuilder[] count = new StringBuilder[max+1];
        Iterator it = hm.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            int ind = (int)me.getValue();
            if(count[ind] == null) count[ind] = new StringBuilder();
            count[ind].append((char)me.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = count.length-1; i >= 0; i--) {
            if(count[i] != null) {
                sb.append(count[i].toString());
            }
        }
        System.out.println(sb.toString());
        int length = sb.length(), i = 0, j = 0;
        List<Character> list = new ArrayList<Character>();
        while(length > 0) {
            if(i <= n) {
                if(j < sb.length()) {
                    list.add(sb.charAt(j));
                    hm.put(sb.charAt(j), hm.get(sb.charAt(j))-1);
                    if(hm.get(sb.charAt(j)) == 0) length--;
                } else {
                    list.add(null);
                }
                j++;
            }
            else {
                int prev = list.size()-n-1;
                if(list.get(prev) == null) list.add(null);
                else {
                    char key = list.get(prev);
                    if(hm.get(key) > 0) {
                        list.add(key);
                        hm.put(key, hm.get(key)-1);
                        if(hm.get(key) == 0) length--;
                    } else {
                        if(j < sb.length()) {
                            list.add(sb.charAt(j));
                            hm.put(sb.charAt(j), hm.get(sb.charAt(j))-1);
                            if(hm.get(sb.charAt(j)) == 0) length--;
                        } else {
                            list.add(null);
                        }
                        j++;
                    }
                }
            }
            i++;
        }
        for(int k = 0; k < list.size(); k++) System.out.println(list.get(k));
        //while(list.size() > 0 && list.get(list.size()-1) == null) list.remove(list.size()-1);
        /*while(list.size() != 0 && list.get(0) != 0) {
            int len = Math.max(list.size(), n+1);
            for(int i = 0; i < len && list.size() > 0; i++) {
                if(i < list.size()) {
                    int val = list.get(i);
                    list.set(i, --val);
                }
                ret++;
                if(i == list.size()-1) {
                    while(list.size() > 0 && list.get(list.size()-1) == 0) list.remove(list.size()-1);
                }
            }
        }*/
        return list.size();
    }
}