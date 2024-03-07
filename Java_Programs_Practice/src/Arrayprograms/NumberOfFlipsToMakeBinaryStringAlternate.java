package Arrayprograms;

public class NumberOfFlipsToMakeBinaryStringAlternate {

	public static void main(String[] args) {

		String s = "101101"; // Replace this with the input binary string
		int minFlipsNeeded = minFlips1(s);
		System.out.println("Minimum number of flips needed: " + minFlipsNeeded);
		System.out.println(minFlips2(s));
	}

	private static int minFlips2(String s) {
		
		int n=s.length();
		int flip1=0,flip2=0;
		
		for(int i=0;i<n;i++)
		{
			char expectedZero=(i%2==0)?'0':'1';
			char expectedOne=(i%2==0)?'1':'0';
			
			if(expectedZero!=s.charAt(i))
			{
				flip1++;
			}
			if(expectedOne!=s.charAt(i))
			{
				flip2++;
			}
		}
		return Math.min(flip1, flip2);
	}

	public static int minFlips1(String s) {
		int n = s.length();
		s = s + s;

		StringBuilder alt1 = new StringBuilder();
		StringBuilder alt2 = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			alt1.append((i % 2 == 0) ? '0' : '1');
			alt2.append((i % 2 == 0) ? '1' : '0');
		}

		int res = n;
		int diff1 = 0, diff2 = 0;
		int l = 0;

		for (int r = 0; r < n * 2; r++) {
			if (s.charAt(r) != alt1.charAt(r)) {
				diff1++;
			}
			if (s.charAt(r) != alt2.charAt(r)) {
				diff2++;
			}
			if ((r - l + 1) > n) {
				if (s.charAt(l) != alt1.charAt(l)) {
					diff1--;
				}
				if (s.charAt(l) != alt2.charAt(l)) {
					diff2--;
				}
				l++;
			}
			if ((r - l + 1) == n) {
				res = Math.min(res, Math.min(diff1, diff2));
			}
		}
		return res;
	}
}
