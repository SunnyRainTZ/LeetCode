/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if 
it were inserted in order.You may assume no duplicates in the array.
Example 1:
  Input: [1,3,5,6], 5
  Output: 2
Example 2:
  Input: [1,3,5,6], 2
  Output: 1
Example 3:
  Input: [1,3,5,6], 7
  Output: 4
Example 1:
  Input: [1,3,5,6], 0
  Output: 0
*/

思路：由于数组已经有序，因而使用二分法进行搜索更快。
O(n):
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        for(; i<nums.length ; i++){
            if(target <= nums[i]){
                return i;
            }
        }
        return i;
    }
}

O(logn):
public int searchInsert(int[] A, int target) {
    int low = 0, high = A.length-1;
    while(low<=high){
        int mid = (low+high)/2;
        if(A[mid] == target) return mid;
        else if(A[mid] > target) high = mid-1;
        else low = mid+1;
    }
    return low;
}
改进：mid = (high - low)/2 + low;  可以避免(high + low)太大时的溢出问题。
