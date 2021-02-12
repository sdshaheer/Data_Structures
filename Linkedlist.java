/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;
import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
class Linked{
    Scanner sc;
    public Linked(){
        sc=new Scanner(System.in);
    }
    public int count(Node head){
        Node t=head;
        int count=0;
        while(t!=null){
            count++;
            t=t.next;
        }
        return count;
    }
    public Node createlist(Node head){
        while(true){
            System.out.println("Enter a number");
            int a=sc.nextInt();
            head=insert(a,head);
            System.out.println("Enter 1.continue 0.quit");
            int b=sc.nextInt();
            if(b==0){
                break;
            }
        }
        return head;
    }
    public Node insert(int a,Node head){
        Node temp=new Node(a);
        Node t;
        if(head==null){
            head=temp;
        }
        else{
            t=head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=temp;
        }
        return head;
    }
    public void show(Node head){
        Node t=head;
        while(t.next!=null){
            System.out.print(t.data+"->");
            t=t.next;
        }
        System.out.println(t.data);
    }
    public void insertfirst(Node head,int data){
        Node temp=new Node(data);
        temp.next=head;
        head=temp;
        
    }
    public void insertat(Node head,int pos,int data){
        Node temp=new Node(data);
        Node t=head;
        Node u;
        int d=1;
        while(d<pos){
            t=t.next;
            d++;
        }
        u=t;
        u=u.next;
        t.next=temp;
        temp.next=u;
        
    }
    public void insertlast(Node head,int data){
        insert(data,head);
    }
    public Node removefirst(Node head){
        Node t=head;
        t=t.next;
        head=t;
        return head;
    }
    public void removeat(Node head,int pos){
        Node t=head;
        Node u;
        int d=1;
        while(d<pos){
            t=t.next;
            d++;
        }
        u=t;
        t=t.next;
        t=t.next;
        u.next=t;
    }
    public void removelast(Node head){
        Node t=head;
        int count=1;
        while(count<count(head)-1){
            t=t.next;
            count++;
        }
        t.next=null;
    }
    public void reverse(Node head){
        int stk[]=new int[10];
        int top=0;
        Node temp=head;
        while(temp!=null){
          stk[top++]=temp.data;
          temp=temp.next;
        }
        while(top!=0){
            System.out.print(stk[--top]+" ");
        }
        System.out.println();
    }
    public void  sort(Node head){
        Node t=head;
        Node u;
        while(t.next!=null){
            u=t.next;
            while(u!=null){
                if(t.data>=u.data){
                    t.data=t.data+u.data-(u.data=t.data);
                }
                u=u.next;
            }
            t=t.next;
        }
    }
    public void search(Node head,int num){
        Node t=head;
        while(t!=null){
            if(t.data==num){
                System.out.println("element found");
                return;
            }
            t=t.next;
        }
        System.out.println("element not found");
    }
    public void concat(Node head,Node head1){
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=head1;
    }
}
public class Linkedlist {

    public static void main(String[] args) {
        // TODO code application logic here
        Node head=null;
        Node head1=null;
        Linked obj=new Linked();
        head=obj.createlist(head);
        //obj.insertfirst(head,1000);
        //obj.insertat(head,2,100);
        //obj.insertlast(head,1000);
        //head=obj.removefirst(head);
        //obj.removeat(head,2);
        //obj.removelast(head);
        //obj.reverse(head);
        //obj.sort(head);
        //obj.search(head,23);
        obj.show(head);
        Linked obj1=new Linked();
        System.out.println("Enter 2 list elements");
        head1=obj1.createlist(head1);
        obj1.show(head1);
        obj.concat(head,head1);
        obj.show(head);

    }
    
}
