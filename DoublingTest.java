package edu.princeton.cs.algs4;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private DoublingTest() { }

    /**
     * Returns the amount of time to call <tt>ThreeSum.count()</tt> with <em>N</em>
     * random 6-digit integers.
     * @param N the number of integers
     * @return amount of time (in seconds) to call <tt>ThreeSum.count()</tt>
     *   with <em>N</em> random 6-digit integers
     */
    public static double timeTrial(int N) {
        Integer[] a = new Integer [N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        Quick.sort(a);
        return timer.elapsedTime();
    }
    public static double timeTrial1(int N) {
        Integer[] a = new Integer [N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        QuickWithMedian3.sort(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call <tt>ThreeSum.count()</tt>
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     */
    public static void main(String[] args) { 
    	System.out.println("Unimproved QuickSort Doubling Test Result");
        for (int N = 250; N<=32768000; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        } 
        System.out.println("Improved with Median3 Quicksort Doubling Test Result");
        for (int N = 250; N<=32768000; N += N) {
            double time = timeTrial1(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        } 
    } 
} 
