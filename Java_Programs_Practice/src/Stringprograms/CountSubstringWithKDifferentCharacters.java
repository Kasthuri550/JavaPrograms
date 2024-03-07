package Stringprograms;

public class CountSubstringWithKDifferentCharacters {

	public static void main(String[] args) {
		
		String str="aacfssa";
		int k=3;
		
		System.out.println(countSubstring(str,k));
	}

	private static int countSubstring(String str, int k) {
		
		int n=str.length();

        int res=0;

        for(int i=0;i<n;i++){

            int dis_count=0;

            int[] cnt=new int[26];

            for(int j=i;j<n;j++){

                if(cnt[str.charAt(j)-'a']==0){

                    dis_count++;

                    cnt[str.charAt(j)-'a']++;

                }

                if(dis_count==k){
                	System.out.println(str.substring(i,j));
                    res++;
                }

                if(dis_count>k){
                    break;
                }
            }
        } 
        return res;
	}
}
