/*  代码包含一道题解
 *  test2_3
 *  注释已经标明
 *  input file in.txt is
 *  E A S Y Q U E S T I O N
 * */
package main.com.learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MergeBU {
    private static int count;
    //自底向上，，循序渐进
    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        int N = a.length;
        for(int sz = 1; sz < N; sz+=sz){
            //System.out.print(sz);
            for(int lo = 0; lo < N-sz; lo+=sz+sz){
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1)); // min防止越界


                // test2_3题解
                //System.out.print("|merge(a, "+lo+", "+(lo+sz-1)+", "+Math.min(lo+sz+sz-1, N-1)+")     |");
                //show(a);
                // test2_3题解 end
            }
        }
    }
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] aux = new Comparable[a.length];
        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
            count+=2;
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid)     a[k] = aux[j++];
            else if(j > hi)     a[k] = aux[i++];
            else if(less(aux[j], aux[i])){
                a[k] = aux[j++];
                count+=2;
            }
            else        a[k] = aux[i++];
            count+=2;
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    public static int visitarray(Comparable[] a){
        count = 0;
        sort(a);
        return count;
    }
    private static void show(Comparable[] a){
        count = 0;
        for(Comparable i : a){
            System.out.print(i + "  ");
        }
        System.out.println(" |");
    }
    public static void main(String[] args){
        try{
            FileInputStream input = new FileInputStream("src\\main\\com\\in.txt");
            System.setIn(input);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String[] a = StdIn.readAllStrings();
        MergeBU.sort(a);
    }
}
