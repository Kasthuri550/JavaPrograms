import java.util.ArrayList;

public class ClosestPair {

	public static void main(String[] args) {
		
		int a[]= {1,4,5,7};
		int b[]= {10,20,30,40};
		int x=40;
		ArrayList<Integer> printClosest = printClosest(a,b,a.length,b.length,x);
		System.out.println(printClosest);
	}
	
	
public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        
        int sum,num;
        
        ArrayList<Integer> al=new ArrayList<Integer>();
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                sum=arr[i]+brr[j];
                
                if(sum<x)
                {
                    if(al.size()<1)
                    {
                       al.add(sum);
                    }
                    else if(al.get(0)<sum)
                    {
                       al.remove(0);
                       al.add(sum);
                    }
                }
                
            }
        }
        
        int val=x-(al.get(0));
        
        ArrayList<Integer> al2=new ArrayList<Integer>();
        al2.add(val);
        
        return al2;
    }

}
