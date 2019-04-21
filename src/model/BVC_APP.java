package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dataStructures.AVLTree;
import dataStructures.RedBlackTree;

public class BVC_APP {
	
	private AVLTree<FinancialThing> general1;
	
	private RedBlackTree<FinancialThing> general2;
	
	private ArrayList<FinancialThing> BTCUSD;
	
	public BVC_APP() {
		setBTCUSD(new ArrayList<>());
	}

	/**
	 * @return the bTCUSD
	 */
	public ArrayList<FinancialThing> getBTCUSD() {
		return BTCUSD;
	}

	/**
	 * @param bTCUSD the bTCUSD to set
	 */
	public void setBTCUSD(ArrayList<FinancialThing> bTCUSD) {
		BTCUSD = bTCUSD;
	}

	/**
	 * @return the general1
	 */
	public AVLTree<FinancialThing> getGeneral1() {
		return general1;
	}

	/**
	 * @param general1 the general1 to set
	 */
	public void setGeneral1(AVLTree<FinancialThing> general1) {
		this.general1 = general1;
	}

	/**
	 * @return the general2
	 */
	public RedBlackTree<FinancialThing> getGeneral2() {
		return general2;
	}

	/**
	 * @param general2 the general2 to set
	 */
	public void setGeneral2(RedBlackTree<FinancialThing> general2) {
		this.general2 = general2;
	}
	
	public void loadData(String url, LocalDate start, LocalDate end) {
		if(url.equals("AAPL") || url.equals("MSFT") || url.equals("US30") || url.equals("WTI") || url.equals("USSPX500")) {
			loadStock(url, start, end);
		}else {
			
		}
	}
	
	public void loadStock(String url, LocalDate start, LocalDate end) {
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File("src/stockData"+url+".txt")));
			String line="";
			while((line=br.readLine())!=null) {
				String[] obj=line.split(", ");
				String[] d=obj[1].split(" ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String date = d[0];
				LocalDate lDate = LocalDate.parse(date, formatter);
				if(lDate.isBefore(start) && lDate.isAfter(end)) {
					FinancialThing ft=new FinancialThing(2, Double.parseDouble(obj[3]), lDate);
					general1.add(ft);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}

	
	public void loadForex(String url, LocalDate start, LocalDate end) {
			
	}
	
	public void filterData(String stock, String initialDate, String finalDate) {
		   
	}
	
	public double highestPrice() {
		

		return 0;
		
	}
		
}