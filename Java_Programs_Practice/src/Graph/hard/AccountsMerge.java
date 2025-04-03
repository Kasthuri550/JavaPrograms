package Graph.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
 * Time Complexity:O(n*mlogm)
   Space Complexity: O(n*m)
 * */
public class AccountsMerge {

	static class DisjointSet
	{
		List<Integer> parent=new ArrayList<>();
		List<Integer> size=new ArrayList<>();

		DisjointSet(int n)
		{
			for(int i=0;i<n;i++)
			{
				parent.add(i);
				size.add(1);
			}
		}

		public int findParent(int node)
		{
			if(node==parent.get(node)) return node;

			int ulp=findParent(parent.get(node));
			parent.set(node,ulp);
			return parent.get(node);
		}

		public void unionBySize(int u,int v)
		{
			int ulp_u=findParent(u);
			int ulp_v=findParent(v);

			if(ulp_u==ulp_v) return;

			if(size.get(ulp_u)<size.get(ulp_v))
			{
				parent.set(ulp_u,ulp_v);
				size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
			}
			else
			{
				parent.set(ulp_v,ulp_u);
				size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
			}
		}
	}

	public static void main(String[] args) {

		List<List<String>> accounts = new ArrayList<>();
		accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
		accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
		accounts.add(Arrays.asList("Mary", "mary@mail.com"));
		accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

		List<List<String>> mergedAccounts=accountsMerge(accounts);
		print(mergedAccounts);
	}

	private static void print(List<List<String>> mergedAccounts) {

		for (List<String> account : mergedAccounts) {
			System.out.println(account);
		}
	}

	private static List<List<String>> accountsMerge(List<List<String>> accounts) 
	{
		int n=accounts.size();

		DisjointSet ds=new DisjointSet(n);

		Map<String,Integer> emailToUser=new HashMap<>();

		for(int i=0;i<n;i++)
		{
			for(int j=1;j<accounts.get(i).size();j++)
			{
				String email=accounts.get(i).get(j);

				if(!emailToUser.containsKey(email))
				{
					emailToUser.put(email,i);
				}
				else
				{
					ds.unionBySize(i,emailToUser.get(email));
				}
			}
		}

		Map<Integer,TreeSet<String>> mergedEmails=new HashMap<Integer, TreeSet<String>>();

		for(Map.Entry<String,Integer> entry:emailToUser.entrySet())
		{
			String email=entry.getKey();
			int leader=ds.findParent(entry.getValue());

			mergedEmails.computeIfAbsent(leader,k->new TreeSet<>()).add(email);
		}

		List<List<String>> result=new ArrayList<>();
		for(Map.Entry<Integer,TreeSet<String>> entry:mergedEmails.entrySet())
		{
			int userIndex=entry.getKey();
			List<String> mergedAccount=new ArrayList<>();
			mergedAccount.add(accounts.get(userIndex).get(0));
			mergedAccount.addAll(entry.getValue());
			result.add(mergedAccount);
		}

		return result;
	}
}
