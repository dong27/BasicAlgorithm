/**
 * 八皇后问题
 */
public class Empress {
    static int max=8; //皇后的个数，可以扩展到N皇后问题
    static int[] array=new int[max]; //皇后i放置在array[i]列中
    static int sum=0; //所有可能的组合数
    public static void main(String[] args){
        traceBack(0);
        System.out.println("Sum "+sum);
    }

    /**
     * 判断第n列是否可放
     * @param n
     * @return
     */
    public static boolean place(int n){
        for(int i=0;i<n;i++){
            if(Math.abs(n-i)==Math.abs(array[n]-array[i])||array[n]==array[i]){
                return false; //判断是否在同一对角线或者同一列上，若是则返回false
            }
        }
        return true;
    }
    public static void traceBack(int n){
        if(n==max){
            sum++;
            System.out.println("方案 "+sum);
            print();
            return;
        }
        else {
            for (int i=0;i<max;i++){
                array[n]=i;
                if(place(n)){
                    traceBack(n+1);
                }
            }
        }
    }
    public static void print(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+1+" ");
        }
        System.out.println();
    }
}
