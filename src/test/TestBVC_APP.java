package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import dataStructures.BinarySearchTree.Node;
import model.BVC_APP;
import model.FinancialThing;

class TestBVC_APP {
	private BVC_APP b;
	
	void stage1() {
		b = new BVC_APP();
	}
	
	void stage2() {
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 21);
		b.loadData("USSPX500", start, end);
	}
	
	void stage3() {
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 21);
		b.loadData("USDJPY", start, end);
	}
	
	@Test
	void loadStockTest1() { 
		stage2();
		assertNotNull(b.getStocks());
		assertEquals(1191, b.getStocks().size());
	}
	
	@Test
	void LoadStockTest2() {
		stage2();
		LocalDate ajam=LocalDate.of(2019, 3, 20);
		FinancialThing webos=new FinancialThing(2, 2830.25, ajam);
		Node<FinancialThing> eL=b.getStocks().search(webos);
		assertEquals(webos.getValue(), eL.getID().getValue());
	}

	@Test
	void LoadForexTest() {
		stage3();
		
		assertNotNull(b.getForexs());
		assertEquals(1190, b.getForexs().size());
	}
	
	@Test
	void LoadForexTest2() {
		stage3();
		LocalDate ajam=LocalDate.of(2019, 3, 20);
		FinancialThing webos2=new FinancialThing(1, 110.724, ajam);
		Node<FinancialThing> eL2=b.getForexs().search(webos2);
		assertEquals(webos2.getValue(), eL2.getID().getValue());
	}
	
	@Test
	void loadEachTest1() { 
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 6);
		String url = "US30";
		b.loadEach(url, 0, start, end);
		assertNotNull(b.getArr2().get(0));
	}
	
	@Test
	void loadEverythingTest1() { 
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 6);
		b.loadEverything(start, end);
		assertNotNull(b.getArr2().get(4));
	}

	

	
}
