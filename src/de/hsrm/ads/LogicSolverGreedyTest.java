
package de.hsrm.ads;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;

public class LogicSolverGreedyTest {

	// X2 v X3 v -X5
	static short[] clause1 = new short[] { 0, 1, 1, 0,-1};

	// -X2
	static short[] clause2 = new short[] { 0,-1};
	  
	@Test
	public void testSatisfiesClause1() {
		assertEquals( "(1,-1,-1,0,1) does not satisfy X2vX3v-X5!", LogicSolverGreedy.satisfies(new short[] {1,-1,-1, 0, 1}, clause1), false);
	}
	
	@Test
	public void testSatisfiesClause2() {
		assertEquals( "(1,-1,-1,0,-1) does satisfy X2vX3v-X5!", LogicSolverGreedy.satisfies(new short[] {1,-1,-1, 0, -1}, clause1), true);
	}
	
	@Test
	public void testSatisfiesClause3() {
		assertEquals( "(1,1,-1,0,-1) does satisfy X2vX3v-X5!", LogicSolverGreedy.satisfies(new short[] {1,1,-1, 0, -1}, clause1), true);
	}
	
	@Test
	public void testSatisfiesClause4() {
		assertEquals( "(0,0,0,0,0) does not satisfy X2vX3v-X5!", LogicSolverGreedy.satisfies(new short[] {0,0,0,0,0}, clause1), false);
	}
	
	@Test
	public void testSatisfiesClause5() {
		assertEquals( "(1,0) does not satisfy -X2!", LogicSolverGreedy.satisfies(new short[] {1,0}, clause2), false);
	}
	
	@Test
	public void testSatisfiesClause6() {
		assertEquals( "(1,-1) does satisfy -X2!", LogicSolverGreedy.satisfies(new short[] {1,-1}, clause2), true);
	}

	@Test
	public void testSatisfiableClause1() {
		assertEquals( "(1,-1,-1,0,1) does not make X2vX3v-X5 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {1,-1,-1, 0, 1}, clause1), false);
	}
	
	@Test
	public void testSatisfiableClause2() {
		assertEquals( "(1,-1,-1,0,-1) does make X2vX3v-X5 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {1,-1,-1, 0, 0}, clause1), true);
	}
	
	@Test
	public void testSatisfiableClause3() {
		assertEquals( "(1,1,1,0,1) does make X2vX3v-X5 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {1,1,1, 0, 1}, clause1), true);
	}
	
	@Test
	public void testSatisfiableClause4() {
		assertEquals( "(0,0,0,0,0) does not make X2vX3v-X5 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {0,0,0,0,0}, clause1), true);
	}
	
	@Test
	public void testSatisfiableClause5() {
		assertEquals( "(1,0) does make -X2 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {1,0}, clause2), true);
	}
	
	@Test
	public void testSatisfiableClause6() {
		assertEquals( "(1,-1) does make -X2 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {1,-1}, clause2), true);
	}
	
	@Test
	public void testSatisfiableClause7() {
		assertEquals( "(1,1) does not make -X2 satisfiable!", LogicSolverGreedy.satisfiable(new short[] {1,1}, clause2), false);
	}

	// ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 )
	short[][] formula1 = new short[][] {
		{ -1, -1,  0, 0 },
		{ 0,  1, -1, 0 },
		{ 0,  0,  1, 1 }
	};
	
	@Test
	public void testSatisfiesFormula1() {
		assertEquals( "(0,0,0,0) does not satisfy ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) !", 
				LogicSolverGreedy.satisfies(new short[] {0,0,0,0}, formula1), false);
	}
	
	@Test
	public void testSatisfiesFormula2() {
		assertEquals( "(0,-1,-1,0) does not satisfy ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) !", 
				LogicSolverGreedy.satisfies(new short[] {0,-1,-1,0}, formula1), false);
	}
	
	@Test
	public void testSatisfiesFormula3() {
		assertEquals( "(0,-1,-1,1) does satisfy ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) !", 
				LogicSolverGreedy.satisfies(new short[] {0,-1,-1,1}, formula1), true);
	}
	
	@Test
	public void testSatisfiesFormula4() {
		assertEquals( "(1,1,1,1) does not satisfy ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) !", 
				LogicSolverGreedy.satisfies(new short[] {1,1,1,1}, formula1), false);
	}
	
	@Test
	public void testSatisfiesFormula5() {
		assertEquals( "(-1,-1,-1,1) does satisfy ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) !", 
				LogicSolverGreedy.satisfies(new short[] {-1,-1,-1,1}, formula1), true);
	}

	@Test
	public void testSatisfiableFormula1() {
		assertEquals( "(0,0,0,0) does make( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) satisfiable!", 
				LogicSolverGreedy.satisfiable(new short[] {0,0,0,0}, formula1), true);
	}
	
	@Test
	public void testSatisfiableFormula2() {
		assertEquals( "(0,-1,-1,0) does make( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) satisfiable!", 
				LogicSolverGreedy.satisfiable(new short[] {0,-1,-1,0}, formula1), true);
	}
	
	@Test
	public void testSatisfiableFormula3() {
		assertEquals( "(1,1,0,0) does not make ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) satisfiable!", 
				LogicSolverGreedy.satisfiable(new short[] {1,1,0,0}, formula1), false);
	}
	
	@Test
	public void testSatisfiableFormula4() {
		assertEquals( "(0,-1,-1,1) does make ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) satisfiable!", 
				LogicSolverGreedy.satisfiable(new short[] {0,-1,-1,1}, formula1), true);
	}
	
	@Test
	public void testSatisfiableFormula5() {
		assertEquals( "(1,1,1,1) does not make ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) satisfiable!", 
				LogicSolverGreedy.satisfiable(new short[] {1,1,1,1}, formula1), false);
	}

	public static void check(String msg, short[] a, short[] b) {
		assertEquals(msg, a.length, b.length);
		for (int i=0; i<a.length; ++i) {
			assertEquals(msg, a[i], b[i]);
		}
	}
	
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

	// X4
	short[][] formula5 = new short[][] {
		{ 0, 0, 0, 1 },
	};


	@Test
	public void testGreedy1() {
		short[] result = LogicSolverGreedy.solveGreedy(formula1);
		check( "Greedy Solution for ( -X1 v -X2 ) ^ ( X2 v -X3 ) ^ ( X3 v X4 ) should be (-1,1,1,0)!", 
				new short[] {-1,1,1,0}, result);
	}
	
	@Test
	public void testGreedy2() {
		short[] result = LogicSolverGreedy.solveGreedy(formula2);
		check( "Greedy Solution for ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) should be (-1,-1)!", 
				new short[] {-1,-1}, result);
	}
	
	@Test
	public void testGreedy3() {
		short[] result = LogicSolverGreedy.solveGreedy(formula3);
		check( "Greedy Solution for ( -X1 v -X2 ) ^ ( -X1 v X2 ) ^ ( X1 v -X2 ) ^ ( X1 v X2 ) should be (0,0)!", 
				new short[] {0,0}, result);
	}
	
	@Test
	public void testGreedy4() {
		short[] result = LogicSolverGreedy.solveGreedy(formula4);
		check( "Greedy Solution for ( -X1 v -X2 ) ^ X1 should be (0,0)!", 
				new short[] {0,0}, result);
	}

	@Test
	public void testGreedy5() {
		short[] result = LogicSolverGreedy.solveGreedy(formula5);
		check( "Greedy Solution for ( X4 ) should be (0,0,0,1)!", 
				new short[] {0,0,0,1}, result);
	}
	
}
