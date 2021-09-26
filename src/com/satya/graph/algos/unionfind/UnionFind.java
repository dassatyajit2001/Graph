package com.satya.graph.algos.unionfind;

/**
 * Implementation of Unionfind/Disjoint set, along with path compression
 */
public class UnionFind {
    //Total number of components in UnionFind
    private int numOfComponents;
    //Total elements in UnionFind
    private int size;
    //Size of each components
    private int[] nodeSize;
    //The actual child to parent mapping structure. If ids[i]==i . If we encounter self loop then it is the parent
    private int[] ids;

    /**
     * Constructor which takes the size of total nodes.
     * This will preInitialize all variables to be used in UnionFind
     * @param size
     */
    public UnionFind(int size){
        size=size;
        numOfComponents=size;
        nodeSize=new int[size];
        ids=new int[size];

        for (int i = 0; i < size; i++) {
            //Every node has a self loop means it is the parent
            ids[i]=i;
            //since each node is an individual component hence size is 1;
            nodeSize[i]=1;
        }
    }

    /**
     * It finds the root or to which component an given element belongs to.
     * It takes amortized constant time.
     * @param element
     * @return
     */
    public int find(int element){
        int parent=element;
        //until we find the self loop keep traversing until we get it
        while(ids[parent]!=parent){
            parent=ids[parent];
        }
        compressPath(element,parent);
        return parent;
    }

    /**
     * This method compresses path for a given component's element
     * @param element
     */
    private void compressPath(int element,int root){
        // map each element's parent to the root
        while(element!=root){
            int parent=ids[element];
            ids[element]=root;
            element=parent;
        }
    }

    /**
     * returns total elements in Union find
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * returns total number of components in Union find
     * @return
     */
    public int components(){
        return numOfComponents;
    }

    /**
     * returns the number of nodes or component size for a given component
     * @param element
     * @return
     */
    public int componentsSize(int element){
        return nodeSize[element];
    }

    /**
     * tells whether 2 nodes are part of same component or not
     * @return
     */
    public boolean isConnected(int element1, int element2){
        return find(element1)==find(element2);
    }

    /**
     * merges 2 components
     * @param element1
     * @param element2
     * @return
     */
    public int unify(int element1,int element2){
       //if both the element are part of same component then no unification required.
        if(isConnected(element1,element2))
           return find(element1);
        //get the roots of both the elements
        int root1=find(element1);
        int root2=find(element2);
    int root=-1;
        if(componentsSize(root1)<componentsSize(root2)){
            // make root1's parent as root 2 as the size is greater
            ids[root1]=root2;
            //increase the component size of root2. Add component size of root1 to it.
            nodeSize[root2]+=nodeSize[root1];
            // make the component size of root1 to zero as it is not more the root node.
            nodeSize[root1]=0;
            //this is the root to be returned
            root=root2;
        }
        else{
            // make root2's parent as root1 as the size is greater
            ids[root2]=root1;
            //increase the component size of root1. Add component size of root2 to it.
            nodeSize[root1]+=nodeSize[root2];
            // make the component size of root2 to zero as it is not more the root node.
            nodeSize[root2]=0;
            //this is the root to be returned
            root=root1;
        }
        //decrease the component size by 1 as 2 components merge to 1.
        numOfComponents--;

        return root;
    }

}
