import java.lang.*;
import java.util.*;
import java.io.*;
/*Write a Java class PageIndex which stores one word-entry for each
unique word in the document.
– void addPositionForWord(String str, Position p): Add po-
sition p to the word-entry of str. If a word entry for str is already
present in the page index, then add p to the word entry. Other-
wise, create a new word-entry for str with just one position entry
p.
– LinkedList<WordEntry> getWordEntries(): Return a list of
all word entries stored in the page index.*/

public class PageIndex extends MyLinkedList<WordEntry>{
    
    MyLinkedList<WordEntry> pIndex = new MyLinkedList<>();
   
    
    void addPositionForWord(String str, Position p){
        int i=0;
        for(i=0;i<pIndex.size();){
            if(!pIndex.get(i).string.equals(str.toLowerCase())){
                i++;
            }
            else break;
        }
        if(i<pIndex.size()){
            pIndex.get(i).addPosition(p);
        }
        else {
            WordEntry k = new WordEntry(str);
            k.addPosition(p);
            pIndex.addLast(k);
        }
    }
    MyLinkedList<WordEntry> getWordEntries(){
        return pIndex;
    }
    
    Boolean containWE(String str){
        int i = pIndex.size();
        if(pIndex!=null){
        int j;
        for(j=0;j<i;j++){
            if(pIndex.get(j).string.equals(str.toLowerCase())){
                return true;
            }
        } if(j==i) return false;
        }
        return false;
    }
    
    WordEntry getWordEntryFromName(String str){
        int i = pIndex.size();
        if(pIndex!=null){
        int j;
        for(j=0;j<i;j++){
            if(pIndex.get(j).string.equals(str.toLowerCase())){
                return pIndex.get(j);
            }
        } if(j==i) return null;
        }
        return null;
    }
}