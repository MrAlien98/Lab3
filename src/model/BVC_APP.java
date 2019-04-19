package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	public void loadData() {
		FileReader fr = null;
	    BufferedReader br = null;
			try {
				fr = new FileReader (new File("data/XAUUSD prices.txt"));
				br = new BufferedReader(fr);
				XAUUSD = new AVLTree<>();
					while(br.readLine()!=null) {
						String read = br.readLine();
						String[] v = read.split(", ");
						Stock s = new Stock();
						s.setValue(Double.parseDouble(v[2]));
						XAUUSD.add(s);
					}
			
					fr.close();
					br.close();
			
				}catch (Exception e) { 
					// TODO: handle exception
				}
			
			try {
				fr = new FileReader (new File("data/EURUSD prices.txt"));
				br = new BufferedReader(fr);
				EURUSD = new AVLTree<>();
					while(br.readLine()!=null) {
						String read = br.readLine();
						String[] v = read.split(", ");
						Stock s = new Stock();
						s.setValue(Double.parseDouble(v[2]));
						EURUSD.add(s);
					}
			
					fr.close();
					br.close();
			
				}catch (Exception e) { 
					// TODO: handle exception
				}
	}
	
	public void filterData(String stock, String initialDate, String finalDate) {
		   
	}
	
	public double highestPrice() {
		

		return 0;
		
	}
		
}
