import java.io.*;
import java.util.*;
public class Main
{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(){
            
        }
        Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
        
    }
    public static class Pair{
        Node node;
        int state;
        Pair(){
            
        }
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }
    public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = " <- " + node.data + " -> ";

    String left = (node.left == null) ? "." :  "" + node.left.data;
    String right = (node.right == null) ? "." : "" + node.right.data;

    str = left + str + right;

    System.out.println(str);

    display(node.left);
    display(node.right);
  }
    
   public static void Main(String[] args){
       Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
       Node root=new Node(arr[0],null,null);
       Pair p = new Pair(root,1);
       Stack<Pair> st=new Stack<>();
       st.push(p);
       int idx=1;
       while(st.size()>0){
           Pair top=st.peek();
           if(top.state==1){
              if(arr[idx]!=null){
                  Node ln=new Node(arr[idx],null,null);
                  top.node.left=ln;
                  Pair cp=new Pair(ln,1);
                  st.push(cp);
              }else{
                  top.node.left=null;
              }
              idx++;
              top.state+=1;
               
           }
           else if(top.state==2){
               if(arr[idx]!=null){
                   Node rn=new Node(arr[idx],null,null);
                   top.node.right=rn;
                   Pair cp=new Pair(rn,1);
                   st.push(cp);
               }else{
                   top.node.right=null;
               }
               idx++;
               top.state+=1;
               
           }
           else{
               st.pop();
           }
       }
       display(root);
       
   }
    
}
