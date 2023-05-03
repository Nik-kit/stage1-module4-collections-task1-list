package com.epam.mjc.collections.list;

import java.util.Comparator;
import java.util.List;

public class ListSorter {
    public void sort(List<String> sourceList) {

        ListComparator listComparator = new ListComparator();
        boolean isSorted = false;
        String buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < sourceList.size()-1; i++) {
                if(listComparator.compare(sourceList.get(i), sourceList.get(i+1)) == 1){
                    isSorted = false;

                    buf = sourceList.get(i);
                    sourceList.set(i, sourceList.get(i+1));
                    sourceList.set(i+1, buf);
                } else if(Math.abs(Integer.parseInt(sourceList.get(i))) == Math.abs(Integer.parseInt(sourceList.get(i+1)))
                            && Integer.parseInt(sourceList.get(i)) > Integer.parseInt(sourceList.get(i+1))){
                    isSorted = false;
                    buf = sourceList.get(i);
                    sourceList.set(i, sourceList.get(i+1));
                    sourceList.set(i+1, buf);
                }
            }
        }

    }
}

class ListComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {

        if(Math.abs(Integer.parseInt(a)) > Math.abs(Integer.parseInt(b))){
            return 1;
        } else {
            return 0;
        }

    }
}
