/*
 *
 *  @author: David Berry (berryd1)
 *  @dateOfSubmission: October 2019 
 *  
*/
import static org.junit.Assert.*;

import org.junit.Test;

public class LCATests {
	
	@Test 
	public void treeEmptyTest(){
		LCA emptyTree = new LCA();
		assertEquals("Find LCA when tree is empty: ",-1,emptyTree.findLowestCommonAncestor(0, 0));
	}
	
	@Test
	public void nodeConstructorTest(){
		
		Node nodeConstruct = new Node(1);
		assertNotNull("Node constructor being tested: ", nodeConstruct);
	}
	
	@Test
	public void twoNodesLowestCommonAncestorTest()
	{
		LCA ancestorTest = new LCA();
		ancestorTest.root = new Node(1);
		ancestorTest.root.left = new Node(2);
		ancestorTest.root.right = new Node(3);
		ancestorTest.root.left.left = new Node(4);
		ancestorTest.root.left.right = new Node(5);
		ancestorTest.root.right.left = new Node(6);
        	ancestorTest.root.right.right = new Node(7);
        
        assertEquals("LCA of 4 and 5: ",2,ancestorTest.findLowestCommonAncestor(4, 5));
        assertEquals("LCA of 6 and 7: ",3,ancestorTest.findLowestCommonAncestor(6, 7));
        assertEquals("LCA of 2 and 5: ",2,ancestorTest.findLowestCommonAncestor(2, 5));
        assertEquals("LCA of 1 and 7: ",1,ancestorTest.findLowestCommonAncestor(1, 7));
        assertEquals("LCA of 1 and 6: ",1,ancestorTest.findLowestCommonAncestor(1, 6));
        
	}
	
	@Test 
	public void unevenTreeTest () { 
		LCA unevenTest = new LCA();
		unevenTest.root = new Node(1);
		unevenTest.root.right = new Node(2);
		unevenTest.root.right.right = new Node(3);
		
		assertEquals("Uneven tree with three nodes: ", 2, unevenTest.findLowestCommonAncestor(2,3));	
		assertEquals("Uneven tree with three nodes: ", 1, unevenTest.findLowestCommonAncestor(3, 1));
	}
	
	@Test
	public void nonExistingNodesTest()
	{
		LCA existanceTest = new LCA();
		existanceTest.root = new Node(1);
		existanceTest.root.left = new Node(2);
		existanceTest.root.right = new Node(3);
		existanceTest.root.left.left = new Node(4);
		existanceTest.root.left.right = new Node(5);
		existanceTest.root.right.left = new Node(6);
		existanceTest.root.right.right = new Node(7);
		
		assertEquals("LCA of 6 and 7: ", 3, existanceTest.findLowestCommonAncestor(6,7));
		assertEquals("LCA of 2 and 16: ", -1, existanceTest.findLowestCommonAncestor(2,16));
		assertEquals("LCA of 8 and 12: ", -1, existanceTest.findLowestCommonAncestor(8,12));
		
	}
	
	@Test
	public void allSameNodeTest() {
		LCA sameTest = new LCA();
		sameTest.root = new Node(3);
		sameTest.root.left = new Node(3);
		sameTest.root.right = new Node(3);
		sameTest.root.left.left = new Node(3);
		sameTest.root.left.right = new Node(3);
		
		assertEquals("LCA of 3 and 3: ",3,sameTest.findLowestCommonAncestor(3, 3));
	}
	
	@Test
	public void treeSize1Test(){
		LCA treeSizeTest = new LCA();
		treeSizeTest.root = new Node(1);
		assertEquals("LCA of 1 and 0: ",-1,treeSizeTest.findLowestCommonAncestor(1, 0));
		
	}

	
}
