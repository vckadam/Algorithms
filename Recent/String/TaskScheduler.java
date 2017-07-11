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

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0 || tasks.length == 1) return tasks.length;
        int[] freqs = new int[26];
        for(int i = 0; i < tasks.length; i++) freqs[tasks[i]-'A']++;
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b)->(b-a));
        for(int i = 0; i < freqs.length; i++) if(freqs[i] > 0) pq.add(freqs[i]);
        Map<Integer,Integer> hm = new HashMap<>();
        int time = 0, taskRemaining = tasks.length;
        while(taskRemaining > 0) {
            Integer prev = hm.get(time);
            if(prev != null) pq.add(prev);
            Integer curr = pq.poll();
            if(curr != null) taskRemaining--;
            if(curr != null && --curr > 0) hm.put(time+n+1, curr);
            time++;
        }
        return time;
    }
}