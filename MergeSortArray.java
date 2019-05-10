import java.util.*;
import java.io.*;

class MergeSortArray{

	int[] tempArray; 

    public static int[] divide(int[] a){
    	int l = a.length;
		int mid = l/2;
		int remaining = l-mid;

		int[] leftArray = new int[mid];
		int[] rightArray = new int[remaining];

		for(int i=0;i<mid;i++){
      		leftArray[i] = a[i];
  		}

  		for (int j=0; j<remaining; j++) {
  			rightArray[j] = a[mid + j];
  		}
    	
    	if(leftArray.length != 1){
	    	divide(leftArray);    		
    	}

    	if(rightArray.length != 1){
	    	divide(rightArray);    		
    	}

    	return merge(leftArray,rightArray);
	}

	public static int[] merge(int[] leftArray, int[] rightArray){
		// int[] mergedArray = (int[])ArrayUtils.addAll(leftArray, rightArray);
		int size = leftArray.length + rightArray.length;
		int[] mergedArray = new int[size];
		
		int leftSize = leftArray.length;

		for (int i=0; i<leftArray.length; i++) {
			mergedArray[i] = leftArray[i];
		}

		for (int i=0; i<rightArray.length; i++) {
			mergedArray[leftSize + i] = rightArray[i];
		}

		mergedArray = sort(mergedArray);
	    return mergedArray;
	}

	public static int[] sort(int[] mergedArray){
	    int temp;

	    for (int i = 1; i < mergedArray.length; i++) {
	    	for (int j = i; j > 0; j--) {
	        	if (mergedArray[j] < mergedArray [j - 1]) {
		        	temp = mergedArray[j];
		        	mergedArray[j] = mergedArray[j - 1];
		        	mergedArray[j - 1] = temp;
	        	}
	      	}
	    }

	    displayOutput(mergedArray);

	    return mergedArray;
    }

    public static void displayOutput(int[] mergedArray){
    	System.out.println("DISPLAY: ");
    	for (int i = 0; i < mergedArray.length; i++) {
	        System.out.print(mergedArray[i] + " ");
	    }
	    System.out.println();
    }

    public static void displayOutput(int[] mergedArray, String text){
    	System.out.println(text);
    	for (int i = 0; i < mergedArray.length; i++) {
	        System.out.print(mergedArray[i] + " ");
	    }
	    System.out.println();
    }

	public static void main(String args[]){

		int[] inputArray = new int[]{1,6,4,5,7,2,9,3};
		int length = inputArray.length;   
		System.out.println("Your input Array is:" + length);
		
		int[] finalArray = divide(inputArray);
		displayOutput(finalArray);
	}
}

