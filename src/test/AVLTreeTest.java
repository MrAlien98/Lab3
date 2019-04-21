package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.RedBlackTree;
import model.*
;class AVLTreeTest {
private RedBlackTree<Integer> tree;
	
	void stage1() {
		tree= new RedBlackTree<Integer>();
		tree.add(5);
		tree.add(4);
		tree.add(1);
		tree.add(8);
		tree.add(23);
		tree.add(10);
		tree.add(0);
		tree.add(7);
		tree.add(12);
		tree.add(1000);
		
	}

	@Test
	public void searchTest() {
		stage1();
		tree.add(56);
		tree.add(55);
		assertEquals(1000,(int)tree.search(1000).getID());
		assertEquals(1, (int)tree.search(1).getID());
		assertEquals(55, (int)tree.search(55).getID());;
	}



}
