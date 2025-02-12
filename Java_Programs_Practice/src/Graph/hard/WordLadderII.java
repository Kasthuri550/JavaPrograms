package Graph.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Time Complexity: cannot be predicted for this particular algorithm
 * Space Complexity: cannot be predicted for this particular algorithm
 * */
class Comp implements Comparator<ArrayList<String>>
{
	public int compare(ArrayList<String> list1,ArrayList<String> list2)
	{
		String x="",y="";

		for(int i=0;i<list1.size();i++)
		{
			x+=list1.get(i);
		}

		for(int j=0;j<list2.size();j++)
		{
			y+=list2.get(j);
		}

		return x.compareTo(y);
	}
}

public class WordLadderII {

	public static void main(String[] args) 
	{
		String startWord = "der", targetWord = "dfs";
		String wordList[] = {"des","der","dfr","dgt","dfs"};

		ArrayList<ArrayList<String>> wordLadderII = wordLadderII(startWord,targetWord,wordList);

		if(wordLadderII.size()==0)
		{
			System.out.println(-1);
		}
		else
		{
			Collections.sort(wordLadderII,new Comp());

			for(int i=0;i<wordLadderII.size();i++)
			{
				for(int j=0;j<wordLadderII.get(i).size();j++)
				{
					System.out.println(wordLadderII.get(i).get(j)+"");
				}
				System.out.println();
			}
		}
	}

	private static ArrayList<ArrayList<String>> wordLadderII(String startWord, String targetWord, String[] wordList) {

		Set<String> set=new HashSet<>();

		for(String word:wordList)
		{
			set.add(word);
		}

		Queue<ArrayList<String>> queue=new LinkedList<>();

		ArrayList<String> list=new ArrayList<String>();
		list.add(startWord);

		queue.add(list);

		int level=0;

		ArrayList<ArrayList<String>> ans=new ArrayList<>();

		ArrayList<String> usedOnLevel=new ArrayList<>();
		usedOnLevel.add(startWord);

		while(!queue.isEmpty())
		{
			ArrayList<String> vec=queue.poll();

			if(vec.size()>level)
			{
				level++;

				for(String used:usedOnLevel)
				{
					set.remove(used);
				}
			}

			String word=vec.get(vec.size()-1);

			if(word.equals(targetWord))
			{
				if(ans.size()==0)
				{
					ans.add(vec);
				}
				else if(ans.get(0).size()==vec.size())
				{
					ans.add(vec);
				}

			}

			for(int i=0;i<word.length();i++)
			{
				for(char c='a';c<='z';c++)
				{
					char replaceCharArray[]=word.toCharArray();
					replaceCharArray[i]=c;

					String replacedWord=new String(replaceCharArray);

					if(set.contains(replacedWord))
					{
						vec.add(replacedWord);
						ArrayList<String> temp=new ArrayList<>(vec);
						queue.add(temp);

						usedOnLevel.add(replacedWord);
						vec.remove(vec.size()-1);						
					}

				}
			}
		}

		return ans;
	}
}
