public class Solution45 {

    /*
        You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

        0 <= j <= nums[i] and
        i + j < n
        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        Example 2:

        Input: nums = [2,3,0,1,4]
        Output: 2


        Constraints:

        1 <= nums.length <= 104
        0 <= nums[i] <= 1000
        It's guaranteed that you can reach nums[n - 1].
     */

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int far = 0;
        int[] reachSteps = new int[nums.length];
        reachSteps[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > far) return -1;
            if (i + nums[i] <= far) continue;
            if (i + nums[i] >= nums.length - 1) return reachSteps[i] + 1;
            for (int j = far + 1; j <= i + nums[i]; j++) {
                reachSteps[j] = reachSteps[i] + 1;
            }
            far = i + nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution45 solution = new Solution45();
        int[] steps = new int[]{2,3,0,1,4};
//        int[] steps = new int[]{2,3,1,1,4};
//        int[] steps = new int[]{1,1,0,1};
        System.out.println(solution.jump(steps));
    }

}
