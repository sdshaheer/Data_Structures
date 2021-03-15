/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;
import java.util.*;
class Node{
    public  int data;
    public Node left,right;
    public Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class Binary{
    public Node getsucceedor(Node node,int data){
        if(node==null)
            return null;
        Node small=node;
        while(node!=null){
            if(data<node.data){
                small=node;
                node=node.left;
            }
            else{
                node=node.right;
            }
        }
        return small;
    }
    public Node insert(Node node,int data){
      if(node==null){
          Node temp=new Node(data);
          return temp;
      }  
      else if(data<node.data){
          node.left=insert(node.left,data);
      }
      else
          node.right=insert(node.right,data);
      return node;
    }
    public Node getparent(Node node,int data){
        if(node==null)
            return null;
        Node parent=null;
        while(node.data!=data){
            if(data<node.data){
                parent=node;
                node=node.left;
            }
            else{
                parent=node;
                node=node.right;
            }
        }
        return parent;
        
    }
    public Node search(Node node,int data){
        if(node==null){
            System.out.println("no data");
            return null;
        }
        if(data<node.data)
            return search(node.left,data);
        else 
            return search(node.right,data);
    }
    public void delete(Node node,int data){
        Node t=node;
        while(t.data!=data){
            if(data<t.data)
                t=t.left;
            else
                t=t.right;
        }
        Node parent=getparent(node,data);
        //case 1
        if(t.left==null && t.right==null){
            if(parent.left==t)
                parent.left=null;
            else
                parent.right=null;
        }
        //case 3
        else if(t.left!=null && t.right!=null){
            Node succ=getsucceedor(t.right,t.data);
            Node succparent=getparent(node,succ.data);//parent of succesor
            if(succ.right!=null){
                succparent.left=succ.right;
            }
            else{
                succparent.left=null;
            }
            t.data=succ.data;

        }
        //case 2
        else{
            if(parent.left==t){
                if(t.left!=null)
                    parent.left=t.left;
                else
                    parent.left=t.right;
            }
            else{
                if(t.left!=null)
                    parent.right=t.left;
                else
                    parent.right=t.right;
            }
                
        }
        
    }
    public void getsibling(Node node,int data){
        Node parent=getparent(node,data);
        if(parent.left.data==data && parent.right!=null){
            System.out.println("sibling node to "+data+" is "+parent.right.data);    
        }
        else if(parent.right.data==data && parent.left!=null){
            System.out.println("sibling node to "+data+" is "+parent.left.data);
        }
        else{
            System.out.println("no such node found");
        }
    }
    public Node getmax(Node node){
        if(node.right==null){
            return node;
        }
        else{
            return getmax(node.right);
        }
    }
    public Node getmin(Node node){
        if(node.left==null){
            return node;
        }
        else{
            return getmin(node.left);
        }
    }
    public Node getcommonparent(Node node,int data1,int data2){
        if(data1<node.data && data2<node.data)
            return getcommonparent(node.left,data1,data2);
        else if(data1>node.data && data2>node.data)
            return getcommonparent(node.right,data1,data2);
        else
            return node;
    }
    public void show(Node node){
        if(node==null){
            return;
        }
        //System.out.println(root.data);
        show(node.left);
        System.out.println(node.data);
        show(node.right);

    }
}
public class BinaryTree {

    public static void main(String[] args) {
        // TODO code application logic here
        Node root=null;
        Binary obj=new Binary();
        root=obj.insert(root,8);
        obj.insert(root, 3);
        obj.insert(root, 10);
        obj.insert(root, 1);
        obj.insert(root, 6);
        obj.insert(root, 14);
        obj.insert(root, 4);
        obj.insert(root, 7);
        obj.insert(root, 13);
        System.out.println(obj.search(root,11).data);
        //obj.show(root);
        //System.out.println(".....");
        //obj.getparent(root,60);
        //obj.delete(root,60);
        //obj.show(root);
        //obj.getsibling(root,14);
        //System.out.println("max element is "+obj.getmax(root).data);
        //System.out.println("min element is "+obj.getmin(root).data);
        //System.out.println("common parent is "+obj.getcommonparent(root,1,13).data);
    }
    
}
