import java.util.*;
import java.io.*;



/*
 *	Nearly sorted using insertion sort o(nk) complexity 
*/
class Solution {
	
	public static int[] nearlySorted(int[] array, int n, int k) {
		for (int i = 1; i < n; i++) {
			int key = array[i];

			int j = i-1;

			while(j>= 0 && j>= i-k && array[j] > key) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
			
			
		}
		return array;
	}
}