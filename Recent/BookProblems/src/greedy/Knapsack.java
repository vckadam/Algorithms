package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Knapsack {
	public Object[] getO1Knapsack(int[] item, int[] weight, int[] val, int totalWeight) {
		if(item == null || weight == null || val == null || totalWeight < 0) 
			throw new IllegalArgumentException("Illegal Arguments");
		PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b)->(a[3]<b[3])?1:-1);
		for(int i = 0; i < item.length; i++) {
			pq.add(new double[]{item[i],weight[i],val[i],val[i]/weight[i]});
		}
		List<Integer> pickedItems = new ArrayList<Integer>();
		int currWeight = 0, currAmount = 0;
		while(!pq.isEmpty() && currWeight < totalWeight) {
			double[] curr = pq.poll();
			if((int)curr[1] <= totalWeight-currWeight) {
				pickedItems.add((int)curr[0]);
				currAmount += (int)curr[2];
				currWeight += (int)curr[1];
			}
		}
		return new Object[]{currAmount, pickedItems};
	}
	
	public Object[] getFractionalKnapsack(int[] item, int[] weight, int[] val, int totalWeight) {
		if(item == null || weight == null || val == null || totalWeight <= 0)
			throw new IllegalArgumentException("Illegal Argument item = "+item+" weight = "+weight+" val = "+val+" totalWeight = "+totalWeight);
		PriorityQueue<double[]> pq = new PriorityQueue<double[]>((a,b)->(a[3]<b[3])?1:-1);
		for(int i = 0; i < item.length; i++) {
			pq.add(new double[]{item[i],weight[i],val[i],val[i]/weight[i]});
		}
		double curAmount = 0;
		int curWeight = 0;
		List<Integer> pickedItems = new ArrayList<Integer>();
		while(!pq.isEmpty() && curWeight < totalWeight) {
			double[] temp = pq.poll();
			double curPickedWeight = Math.min(temp[1], totalWeight-curWeight);
			curAmount += (curPickedWeight*temp[3]);
			curWeight += curPickedWeight;
			pickedItems.add((int)temp[0]);
		}
		return new Object[]{curAmount,pickedItems};
	}
}
