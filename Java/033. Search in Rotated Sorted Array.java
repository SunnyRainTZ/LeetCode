/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/

/*
思路：二分查找。当nums[low]<=nums[middle]时，代表转点在middle右侧，此时左侧的数为递增的，如果target在[nums[low],nums[middle])范围内，
则在该范围内查找。如果不在，则在右侧范围内查找。当nums[low]>nums[middle]时，代表转点在middle左侧，此时右侧的数为递增的，
如果target在(nums[middle],nums[high]]范围内，则在该范围内查找。如果不在，则在左侧范围内查找。
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int middle = (low + high)/2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[low] <= nums[middle]){
                if(target < nums[middle] && target >= nums[low]){
                    high = middle - 1;
                }else{
                    low = middle + 1;
                }
            }else{
                if(target > nums[middle] && target <= nums[high]){
                    low = middle + 1;
                }else{
                    high = middle - 1;
                }
            }
        }
        return nums[low] == target ? low : -1;
    }
}


