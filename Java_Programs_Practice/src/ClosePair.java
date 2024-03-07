import java.util.ArrayList;

public class ClosePair {

	public static void main(String[] args) {
		
		int a[]= {1,4,5,7,8};
		int b[]= {10,20,30,40};
		int x=80;
		ArrayList<Integer> printClosest = printClosest(a,b,a.length,b.length,x);
		System.out.println(printClosest);

	}
	
public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        
        int sum;
        
        ArrayList<Integer> al=new ArrayList<Integer>();
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                sum=arr[i]+brr[j];
                
                if(sum<x)
                {
                    if(al.size()<2)
                    {
                       al.add(arr[i]);
                       al.add(brr[j]);
                    }
                    else if((al.get(0)+al.get(1))<sum)
                    {
                       al.remove(1);
                       al.remove(0);
                       al.add(arr[i]);
                       al.add(brr[j]);
                    }
                }
                
            }
        }
        
        return al;
    }

}
