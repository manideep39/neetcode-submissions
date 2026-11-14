class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] numsIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numsIndex[i][0] = nums[i];
            numsIndex[i][1] = i;
        }

        Arrays.sort(numsIndex, Comparator.comparingInt((x) -> x[0]));

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = numsIndex[i][0] + numsIndex[j][0];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[] {
                    Math.min(numsIndex[i][1], numsIndex[j][1]), 
                    Math.max(numsIndex[i][1], numsIndex[j][1])
                };
            }
        }
        return new int[0];
    }
}
