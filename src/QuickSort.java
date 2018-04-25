public class QuickSort {
    //快速排序
    public static void quickSort(int[] arr,int low,int high){
        int start=low;
        int end=high;
        int key=arr[low];
        while (start<end){
            while (end>start&&arr[end]>=key){
                end--;
            }
            if(arr[end]<=key){
                int temp=arr[end];
                arr[end]=arr[start];
                arr[start]=temp;
            }
            while (end>start&&arr[start]<=key)
                start++;
            if(arr[start]>=key){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
        }
        if(start>low) quickSort(arr,low,start-1);
        if(end<high) quickSort(arr,end+1,high);
    }
}
