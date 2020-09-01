/**
 *  A vector that implements the functionality of an ArrayList in Java.
 *  @author   Jeremy Moyer CS174
 *  February 27 2020
 */

import java.util.Arrays;


public class IntArrayList extends IntList{

    int size = 0;     //tracks the number of values in arr
    
    int[] arr;     //holds all user-given given integers

    public static void main(String[] args) {

	IntArrayList i = new IntArrayList(4);    //Creates an instance of the class IntArrayList

	//Manually tests the implementation of the methods

	System.out.println("Original Array");
      	i.add(0);
	i.add(1);
	i.add(2);
	i.add(3);
	i.add(4);
	i.add(5);
	i.set(0,5);
	i.remove(2);	
	i.toString();

	IntArrayList c = new IntArrayList(i);

	System.out.println("");
	System.out.println("Copied Array");
	c.add(9);
	c.add(8);
	c.set(1,2);
	c.add(7);
	c.add(6);
	c.add(5);
	c.remove(0);
	c.toString();
	
    }
 
    // Increases the size of the internal array by multiplying its length by 2.   
    private void expandArray(){

	//creates a temporary array double the length of arr
	int[] tempArr = new int[arr.length * 2];

	for(int i =0;i<arr.length;i++){
            tempArr[i] = arr[i]; 
	}

	arr = tempArr;       	        
    }

    /**
    * Defines the initial size of the array.
    *
    * @param  initialSize  a user-given integer representing the starting size of the array.
    */
    public IntArrayList(int initialSize){

	arr = new int[initialSize];
	this.arr = arr;
	
    }

    IntArrayList(IntArrayList i){
	arr = i.arr;
    }

    /**
    * Adds a user-given value to the end of the array.
    *
    * @param val  a user-given integer to be added to the end of the array.
    */
    public void add(int val){

	int[] tempArr = new int[arr.length];

	if(size == arr.length){
	    expandArray();

	    arr[size] = val;
	   
	}
	else{
	    for(int i =0;i<arr.length;i++){
            tempArr[i] = arr[i];
	    }
	    tempArr[size] = val;
	    arr = tempArr;
	}
	
	size++;
    }
    
    //Removes the last element of the array.
    public void removeLast(){

	size--;

	int[] tempArr4 = new int[arr.length-1];

	for(int l =0;l<arr.length-1;l++){		
	    tempArr4[l] = arr[l];
	}

	arr = tempArr4;
    }

    /**
    * Returns the value at the given index.
    *
    * @param  index  the array index to be returned.
    */
    public int get(int index){

	int indexValue = arr[index];
	return indexValue;
    }

    /**
    * Sets the index at the variable index to be equal to the variable val.
    *
    * @param  index  the location in the array to be changed.
    * @param  val  the value that index is to be changed to.
    */
    public void set(int index, int val){

	arr[index] = val;
    }

    /**
    * Removes the element at the user-given index.
    *
    * @param  index  the location of the value to be removed.
    */
    public void remove(int index)throws ArrayIndexOutOfBoundsException{

	size--;

	arr[index] = -1;

	int[] tempArr2 = new int[arr.length];

	for(int i =0;i<arr.length;i++){

	    if(arr[i]!= -1){
		tempArr2[i] = arr[i];
	    }
	}
	        
	    for(int j = 1; j < arr.length-index;j++){
		tempArr2[index + j -1] = tempArr2[index+j];
	    }

	    int[] tempArr3 = new int[arr.length-1];

	    for(int k =0;k<arr.length-1;k++){		
		tempArr3[k] = tempArr2[k];
	    }
	    	    
	arr = tempArr3;	
    }

    //Returns the number of elements in the array.
    public int size(){
	
	return size;
    }

    //Overrides the toString() method and returns the array as a string.
    public String toString(){

	int[] tempArrPrint = new int[size];

	for(int p = 0; p<size; p++){
	    tempArrPrint[p] = arr[p];	    
	}
	
	arr = tempArrPrint;
	String toReturn = Arrays.toString(arr);

	System.out.print("[");
	for(int i = 0; i<size; i++){
	    if(arr[i] != size - 1){
	    System.out.print(arr[i] + "," + " ");
	    }	    
	}
	System.out.print("]");
	
	return toReturn;
    }
}
