//Merge Improvement A -Cutoff to Insertion Sort for small subarrays 
package edu.princeton.cs.algs4;


public class MergeImprovementA {  
	private static final int CUTOFF = 7; // cutoff to insertion sort 
	private void Merge() { }

// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    // copy to aux[]
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k]; 
    }

    // merge back to a[]
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
        if      (i > mid)              a[k] = aux[j++];
        else if (j > hi)               a[k] = aux[i++];
        else if (less(aux[j], aux[i])) a[k] = aux[j++];
        else                           a[k] = aux[i++];
    }

    // postcondition: a[lo .. hi] is sorted
    assert isSorted(a, lo, hi);
}

// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
	//if(hi<= lo) return; 
	  if (hi <= lo + CUTOFF) { 
          insertionSort(a, lo, hi);
          return;
      }
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
}

/**
 * Rearranges the array in ascending order, using the natural order.
 * @param a the array to be sorted
 */
public static void sort(Comparable[] a) {
    Comparable[] aux = a.clone(); 
    sort(a, aux, 0, a.length-1);
    assert isSorted(a);
}

// sort from a[lo] to a[hi] using insertion sort
private static void insertionSort(Comparable[] a, int lo, int hi) {
    for (int i = lo; i <= hi; i++)
        for (int j = i; j > lo && less(a[j], a[j-1]); j--)
            exch(a, j, j-1);
}

/***************************************************************************
*  Helper sorting functions.
***************************************************************************/

// is v < w ?
private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
}
    
// exchange a[i] and a[j]
private static void exch(Object[] a, int i, int j) {
    Object swap = a[i];
    a[i] = a[j];
    a[j] = swap;
}


/***************************************************************************
*  Check if array is sorted - useful for debugging.
***************************************************************************/
private static boolean isSorted(Comparable[] a) {
    return isSorted(a, 0, a.length - 1);
}

private static boolean isSorted(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
        if (less(a[i], a[i-1])) return false;
    return true;
}


}
