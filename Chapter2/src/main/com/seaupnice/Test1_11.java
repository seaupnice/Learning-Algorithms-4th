package main.com.seaupnice;

import main.com.learn.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test1_11 {
    public static void sort(Comparable[] a){
        int N = a.length;

        /*******************/
        //求h数组
        //h[]数组的个数  由h=3*h+1得
        int num_n = (int)Math.ceil( Math.log(N) / Math.log(3) );
        // +1防止越界
        int[] h = new int[num_n+1];
        h[0] = 1;
        for(int i = 1; i < num_n; i++){
            h[i] = h[i-1]*3 + 1;
        }
        /*******************/

        for(int i = num_n-1; i >= 0; i--){
            //将数组变为h[i]有序
            for(int j = h[i]; j < N; j++){
                //将a[j]插入a[j-h[i]], a[j-2*h[i]]......
                for(int k = j; k >= h[i] && less(a[k], a[k-h[i]]); k-=h[i]){
                    exch(a, k, k-h[i]);
                }
            }
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }
    private static boolean isSorted(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("src\\main\\com\\1_11.txt");
            System.setIn(input);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        String[] a = StdIn.readAllStrings();
        Test1_11.sort(a);
        assert isSorted(a);
        show(a);
    }
}
