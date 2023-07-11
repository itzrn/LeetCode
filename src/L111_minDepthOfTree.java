package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Constraints:
 *     The number of nodes in the tree is in the range [0, 105].
 *     -1000 <= Node.val <= 1000
 */
class Node{
    int data;
    Node right;
    Node left;

    Node(int data){
        this.data = data;
        right = null;
        left = null;
    }
}


public class L111_minDepthOfTree {
    /*
    here we have 4 possibility
    right and left node of a parent node is present
    right and left node of a parent node is not present
       The above two situation we have to move by taking min depth of right and left
    either right or left node of a parent node is present ---> this situation is tricky
       In the above situation, means the current node is not leaf node means 1 depth get increase,
       at this point we have not to find the minimum, but we have to move as normal dfs
     */
    public int minDepthUsingDFS(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return  1 + minDepthUsingDFS(root.right);
        }else if (root.right == null){
            return 1+ minDepthUsingDFS(root.left);
        }
        return 1 + Math.min(minDepthUsingDFS(root.left), minDepthUsingDFS(root.right)); // this is dfs with taking min of right and left(without above if else condition)
    }

    public int minDepthUsingBFS(Node root){
        if(root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty()){//this loop is iterating till the queue won't get empty
            int q = queue.size();
            while (q>0){// this loop is iterating equal to the number of nodes present in every level
                Node node = queue.remove();
                if(node.right == null && node.left == null) {
                    return i;
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                q--;
            }
            i++;
        }
        return  i;
    }
}
