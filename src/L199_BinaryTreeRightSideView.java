package src;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class L199_BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        recursion(root,1); // we are assuming our tree is starting from level 1
        return list;
    }

    /*
    Intuition ->
    we know there will be as many node while viewing from right side, as many levels we have
    so, we will traverse al the right sided node first and keep them in the list,
    then we will backtrack to go in left subtree to check that do we have any number of nodes more than the list size, if yes we will add the right sided node of
    that level in the list and make the list of size equal to number of level
     */
    List<Integer> list = new ArrayList<>();
    public void recursion(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(level > list.size()){ // whenever the size of list is greater than list size then we will add that particular node
            list.add(root.val);
        }

        recursion(root.right, level+1); // so firstly we will go in right as we have to cover the right side view
        recursion(root.left, level+1); // then left, if for any left node level is greater than list size,
        // it means viewing from right side this particular node will get view.
    }
}
