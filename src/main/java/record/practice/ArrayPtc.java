package record.practice;

import record.practice.common.STATE;

import java.util.List;

/**
 * @author mqw
 * @create 2020-05-15-14:12
 */
public interface ArrayPtc {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，
     * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 思路：
     *  1：两层循环
     *  2：hash表存储值对应的下标
     *  3：排序后 前后两个指针移动
     *
     * @param nums
     * @param target
     * @return
     */
    default int[] twoSum(int[] nums, int target){
        throw exp(STATE.NONE.toString());
    }


    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 思路：
     *  1：三层循环
     *  2：转换为上面的两数之和
     *      2.1：找出第一个负数后，剩下数中找相加和为前面负数的正数
     *
     * @param nums
     * @return
     */
    default List<List<Integer>> threeSum(int[] nums) {
        throw exp(STATE.NONE.toString());
    }






    default void error(String msg) {
        throw new RuntimeException(msg);
    }

    default RuntimeException exp(String msg){
        return new RuntimeException(msg);
    }

}
