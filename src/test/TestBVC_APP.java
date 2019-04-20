package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;

import org.junit.jupiter.api.Test;

class TestBVC_APP {
	private BVC_APP b;
	
	void stage1() {
		b = new BVC_APP();
	}
	
	@Test
	void loadForexTest() {
		stage1();
		b.loadForex("USSPX500");
		assertNotNull(b.getUSSPX500());
		assertEquals(1233, b.getUSSPX500().size());
	}
	
	@Test
	void loadStockTest1() {
		stage1();
		b.loadStock("XAUUSD");
		assertEquals(31730, b.getXAUUSD().size());
		assertNotNull(b.getXAUUSD());
	}

	@Test
	void loadStockTest2() {
		stage1();
		b.loadStock("EURUSD");
		assertEquals(31730, b.getEURUSD().size());
		assertNotNull(b.getEURUSD());
	}
	
	@Test
	void loadStockTest3() {
		stage1();
		b.loadStock("GBPCAD");
		assertNotNull(b.getGBPCAD());
	}
	
	@Test
	void loadStockTest4() {
		stage1();
		b.loadStock("USDJPY");
		assertNotNull(b.getUSDJPY());
	}

}
