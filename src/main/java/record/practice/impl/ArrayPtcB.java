package record.practice.impl;

import record.practice.ArrayPtc;
import record.practice.common.STATE;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mqw
 * @create 2020-05-15-14:25
 */
public class ArrayPtcB implements ArrayPtc {

    // 两遍哈希表 O(n)
    // 保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num) && !map.get(num).equals(i)){
                return new int[]{i,map.get(num)};
            }
        }
        throw new RuntimeException("none");
    }
}
