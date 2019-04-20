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
	void loadStockTest1() {
		stage1();
		b.loadStock("AAPL");
//		assertNotNull(b.getUSSPX500());
//		assertEquals(1233, b.getUSSPX500().size());
	}
	
	@Test
	void loadStockTest2() {
		stage1();
		b.loadStock("USSPX500");
		assertNotNull(b.getUSSPX500());
		assertEquals(21140, b.getUSSPX500().size());
	}
	
	@Test
	void loadStockTest3() {
		stage1();
		b.loadStock("US30");
		assertNotNull(b.getUS30());
		assertEquals(21140, b.getUS30().size());
	}
	
	@Test
	void loadForexTest1() {
		stage1();
		b.loadForex("XAUUSD");
		assertEquals(31730, b.getXAUUSD().size());
		assertNotNull(b.getXAUUSD());
	}

	@Test
	void loadForexTest2() {
		stage1();
		b.loadForex("EURUSD");
		assertEquals(47997, b.getEURUSD().size());
		assertNotNull(b.getEURUSD());
	}
	
	@Test
	void loadForexTest3() {
		stage1();
		b.loadForex("GBPCAD");
		assertNotNull(b.getGBPCAD());
	}
	
	@Test
	void loadForexTest4() {
		stage1();
		b.loadForex("USDJPY");
		assertNotNull(b.getUSDJPY());
	}

}
