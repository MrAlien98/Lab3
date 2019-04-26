package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dataStructures.AVLTree;
import dataStructures.BinarySearchTree;
import dataStructures.RedBlackTree;

public class BVC_APP {
	
	private AVLTree<FinancialThing> stocks;
	
	private AVLTree<FinancialThing> US30;
	private AVLTree<FinancialThing> USSPX500;
	private AVLTree<FinancialThing> WTI;
	
	private RedBlackTree<FinancialThing> forexs;
	
	private RedBlackTree<FinancialThing> EURUSD;
	private RedBlackTree<FinancialThing> GBPCAD;
	private RedBlackTree<FinancialThing> USDJPY;
	private RedBlackTree<FinancialThing> XAUUSD;
	
	private ArrayList<FinancialThing> BTCUSD;
	
	private ArrayList<BinarySearchTree<FinancialThing>> arr2;
	
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
	
	/**
	 * @return the uS30
	 */
	public AVLTree<FinancialThing> getUS30() {
		return US30;
	}

	/**
	 * @param uS30 the uS30 to set
	 */
	public void setUS30(AVLTree<FinancialThing> uS30) {
		US30 = uS30;
	}

	/**
	 * @return the uSSPX500
	 */
	public AVLTree<FinancialThing> getUSSPX500() {
		return USSPX500;
	}

	/**
	 * @param uSSPX500 the uSSPX500 to set
	 */
	public void setUSSPX500(AVLTree<FinancialThing> uSSPX500) {
		USSPX500 = uSSPX500;
	}

	/**
	 * @return the wTI
	 */
	public AVLTree<FinancialThing> getWTI() {
		return WTI;
	}

	/**
	 * @param wTI the wTI to set
	 */
	public void setWTI(AVLTree<FinancialThing> wTI) {
		WTI = wTI;
	}

	/**
	 * @return the eURUSD
	 */
	public RedBlackTree<FinancialThing> getEURUSD() {
		return EURUSD;
	}

	/**
	 * @param eURUSD the eURUSD to set
	 */
	public void setEURUSD(RedBlackTree<FinancialThing> eURUSD) {
		EURUSD = eURUSD;
	}

	/**
	 * @return the gBPCAD
	 */
	public RedBlackTree<FinancialThing> getGBPCAD() {
		return GBPCAD;
	}

	/**
	 * @param gBPCAD the gBPCAD to set
	 */
	public void setGBPCAD(RedBlackTree<FinancialThing> gBPCAD) {
		GBPCAD = gBPCAD;
	}

	/**
	 * @return the uSDJPY
	 */
	public RedBlackTree<FinancialThing> getUSDJPY() {
		return USDJPY;
	}

	/**
	 * @param uSDJPY the uSDJPY to set
	 */
	public void setUSDJPY(RedBlackTree<FinancialThing> uSDJPY) {
		USDJPY = uSDJPY;
	}

	/**
	 * @return the xAUUSD
	 */
	public RedBlackTree<FinancialThing> getXAUUSD() {
		return XAUUSD;
	}

	/**
	 * @param xAUUSD the xAUUSD to set
	 */
	public void setXAUUSD(RedBlackTree<FinancialThing> xAUUSD) {
		XAUUSD = xAUUSD;
	}

	/**
	 * @return the arr2
	 */
	public ArrayList<BinarySearchTree<FinancialThing>> getArr2() {
		return arr2;
	}

	/**
	 * @param arr2 the arr2 to set
	 */
	public void setArr2(ArrayList<BinarySearchTree<FinancialThing>> arr2) {
		this.arr2 = arr2;
	}

	public int loadData(String url, LocalDate start, LocalDate end) {
		try {
		if(url.equals("AAPL") || url.equals("MSFT") || url.equals("US30") || url.equals("WTI") || url.equals("USSPX500")) {
			return loadData(2, url, start, end);
		}else if(url.equals("BTCUSD")){
			return loadData(3, url, start, end);
		}else {
			return loadData(1, url, start, end);
		}
		}catch (NullPointerException e) {
			e.fillInStackTrace();
		}
		return 0;
	}
	
	public int loadData(int x, String url, LocalDate start, LocalDate end) {
		File f=null;
		try {
			f=new File("src/financialData/"+url+".txt");
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line="";
			setBTCUSD(new ArrayList<>());
			setStocks(new AVLTree<>());
			setForexs(new RedBlackTree<>());
			while((line=br.readLine())!=null) {
				String[] obj=line.split(", ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:m");
				String date = obj[1];
				LocalDate lDate = LocalDate.parse(date, formatter);
				if( lDate.isEqual(start) || (lDate.isAfter(start) && lDate.isBefore(end)) ) {
					FinancialThing ft=new FinancialThing(x, Double.parseDouble(obj[2]), lDate);
					if(x==1) {
						forexs.add(ft);
					}else if(x==2){
						stocks.add(ft);
					}else {
						BTCUSD.add(ft);
					}
				}
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public void loadEverything(LocalDate start, LocalDate end) {
		ArrayList<String>arr=new ArrayList<>();
		arr.add("BTCUSD");
		arr.add("EURUSD");
		arr.add("GBPCAD");
		arr.add("USDJPY");
		arr.add("XAUUSD");
		arr.add("US30");
		arr.add("USSPX500");
		arr.add("WTI");
		arr2=new ArrayList<>();
		arr2.add(getEURUSD());
		arr2.add(getGBPCAD());
		arr2.add(getUSDJPY());
		arr2.add(getXAUUSD());
		arr2.add(getUS30());
		arr2.add(getUSSPX500());
		arr2.add(getWTI());
		for(int i=0;i<arr.size();i++){
			loadEach(arr.get(i), i, start, end);
		}
	}
	
	public void loadEach(String url, int pos, LocalDate start, LocalDate end) {
		try {
			File f=new File("src/financialData/"+url+".txt");
			BufferedReader br=new BufferedReader(new FileReader(f));
			String line="";
			while((line=br.readLine())!=null) {
				String[] obj=line.split(", ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:m");
				String date = obj[1];
				LocalDate lDate = LocalDate.parse(date, formatter);
				if( lDate.isEqual(start) || (lDate.isAfter(start) && lDate.isBefore(end)) ) {
					FinancialThing ft=new FinancialThing(Double.parseDouble(obj[2]), lDate);
					arr2.get(pos).add(ft);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	
	public FinancialThing find(int x, String url, LocalDate start, LocalDate end) {
		int f=loadData(url, start, end);
		if(f==1) {
			if(x>0) {
				return forexs.getLesser().getID();
			}else {
				return forexs.getGreater().getID();
			}
		}else if(f==2) {
			if(x>0) {
				return (stocks.getLesser().getID());
			}else {
				return (stocks.getGreater().getID());
			}
		}else {
			if(x>0) {
				return getBTCUSD().get(getBTCUSD().size()-1);
			}else {
				return getBTCUSD().get(0);
			}
		}
	}

}