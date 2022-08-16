package temp;
import java.util.ArrayList;
import java.util.Date;

import ClassFiles.*;
import FilesClass.DataFile;

// import java.util.ArrayList;
// import java.util.Arrays;

// import java.io.*;
public class TestJSON {
	public static void main(String args[]) {

		Customer cus1=new Customer("Nurad Hussen","mure","nurad");
		Food fo=new Food("Shiro",780,120);
		Admin admin=new Admin(34,"Murad","233");
		Order o=new Order(new ArrayList<Food>(),cus1);
		Order o2=new Order(new ArrayList<Food>(),cus1);
		Delivery del=new Delivery("Addmn",o);
		System.out.println(o.getId());
		System.out.println(o2.getId());

		
		DataFile c=DataFile.getInstance();
		// c.addToCollection(cus1);
		// c.addToCollection(fo);
		// c.addToCollection(admin);
		// c.addToCollection(o);
		// c.addToCollection(del);
		// System.out.println(c.orderList.get(0).getWhoOrdered().getFullName());

		// c.delete(cus1);
		// c.addToCollection(cus1);
		// c.addToCollection(cus1);
		// c.addToCollection(cus1);
		// c.addToCollection(cus2);
		// CollectCustomer c2=CollectCustomer.getInstance();
		// System.out.println(c.customerCollection.size());
		// Ad ad=new Ad(67,"huse","kool");
		
		// Admin cc= Admin.getInstance();
		// cc.addToCollection(ad);
		// System.out.println(cc.adminList.get(0).getId());
		// System.out.println(c.customerCollection.get(0).getPassword());
		// System.out.println(c2.customerCollection.get(1).getId());

		// ArrayList<Integer>test=new ArrayList<>();
		// test.add(12);
		// test.add(25);
		// test.add(100);
		// System.out.println(test);
		// test.remove(1);
		// System.out.println(test);
		





	      
	}

}
