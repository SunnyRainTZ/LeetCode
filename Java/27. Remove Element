/*
Given an array and a value, remove all instances of that value in-place and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

思路：遇到和val相同的值和末尾元素互换位置，因为交换的值也可能等于val，所以只当换回来的值不等于val时i才加一

class Solution {
    public int removeElement(int[] nums, int val) {
        int num = 0;
        for(int i=0 ;i<nums.length - num;){
            if(nums[i] == val){
                int temp = nums[nums.length - num - 1];
                nums[nums.length - num - 1] = val;
                nums[i] = temp;
                num++;
            }
            if(nums[i] != val){
                i++;
            }  
        }
        return nums.length - num;
    }
}

简短的代码：

int removeElement(int A[], int n, int elem) {
    int begin=0;
    for(int i=0;i<n;i++) 
        if(A[i]!=elem) 
            A[begin++]=A[i];
    return begin;
}





