/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

/*
思路：和3Sum思路一致，区别在于不需要考虑重复数字的情况，以及Math.abs()的使用。
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0; i < nums.length - 2; i++){
            int low = i+1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
                if(sum > target){
                    high--;
                }else{
                    low++;
                }                
            }
        }
        return result;
    }
}


