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
	void loadDataTest() {
		stage1();
		b.loadData();
		assertEquals(15865, b.getXAUUSD().size());
	}

}
