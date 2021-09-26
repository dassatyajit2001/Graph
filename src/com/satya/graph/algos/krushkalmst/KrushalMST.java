package com.satya.graph.algos.krushkalmst;

import com.satya.graph.util.Edge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a connected and undirected graph, a spanning tree of that graph is a subgraph that is a tree and connects
 * all the vertices together. A single graph can have many different spanning trees. A minimum spanning tree (MST)
 * or minimum weight spanning tree for a weighted, connected, undirected graph is a spanning tree with a weight
 * less than or equal to the weight of every other spanning tree. The weight of a spanning tree is the sum of
 * weights given to each edge of the spanning tree.
 *
 * MST has n-1 edges where n is number of nodes present
 *
 * 1) Sort edges by ascending edge weight
 * 2) Walk through the sorted edges, Take the 2 nodes the edge belongs to. IF both nodes are unified then
 *    don’t include the edge. Else include it and unify the nodes.
 * 3) Terminate when all n-1 edges have been processed or all nodes have been unified.
 */
public class KrushalMST {
    //holds the sum of mst weight
    private int sum=0;
    //Size of number of nodes
    private int size;
    //the ids or nodes array used in union find
    private int[] ids;
    //Holds size of each component seen via a root node
    private int[] componentSize;
    //Total number of components
    private int numOfComponents;

    public int getSum(){
        return sum;
    }
    /**
     * initialize the variables
     * @param n
     */
    public KrushalMST(int n){
        size=n;
        numOfComponents=n;
        ids=new int[n];
        componentSize=new int[n];
        for(int i=0;i<n;i++){
            //initially all nodes have a self loop or are its own parent
            ids[i]=i;
            //the component size is 1 as each node is a component
            componentSize[i]=1;
        }
    }

    /**
     * This method computes the Krushkal MST
     * 1) Sort edges by ascending edge weight
     * 2) Walk through the sorted edges, Take the 2 nodes the edge belongs to. IF both nodes are unified then
     *     don’t include the edge. Else include it and unify the nodes.
     * 3) Terminate when all n-1 edges have been processed or all nodes have been unified.
     */
    public void computeMST(Edge[] edges){

        sortEdges(edges);
        for(Edge e1:edges){
            // if numOfComponents is 1 that means all nodes are unified and we have the mst
            //else keep unifying
            if(numOfComponents!=1) {
                int root1 = find(e1.getSrc());
                int root2 = find(e1.getDest());
                //Unify only those nodes or roots which are not part of same component
                //skip if they are already unified
                if (root1 != root2) {
                    unify(e1.getSrc(),e1.getDest());
                    System.out.println(e1.getSrc()+" --"+e1.getWt()+"-- "+e1.getDest());
                    sum+=e1.getWt();
                }
            }
            else
                return;
        }
    }

    /**
     * returns the size of a given component
     * @param root
     * @return
     */
    public int componentsSize(int root){
        return componentSize[root];
    }

    /**
     * returns the number of components
     * @return
     */
    public int getNumOfComponents(){
        return numOfComponents;
    }

    /**
     * Unifies or merges 2 diff components
     */
    public void unify(int v1,int v2){
        int root1=find(v1);
        int root2=find(v2);
        if(root1==root2)
            return;
        if(componentsSize(root1)>componentsSize(root2)){
            ids[root2]=root1;
            componentSize[root2]+=componentSize[root1];
            componentSize[root1]=0;
        }
        else{
            ids[root1]=root2;
            componentSize[root1]+=componentSize[root2];
            componentSize[root2]=0;
        }
        numOfComponents--;
    }

    /**
     * Traverses the ids array and finds the root of a given node
     * @param v
     * @return
     */
    public int find(int v){
        while(ids[v]!=v){
            v=ids[v];
        }
        return v;
    }

    /**
     * Sort the given edges
     * @param edges
     */
    public void sortEdges(Edge[] edges){
        Comparator comparator= Comparator.comparing(Edge::getWt);
        Arrays.sort(edges,comparator);
    }
}
