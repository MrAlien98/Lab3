package model;

import java.time.LocalDate;

public class Forex implements Comparable<Forex>{
	
	private double value;
	private LocalDate date;
	
	public Forex() {
	
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
	
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int compareTo(Forex a1) {
		if(this.getValue()>a1.getValue()) {
			return 1;
		}else if(this.getValue()<a1.getValue()){
			return -1;
		}else {
			return 0;
		}
	}
	
}
