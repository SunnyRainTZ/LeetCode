/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


解法1：
  相对暴力简洁, HashMap<value, index>，找到一个value, 存一个; 若在HashMap里面 match 到结果, 就return HashMap里存的index. 
  时间复杂度：O(n)
  空间复杂度：O(n)
  核心：利用hash table将查询时间由O(n)降至O(1)




class Solution {
    public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < numbers.length; i++) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i;
            result[0] = map.get(target - numbers[i]);
            return result;
        }
        map.put(numbers[i], i);
    }
    return result;
    }
}
