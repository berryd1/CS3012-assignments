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

	
}
