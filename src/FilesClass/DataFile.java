package FilesClass;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import ClassFiles.*;

public final class DataFile implements Serializable {
    static final long serialVersionUID = 1L;
      public ArrayList<Customer>customerCollection=new ArrayList<Customer>();
      public ArrayList<Order>orderList=new ArrayList<Order>();
      public ArrayList<Admin>adminList=new ArrayList<Admin>();
      public ArrayList<Food>foodList=new ArrayList<Food>();
      public ArrayList<Delivery>deliverierList=new ArrayList<Delivery>();
    //making the class singleton class :instanciate only once
    private static DataFile instance;
    public static DataFile getInstance() {
        if(instance==null){
        instance=new DataFile();
        return instance;
        }
        return instance;
    }
    //the constructor for the class Collection of Customer class
    DataFile(){
        readFromFile();
        try{
            Customer.count=customerCollection.size()!=0?customerCollection.get(customerCollection.size()-1).getId():0;
            Delivery.count=deliverierList.size()!=0?deliverierList.get(deliverierList.size()-1).getId():0;
            Order.count=orderList.size()!=0?orderList.get(orderList.size()-1).getId():0;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    //differnt methods to manupulate the class
    public void addToCollection(Customer customer){
        if(search(customer.getUsername())==null){
            customerCollection.add(customer);
            writeToFile();
        }
    }
    public void addToCollection(Order order){
        orderList.add(order);
        writeToFile();
    }
    public void addToCollection(Admin admin){
        if(search(admin.getId())==-1){
            adminList.add(admin);
            writeToFile();
        }
    }
    public void addToCollection(Food food){
        if(search(food)==-1){
            foodList.add(food);
            writeToFile();
        }
    }
    public void addToCollection(Delivery del){
        if(search(del)==-1){
            deliverierList.add(del);
            writeToFile();
        }
    }
    //sequential search through the collection of customers by id 
    //Search for Customer 
    public int search(Customer customer){
        int len=customerCollection.size();
        for(int i=0;i<len;i++){
            if(customerCollection.get(i).getUsername().equals(customer.getUsername())){
                return i;
            }
        }
        return -1;

    }
    public int search(Order order){
        int len=orderList.size();
        for(int i=0;i<len;i++){
            if(orderList.get(i).getId()==order.getId()){
                return i;
            }
        }
        return -1;
    }
    public Customer search(String  username){
        int len=customerCollection.size();
        for(int i=0;i<len;i++){
            if(customerCollection.get(i).getUsername().equals(username)){
                return customerCollection.get(i);
            }
        }
        Customer customer=null;
        return customer;
    }
    //Search for Adminmin
    public int search(Admin admin){
        int len=adminList.size();
        for(int i=0;i<len;i++){
            if(adminList.get(i).getId()==admin.getId()){
                return i;
            }
        }
        return -1;
    }
    public int search(int id){
        int len=adminList.size();
        for(int i=0;i<len;i++){
            if(adminList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public int search(Food food){
        int len=foodList.size();
        for(int i=0;i<len;i++){
            if(foodList.get(i).getName().equals(food.getName())){
                return i;

            }
        }
        return -1;

    }
    //Search for the Deliverier 
    public int search(Delivery del){
        int len=deliverierList.size();
        for(int i=0;i<len;i++){
            if(deliverierList.get(i).getId()==del.getId()){
                return i;
            }
        }
        return -1;
    }
    //Delete customer 
    void delete(Customer customer){
        int index=search( customer);
        if(index!=-1){
            customerCollection.remove(index);
            writeToFile();
        }

    }
    void delete(Admin admin){
        int index=search(admin);
        if(index!=-1){
            adminList.remove(index);
            writeToFile();
        }
        
    }
    void delete(Delivery del){
        int index=search(del);
        if(index!=-1){
            deliverierList.remove(index);
            writeToFile();
        }
    }
    void delete(Food food){
        int index=search(food);
        if(index!=-1){
            foodList.remove(index);
            writeToFile();
        }
    }
    void delete(Order order){
        int index=search(order);
        if(index!=-1){

        }
    }

    //file related methods are below
    public  void writeToFile(){
        try{
                FileOutputStream myObjOutCustomer= new FileOutputStream("src/FilesClass/data.txt");
                ObjectOutputStream obOutCustomer = new ObjectOutputStream(myObjOutCustomer);
                obOutCustomer.writeObject(this);
                obOutCustomer.close();
                myObjOutCustomer.close();	
        }
        catch(FileNotFoundException e){
            //Todo
        }
        catch(IOException e){
            //Todo
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            
        }
    };
    public  void readFromFile(){
        try{
        FileInputStream myObjInCustomer = new FileInputStream("src/FilesClass/data.txt");
        ObjectInputStream obInCustomer=new ObjectInputStream(myObjInCustomer);
        Object obj=null;
        while((obj=obInCustomer.readObject())!=null){
            if(obj instanceof DataFile){
                int len=((DataFile)obj).customerCollection.size();
                int len2=((DataFile)obj).adminList.size();
                int len3=((DataFile)obj).foodList.size();
                int len4=((DataFile)obj).orderList.size();
                int len5=((DataFile)obj).deliverierList.size();
                for(int i=0;i<len;i++){
                    customerCollection.add(((DataFile)obj).customerCollection.get(i));
                }
                for(int i=0;i<len2;i++){
                    adminList.add(((DataFile)obj).adminList.get(i));
                }
                for(int i=0;i<len3;i++){
                    foodList.add(((DataFile)obj).foodList.get(i));
                }
                for(int i=0;i<len4;i++){
                    orderList.add(((DataFile)obj).orderList.get(i));
                }
                for(int i=0;i<len5;i++){
                    deliverierList.add(((DataFile)obj).deliverierList.get(i));
                }
            }
        }
        obInCustomer.close();}
        catch(FileNotFoundException e){
            e.printStackTrace();
            //Todo thiss....
        }catch(IOException e){
            //Todo this
    
        }catch(ClassNotFoundException e){
    
        }catch(Exception e){
            e.printStackTrace();
        }
        //Todo finish me...
    }  
    

}
