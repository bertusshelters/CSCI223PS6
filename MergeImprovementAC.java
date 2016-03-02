package edu.princeton.cs.algs4;

public class MergeImprovementAC {

	
	    private static final int CUTOFF = 7;  // cutoff to insertion sort

	    // This class should not be instantiated.
	    private MergeImprovementAC() { }

	    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {

	        // precondition: src[lo .. mid] and src[mid+1 .. hi] are sorted subarrays
	        assert isSorted(src, lo, mid);
	        assert isSorted(src, mid+1, hi);

	        int i = lo, j = mid+1;
	        for (int k = lo; k <= hi; k++) {
	            if      (i > mid)              dst[k] = src[j++];
	            else if (j > hi)               dst[k] = src[i++];
	            else if (less(src[j], src[i])) dst[k] = src[j++];   // to ensure stability
	            else                           dst[k] = src[i++];
	        }

	        // postcondition: dst[lo .. hi] is sorted subarray
	        assert isSorted(dst, lo, hi);
	    }

	    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
	        // if (hi <= lo) return;
	        if (hi <= lo + CUTOFF) { 
	            insertionSort(dst, lo, hi);
	            return;
	        }
	        int mid = lo + (hi - lo) / 2;
	        sort(dst, src, lo, mid);
	        sort(dst, src, mid+1, hi);
	        merge(src, dst, lo, mid, hi);
	    }

	    /**
	     * Rearranges the array in ascending order, using the natural order.
	     * @param a the array to be sorted
	     */
	    public static void sort(Comparable[] a) {
	        Comparable[] aux = a.clone();
	        sort(aux, a, 0, a.length-1);  
	        assert isSorted(a);
	    }

	    // sort from a[lo] to a[hi] using insertion sort
	    private static void insertionSort(Comparable[] a, int lo, int hi) {
	        for (int i = lo; i <= hi; i++)
	            for (int j = i; j > lo && less(a[j], a[j-1]); j--)
	                exch(a, j, j-1);
	    }


	    /*******************************************************************
	     *  Utility methods.
	     *******************************************************************/

	    // exchange a[i] and a[j]
	    private static void exch(Object[] a, int i, int j) {
	        Object swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

	    // is a[i] < a[j]?
	    private static boolean less(Comparable a, Comparable b) {
	        return a.compareTo(b) < 0;
	    }


	    private static boolean isSorted(Comparable[] a) {
	        return isSorted(a, 0, a.length - 1);
	    }

	    private static boolean isSorted(Comparable[] a, int lo, int hi) {
	        for (int i = lo + 1; i <= hi; i++)
	            if (less(a[i], a[i-1])) return false;
	        return true;
	    }
}