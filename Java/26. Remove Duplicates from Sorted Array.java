/*
Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
Example:
  Given nums = [1,1,2],
  Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
  It doesn't matter what you leave beyond the new length.
*/

思路：i是快跑者，repeatIndex是慢跑者


class Solution {
    public int removeDuplicates(int[] nums) {
        int currentNum = 0;
        int repeatIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                currentNum = nums[0];
                repeatIndex++;
            }else{
                if(nums[i] != currentNum){
                    nums[repeatIndex] = nums[i];
                    repeatIndex++;
                    currentNum = nums[i];
                }
            }
        }
        return repeatIndex;
    }
}
