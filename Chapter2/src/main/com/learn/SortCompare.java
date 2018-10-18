package main.com.learn;

public class SortCompare {
    public static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        else if(alg.equals("Selection")) Selection.sort(a);
        //else if(alg.equals("Shell")) Shell.sort(a);
        //else if(alg.equals("Merge")) Merge.sort(a);
        //else if(alg.equals("Quick")) Quick.sort(a);
        //else if(alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }
    //使用alg算法将T个长度为N的序列排序
    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t = 0; t < T; t++){
            for(int i = 0; i < N; i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args){
        String alg1 = StdIn.readString(), alg2 = StdIn.readString();
        int N = StdIn.readInt(), T = StdIn.readInt();
        double t1 = timeRandomInput(alg1, N, T),
                t2 = timeRandomInput(alg2, N, T);
        System.out.printf("For %d random Doubles\n    %s is", N, alg1);
        System.out.printf("   %.1f times faster than %s\n",  t2/t1, alg2);
    }
}
