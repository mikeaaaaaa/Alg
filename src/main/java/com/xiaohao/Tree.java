package com.xiaohao;

public class Tree<T> {
    public Tree<T> left;
    public Tree<T> right;
    public T val;
    public Tree(T val) {}
    public Tree(T val, Tree<T> left, Tree<T> right) {}

    public static void printVal(Tree tree){
        System.out.println(tree.val);
    }
}
