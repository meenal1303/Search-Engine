/*Write a Java class PageEntry to store the the information related to a
webpage. It should contain following methods:
– PageEntry(String pageName): Constructor method. The argu-
ment is the name of the document. Read this file, and create the
page index.
– PageIndex getPageIndex(): This method returns the page in-
dex of this web-page.*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class PageEntry{
//System.out.println("hee");
    PageIndex index = new PageIndex();
    MyLinkedList<Integer> cPos = new MyLinkedList<>();
    String name;
    MyLinkedList<String> connectors = new MyLinkedList<>();
    MyLinkedList<String> punctuations = new MyLinkedList<>();
    MyLinkedList<String> webpage = new MyLinkedList<>(); //link list of all webpages
    //InvertedPageIndex inv = new InvertedPageIndex();
    int total;
    
    
    public PageEntry(String pageName){
    
        connectors.addLast("a"); connectors.addLast("an"); connectors.addLast("the"); connectors.addLast("they"); connectors.addLast("these"); connectors.addLast("this");connectors.addLast("for"); connectors.addLast("is"); connectors.addLast("are"); connectors.addLast("was"); connectors.addLast("of"); connectors.addLast("or"); connectors.addLast("and"); connectors.addLast("does"); connectors.addLast("will"); connectors.addLast("whose");
        
        punctuations.addLast("{"); punctuations.addLast("}"); punctuations.addLast("["); punctuations.addLast("]"); punctuations.addLast("<"); punctuations.addLast(">"); punctuations.addLast("="); punctuations.addLast("("); punctuations.addLast(")"); punctuations.addLast("\""); punctuations.addLast("."); punctuations.addLast(","); punctuations.addLast(";"); punctuations.addLast("'"); punctuations.addLast("?"); punctuations.addLast("#"); punctuations.addLast("!"); punctuations.addLast("-"); punctuations.addLast(":"); 
    
    
        total = 0;
        this.name = pageName;
        webpage.addLast(pageName);
        
        try{
        //System.out.println("hee");
        FileReader fil=new FileReader("webpages/"+pageName);
       // System.out.println("h");
        webpage.addLast(pageName);
        Scanner s=new Scanner(fil);
        //System.out.println("rr");
        int i=0;
                
        //System.out.println("ss");
           
           
           while(s.hasNextLine()){
                    String a = s.nextLine();
                    a = a.toLowerCase();
          // Scanner s2 = new Scanner(a);
            //while(s2.hasNext()){   
                //System.out.println("b");
    
                int f=0;
                //String recent;
                while(f<a.length()){
                    String dd = "";
                    dd = dd + a.charAt(f);
                    if(punctuations.contains(dd)){
                        if(f==0){
                            a = " "+a.substring(1,a.length());
                        }
                        if(f==a.length()-1){
                            a = a.substring(0,a.length()-1) + " ";
                        }else{ a = a.substring(0,f) + " " + a.substring(f+1,a.length());}
                        
                    }
                    f++;
                }
                
              //    = s2.next();   
                //}
                //int k=0;
                Scanner r = new Scanner(a);
                while(r.hasNext()){
                    String tt = r.next();
                    total++;
                    i++;
                    if(tt.equals("stacks")){
                        tt = "stack";
                    }
                    if(tt.equals("structures")){
                        tt = "structure";
                    }
                    if(tt.equals("applications")){
                        tt = "application";
                    }
                    
                    if(!connectors.contains(tt)){
                    //System.out.println("tt");
                        Position ps = new Position(this,i);
                        this.index.addPositionForWord(tt, ps);
                        //System.out.println(tt);
                        
                    }else{
                        cPos.addLast(i);
                        //System.out.println("123");
                    }
                }
                //a = s.nextLine();
            }//System.out.println();
                
    //hmap.put(sc,index.pIndex.entries); 
        }catch(Exception e){System.out.println("ERROR FOUND in page Entry");}
    }
    
    PageIndex getPageIndex(){
        
        return index;
    }
    float getTermFrequency(String word){
        //System.out.println("sz = "+cPos.size());
        //if(word.toLowerCase().equals("applications")) word="application";
        
        int sz = this.total-this.cPos.size();
        //System.out.println(total);
        int wd=0;
        //System.out.println(this.name);
        for(int i=0;i<this.getPageIndex().getWordEntries().size();i++){
            if(this.getPageIndex().getWordEntries().get(i).string.equals(word.toLowerCase())){
                //System.out.println(this.index.pIndex.get(i).string);
                wd=this.index.pIndex.get(i).entries.size();
                
                //System.out.println(wd);
                break;
                //System.out.println("tttttttttttttttt"+this.index.pIndex.get(i).entries.get(0).getWordIndex());
                //System.out.println("tttttttttttttttt"+this.index.pIndex.get(i).entries.get(1).getWordI
            }
        }
        //System.out.println(wd);
        //System.out.println("gtf "+this.name+(float)wd/sz);
        //float freq = wd/sz;
        if(wd==0) return 0.0f;
        else
        return (float)wd/sz;
        
        //return freq;
    }
     
    int countOfPhraseInAPage(String str[]){
       
        WordEntry w;
        MyLinkedList<Position> fin = new MyLinkedList<>();

            int count=0;
            MyLinkedList<WordEntry> got = this.getPageIndex().getWordEntries();
            
            for(int j=0;j<got.size();j++){
                if(got.get(j).string.toLowerCase().equals(str[0].toLowerCase())){
                    fin = got.get(j).entries;                    
                }
            }
            for(int t=0;t<fin.size();t++){
                int l=1;
                int d=fin.get(t).getWordIndex()+1;
                while(l<str.length){
                
                    while(this.cPos.contains(d)){
                        d++;
                    }
                        w = this.getPageIndex().getWordEntryFromName(str[l]);
                        //Node nn = new Node(w.entries.get(0));
                        if(w.avl.find(d,w.avl.root)==true){
                            l++;
                            d++;
                        }else break;
                    }
                    if(l==str.length) count++;
                }
                System.out.println(count);
                 return count;
            }
    
    float getRelevanceOfPage(String str[], boolean doTheseWordsRepresentAPhrase){
    /*float getRelevanceOfPage(String str[ ], boolean doThese-
    WordsRepresentAPhrase): Return the relevance of the webpage
    for a group of words represented by the array str[ ]. If the flag
    doTheseWordsRepresentAPhrase is true, it means that the words
    represent a phrase; otherwise the words are part of a complex
    query (AND/OR).*/
    if(doTheseWordsRepresentAPhrase == true){
        float idf = 0.0f;
        idf=(float)Math.log((float)(InvertedPageIndex.invPageIn.list.size())/(float)InvertedPageIndex.getPagesWhichContainPhrase(str).list.size());
        //System.out.println("idf = "+idf);
        int m = this.countOfPhraseInAPage(str); 
        //System.out.println("m = "+m);
        
        int k = str.length;
        //System.out.println("k = "+k);
        int w = this.total;
        //System.out.println("total = "+total);
        
        float tf = (float)m/(float)(w - (k-1)*m) ;
        //System.out.println("relevance in a phrase for page "+this.name+" = "+idf*tf);
        return idf*tf;
    
    }else{
        float ret=0.0f;
        for(int k=0;k<str.length;k++){
            
            ret=ret+InvertedPageIndex.relevance(this,str[k]);
            //System.out.println("relevance for = "+str[k]+" = "+InvertedPageIndex.relevance(this,str[k]));
        }
        //System.out.println("relevance of "+this.name+" = "+ret);
        return ret;
    }
    }
    
    float getRelevanceOfPage2(String str){
        float ret=0.0f;
        ret = InvertedPageIndex.relevance(this,str);
        System.out.println("relevance of "+this.name+" = "+ret);
        return ret;
    }
    
}
