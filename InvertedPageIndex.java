import java.lang.*;
import java.util.*;
import java.io.*;
/*Write a Java class InvertedPageIndex which contains the following
methods:
– void addPage(PageEntry p): Add a new page entry p to the
inverted page index.
– MySet<PageEntry> getPagesWhichContainWord(String str):
Return a set of page-entries of webpages which contain the word
str.
*/
class InvertedPageIndex{
    static MySet<PageEntry> invPageIn = new MySet<>();
    //PageEntry ww=new PageEntry();
    static MyHashTable ht = new MyHashTable();
    
    
    static void addPage(PageEntry p){
    //System.out.println("Debug");
        invPageIn.addElement(p);
        //System.out.println(invPageIn.list.size());
        if(p.getPageIndex().getWordEntries() !=null){
        //System.out.println("Dd");
        MyLinkedList<WordEntry> store = p.getPageIndex().getWordEntries();
        int size = store.size();
        //System.out.println(size);z
        int m=0;
            while(m<size){
                WordEntry ww = store.get(m);
                //System.out.println("add");
                ht.addPositionsForWord(ww);
                
                m++;
                //System.out.println(m+ " = m");
            }
        }
    }
    static MySet<PageEntry> getPagesWhichContainWord(String str){
        //MyLinkedList<WordEntry> get = p.getPageIndex().getWordEntries();
        int sz = invPageIn.list.size();
        MySet<PageEntry> pg = new MySet<>();
        int t = 0;
        //System.out.println("sz= "+sz);
        while(t<sz){
        //System.out.println("kk");
        //System.out.println(sz);
        //System.out.println(invPageIn.list.get(t).name);
            MyLinkedList<WordEntry> got = invPageIn.list.get(t).getPageIndex().getWordEntries();
          //  System.out.println("ff");
            //System.out.println(invPageIn.list.get(t).name);
            int qs = got.size(); int j=0;
            //System.out.println(qs);
            while(j<qs){
                if(got.get(j).string.toLowerCase().equals(str.toLowerCase())){
               //     System.out.println("yes");
                    pg.addElement(invPageIn.list.get(t));
                //    System.out.println(pg.list.size());
                    break;
                }
                j++;
            }        
            t++;
        }
        //System.out.println("pg = "+pg.list.size());
        return pg;        
    }
    
    static float inverseDocumentFrequency(String word){
        
        int totalPages = invPageIn.list.size();
        
        int nw=0;//number of webpages that contain word w
        nw = getPagesWhichContainWord(word.toLowerCase()).list.size();
        //System.out.println("nw=  "+nw);
        /*for(int j=0;j<totalPages;j++){
            MyLinkedList<WordEntry> SI= invPageIn.list.get(j).index.getWordEntries();
            int loop = SI.size();
        
            for(int k=0;k<loop;k++){
                if(SI.get(k).string.toLowerCase().equals(word.toLowerCase())){
                    System.out.println("yes");
                    nw++;
                    break;
                }
            }    
        }*/
        //System.out.println(nw);
        //System.out.println(totalPages);
        //double nwf = Math.log(nw);
        if(nw==0){ //System.out.println("tgt");
            return 0.0f;
           
        }else {//System.out.println("nw = "+(float)Math.log(totalPages/(nw)));
        //System.out.println("total = "+Math.log(4/3.05));
        
       // System.out.println("idfe = "+(float)Math.log(totalPages/(nw)));
        return (float)Math.log((float)totalPages/(float)nw);}
    }
    
    static float relevance(PageEntry p,String w){
        return(inverseDocumentFrequency(w) * p.getTermFrequency(w));
    }
    
    static MySet<PageEntry>getPagesWhichContainPhrase(String str[]){
        MySet<PageEntry> ret = new MySet<>();
        MySet<PageEntry> pg = new MySet<>();
        
        pg = getPagesWhichContainWord(str[0]);
        WordEntry w;
        MyLinkedList<Position> fin = new MyLinkedList<>();
        for(int k=0;k<pg.list.size();k++){
        int count=0;
            PageEntry st = pg.list.get(k);
            MyLinkedList<WordEntry> got = st.getPageIndex().getWordEntries();
            
            for(int j=0;j<got.size();j++){
                if(got.get(j).string.toLowerCase().equals(str[0].toLowerCase())){
                    
                    fin = got.get(j).entries;                    
                    /*for(int z=0;z<sec.size();z++){
                        if(sec.get(z).getPageEntry().name.equals(st.name)){
                            fin.addLast(sec.get(z));
                        }
                    }*/
                }
            }
            for(int t=0;t<fin.size();t++){
            //System.out.println(fin.size());
            int d=fin.get(t).getWordIndex()+1;
                int l=1;
                while(l<str.length){
                
                //System.out.println("d = "+d);
                    while(st.cPos.contains(d)){
                        d++;
                    }
                        if(st.getPageIndex().containWE(str[l])){
                        w = st.getPageIndex().getWordEntryFromName(str[l]);
                        
                        //System.out.println(w.avl.find(d,w.avl.root));
                        //System.out.println(str[l]);
                        //System.out.println("ut "+w.avl.root.getRight().key.getWordIndex());
                        //Node nn = new Node(w.entries.get(0));
                        
                        if(w.avl.find(d,w.avl.root)==true){
                        //System.out.println(" go ");
                            l++;
                           
                        }else break;
                        d++;
                        }
                        else break;
                    }if(l==str.length && count==0) ret.list.addLast(st);
                    if(l==str.length) count++;
                }
            }return ret; 
            }
            
            
        }
                         /*MyLinkedList<WordEntry> got2 = st.getPageIndex().getWordEntries();
                         for(int s=0;s<got2.size();s++){
                            if(got.get(s).string.toLowerCase().equals(str[l].toLowerCase())){
                                w = got.get(s);
                            }
                            break;
                         }
                         while(d<got2.size()){
                            if(got.get(d).string.toLowerCase().equals(str[l].toLowerCase())){
                                w = got.get(d);
                                if(w.avl.find(d,w.entries.get(0)))==true{
                                    l++;
                                    d++;
                                }
                            }else break;
                    } if(l==str.length) ret.list.addLast(st); */
    