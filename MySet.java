import java.lang.*;
import java.io.*;
import java.util.*;
public class MySet<T> extends MyLinkedList<T>{
    MyLinkedList<T> list = new MyLinkedList<>();

    public void addElement(T element){
        if(!list.contains(element))
            list.addLast(element);
    }
    MySet<T> union(MySet<T> otherSet){
        MySet<T> x = new MySet<>();
        int i=0;
        while(i<this.list.size()){
            x.addElement(this.list.get(i));
            i++;
        }
        int k=0;
        int j = otherSet.list.size();
        while(k<j){
            if(!(x.list.contains(otherSet.list.get(k)))){
                x.addElement(otherSet.list.get(k));
            }
            k++;
        }
        //System.out.println(x.list.size());
        return x;
    }
    MySet<T> intersection(MySet<T> otherSet){
        MySet<T> x = new MySet<>();
        int m=0;
        int i = otherSet.list.size();
         //System.out.println(otherSet.list.get(0).name);
        //System.out.println(otherSet.list.size());
        while(m<i){
        //System.out.println(this.list.get(m));
       //System.out.println(otherSet.list.get(m));
           if(this.list.contains(otherSet.list.get(m))){
          //System.out.println("kk");
                x.addElement(otherSet.list.get(m));
           } //System.out.println("m  "+m);
           m++;
        }
        return x;
    }

}