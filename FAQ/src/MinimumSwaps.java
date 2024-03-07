
public class MinimumSwaps {

	public static void main(String[] args) {
		
		int arr[ ] = {10,12,20,20,5,19,19,12,1,20,1};
		int K = 1,n=11;
		int minSwap = minSwap (arr,n,K);
		System.out.println(minSwap);
	}
	
	public static int minSwap (int arr[], int n, int k) {
        
        
	       int good=0;
	       int bad=0;
	       for(int i=0;i<n;i++){
	           if(arr[i]<=k) 
	        	   good++;
	       }
	       for(int j=0;j<good;j++){
	           if(arr[j]>k) 
	        	   bad++;
	       }
	       int start=0;
	       int end=good;
	       int ans=bad;
	       while(end<n){
	           if(arr[start]>k) 
	        	   bad--; 
	           if(arr[end]>k) 
	        	   bad++;
	           
	           ans=Math.min(ans,bad); 
	           start++;
	           end++;
	       }
	      return ans;
	        
	    }

}
