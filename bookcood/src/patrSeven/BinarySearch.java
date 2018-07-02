package patrSeven;

public class BinarySearch {
	/** Use binary to find the key in the list */
	public static int Binary(int[] list, int key){
		int low = 0;
		int high = list.length - 1 ;
		
		while (high >= low){
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key == list[mid])
				return mid;
			else
				low = mid + 1;		
		}
		return -low - 1;// Now high < low , key not found
	}

}
