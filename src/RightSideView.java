/**
 * @Classname RightSideView
 * @Description TODO
 * @DATE 2019/11/3 10:56
 * @Created by Administrator
 */
public class RightSideView {
    public boolean isBalanced(TreeNode root) {
return true;
    }



    public boolean isLast(TreeNode node){
        if(node.left ==null&&node.right==null){
            return true;
        }else{
            return false;
        }

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
