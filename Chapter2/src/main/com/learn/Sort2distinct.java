/*
 * 排序只有两种主键的数组
 */
package main.com.learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sort2distinct {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while(i < j){
            if(less(a[i], v)){ exch(a, i, lo); break; }
            i++;
        }
        i = lo;  v = a[lo];      //找到最小元素并置于首位
        while(true){
            while(v.equals(a[++i])) if(i == hi) break;
            while(!v.equals(a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
    }
    private static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i]; a[i] = a[j]; a[j] = tmp;
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }
    private static void show(Comparable[] a){
        for (Comparable i : a){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int N = 100;
        for(int i = 0; i < 100; i++){
            Comparable[] a = new Comparable[N];
            for(int j = 0; j < N; j++){
                a[j] = StdRandom.uniform(2);
            }
            Sort2distinct.sort(a);
            if(!isSorted(a)){
                System.out.println("no");
            }
        }
    }
}