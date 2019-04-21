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
	
	private AVLTree<FinancialThing> stocks;
	
	private RedBlackTree<FinancialThing> forexs;
	
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
	public AVLTree<FinancialThing> getStocks() {
		return stocks;
	}

	/**
	 * @param general1 the general1 to set
	 */
	public void setStocks(AVLTree<FinancialThing> general1) {
		this.stocks = general1;
	}

	/**
	 * @return the general2
	 */
	public RedBlackTree<FinancialThing> getForexs() {
		return forexs;
	}

	/**
	 * @param general2 the general2 to set
	 */
	public void setForexs(RedBlackTree<FinancialThing> general2) {
		this.forexs = general2;
	}
	
	public void loadData(String url, LocalDate start, LocalDate end) {
		if(url.equals("AAPL") || url.equals("MSFT") || url.equals("US30") || url.equals("WTI") || url.equals("USSPX500")) {
			loadData(2, url, start, end);
		}else {
			loadData(1, url, start, end);
		}
	}
	
	public void loadData(int x, String url, LocalDate start, LocalDate end) {
		try {
			BufferedReader br=new BufferedReader(new FileReader(new File("src/stockData/"+url+".txt")));
			String line="";
			stocks = new AVLTree<>();
			forexs = new RedBlackTree<>();
			while((line=br.readLine())!=null) {
				String[] obj=line.split(", ");
				String[] d=obj[1].split(" ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
				String date = d[0];
				LocalDate lDate = LocalDate.parse(date, formatter);
				if( lDate.isEqual(start) || (lDate.isAfter(start) && lDate.isBefore(end)) ) {
					FinancialThing ft=new FinancialThing(x, Double.parseDouble(obj[2]), lDate);
					if(x==1) {
						forexs.add(ft);
					}else {
						stocks.add(ft);
					}
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}