package edu.princeton.cs.algs4;

import java.util.Arrays;

import java.util.Comparator;


public class MergeExperiment {
	 static double classicMergeAverage; 
	 static double aAverage;
	 static double bAverage;
	 static double cAverage;
	 static double abAverage;
	 static double acAverage;
	 static double bcAverage;
	 static double abcAverage;
	 
public static void main(String[] args) {
    	double time; 
    	int number_of_trails = 25; 
    	int number_of_elements=1000000; 
    	double[] classicMergeTime = new double[number_of_trails]; 
    	double[] aTime = new double[number_of_trails]; 
    	double[] bTime = new double[number_of_trails]; 
    	double[] cTime = new double[number_of_trails]; 
    	double[] abTime = new double[number_of_trails]; 
    	double[] bcTime = new double[number_of_trails]; 
    	double[] acTime = new double[number_of_trails]; 
    	double[] abcTime = new double[number_of_trails]; 
    	
    	Integer [] orignial  = new Integer[number_of_elements]; // original array
    	Integer[] copy1 = new Integer[number_of_elements];
    	Integer[] copy2 = new Integer[number_of_elements];
    	Integer[] copy3 = new Integer[number_of_elements];
    	Integer[] copy4 = new Integer[number_of_elements];
    	Integer[] copy5 = new Integer[number_of_elements];
    	Integer[] copy6 = new Integer[number_of_elements];
    	Integer[] copy7 = new Integer[number_of_elements];
    	Integer[] copy8 = new Integer[number_of_elements];
    	for(int i =0; i <number_of_elements; i++){
    		orignial[i] = i+1; 
    	}
    
    for(int k =0; k<number_of_trails; k++){
    	for(int i =0; i <number_of_elements; i++){
    		orignial[i] = i+1; 
    	}
    	StdRandom.shuffle(orignial); 
    	copy1 = copier(orignial);
    	copy2 = copier(orignial);
    	copy3 = copier(orignial);
    	copy4 = copier(orignial);
    	copy5 = copier(orignial);
    	copy6 = copier(orignial);
    	copy7 = copier(orignial);
    	copy8 = copier(orignial);
    	//time Classic Merge Sort 
    	Stopwatch timer1 = new Stopwatch(); 
    	ClassicalMerge.sort(copy1);
    	time = timer1.elapsedTime();
    	classicMergeTime[k] =time; 
    	//time MergeImprovementA 
    	Stopwatch timer2 = new Stopwatch(); 
    	MergeImprovementA.sort(copy2);
    	time = timer2.elapsedTime();
    	aTime[k] =time; 
    	//time MergeImprovementB 
    	Stopwatch timer3 = new Stopwatch(); 
    	MergeImprovementB.sort(copy3);
    	time = timer3.elapsedTime();
    	bTime[k] =time;
    	//time MergeImprovementC 
    	Stopwatch timer4 = new Stopwatch(); 
    	MergeImprovementC.sort(copy4);
    	time = timer4.elapsedTime();
    	cTime[k] =time;
    	//time MergeImprovementAC
    	Stopwatch timer5 = new Stopwatch(); 
    	MergeImprovementAC.sort(copy5);
    	time = timer5.elapsedTime();
    	acTime[k] =time;
    	//time MergeImprovementAB 
    	Stopwatch timer6 = new Stopwatch(); 
    	MergeImprovementAB.sort(copy6);
    	time = timer6.elapsedTime();
    	abTime[k] =time;
    	//time MergeImprovementBC
    	Stopwatch timer7 = new Stopwatch(); 
    	MergeImprovementBC.sort(copy7);
    	time = timer7.elapsedTime();
    	bcTime[k] =time;
    	//time MergeImprovementABC 
    	Stopwatch timer8 = new Stopwatch(); 
    	MergeImprovementABC.sort(copy8);
    	time = timer8.elapsedTime();
    	abcTime[k] =time;
		
    }

    // find the average times 
    aAverage = average(aTime, number_of_trails); 
    bAverage = average(bTime, number_of_trails);
    cAverage = average(cTime, number_of_trails);
    abAverage = average(abTime, number_of_trails);
    acAverage = average(acTime, number_of_trails);
    bcAverage = average(bcTime, number_of_trails);
    abcAverage = average(abcTime, number_of_trails);
    classicMergeAverage = average(classicMergeTime, number_of_trails); 
    System.out.println("_________________________________________________________________________________");
    System.out.println("Average Runtime of Randomly Shuffled for " + number_of_trails + " different arrays");
    System.out.println("_________________________________________________________________________________");
    // Report to user 
    System.out.println("Average Classic Merge Sort Runtime  " + classicMergeAverage );
    System.out.println("Average Improvement A Runtime  " + aAverage + " seconds" );
    System.out.println("Average Improvement B Runtime  " + bAverage + " seconds");
    System.out.println("Average Improvement C Runtime  " + cAverage + " seconds");
    System.out.println("Average Improvement AB Runtime  " + abAverage + " seconds");
    System.out.println("Average Improvement BC Runtime  " + bcAverage + " seconds" );
    System.out.println("Average Improvement AC Runtime  " + acAverage + " seconds" );
    System.out.println("Average Improvement ABC Runtime  " + abcAverage + " seconds");
    
    
for(int k =0; k<number_of_trails; k++){
	for(int i =0; i <number_of_elements; i++){
		orignial[i] = i+1; 
	}
    	shufflePartially(orignial); 
    	copy1 = copier(orignial);
    	copy2 = copier(orignial);
    	copy3 = copier(orignial);
    	copy4 = copier(orignial);
    	copy5 = copier(orignial);
    	copy6 = copier(orignial);
    	copy7 = copier(orignial);
    	copy8 = copier(orignial);
    	//time Classic Merge Sort 
    	Stopwatch timer1 = new Stopwatch(); 
    	ClassicalMerge.sort(copy1);
    	time = timer1.elapsedTime();
    	classicMergeTime[k] =time; 
    	//time MergeImprovementA 
    	Stopwatch timer2 = new Stopwatch(); 
    	MergeImprovementA.sort(copy2);
    	time = timer2.elapsedTime();
    	aTime[k] =time; 
    	//time MergeImprovementB 
    	Stopwatch timer3 = new Stopwatch(); 
    	MergeImprovementB.sort(copy3);
    	time = timer3.elapsedTime();
    	bTime[k] =time;
    	//time MergeImprovementC 
    	Stopwatch timer4 = new Stopwatch(); 
    	MergeImprovementC.sort(copy4);
    	time = timer4.elapsedTime();
    	cTime[k] =time;
    	//time MergeImprovementAC
    	Stopwatch timer5 = new Stopwatch(); 
    	MergeImprovementAC.sort(copy5);
    	time = timer5.elapsedTime();
    	acTime[k] =time;
    	//time MergeImprovementAB 
    	Stopwatch timer6 = new Stopwatch(); 
    	MergeImprovementAB.sort(copy6);
    	time = timer6.elapsedTime();
    	abTime[k] =time;
    	//time MergeImprovementBC
    	Stopwatch timer7 = new Stopwatch(); 
    	MergeImprovementBC.sort(copy7);
    	time = timer7.elapsedTime();
    	bcTime[k] =time;
    	//time MergeImprovementABC 
    	Stopwatch timer8 = new Stopwatch(); 
    	MergeImprovementABC.sort(copy8);
    	time = timer8.elapsedTime();
    	abcTime[k] =time;
		
    }
// find the average times 
aAverage = average(aTime, number_of_trails); 
bAverage = average(bTime, number_of_trails);
cAverage = average(cTime, number_of_trails);
abAverage = average(abTime, number_of_trails);
acAverage = average(acTime, number_of_trails);
bcAverage = average(bcTime, number_of_trails);
abcAverage = average(abcTime, number_of_trails);
classicMergeAverage = average(classicMergeTime, number_of_trails); 
System.out.println("_________________________________________________________________________________");
System.out.println("Average Runtime of Partially Shuffled for " + number_of_trails + " different arrays");
System.out.println("_________________________________________________________________________________");
// Report to user 
System.out.println("Average Classic Merge Sort Runtime  " + classicMergeAverage );
System.out.println("Average Improvement A Runtime  " + aAverage + " seconds");
System.out.println("Average Improvement B Runtime  " + bAverage + " seconds");
System.out.println("Average Improvement C Runtime  " + cAverage + " seconds");
System.out.println("Average Improvement AB Runtime  " + abAverage + " seconds");
System.out.println("Average Improvement BC Runtime  " + bcAverage + " seconds");
System.out.println("Average Improvement AC Runtime  " + acAverage + " seconds");
System.out.println("Average Improvement ABC Runtime  " + abcAverage + " seconds");


for(int k =0; k<number_of_trails; k++){
	int fakeMax = (int)(0.55*number_of_elements); 
	for(int i =0; i<number_of_elements; i++){
		if(i<= fakeMax){
			orignial[i] = i+1;
		}
		else 
			orignial[i] = i- fakeMax; 
			}
	StdRandom.shuffle(orignial);
	    copy1 = copier(orignial);
    	copy2 = copier(orignial);
    	copy3 = copier(orignial);
    	copy4 = copier(orignial);
    	copy5 = copier(orignial);
    	copy6 = copier(orignial);
    	copy7 = copier(orignial);
    	copy8 = copier(orignial);
    	//time Classic Merge Sort 
    	Stopwatch timer1 = new Stopwatch(); 
    	ClassicalMerge.sort(copy1);
    	time = timer1.elapsedTime();
    	classicMergeTime[k] =time; 
    	//time MergeImprovementA 
    	Stopwatch timer2 = new Stopwatch(); 
    	MergeImprovementA.sort(copy2);
    	time = timer2.elapsedTime();
    	aTime[k] =time; 
    	//time MergeImprovementB 
    	Stopwatch timer3 = new Stopwatch(); 
    	MergeImprovementB.sort(copy3);
    	time = timer3.elapsedTime();
    	bTime[k] =time;
    	//time MergeImprovementC 
    	Stopwatch timer4 = new Stopwatch(); 
    	MergeImprovementC.sort(copy4);
    	time = timer4.elapsedTime();
    	cTime[k] =time;
    	//time MergeImprovementAC
    	Stopwatch timer5 = new Stopwatch(); 
    	MergeImprovementAC.sort(copy5);
    	time = timer5.elapsedTime();
    	acTime[k] =time;
    	//time MergeImprovementAB 
    	Stopwatch timer6 = new Stopwatch(); 
    	MergeImprovementAB.sort(copy6);
    	time = timer6.elapsedTime();
    	abTime[k] =time;
    	//time MergeImprovementBC
    	Stopwatch timer7 = new Stopwatch(); 
    	MergeImprovementBC.sort(copy7);
    	time = timer7.elapsedTime();
    	bcTime[k] =time;
    	//time MergeImprovementABC 
    	Stopwatch timer8 = new Stopwatch(); 
    	MergeImprovementABC.sort(copy8);
    	time = timer8.elapsedTime();
    	abcTime[k] =time;
		
    }
// find the average times 
aAverage = average(aTime, number_of_trails); 
bAverage = average(bTime, number_of_trails);
cAverage = average(cTime, number_of_trails);
abAverage = average(abTime, number_of_trails);
acAverage = average(acTime, number_of_trails);
bcAverage = average(bcTime, number_of_trails);
abcAverage = average(abcTime, number_of_trails);
classicMergeAverage = average(classicMergeTime, number_of_trails); 
System.out.println("_________________________________________________________________________________");
System.out.println("Average Runtime of Repeated Elements for " + number_of_trails + " different arrays");
System.out.println("_________________________________________________________________________________");
// Report to user 
System.out.println("Average Classic Merge Sort Runtime  " + classicMergeAverage );
System.out.println("Average Improvement A Runtime  " + aAverage + " seconds");
System.out.println("Average Improvement B Runtime  " + bAverage + " seconds");
System.out.println("Average Improvement C Runtime  " + cAverage + " seconds");
System.out.println("Average Improvement AB Runtime  " + abAverage + " seconds");
System.out.println("Average Improvement BC Runtime  " + bcAverage + " seconds");
System.out.println("Average Improvement AC Runtime  " + acAverage + " seconds");
System.out.println("Average Improvement ABC Runtime  " + abcAverage + " seconds");

}













    
    public static double average(double[] input, int trails){
    	double total = 0;
		double average = 0;
		for (int j = 0; j < trails; j++) {
			total = total+ input[j];
		}
		average = total / trails;
    	
    	return  average; 
    }
    public static Integer[] copier( Integer[] orig ){
		Integer [] copy  = new Integer[orig.length];
		for(int i =0; i <orig.length; i++){
    		copy[i] = orig[i]; 
		}
		return copy; 
	}
    // Modified Version of Knuth Shuffle that creates partillay sorted arrays 
    public static void shufflePartially(Object[] a) {
        int N = a.length;
        int see = (int)((Math.random())*10);
    	double seed = (double)see/10; 
        for (int i = 0; i < N; i++) {
        	//System.out.println(seed);
            int r = i + (int) (seed* (N - i));
            Object swap = a[r];
            a[r] = a[i];
            a[i] = swap;
        }
    }
   
    }
    
    
    
    
    
    


