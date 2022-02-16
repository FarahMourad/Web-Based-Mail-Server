package com.example.hidwig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

public class PartitionDate extends Partition implements IPartition {
    public void performQuickSort(List<Mail> array,int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        //String pivot = "2020-12-26:09:47:00";
        String pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2).getDates();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH);
        LocalDateTime dateBefore =LocalDateTime.parse(pivot, dtf);
        LocalDateTime dateAfter = LocalDateTime.now();
        long noOfSecsBetween = ChronoUnit.SECONDS.between(dateBefore, dateAfter);
        System.out.println(noOfSecsBetween);


        while (i <= j) {
            String date1 = array.get(i).getDates();
            LocalDateTime dateBefore1 =LocalDateTime.parse(date1, dtf);
            LocalDateTime dateAfter1 = LocalDateTime.now();
            long noOfSecsBetween1 = ChronoUnit.SECONDS.between(dateBefore1, dateAfter1);

            String date2 = array.get(j).getDates();
            LocalDateTime dateBefore2 =LocalDateTime.parse(date2, dtf);
            LocalDateTime dateAfter2 = LocalDateTime.now();
            long noOfSecsBetween2 = ChronoUnit.SECONDS.between(dateBefore2, dateAfter2);
            while (noOfSecsBetween1< noOfSecsBetween ) {

                i++;
                date1 = array.get(i).getDates();
                dateBefore1 =LocalDateTime.parse(date1, dtf);
                dateAfter1 = LocalDateTime.now();
                noOfSecsBetween1 = ChronoUnit.SECONDS.between(dateBefore1, dateAfter1);
            }
            while (noOfSecsBetween2 >(noOfSecsBetween) ) {
                j--;
                date2 = array.get(j).getDates();
                dateBefore2 =LocalDateTime.parse(date2, dtf);
                dateAfter2 = LocalDateTime.now();
                noOfSecsBetween2 = ChronoUnit.SECONDS.between(dateBefore2, dateAfter2);
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
