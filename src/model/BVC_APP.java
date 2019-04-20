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
	
	private AVLTree<Stock> XAUUSD;
	private AVLTree<Stock> EURUSD;
	private AVLTree<Stock> GBPCAD;
	private AVLTree<Stock> USDJPY;

	private RedBlackTree<Forex> US30;
	private RedBlackTree<Forex> USSPX500;
	private RedBlackTree<Forex> AAPL;
	private RedBlackTree<Forex> MSFT;
	private RedBlackTree<Forex> WTI;
	
	private ArrayList<Forex> BTCUSD;
	
	public BVC_APP() {
		
	}

	/**
	 * @return the xAUUSD
	 */
	public AVLTree<Stock> getXAUUSD() {
		return XAUUSD;
	}

	/**
	 * @param xAUUSD the xAUUSD to set
	 */
	public void setXAUUSD(AVLTree<Stock> xAUUSD) {
		XAUUSD = xAUUSD;
	}

	/**
	 * @return the eURUSD
	 */
	public AVLTree<Stock> getEURUSD() {
		return EURUSD;
	}

	/**
	 * @param eURUSD the eURUSD to set
	 */
	public void setEURUSD(AVLTree<Stock> eURUSD) {
		EURUSD = eURUSD;
	}

	/**
	 * @return the gBPCAD
	 */
	public AVLTree<Stock> getGBPCAD() {
		return GBPCAD;
	}

	/**
	 * @param gBPCAD the gBPCAD to set
	 */
	public void setGBPCAD(AVLTree<Stock> gBPCAD) {
		GBPCAD = gBPCAD;
	}

	/**
	 * @return the uSDJPY
	 */
	public AVLTree<Stock> getUSDJPY() {
		return USDJPY;
	}

	/**
	 * @param uSDJPY the uSDJPY to set
	 */
	public void setUSDJPY(AVLTree<Stock> uSDJPY) {
		USDJPY = uSDJPY;
	}

	/**
	 * @return the uS30
	 */
	public RedBlackTree<Forex> getUS30() {
		return US30;
	}

	/**
	 * @param uS30 the uS30 to set
	 */
	public void setUS30(RedBlackTree<Forex> uS30) {
		US30 = uS30;
	}

	/**
	 * @return the uSSPX500
	 */
	public RedBlackTree<Forex> getUSSPX500() {
		return USSPX500;
	}

	/**
	 * @param uSSPX500 the uSSPX500 to set
	 */
	public void setUSSPX500(RedBlackTree<Forex> uSSPX500) {
		USSPX500 = uSSPX500;
	}

	/**
	 * @return the aAPL
	 */
	public RedBlackTree<Forex> getAAPL() {
		return AAPL;
	}

	/**
	 * @param aAPL the aAPL to set
	 */
	public void setAAPL(RedBlackTree<Forex> aAPL) {
		AAPL = aAPL;
	}

	/**
	 * @return the mSFT
	 */
	public RedBlackTree<Forex> getMSFT() {
		return MSFT;
	}

	/**
	 * @param mSFT the mSFT to set
	 */
	public void setMSFT(RedBlackTree<Forex> mSFT) {
		MSFT = mSFT;
	}

	/**
	 * @return the wTI
	 */
	public RedBlackTree<Forex> getWTI() {
		return WTI;
	}

	/**
	 * @param wTI the wTI to set
	 */
	public void setWTI(RedBlackTree<Forex> wTI) {
		WTI = wTI;
	}

	/**
	 * @return the bTCUSD
	 */
	public ArrayList<Forex> getBTCUSD() {
		return BTCUSD;
	}

	/**
	 * @param bTCUSD the bTCUSD to set
	 */
	public void setBTCUSD(ArrayList<Forex> bTCUSD) {
		BTCUSD = bTCUSD;
	}
	
	public void loadForex(String url) {
		if(url.equals("AAPL")) {
			url="src/forexData/AAPL.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				AAPL = new RedBlackTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					String date = obj[1];
					LocalDate localDate = LocalDate.parse(date, formatter);
					Forex f = new Forex(obj[0],Double.parseDouble(obj[2]),localDate);
					AAPL.add(f);
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("USSPX500")) {
			url="data/USSPX500.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				USSPX500 = new RedBlackTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					String date = obj[1];
					LocalDate localDate = LocalDate.parse(date, formatter);
					Forex f = new Forex(obj[0],Double.parseDouble(obj[2]),localDate);
					USSPX500.add(f);
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("US30")) {
			url="src/forexData/US30.txt";
		}else if(url.equals("MSFT")) {
			url="src/forexData/MSFT.txt";
		}else if(url.equals("WTI")) {
			url="src/forexData/WTI.txt";
		}
	}
	
	public void loadStock(String url) {
		if (url.equals("XAUUSD")) {
			url="data/XAUUSD.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				XAUUSD = new AVLTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
//					String[] hour = obj[1].split(" ");
//					String date = hour[0];
//					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//					LocalDate localDate = LocalDate.parse(date, formatter);
					LocalDate localDate = LocalDate.now();
					XAUUSD.add(new Stock(obj[0],Double.parseDouble(obj[2]),localDate));
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("EURUSD")) {
			url="data/EURUSD.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				EURUSD = new AVLTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
					String[] hour = obj[1].split(" ");
					String date = hour[0];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate localDate = LocalDate.parse(date, formatter);
					EURUSD.add(new Stock(obj[0],Double.parseDouble(obj[2]),localDate));
				}
					br.close();
			}catch(Exception e) {
				
			}
			}else if(url.equals("GBPCAD")) {
				url="data/GBPCAD.txt";
				try {
					BufferedReader br=new BufferedReader(new FileReader(new File(url)));
					GBPCAD = new AVLTree<>();
					String line="";
					while((line=br.readLine())!=null) {
						String[] obj=line.split(", ");
						String[] hour = obj[1].split(" ");
						String date = hour[0];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate localDate = LocalDate.parse(date, formatter);
						GBPCAD.add(new Stock(obj[0],Double.parseDouble(obj[2]),localDate));
					}
						br.close();
				}catch(Exception e) {
					
				}
				}else if(url.equals("USDJPY")) {
					url="data/USDJPY.txt";
					try {
						BufferedReader br=new BufferedReader(new FileReader(new File(url)));
						USDJPY = new AVLTree<>();
						String line="";
						while((line=br.readLine())!=null) {
						String[] obj=line.split(", ");
						String[] hour = obj[1].split(" ");
						String date = hour[0];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate localDate = LocalDate.parse(date, formatter);
						USDJPY.add(new Stock(obj[0],Double.parseDouble(obj[2]),localDate));
						}
							br.close();
					}catch(Exception e) {
					
					}
		}
	}
	
	public void filterData(String stock, String initialDate, String finalDate) {
		   
	}
	
	public double highestPrice() {
		

		return 0;
		
	}
		
}
