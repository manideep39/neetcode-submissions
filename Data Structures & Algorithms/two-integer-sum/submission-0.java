class Solution {
    public int[] twoSum(int[] nums, int target) {
        var diffs = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (diffs.containsKey(cur)) {
                return new int[] {diffs.get(cur), i};
            }

            int diff = target - cur;
            diffs.putIfAbsent(diff, i);
        }
        return new int[0];
    }
}
