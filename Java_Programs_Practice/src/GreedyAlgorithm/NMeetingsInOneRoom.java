package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsInOneRoom {
	
	static class Meeting
	{
		int start,end;
		
		Meeting(int start,int end)
		{
			this.start=start;
			this.end=end;
		}
	}

	public static void main(String[] args) {
		
		int n = 6, start[] = {1, 3, 0, 5, 8, 5}, end[] =  {2, 4, 6, 7, 9, 9};
		
		System.out.println(nMeetingsInOneRoom(n,start,end));

	}

	private static int nMeetingsInOneRoom(int n, int[] start, int[] end) {
		
		List<Meeting> meetings=new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			meetings.add(new Meeting(start[i],end[i]));
		}
		
		Collections.sort(meetings,(m1,m2)->m1.end-m2.end);
		
		int count=1;
		int lastEndTime=meetings.get(0).end;
		
		for(int i=1;i<n;i++)
		{
			if(meetings.get(i).start>lastEndTime)
			{
				count++;
				lastEndTime=meetings.get(i).end;
			}
		}
		
		return count;
		
	}

}
