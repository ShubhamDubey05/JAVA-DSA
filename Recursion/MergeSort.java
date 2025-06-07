package com.Shubham


public class MergeSort {
  public static  void divide(int arr[] , int low, int high){
           if(low == high){
            return;
           }
           int mid =  (low+high)/2;
           divide(arr, low, mid);
           divide(arr, mid+1, high);
           merge(arr, low, mid, high);

  }

  public static  void merge(int arr[], int low, int mid,  int high){
           int [] merged = new int [high - low +1];
           int left = low;
           int right = mid+1;
           int k =0;
           while(left <=mid && right <=high){
            if(arr[left] <= arr[right]){
              merged[k] = arr[left];
               left++;
            }
            else {
                merged[k] = arr[right];
                right++;
            }
            k++;
           }
           while(left <= mid){
             merged[k] = arr[left];
               left++;
               k++;
           }
           while(right <= high){
             merged[k] = arr[right];
               right++;
               k++;
           }
           for(int i =0 ; i<merged.length; i++){
               arr[i+low] = merged[i];
           }
             
  }
  public static void main(String[] args) {


    int[] arr = {5, 7, 8, 3, 4, 2, 1};
    int n = arr.length;
     for(int val : arr){
      System.out.print(val+" ");
     }
     System.out.println();
     divide(arr, 0, n-1);
   for(int val : arr){
    System.out.print(val +" ");
   }
  
}
  
}
