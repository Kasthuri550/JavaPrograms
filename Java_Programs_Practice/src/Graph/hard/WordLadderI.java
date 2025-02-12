package Graph.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Time Complexity: O(N*M*26)
 * Space Complexity: O(N)
 */
public class WordLadderI {

	static class Pair
	{
		String word;
		int steps;

		Pair(String word,int steps)
		{
			this.word=word;
			this.steps=steps;
		}
	}

	public static void main(String[] args) {

		String wordList[] = {"des","der","dfr","dgt","dfs"};
		String startWord = "der", targetWord= "dfs";

		System.out.println(wordLadderI(startWord,targetWord,wordList));
	}

	private static int wordLadderI(String startWord, String targetWord, String[] wordList) {

		Queue<Pair> queue=new LinkedList<>();
		queue.add(new Pair(startWord,1));

		Set<String> set=new HashSet<String>();

		for(String word:wordList)
		{
			set.add(word);
		}
		set.add(startWord);

		while(!queue.isEmpty())
		{
			Pair pair=queue.poll();
			String word=pair.word;
			int steps=pair.steps;

			if(word.equals(targetWord))
				return steps;

			for(int i=0;i<word.length();i++)
			{
				for(char ch='a';ch<='z';ch++)
				{
					char[] charArray = word.toCharArray();
					charArray[i]=ch;

					String replacedWord=new String(charArray);

					if(set.contains(replacedWord))
					{
						set.remove(replacedWord);
						queue.add(new Pair(replacedWord,steps+1));
					}
				}
			}

		}

		return 0;		
	}
}
