package eidi2.sose25.weber.felix.sheet04.ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTestsSolution {

	/**
	 * Requires constructor DynamicArray() to work.
	 * Requires methods get() and size() to work.
	 */
	@Test
	public void testAdd1() {
		DynamicArray<Integer> da = new DynamicArray<>();

		assertEquals(0, da.size());

		da.add(5);
		assertEquals(1, da.size());
		assertEquals(5, (int) da.get(0));

		da.add(7);
		assertEquals(2, da.size());
		assertEquals(5, (int) da.get(0));
		assertEquals(7, (int) da.get(1));
	}

	/**
	 * Requires constructor DynamicArray() to work.
	 * Requires methods get() and size() to work.
	 */
	@Test
	public void testAdd2() {
		DynamicArray<Integer> da = new DynamicArray<>();

		assertEquals(0, da.size());

		da.add(0, 5);
		assertEquals(1, da.size());
		assertEquals(5, (int) da.get(0));

		da.add(0, 7);
		assertEquals(2, da.size());
		assertEquals(7, (int) da.get(0));
		assertEquals(5, (int) da.get(1));
	}

	/**
	 * Requires constructor DynamicArray() to work.
	 * Requires methods resize() and get() to work.
	 */
	@Test
	public void testAdd3() {
		DynamicArray<Integer> da = new DynamicArray<>();

		for (int i = 0; i < 1000; i++) {
			da.add(i);
		}

		for (int i = 0; i < 1000; i++) {
			assertEquals(i, (int) da.get(i));
		}
	}

	/**
	 * Requires constructor DynamicArray() to work.
	 * Requires methods resize() and get() to work.
	 */
	@Test
	public void testAdd4() {
		DynamicArray<Integer> da = new DynamicArray<>();

		for (int i = 0; i < 1000; i++) {
			da.add(0, i);
		}

		for (int i = 0; i < 1000; i++) {
			assertEquals(1000 - i - 1, (int) da.get(i));
		}
	}

	/**
	 * Requires constructor DynamicArray(int n) to work.
	 * Requires methods add(...), size() and get() to work.
	 */
	@Test
	public void testSet() {
		DynamicArray<Integer> da = new DynamicArray<>(1000);

		for (int i = 0; i < 1000; i++) {
			da.add(i);
		}

		for (int i = 1000, k = 0; i > 0; i--, k++) {
			assertEquals(k, (int) da.get(k));
			da.set(k, i);
			assertEquals(i, (int) da.get(k));
		}

		assertEquals(1000, da.size());
	}

	/**
	 * Requires constructor DynamicArray(int...) to work
	 */
	@Test
	public void testGet() {
		DynamicArray<Integer> da = new DynamicArray<>(5, 2, 1);
		assertEquals(5, (int) da.get(0));
		assertEquals(2, (int) da.get(1));
		assertEquals(1, (int) da.get(2));
	}

	/**
	 * Requires constructor DynmaicArray(int...) to work
	 */
	@Test
	public void testIndexOf(){
		DynamicArray<Integer> da = new DynamicArray<>(3, 5, 2, 0);
		assertEquals(0, da.indexOf(3));
		assertEquals(2, da.indexOf(2));
		assertEquals(-1, da.indexOf(42));
	}

	/**
	 * Requires constructor DynmaicArray(int...) to work
	 */
	@Test
	public void testLastIndexOf(){
		DynamicArray<Integer> da = new DynamicArray<>(3, 5, 2, 0);
		assertEquals(0, da.lastIndexOf(3));
		assertEquals(2, da.lastIndexOf(2));
		assertEquals(-1, da.lastIndexOf(42));

		da = new DynamicArray<>(3,5,4,3,2,0,5);

		assertEquals(3, da.lastIndexOf(3));
		assertEquals(6, da.lastIndexOf(5));
		assertEquals(-1, da.lastIndexOf(42));
	}

	/**
	 * Requires constructor DynmaicArray(int...) to work
	 */
	@Test
	public void testContains(){
		DynamicArray<Integer> da = new DynamicArray<>(3, 5, 2, 0);
		assertTrue(da.contains(3));
		assertTrue(da.contains(5));
		assertTrue(da.contains(2));
		assertTrue(da.contains(0));
		assertFalse(da.contains(42));
	}

	/**
	 * Requires constructor DynamicArray(int...) to work
	 */
	@Test
	public void testSize() {
		DynamicArray<Integer> da = new DynamicArray<>(5, 2, 1);
		assertEquals(3, da.size());
	}

	/**
	 * Requires constructors DynamicArray(),  DynamicArray(int...) to work
	 */
	@Test
	public void testIsEmpty() {
		DynamicArray<Integer> da = new DynamicArray<>(5, 2, 1);
		assertFalse(da.isEmpty());

		da = new DynamicArray<>();
		assertTrue(da.isEmpty());
	}

	/**
	 * Requires constructors DynamicArray(int...) to work
	 * Requires method isEmpty(), size() to work
	 */
	@Test
	public void testClear() {
		DynamicArray<Integer> da = new DynamicArray<>(5, 2, 1);
		assertFalse(da.isEmpty());

		da.clear();

		assertEquals(0, da.size());
		assertTrue(da.isEmpty());
	}


	/**
	 * Requires constructors DynamicArray(int...) to work
	 * Requires method size() to work
	 */
	@Test
	public void testRemove() {
		DynamicArray<Integer> da = new DynamicArray<>(5, 2, 1);

		assertEquals(5, (int) da.remove(0));
		assertEquals(2, da.size());
		assertEquals(1, (int) da.remove(1));
		assertEquals(1, da.size());
	}

	/**
	 * Requires constructor DynamicArray(int...) to work
	 * Requires method size() to work
	 */
	@Test
	public void testRemove2() {
		DynamicArray<Integer> da = new DynamicArray<>(5, 2, 1);

		assertTrue(da.remove((Integer) 5));
		assertTrue(da.remove((Integer) 1));
		assertFalse(da.remove((Integer) 42));
		assertTrue(da.remove((Integer) 2));
		assertFalse(da.remove((Integer) 2));
	}

	/**
	 * Require constructor DynamicArray(int...) to work
	 */
	@Test
	public void testIterator(){
		int[] test = {1,5,7,3};

		DynamicArray<Integer> da = new DynamicArray<>(1,5,7,3);

		int i = 0;
		for(int n : da){
			assertEquals(test[i++], n);
		}

		assertEquals(4, i);
	}

	//Testing the exception cases

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testAddException1(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.add(-1, 5));
	}

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testAddException2(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.add(5, 5));
	}

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testSetException1(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.set(-1, 5));
	}

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testSetException2(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.set(5, 5));
	}


	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testGetException1(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.get(-1));
	}

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testGetException2(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.get(5));
	}

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testRemoveException1(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.remove(-1));
	}

	/**
	 * Requires DynamicArray(int...) to work
	 */
	@Test
	public void testRemoveException2(){
		DynamicArray<Integer> da = new DynamicArray<>(42, 3, 27);
		assertThrows(IndexOutOfBoundsException.class, () -> da.remove(5));
	}
}
