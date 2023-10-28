package com.oculux.se284.datastructures.disjointset;

public class DisjointSet {

  private int[] parent;
  private int[] height;

  public DisjointSet(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Size must be positive");
    }

    parent = new int[size];
    height = new int[size];

    for (int i = 0; i < size; i++) {
      parent[i] = i;
      height[i] = 0;
    }
  }

  public void union(int x, int y) {
    int xRoot = find(x);
    int yRoot = find(y);

    if (xRoot == yRoot) {
      return;
    }

    if (height[xRoot] < height[yRoot]) {
      parent[xRoot] = yRoot;
    } else if (height[xRoot] > height[yRoot]) {
      parent[yRoot] = xRoot;
    } else {
      parent[yRoot] = xRoot;
      height[xRoot]++;
    }
  }

  public int find(int x) {
    int rep = x;
    while (rep != parent[rep]) {
      rep = parent[rep];
    }

    while (x != rep) {
      int next = parent[x];
      parent[x] = rep;
      x = next;
    }

    return rep;
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}
