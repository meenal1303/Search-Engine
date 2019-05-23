import java.lang.*;
import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
public class MyLinkedList<T>{
    class node<T>{
        private T data;
        private node next;
        node(){
            data=null;
            next=null;
        }
        public node(T a){
            data=a;
        }
        public T value(){
            return data;}
        
        public node<T> successor(){
            return next;}
        
        public void setnext(node<T> a){
            next=a;}
    }
    
    node<T> object = new node<T>();
    private int size;
    MyLinkedList(){
        object=null;
        size=0;
    }
    
    public void addLast(T a){
        if(size==0){
                object = new node<>(a);
                object.setnext(null);
            }
            else{
                node<T> temp = object;
                while(temp.successor()!=null){
                    temp=temp.successor();
                }
                node<T> b = new node<>(a);
                temp.setnext(b);
                b.setnext(null);
            }
            size++;
    }
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        if(size()==0)
            return true;
        else
            return false;
    }
    
    public boolean contains(T a){
        if(object==null)
            return false;
        else{
        node<T> temp = object;
        
        while(temp!=null){
         //System.out.println(temp.data);
            if(temp.data.equals(a))
                return true;
            temp=temp.successor();
        }
        return false;
        }
    }
    
    public void remove(T a){
    node<T> temp = object;
        if(contains(a)==false)
            System.out.println("error in LL ");
        
        else if(object.data.equals(a)){
            object=object.successor();
            size--;
        }
        else{
            while(temp.successor().data!=a){
                temp=temp.successor();
            }
            temp.setnext(temp.successor().successor());
            size-- ;
            }   
    }
    public T get(int i){
        if(i>=size)
            System.out.println("Linked list error");
        else{
        int t=0;
        node<T> temp = object;
        while(temp.successor()!=null && t<i){
            temp=temp.successor();
            t++;
        }
        if(temp!=null){
            return temp.value();
        }
        }
        return null;
        
    }

}