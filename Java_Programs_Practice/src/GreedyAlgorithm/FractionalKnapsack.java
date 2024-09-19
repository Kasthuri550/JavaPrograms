package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Item
{
	int value,weight;

	Item(int value,int weight)
	{
		this.value=value;
		this.weight=weight;
	}
}
public class FractionalKnapsack {

	public static void main(String[] args) {

		int n = 3, w = 50;

		Item[] items = {
				new Item(60, 10),
				new Item(100, 20),
				new Item(120, 30)
		};

		System.out.println(fractionalKnapsack(items,n,w));

	}

	private static double fractionalKnapsack(Item[] items, int n, int w) {

		Arrays.sort(items,new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {

				double r1=(double)o1.value/o1.weight;
				double r2=(double)o2.value/o2.weight;

				if(r1<r2) return 1;
				if(r1>r2) return -1;
				return 0;
			}
		});
		
		double totalValue=0.0;
		
		for(int i=0;i<n;i++)
		{
			if(items[i].weight<=w)
			{
				totalValue+=items[i].value;
				w-=items[i].weight;
			}
			else
			{
				totalValue+=items[i].value*((double)w/items[i].weight);
			}
		}

		return totalValue;
	}
}
