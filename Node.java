import java.util.*;
import java.lang.*;    


public class Node{ 
        int height, balance; 
        Position key; 
        
        Node left, right ,parent; 
        
        Node(){
            left=null;
            right = null;
            key=null;
            height = 0;
        }
        Node(Position d) { 
            key = d; 
            height = 0; 
            setLeft(null);
            setRight(null);
        } 
        void setRight(Node x){
            this.right=x;
        }
        void setLeft(Node x){
            this.left=x;
        }
        void setParent(Node x){
            this.parent = x;
        }
        Node getRight(){
            return right;
        }
        Node getLeft(){
            return left;
        }
        Node getParent(){
            return parent;
        }
        public int compareTo(Node object){
            if(this.key.getWordIndex()<object.key.getWordIndex()) return -1;
            else if(this.key.getWordIndex()==object.key.getWordIndex()) return 0;
            else return 1;
        }
    }