public class SelectSort {
    //选择排序
    public static void selectSort(int[] arr){
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int minIndex=i;
            for(int j=minIndex+1;j<len;j++){
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
}
