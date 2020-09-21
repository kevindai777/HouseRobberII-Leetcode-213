//Java Solution

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] start = new int[nums.length];
        start[0] = nums[0];
        
        int[] end = new int[nums.length];
        end[0] = 0;
        end[1] = nums[1];
        
        for (int i = 1; i < nums.length - 1; i++) {
            start[i] = (i >= 2) ? Math.max(start[i - 1], start[i - 2] + nums[i]) : Math.max(start[i - 1], nums[i]);
        }
        
        for (int i = 2; i < nums.length; i++) {
            end[i] = Math.max(end[i - 1], end[i - 2] + nums[i]);
        }
        
        return Math.max(start[start.length - 2], end[end.length - 1]);
    }
}