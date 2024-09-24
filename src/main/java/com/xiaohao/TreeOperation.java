package com.xiaohao;

import java.util.Stack;

public class TreeOperation {
    // 先序遍历非递归
    public static void preOrder(Tree<Integer> head){
        Stack<Tree<Integer>> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            // 打印
            Tree.printVal(head);
            // 先右后左，依次入栈
            if(head.right != null){
                stack.push(head.right);
            }
            if(head.left!=null){
                stack.push(head.left);
            }
        }
    }

    // 中序遍历非递归,head变成一个指针
    public static void inOrder(Tree<Integer> head){
        Stack<Tree<Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || head !=null){
            // 左孩子依次入栈
            while(head != null){
                stack.push(head);
                head = head.left;
            }
            // head为空，则出栈一个作为head
            head = stack.pop();
            // 打印
            Tree.printVal(head);
            // 按照递归的思想来看！！！，此时右子树看作是一颗新数
            head = head.right;

        }
    }

    // 后序遍历（使用两个栈），前序为“中左右”，转换一下就是中右左，逆序一下就是左右中
    public static void posOrderWithTwoStacks(Tree<Integer> head){
        Stack<Tree<Integer>> stack = new Stack<>();
        Stack<Tree<Integer>> stack2 = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            head = stack.pop();
            stack2.push(head);
            if(head.left != null){
                stack.push(head.left);
            }
            if(head.right!=null){
                stack.push(head.right);
            }
        }
        while(!stack2.isEmpty()){
            Tree.printVal(stack2.pop());
        }
    }

    // 后续遍历-》使用一个stack，更加省空间
    public static void posOrder(Tree<Integer> head){
        if(head!=null){
            /**
             * head 在这个算法中作为我们的指针
             * 当还没打印过节点时，head指向根节点
             * 一旦打印过节点时，head就变成了刚刚打印的节点
             * 如何判断左孩子、有孩子有没有处理过：比较left、right是否与head相等
             */
            Stack<Tree<Integer>> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                Tree<Integer> cur = stack.peek();
                if(cur.left !=null
                        && cur.left !=head
                        && cur.right!=head){
                    // 有左孩子，而且左右孩子都没有处理过，则处理左孩子
                    stack.push(cur.left);
                } else if (cur.right != null
                        && cur.right != head) {
                    // 有右孩子，并且右孩子没有被处理过
                    stack.push(cur.right);
                }else{
                    // 没有左右孩子或者左右孩子都被处理过了
                    Tree.printVal(cur);
                    stack.pop();
                }
            }
        }
    }

}

