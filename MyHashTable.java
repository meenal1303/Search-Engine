import java.util.*;
import java.io.*;
import java.lang.*;
/*Write a Java class MyHashTable that implements the hashtable used
by the InvertedPageIndex. It maps a word to its word-entry.
– private int getHashIndex(String str): Create a hash func-
tion which maps a string to the index of its word-entry in the
hashtable. The implementation of hashtable should support chain-
ing.
– void addPositionsForWord(WordEntry w): This adds an entry
to the hashtable: stringName(w) − > positionList(w). If no word-
entry exists, then create a new word entry. However, if a word-
entry exists, then merge w with the existing word-entry.
*/
@SuppressWarnings("unchecked")
public class MyHashTable{

    public class BucketArray{
        WordEntry data;
        BucketArray next;
        int size=0;
        public BucketArray(){
            //data = null;
            next = null;
        }
        public BucketArray(WordEntry w , BucketArray b){
            data = w;
            next = b;
            if(size==0) size=1;
        }
        public WordEntry getElement(){
            return data;
           
        }
        public BucketArray getNext(){
            return next;
        }
        public void setNext(BucketArray b){
            next = b;
        }
        public void setElement(WordEntry w){
            data = w;       
             size++;
        }       
        public Boolean Empty(){
            if (data==null) return true;
            else return false;
        }
        public int getSize(){
            return size;
        }
        
    }

    BucketArray[] hash =new BucketArray[26];
    
    public MyHashTable(){
    
        for(int j=0;j<26;j++){
            hash[j] = new BucketArray();
        }
    }
    
    int getHashIndex(String str){
        char first = str.toLowerCase().charAt(0);
        int asc = (int)first%26 ;
        return asc;
    }
    void addPositionsForWord(WordEntry w){
    
        int pos = getHashIndex(w.string.toLowerCase());
        //System.out.println(w.string.toLowerCase());
        //System.out.println("ak ");
        //System.out.print(hash[pos].Empty()+" ");
        if(hash[pos].Empty()){
            //System.out.println("b ");
            hash[pos].setElement(w);
           //System.out.println( hash[pos].data.string);
            hash[pos].setNext(null);
           // System.out.println(hash[pos].llist.size());
           //System.out.print(hash[pos].getSize()+" ");
            //hash[pos] = hash[pos].llist;
        }else{
        //System.out.println("c");
            //System.out.println("c");
           
            BucketArray temp = hash[pos];
            int flag=0;
            int flag2=0;
           // while(temp.next != null){                
                while(temp.next!=null){
                    if(temp.getElement().string.toLowerCase().equals(w.string.toLowerCase())){
                        temp.getElement().addPositions(w.getAllPositionsForThisWord()); flag=1;
                        break;
                    }
                    temp=temp.next;
                }
                if(temp.next == null){
                    if(temp.getElement().string.toLowerCase().equals(w.string.toLowerCase()) && flag==0){
                        temp.getElement().addPositions(w.getAllPositionsForThisWord()); flag2=1;
                    
                    }
                    if(flag==0 && flag2==0){
                    BucketArray b = new BucketArray(w,null);
                    temp.setNext(b);
                    b.setNext(null);   }
                }
           // } //System.out.println("e");
        }
    }
}
           