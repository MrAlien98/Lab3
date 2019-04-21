package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
	
	@Test
	void loadStockTest1() { 
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 21);
		b.loadData("USSPX500", start, end);
		assertNotNull(b.getStocks());
		assertEquals(1191, b.getStocks().size());
	}
	
	@Test
	void LoadStockTest2() {
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 21);
		b.loadData("USSPX500", start, end);
		LocalDate ajam=LocalDate.of(2019, 3, 20);
		FinancialThing webos=new FinancialThing(2, 2830.25, ajam);
		Node<FinancialThing> eL=b.getStocks().search(webos);
		assertEquals(webos.getValue(), eL.getID().getValue());
	}

}
