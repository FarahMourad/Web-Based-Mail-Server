package com.example.hidwig;

import java.util.List;

public class PartitionMailCont extends Partition implements IPartitionCont{

    public void performQuickSort(List<Contacts> array, int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        String pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2).getEmail();

        while (i <= j) {

            while ((array.get( i ).getEmail()).compareTo( pivot )<0 ) {
                i++;
            }
            while ((array.get( j).getEmail()) .compareTo(pivot)>0 ) {
                j--;
            }
            if (i <= j) {
                swapC(array,i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j)
            performQuickSort(array,lowerIndex, j);
        if (i < higherIndex)
            performQuickSort(array,i, higherIndex);
    }
}