public class LargestValue {
 //How To Find The Largest Value From The Given Array.
 public static void main(String[] args){
 
	 int[] arr={3,15,9,17,28,4,23,2};
	 
	 int val=arr[0];
	 
	 for(int i=0; i<arr.length; i++){
		 if(arr[i] > val){
		 val=arr[i];
		 }
	 }
	 System.out.println("Largest value in the Given Array is "+ val);
 }
}
