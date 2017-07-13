/*
Radix Sort 

input : 14 782341 98231 56342 75987 585214 453457 

output : 14 56342 75987 98231 453457 585214 782341 

*/

import java.io.*;
import java.util.*;

public class RedixSort {

    public static void redixSort(int[] ar)
    {       
        int[] tempArray = new int[ar.length];
        for(int place = 1; place <= 100000; place*=10) countSort(ar, tempArray, place);
        // 100000 - number of digits in this number - same as number of time the loop run.
    }  
    
    public static void countSort(int[] array, int[] tempArray, int place) {
        int[] countArray = new int[10];
        for(int i = 0; i < array.length; i++) countArray[(array[i] / place) % 10]++;
        for(int i = 1; i < countArray.length; i++) countArray[i] += countArray[i-1];
        for(int i = array.length-1; i >= 0; i--) tempArray[--countArray[(array[i] / place) % 10]] = array[i];
        for(int i = 0; i < array.length; i++) array[i] = tempArray[i];
    }
}