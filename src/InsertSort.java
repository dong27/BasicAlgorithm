public class InsertSort {
    //插入排序
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            int target=arr[i];
            while (j>0&&target<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=target;
        }
    }
}
