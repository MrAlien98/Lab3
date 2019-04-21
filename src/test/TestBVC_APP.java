package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.sound.midi.Soundbank;

import org.junit.jupiter.api.Test;

import model.BVC_APP;

class TestBVC_APP {
	private BVC_APP b;
	
	void stage1() {
		b = new BVC_APP();
	}
	
	@Test
	void loadStockTest1() { 
		stage1();
		LocalDate start=LocalDate.of(2019, 3, 20);
		LocalDate end=LocalDate.of(2019, 3, 6);
		b.loadData("USSPX500", start, end);
		assertNotNull(b.getGeneral1());
		assertEquals(21140, b.getGeneral1().size());
	}
	
	

}
