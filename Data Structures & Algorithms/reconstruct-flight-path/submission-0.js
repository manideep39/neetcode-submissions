class Solution {
    /**
     * @param {string[][]} tickets
     * @return {string[]}
     */
    findItinerary(tickets) {
            tickets.sort((a, b) => {
        if (a[0] == b[0]) {
            return a[1].localeCompare(b[1])
        } else {
            return a[0].localeCompare(b[0])
        }
    })

    const graph = new Map()
    for (const [from, to] of tickets) {
        if (!graph.has(from)) graph.set(from, [])
        graph.get(from).push(to)
    }

    let ans = []
    dfs('JFK', ['JFK'])
    return ans

    function dfs (source, result) {
        if (result.length == tickets.length + 1) {
            ans = result
            return true
        }

        if (!graph.has(source)) return false

        for (let i = 0; i < graph.get(source).length; i++) {
            const neighbor = graph.get(source).shift()
            if (dfs(neighbor, [...result, neighbor])) return true
            graph.get(source).push(neighbor)
        }

        return false
    }
    }
}
