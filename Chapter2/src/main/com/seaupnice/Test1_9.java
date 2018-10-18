package main.com.seaupnice;

import main.com.learn.StdIn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test1_9 {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h < N/3) h = 3*h + 1;
        show(a);
        while(h >= 1){
            for(int i = h, j; i < N; i++){
                for(j = i; j >= h && less(a[j], a[j-h]); j-=h){
                    exch(a, j, j-h);
                }
                System.out.print("| "+ i + " |"+ j + " |"); show(a);
            }
            h = h / 3;
            show(a);
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
            FileInputStream input = new FileInputStream("src\\main\\com\\in.txt");
            System.setIn(input);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        String[] a = StdIn.readAllStrings();
        sort(a);

        assert isSorted(a);
        show(a);
    }
}
