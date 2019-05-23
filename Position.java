import java.lang.*;
import java.io.*;
import java.util.*;
public class Position{
    PageEntry p;
    int wordIndex;
    
    Position(PageEntry p, int wordIndex){
        this.p = p;
        this.wordIndex = wordIndex;
    }
    PageEntry getPageEntry(){
        return p;
    }
    int getWordIndex(){
        return wordIndex;
    }
}