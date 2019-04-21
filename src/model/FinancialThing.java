package model;

import java.time.LocalDate;

public class FinancialThing implements Comparable<FinancialThing>{

	public static final int FOREX=1;
	public static final int STOCK=2;
	
	private int type;
	private double value;
	private LocalDate date;
		
	public FinancialThing(int type, double value, LocalDate date) {
		this.type = type;
		this.value = value;
		this.date = date;
	}
	
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
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
	public int compareTo(FinancialThing a1) {
		if(this.getValue()>a1.getValue()) {
			return 1;
		}else if(this.getValue()<a1.getValue()){
			return -1;
		}else {
			return 0;
		}
	}

}
