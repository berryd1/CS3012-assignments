import static org.junit.Assert.*;

import org.junit.Test;

public class LCATests {
	
	@Test 
	public void treeEmptyTest(){
		LCA emptyTree = new LCA();
		assertEquals("LCA is empty: ",-1,emptyTree.findLowestCommonAncestor(0, 0));
	}
	
	
}
