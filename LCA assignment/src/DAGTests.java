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

}