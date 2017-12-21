/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],
  A solution set is:
  [
    [-1, 0, 1],
    [-1, -1, 2]
  ]
*/

/*
思路：首先对nums排序，然后遍历每个数到倒数第三个数，在nums[i]右边寻找和为(0 - nums[i])的两个数。
由于数组有序，所以low和high向中间收缩只需要O(n)的时间复杂度。
注意重复数字的处理：
1、对外层循环：如果当前数和前一个已经处理过的数相同，则不用处理，直接跳过。
2、内层循环：如果一个方案已经添加到结果里面，则可跳过low右边、high左边的相同的数字。
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        //只遍历到倒数第3个数，给后两个加数留位置
        for(int i=0 ; i<nums.length - 2 ; i++){
            //处理重复数字
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int low = i+1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        //处理重复数字
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;                        
                    }else if(nums[low] + nums[high] > sum){
                        high--;
                    }else{
                        low++;
                    }
                }
            }            
        }
        return result;
    }
}
