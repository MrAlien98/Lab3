package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.AVLTree;
import dataStructures.BinarySearchTree.DepthFirstSearchOrder;
class AVLTreeTest {
	private AVLTree<Integer> tree;
	int uno;
	int dos;
	int tres;
	int cuatro;;
	int cinco;
	int diez;
	
	void stage1() {
		tree= new AVLTree<Integer>();
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
	
	@SuppressWarnings("unused")
	void stage2() {
		tree= new AVLTree<Integer>();
		int uno=1;
		int dos=2;
		int tres=3;
		int cuatro=4;
		int cinco=5;
		int diez=10;		
	}
	@Test
	public void searchTest() {
		stage1();
		tree.add(56);
		tree.add(55);
		assertEquals(1000,(int)tree.search(1000).getID());
		assertEquals(1, (int)tree.search(1).getID());
		assertEquals(55, (int)tree.search(55).getID());
		
	}

	
	@Test
	public void deleteTest() {
		stage2();
		Integer[] arr=new Integer[5];
		arr[0]=uno;
		arr[1]=dos;
		arr[2]=tres;
		arr[3]=cuatro;
		arr[4]=diez;
		
		
		tree.add(cuatro);
		tree.add(cinco);
		tree.add(tres);
		tree.add(diez);
		tree.add(dos);
		tree.add(uno);
		tree.remove(cinco);
		
		assertArrayEquals(arr, tree.getDFS(DepthFirstSearchOrder.inOrder));
		
		
	}

	@Test
	public void addTest() {
		stage2();
		Integer[] arr=new Integer[6];
		arr[0]=cuatro;
		arr[1]=tres;
		arr[2]=dos;
		arr[3]=uno;
		arr[4]=diez;
		arr[5]=cinco;
		
		tree.add(cuatro);
		tree.add(cinco);
		tree.add(tres);
		tree.add(diez);
		tree.add(dos);
		tree.add(uno);
		
		assertArrayEquals(arr, tree.getDFS(DepthFirstSearchOrder.preOrder));
	}

	@Test
	public void clearTest() {
		stage1();
		tree.clear();
		assertEquals(0, tree.size());
	}

	@Test
	public void testSize() {
		stage1();
		assertEquals(10, tree.size());
	}
}
