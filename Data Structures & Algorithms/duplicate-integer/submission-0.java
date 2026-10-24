class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int seen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && seen == nums[i])
                return true;
            seen = nums[i];
        }
        return false;
    }
}