package src;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to
 * any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has
 * its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point
 * to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding
 * two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val,
 * random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node. Your code will only be given the head of the original linked list.
 *
 * Example 1:
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */

import java.util.HashMap;

public class L138_CopyListWithRandomPointer {
    private static class Node{
        int val;
        Node next;
        Node random;

        Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        HashMap<Integer, Integer> map = mapping(head);
        Node headRes = creatingList(head);
        fillingRandom(headRes, map);
        return headRes;
    }

    // this method is used to map, which node is connected with the random pointer of all node
    // mapping is based on index
    public HashMap<Integer,Integer> mapping(Node head){
        HashMap<Integer, Integer> map = new HashMap<>();

        Node curr = head;
        int i1 = 0;
        while(curr != null){
            if(curr.random == null){
                map.put(i1,-1);
                i1++;
                curr = curr.next;
                continue;
            }
            Node temp = head;
            int i2 = 0;
            while(temp != null){
                if(curr.random == temp){
                    map.put(i1,i2);
                    break;
                }
                i2++;
                temp = temp.next;
            }
            i1++;
            curr = curr.next;
        }
        return map;
    }

    // creating the List, random pointer as null
    public Node creatingList(Node head){
        Node headRes = null;
        Node curr1 = head;
        Node curr2 = null;

        while(curr1 != null){
            if(headRes == null){
                headRes = new Node(curr1.val);
                curr2 = headRes;
                curr1 = curr1.next;
                continue;
            }

            curr2.next = new Node(curr1.val);
            curr2 = curr2.next;
            curr1 = curr1.next;
        }

        return headRes;
    }

    // filling all the pointer of newly made list using map
    public void fillingRandom(Node head, HashMap<Integer, Integer> map){
        Node curr = head;

        int i1 = 0;
        while(curr != null){
            int i2 = map.get(i1);

            if(i2 != -1){
                Node temp = head;
                while(i2>0){
                    temp = temp.next;
                    i2--;
                }
                curr.random = temp;
            }

            i1++;
            curr = curr.next;
        }
    }
}
