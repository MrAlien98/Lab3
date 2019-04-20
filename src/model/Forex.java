package model;

import java.time.LocalDate;

public class Forex implements Comparable<Forex>{
	
	private String type;
	private double value;
	private LocalDate date;
	
	public Forex() {
		
	}
	
	public Forex(String type, double value, LocalDate date) {
		this.type=type;
		this.value=value;
		this.date=date;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
