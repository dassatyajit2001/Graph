package com.satya.graph.algos.krushkalmst;

import com.satya.graph.algos.unionfind.UnionFind;
import com.satya.graph.util.Edge;

public class Main {
    public static void main(String[] args) {
        int n=4;
        int nEdg=5;
        KrushalMST kmst=new KrushalMST(n);
        Edge[] edges=new Edge[nEdg];
        edges[0]=new Edge(0,1,10);
        edges[1]=new Edge(0,2,6);
        edges[2]=new Edge(0,3,5);
        edges[3]=new Edge(1,3,15);
        edges[4]=new Edge(2,3,4);
        kmst.computeMST(edges);
        System.out.println(kmst.getSum());

         n=9;
        nEdg=14;
        KrushalMST kmst2=new KrushalMST(n);
        edges=new Edge[nEdg];
        edges[0]=new Edge(7,6,1);
        edges[1]=new Edge(8,2,2);
        edges[2]=new Edge(6,5,2);
        edges[3]=new Edge(0,1,4);
        edges[4]=new Edge(2,5,4);
        edges[5]=new Edge(8,6,6);
        edges[6]=new Edge(2,3,7);
        edges[7]=new Edge(7,8,7);
        edges[8]=new Edge(0,7,8);
        edges[9]=new Edge(1,2,8);
        edges[10]=new Edge(3,4,9);
        edges[11]=new Edge(5,4,10);
        edges[12]=new Edge(1,7,11);
        edges[13]=new Edge(3,5,14);

        kmst2.computeMST(edges);
        System.out.println(kmst2.getSum());
    }
}
