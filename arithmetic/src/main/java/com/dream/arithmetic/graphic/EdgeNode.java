package com.dream.arithmetic.graphic;

public class EdgeNode<E> {
    E data;              // 弧中所含的信息
    int headvex;         // 弧头结点的下标 
    int tailvex;         // 弧尾结点的下标
    EdgeNode<E> headlink;    // 指向弧头相同的下一条弧的链域
    EdgeNode<E> taillink;    // 指向弧尾相同的下一条弧的链域

    public EdgeNode(E data, int headvex, int tailvex) {
        this.data = data;
        this.headvex = headvex;
        this.tailvex = tailvex;
    }
    
}
