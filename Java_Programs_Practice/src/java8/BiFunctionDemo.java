package java8;

import java.util.ArrayList;
import java.util.function.BiFunction;

class Customer
{
  private Integer custId;
  private String custName;
  
	public Customer() {
		super();
	}

	public Customer(Integer custId, String custName) {
		super();
		this.custId = custId;
		this.custName = custName;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + "]";
	}		
}

public class BiFunctionDemo {

	public static void main(String[] args) {
		
		ArrayList<Customer> al=new ArrayList<Customer>();
		BiFunction<Integer,String,Customer> b=(i,s)-> new Customer(i,s);
		al.add(b.apply(1001,"Anil"));
		al.add(b.apply(1002,"Sidhu"));
		al.add(b.apply(1003,"Sam"));
		
		al.stream().forEach((c)-> System.out.println(c));

	}

}
