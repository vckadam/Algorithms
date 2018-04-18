package heap.LFU;

public class Item {
	private int value, freq, occu;
	
	public Item(int value, int freq, int occu) {
		this.value = value;
		this.freq = freq;
		this.occu = occu;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public int getOccu() {
		return occu;
	}

	public void setOccu(int occu) {
		this.occu = occu;
	}
	
}
