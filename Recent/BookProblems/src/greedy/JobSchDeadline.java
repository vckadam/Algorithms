package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Job Sequencing Problem | Set 1 (Greedy Algorithm)
Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline. It is also given that every job takes single unit of time, so the minimum possible deadline for any job is 1. How to maximize total profit if only one job can be scheduled at a time.

Examples:

Input: Four Jobs with following deadlines and profits
  JobID    Deadline      Profit
    a        4            20   
    b        1            10
    c        1            40  
    d        1            30
Output: Following is maximum profit sequence of jobs
        c, a   


Input:  Five Jobs with following deadlines and profits
   JobID     Deadline     Profit
     a         2           100
     b         1           19
     c         2           27
     d         1           25
     e         3           15
Output: Following is maximum profit sequence of jobs
        c, a, e
 */
public class JobSchDeadline {
	public List<Character> getSequenceJobId(char[] jobIds, int[] deadLine, int[] profit) {
		if(jobIds == null || deadLine == null || profit == null) 
			throw new IllegalArgumentException("Illegal Argument");
		List<Character> sequence = new ArrayList<Character>();
		PriorityQueue<Object[]> pq = new PriorityQueue<Object[]>((a,b)->(int)b[2]-(int)a[2]);
		for(int i = 0; i < jobIds.length; i++) {
			pq.add(new Object[]{jobIds[i],deadLine[i],profit[i]});
		}
		char[] decidedJob = new char[jobIds.length+1];
		while(!pq.isEmpty()) {
			Object[] temp = pq.poll();
			int lastDate = (int)temp[1];
			while(lastDate > 0 && decidedJob[lastDate] != '\0')
				lastDate--;
			if(lastDate > 0) {
				decidedJob[lastDate] = (char)temp[0];
			}
		}
		for(int i = 0; i < decidedJob.length; i++)
			if(decidedJob[i] != '\0')
				sequence.add(decidedJob[i]);
		return sequence;
	}
}	
