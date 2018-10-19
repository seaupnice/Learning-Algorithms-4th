/*
* in.txt
* 4 100 1000 10000 100000
* */
package main.com.seaupnice;

import main.com.learn.StdIn;
import main.com.learn.StdRandom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Test1_12 {
    public static void sort(Comparable[] a){
        int N = a.length;
        Map<Comparable, Integer> mp = new HashMap<>(100);
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        while(h >= 1){
            for(int i = h; i < N; i++){
                for(int j = i; j >= h && less(a[j], a[j-h]); j-=h) {
                    /****************************/
                    // the function is count number.
                    Integer count = mp.get(h);
                    mp.put(h, count == null ? 1 : count+1);
                    /*****************************/
                    Test1_12.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }

        assert Test1_12.isSorted(a);
        ///show answer
        for(Map.Entry<Comparable, Integer> entry : mp.entrySet()){
            System.out.println("h =  "+entry.getKey()+ "      比值 =  " + entry.getValue()*1.0/N);
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
            FileInputStream input = new FileInputStream("src\\main\\com\\1_12.txt");
            System.setIn(input);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        int N = StdIn.readInt();
        for(int i = 0; i < N; i++){
            int n = StdIn.readInt();
            System.out.println("N = " + n);
            Double[] a = new Double[n];
            for(int j = 0; j < n; j++){
                a[j] = StdRandom.uniform();
            }
            Test1_12.sort(a);
            System.out.println();
        }
    }
}
