class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Binary{

	private int flag;
	private int sum;

	public void setFlag(int flag){
		this.flag = flag;
	}

	public int sumTree(TreeNode root){
		int s = 0;
		if(root.left == null && root.right == null) return (s + root.val);
		if(root.left != null) s = s + sumTree(root.left);
		if(root.right != null) s = s + sumTree(root.right);
		s = s + root.val;
		return s;
	}

	public TreeNode convertBST(TreeNode root) {
		if(flag == 0){
			sum = sumTree(root);
			flag = 1;
		}
		if(root.left == null && root.right == null) {
			int tmp = root.val;
			root.val = sum;
			sum = sum - tmp;
			System.out.println(sum);
			return root;
		}

		if(root.left != null){
			return convertBST(root.left);
		} 
		int tmp = root.val;
		root.val = sum;
		sum = sum - tmp;
		if(root.right != null){
			return convertBST(root.right);
		} 
		return root;
	}

	public static void main(String[] args){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(13);
        t1.left = t2;
        t1.right = t3;
        Binary s = new Binary();
        s.setFlag(0);
        TreeNode t = s.convertBST(t1);
        System.out.println(t.val);
        System.out.println(t.left.val);
        System.out.println(t.right.val);
    }
}