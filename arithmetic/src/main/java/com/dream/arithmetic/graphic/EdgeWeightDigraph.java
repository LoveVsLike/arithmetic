package com.dream.arithmetic.graphic;

import java.util.ArrayList;

public class EdgeWeightDigraph {
	public int v;// 顶点的个数
	public int e; // 边的个数

	public ArrayList<Edge>[] adj; // 邻接表

	@SuppressWarnings("unchecked")
	public EdgeWeightDigraph(int v) {
		this.v = v;
		adj = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new ArrayList<Edge>();
		}
	}

	public void addEdge(Edge e) {
		adj[e.from()].add(e);
		this.e++;
	}

	public void printEdge() {
		for (int i = 0; i < v; i++) {
			for (Edge e : adj[i]) {
				System.out.println(e + " ");
			}
		}
	}

	public static void main(String[] args) {
		EdgeWeightDigraph graph = new EdgeWeightDigraph(5);

		Edge e = new Edge(0, 1, 1);
		Edge e1 = new Edge(0, 2, 1);
		Edge e2 = new Edge(1, 2, 1);
		Edge e3 = new Edge(2, 3, 1);
		Edge e4 = new Edge(3, 4, 1);

		graph.addEdge(e);
		graph.addEdge(e1);
		graph.addEdge(e2);
		graph.addEdge(e3);
		graph.addEdge(e4);

		graph.printEdge();

	}

}
