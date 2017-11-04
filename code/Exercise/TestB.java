class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

 public  class TestB {
    // public int diameterOfBinaryTree(TreeNode root) {
    //     if(root == null) return 0;
    //     int sum = 0;
    //     if(root != null){
    //         int leftLen = diameterOfBinaryTree(root.left);
    //         int rightLen = diameterOfBinaryTree(root.right);
    //         if(root.left == null && root.right != null){
    //             sum = sum + rightLen + 1;
    //         }else if(root.left != null && root.right == null){
    //             sum = sum + leftLen + 1;
    //         }else if(root.left != null && root.right != null){
    //             sum = sum + rightLen + leftLen + 2;
    //         }else{
    //             sum = sum;
    //         }
    //         System.out.println("left = " + leftLen);
    //         System.out.println("right = " + rightLen);
    //         System.out.println("sum = " + sum);
    //     }
    //     return sum;
    // }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        int ll = 0;
        int lr = 0;
        int rl = 0;
        int rr = 0;
        int l = 0;
        int r = 0;
        int llk = 0;
        int lrk = 0;
        int rlk = 0;
        int rrk = 0;
        if(root.left != null){
        	l = 1;
        	if(root.left.left != null) llk = 1;
        	if(root.left.right != null) lrk = 1;
            ll = diameterOfBinaryTree(root.left.left);
            lr = diameterOfBinaryTree(root.left.right);
        }else{
        	l = 0;
            ll = 0;
            lr = 0;
        }
        if(root.right != null){
        	r = 1;
        	if(root.right.left != null) rlk = 1;
        	if(root.right.right != null) rrk = 1;
            rl = diameterOfBinaryTree(root.right.left);
            rr = diameterOfBinaryTree(root.right.right);
        }else{
        	r = 0;
            rl = 0;
            rr = 0;
        }
        if((ll + lr + llk + lrk) > sum) sum = ll + lr + llk + lrk;
        if((rl + rr + rlk + rrk) > sum) sum = rl + rr + rlk + rrk;
        if((ll + rl + l + r + llk + rlk) > sum) sum = ll + rl + l + r + llk + rlk;
        if((ll + rr + l + r + llk + rrk) > sum) sum = ll + rr + l + r + llk + rrk;
        if((lr + rl + l + r + lrk + rlk) > sum) sum = lr + rl + l + r + lrk + rlk;
        if((lr + rr + l + r + lrk + rrk) > sum) sum = lr + rr + l + r + lrk + rrk;

        System.out.println("l=" + l + "," + "r=" + r + "," + "ll=" + ll + "," + "lr=" + lr + "," + "rl=" + rl + "," + "rr=" + rr);
        System.out.println(root.val + " " + sum);
        return sum;
    }

    public static void main(String[] args){
    	// TreeNode t1 = new TreeNode(1);
    	// TreeNode t2 = new TreeNode(2);
    	// TreeNode t3 = new TreeNode(3);
    	// TreeNode t4 = new TreeNode(4);
    	// TreeNode t5 = new TreeNode(5);
    	// TreeNode t6 = new TreeNode(6);
    	// TreeNode t7 = new TreeNode(7);
    	// t2.left = t4;
    	// t2.right = t5;
    	// t3.left = t6;
    	// t3.right = t7;
    	// t1.left = t2;
    	// t1.right = t3;

    	TreeNode t1 = new TreeNode(1);
    	TreeNode t2 = new TreeNode(2);
    	TreeNode t3 = new TreeNode(3);
    	TreeNode t4 = new TreeNode(4);
    	TreeNode t5 = new TreeNode(5);
    	t3.left = t4;
    	t3.right = t5;
    	t2.left = t3;
    	t1.left = t2;
    	TestB t = new TestB();
    	int sum = t.diameterOfBinaryTree(t1);
    }
}