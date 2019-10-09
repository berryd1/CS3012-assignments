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
	
}
