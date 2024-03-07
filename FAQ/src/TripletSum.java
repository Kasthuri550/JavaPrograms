
public class TripletSum {

	public static void main(String[] args) {

		int n = 6, X = 13;
		int	arr[] = {1, 4 ,45, 6, 10 ,8};
		boolean find3Numbers = find3Numbers(arr,n,X);
		System.out.println(find3Numbers);
	}
	
public static boolean find3Numbers(int A[], int n, int X) { 
        
        int sum;
        for(int i=0;i<n;i++)
        {
            int first=A[i];
            for(int j=i+1;j<n-1;j++)
            {
                sum=first+A[j]+A[j+1];
                
                if(sum==X)
                  return true;
                else
                  return false;
                
            }
        }
        
        return false;
        
    }

}
