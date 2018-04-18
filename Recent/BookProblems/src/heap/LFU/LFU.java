package heap.LFU;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFU {
	int count;
	Map<Integer,Item> itemMap;
	PriorityQueue<Item> itemPq;
	
	public LFU() {
		this.count = 0;
		this.itemMap = new HashMap<Integer,Item>();
		this.itemPq = 
				new PriorityQueue<Item>((a, b) -> a.getFreq() != b.getFreq() ? b.getFreq() - a.getFreq() : a.getOccu() - b.getOccu());
	}
	
	public void add(int num) {
		count++;
		Item item;
		if(!itemMap.containsKey(num)) {
			item = new Item(num, 1, count);
			itemMap.put(num, item);
		} else {
			item = itemMap.get(num);
			itemPq.remove(item);
			item.setFreq(item.getFreq()+1);
			item.setOccu(count);
		}
		itemPq.add(item);
	}
	
	public int remove() {
		Item item = itemPq.remove();
		return item.getValue();
	}
		 
}
