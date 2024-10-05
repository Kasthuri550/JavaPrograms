package Recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public static void main(String[] args) {
		
		String S = "123";
		int target = 6;
		
		System.out.println(expressionAddOperators(S,target));

	}

	private static List<String> expressionAddOperators(String s, int target) {

		List<String> result=new ArrayList<>();
		
		if(s==null || s.length()==0) return result;
		
		backTrack(s,target,result,"",0,0,0);
		
		return result;
	}

	private static void backTrack(String s, int target, List<String> result, String path, int index, long eval, long prev) {

		if(index==s.length())
		{
			if(eval==target)
			{
				result.add(path);
			}
			return;
		}
		
		for(int i=index;i<s.length();i++)
		{
			if(index!=i && s.charAt(index)=='0') break;
			String currStr=s.substring(index,i+1);
			long curr=Long.parseLong(currStr);
			
			if(index==0)
			{
				backTrack(s, target, result, path+currStr, i+1,curr,curr);
			}
			else
			{
				backTrack(s, target, result, path+"+"+currStr, i+1,eval+curr, curr);
				backTrack(s,target,result,path+"-"+currStr,i+1,eval-curr,-curr);
				backTrack(s, target, result, path+"*"+currStr, i+1, eval-prev+prev*curr,prev*curr);
			}
		}
		
	}
}
