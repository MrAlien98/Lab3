package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import dataStructures.*;
class RedBlackTreeTest{
private RedBlackTree<Integer> tree;
	
	void stage1() {
		tree= new RedBlackTree<Integer>();
		tree.add(8);
		tree.add(4);
		tree.add(34);
		tree.add(98);
		tree.add(233);
		tree.add(1450);
		tree.add(0);
		tree.add(734);
		tree.add(1200);
		tree.add(1000);
		tree.add(98765);
		tree.add(98754);
	}

	@Test
	public void searchTest() {
		stage1();
		
		assertEquals(233, (int)tree.search(233).getID());
		assertEquals(734, (int)tree.search(734).getID());
	}

	@Test
	public void addTest() {
		stage1();
		assertEquals(12, tree.size());
	}

	@Test
	public void deleteTest() {
		stage1();
		tree.remove(1000);
		tree.remove(98754);
		tree.remove(98765);
		
		assertEquals(9, tree.size());
		assertNull(tree.search(1000));
		assertNull(tree.search(98754));
		assertNull(tree.search(98765));
	}

}
