package src;

import java.util.LinkedList;
import java.util.List;

public class L863_AllNodesAtDistanceK {
    List<Integer> list = new LinkedList<>(); // this list is storing all the value at the distance k from the target node
    public void afterGettingNode(TreeNode node, int k){
        /*
        this fun taking a node and k, means it will search all the nodes at the distance k from the target node
         */
        if(node == null || k < 0){
            return;
        }else if(k == 0){
            list.add(node.val);
            return;
        }
        afterGettingNode(node.left,k-1);
        afterGettingNode(node.right,k-1);
    }
    boolean check = false; // check is used to make notify that the target node got ot not
    public int distanceAtK(TreeNode root, TreeNode target, int k){
        /*
        this fun work as simple dfs before getting the target node,
        as the target node get searched, check become true
        and starts to backtrack to ancestor and return integer temp which means while back tracking it reached
        k-temp distance closer to the node which is at kth distance form the target node
         */
        if(root == null){
            return 0; // returning zero means we didn't get teh target node
        }
        if(root == target){
            check = true;
            afterGettingNode(root,k);
            return 1;
        }
        int temp = distanceAtK(root.left,target,k); // temp is usd to calculate the distance covered towards kth node from the target node
        if (check){ // compiler can only enter here if and only if we got the target node
            k = k - temp;
            if (k == 0){
                list.add(root.val);
                return temp+1;
            }
            afterGettingNode(root.right,k-1);
            return temp+1;
        }
        temp = distanceAtK(root.right,target,k);
        if(check){// compiler can only enter here if and only if we got the target node
            k = k - temp;
            if (k == 0){
                list.add(root.val);
                return temp+1;
            }
            afterGettingNode(root.left,k-1);
            return temp+1;
        }
        return 0; // returning zero means I didn't get teh target node, so until and unless I won,t get the target node, I didn't cover any distance from the target
        //node, so returning zero, and It's obvious after getting target node only we can calculate how much distance covered
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        int a = distanceAtK(root, target, k);
        return list;
    }
}
