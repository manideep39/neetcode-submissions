class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> edgeMatrix = IntStream.range(0, n)
            .mapToObj(ArrayList<Integer>::new)
            .collect(Collectors.toCollection(ArrayList::new));

        for (int[] edge: edges) {
            edgeMatrix.get(edge[0]).add(edge[1]);
            edgeMatrix.get(edge[1]).add(edge[0]);
        }

        int[] seen = new int[n];
        if (isCycleExist(-1, 0, seen, edgeMatrix))
            return false;

        return Arrays.stream(seen).sum() == n;
    }

    private boolean isCycleExist(int parent, int node, 
            int[] seen, List<List<Integer>> edgeMatrix) {
        if (seen[node] == 1)
            return true;
        seen[node] = 1;

        for (int neighbour: edgeMatrix.get(node)) {
            if (neighbour != parent) {
                if (isCycleExist(node, neighbour, seen, edgeMatrix) == true)
                    return true;
            }
        }

        return false;
    }
}
