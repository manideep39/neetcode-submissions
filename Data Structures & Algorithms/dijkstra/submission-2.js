/**
 * const PriorityQueue = require('priority-queue-js');
 */

class Solution {
    /**
     * @param {number} n
     * @param {number[][]} edges
     * @param {number} src
     * @returns {number[]}
     */
    shortestPath(n, edges, src) {
        const graph = Array.from({ length: n }, () => []);
        for (const [from, to, weight] of edges) {
            graph[from].push([to, weight]);
        }
        
        const distances = Array(n).fill(Infinity);
        distances[src] = 0;
        
        const priQueue = new PriorityQueue((a, b) => a[1] - b[1]);
        priQueue.enq([src, 0]);

        while (!priQueue.isEmpty()) {
            const [currentNode, currentDistance] = priQueue.deq();
            if (currentDistance <= distances[currentNode]) {
                for (const [toNode, toNodeDistance] of graph[currentNode]) {
                    const dist = currentDistance + toNodeDistance;
                    if (dist < distances[toNode]) {
                        priQueue.enq([toNode, dist]);
                        distances[toNode] = dist;
                    }
                }
            }
        }

        const reuslt = distances.map((x) => (x == Infinity ? -1 : x))
        return reuslt;
    }
}

