package com.satya.graph.algos.unionfind;

public class Main {
    public static void main(String[] args) {
        UnionFind uf=new UnionFind(10);


        System.out.println(uf.unify(0,1));
        System.out.println(uf.unify(2,3));
        System.out.println(uf.unify(4,5));
        System.out.println(uf.unify(6,7));
        System.out.println(uf.unify(8,9));
        System.out.println("Total number of components->"+uf.components());
        System.out.println("Total number of nodes of component (8)-> "+uf.componentsSize(8));
        System.out.println("Total number of nodes of component (9)-> "+uf.componentsSize(9));


        System.out.println("Root of Node (7)->"+uf.find(7));
        System.out.println("Unify 9 and 6. root node should be root of 9 that is 8");
        System.out.println(uf.unify(9,6));
        System.out.println(uf.find(6));
        System.out.println(uf.find(7));
        System.out.println("Total number of components after unify->"+uf.components());
        System.out.println("Total number of nodes of component (8)-> "+uf.componentsSize(8));


        System.out.println("Unify 6 and 4. root node should be root of 6 that is 8");
        System.out.println(uf.unify(6,4));
        System.out.println(uf.find(4));
        System.out.println(uf.find(5));
        System.out.println(uf.find(6));
        System.out.println("Total number of components after unify->"+uf.components());

    }
}
