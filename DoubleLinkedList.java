/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkedlist;
import java.util.*;
class Node{
    int data;
    Node next,previous;
    int count=0;
    public Node(int data){
        this.data=data;
        this.previous=null;
        this.next=null;
        count++;
    }
}
class LinkedList{
    Scanner sc;
    public LinkedList(){
        sc=new Scanner(System.in);
    }
    public Node create(Node head){
        while(true){
            System.out.println("Enter data");
            int a=sc.nextInt();
            head=insert(a,head);
            System.out.println("Enter 1 to continue");
            int b=sc.nextInt();
            if(b!=1)
                break;
        }
        return head;
    }
    public Node insert(int a,Node head){
        Node temp,t;
        temp=new Node(a);
        if(head==null){
            head=temp;
        }
        else{
            t=head;
            while(t.next!=null)
                t=t.next;
            t.next=temp;
            temp.previous=t;
        }
        return head;
    }
    public Node insertFirst(int data,Node head){
        Node t=head;
        Node temp=new Node(data);
        t=t.next;
        t.previous=temp;
        temp.next=t;  
        head=temp;
        return head;
        
    }
    public void insertAt(int index,int data,Node head){
        Node temp,t,u;
        int c=1;
        temp=new Node(data);
        t=head;
        while(c<index){
            t=t.next;
            c++;
        }
        u=t;
        t=t.next;
        u.next=temp;
        temp.previous=u;
        temp.next=t;
        t.previous=temp;
        
    }
    public void insertLast(int data,Node head){
        insert(data,head);
    }
    public Node removeFirst(Node head){
        Node t=head;
        t=t.next;
        t.previous=null;
        head=t;
        return head;
    }
    public void removeAt(int index,Node head){
        Node t=head;
        Node u;
        int c=1;
        while(c<index){
            t=t.next;
            c++;
        }
        u=t;
        t=t.next;
        t=t.next;
        u.next=t;
        t.previous=u;
        
    }
    public void reverse(Node head){
        Node t=head;
        while(t.next!=null)
            t=t.next;
        while(t.previous!=null){
            System.out.print(t.data+" ");
            t=t.previous;
        }
        System.out.println(t.data);
    }
    public void removeLast(Node head){
        Node t=head;
        while(t.next!=null)
            t=t.next;
        t=t.previous;
        t.next=null;
        
    }
    public void show(Node head){
        Node t=head;
        while(t.next!=null){
            System.out.print(t.data+"->");
            t=t.next;
        }
        System.out.println(t.data);
    }
}

public class DoubleLinkedList {

    public static void main(String[] args) {
        // TODO code application logic here
        Node head=null;
        LinkedList obj=new LinkedList();
        head=obj.create(head);
        //obj.show(head);
        //head=obj.insertFirst(100,head);
        //obj.insertAt(4,1000,head);
        //obj.insertLast(100,head);
        obj.show(head);
        //head=obj.removeFirst(head);
        //obj.removeAt(3,head);
        obj.removeLast(head);
        obj.show(head);
        //obj.reverse(head);

    }
    
}
