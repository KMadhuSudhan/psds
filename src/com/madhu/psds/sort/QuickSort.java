package com.madhu.psds.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[] {10, 80, 30, 90, 40, 50, 70};
        int length = a.length;
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a,0,length-1);
        quickSort.printSortedArray(a,length);
    }

    public void sort(int[] array,int lb,int ub) {
      if(lb < ub) {
          int partition = partition(array,lb,ub);
          sort(array,lb,partition-1);
          sort(array,partition+1,ub);
      }
    }

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    int partitionFirstPivot ( int A[],int start ,int end) {
        int i = start + 1;
        int piv = A[start] ;            //make the first element as pivot element.
        for(int j =start + 1; j <= end ; j++ )  {
    /*rearrange the array by putting elements which are less than pivot
       on one side and which are greater that on other. */

            if ( A[ j ] < piv) {
                int temp1 = A[ i ];
                A[ i ] = A[ j];
                A[ j] = temp1;
                i += 1;
            }
        }
        int temp = A[ start ];
        A[ start ] = A[ i-1];
        A[ i-1] = temp;
//        swap ( A[ start ] ,A[ i-1 ] ) ;  //put the pivot element in its proper place.
        return i-1;                      //return the position of the pivot
    }

    public  void printSortedArray(int[] array,int length) {
        for(int i=0;i<length;i++) {
            System.out.print(" " + array[i]);
        }
    }
}
