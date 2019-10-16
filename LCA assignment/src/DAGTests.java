/*
 *
 *  @author: David Berry (berryd1) 
 *  @dateOfSubmission: October 2019
 *
*/
import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTests {

	@Test
	public void directedGraphTest()
	{
		DAG test1 = new DAG(10);
		test1.addEdge(1, 2);
		test1.addEdge(1, 3);
		test1.addEdge(3, 4);
		test1.addEdge(4, 5);
		test1.addEdge(4, 6);

		assertEquals("", 5, test1.E());
		assertEquals("", 10, test1.V());
		String ans = "[5, 6]";
		assertEquals("",ans, test1.adj(4).toString());
	}
	
	@Test
	public void inDegreeTest(){
		DAG test2 = new DAG(5);
		assertEquals("", -1, test2.indegree(-3));
	}

	@Test
	public void outDegreeTest(){
		DAG test3 = new DAG(5);
		assertEquals("", -1, test3.outdegree(8));	
	}
	
	@Test
	public void cyclingTest()
	{
		DAG test4cyclic = new DAG(20);
		test4cyclic.addEdge(0, 1);
		test4cyclic.addEdge(1, 2);
		test4cyclic.addEdge(2, 0);

		test4cyclic.findCycle(0);

		assertTrue(test4cyclic.hasCycle());
		//Cycle exists, should return true
		DAG test4acyclic = new DAG(20);
		test4acyclic.addEdge(0, 1);
		test4acyclic.addEdge(1, 3);
		test4acyclic.addEdge(2, 4);
		test4acyclic.findCycle(0);
		
		assertFalse(test4acyclic.hasCycle());
		//Cycle doesn't exist, should return false
	}
	
	@Test
	public void addEdgeTest()
	{
		DAG test5 = new DAG(5);
		test5.addEdge(0, 1);

		test5.addEdge(-2, -5);
		assertEquals("Testing edge count is 1", 1, test5.E());

		test5.addEdge(1, 2);
		assertEquals("Testing edge count is 2", 2, test5.E());
	}
	
	@Test
	public void emptyLCATest() {
		DAG test6 = new DAG(10);
		assertEquals("Testing LCA is -1", -1, test6.findLowestCommonAncestor(1, 2));
	}
	
	@Test
	public void noCommonAncestorsLCATest(){
		DAG test7 = new DAG(11);
		
		//-----1----5----
		//---0-|---/-----
		//-----2--3---4--
		
		test7.addEdge(0, 1);
		test7.addEdge(0, 2);
		test7.addEdge(1, 2);
		test7.addEdge(2, 3);
		test7.addEdge(3, 4);
		test7.addEdge(1, 5);
		test7.addEdge(3, 5);

		assertEquals("Finding LCA when there is no LCA", 0, test7.findLowestCommonAncestor(3, 1));
		assertEquals("", 2, test7.findLowestCommonAncestor(3, 2));
		assertEquals("", 3, test7.findLowestCommonAncestor(4, 5));
		assertEquals("Finding LCA when one node doesnt exist", -1, test7.findLowestCommonAncestor(7, 3));
	}

	@Test
	public void LCAForNonDAGTest()
	{
		DAG test8 = new DAG(11);
		//---0
		//--|-\
		//--2--3
		
		//0 - 2 - 3 make a cycle

		test8.addEdge(0, 1);
		test8.addEdge(0, 2);
		test8.addEdge(2, 3);
		test8.addEdge(3, 0);
		test8.addEdge(3, 4);

		//Returns -1 if graph is not a DAG
		assertEquals("", -1, test8.findLowestCommonAncestor(2, 3));
		assertEquals("", -1, test8.findLowestCommonAncestor(3, 4));
		assertEquals("", -1, test8.findLowestCommonAncestor(1, 2));
		assertEquals("", -1, test8.findLowestCommonAncestor(0, 3));
		assertEquals("", -1, test8.findLowestCommonAncestor(1, 3));

	}
	
	@Test
	public void LCATest(){
		DAG test9 = new DAG(10);

		//--------2---5----7--
		//---0--1-------6----8
		//--------3---4-------
		test9.addEdge(0, 1);
		test9.addEdge(1, 2);
		test9.addEdge(1, 3);
		test9.addEdge(2, 5);
		test9.addEdge(3, 4);
		test9.addEdge(4, 6);
		test9.addEdge(5, 6);
		test9.addEdge(6, 8);
		test9.addEdge(5, 7);
		test9.addEdge(7, 8);
		test9.addEdge(8, 9);

		assertEquals("Finding LCA for 4 and 5", 1, test9.findLowestCommonAncestor(5, 4));
		assertEquals("Finding LCA for 7 and 8", 7, test9.findLowestCommonAncestor(8, 7));
		assertEquals("Finding LCA for 6 and 8", 6, test9.findLowestCommonAncestor(6, 8));
		assertEquals("Special case where both parameters are same vertex", 2, test9.findLowestCommonAncestor(2,2));
	}
	
	@Test(expected=Exception.class)
	public void exceptionTest(){
		//Cannot make a directed graph with less than 0 vertices
		DAG test10 = new DAG(-5);
	}

}