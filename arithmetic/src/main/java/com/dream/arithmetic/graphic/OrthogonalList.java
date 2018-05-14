package com.dream.arithmetic.graphic;

import java.util.ArrayList;
import java.util.List;

public class OrthogonalList {

	//插入边
	public static void insertEdge(EdgeNode<Integer> edge, List<VertexNode<Integer, Integer>> vertexs) {
		int headvex = edge.headvex;
		int tailvex = edge.tailvex;
		VertexNode<Integer, Integer> firstIn = vertexs.get(headvex);
		VertexNode<Integer, Integer> firstOut = vertexs.get(tailvex);
		if (firstIn.firstOut == null) {// 插入到顶点的出边属性
			firstIn.firstOut = edge;
		} else { // 插入到edge的headlink属性
			EdgeNode<Integer> tempEdge = firstIn.firstOut;
			while (tempEdge.headlink != null) { // 找到最后一个Edge
				tempEdge = tempEdge.headlink;
			}
			tempEdge.headlink = edge;
		}
		if (firstOut.firstIn == null) {// 插入到顶点的入边属性
			firstOut.firstIn = edge;
		} else {// 插入到edge的taillink属性
			EdgeNode<Integer> tempEdge = firstOut.firstIn;
			while (tempEdge.taillink != null) {// 找到最后一个Edge
				tempEdge = tempEdge.taillink;
			}
			tempEdge.taillink = edge;
		}
	}

	public static void printVertexAndEdges(List<VertexNode<Integer, Integer>> list) {
		for (VertexNode<Integer, Integer> vertex : list) { // 输出入度
			String infoIn = String.format("vertex: %3d - its in-edge are: ", vertex.data);
			EdgeNode<Integer> edge = vertex.firstIn;
			while (edge != null) {
				infoIn += String.format("(from: %d, to: %d, data: %d)", edge.headvex, edge.tailvex, edge.data);
				edge = edge.taillink;
			}
			System.out.println(infoIn);
			// 输出出度
			String infoOut = String.format("vertex: %3d - its out-edge are: ", vertex.data);
			EdgeNode<Integer> edgeOut = vertex.firstOut;
			while (edgeOut != null) {
				infoOut += String.format("(from: %d, to: %d, data: %d)", edgeOut.headvex, edgeOut.tailvex,
						edgeOut.data);
				edgeOut = edgeOut.headlink;
			}
			System.out.println(infoOut);
		}
	}

	public static void main(String[] args) {
		int vertexNumber = 12;
        int edgeNumber = 21;
        // 检查边的数量是否正确
        // 有向完全图
        int maxEdgeNumber = vertexNumber*(vertexNumber-1); 
        if (edgeNumber < 0 || edgeNumber > maxEdgeNumber) {
            return;
        }
        // 输入有向图数据
        // 1. 先输入顶点，暂时令firstIn， firstOut为null;
        ArrayList<VertexNode<Integer, Integer>> vertexList = new ArrayList<>();
        for (int i=0; i<vertexNumber; i++) {
            VertexNode<Integer, Integer> v = new VertexNode<>(i);
            vertexList.add(v);
        } 
        // 2. 输入边
        // 二维数组，每一行两个元素，分别是起点和终点的下标
        @SuppressWarnings("serial")
        List<EdgeNode<Integer>> rawEdgeList = new ArrayList<EdgeNode<Integer>>(){{
            add(new EdgeNode<Integer>(9, 0, 1));
            add(new EdgeNode<Integer>(7, 0, 2));
            add(new EdgeNode<Integer>(3, 0, 3));
            add(new EdgeNode<Integer>(2, 0, 4));
            add(new EdgeNode<Integer>(4, 1, 5));
            add(new EdgeNode<Integer>(2, 1, 6));
            add(new EdgeNode<Integer>(1, 1, 7));
            add(new EdgeNode<Integer>(2, 2, 5));
            add(new EdgeNode<Integer>(7, 2, 6));
            add(new EdgeNode<Integer>(11, 3, 7));
            add(new EdgeNode<Integer>(11, 4, 6));
            add(new EdgeNode<Integer>(8, 4, 7));
            add(new EdgeNode<Integer>(6, 5, 8));
            add(new EdgeNode<Integer>(5, 5, 9));
            add(new EdgeNode<Integer>(4, 6, 8));
            add(new EdgeNode<Integer>(3, 6, 9));
            add(new EdgeNode<Integer>(5, 7, 9));
            add(new EdgeNode<Integer>(6, 7, 10));
            add(new EdgeNode<Integer>(4, 8, 11));
            add(new EdgeNode<Integer>(2, 9, 11));
            add(new EdgeNode<Integer>(5, 10, 11));

        }};
        
        for (EdgeNode<Integer> edge : rawEdgeList) {        
            insertEdge(edge, vertexList);
        }
        
        //遍历顶点，输出每个顶点的出边和入边
        printVertexAndEdges(vertexList);
    }
}
