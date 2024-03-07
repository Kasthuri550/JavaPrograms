package Basicmaths;

public class PowerNumber {

	public static void main(String[] args) {
		
		int N = 12, R = 21;
		
		System.out.println(power(N,R));
	}

	private static long power(int N, int R) {
		
		int mod=(int) (1e9+7);
		long n=N,r=R,res=1L;
		
		if(R<0)
		{
			r=r*-1;
		}
		
		while(r>0)
		{
			if(r%2==1)
			{
				res=(res*n)%mod;
				r=r-1;
			}
			else
			{
				n=(n*n)%mod;
				r=r/2;
			}
		}
		
		if(R<0)
		{
			res=1L/res;
		}
		
		return res;
	}
}
