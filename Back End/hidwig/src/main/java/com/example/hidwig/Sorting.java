package com.example.hidwig;

import java.lang.*;
import java.util.*;
public class Sorting {

    private int length;
    public void sort(List inputArrayArr, String typeOfSort) {
        if (inputArrayArr == null || inputArrayArr.size() == 0) {
            return;
        }

       // this.array = inputArrayArr;
        length = inputArrayArr.size();
        PartitionFactory f = new PartitionFactory();
        IPartition p ;
        IPartitionCont q;
        if(typeOfSort.equals("NameCont")||typeOfSort.equals("MailCont"))
        {
            q = f.getInstanceCont( typeOfSort );
            q.performQuickSort(inputArrayArr,0, length - 1);
        }
        else{
            p =  f.getInstance(typeOfSort);
            p.performQuickSort(inputArrayArr,0, length - 1);
        }


    }


}
