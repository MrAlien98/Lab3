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
	
	private AVLTree<Stock> US30;
	private AVLTree<Stock> USSPX500;
	private AVLTree<Stock> AAPL;
	private AVLTree<Stock> MSFT;
	private AVLTree<Stock> WTI;

	private RedBlackTree<Forex> XAUUSD;
	private RedBlackTree<Forex> EURUSD;
	private RedBlackTree<Forex> GBPCAD;
	private RedBlackTree<Forex> USDJPY;
	
	
	private ArrayList<Forex> BTCUSD;
	
	public BVC_APP() {
		
	}

	/**
	 * @return the xAUUSD
	 */
	public  RedBlackTree<Forex> getXAUUSD() {
		return XAUUSD;
	}

	/**
	 * @param xAUUSD the xAUUSD to set
	 */
	public void setXAUUSD( RedBlackTree<Forex> xAUUSD) {
		XAUUSD = xAUUSD;
	}

	/**
	 * @return the eURUSD
	 */
	public RedBlackTree<Forex> getEURUSD() {
		return EURUSD;
	}

	/**
	 * @param eURUSD the eURUSD to set
	 */
	public void setEURUSD( RedBlackTree<Forex> eURUSD) {
		EURUSD = eURUSD;
	}

	/**
	 * @return the gBPCAD
	 */
	public RedBlackTree<Forex> getGBPCAD() {
		return GBPCAD;
	}

	/**
	 * @param gBPCAD the gBPCAD to set
	 */
	public void setGBPCAD( RedBlackTree<Forex> gBPCAD) {
		GBPCAD = gBPCAD;
	}

	/**
	 * @return the uSDJPY
	 */
	public  RedBlackTree<Forex> getUSDJPY() {
		return USDJPY;
	}

	/**
	 * @param uSDJPY the uSDJPY to set
	 */
	public void setUSDJPY( RedBlackTree<Forex> uSDJPY) {
		USDJPY = uSDJPY;
	}

	/**
	 * @return the uS30
	 */
	public  AVLTree<Stock> getUS30() {
		return US30;
	}

	/**
	 * @param uS30 the uS30 to set
	 */
	public void setUS30( AVLTree<Stock> uS30) {
		US30 = uS30;
	}

	/**
	 * @return the uSSPX500
	 */
	public  AVLTree<Stock> getUSSPX500() {
		return USSPX500;
	}

	/**
	 * @param uSSPX500 the uSSPX500 to set
	 */
	public void setUSSPX500( AVLTree<Stock> uSSPX500) {
		USSPX500 = uSSPX500;
	}

	/**
	 * @return the aAPL
	 */
	public  AVLTree<Stock> getAAPL() {
		return AAPL;
	}

	/**
	 * @param aAPL the aAPL to set
	 */
	public void setAAPL( AVLTree<Stock> aAPL) {
		AAPL = aAPL;
	}

	/**
	 * @return the mSFT
	 */
	public  AVLTree<Stock> getMSFT() {
		return MSFT;
	}

	/**
	 * @param mSFT the mSFT to set
	 */
	public void setMSFT( AVLTree<Stock> mSFT) {
		MSFT = mSFT;
	}

	/**
	 * @return the wTI
	 */
	public  AVLTree<Stock> getWTI() {
		return WTI;
	}

	/**
	 * @param wTI the wTI to set
	 */
	public void setWTI( AVLTree<Stock> wTI) {
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
	
	public void loadStock(String url) {
		if(url.equals("AAPL")) {
			url="src/forexData/AAPL.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				AAPL = new AVLTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					String date = obj[1];
					LocalDate localDate = LocalDate.parse(date, formatter);
					Stock s = new Stock(obj[0],Double.parseDouble(obj[2]),localDate);
					AAPL.add(s);
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("USSPX500")) {
			url="data/#USSPX500.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				USSPX500 = new AVLTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
//					String[] hour = obj[1].split(" ");
//					String date = hour[0];
//					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//					LocalDate localDate = LocalDate.parse(date, formatter);
					LocalDate localDate = LocalDate.now();
					USSPX500.add(new Stock(obj[0],Double.parseDouble(obj[2]),localDate));
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("US30")) {
			url="data/#US30.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				US30 = new AVLTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
//					String[] hour = obj[1].split(" ");
//					String date = hour[0];
//					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//					LocalDate localDate = LocalDate.parse(date, formatter);
					// funciona pero con la fecha actual
					LocalDate localDate = LocalDate.now();
					US30.add(new Stock(obj[0],Double.parseDouble(obj[2]),localDate));
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("MSFT")) {
			url="src/forexData/MSFT.txt";
		}else if(url.equals("WTI")) {
			url="src/forexData/WTI.txt";
		}
	}
	
	public void loadForex(String url) {
		if (url.equals("XAUUSD")) {
			url="data/XAUUSD.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				XAUUSD = new RedBlackTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
//					String[] hour = obj[1].split(" ");
//					String date = hour[0];
//					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//					LocalDate localDate = LocalDate.parse(date, formatter);
					LocalDate localDate = LocalDate.now();
					// NO ES EL ADD DEL REDBLACKTREE
					XAUUSD.add(new Forex(obj[0],Double.parseDouble(obj[2]),localDate));
				}
					br.close();
			}catch(Exception e) {
				
			}
		}else if(url.equals("EURUSD")) {
			url="data/EURUSD.txt";
			try {
				BufferedReader br=new BufferedReader(new FileReader(new File(url)));
				EURUSD = new RedBlackTree<>();
				String line="";
				while((line=br.readLine())!=null) {
					String[] obj=line.split(", ");
					String[] hour = obj[1].split(" ");
					String date = hour[0];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate localDate = LocalDate.parse(date, formatter);
//					LocalDate localDate = LocalDate.now();
					EURUSD.add(new Forex(obj[0],Double.parseDouble(obj[2]),localDate));
				}
					br.close();
			}catch(Exception e) {
				
			}
			}else if(url.equals("GBPCAD")) {
				url="data/GBPCAD.txt";
				try {
					BufferedReader br=new BufferedReader(new FileReader(new File(url)));
					GBPCAD = new RedBlackTree<>();
					String line="";
					while((line=br.readLine())!=null) {
						String[] obj=line.split(", ");
						String[] hour = obj[1].split(" ");
						String date = hour[0];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate localDate = LocalDate.parse(date, formatter);
						GBPCAD.add(new Forex(obj[0],Double.parseDouble(obj[2]),localDate));
					}
						br.close();
				}catch(Exception e) {
					
				}
				}else if(url.equals("USDJPY")) {
					url="data/USDJPY.txt";
					try {
						BufferedReader br=new BufferedReader(new FileReader(new File(url)));
						USDJPY = new RedBlackTree<Forex>();
						String line="";
						while((line=br.readLine())!=null) {
						String[] obj=line.split(", ");
						String[] hour = obj[1].split(" ");
						String date = hour[0];
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate localDate = LocalDate.parse(date, formatter);
						USDJPY.add(new Forex(obj[0],Double.parseDouble(obj[2]),localDate));
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
