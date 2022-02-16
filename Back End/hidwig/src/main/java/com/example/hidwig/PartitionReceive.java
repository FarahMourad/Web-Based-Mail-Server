package com.example.hidwig;

import java.util.List;

public class PartitionReceive extends Partition implements IPartition {
    public void performQuickSort(List<Mail> array,int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        String pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2).getReceiver();

        while (i <= j) {

            while ((array.get( i ).getReceiver()).compareTo( pivot )<0 ) {
                i++;
            }
            while ((array.get( j).getReceiver()) .compareTo(pivot)>0 ) {
                j--;
            }
            if (i <= j) {
                swap(array,i, j);
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
