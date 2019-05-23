import java.lang.*;
import java.util.*;
import java.io.*;
/*For a string str, this class stores the list
of word indice’s where str is present in the document(s).
WordEntry(String word): Constructor method. The argument
is the word for which we are creating the word entry.
– void addPosition(Position position): Add a position entry
for str.
– void addPositions(MyLinkedList<Position> positions): Add
multiple position entries for str.
– MyLinkedList<Position> getAllPositionsForThisWord(): Re-
turn a linked list of all position entries for str.
– float getTermFrequency(String word): Return the term fre-
quency of the word in a webpage.
*/

public class WordEntry{

    String string;
    MyLinkedList<Position> entries = new MyLinkedList<>();
    avlTree avl = new avlTree();
    WordEntry(String word){
        string = word.toLowerCase();
    }
    void addPosition(Position position){
       try{ entries.addLast(position);
         if(entries.size()==1){
         //System.out.println("f1");
            Node r = new Node(position);
            avl.setRoot(r);
            //System.out.println("f2");
         }else{
         //System.out.println("f3");
        Node n1 = new Node(position);
        //System.out.println("f4");
        avl.insert(n1); 
        //System.out.println("f5");
        //entries.addLast(position);
        }}catch(Exception e){System.out.println("fr");}
    }
    void addPositions(MyLinkedList<Position> positions){
        int i = positions.size();
        int j=0;
        while(j<i){
            entries.addLast(positions.get(j));
            j++;
        }
    }
    MyLinkedList<Position> getAllPositionsForThisWord(){
        return entries;
    }
    
    
}