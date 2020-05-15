package record.practice.impl;

import record.practice.ArrayPtc;
import record.practice.common.Printer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mqw
 * @create 2020-05-15-14:25
 */
public class ArrayPtcC implements ArrayPtc {

    // 两遍哈希表 O(n)
    // 保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num) && !map.get(num).equals(i)){
                return new int[]{i,map.get(num)};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("none");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = new ArrayPtcC().twoSum(nums, target);
        Printer.print(ints);
    }
}
