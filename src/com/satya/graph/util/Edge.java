package com.satya.graph.util;

/**
 * This class represents the edge between 2 nodes
 */
public class Edge {
    //the source node
   private int src;
    //the destination node
    private int dest;
    //weight among the nodes
    private int wt;

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWt() {
        return wt;
    }

    public void setWt(int wt) {
        this.wt = wt;
    }

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "src=" + src +
                ", nbr=" + dest +
                ", wt=" + wt +
                '}';
    }
}
