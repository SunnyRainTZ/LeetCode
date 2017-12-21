/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2.
*/

/*
思路：low指向最左边，high指向最右边，二者向内收缩。假设height[i]的值为长方形的宽，坐标之间的差值为长方形的长。有以下两种情况：
1、low处的边比high处的低：这种情况下可以忽略以low为左边的边，以任何一个坐标小于high的边为右边的情况。因为height[low] < height[high]，如果high左边
的边比high低，则面积显然比原来小。high左边的边如果比high对应的边高，那么也比low对应的边高，此时计算长方形面积时宽仍是height[low]，但是长的长度比原来
小，因而面积也小于原来的面积。此时low右移，不必再计算(low,high-1),(low,high-2)...(low,low+1)这些情况的面积。
2、high处的边比low处的低：原理同上。此时high左移，不必再计算(low+1,high),(low+2,high),...,(high-1,high)这些情况的面积。
*/

class Solution {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;
        while(high > low){
            maxArea = Math.max(maxArea,Math.min(height[high],height[low]) * (high - low));
            if(height[low] <= height[high]){
                low++;
            }else{
                high--;
            }
        }
        return maxArea;
    }
}
