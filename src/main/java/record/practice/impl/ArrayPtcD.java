package record.practice.impl;

import record.practice.ArrayPtc;
import record.practice.common.Printer;

import java.util.*;

/**
 * @author mqw
 * @create 2020-05-15-14:25
 */
public class ArrayPtcD implements ArrayPtc {


    /**
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target,int targetIndex) {
        Arrays.sort(nums);
        int first = 0;
        int end = nums.length-1;
        int m = nums[first];
        int n = nums[end];
        int sum = m + n;
        while((sum) != target){
            if(end < first || end == first){
                throw new RuntimeException();
            }
            if(sum > target) {
                end--;
            }else {
                first++;
            }
            if(targetIndex == first || targetIndex == end){
                continue;
            }
//            if(targetIndex!=0 && nums[targetIndex] == nums[targetIndex-1]){
//                continue;
//            }
            m = nums[first];
            n = nums[end];
            sum = m +n;
        }
        // return new int[]{first,end}; //这个是返回下标
        return new int[]{n,m};
    }

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num < 0){
                List<Integer> integers = new ArrayList<>();
                target = num;
                try {
                    int[] ints = twoSum(nums, -target,i);
                    integers.add(target);
                    integers.add(ints[0]);
                    integers.add(ints[1]);
                    result.add(integers);
                }catch (Exception e){
                    continue;
                }
            }else {
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        int[] ints = new ArrayPtcD().twoSum(nums, target);
//        Printer.print(ints);

        int[] nums = {-1, 0, 1, 2, -1, -4};
        // -4 -1 -1 0 1 2
        List<List<Integer>> lists = new ArrayPtcD().threeSum(nums);
        System.out.println(lists);
    }
}
