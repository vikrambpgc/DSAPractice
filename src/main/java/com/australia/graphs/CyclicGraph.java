package com.australia.graphs;

import java.util.ArrayList;
import java.util.List;

class CyclicGraph {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, adj, visited, recursionStack)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isCyclicUtil(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        recursionStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (isCyclicUtil(neighbor, adj, visited, recursionStack)) {
                return true;
            }
        }
        recursionStack[node] = false;
        return false;
    }
}
