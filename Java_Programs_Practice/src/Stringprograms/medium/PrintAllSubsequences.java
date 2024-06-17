package Stringprograms.medium;

import java.util.TreeSet;

public class PrintAllSubsequences {

	public static void main(String[] args) {
		
		String s="abc";
		
		System.out.println(allSubsequences(s));

	}

	private static TreeSet<String> allSubsequences(String s) {
		int n=s.length();
        TreeSet<String> treeSet=new TreeSet<>();
        
        int total=1<<n;
        
        for(int i=0;i<total;i++)
        {
            String subSeq="";
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                {
                    subSeq+=s.charAt(j);
                }
            }
            
            treeSet.add(subSeq);
        }
        
        return treeSet;
	}

}
