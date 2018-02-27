/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author toledo
 */
public class Mergesort {
    static int [] Sort;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3};
        if(arr.length==1){
            printSort(arr);
        }
        else{
            divide(arr, 0, arr.length-1);
            printSort(Sort);
        }
    } 
    static void merge(int arr[], int left, int middle, int right) {
        // Find sizes of two subarrays to be merged
        Sort=arr;
        int leftPart = middle - left + 1;
        int rightPart = right - middle;
 
        /* Create temp arrays */
        int leftArray[] = new int [leftPart];
        int rightArray[] = new int [rightPart];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<leftPart; i++){
            leftArray[i] = arr[left + i];
        }
        for (int j=0; j<rightPart; j++){
            rightArray[j] = arr[middle + 1+ j];
        }
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = left;
        while (i < leftPart && j < rightPart){
            if (leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }else{
                arr[k] = rightArray[j];
                j++;                
            }
            k++;
        }
        while (i < leftPart)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < rightPart)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
 
    
    // Main function that sorts arr[l..r] using
    // merge()
    static void divide(int arr[], int left, int right){
        if (left < right)
        {
            // Find the middle point
            int middle = (left+right)/2;
 
            // Sort first and second halves
            divide(arr, left, middle);
            divide(arr , middle+1, right);
 
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }
    
    static void printSort(int [] numbers){
        JOptionPane.showMessageDialog(null,Arrays.toString(numbers));
    }
}
