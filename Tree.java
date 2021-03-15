/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;
import java.util.*;
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class Operations{
    TreeMap<Integer,Integer> t=new TreeMap<>();
    public int leaf(Node node){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return 1;
        else
            return leaf(node.left)+leaf(node.right);
    }
    public int height(Node node){
        if(node==null)
            return -1;
        else
            return max(height(node.left),height(node.right))+1;
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
    public void level(Node node,int level){
        if(node==null)
            return;
        if(level==1){
            System.out.println(node.data);
        }
        level(node.left,level-1);
        level(node.right,level-1);
    }
    int max=0;
    public void leftview(Node node,int level){
        if(node==null)
            return;
        if(level>=max){
            System.out.println(node.data);
            max++;
        }
        leftview(node.left,level+1);
        leftview(node.right,level+1);
    }
    public void rightview(Node node,int level){
        if(node==null)
            return;
        if(level>=max){
            System.out.println(node.data);
            max++;
        }
        rightview(node.right,level+1);
        rightview(node.left,level+1);
    }
    public void checktop(Node node,Node root,int level){
        if(root.right.data==node.data){
            for(Map.Entry<Integer,Integer> map:t.entrySet()){
                int i=map.getKey();
                if(i>0){
                    t.remove(i);
                }
            }
        }
        if(!t.containsKey(level)){
            t.put(level,node.data);
        }
        
    }
    public void topview(Node node,Node root,int level){
        if(node==null)
            return;
        checktop(node,root,level);
        System.out.println(node.data+" "+level);
        topview(node.left,root,level-1);
        topview(node.right,root,level+1);
    }
    public void checkbottom(Node node,Node root,int level){
        t.put(level, node.data);
    }
    public void bottomview(Node node,Node root,int level){
        if(node==null)
            return;
        checkbottom(node,root,level);
        System.out.println(node.data+" "+level);
        bottomview(node.left,root,level-1);
        bottomview(node.right,root,level+1);
    }
    int diameter=0;
    public int getdiameter(Node node){
        if(node==null)
            return 0;
        int l=height(node.left)+1;
        int r=height(node.right)+1;
        diameter=Math.max(l+r+1, diameter);
        getdiameter(node.left);
        getdiameter(node.right);
        return diameter;
    }
    public void show(Node node){
        if(node==null)
            return;
        show(node.right);
        System.out.println(node.data);

        show(node.left);
    }
} 
public class Tree {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Operations obj=new Operations();
        Node root=new Node(2);
        root.left=new Node(7);
        root.right=new Node(5);
        root.left.left=new Node(2);
        root.left.right=new Node(6);
        root.left.right.left=new Node(5);
        root.left.right.right=new Node(11);
        root.right.right=new Node(9);
        root.right.right.left=new Node(4);
        //System.out.println("No leaf nodes "+obj.leaf(root));
       //System.out.println("Height of tree is "+obj.height(root));
        //obj.level(root,4);
        //obj.leftview(root,0);
        //obj.rightview(root,0);
        //obj.topview(root,root,0);
        //obj.bottomview(root,root,0);
        //System.out.println(obj.t);
        //System.out.println(obj.getdiameter(root));
         obj.show(root);
    }
    
}
