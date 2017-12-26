/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
  1,2,3 → 1,3,2
  3,2,1 → 1,2,3
  1,1,5 → 1,5,1
*/

/*
思路：从右向左找第一个数值变小的地方，然后将该处数值和它后面比它大的数中的最小值（min{x|x>target}）进行交换，然后将该数后面的数字首尾交换。
例子：135432
第一个循环：从右向左找到第一个数值变小的地方：1右边的3
第二个循环：在3后面的数中找到比它大的数的最小值：4（3右边的数是递减的），交换两个数，此时变为：145332
第三个循环：4后面的数依旧是递减的，此时首尾交换来得到最小值，交换完后变为：142335
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int cursor = -1;
        int cursorNum = -1;
        for(int i = nums.length-1 ; i > 0 ; i--){
            if(nums[i-1] < nums[i]){
                cursor = i-1;
                cursorNum = nums[i-1];
                break;
            }
        }
        if(cursor != -1){
            for(int i = nums.length-1 ; i > 0 ; i--){
               if(nums[i] > cursorNum) {
                   swap(i,cursor,nums);
                   break;
               }
            }
        }
        int low = cursor + 1;
        int high = nums.length - 1;
        while(low < high){
            swap(low,high,nums);
            low++;
            high--;
        }
    }
    
    public void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}




