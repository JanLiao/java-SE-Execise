
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class TestNode{
	public void findTilt(TreeNode root) {
        sumNode(root);
        printNode(root);
        System.out.println(sumNodeTilt(root));
    }
    
    public void sumNode(TreeNode root){
        if(root == null) return ;
        sumNode(root.left);
        sumNode(root.right);
        if(root.left != null && root.right != null){
            root.val = root.val + root.left.val + root.right.val;
        }else if(root.left != null && root.right == null){
            root.val = root.val + root.left.val;
        }else if(root.left == null && root.right != null){
            root.val = root.val + root.right.val;
        }
    }

    public void printNode(TreeNode root){
    	if(root != null){
    		System.out.println(root.val);
    		printNode(root.left);
    		printNode(root.right);
    	}
    }

    public int sumNodeTilt(TreeNode root){
        int sum = 0;
        if(root == null) return 0;
        int left = sumNodeTilt(root.left);
        int right = sumNodeTilt(root.right);
        if(root.left == null && root.right == null) {
            sum = 0;
        }
        if(root.left == null && root.right != null){
            if(root.right.val > 0){
                sum = sum + root.right.val;
            }else{
                sum = sum - root.right.val;
            }
        }
        if(root.left != null && root.right == null){
            if(root.left.val > 0){
                sum = sum + root.left.val;
            }else{
                sum = sum - root.left.val;
            }
        }
        if(root.left != null && root.right != null){
            if(root.left.val > root.right.val){
                sum = sum + root.left.val - root.right.val;
            }else {
                sum = sum + root.right.val - root.left.val;
            }
        }
        System.out.println("(" + root.val + "," + left + "," + right + ")");
        return sum + left + right;
    }

    public static void main(String[] args){
    	// TreeNode t1 = new TreeNode(1);
    	// TreeNode t2 = new TreeNode(2);
    	// TreeNode t3 = new TreeNode(3);
    	// TreeNode t4 = new TreeNode(4);
    	// TreeNode t5 = new TreeNode(5);
    	// TreeNode t6 = new TreeNode(6);
    	// TreeNode t7 = new TreeNode(7);
    	// t3.left = t5;
    	// t3.right = t6;
    	// t4.right = t7;
    	// t2.left = t4;
    	// t1.left = t2;
    	// t1.right = t3;

    	TreeNode t1 = new TreeNode(-8);
    	TreeNode t2 = new TreeNode(3);
    	TreeNode t3 = new TreeNode(0);
    	TreeNode t4 = new TreeNode(-8);
    	TreeNode t5 = new TreeNode(-1);
    	TreeNode t6 = new TreeNode(8);
    	t5.right = t6;
    	t4.right = t5;
    	t2.left = t4;
    	t1.left = t2;
    	t1.right = t3;
    	
    	TestNode tn = new TestNode();
    	tn.findTilt(t1);
    }
}
