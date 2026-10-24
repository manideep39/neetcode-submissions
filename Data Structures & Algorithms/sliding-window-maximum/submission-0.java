class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < k; i++)
            maxHeap.offer(new int[] {i, nums[i]});
        
        int[] output = new int[nums.length - k + 1];

        if (nums.length == 0)
            return output;

        output[0] = maxHeap.peek()[1];

        for (int i = k; i < nums.length; i++) {
            maxHeap.offer(new int[] {i, nums[i]});
            while (maxHeap.peek()[0] <= i - k)
                maxHeap.poll();
            output[i - k + 1] = maxHeap.peek()[1];
        }

        return output;
    }
}