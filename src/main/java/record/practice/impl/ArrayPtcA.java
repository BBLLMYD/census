package record.practice.impl;

import record.practice.ArrayPtc;

import java.util.List;

/**
 * @author mqw
 * @create 2020-05-15-14:25
 */
public class ArrayPtcA implements ArrayPtc {

    // 时间复杂度：O(n^2)
    @Override
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == target - nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    @Override
    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }
}
