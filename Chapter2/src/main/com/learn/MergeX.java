/*
 *  带优化的Merge
 * */
package main.com.learn;

public class MergeX {
    private static final int CUTOFF = 7;
    public static void sort(Comparable[] a){
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }
    private static void sort(Comparable[]a, Comparable[] aux, int lo, int hi){
        //优化1
        if(hi <= lo + CUTOFF){
                Insertion.sort(aux);
                return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid+1, hi);
        //优化2
        if(!less(a[mid+1], a[mid])){
            System.arraycopy(a, lo, aux, lo, hi-lo+1);
        }
        //优化3
        merge(a, aux, lo, mid, hi);
    }
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++){
            if(i > mid) aux[k] = a[j++];
            else if(j > hi) aux[k] = a[i++];
            else if(less(a[j], a[i])) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
    private static void show(Comparable[] a){
        for (Comparable i : a){
            System.out.print(i + "  ");
        }
        System.out.println();
    }
    private static boolean isSorted(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        int N = 100, n = 10;
        for(int i = 0; i < n; i++){
            Comparable[] a = new Comparable[N];
            for(int j = 0; j < N; j++){
                a[j] = StdRandom.uniform(N);
            }
            MergeX.sort(a);
            if(!isSorted(a)){
                System.out.println("false sorted!");
            }
        }
    }
}
