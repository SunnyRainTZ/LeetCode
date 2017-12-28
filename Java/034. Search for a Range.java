/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
  Given [5, 7, 7, 8, 8, 10] and target value 8,
  return [3, 4].
*/

/*
思路：首先二分查找左边的点，如果找到target，判断(mid == 0 || nums[mid-1] < nums[mid])是否成立（mid等于0时直接判真，不会出现数组越界)。
如果没找到左边的点，即代表数组中没有target，此时返回{-1，-1}。如果找到了左边的点，那么一定存在右边的点。此时让low=mid，然后在左边的点的
右边去二分查找右边的点，如果找到target，判断(mid == nums.length-1 || nums[mid+1] > nums[mid])是否成立。最终返回result。
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int[] result = {-1,-1};
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    result[0] = mid;
                    break;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(result[0] == -1){
            return result;
        }
        low = mid;
        high = nums.length - 1;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] > nums[mid]){
                    result[1] = mid;
                    break;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}



