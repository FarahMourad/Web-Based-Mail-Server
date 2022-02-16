package com.example.hidwig;

import java.util.List;

public class Partition {
    static void swap(List arr, int i, int j) {
            Mail temp = (Mail) arr.get( i );
            arr.set( i, arr.get( j ) );
            arr.set( j, temp );
    }
    static void swapC(List arr, int i, int j) {
        Contacts temp = (Contacts) arr.get( i );
        arr.set( i, arr.get( j ) );
        arr.set( j, temp );
    }

}
