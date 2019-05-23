import java.util.*;
import java.lang.*;
import java.io.*;

public class MySort{

    ArrayList<SearchResult> sortThisList(MySet<SearchResult> listOfSortableEntries){
    /*Given a set of Sortable objects, this method
    returns a sorted list of objects. The list is represented as Java’s
    ArrayList where the following relation holds: if a<b,
    sortedlist.get(a).getNumber() >= sortedlist.get(b).getNumber().
    You can implement any sorting algorithm that you want. Your
    SearchEngine class should use the MySort class to sort the set of
    pages on the basis of the relevance criteria.*/
    
        ArrayList<SearchResult> sortedList = new ArrayList<>();
        int size = listOfSortableEntries.list.size();
        for(int k=0;k<size;k++){
            sortedList.add(listOfSortableEntries.list.get(k));
        }
        Collections.sort(sortedList);
        return sortedList;
    }
}