package src;

public class L1457_PseudoPalindromicPathsInABinaryTree {
    public int pseudoPalindromicPaths (TreeNode root) {
        recursion(root);
        return count;
    }
    int[] arr = new int[10];
    int count = 0;
    public void recursion(TreeNode root){ // this is a normal dfs with the check of each combination that whether it have a palindromic permutation or not
        if(root == null){
            return;
        }
        arr[root.val]++;
        if(root.left == null && root.right == null){
            count += palindrome()?1:0;
            arr[root.val]--;
            return;
        }

        recursion(root.left);
        recursion(root.right);
        arr[root.val]--;
    }

    public boolean palindrome(){ // this is to check whether a given sequence can have a palindromic permutation or not
        boolean check = false;

        for(int i: arr){
            if(check && i%2 != 0){
                return false;
            }

            if(i%2 != 0){
                check = true;
            }
        }

        return true;
    }
}
