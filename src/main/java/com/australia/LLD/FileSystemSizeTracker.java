package com.australia.LLD;

import java.util.*;

class TrieNode {
    Map<String, TrieNode> children = new HashMap<>();
    long size = 0;
}

public class FileSystemSizeTracker {
    private TrieNode root = new TrieNode();

    public void addFile(String path, long size) {
        TrieNode node = root;
        String[] directories = path.split("/");
        for (String directory : directories) {
            node = node.children.computeIfAbsent(directory, k -> new TrieNode());
            node.size += size;
        }
    }

    public void removeFile(String path, long size) {
        TrieNode node = root;
        String[] directories = path.split("/");
        for (String directory : directories) {
            node = node.children.get(directory);
            node.size -= size;
        }
    }

    public long getDirectorySize(String path) {
        TrieNode node = root;
        String[] directories = path.split("/");
        for (String directory : directories) {
            node = node.children.get(directory);
        }
        return node.size;
    }

    public List<String> getTopNDirectories(int topN) {
        List<String> topDirectories = new ArrayList<>();
        PriorityQueue<TrieNode> queue = new PriorityQueue<>((a, b) -> Long.compare(b.size, a.size));
        queue.offer(root);
        while (!queue.isEmpty() && topDirectories.size() < topN) {
            TrieNode node = queue.poll();
            topDirectories.add(node.children.keySet().iterator().next());
            node.children.values().forEach(queue::offer);
        }
        return topDirectories;
    }
}
