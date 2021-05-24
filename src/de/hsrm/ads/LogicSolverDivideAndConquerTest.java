
package de.hsrm.ads;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import org.junit.Test;

public class LogicSolverDivideAndConquerTest {

	// checks if two short[][] arrays contain the same short[] subarrays
	// (the exact order of the short[] subarrays is ignored).
	void assertEqualsArray(short[][] expected, short[][] actual) {
		assertEquals(expected.length, actual.length);
		if (expected.length==0)
			return;
		int k = expected[0].length;
		for (short[] e : expected) {
			assertEquals(e.length, k);
			boolean found = false;
			for (short[] a : actual) {
				if (Arrays.equals(e,a)) {
					found = true;
					break;
				}
			}
			assertTrue(found);				
		}
	}
	
	@Test
	public void testSolutionsForClause1() {
		short[] clause = new short[]{1,-1};
		short[][] actual = LogicSolverDivideAndConquer.solutionsForClause(clause);
		short[][] expected = new short[][] {
			{-1, -1},
			{ 1, -1},
			{ 1,  1}
		};
		assertEqualsArray(expected, actual);
	}

	@Test
	public void testSolutionsForClause2() {
		short[] clause = new short[]{1,0,-1};
		short[][] actual = LogicSolverDivideAndConquer.solutionsForClause(clause);
		short[][] expected = new short[][] {
			{-1, -1, -1},
			//{-1, -1,  1},
			{-1,  1, -1},
			//{-1,  1,  1},
			{ 1, -1, -1},
			{ 1, -1,  1},
			{ 1,  1, -1},
			{ 1,  1,  1},
		};
		assertEqualsArray(expected, actual);
	}
	
	@Test
	public void testSolutionsForClause3() {
		short[] clause = new short[]{0,-1,0};
		short[][] actual = LogicSolverDivideAndConquer.solutionsForClause(clause);
		short[][] expected = new short[][] {
			{-1, -1, -1},
			{-1, -1,  1},
			//{-1,  1, -1},
			//{-1,  1,  1},
			{ 1, -1, -1},
			{ 1, -1,  1},
			//{ 1,  1, -1},
			//{ 1,  1,  1},
		};
		assertEqualsArray(expected, actual);
	}

	@Test
	public void testSolutionsForClause4() {
		short[] clause = new short[]{1,1,1,1};
		short[][] actual = LogicSolverDivideAndConquer.solutionsForClause(clause);
		short[][] expected = new short[][] {
			//{-1, -1, -1, -1},
			{-1, -1, -1,  1},
			{-1, -1,  1, -1},
			{-1, -1,  1,  1},
			{-1,  1, -1, -1},
			{-1,  1, -1,  1},
			{-1,  1,  1, -1},
			{-1,  1,  1,  1},
			{ 1, -1, -1, -1},
			{ 1, -1, -1,  1},
			{ 1, -1,  1, -1},
			{ 1, -1,  1,  1},
			{ 1,  1, -1, -1},
			{ 1,  1, -1,  1},
			{ 1,  1,  1, -1},
			{ 1,  1,  1,  1},
		};
		assertEqualsArray(expected, actual);
	}

	@Test
	public void testSolutionsForClause5() {
		short[] clause = new short[]{1,0,0,-1};
		short[][] actual = LogicSolverDivideAndConquer.solutionsForClause(clause);
		short[][] expected = new short[][] {
			{-1, -1, -1, -1},
			//{-1, -1, -1,  1},
			{-1, -1,  1, -1},
			//{-1, -1,  1,  1},
			{-1,  1, -1, -1},
			//{-1,  1, -1,  1},
			{-1,  1,  1, -1},
			//{-1,  1,  1,  1},
			{ 1, -1, -1, -1},
			{ 1, -1, -1,  1},
			{ 1, -1,  1, -1},
			{ 1, -1,  1,  1},
			{ 1,  1, -1, -1},
			{ 1,  1, -1,  1},
			{ 1,  1,  1, -1},
			{ 1,  1,  1,  1},
		};
		assertEqualsArray(expected, actual);
	}

	
	
	// ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
	short[][] formula1 = new short[][] {
		{ -1, -1,  0, 0 },
		{ 0,  1, -1, 0 },
		{ 0,  0,  1, 1 }
	};

	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 )
	short[][] formula2 = new short[][] {
		{ -1, -1 },
		{ -1,  1 },
		{  1, -1 },
	};

	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
	short[][] formula3 = new short[][] {
		{ -1, -1 },
		{ -1,  1 },
		{  1, -1 },
		{  1,  1 },
	};

	// ( -X1 v -X2 ) ^ X1
	short[][] formula4 = new short[][] {
		{ -1, -1 },
		{  1,  0 },
	};

	// X6
	short[][] formula5 = new short[][] {
		{ 0, 0, 0, 1 },
	};

		
	// ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
	@Test
	public void testDivideAndConquer1() {
		short[][] actual = LogicSolverDivideAndConquer.solveDivideAndConquer(formula1);
		short[][] expected = new short[][] {
			{-1, -1, -1, 1},
			{-1, 1, -1, 1},
			{-1, 1, 1, -1},
			{-1, 1, 1, 1},
			{1, -1, -1, 1}			
		};
		assertEqualsArray(expected, actual);
	}

	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 )
	@Test
	public void testDivideAndConquer2() {
		short[][] actual = LogicSolverDivideAndConquer.solveDivideAndConquer(formula2);
		short[][] expected = new short[][] {
			{-1, -1},
		};
		assertEqualsArray(expected, actual);		
	}
	
	// ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 )
	@Test
	public void testDivideAndConquer3() {
		short[][] actual = LogicSolverDivideAndConquer.solveDivideAndConquer(formula3);
		short[][] expected = new short[][] {};
		assertEqualsArray(expected, actual);		
	}

	// ( -X1 v -X2 ) ^ X1
	@Test
	public void testDivideAndConquer4() {
		short[][] actual = LogicSolverDivideAndConquer.solveDivideAndConquer(formula4);
		short[][] expected = new short[][] {
			{1, -1},
		};
		assertEqualsArray(expected, actual);		
	}

	// X4 (nur X4)
	@Test
	public void testDivideAndConquer5() {
		short[][] actual = LogicSolverDivideAndConquer.solveDivideAndConquer(formula5);
		short[][] expected = new short[][] {
			{-1, -1, -1, 1},
			{-1, -1, 1, 1},
			{-1, 1, -1, 1},
			{-1, 1, 1, 1},
			{1, -1, -1, 1},
			{1, -1, 1, 1},
			{1, 1, -1, 1},
			{1, 1, 1, 1},
		};
		assertEqualsArray(expected, actual);		
	}
	
}
