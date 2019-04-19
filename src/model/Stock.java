package model;

public class Stock implements Comparable<Stock>{

	private double value;
	
	public Stock() {
		
	}
	
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public int compareTo(Stock a1) {
		if(this.getValue()>a1.getValue()) {
			return 1;
		}else if(this.getValue()<a1.getValue()){
			return -1;
		}else {
			return 0;
		}
	}

	
	
}
