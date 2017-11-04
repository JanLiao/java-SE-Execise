class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution3 {
    private int sum;
    private int tmp;
    
    public int sumTree(TreeNode root){
        int s = 0;
        if(root.left == null && root.right == null) return (s + root.val);
        if(root.left != null) s = s + sumTree(root.left);
        if(root.right != null) s = s + sumTree(root.right);
        s = s + root.val;
        return s;
    }
    
    public void newBST(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            System.out.println("========");
            System.out.println(sum);
            int tmp = root.val;
            root.val = sum;
            sum = sum - tmp;
            System.out.println(sum);
            System.out.println("==========");
        }
        if(root.left != null) {
            System.out.println("%%%%%%%%%%%%%%%%");
            System.out.println(sum);
            newBST(root.left, sum);
            System.out.println(sum);
            System.out.println("%%%%%%%%%%%%%%%%%%%");
        }
        System.out.println("----------");
        System.out.println(sum);
        int tmp = root.val;
        System.out.println(tmp);
        root.val = sum;
        sum = sum - tmp;
        System.out.println(sum);
        System.out.println("-----------");
        if(root.right != null){
            System.out.println("!!!!!!!!!!!!!!!");
            System.out.println(sum);
            newBST(root.right, sum);
            System.out.println(sum);
            System.out.println("!!!!!!!!!!!!!!!");
        }
    }
    
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        sum = sumTree(root);
        System.out.println(sum);
        if(root.left == null && root.right == null){
            tmp = root.val;
            root.val = sum;
            sum = sum - tmp;
        }
        if(root.left != null){
            convertBST(root.left);
        }
        tmp = root.val;
        root.val = sum;
        sum = sum - tmp;
        if(root.right != null){
            convertBST(root.right);
        }
        return root; 
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(13);
        t1.left = t2;
        t1.right = t3;
        Solution3 s = new Solution3();
        TreeNode t = s.convertBST(t1);
        System.out.println(t.val);
        System.out.println(t.left.val);
        System.out.println(t.right.val);
    }
}