package com.dream.arithmetic.graphic;

public class Edge {
	private int v; // 边的起点
	private int w; // 边的终点

	private double weight;// 边的权重

	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public double weight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}
}
