package src;

/**
 * Design a number container system that can do the following:
 *
 * Insert or Replace a number at the given index in the system.
 * Return the smallest index for the given number in the system.
 * Implement the NumberContainers class:
 *
 * NumberContainers() Initializes the number container system.
 * void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
 * int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.
 *
 *
 * Example 1:
 *
 * Input
 * ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
 * [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
 * Output
 * [null, -1, null, null, null, null, 1, null, 2]
 *
 * Explanation
 * NumberContainers nc = new NumberContainers();
 * nc.find(10); // There is no index that is filled with number 10. Therefore, we return -1.
 * nc.change(2, 10); // Your container at index 2 will be filled with number 10.
 * nc.change(1, 10); // Your container at index 1 will be filled with number 10.
 * nc.change(3, 10); // Your container at index 3 will be filled with number 10.
 * nc.change(5, 10); // Your container at index 5 will be filled with number 10.
 * nc.find(10); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
 * nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
 * nc.find(10); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
 *
 *
 * Constraints:
 *
 * 1 <= index, number <= 109
 * At most 105 calls will be made in total to change and find.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L2349_DesignANumberContainerSystem {
    Map<Integer, PriorityQueue<Integer>> map1; // here number is used as key and priority queue as value, priority queue contains all those index where that particular number is
    Map<Integer, Integer> map2; // this is used to at what index, which number is available, so in future if at the same index any other number comes, then
    // with help of map2 we can access that number in map1 and remove that index from the respective priority queue. doing this no two number will be at one index

    public L2349_DesignANumberContainerSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void change(int index, int number) {
        if(!map1.containsKey(number)){
            map1.put(number, new PriorityQueue<>());
        }

        map1.get(number).add(index);
        if(map2.containsKey(index)){
            map1.get(map2.get(index)).remove(index);
        }

        map2.put(index, number);
    }

    public int find(int number) {
        if(map1.containsKey(number)){
            Integer a = map1.get(number).peek();
            return a != null?a:-1;
        }
        return -1;
    }
}
