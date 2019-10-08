import java.util.ArrayList;
import java.util.List;

class Node { 
    int data; 
    Node left, right; 
  
    Node(int value) { 
        data = value; 
        left = right = null; 
    } 
} 

public class LCA {
	
	Node root;
    private List<Integer> path1 = new ArrayList<Integer>();
    private List<Integer> path2 = new ArrayList<Integer>();
 
    int findLowestCommonAncestor(int node1, int node2) {
        path1.clear();
        path2.clear();
        return findLCA(root, node1, node2);
    }
 
    private int findLCA(Node root, int node1, int node2) {
 
        if (!pathFinder(root, node1, path1) || !pathFinder(root, node2, path2)) {
            return -1;
        }
 
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
 
        return path1.get(i-1);
    }
 
    private boolean pathFinder(Node root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }
 
        path.add(root.data);
 
        if (root.data == n) {
            return true;
        }
 
        if (root.left != null && pathFinder(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && pathFinder(root.right, n, path)) {
            return true;
        }
 
        path.remove(path.size()-1);
 
        return false;
    }
 


}
