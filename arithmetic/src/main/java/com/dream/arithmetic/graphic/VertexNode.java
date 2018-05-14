package com.dream.arithmetic.graphic;

//顶点结点的定义
public class VertexNode<E,T>  {
    E data;           //顶点内容  
    EdgeNode<T> firstIn;  // 顶点的第一条入弧
    EdgeNode<T> firstOut; //顶点的第一条出弧

    public VertexNode(E data) {
        this.data = data;
    }
}
