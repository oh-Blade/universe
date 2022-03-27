package com.huohou.universe.algorithm;

/**
 * @Description 53题
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author naikuo
 * @Date 2020/2/3 11:34 AM
 */
public class MaxSubArray53 {

    /**
     * 每一个数据都有两个选择，与前面相连或者自己另立门户！
     * 所以状态转移方程就是这个 dp[i] = Math.max(dp[i - 1] + nums[i],nums[i]);
     *
     * 作者：yi-dai-mi-kang-ji-lou
     * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci/solution/chao-ji-jian-dan-de-jie-fa-by-yi-dai-mi-kang-ji-lo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int currentMax = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            sum = Math.max(currentMax, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
