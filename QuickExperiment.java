package edu.princeton.cs.algs4;

import java.util.Arrays;

public class QuickExperiment {
	public static void main(String[] args) {
		double quickAverage;
		double quickMedian3Average;
		double time;
		int number_of_trails = 25;
		int number_of_elements = 1000000;
		double[] quickTime = new double[number_of_trails];
		double[] quickMedian3Time = new double[number_of_trails];
		Integer[] orignial = new Integer[number_of_elements]; // original array
		Integer[] copy1 = new Integer[number_of_elements];
		for (int k = 0; k < number_of_trails; k++) {
			for (int i = 0; i < number_of_elements; i++) {
				orignial[i] = i + 1;
			}
			StdRandom.shuffle(orignial);
			copy1 = copier(orignial);
			Stopwatch timer1 = new Stopwatch();
			Quick.sort(orignial);
			time = timer1.elapsedTime();
			quickTime[k] = time;
			// time quicksort with median
			Stopwatch timer2 = new Stopwatch();
			QuickWithMedian3.sort(copy1);
			time = timer2.elapsedTime();
			quickMedian3Time[k] = time;

		}

		// find the average times
		quickAverage = average(quickTime, number_of_trails);
		quickMedian3Average = average(quickMedian3Time, number_of_trails);

		System.out.println("_________________________________________________________________________________");
		System.out.println("Average Runtime of Randomly Shuffled for " + number_of_trails + " different arrays");
		System.out.println("_________________________________________________________________________________");
		// Report to user
		System.out.println("Average Classic Quick Sort Runtime  " + quickAverage);
		System.out.println("Average Quick with Median-of-2 partioning Runtime  " + quickMedian3Average + " seconds");

		for (int k = 0; k < number_of_trails; k++) {
			for (int i = 0; i < number_of_elements; i++) {
				orignial[i] = i + 1;
			}
			shufflePartially(orignial);
			copy1 = copier(orignial);
			Stopwatch timer1 = new Stopwatch();
			Quick.sort(orignial);
			time = timer1.elapsedTime();
			quickTime[k] = time;
			// time quicksort with median
			Stopwatch timer2 = new Stopwatch();
			QuickWithMedian3.sort(copy1);
			time = timer2.elapsedTime();
			quickMedian3Time[k] = time;

		}

		// find the average times
		quickAverage = average(quickTime, number_of_trails);
		quickMedian3Average = average(quickMedian3Time, number_of_trails);

		System.out.println("_________________________________________________________________________________");
		System.out.println("Average Runtime of Partially Shuffled for " + number_of_trails + " different arrays");
		System.out.println("_________________________________________________________________________________");
		// Report to user
		System.out.println("Average Classic Quick Sort Runtime  " + quickAverage);
		System.out.println("Average Quick with Median-of-2 partioning Runtime  " + quickMedian3Average + " seconds");

		for (int k = 0; k < number_of_trails; k++) {
			int fakeMax = (int) (0.55 * number_of_elements);
			for (int i = 0; i < number_of_elements; i++) {
				if (i <= fakeMax) {
					orignial[i] = i + 1;
				} else
					orignial[i] = i - fakeMax;
			}
			StdRandom.shuffle(orignial);
			copy1 = copier(orignial);
			Stopwatch timer1 = new Stopwatch();
			Quick.sort(orignial);
			time = timer1.elapsedTime();
			quickTime[k] = time;
			// time quicksort with median
			Stopwatch timer2 = new Stopwatch();
			QuickWithMedian3.sort(copy1);
			time = timer2.elapsedTime();
			quickMedian3Time[k] = time;

		}

		// find the average times
		quickAverage = average(quickTime, number_of_trails);
		quickMedian3Average = average(quickMedian3Time, number_of_trails);

		System.out.println("_________________________________________________________________________________");
		System.out.println("Average Runtime of Repeated Elements for " + number_of_trails + " different arrays");
		System.out.println("_________________________________________________________________________________");
		// Report to user
		System.out.println("Average Classic Quick Sort Runtime  " + quickAverage);
		System.out.println("Average Quick with Median-of-2 partioning Runtime  " + quickMedian3Average + " seconds");

	}

	public static Integer[] copier(Integer[] orig) {
		Integer[] copy = new Integer[orig.length];
		for (int i = 0; i < orig.length; i++) {
			copy[i] = orig[i];
		}
		return copy;
	}

	public static double average(double[] input, int trails) {
		double total = 0;
		double average = 0;
		for (int j = 0; j < trails; j++) {
			total = total + input[j];
		}
		average = total / trails;

		return average;
	}

	// Modified Version of Knuth Shuffle that creates partillay sorted arrays
	public static void shufflePartially(Object[] a) {
		int N = a.length;
		int see = (int) ((Math.random()) * 10);
		double seed = (double) see / 10;
		for (int i = 0; i < N; i++) {
			// System.out.println(seed);
			int r = i + (int) (seed * (N - i));
			Object swap = a[r];
			a[r] = a[i];
			a[i] = swap;
		}
	}

}
