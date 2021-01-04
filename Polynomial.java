package polynomial;
import java.util.*;

class Node{
    int coeff;
    int pow;
    Node next;
    public Node(int coeff,int pow){
        this.coeff=coeff;
        this.pow=pow;
        this.next=null;
    }
}
class Operation{
    Scanner sc;
    public Operation(){
        sc=new Scanner(System.in);
    }
    public int count(Node head){
        Node t=head;
        int c=0;
        while(t!=null){
            t=t.next;
            c++;
        }
        return c;
    }
    public Node createlist(Node head){
        while(true){
            System.out.println("Enter coeffecient");
            int coeff=sc.nextInt();
            System.out.println("Enter power");
            int pow=sc.nextInt();
            head=insert(coeff,pow,head);
            if(pow==0)
                break;
        }
        return head;
    }
    public Node insert(int coeff,int pow,Node head){
        Node temp,t;
        temp=new Node(coeff,pow);
        if(head==null)
            head=temp;
        else{
            t=head;
            while(t.next!=null)
                t=t.next;
            t.next=temp;
            
        }
        return head;
    }
    public Node add(Node head1,Node head2,Node head){
        Node temp,t;
        temp=head1;
        t=head2;
        while(temp!=null && t!=null){
            if(temp.pow==t.pow){
                head=insert(temp.coeff+t.coeff,temp.pow,head);
                temp=temp.next;
                t=t.next;
            }
            else if(temp.pow>t.pow){
                head=insert(temp.coeff,temp.pow,head);
                temp=temp.next;
            }
            else{
                head=insert(t.coeff,t.pow,head);
                t=t.next;
            }
               
        }
        while(temp!=null){
            head=insert(temp.coeff,temp.pow,head);
            temp=temp.next;
        }
        while(t!=null){
            head=insert(t.coeff,t.pow,head);
            t=t.next;
        }
        return head;
    }
    public Node sub(Node head1,Node head2,Node head){
        Node t=head2;
        while(t!=null){
            t.coeff=(-t.coeff);
            t=t.next;
        }
        head=add(head1,head2,head);
        return head;
    }
    public Node mul(Node head1,Node head2,Node head){
        Node temp=head1;
        Node t=head2;
        Node arr[]=new Node[count(head1)];
        Node out[]=new Node[count(head1)];
        for (int i = 0; i < count(head1); i++) {
            while(t!=null){
                arr[i]=insert(temp.coeff*t.coeff,temp.pow+t.pow,arr[i]);
                t=t.next;
            }
            t=head2;
            temp=temp.next;
        }
        out[0]=arr[0];
        for (int i = 0; i < count(head1)-1; i++) {
            out[i+1]=add(out[i],arr[i+1],out[i+1]);
        }
        head=out[out.length-1];
        return head;
    }
    public void show(Node head){
        Node t=head;
        while(t.next!=null){
            System.out.print(t.coeff+"^"+t.pow+"+");
            t=t.next;
        }
        System.out.println(t.coeff+"^"+t.pow);
    }
    
}

public class Polynomial {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        Node head1=null;
        Node head2=null;
        Node head3=null;
        Node head4=null;
        Node head5=null;
        Operation op1=new Operation();
        System.out.println("Enter first polynomial");
        head1=op1.createlist(head1);
        System.out.println("Enter second polynomial");
        Operation op2=new Operation();
        head2=op2.createlist(head2);
        System.out.println("First polynomial is:");
        op1.show(head1);
        System.out.println("Second polynomial is:");
        op2.show(head2);
        System.out.println("Enter 1.addition\n2.subtraction\n3.multiplication");
        int option=sc.nextInt();
   
        switch (option){
            case 1:
            {
               head3=op1.add(head1,head2,head3);
               op1.show(head3);
               break;
            }
            case 2:
            {
               head4=op1.sub(head1,head2,head4);
               op1.show(head4);
               break;
            }
            case 3:
            {
                head5=op1.mul(head1,head2,head5);
                op1.show(head5);
                break;
            }
            default:
            {
                System.out.println("Enter right option");
            }  
        }
       
        
    }
    
}
