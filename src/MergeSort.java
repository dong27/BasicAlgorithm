public class MergeSort {
    //归并排序
    public static void main(String[] args){
            System.out.println("hello git");
    }
    public static void merge(int[] arr,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=high){
            temp[k++]=arr[j++];
        }
        for (int k1=0;k1<temp.length;k1++){
            arr[k1+low]=temp[k1];
        }
    }
    public static void mergeSort(int[] arr,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
}
